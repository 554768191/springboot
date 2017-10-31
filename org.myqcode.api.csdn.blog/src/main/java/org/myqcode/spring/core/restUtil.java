package org.myqcode.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestOperations;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/30 0030.
 */
public class restUtil {
    @Autowired
    private RestOperations restOperations;

    /**
     * 保存微博
     * @param savearticleurl
     */
    public void saveAticle(String savearticleurl){
        String url = "http://localhost:8080/test/sendSms?phone={phone}&msg={phone}";

        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("phone", "");
        uriVariables.put("msg", "");
        String asckey = authorize();
        uriVariables.put("asc", asckey);

        String result = restOperations.getForObject(url, String.class, uriVariables);
    }

    /**
     * 用户认证
     * client_id：在开发者中心注册应用时获得的API Key。
     redirect_uri：登录成功后浏览器回跳的URL。
     response_type：服务端流程，此值固定为“code”。
     */
    public String authorize(){
        String url = "http://api.csdn.net/oauth2/authorize?client_id=1100566&redirect_uri=YOUR_CALLBACK_URL&response_type=code";
        Map<String, Object> uriVariables = new HashMap<String, Object>();
        return restOperations.getForObject(url,String.class,uriVariables);
    }
}
