package com.dse.reservoir.fxwz.wzflgl.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.wzflgl.pojo.WrMaterialType;
import com.dse.reservoir.fxwz.wzflgl.dao.WzflglDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-8-1.
 */
@Repository("wzflglDao")
public class WzflglDaoImpl extends BaseDao<WrMaterialType,String> implements WzflglDao {

    @Override
    public Object getfl(String id) throws Exception{
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT * FROM WR_MATERIAL_TYPE WHERE 1=1";

        if(StringUtil.isNotEmpty(id)){
            sql += " AND MA_TYPE_ID != ? ";
            params.add(id);
        }

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object checkId(String id) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT * FROM WR_MATERIAL_TYPE WHERE 1=1";

        if(StringUtil.isNotEmpty(id)){
            sql += " AND MA_TYPE_ID = ? ";
            params.add(id);
        }

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public EasyUiPage getListInfoByParams(String wztypename, EasyUiPage easyUiPage) throws Exception{
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT A.*,B.MA_TYPE_NAME AS PNAME FROM WR_MATERIAL_TYPE A LEFT JOIN WR_MATERIAL_TYPE B ON A.MA_TYPE_PID = B.MA_TYPE_ID WHERE 1=1";

        if(StringUtil.isNotEmpty(wztypename)){
            sql += " AND A.MA_TYPE_NAME LIKE ? ";
            params.add("%"+wztypename+"%");
        }

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception{
        if(StringUtil.isNotEmpty(ids)){
            String[] id = ids.split(",");
            for (int i = 0; i < id.length; i++) {
                removeById(WrMaterialType.class,id[i]);
            }
        }
        return true;
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception{
        if(StringUtil.isNotEmpty(dataStr)){
            WrMaterialType model = JsonUtil.json2Object(dataStr,WrMaterialType.class);
            if(!StringUtil.isNotEmpty(model.getMa_type_id())) {
                model.setMa_type_id(DseSysCommonUtil.getNewId().toString());
                model.setTs(new Date());
            }
            saveOrUpdate(model);
            return model;
        }
        return null;
    }

    @Override
    public Object getInfoById(String id) throws Exception{
        return get(id);
    }

}
