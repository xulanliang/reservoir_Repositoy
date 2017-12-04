package com.dse.reservoir.api.sgxc.wrchkobject.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 *  巡查内容表
 * Created by dse on 2017/8/11.
 */
@Entity
@Table(name = "WR_CHK_CONTENTS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class XcnrModel implements Serializable {
    public XcnrModel() {
        super();
    }

    private static final long serialVersionUID = 1L;

    private String CK_CNT_ID;   //编码
    private String CK_CNT_DESC;   //巡查内容描述
    private String CK_TAG_DESC;   //巡查标准描述
    private String CK_OBJ_ID;   //巡查点编码(巡查对象WR_CHK_OBJECT.CK_ITEM为1(1:巡查点))
    private String CK_TM_REQ;   //巡查时间要求(2周1次;停水期;1月1次)
    private Integer SEQ;   //排序
    private Date TS;   //时间戳
    private String NT;   //备注
    private String CK_TYPE;   //巡查类型（0、水工巡查 1、物资巡查）
    private String TYPE;   //汛前、汛后/日常（0、汛前、汛后 1、日常）



    @Id
    @Column(name = "CK_CNT_ID",length = 32)
    @Length(min = 0,max = 32,message = "编码长度只能在 0  至 32 之间")
    public String getCK_CNT_ID() {
        return CK_CNT_ID;
    }

    public void setCK_CNT_ID(String CK_CNT_ID) {
        this.CK_CNT_ID = CK_CNT_ID;
    }

    @Column(name = "CK_CNT_DESC",length = 200)
    @Length(min = 0,max = 200,message = "巡查内容描述长度只能在 0  至 200 之间")
    public String getCK_CNT_DESC() {
        return CK_CNT_DESC;
    }

    public void setCK_CNT_DESC(String CK_CNT_DESC) {
        this.CK_CNT_DESC = CK_CNT_DESC;
    }

    @Column(name = "CK_TAG_DESC",length = 200)
    @Length(min = 0,max = 200,message = "巡查标准描述长度只能在 0  至 200 之间")
    public String getCK_TAG_DESC() {
        return CK_TAG_DESC;
    }

    public void setCK_TAG_DESC(String CK_TAG_DESC) {
        this.CK_TAG_DESC = CK_TAG_DESC;
    }

    @Column(name = "CK_OBJ_ID",length = 32)
    @Length(min = 0,max = 32,message = "巡查点编码长度只能在 0  至 32 之间")
    public String getCK_OBJ_ID() {
        return CK_OBJ_ID;
    }

    public void setCK_OBJ_ID(String CK_OBJ_ID) {
        this.CK_OBJ_ID = CK_OBJ_ID;
    }

    @Column(name = "CK_TM_REQ",length = 50)
    @Length(min = 0,max = 50,message = "巡查时间要求长度只能在 0  至 50 之间")
    public String getCK_TM_REQ() {
        return CK_TM_REQ;
    }

    public void setCK_TM_REQ(String CK_TM_REQ) {
        this.CK_TM_REQ = CK_TM_REQ;
    }

    @Column(name = "SEQ")
    public Integer getSEQ() {
        return SEQ;
    }

    public void setSEQ(Integer SEQ) {
        this.SEQ = SEQ;
    }

    @Column(name = "TS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTS() {
        return TS;
    }

    public void setTS(Date TS) {
        this.TS = TS;
    }

    @Column(name = "NT",length = 256)
    @Length(min = 0,max = 256,message = "备注长度只能在 0  至 256 之间")
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }

    @Column(name = "CK_TYPE",length = 1)
    @Length(min = 0,max = 1,message = "长度只能在 0  至 1 之间")
    public String getCK_TYPE() {
        return CK_TYPE;
    }

    public void setCK_TYPE(String CK_TYPE) {
        this.CK_TYPE = CK_TYPE;
    }

    @Column(name = "TYPE",length = 1)
    @Length(min = 0,max = 1,message = "长度只能在 0  至 1 之间")
    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }
}
