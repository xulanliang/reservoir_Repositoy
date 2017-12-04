package com.dse.reservoir.api.tableEdit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**     垂直位移监测信息表
 * Created by dse on 2017/8/3.
 */
@Entity
@Table(name = "WR_VSFT_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CzwyjcxxModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private  CzwyjcxxPK id;     //联合主键

    private Double ORIGDATA;    //监测值
    private Double CALCDATA;    //校验值
    private String JCL;    //监测量
    private String TRANSST;    //转换状态
    private String OTDESC;    //其他
    private String GATTYPE;    //采集方式    0:自动 1：手动
    private Date TS;    //时间戳
    private String NT;    //备注

    public CzwyjcxxPK getId() {
        return id;
    }

    public void setId(CzwyjcxxPK id) {
        this.id = id;
    }

    @Column(name = "ORIGDATA")
    public Double getORIGDATA() {
        return ORIGDATA;
    }

    public void setORIGDATA(Double ORIGDATA) {
        this.ORIGDATA = ORIGDATA;
    }

    @Column(name = "CALCDATA")
    public Double getCALCDATA() {
        return CALCDATA;
    }

    public void setCALCDATA(Double CALCDATA) {
        this.CALCDATA = CALCDATA;
    }

    @Column(name = "JCL",length = 200)
    @Length(min = 0,max = 200,message = "监测量的长度至能在 0 至 200 之间")
    public String getJCL() {
        return JCL;
    }

    public void setJCL(String JCL) {
        this.JCL = JCL;
    }

    @Column(name = "TRANSST",length = 1)
    @Length(min = 0,max = 1,message = "转换状态的长度至能为 1")
    public String getTRANSST() {
        return TRANSST;
    }

    public void setTRANSST(String TRANSST) {
        this.TRANSST = TRANSST;
    }

    @Column(name = "OTDESC",length = 200)
    @Length(min = 0,max = 200,message = "其他的长度至能为 0 至 200 之间")
    public String getOTDESC() {
        return OTDESC;
    }

    public void setOTDESC(String OTDESC) {
        this.OTDESC = OTDESC;
    }

    @Column(name = "GATTYPE",length = 1)
    @Length(min = 0,max = 1,message = "采集方式的长度至能为 1")
    public String getGATTYPE() {
        return GATTYPE;
    }

    public void setGATTYPE(String GATTYPE) {
        this.GATTYPE = GATTYPE;
    }

    @Column(name = "TS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTS() {
        return TS;
    }

    public void setTS(Date TS) {
        this.TS = TS;
    }

    @Column(name = "NT",length = 200)
    @Length(min = 0,max = 200,message = "备注的长度只能在 0 至 200 之间")
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }
}
