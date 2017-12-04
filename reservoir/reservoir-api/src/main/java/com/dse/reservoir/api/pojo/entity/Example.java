package com.dse.reservoir.api.pojo.entity;

import com.dse.common.entity.base.BaseEntity;
import com.dse.common.enums.DelFlag;
import com.dse.common.enums.Status;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用于记录系统的基本数据信息
 **/
@Entity
@Table(name = "T_SYS_DICTIONARY")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Example extends BaseEntity {

	@Id
	@GenericGenerator(name = "dictionary-uuid", strategy = "uuid")
	@GeneratedValue(generator = "dictionary-uuid")
	public String getId() {
		return this.id;
	}

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

	@Column(name = "LEV")
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	@Column(updatable = false)
	public String getCreator() {
		return super.getCreator();
	}

	@Override
	@Column(updatable = false)
	public Date getCreateTime() {
		return super.getCreateTime();
	}

	@Override
	@Type(type = "com.dse.common.enums.map.EnumType", parameters = { @Parameter(name = "enumClass", value = "com.dse.common.enums.DelFlag") })
	public DelFlag getDelFlag() {
		return super.getDelFlag();
	}

	@Override
	public String getLastUpdator() {
		return super.getLastUpdator();
	}

	@Override
	public Date getLastUpdateTime() {
		return super.getLastUpdateTime();
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Integer getOrderIndex() {
		return this.orderIndex;
	}

	@Override
	@Type(type = "com.dse.common.enums.map.EnumType", parameters = { @Parameter(name = "enumClass", value = "com.dse.common.enums.Status") })
	public Status getStatus() {
		return this.status;
	}
}