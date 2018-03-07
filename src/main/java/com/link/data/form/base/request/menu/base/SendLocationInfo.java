package com.link.data.form.base.request.menu.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by DWeixin
 *
 * @author xh.d
 * @since 2018/3/7 17:07
 */
@XStreamAlias("SendLocationInfo")
public class SendLocationInfo {
    @XStreamAlias("Label")
    private String label;
    @XStreamAlias("Location_X")
    private Double locationX;
    @XStreamAlias("Location_Y")
    private Double locationY;
    @XStreamAlias("Scale")
    private Integer scale;
    @XStreamAlias("Poiname")
    private String poiname;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getPoiname() {
        return poiname;
    }

    public void setPoiname(String poiname) {
        this.poiname = poiname;
    }
}
