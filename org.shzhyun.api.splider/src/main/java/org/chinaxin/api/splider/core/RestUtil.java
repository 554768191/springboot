package org.chinaxin.api.splider.core;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by Administrator on 2017/10/30 0030.
 */
public class RestUtil {
    @Autowired
    private RestOperations restOperations;

    RestTemplate restTemplate = new RestTemplate();
    /**     *
     * 保存微博
     * @param saveArticleUrl 上传微博url
     * @param uriVariables api入参
     * @return 微博url
     */
    public String saveAticle(String saveArticleUrl,Map uriVariables){
        String url = saveArticleUrl;
        url = url + "?access_token={access_token}&title={title}&type={type}";
        url = url + "&description={description}&content={content}&categories={categories}";
        url = url + "&tags={tags}&ip={ip}&id={id}";
        //返回文章链接
        return restTemplate.getForObject(url, String.class, uriVariables);
    }

    /**
     * 用户认证
    //     直接传输用户名、密码来获取Access Token。
    //     client_id：在开发者中心注册应用时获得的API Key。
    //     client_secret：在开发者中心注册应用时获得的API Secret。
    //     grant_type：此值为“password”。
    //     username：授权用户的用户名。
    //     password：授权用户的密码。
    //     {
    //     "access_token": "0dd49b2a5afa45bba6765ba4fdd1b3c9",
    //     "expires_in": 86400,
    //     "username": "zhuyi"
//     }
     access_token:2b3d6860861d41a599828c8e4a5cee9e
     */
    public String authorize(Map uriVariables){
        String url = "http://api.csdn.net/oauth2/access_token?client_id={YOUR_API_KEY}&client_secret={YOUR_API_SECRET}&grant_type=password&username={USER_NAME}&password={PASSWORD}";
        String res = restTemplate.getForObject(url,String.class,uriVariables);
//        JSONObject jsonobject = JSON.parse(res);
        return restTemplate.getForObject(url,String.class,uriVariables);
    }
}
