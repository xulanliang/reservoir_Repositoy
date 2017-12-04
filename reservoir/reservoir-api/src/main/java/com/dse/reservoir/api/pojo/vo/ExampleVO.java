package com.dse.reservoir.api.pojo.vo;


import java.util.Date;
import java.util.List;

import com.dse.common.enums.DelFlag;
import com.dse.common.enums.Status;
import com.dse.reservoir.api.pojo.entity.Example;

/**
 * 用于记录系统的基本数据信息
 **/
public class ExampleVO  {


    public String id;
    /**
     * 数据项code
     */
    public String code;

    /**
     * 数据项名称
     */
    public String name;

    /**
     * 父数据项
     */
    public String pid;

    /**
     * 树形结构的层次
     */
    protected Integer level;


    /**
     * 创建者
     */
    protected String creator;

    /**
     * 创建时间
     */
    protected Date createTime = null;

    /**
     * 最后更新者
     */
    protected String lastUpdator;

    /**
     * 最后更新时间
     */
    protected Date lastUpdateTime = null;

    /**
     * 删除标记：：0：正常；1：逻辑删除；-1：永久删除
     */
    protected DelFlag delFlag;

    /**
     * 描述或者备注
     */
    protected String description;

    /**
     * 状态
     */
    protected Status status;

    /**
     * 排序
     */
    protected Integer orderIndex;


    public ExampleVO() {
    }
    public ExampleVO(String id) {
        this.id = id;
    }


    private String key;

    private String pname;

    private String statusName;

    private List<String> pids;



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<String> getPids() {
        return pids;
    }

    public void setPids(List<String> pids) {
        this.pids = pids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdator() {
        return lastUpdator;
    }

    public void setLastUpdator(String lastUpdator) {
        this.lastUpdator = lastUpdator;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public DelFlag getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(DelFlag delFlag) {
        this.delFlag = delFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }
}