package com.dse.reservoir.api.sgxc.wrchkrecord.pojo;

import com.dse.reservoir.api.util.DateUtil;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @Description:实体 巡查记录信息
 * @Copyright:
 * @Company:
 * @author
 * @version 1.0 2017-08-11
 */
@Entity
@Table(name = "WR_CHK_RECORD")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrchkRecordModel implements java.io.Serializable {

    public WrchkRecordModel() {
        super();
    }

    private static final long serialVersionUID = 1L;
    /**
     *编码
     */
    private String ck_re_id ;
    /**
     *巡查任务描述
     */
    private String ck_tk_desc;

    /**
     *巡检对象编码
     */
    private String ck_obj_id;
    private String ck_obj_id_name;

    /**
     *起始日期
     */
    private Date ck_begin;
    private String ck_beginStr;
    /**
     *结束日期
     */
    private Date ck_end;
    private String ck_endStr;
    /**
     *管理部门(深圳部,雁田部,桥头部,塘厦部)
     */
    private String ck_org;
    private String ck_org_name;
    /**
     *巡查类型 (日常巡视,日常检查,定期巡检,特别巡检)
     */
    private String ck_type;
    private String ck_type_name;

    /**
     *巡查人员
     */
    private String ck_users;
    /***
     * 巡查任务编码
     */
    private String ck_tk_id ;
    /***
     * 巡查任务编码
     */
    private String ck_tk_id_name ;

    /**
     *巡查人员
     */
    private String ch_note_user;

    /**
     *巡查人员
     */
    private String ch_review_user;

    /**
     *巡查点数
     */
    private Integer ck_re_pcount;
    /**
     *异常点数
     */
    private Integer ck_re_ecount;

    /**
     *创建时间
     */
    private Date ts;
    /**
     *状态(0:未开始;   1:进行中 ; 2:已完成)
     */
    private String status;
    private String status_name;
    /**
     *备注
     */
    private String nt;
    private  String ck_object;

    private  String ck_object_name;

    @Id
    @Column(name = "CK_RE_ID", nullable = false, precision = 32, scale = 0   )
    @NotNull(message="编码不能为空")
    public String getCk_re_id() {
        return ck_re_id;
    }

    public void setCk_re_id(String ck_re_id) {
        this.ck_re_id = ck_re_id;
    }

    @Column(name = "CK_BEGIN")
    public Date getCk_begin() {
        return ck_begin;
    }

    public void setCk_begin(Date ck_begin) {
        this.ck_begin = ck_begin;
    }

    @Column(name = "CK_END")
    public Date getCk_end() {
        return ck_end;
    }

    public void setCk_end(Date ck_end) {
        this.ck_end = ck_end;
    }


    @Column(name = "CK_OBJ_ID")
    public String getCk_obj_id() {
        return ck_obj_id;
    }

    public void setCk_obj_id(String ck_obj_id) {
        this.ck_obj_id = ck_obj_id;
    }

    @Column(name = "ck_tk_desc")
    public String getCk_tk_desc() {
        return ck_tk_desc;
    }

    public void setCk_tk_desc(String ck_tk_desc) {
        this.ck_tk_desc = ck_tk_desc;
    }

    @Column(name = "CK_USERS")
    public String getCk_users() {
        return ck_users;
    }

    public void setCk_users(String ck_users) {
        this.ck_users = ck_users;
    }

    @Column(name = "CH_NOTE_USER")
    public String getCh_note_user() {
        return ch_note_user;
    }

    public void setCh_note_user(String ch_note_user) {
        this.ch_note_user = ch_note_user;
    }
    @Column(name = "CH_REVIEW_USER")
    public String getCh_review_user() {
        return ch_review_user;
    }

    public void setCh_review_user(String ch_review_user) {
        this.ch_review_user = ch_review_user;
    }
    @Column(name = "CK_RE_ECOUNT")
    public Integer getCk_re_ecount() {
        return ck_re_ecount;
    }

    public void setCk_re_ecount(Integer ck_re_ecount) {
        this.ck_re_ecount = ck_re_ecount;
    }
    @Column(name = "CK_RE_PCOUNT")
    public Integer getCk_re_pcount() {
        return ck_re_pcount;
    }

    public void setCk_re_pcount(Integer ck_re_pcount) {
        this.ck_re_pcount = ck_re_pcount;
    }
    @Column(name = "CK_TK_ID")
    public String getCk_tk_id() {
        return ck_tk_id;
    }

    public void setCk_tk_id(String ck_tk_id) {
        this.ck_tk_id = ck_tk_id;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "CK_ORG")
    public String getCk_org() {
        return ck_org;
    }

    public void setCk_org(String ck_org) {
        this.ck_org = ck_org;
    }

    @Column(name = "CK_TYPE")
    public String getCk_type() {
        return ck_type;
    }

    public void setCk_type(String ck_type) {
        this.ck_type = ck_type;
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
    public String getCk_obj_id_name() {
        return ck_obj_id_name;
    }

    public void setCk_obj_id_name(String ck_obj_id_name) {
        this.ck_obj_id_name = ck_obj_id_name;
    }
    @Transient
    public String getCk_object() {
        return ck_object;
    }

    public void setCk_object(String ck_object) {
        this.ck_object = ck_object;
    }
    @Transient
    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    @Transient
    public String getCk_tk_id_name() {
        return ck_tk_id_name;
    }

    public void setCk_tk_id_name(String ck_tk_id_name) {
        this.ck_tk_id_name = ck_tk_id_name;
    }
    @Transient
    public String getCk_beginStr() {
        if(ck_begin!=null){
            ck_beginStr= DateUtil.dateToStr(ck_begin,DateUtil.DATE_MASK);
        }
        return ck_beginStr;
    }

    public void setCk_beginStr(String ck_beginStr) {
        this.ck_beginStr = ck_beginStr;
    }
    @Transient
    public String getCk_endStr() {
        if(ck_end!=null){
            ck_endStr= DateUtil.dateToStr(ck_end,DateUtil.DATE_MASK);
        }
        return ck_endStr;
    }
    @Transient
    public String getCk_object_name() {
        return ck_object_name;
    }

    public void setCk_object_name(String ck_object_name) {
        this.ck_object_name = ck_object_name;
    }

    public void setCk_endStr(String ck_endStr) {
        this.ck_endStr = ck_endStr;
    }
//Column(name = "JSRNAME" ,  length = 50   )
    //Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    //Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
}
