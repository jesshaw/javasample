package com.lexiangmiao.sample.springcloud.alibaba.gateway.filter;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RefreshScope
//@ConditionalOnProperty(value = "spring.cloud.gateway.discovery.locator.routeToLocalService")
public class SpecifyProducerNetworkSegment extends AbstractLoadBalancerRule {
    @Value("${lexiangmiao.client.producer-ns}")
    private String producerNetworkSegment;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    protected boolean isSpecify(Server server) {
        if (producerNetworkSegment.isEmpty()) {
            return true;
        }
        for (String specifyHost : producerNetworkSegment.split("\\,")) {
            if (IpAddressMatcher.isValidInetAddress(specifyHost) && specifyHost.equals(server.getHost())) {
                return true;
            }

            IpAddressMatcher matcher = new IpAddressMatcher(specifyHost);
            if (matcher.matches(server.getHost())) {
                return true;
            }
        }
        return false;
    }


    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                int index = this.chooseRandomInt(serverCount);
                server = upList.get(index);
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        log.info(server.getHost());
                        if (isSpecify(server)) {
                            return server;
                        } else {
                            Thread.yield();
                        }
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }


    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }
}