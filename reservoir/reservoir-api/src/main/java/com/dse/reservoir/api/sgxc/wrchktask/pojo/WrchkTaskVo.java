package com.dse.reservoir.api.sgxc.wrchktask.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @Description:实体 巡查任务
 * @Copyright:
 * @Company:
 * @author
 * @version 1.0 2017-08-08
 */

public class WrchkTaskVo implements java.io.Serializable {

    public WrchkTaskVo() {
        super();
    }

    private static final long serialVersionUID = 1L;

    /***
     *按年
     */
    public static final String CYCLE_001="CYCLE_001";
    /***
     *按半年
     */
    public static final String CYCLE_002="CYCLE_002";
    /***
     *按季
     */
    public static final String CYCLE_003="CYCLE_003";
    /***
     *按月
     */
    public static final String CYCLE_004="CYCLE_004";
    /***
     *按周
     */
    public static final String CYCLE_005="CYCLE_005";
    /***
     *按天
     */
    public static final String CYCLE_006="CYCLE_006";

   private String ck_tk_id;
    private String ck_tk_desc;
    private String ck_obj_id;
    private String create_user;
    private Date create_date;
    private Date ck_begin;
    private Date  ck_end;
    private String  ck_org;
    private String ck_type;
    private String  ck_users;
    private String ck_cycle;
    private Integer ck_frequency;
    private Integer  ck_int_hours;
    private Date  last_create_date;

    public Date getCk_begin() {
        return ck_begin;
    }

    public void setCk_begin(Date ck_begin) {
        this.ck_begin = ck_begin;
    }

    public String getCk_cycle() {
        return ck_cycle;
    }

    public void setCk_cycle(String ck_cycle) {
        this.ck_cycle = ck_cycle;
    }

    public Date getCk_end() {
        return ck_end;
    }

    public void setCk_end(Date ck_end) {
        this.ck_end = ck_end;
    }

    public Integer getCk_frequency() {
        return ck_frequency;
    }

    public void setCk_frequency(Integer ck_frequency) {
        this.ck_frequency = ck_frequency;
    }

    public Integer getCk_int_hours() {
        return ck_int_hours;
    }

    public void setCk_int_hours(Integer ck_int_hours) {
        this.ck_int_hours = ck_int_hours;
    }

    public String getCk_obj_id() {
        return ck_obj_id;
    }

    public void setCk_obj_id(String ck_obj_id) {
        this.ck_obj_id = ck_obj_id;
    }

    public String getCk_org() {
        return ck_org;
    }

    public void setCk_org(String ck_org) {
        this.ck_org = ck_org;
    }

    public String getCk_tk_desc() {
        return ck_tk_desc;
    }

    public void setCk_tk_desc(String ck_tk_desc) {
        this.ck_tk_desc = ck_tk_desc;
    }

    public String getCk_tk_id() {
        return ck_tk_id;
    }

    public void setCk_tk_id(String ck_tk_id) {
        this.ck_tk_id = ck_tk_id;
    }

    public String getCk_type() {
        return ck_type;
    }

    public void setCk_type(String ck_type) {
        this.ck_type = ck_type;
    }

    public String getCk_users() {
        return ck_users;
    }

    public void setCk_users(String ck_users) {
        this.ck_users = ck_users;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public Date getLast_create_date() {
        return last_create_date;
    }

    public void setLast_create_date(Date last_create_date) {
        this.last_create_date = last_create_date;
    }
}
