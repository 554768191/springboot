package org.chinaxin.api.splider.core;

import org.chinaxin.api.splider.model.News;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class NewSplider {
    Logger logger = LoggerFactory.getLogger(NewSplider.class);
    public static void main(String[] args){
//        querySinaIT();
    }

    public HashMap<String , String> queryNewsIT(String url){
        HashMap<String , String> hashMap = new HashMap<String , String>();
        try {
            Parser parser = new Parser(url);
            parser.setEncoding("utf8");
            NodeList nodeList = parser
                    .extractAllNodesThatMatch(new NodeFilter()
                    {
                        // 实现该方法,用以过滤标签
                        public boolean accept(Node node)
                        {
                            if (node instanceof LinkTag
                                    && ((LinkTag) node).getLinkText().length()>15
                                    && !((LinkTag) node).getLinkText().contains(">")
                                    && !((LinkTag) node).getLinkText().contains("<img")){
                                // 标记
                                return true;
                            }else{
                                return false;
                            }
                        }

                    });
            for (int i = 0; i < nodeList.size(); i++)
            {
                LinkTag n = (LinkTag) nodeList.elementAt(i);
                hashMap.put(n.getStringText(),n.extractLink());

//                System.out.print(n.getStringText() + " ==>> ");
//                System.out.println(n.extractLink());
            }

        } catch (ParserException e) {
            e.printStackTrace();
        }finally {
            return hashMap;
        }
    }
    public HashMap<String , String> queryNewsByA(String url){
        HashMap<String , String> hashMap = new HashMap<String , String>();
        try {
            Document doc = Jsoup.connect(url) .timeout(60000).get();
            Elements list = doc.getElementsByTag("a");
            for(Element l : list){
                String t = l.text();
                String h = l.attr("href");
//                System.out.println(t);
//                System.out.println(h);
                if(t.length()>10 && !t.contains("备案") && !t.contains("ICP备")
                        && !t.contains("ICP")
                        && !t.contains("ICP备")
                        && !t.contains("京公网")
                        && !t.contains("跟帖评论")){
                    logger.info(t + ":" + h);
                    hashMap.put(t,h);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public HashMap<String,String> queryToutiaoByA(String url) {
        HashMap<String , String> hashMap = new HashMap<String , String>();
        try {
            Document doc = Jsoup.connect(url) .timeout(60000).get();
            Elements list = doc.getElementsByTag("a");
            for(Element l : list){
                String t = l.text();
                String h = l.attr("href");
//                System.out.println(t);
//                System.out.println(h);
                if(t.length()>10 && !t.contains("备案") && !t.contains("ICP备")
                        && !t.contains("ICP")
                        && !t.contains("ICP备")
                        && !t.contains("京公网")
                        && !t.contains("跟帖评论")){
                    logger.info(t + ":" + h);
                    hashMap.put(t,h);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
