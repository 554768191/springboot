package org.myqcode.spring.restController;

import org.myqcode.spring.core.ModulerWrapper;
import org.myqcode.spring.core.TimeUtil;
import org.myqcode.spring.model.Blog;
import org.myqcode.spring.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/5/13 0013.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Value("${htmlSavePath}")
    private String htmlSavePath;
    @Autowired
    private BlogService blogService;
    @RequestMapping(value = "/blogControl/getAllBlog",method = RequestMethod.GET)
    public List<Blog> getAllBlog(){
        return blogService.queryAllBlog();
    }
    @RequestMapping(value = "/blogControl/addBlog", method = RequestMethod.POST)
    public String addBlog(@RequestBody Blog blog) {
        String timeTmp = TimeUtil.getCurrentTime();
        blog.setAddtime(timeTmp);
        Map map = new HashMap();
        map.put("title", blog.getTitle());//博客标题
        map.put("content", blog.getContent());//博客正文
        map.put("username", blog.getUsername());//发布用户
        String contentTemp = blog.getContent().concat("...");
        int contentLength = contentTemp.length();
        String summary = contentLength>300?(contentTemp.substring(0,300)):contentTemp;
        blog.setContent(summary);//摘要
        ModulerWrapper modulerUtil = new ModulerWrapper();
        try {
            String htmlpath = modulerUtil.saveHtml(map,htmlSavePath);
            blog.setHtmlpath(htmlpath);
            blogService.saveBlog(blog);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }

}
