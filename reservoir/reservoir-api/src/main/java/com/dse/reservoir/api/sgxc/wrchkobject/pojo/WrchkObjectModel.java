package com.dse.reservoir.api.sgxc.wrchkobject.pojo;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @Description:实体
 * @Copyright:
 * @Company:
 * @author
 * @version 1.0 2017-08-08
 */
@Entity
@Table(name = "WR_CHK_OBJECT")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrchkObjectModel implements java.io.Serializable {

    public WrchkObjectModel() {
        super();
    }

    private static final long serialVersionUID = 1L;
    /**
     *编码
     */
    private String ck_obj_id ;
    /**
     *名称描述
     */
    private String ck_name;
    /**
     *管理部门(深圳部,雁田部,桥头部,塘厦部)
     */
    private String ck_org;
    private String ck_org_name;
    /**
     *所属对象（ 水库,泵站,渡槽明槽,倒虹吸,隧洞,箱涵埋管,明渠,分水工程）
     */
    private String ck_object;
    private String ck_object_name;
    /**
     *父级对象
     */
    private String ck_obj_pid;
    private String ck_obj_pid_name;
    /**
     *巡查类型 (日常巡视,日常检查,定期巡检,特别巡检)
     */
    private String ck_type;
    private String ck_type_name;
    /**
     *管理要求
     */
    private String ck_mg_pro;
    /**
     *经度
     */
    private Double lgtd;
    /**
     *纬度
     */
    private Double lttd;
    /**
     *提醒半径（100：100米,200：200米）
     */
    private Double ck_wir_radius;
    /**
     *有效半径范围(100：100米,200：200米)
     */
    private Double ck_radius;
    /**
     *巡检时间要求
     */
    private String ck_tm_req;
    /**
     *排序
     */
    private Integer  seq;
    /**
     *所在地点
     */
    private String loc;
    /**
     *创建时间
     */
    private Date ts;
    /**
     *备注
     */
    private String nt;
    /**
     *巡查对象分类(0:巡查对象,1:巡查点)
     */
    private String ck_item;
    /**
     *巡检终端
     */
    private String term_cd;

    private String rootNode;


    @Column(name = "CK_ITEM")
    public String getCk_item() {
        return ck_item;
    }

    public void setCk_item(String ck_item) {
        this.ck_item = ck_item;
    }
    @Column(name = "CK_MG_PRO")
    public String getCk_mg_pro() {
        return ck_mg_pro;
    }

    public void setCk_mg_pro(String ck_mg_pro) {
        this.ck_mg_pro = ck_mg_pro;
    }
    @Column(name = "CK_NAME")
    public String getCk_name() {
        return ck_name;
    }

    public void setCk_name(String ck_name) {
        this.ck_name = ck_name;
    }

    @Id
    @Column(name = "CK_OBJ_ID", nullable = false, precision = 32, scale = 0   )
    @NotNull(message="编码不能为空")
    public String getCk_obj_id() {
        return ck_obj_id;
    }

    public void setCk_obj_id(String ck_obj_id) {
        this.ck_obj_id = ck_obj_id;
    }
    @Column(name = "CK_OBJ_PID")
    public String getCk_obj_pid() {
        return ck_obj_pid;
    }

    public void setCk_obj_pid(String ck_obj_pid) {
        this.ck_obj_pid = ck_obj_pid;
    }
    @Column(name = "CK_OBJECT")
    public String getCk_object() {
        return ck_object;
    }

    public void setCk_object(String ck_object) {
        this.ck_object = ck_object;
    }
    @Column(name = "CK_ORG")
    public String getCk_org() {
        return ck_org;
    }

    public void setCk_org(String ck_org) {
        this.ck_org = ck_org;
    }
    @Column(name = "CK_RADIUS")
    public Double getCk_radius() {
        return ck_radius;
    }

    public void setCk_radius(Double ck_radius) {
        this.ck_radius = ck_radius;
    }
    @Column(name = "CK_TM_REQ")
    public String getCk_tm_req() {
        return ck_tm_req;
    }

    public void setCk_tm_req(String ck_tm_req) {
        this.ck_tm_req = ck_tm_req;
    }
    @Column(name = "CK_TYPE")
    public String getCk_type() {
        return ck_type;
    }

    public void setCk_type(String ck_type) {
        this.ck_type = ck_type;
    }
    @Column(name = "CK_WIR_RADIUS")
    public Double getCk_wir_radius() {
        return ck_wir_radius;
    }

    public void setCk_wir_radius(Double ck_wir_radius) {
        this.ck_wir_radius = ck_wir_radius;
    }
    @Column(name = "LGTD")
    public Double getLgtd() {
        return lgtd;
    }

    public void setLgtd(Double lgtd) {
        this.lgtd = lgtd;
    }
    @Column(name = "LOC")
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
    @Column(name = "LTTD")
    public Double getLttd() {
        return lttd;
    }

    public void setLttd(Double lttd) {
        this.lttd = lttd;
    }
    @Column(name = "SEQ")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    @Column(name = "TERM_CD")
    public String getTerm_cd() {
        return term_cd;
    }

    public void setTerm_cd(String term_cd) {
        this.term_cd = term_cd;
    }

    @Column(name = "NT")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    @Column(name = "TS")
    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
    @Transient
    public String getCk_object_name() {
        return ck_object_name;
    }

    public void setCk_object_name(String ck_object_name) {
        this.ck_object_name = ck_object_name;
    }
    @Transient
    public String getCk_org_name() {
        return ck_org_name;
    }

    public void setCk_org_name(String ck_org_name) {
        this.ck_org_name = ck_org_name;
    }
    @Transient
    public String getCk_type_name() {
        return ck_type_name;
    }

    public void setCk_type_name(String ck_type_name) {
        this.ck_type_name = ck_type_name;
    }
    @Transient
    public String getRootNode() {
        return rootNode;
    }

    public void setRootNode(String rootNode) {
        this.rootNode = rootNode;
    }
    @Transient
    public String getCk_obj_pid_name() {
        return ck_obj_pid_name;
    }

    public void setCk_obj_pid_name(String ck_obj_pid_name) {
        this.ck_obj_pid_name = ck_obj_pid_name;
    }
//Column(name = "JSRNAME" ,  length = 50   )
    //Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    //Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
}
