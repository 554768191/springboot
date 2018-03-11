package org.myqcode.spring.restController;

import org.myqcode.spring.core.restUtil;
import org.myqcode.spring.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/5/13 0013.
 */
@org.springframework.web.bind.annotation.RestController
public class CsdnController {
    @Autowired
    private BlogService blogService;

    @Value("savearticleurl")
    String savearticleurl;

    @RequestMapping(value = "/csdnControl/pushBlog",method = RequestMethod.POST)
    public String pushBlog(){
        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("YOUR_API_KEY", "1100567");
        uriVariables.put("YOUR_API_SECRET", "1c5e7b5dc2a7439dabdb5aefcd24a5ca");
        uriVariables.put("USER_NAME", "gedonshen@163.com");
        uriVariables.put("PASSWORD", "yang729");

        restUtil ru = new restUtil();
        String access_token = ru.authorize(uriVariables);
        Map<String, Object> uriVariablesAticale = new HashMap<String, Object>();
        uriVariablesAticale.put("access_token", access_token);
        uriVariablesAticale.put("title", "demo");
//        文章类型（original|report|translated）
        uriVariablesAticale.put("type", "original");
        uriVariablesAticale.put("description", "demo");
        uriVariablesAticale.put("content", "demo");
        uriVariablesAticale.put("categories", "");
        uriVariablesAticale.put("tags", "java");
        uriVariablesAticale.put("ip", "");
        uriVariablesAticale.put("id", "");
        String articaleUrl = ru.saveAticle(savearticleurl,uriVariablesAticale);
        return articaleUrl;
    }

}
