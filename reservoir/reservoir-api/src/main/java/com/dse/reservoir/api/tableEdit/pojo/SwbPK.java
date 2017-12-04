package com.dse.reservoir.api.tableEdit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dse on 2017/8/7.
 */
@Embeddable
public class SwbPK implements Serializable {
    //联合主键
    private String STCD;    //测点编号
    private Date TM;    //采集时间

    @Column(name = "STCD",length = 32)
    @Length(min = 0,max = 32,message = "测点编号只能在 0 至 32 之间")
    public String getSTCD() {
        return STCD;
    }

    public void setSTCD(String STCD) {
        this.STCD = STCD;
    }

    @Column(name = "TM")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTM() {
        return TM;
    }

    public void setTM(Date TM) {
        this.TM = TM;
    }
}
