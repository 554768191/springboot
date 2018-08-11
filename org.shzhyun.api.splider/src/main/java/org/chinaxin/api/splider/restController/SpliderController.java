package org.chinaxin.api.splider.restController;

import org.apache.commons.io.FileUtils;
import org.chinaxin.api.splider.core.ConstInf;
import org.chinaxin.api.splider.core.NewSplider;
import org.chinaxin.api.splider.core.m3u8.M3U8Util;
import org.chinaxin.api.splider.model.News;
import org.chinaxin.api.splider.service.NewsService;
import org.chinaxin.api.splider.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * Created by Administrator on 2017/5/13 0013.
 */
@EnableScheduling
@org.springframework.web.bind.annotation.RestController
public class SpliderController extends ConstInf {
    @Autowired
    private VideoService videoService;

    @Autowired
    private NewsService newsService;

//    @Autowired
//    private News news;

    @Value("${url}")
    String url;

    @Value("${filepath}")
    String filepath;

    @Value("${indexhtml}")
    String indexhtml;

    @Value("${urlSinar}")
    String urlSinar;

    @Value("${tmphtml}")
    String tmphtml;

    @Value("${rollhtml}")
    String rollhtml;

    @Value("${urlBaidu}")
    String urlBaidu;

    @Value("${urlToutiao}")
    String urlToutiao;


    private static Logger logger = LoggerFactory.getLogger(SpliderController.class);

    /**
     *
     * @return
     */
    @RequestMapping(value = "/spliderControl/getfiles",method = RequestMethod.GET)
    public String getFiles(){
        ConstInf.filepath = filepath;

        M3U8Util m3U8Util = new M3U8Util();
        m3U8Util.parseFile(url);
        return "success";
    }

    /**
     *
     * @return
     */
    //每1 min执行一次
//    @Scheduled(cron = "*/1 * * * * *")
    //每天2点执行一次
    @Scheduled(cron = "0 0 2 * * ? ")
    @RequestMapping(value = "/spliderControl/spliderNews",method = RequestMethod.GET)
    public String spliderNews(){
//        String urlSinar = "https://tech.sina.com.cn/it/";
//        String urlBaidu = "http://news.baidu.com";
//        String urlToutiao = "http://news.ifeng.com/";

//        newsService.deleteAllNews();
        logger.info("clear news table ...");
        NewSplider newSplider = new NewSplider();
        logger.info("start splider sina news ...");
        HashMap<String,String> res1 = new HashMap<String,String>();
        HashMap<String,String> res2 = new HashMap<String,String>();
        HashMap<String,String> res3 = new HashMap<String,String>();
        logger.info("splider url:" + urlSinar);
        logger.info("splider url:" + urlBaidu);
        logger.info("splider url:" + urlToutiao);
        res1 =  newSplider.queryNewsByA(urlSinar);
        res2 =  newSplider.queryNewsByA(urlBaidu);
        res3 =  newSplider.queryToutiaoByA(urlToutiao);
        this.modHtml(res1,res2,res3);
//        Iterator iter = null;
//        res =  newSplider.queryNewsByA(urlSinar);
//        iter = res.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            String s = entry.getKey().toString();
//            String u = entry.getValue().toString();
//            News news = new News();
//            news.setTitle(s);
//            news.setUrl(u);
//            news.setType(0);
//            newsService.saveNews(news);
//        }
//        logger.info("end splider sina news ...");
//        logger.info("splider sina news:" + res.size() + "nums");
//
//        logger.info("start splider baidu news ...");
//        res =  newSplider.queryNewsByA(urlBaidu);
//        iter = res.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            String s = entry.getKey().toString();
//            String u = entry.getValue().toString();
//            News news = new News();
//            news.setTitle(s);
//            news.setUrl(u);
//            news.setType(1);
//            newsService.saveNews(news);
//        }
//        logger.info("end splider baidu news ...");
//        logger.info("splider baidu news:" + res.size() + "nums");
//
//
//        logger.info("start splider toutiao news ...");
//        res =  newSplider.queryToutiaoByA(urlToutiao);
//        iter = res.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            String s = entry.getKey().toString();
//            String u = entry.getValue().toString();
//            News news = new News();
//            news.setTitle(s);
//            news.setUrl(u);
//            news.setType(2);
//            newsService.saveNews(news);
//        }
        logger.info("end splider toutiao news ...");
//        logger.info("splider toutiao news:" + res.size() + "nums");

        return "success";
    }

    private void modHtml(HashMap<String, String> res1 ,HashMap<String, String> res2 ,HashMap<String, String> res3 ) {
        String htmlTemp = "";
//        File templateFile = new File("/chinaxin/szyCode/html/index.html.tmp");
        File templateFile = new File(tmphtml);
        File indexFile = new File(indexhtml);
        File rollFile = new File(rollhtml);

        //读取文件
        String content = null;
        try {
            content = FileUtils.readFileToString(templateFile, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator iter = null;
        iter = res1.entrySet().iterator();
        // replace context
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String s = entry.getKey().toString();
            String u = entry.getValue().toString();
            htmlTemp = htmlTemp + "<li>\n" +
                    "\t\t\t\t\t\t\t<a href="+u+" target=\"_blank\">\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"com-left\">"+s+"</span>\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"com-right\">"+new Date()+"</span>\n" +
                    "\t\t\t\t\t\t\t</a>\n" +
                    "\n" +
                    "\t\t\t\t\t\t</li>";
        }

        content = content.replaceAll("replaceTagsinaContext",htmlTemp);
        iter = res2.entrySet().iterator();
        // replace context
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String s = entry.getKey().toString();
            String u = entry.getValue().toString();
            htmlTemp = htmlTemp + "<li>\n" +
                    "\t\t\t\t\t\t\t<a href="+u+" target=\"_blank\">\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"com-left\">"+s+"</span>\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"com-right\">"+new Date()+"</span>\n" +
                    "\t\t\t\t\t\t\t</a>\n" +
                    "\n" +
                    "\t\t\t\t\t\t</li>";
        }
        content = content.replaceAll("replaceTagbaiduContext",htmlTemp);

        iter = res3.entrySet().iterator();
        // replace context
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String s = entry.getKey().toString();
            String u = entry.getValue().toString();
            htmlTemp = htmlTemp + "<li>\n" +
                    "\t\t\t\t\t\t\t<a href="+u+" target=\"_blank\">\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"com-left\">"+s+"</span>\n" +
                    "\t\t\t\t\t\t\t\t<span class=\"com-right\">"+new Date()+"</span>\n" +
                    "\t\t\t\t\t\t\t</a>\n" +
                    "\n" +
                    "\t\t\t\t\t\t</li>";
        }
        content = content.replaceAll("replaceTagtoutiaoContext",htmlTemp);
        try {
            FileUtils.moveFile(indexFile ,rollFile);
            FileUtils.write(indexFile, content,"UTF-8",true);
        } catch (IOException e) {
            try {
                FileUtils.forceDeleteOnExit(indexFile);
                FileUtils.moveFile(rollFile , indexFile);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/spliderControl/queryAllNews",method = RequestMethod.GET)
    public List<News> queryAllNews(){
        return newsService.queryAllNews();
    }
}
