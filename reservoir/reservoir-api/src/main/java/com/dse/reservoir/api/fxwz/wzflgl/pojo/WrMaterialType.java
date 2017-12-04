package com.dse.reservoir.api.fxwz.wzflgl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * 物资分类表
 */
@Entity
@Table(name = "WR_MATERIAL_TYPE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class WrMaterialType implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键**/
    @Id
    private String ma_type_id;

    /** 父级分类编码**/
    private String ma_type_pid;

    /** 物资分类名称**/
    private String ma_type_name;

    /** 备注**/
    private String nt;

    /** 创建时间**/
    private Date ts;

    public WrMaterialType() {
    }

    @Id
    @Column(name = "MA_TYPE_ID" , nullable = false ,  length = 32   )
    @Length(min=0, max=32, message="物资分类编码长度必须介于 0 和 32 之间")
    public String getMa_type_id() {
        return ma_type_id;
    }

    public void setMa_type_id(String ma_type_id) {
        this.ma_type_id = ma_type_id;
    }

    @Column(name = "MA_TYPE_PID" ,  length = 32   )
    @Length(min=0, max=32, message="父级分类编码长度必须介于 0 和 32 之间")
    public String getMa_type_pid() {
        return ma_type_pid;
    }

    public void setMa_type_pid(String ma_type_pid) {
        this.ma_type_pid = ma_type_pid;
    }

    @Column(name = "MA_TYPE_NAME" ,  length = 100   )
    @Length(min=0, max=100, message="物资分类名称长度必须介于 0 和 100 之间")
    public String getMa_type_name() {
        return ma_type_name;
    }

    public void setMa_type_name(String ma_type_name) {
        this.ma_type_name = ma_type_name;
    }

    @Column(name = "NT" ,  length = 100   )
    @Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
    public String getNt() {
        return nt;
    }

    public void setNt(String nt) {
        this.nt = nt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TS" ,  length = 23   )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }
}
