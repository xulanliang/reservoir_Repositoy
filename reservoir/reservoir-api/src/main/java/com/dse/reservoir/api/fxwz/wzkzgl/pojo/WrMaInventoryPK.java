package com.dse.reservoir.api.fxwz.wzkzgl.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by dse on 2017/8/7.
 */
@Embeddable
public class WrMaInventoryPK implements Serializable {

    //联合主键
    /**
     *所属仓库
     */
    private String wh_cd;
    /**
     *物资编码
     */
    private String ma_cd;


    @Column(name = "WH_CD")
    public String getWh_cd() {
        return wh_cd;
    }

    public void setWh_cd(String wh_cd) {
        this.wh_cd = wh_cd;
    }

    @Column(name = "MA_CD")
    public String getMa_cd() {
        return ma_cd;
    }

    public void setMa_cd(String ma_cd) {
        this.ma_cd = ma_cd;
    }

}
