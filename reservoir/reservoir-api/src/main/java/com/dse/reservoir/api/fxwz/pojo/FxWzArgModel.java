package com.dse.reservoir.api.fxwz.pojo;

import java.beans.Transient;

/**
 * Created by Administrator on 2017/8/7.
 */
public class FxWzArgModel implements java.io.Serializable {

    /***
     * 所属仓库
     */
    private String wh_cd;
    /***
     * 物资编码
     */
    private String ma_cd;
    /***
     * 物资批次
     */
    private String ma_pc;
    /***
     * 货柜
     */
    private String binnum;

    private String wr_ma_inventory_id;

    //wzkzglList
    private String search_page;

    private String ma_cds;
    private String ma_nms;
    private String gs_std_quans;

    /**
     * 所属管理部
     */
    private String org_cd;

    private String ma_nm;

    private String ma_status;

    private String wh_cd_name;

    private String type;

    private String wa_status;

    private String wa_tp;

    private String stm;

    private String etm;

    private String is_flood;

    private String pa_status;

    private String desc;


    public String getBinnum() {
        return binnum;
    }

    public void setBinnum(String binnum) {
        this.binnum = binnum;
    }

    public String getMa_cd() {
        return ma_cd;
    }

    public void setMa_cd(String ma_cd) {
        this.ma_cd = ma_cd;
    }

    public String getMa_pc() {
        return ma_pc;
    }

    public void setMa_pc(String ma_pc) {
        this.ma_pc = ma_pc;
    }

    public String getWh_cd() {
        return wh_cd;
    }

    public void setWh_cd(String wh_cd) {
        this.wh_cd = wh_cd;
    }

    public String getSearch_page() {
        return search_page;
    }

    public void setSearch_page(String search_page) {
        this.search_page = search_page;
    }

    public String getWr_ma_inventory_id() {
        return wr_ma_inventory_id;
    }

    public void setWr_ma_inventory_id(String wr_ma_inventory_id) {
        this.wr_ma_inventory_id = wr_ma_inventory_id;
    }

    public String getMa_cds() {
        return ma_cds;
    }

    public void setMa_cds(String ma_cds) {
        this.ma_cds = ma_cds;
    }

    public String getMa_nms() {
        return ma_nms;
    }

    public void setMa_nms(String ma_nms) {
        this.ma_nms = ma_nms;
    }

    public String getMa_nm() {
        return ma_nm;
    }

    public void setMa_nm(String ma_nm) {
        this.ma_nm = ma_nm;
    }

    public String getMa_status() {
        return ma_status;
    }

    public void setMa_status(String ma_status) {
        this.ma_status = ma_status;
    }

    public String getOrg_cd() {
        return org_cd;
    }

    public void setOrg_cd(String org_cd) {
        this.org_cd = org_cd;
    }


    public String getWh_cd_name() {
        return wh_cd_name;
    }

    public void setWh_cd_name(String wh_cd_name) {
        this.wh_cd_name = wh_cd_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGs_std_quans() {
        return gs_std_quans;
    }

    public void setGs_std_quans(String gs_std_quans) {
        this.gs_std_quans = gs_std_quans;
    }

    public String getWa_status() {
        return wa_status;
    }

    public void setWa_status(String wa_status) {
        this.wa_status = wa_status;
    }

    public String getWa_tp() {
        return wa_tp;
    }

    public void setWa_tp(String wa_tp) {
        this.wa_tp = wa_tp;
    }

    public String getEtm() {
        return etm;
    }

    public void setEtm(String etm) {
        this.etm = etm;
    }

    public String getStm() {
        return stm;
    }

    public void setStm(String stm) {
        this.stm = stm;
    }

    public String getIs_flood() {
        return is_flood;
    }

    public void setIs_flood(String is_flood) {
        this.is_flood = is_flood;
    }

    public String getPa_status() {
        return pa_status;
    }

    public void setPa_status(String pa_status) {
        this.pa_status = pa_status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
