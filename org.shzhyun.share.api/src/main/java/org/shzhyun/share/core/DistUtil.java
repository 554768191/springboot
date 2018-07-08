package org.shzhyun.share.core;

public class DistUtil {

    private static double EARTH_RADIUS = 6378.137;

    private static double rad(double dis) {
        return dis * Math.PI / 180.0;
    }
    public DistUtil(){

    }

    public static DistUtil getInstance(){
        return new DistUtil();
    }
    /**
     *通过经纬度获取距离(单位：km)
     * @param loFr  起点lo
     * @param laFr  起点la
     * @param loTo  终点lo
     * @param laTo  终点la
     * @return  dis 距离km
     */
    public double calculateDistanceByCoordinate(double laFr, double loFr, double laTo, double loTo){
        double radLat1 = rad(laFr);
        double radLat2 = rad(laTo);
        double a = radLat1 - radLat2;
        double b = rad(loFr) - rad(loTo);
        double dis = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        dis = dis * EARTH_RADIUS;
        dis = Math.round(dis * 10000d) / 10000d;
        return dis;
    }
}
