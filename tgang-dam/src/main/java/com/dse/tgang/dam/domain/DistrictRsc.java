package com.dse.tgang.dam.domain;

import javax.persistence.Transient;
import java.util.List;

/**
 * Created by gaoq on 2016-12-24.
 */
public class DistrictRsc {
    /** 树状结点类型， 2：水库 3：坝 4：断面 5：点 **/
    private String type;
    private String id;
    private String pid;
    private String name;
    private String code;
    private String addvcd;
    private String icon;
    private List<DistrictRsc> children;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public List<DistrictRsc> getChildren() {
        return children;
    }

    public void setChildren(List<DistrictRsc> children) {
        this.children = children;
    }

    public String getAddvcd() {
        return addvcd;
    }

    public void setAddvcd(String addvcd) {
        this.addvcd = addvcd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
