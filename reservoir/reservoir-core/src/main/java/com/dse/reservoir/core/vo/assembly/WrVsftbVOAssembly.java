package com.dse.reservoir.core.vo.assembly;



import com.dse.common.util.BeanConvertUtil;
import com.dse.reservoir.api.pojo.entity.WrVsftb;
import com.dse.reservoir.api.pojo.vo.WrVsftbVO;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 用于记录垂直位置监测信息表(垂直位置监测信息表)数据信息
 * Created by pengzx on 2017/5/26.
 */
public class WrVsftbVOAssembly {

	public static WrVsftbVO toVo(WrVsftb entity)
			throws InvocationTargetException, IllegalAccessException {
		if (entity == null) {
			return null;
		}
		WrVsftbVO vo =null;
		try {
			vo=BeanConvertUtil.convert(entity, WrVsftbVO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public static WrVsftb toEntity(WrVsftbVO vo)
			throws InvocationTargetException, IllegalAccessException {
		if (vo == null) {
			return null;
		}
		WrVsftb entity =null;
		try {
			entity=BeanConvertUtil.convert(vo,WrVsftb.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// BeanUtils.copyProperties(entity,vo);
		if (vo.getId() == null || "".equals(vo.getId())) {
			entity.setId(null);
		}
		return entity;
	}

	public static List<WrVsftbVO> toVos(List<WrVsftb> entities)
			throws InvocationTargetException, IllegalAccessException {
		if (entities == null || entities.size() == 0) {
			return null;
		}
		List<WrVsftbVO> vos = new ArrayList<WrVsftbVO>();
		for (Iterator<WrVsftb> it = entities.iterator(); it.hasNext();) {
			WrVsftb entity = it.next();
			vos.add(toVo(entity));
		}
		return vos;
	}

}
