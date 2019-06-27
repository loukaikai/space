package com.huzhi.webgis.webgiddto.domain;

import java.io.Serializable;
import java.util.Date;

public class TdglJhbz implements Serializable {
    private Long oid;

    private Date jhkssj;

    private Date jhjgsj;

    private String tdgljyx;

    private String zygzxm;

    private String xmlx;

    private String sfyyjh;

    private String sqdw;

    private String dwyxsm;

    private String zrdw;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Date getJhkssj() {
        return jhkssj;
    }

    public void setJhkssj(Date jhkssj) {
        this.jhkssj = jhkssj;
    }

    public Date getJhjgsj() {
        return jhjgsj;
    }

    public void setJhjgsj(Date jhjgsj) {
        this.jhjgsj = jhjgsj;
    }

    public String getTdgljyx() {
        return tdgljyx;
    }

    public void setTdgljyx(String tdgljyx) {
        this.tdgljyx = tdgljyx == null ? null : tdgljyx.trim();
    }

    public String getZygzxm() {
        return zygzxm;
    }

    public void setZygzxm(String zygzxm) {
        this.zygzxm = zygzxm == null ? null : zygzxm.trim();
    }

    public String getXmlx() {
        return xmlx;
    }

    public void setXmlx(String xmlx) {
        this.xmlx = xmlx == null ? null : xmlx.trim();
    }

    public String getSfyyjh() {
        return sfyyjh;
    }

    public void setSfyyjh(String sfyyjh) {
        this.sfyyjh = sfyyjh == null ? null : sfyyjh.trim();
    }

    public String getSqdw() {
        return sqdw;
    }

    public void setSqdw(String sqdw) {
        this.sqdw = sqdw == null ? null : sqdw.trim();
    }

    public String getDwyxsm() {
        return dwyxsm;
    }

    public void setDwyxsm(String dwyxsm) {
        this.dwyxsm = dwyxsm == null ? null : dwyxsm.trim();
    }

    public String getZrdw() {
        return zrdw;
    }

    public void setZrdw(String zrdw) {
        this.zrdw = zrdw == null ? null : zrdw.trim();
    }
}