package com.dse.reservoir.core.vo.assembly;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dse.reservoir.api.pojo.entity.Example;
import com.dse.reservoir.api.pojo.vo.ExampleVO;

/**
 * Created by zhoujc on 2016-3-3.
 */
public class ExampleVOAssembly {

	public static ExampleVO toVo(Example entity)
			throws InvocationTargetException, IllegalAccessException {
		if (entity == null)
			return null;
		ExampleVO vo = new ExampleVO();
		vo.setId(entity.getId());
		vo.setName(entity.getName());
		vo.setCode(entity.getCode());
		vo.setPid(entity.getPid());
		vo.setOrderIndex(entity.getOrderIndex());
		vo.setDescription(entity.getDescription());

		vo.setCreator(entity.getCreator());
		vo.setCreateTime(entity.getCreateTime());
		vo.setLastUpdator(entity.getLastUpdator());
		vo.setLastUpdateTime(entity.getLastUpdateTime());
		vo.setDelFlag(entity.getDelFlag());

		if (entity.getStatus() != null) {
			vo.setStatus(entity.getStatus());
			vo.setStatusName(entity.getStatus().getDescription());
		}
		return vo;
	}

	public static Example toEntity(ExampleVO vo)
			throws InvocationTargetException, IllegalAccessException {
		if (vo == null)
			return null;
		Example entity = new Example();
		// BeanUtils.copyProperties(entity,vo);
		if (vo.getId() == null || "".equals(vo.getId()))
			entity.setId(null);
		entity.setName(vo.getName());
		entity.setCode(vo.getCode());
		entity.setPid(vo.getPid());
		entity.setOrderIndex(vo.getOrderIndex());
		entity.setDescription(vo.getDescription());
		entity.setStatus(vo.getStatus());

		// entity.setCreateTime(new Date(System.currentTimeMillis()));
		// entity.setCreator("zhoujc");
		// entity.setLastUpdator(vo.getLastUpdator());
		// entity.setLastUpdateTime(vo.getLastUpdateTime());
		entity.setDelFlag(vo.getDelFlag());

		return entity;
	}

	public static List<ExampleVO> toVos(List<Example> entities)
			throws InvocationTargetException, IllegalAccessException {
		if (entities == null || entities.size() == 0)
			return null;
		List<ExampleVO> vos = new ArrayList<ExampleVO>();
		for (Iterator<Example> it = entities.iterator(); it.hasNext();) {
			Example entity = it.next();
			vos.add(toVo(entity));
		}
		return vos;
	}

}
