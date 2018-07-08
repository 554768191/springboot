package org.shzhyun.share.restController;

import freemarker.template.utility.DateUtil;
import org.apache.ibatis.executor.ExecutorException;
import org.shzhyun.share.core.ConstInf;
import org.shzhyun.share.core.DistUtil;
import org.shzhyun.share.core.RedisUtil;
import org.shzhyun.share.core.TimeUtil;
import org.shzhyun.share.model.MapLocation;
import org.shzhyun.share.service.MapLocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by Administrator on 2017/5/13 0013.
 */
@org.springframework.web.bind.annotation.RestController
public class mapController extends ConstInf {
    @Autowired
    private MapLocationService mapLocationService;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/mapControl/getLoc",method = RequestMethod.GET)
    public List<Object> getLoc(@RequestParam("curLatitude") double curLatitude,
                         @RequestParam("curLongitude") double curLongitude,@RequestParam("range") int range){
        //默认显示附近5Km内的可带宝贝
        if(0 == range)
            range = 5;
        logger.info("curLatitude:"+curLatitude);
        logger.info("curLongitude:"+curLongitude);
        logger.info("range:"+range);
        Set<String> keys = redisTemplate.keys("mapLocation@*");
        Set<String> keyWithin5km = new HashSet<String>();
        List<Object> res = new ArrayList<Object>();
        HashMap<String,Object> objresF = new HashMap<>();
        HashMap<String,Object> objresT = new HashMap<>();

        //过滤出5km内的key
        for(String key : keys){
            try{
                double lafr = Double.parseDouble(key.split("@")[1]);//from 经度
                double lofr = Double.parseDouble(key.split("@")[2]);//from 维度

                double dis = DistUtil.getInstance().calculateDistanceByCoordinate(curLatitude,curLongitude,lafr,lofr);
//                dis = 0;  fort est
                if(dis<=50)
                    keyWithin5km.add(key);
            }catch (NumberFormatException e){
                continue;
            }
        }
        //查询5km内的宝贝
        String latitudeFromVaule = "";
        String longitudeFromVaule = "";
        for(String k : keyWithin5km){
            Object obj = redisTemplate.opsForValue().get(k);
            String bindId = UUID.randomUUID().toString();
            objresF = (HashMap<String,Object>)((HashMap<String, Object>) obj).clone();
            objresT = (HashMap<String,Object>)((HashMap<String, Object>) obj).clone();
            //起点
            latitudeFromVaule = objresF.get("latitudeFrom").toString();
            longitudeFromVaule = objresF.get("longitudeFrom").toString();
            objresF.remove("latitudeFrom");
            objresF.remove("longitudeFrom");
            objresF.put("latitude",latitudeFromVaule);
            objresF.put("longitude",longitudeFromVaule);
            objresF.put("iconPath","/images/markerF.png");
            objresF.put("bindId",bindId);
            objresF.put("pointType","start");
            res.add(objresF);
            //终点
            latitudeFromVaule = objresT.get("latitudeTo").toString();
            longitudeFromVaule = objresT.get("longitudeTo").toString();
            objresT.remove("latitudeTo");
            objresT.remove("longitudeTo");
            objresT.put("latitude",latitudeFromVaule);
            objresT.put("longitude",longitudeFromVaule);
            objresT.put("iconPath","/images/markerT.png");
            objresT.put("bindId",bindId);
            objresT.put("pointType","end");
            res.add(objresT);
        }
        logger.info("附近5km内宝贝数量:"+res.size());
        return res;
    }

    @RequestMapping(value = "/mapControl/addLoc", method = RequestMethod.POST)
    public String addLoc(@RequestBody HashMap<String,Object> obj){
        long StringStamp = TimeUtil.getCurrentTimeMillis();
        obj.put("id",UUID.randomUUID());
        obj.put("createtime",StringStamp);
        obj.put("updatetime",TimeUtil.getCurrentTime());
//        存在redis中的key命名：
//        mapLocation@经度From@维度From@经度To@维度To@物品类别编号@当前时间戳
        String key = "mapLocation@"+obj.get("latitudeFrom").toString()+"@"+obj.get("longitudeFrom").toString()+"@"
                +obj.get("latitudeTo").toString()+"@"+obj.get("longitudeTo").toString()
                +StringStamp;
        redisTemplate.opsForValue().set(key,obj);
        logger.info("add obj success");
        logger.info(obj.get("id")+":"+obj.get("createtime")+":"+obj.get("latitudeFrom")+":"+obj.get("longitudeFrom")+":"+obj.get("title"));
        return "success";
    }

    @RequestMapping(value = "/mapControl/addLocTest",method = RequestMethod.POST)
    public String addLoctest(){
        HashMap<String,Object> obj = new HashMap<>();
        obj.put("userId","zhangsan");
        obj.put("title","物品标题");
        obj.put("goodsId","goodsId001");
        obj.put("latitudeFrom","31.38475");
        obj.put("longitudeFrom","120.98181");
        obj.put("latitudeTo","2211.222");
        obj.put("longitudeTo","2211.222");
        obj.put("iconPath","/images/marker.png");
        obj.put("width","20px");
        obj.put("height","20px");
        long StringStamp = TimeUtil.getCurrentTimeMillis();
        obj.put("id",UUID.randomUUID());
        obj.put("createtime",StringStamp);
        obj.put("updatetime",TimeUtil.getCurrentTime());
//        存在redis中的key命名：
//        mapLocation@经度From@维度From@经度To@维度To@物品类别编号@当前时间戳
        String key = "mapLocation@"+obj.get("latitudeFrom").toString()+"@"+obj.get("longitudeFrom").toString()
                +"@"+obj.get("latitudeTo").toString()+"@"+obj.get("longitudeTo").toString()
                +StringStamp;
        redisTemplate.opsForValue().set(key,obj);

        return "success";
    }

}
