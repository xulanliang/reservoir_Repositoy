package com.dse.reservoir.api.tableEdit.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by dse on 2017/8/5.
 */
@Entity
@Table(name = "WR_MONITOR_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MkjbxxModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String MDCD;    //编号
    private String MDNAME;    //名称
    private String TYPE;    //类型(1:监测站,2:MCU,3:DAU,4:NDA)
    private Double LGTD;    //经度
    private Double LTTD;    //纬度
    private String NT;    //备注
    private String ALLOWUNIT;    //1001	深圳部  1002 雁田部 1003 桥头部 1004 塘厦部
    private String PROJ_CD;    //工程编号
    private String PID;    //父级编码(为监测站时父级编码为空,为MCU|DAU时父级编码为监测站编码,为NDA时父级编码为DAU编码)

    @Id
    @Column(name = "MDCD",length = 32)
    @Length(min = 0,max = 32,message = "编号长度只能在 0 至 32 之间")
    public String getMDCD() {
        return MDCD;
    }

    public void setMDCD(String MDCD) {
        this.MDCD = MDCD;
    }

    @Column(name = "MDNAME",length = 50)
    @Length(min = 0,max = 50,message = "名称长度只能在 0 至 32 之间")
    public String getMDNAME() {
        return MDNAME;
    }

    public void setMDNAME(String MDNAME) {
        this.MDNAME = MDNAME;
    }

    @Column(name = "TYPE",length = 1)
    @Length(min = 0,max = 1,message = "类型长度只能在 0 至 1 之间")
    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    @Column(name = "LGTD")
    public Double getLGTD() {
        return LGTD;
    }

    public void setLGTD(Double LGTD) {
        this.LGTD = LGTD;
    }

    @Column(name = "LTTD")
    public Double getLTTD() {
        return LTTD;
    }

    public void setLTTD(Double LTTD) {
        this.LTTD = LTTD;
    }

    @Column(name = "NT",length = 200)
    @Length(min = 0,max = 200,message = "备注长度只能在 0 至 200 之间")
    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }

    @Column(name = "ALLOWUNIT",length = 32)
    @Length(min = 0,max = 32,message = "所属部门长度只能在 0 至 200 之间")
    public String getALLOWUNIT() {
        return ALLOWUNIT;
    }

    public void setALLOWUNIT(String ALLOWUNIT) {
        this.ALLOWUNIT = ALLOWUNIT;
    }

    @Column(name = "PROJ_CD",length = 16)
    @Length(min = 0,max = 16,message = "工程编号长度只能在 0 至 200 之间")
    public String getPROJ_CD() {
        return PROJ_CD;
    }

    public void setPROJ_CD(String PROJ_CD) {
        this.PROJ_CD = PROJ_CD;
    }

    @Column(name = "PID",length = 32)
    @Length(min = 0,max = 32,message = "父级编号长度只能在 0 至 32 之间")
    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }
}
