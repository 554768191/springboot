package org.chinaxin.api.splider.core;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/16 0016.
 */
public class ModulerWrapper {
    private Configuration cfg;            //模版配置对象
    Log log = LogFactory.getFactory().getInstance(ModulerWrapper.class);
    public String saveHtml(Map map,String htmlSavePath) throws Exception {
        //创建一个合适的Configration对象
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new File(htmlSavePath));
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
        //获取或创建一个模版。
        Template template = configuration.getTemplate("context.ftl");
        String htmlPath = htmlSavePath+"blog"+map.get("username").toString()+TimeUtil.getCurrentTime().replaceAll(":","").replaceAll("-","").replaceAll(" ","")+".html";
        Writer writer  = new OutputStreamWriter(new FileOutputStream(htmlPath),"UTF-8");
        map.put("htmlpath","htmlPath");
        log.info("html目录："+htmlSavePath);
        template.process(map, writer);

        log.info("博客发表成功！");
        return htmlPath;

    }

}
