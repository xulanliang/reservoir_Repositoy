package com.dse.reservoir.sjfx.wralarmparamm.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.sjfx.wralarmparamm.pojo.WrAlarmParammModel;
import com.dse.reservoir.sjfx.wralarmparamm.dao.WrAlarmParammDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by   on 2017-8-1.
 */
@Repository("wrAlarmParammDao")
public class WrAlarmParammImpl extends BaseDao<WrAlarmParammModel, String> implements WrAlarmParammDao {

    @Override
    public EasyUiPage getListInfoByParams(WrAlarmParammModel args, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT T.*, ");
        sql.append(" W.STNM AS STNM,P.PROJ_NM AS PROJ_CD_NAME,D.NAME AS MON_TP_NAME FROM ( ");
        sql.append(" SELECT ID, PROJ_CD, STCD, MON_TP, MAX_VALUE, CG_VALUE, OBS_VALUE, TO_CHAR(TS,'yyyy-mm-dd') AS TS , NT FROM WR_ALARM_PARAM_M T WHERE 1=1 ");
        if (StringUtil.isNotEmpty(args.getMon_tp())) {
            if("0".equalsIgnoreCase(args.getMon_tp())){
                sql.append(" AND T.MON_TP in ('5','6','7') ");
            }else{
                sql.append(" AND T.MON_TP = ? ");
                params.add(args.getMon_tp());
            }
        }
        if (StringUtil.isNotEmpty(args.getProj_cd())) {
            sql.append(" AND T.PROJ_CD like ? ");
            params.add(args.getProj_cd()+"%");
        }
        sql.append(" ORDER BY T.TS ASC ");
        sql.append(" ) T LEFT JOIN WR_STAT_M W ON T.STCD=W.STCD   ");
        sql.append("  LEFT JOIN WR_PROJ_B P ON P.PROJ_CD=SUBSTR(T.PROJ_CD,1,1)     ");
        sql.append("  LEFT JOIN T_SYS_DICTIONARY D ON D.CODE=T.MON_TP     ");
        sql.append("  ORDER BY  T.TS ASC  ");
        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        if (StringUtil.isNotEmpty(ids)) {
            String[] id = ids.split(",");
            for (int i = 0; i < id.length; i++) {
                removeById(WrAlarmParammModel.class, id[i]);
            }
        }
        return true;
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        if (StringUtil.isNotEmpty(dataStr)) {
            WrAlarmParammModel model = JsonUtil.json2Object(dataStr, WrAlarmParammModel.class);
            if (!StringUtil.isNotEmpty(model.getId())) {
                model.setId(DseSysCommonUtil.getNewId().toString());
            }
            if (model.getTs() == null) {
                model.setTs(new Date());
            }
            saveOrUpdate(model);
            return model;
        }
        return null;
    }

    @Override
    public Object getInfoById(String id) throws Exception {
        return get(id);
    }

}
