package com.lexiangmiao.sample.servicemember;

import com.lexiangmiao.sample.servicemember.service.UserService;
import com.lexiangmiao.sample.servicemember.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 参考： https://github.com/spring-cloud-samples/feign-eureka
     * 参考：https://spring.io/guides/gs/service-registration-and-discovery/
     * @param id
     * @return
     */
    @RequestMapping("/getById/{id}")
    public UserVo getUserById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);

//        String url = "http://localhost:8010/order/findOrderByUserId/" + id;
        String url = "http://service-order/order/findOrderByUserId/" + id;

        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);
        List<Order> orderList = responseEntity.getBody();
        UserVo userVo = new UserVo();
        userVo.setOrderList(orderList);
        userVo.setUserName(user.getUserName());
        return userVo;
    }
}
