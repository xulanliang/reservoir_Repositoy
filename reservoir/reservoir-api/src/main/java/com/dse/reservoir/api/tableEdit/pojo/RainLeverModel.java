package com.dse.reservoir.api.tableEdit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Xll on 2017/7/5.
 *  降雨量表
 * @Company 深圳市东深电子股份有限公司
 */
@Entity
@Table(name = "ST_PPTN_R")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class RainLeverModel  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Date TM;    //采集时间
    private String STCD;    //测点编号
    private Double DRP;     //时段降水量
    private Double INTV;     //时段长
    private Double PDR;     //降水历时
    private Double DYP;     //日降水量
    private String WTH;     //天气状况

    @Id
    @Column(name = "TM",  nullable = false  )
    @NotNull(message="TM不能为空")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTM() {
        return TM;
    }

    public void setTM(Date TM) {
        this.TM = TM;
    }

    @Column(name = "STCD" ,  length = 32   )
    @Length(min=0, max=32, message="测点编号长度必须介于 0 和 32 之间")
    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    @Column(name = "DRP" ,  precision = 5, scale = 1   )
    public Double getDRP() {
        return DRP;
    }

    public void setDRP(Double DRP) {
        this.DRP = DRP;
    }

    @Column(name = "INTV" ,  precision = 5, scale = 2   )
    public Double getINTV() {
        return INTV;
    }

    public void setINTV(Double INTV) {
        this.INTV = INTV;
    }

    @Column(name = "PDR" ,  precision = 5, scale = 2   )
    public Double getPDR() {
        return PDR;
    }

    public void setPDR(Double PDR) {
        this.PDR = PDR;
    }

    @Column(name = "DYP" ,  precision = 5, scale = 1   )
    public Double getDYP() {
        return DYP;
    }

    public void setDYP(Double DYP) {
        this.DYP = DYP;
    }

    public String getWTH() {
        return WTH;
    }

    @Column(name = "WTH" ,  length = 1   )
    @Length(min=0, max=1, message="天气状况长度只能为1")
    public void setWTH(String WTH) {
        this.WTH = WTH;
    }
}
