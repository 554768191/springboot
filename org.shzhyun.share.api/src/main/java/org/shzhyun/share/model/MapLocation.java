package org.shzhyun.share.model;

import javax.swing.plaf.PanelUI;
import java.io.Serializable;

/**
 *地图主标信息
 */
public class MapLocation  implements Serializable {

    private static final long serialVersionUID = -3946734305303957850L;

    public String id;//主键
    public String title;//标题

    public String userId;//发布人ID

    public String goodsId;//货物ID
    public String latitudeFrom;//起点经度
    public String longitudeFrom;//起点维度
    public String latitudeTo;//终点经度
    public String longitudeTo;//终点维度

    public String iconPath;//图标
    public String width;//坐标图标width
    public String height;//坐标图标height


    public String createtime;//创建时间
    public String updatetime;//修改时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getLatitudeFrom() {
        return latitudeFrom;
    }

    public void setLatitudeFrom(String latitudeFrom) {
        this.latitudeFrom = latitudeFrom;
    }

    public String getLongitudeFrom() {
        return longitudeFrom;
    }

    public void setLongitudeFrom(String longitudeFrom) {
        this.longitudeFrom = longitudeFrom;
    }

    public String getLatitudeTo() {
        return latitudeTo;
    }

    public void setLatitudeTo(String latitudeTo) {
        this.latitudeTo = latitudeTo;
    }

    public String getLongitudeTo() {
        return longitudeTo;
    }

    public void setLongitudeTo(String longitudeTo) {
        this.longitudeTo = longitudeTo;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
