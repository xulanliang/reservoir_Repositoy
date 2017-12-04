package com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuan_feng on 2017/9/7.
 */
@Embeddable
public class SljcKey implements Serializable {
    private String stcd;
    private Date tm;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SljcKey that = (SljcKey) o;

        if (!stcd.equals(that.stcd)) return false;
        return tm.equals(that.tm);

    }

    @Override
    public int hashCode() {
        int result = stcd.hashCode();
        result = 31 * result + tm.hashCode();
        return result;
    }

}

