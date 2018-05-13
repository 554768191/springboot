package org.chinaxin.api.splider.restController;

import org.chinaxin.api.splider.core.ConstInf;
import org.chinaxin.api.splider.core.m3u8.M3U8Util;
import org.chinaxin.api.splider.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Administrator on 2017/5/13 0013.
 */
@org.springframework.web.bind.annotation.RestController
public class SpliderController extends ConstInf {
    @Autowired
    private VideoService videoService;

    @Value("url")
    String url;

    @Value("filepath")
    String filepath;

    @RequestMapping(value = "/spliderControl/getfiles",method = RequestMethod.GET)
    public String getFiles(){
        ConstInf.filepath = filepath;

        M3U8Util m3U8Util = new M3U8Util();
        m3U8Util.parseFile(url);
        return "success";
    }

}
