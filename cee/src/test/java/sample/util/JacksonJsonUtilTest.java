package sample.util;

import com.lexiangmiao.sample.svc.dto.ProvincialScoreDTO;
import com.lexiangmiao.sample.util.JacksonJsonUtil;
import org.junit.Test;

/**
 * Created by mzxiao on 2020/7/29 11:33
 */
public class JacksonJsonUtilTest {
    @Test
    public void parseObject() throws Exception {
        String json = "{\"school_id\":\"402\",\"province_id\":\"43\",\"type\":\"2\",\"batch\":\"7\",\"zslx\":\"561\",\"xclevel\":\"0\",\"max\":\"--\",\"min_section\":\"10002\",\"min\":\"568.00\",\"average\":\"--\",\"filing\":\"568\",\"type_control\":\"2\",\"batch_control\":\"7\",\"local_batch_name\":\"本科一批\",\"zslx_name\":\"地方专项计划\",\"xclevel_name\":\"-\",\"proscore\":\"553\",\"year\":\"2019\"}";
        ProvincialScoreDTO dto = JacksonJsonUtil.parseObject(json, ProvincialScoreDTO.class);
        System.out.println(JacksonJsonUtil.toJsonString(dto));
    }

}