package org.shzhyun.share.dao;

import org.apache.ibatis.annotations.Mapper;
import org.shzhyun.share.model.MapLocation;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Mapper
@Component
public interface MapLocationDao {
    Long saveMapLocation(MapLocation mapLocation);

    List<MapLocation> queryAllMapLocation();
}
