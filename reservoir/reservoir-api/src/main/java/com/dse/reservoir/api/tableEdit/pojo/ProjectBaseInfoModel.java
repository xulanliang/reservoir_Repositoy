package com.dse.reservoir.api.tableEdit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Xll on 2017/7/6.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Entity
@Table(name = "WR_ITEM_M")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProjectBaseInfoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ITEM_CD;     //监测项目编号
    private String ITEM_NM;     //监测项目名称
    private String PROJ_CD;     //工程编码
    private String MON_TP;     //监测类型
    private String NOT_SINGLE;     //时候有多测点
    private String IS_AUTO;     //是否为自动化监测
    private Date TS;     //时间戳
    private String NT;     //备注

    @Id
    @Column(name = "ITEM_CD",  nullable = false, length =  32)
    @Length(min = 0,max = 32, message = "监测项目编号长度必须在 0 至 32 之间")
    public String getITEM_CD() {
        return ITEM_CD;
    }

    public void setITEM_CD(String ITEM_CD) {
        this.ITEM_CD = ITEM_CD;
    }

    @Column(name ="ITEM_NM", length = 50)
    @Length(min = 0,max = 50,message = "监测项目名称长度必须在 0 至 50 之间")
    public String getITEM_NM() {
        return ITEM_NM;
    }

    public void setITEM_NM(String ITEM_NM) {
        this.ITEM_NM = ITEM_NM;
    }

    @Column(name ="PROJ_CD", length = 32)
    @Length(min = 0,max = 32,message = "工程编码长度必须在 0 至 32 之间")
    public String getPROJ_CD() {
        return PROJ_CD;
    }

    public void setPROJ_CD(String PROJ_CD) {
        this.PROJ_CD = PROJ_CD;
    }

    @Column(name ="MON_TP", length = 1)
    @Length(min = 0,max = 1)
    public String getMON_TP() {
        return MON_TP;
    }

    public void setMON_TP(String MON_TP) {
        this.MON_TP = MON_TP;
    }

    @Column(name ="NOT_SINGLE", length = 1)
    @Length(min = 0,max = 1)
    public String getNOT_SINGLE() {
        return NOT_SINGLE;
    }

    public void setNOT_SINGLE(String NOT_SINGLE) {
        this.NOT_SINGLE = NOT_SINGLE;
    }

    @Column(name ="IS_AUTO", length = 1)
    @Length(min = 0,max = 1)
    public String getIS_AUTO() {
        return IS_AUTO;
    }

    public void setIS_AUTO(String IS_AUTO) {
        this.IS_AUTO = IS_AUTO;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTS() {
        return TS;
    }

    public void setTS(Date TS) {
        this.TS = TS;
    }

    @Column(name ="NT", length = 256)
    @Length(min = 0,max = 256,message = "工程编码长度必须在 0 至 256 之间")
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }
}
