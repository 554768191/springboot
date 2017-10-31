package org.myqcode.spring.restController;

import org.myqcode.spring.model.Blog;
import org.myqcode.spring.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by Administrator on 2017/5/13 0013.
 */
@org.springframework.web.bind.annotation.RestController
public class CsdnController {
    @Value("${savearticle}")
    private String savearticleurl;
    @Autowired
    private BlogService blogService;
    @RequestMapping(value = "/csdnControl/getAllBlog",method = RequestMethod.POST)
    public List<Blog> getAllBlog(){
        return blogService.queryAllBlog();
    }

}
