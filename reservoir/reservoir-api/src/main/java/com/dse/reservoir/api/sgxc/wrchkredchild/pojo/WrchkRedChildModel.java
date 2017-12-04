package com.dse.reservoir.api.sgxc.wrchkredchild.pojo;

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
@Table(name = "WR_CHK_RED_CHILD")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrchkRedChildModel implements java.io.Serializable {

    public WrchkRedChildModel() {
        super();
    }
    private static final long serialVersionUID = 1L;
    /**
     *编码
     */
    private String id ;
    /**
     *巡查记录编码
     */
    private String ck_re_id;
    /**
     *巡查点编码
     */
    private String ck_obj_id;
    private String ck_obj_id_name;
    /**
     *巡查内容编码
     */
    private String ck_cnt_id;
    /***
     * 巡查内容描述
     */
    private String ck_cnt_desc ;
    /***
     * 巡查标准描述
     */
    private String ck_tag_desc ;
    /**
     *问题记录及处理方式
     */
    private String issue_id;
    /**
     *序号
     */
    private Integer seq;
    /**
     *创建时间
     */
    private Date ts;
    /**
     *处理状态(0:未开始;   1:进行中 ; 2:已完成)
     */
    private String ch_status;
    private String ch_status_name;
    /**
     *备注
     */
    private String nt;

    private String search_ck_re_page;

    @Id
    @Column(name = "ID", nullable = false, precision = 32, scale = 0   )
    @NotNull(message="编码不能为空")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "CK_OBJ_ID")
    public String getCk_obj_id() {
        return ck_obj_id;
    }

    public void setCk_obj_id(String ck_obj_id) {
        this.ck_obj_id = ck_obj_id;
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


    @Column(name = "CH_STATUS")
    public String getCh_status() {
        return ch_status;
    }

    public void setCh_status(String ch_status) {
        this.ch_status = ch_status;
    }
    @Transient
    public String getCh_status_name() {
        return ch_status_name;
    }

    public void setCh_status_name(String ch_status_name) {
        this.ch_status_name = ch_status_name;
    }
    @Column(name = "CK_CNT_DESC")
    public String getCk_cnt_desc() {
        return ck_cnt_desc;
    }

    public void setCk_cnt_desc(String ck_cnt_desc) {
        this.ck_cnt_desc = ck_cnt_desc;
    }
    @Column(name = "CK_CNT_ID")
    public String getCk_cnt_id() {
        return ck_cnt_id;
    }

    public void setCk_cnt_id(String ck_cnt_id) {
        this.ck_cnt_id = ck_cnt_id;
    }

    @Transient
    public String getCk_obj_id_name() {
        return ck_obj_id_name;
    }

    public void setCk_obj_id_name(String ck_obj_id_name) {
        this.ck_obj_id_name = ck_obj_id_name;
    }
    @Column(name = "CK_RE_ID")
    public String getCk_re_id() {
        return ck_re_id;
    }

    public void setCk_re_id(String ck_re_id) {
        this.ck_re_id = ck_re_id;
    }
    @Column(name = "CK_TAG_DESC")
    public String getCk_tag_desc() {
        return ck_tag_desc;
    }

    public void setCk_tag_desc(String ck_tag_desc) {
        this.ck_tag_desc = ck_tag_desc;
    }
    @Column(name = "ISSUE_ID")
    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }
    @Column(name = "SEQ")
    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    @Transient
    public String getSearch_ck_re_page() {
        return search_ck_re_page;
    }

    public void setSearch_ck_re_page(String search_ck_re_page) {
        this.search_ck_re_page = search_ck_re_page;
    }

    //Column(name = "JSRNAME" ,  length = 50   )
    //Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    //Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
}
