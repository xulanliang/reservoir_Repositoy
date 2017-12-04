package com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yuan_feng on 2017/9/7.
 */
    @Entity
    @Table(name = "WR_WEIO_B")
    @IdClass(SljcKey.class)
    public class SljcsjEntity implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        private String stcd;//    STCD                 VARCHAR(32)          not null,
        @Id
        private Date tm;      //    TM                   DATE                 not null,
        private BigDecimal origdata; //    ORIGDATA             NUMBER(12,2),
        private BigDecimal calcdata; //    CALCDATA             NUMBER(12,2),
        private String jcl; //    JCL                  VARCHAR(200),
        private String transst;   //    TRANSST              VARCHAR(1),
        private String otdesc; //    OTDESC               VARCHAR(200),
        private String gattype; //    GETTYPE              VARCHAR(1),
        private String nt;   //    NT                   VARCHAR(200),
        private Date ts;    //    TS                   DATE,

        public String getStcd() {
            return stcd;
        }

        public void setStcd(String stcd) {
            this.stcd = stcd;
        }

        public Date getTm() {
            return tm;
        }

        public void setTm(Date tm) {
            this.tm = tm;
        }

        public BigDecimal getOrigdata() {
            return origdata;
        }

        public void setOrigdata(BigDecimal origdata) {
            this.origdata = origdata;
        }

        public BigDecimal getCalcdata() {
            return calcdata;
        }

        public void setCalcdata(BigDecimal calcdata) {
            this.calcdata = calcdata;
        }

        public String getJcl() {
            return jcl;
        }

        public void setJcl(String jcl) {
            this.jcl = jcl;
        }

        public String getTransst() {
            return transst;
        }

        public void setTransst(String transst) {
            this.transst = transst;
        }

        public String getOtdesc() {
            return otdesc;
        }

        public void setOtdesc(String otdesc) {
            this.otdesc = otdesc;
        }

        public String getGattype() {
            return gattype;
        }

        public void setGattype(String gattype) {
            this.gattype = gattype;
        }

        public String getNt() {
            return nt;
        }

        public void setNt(String nt) {
            this.nt = nt;
        }

        public Date getTs() {
            return ts;
        }

        public void setTs(Date ts) {
            this.ts = ts;
        }
    }
