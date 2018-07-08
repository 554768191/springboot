package org.shzhyun.share.service;


import org.shzhyun.share.model.MapLocation;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
//@Mapper
//@Component
public interface MapLocationService {
    Long saveMapLocation(MapLocation mapLocation);
    List<MapLocation> queryAllMapLocation();
}
