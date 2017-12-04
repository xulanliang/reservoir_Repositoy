package com.dse.reservoir.api.fxwz.wrmaquanb.pojo;



import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.beans.Transient;
import java.util.Date;


/**
 * @Description:实体 物资存储定额表
 * @Copyright:
 * @Company:
 * @author
 * @version 1.0 2017-08-06
 */
@Entity
@Table(name = "WR_MA_QUAN_B")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrmaquanbModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private WrMaPK idd;      //联合主键

    /**
     *当前库容量（累计：WR_MA_QUAN_B.REAL_QUAN（当次数量））
     */
    private double real_quan;





    /**
     *创建时间
     */
    private Date ts;
    /**
     *备注
     */
    private String nt;



    public WrMaPK getIdd() {
        return idd;
    }

    public void setIdd(WrMaPK idd) {
        this.idd = idd;
    }

    @Column(name = "NT")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    @Column(name = "REAL_QUAN")
    public double getReal_quan() {
        return real_quan;
    }

    public void setReal_quan(double real_quan) {
        this.real_quan = real_quan;
    }

    @Column(name = "TS")
    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }


    //Column(name = "JSRNAME" ,  length = 50   )
    //Length(min=0, max=50, message="入库签收人员长度必须介于 0 和 50 之间")
    //Column(name = "CKID",  nullable = false, precision = 16, scale = 0   )
}
