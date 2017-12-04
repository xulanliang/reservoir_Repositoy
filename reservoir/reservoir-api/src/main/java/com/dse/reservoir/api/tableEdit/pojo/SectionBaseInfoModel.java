package com.dse.reservoir.api.tableEdit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 *  断面基础信息
 * Created by Xuu on 2017/7/7.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Entity
@Table(name = "WR_RB_M")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SectionBaseInfoModel implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String RB_CD;   //断面编码
    private String RB_NM;   //断面名称
    private String PROJ_CD_ONE;   //一级工程编码
    private String PROJ_CD_TWO;   //二级工程编码
    private String ITEM_CD;   //监测项目编码
    private Date TS;   //时间
    private String NT;   //备注
    private String RB_TYPE="0";   //断面类型(0:横断面,1:纵断面)


    @Column(name = "RB_TYPE",length = 1)
    @Length(min = 0,max = 1,message = "断面名称长度只能在 0 至 100 之间")
    public String getRB_TYPE() {
        return RB_TYPE;
    }

    public void setRB_TYPE(String RB_TYPE) {
        this.RB_TYPE = RB_TYPE;
    }


    @Id
    @Column(name = "RB_CD",length = 32)
    @Length(min = 0,max = 32,message = "断面编码长度只能在 0 至 32 之间")
    public String getRB_CD() {
        return RB_CD;
    }

    public void setRB_CD(String RB_CD) {
        this.RB_CD = RB_CD;
    }

    @Column(name = "RB_NM",length = 100)
    @Length(min = 0,max = 100,message = "断面名称长度只能在 0 至 100 之间")
    public String getRB_NM() {
        return RB_NM;
    }

    public void setRB_NM(String RB_NM) {
        this.RB_NM = RB_NM;
    }

    @Column(name = "PROJ_CD_ONE",length = 32)
    @Length(min = 0,max = 32,message = "一级工程编码长度只能在 0 至 32 之间")
    public String getPROJ_CD_ONE() {
        return PROJ_CD_ONE;
    }

    public void setPROJ_CD_ONE(String PROJ_CD_ONE) {
        this.PROJ_CD_ONE = PROJ_CD_ONE;
    }

    @Column(name = "PROJ_CD_TWO",length = 32)
    @Length(min = 0,max = 32,message = "二级工程编码长度只能在 0 至 32 之间")
    public String getPROJ_CD_TWO() {
        return PROJ_CD_TWO;
    }

    public void setPROJ_CD_TWO(String PROJ_CD_TWO) {
        this.PROJ_CD_TWO = PROJ_CD_TWO;
    }

    @Column(name = "ITEM_CD",length = 32)
    @Length(min = 0,max = 32,message = "监测项目编号长度只能在 0 至 32 之间")
    public String getITEM_CD() {
        return ITEM_CD;
    }

    public void setITEM_CD(String ITEM_CD) {
        this.ITEM_CD = ITEM_CD;
    }

    @Column(name = "TS")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTS() {
        return TS;
    }

    public void setTS(Date TS) {
        this.TS = TS;
    }

    @Column(name = "NT",length = 256)
    @Length(min = 0,max = 256,message = "备注长度只能在 0 至 256 之间")
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }
}
