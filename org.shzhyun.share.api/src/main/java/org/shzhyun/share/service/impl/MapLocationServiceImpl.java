package org.shzhyun.share.service.impl;

import org.shzhyun.share.dao.MapLocationDao;
import org.shzhyun.share.model.MapLocation;
import org.shzhyun.share.service.MapLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/25 0025.
 */
@Service
public class MapLocationServiceImpl implements MapLocationService {

    @Autowired
    private MapLocationDao mapLocationDao;
    @Override
    public Long saveMapLocation(MapLocation mapLocation) {
        return mapLocationDao.saveMapLocation(mapLocation);
    }
    @Override
    public List<MapLocation> queryAllMapLocation() {
        return mapLocationDao.queryAllMapLocation();
    }
}
