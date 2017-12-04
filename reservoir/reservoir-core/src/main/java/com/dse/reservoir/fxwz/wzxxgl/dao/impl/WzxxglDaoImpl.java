package com.dse.reservoir.fxwz.wzxxgl.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wzxxgl.pojo.WrMaterialB;
import com.dse.reservoir.fxwz.wzxxgl.dao.WzxxglDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-8-3.
 */
@Repository("wzxxglDao")
public class WzxxglDaoImpl extends BaseDao<WrMaterialB,String> implements WzxxglDao {

    @Override
    public EasyUiPage getListInfoByParams(String name, String type, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT B.*,T.MA_TYPE_NAME FROM WR_MATERIAL_B B LEFT JOIN WR_MATERIAL_TYPE T ON B.MA_TYPE_ID = T.MA_TYPE_ID WHERE 1=1";

        if(StringUtil.isNotEmpty(name)){
            sql += " AND B.MA_NM LIKE ? ";
            params.add("%"+name+"%");
        }

        if(StringUtil.isNotEmpty(type)){
            sql += " AND B.MA_TYPE_ID = ? ";
            params.add(type);
        }

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    @Override
    public EasyUiPage getListWzCkPcBinInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception {
        List<Object> params= new ArrayList<Object>();//hh24:mi:ss
        StringBuffer sql= new StringBuffer();
        sql.append(" SELECT T.*,WMI.ORG_CD,WMI.STD_QUAN,WMI.REAL_QUAN AS SREAL_QUAN,TSD.NAME ORG_CD_NAME  FROM ( ");
        sql.append(" SELECT T.* FROM (");
        sql.append(" SELECT T.*,WMB.MA_NM,WMB.MODEL,WMB.MU,WMB.STD_YEAR,WMB.GS_STD_QUAN,WMB.SL_STD_QUAN,WMB.MA_TYPE_ID,WMB.STATUS ");//AS WMBSTATUS
        sql.append(" ,WH.WH_NM,WH.LOC,WH.ORG_CD AS WORG_CD FROM ( ");
        sql.append(" SELECT WH_CD, MA_CD, MA_PC, BINNUM, REAL_QUAN, TO_CHAR(TS,'yyyy-mm-dd') AS TS , NT FROM WR_MA_QUAN_B T WHERE 1=1  ");
        if(StringUtil.isNotEmpty(args.getWh_cd())){
            sql.append(" AND T.WH_CD= ? ");
            params.add(args.getWh_cd());
        }
        if(StringUtil.isNotEmpty(args.getMa_cd())){
            sql.append(" AND T.MA_CD= ? ");
            params.add(args.getMa_cd());
        }
        if(StringUtil.isNotEmpty(args.getMa_pc())){
            sql.append(" AND T.MA_PC like ? ");
            params.add("%"+args.getMa_pc()+"%");
        }
        if(StringUtil.isNotEmpty(args.getBinnum())){
            sql.append(" AND T.BINNUM like ? ");
            params.add("%"+args.getBinnum()+"%");
        }
        sql.append(" ORDER BY T.TS DESC ");
        sql.append(" ) T LEFT JOIN WR_MATERIAL_B WMB ON T.MA_CD=WMB.MA_CD ");
        sql.append(" LEFT JOIN WR_WH_B WH ON T.WH_CD=WH.WH_CD ");
        sql.append(" ) T WHERE 1=1  ");
        if(StringUtil.isNotEmpty(args.getMa_nm())){
            sql.append(" AND T.MA_NM like ? ");
            params.add("%"+args.getMa_nm()+"%");
        }
        if(StringUtil.isNotEmpty(args.getOrg_cd())){
            sql.append(" AND T.WORG_CD= ? ");
            params.add(args.getOrg_cd());
        }
        if(StringUtil.isNotEmpty(args.getType())){
            sql.append(" AND T.MA_TYPE_ID= ? ");
            params.add(args.getType());
        }
        if(StringUtil.isNotEmpty(args.getMa_status())){
            sql.append(" AND T.STATUS= ? ");
            params.add(args.getMa_status());
        }
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN WR_MA_INVENTORY WMI ON WMI.WH_CD=T.WH_CD AND WMI.MA_CD=T.MA_CD ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD ON TSD.ID=WMI.ORG_CD ");
        sql.append(" ORDER BY T.TS DESC ");

        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }

    @Override
    public EasyUiPage getListWzCkPcBinInfoByParamsNew(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception {
        List params = new ArrayList();
        StringBuffer sql =new StringBuffer("SELECT A.*,BB.WH_NM,BB.LOC,YY.NAME FROM (SELECT B.*,Y.WH_CD,Y.STD_QUAN,Y.ORG_CD,Y.REAL_QUAN,Y.BINNUM FROM WR_MATERIAL_B B LEFT JOIN WR_MA_INVENTORY Y ON B.MA_CD = Y.MA_CD) A LEFT JOIN T_SYS_DICTIONARY YY ON A.ORG_CD = YY.ID LEFT JOIN WR_WH_B BB ON A.WH_CD = BB.WH_CD WHERE 1=1 ");
        if(StringUtil.isNotEmpty(args.getOrg_cd())){
            sql.append(" AND A.ORG_CD = ?");
            params.add(args.getOrg_cd());
        }else if(StringUtil.isNotEmpty(args.getWh_cd())){
            sql.append(" AND A.WH_CD = ?");
            params.add(args.getWh_cd());
        }else if(StringUtil.isNotEmpty(args.getMa_status())){
            sql.append(" AND A.STATUS = ?");
            params.add(args.getMa_status());
        }else if(StringUtil.isNotEmpty(args.getType())){
            sql.append(" AND A.MA_TYPE_ID = ? ");
            params.add(args.getType());
        }
        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object getWzCkPcBinInfoById(FxWzArgModel args) {
        List<Object> params= new ArrayList<Object>();//hh24:mi:ss
        StringBuffer sql= new StringBuffer();
        sql.append(" SELECT T.*,WMI.ORG_CD,WMI.STD_QUAN,WMI.REAL_QUAN AS SREAL_QUAN,TSD.NAME ORG_CD_NAME,WMT.MA_TYPE_NAME  FROM ( ");
        sql.append(" SELECT T.* FROM (");
        sql.append(" SELECT T.*,WMB.MA_NM,WMB.MODEL,WMB.MU,WMB.STD_YEAR,WMB.GS_STD_QUAN,WMB.SL_STD_QUAN,WMB.MA_TYPE_ID,WMB.STATUS ");//AS WMBSTATUS
        sql.append(" ,WH.WH_NM,WH.LOC,WH.ORG_CD AS WORG_CD FROM ( ");
        sql.append(" SELECT WH_CD, MA_CD, MA_PC, BINNUM, REAL_QUAN, TO_CHAR(TS,'yyyy-mm-dd') AS TS , NT FROM WR_MA_QUAN_B T WHERE 1=1  ");
        if(StringUtil.isNotEmpty(args.getWh_cd())){
            sql.append(" AND T.WH_CD= ? ");
            params.add(args.getWh_cd());
        }
        if(StringUtil.isNotEmpty(args.getMa_cd())){
            sql.append(" AND T.MA_CD= ? ");
            params.add(args.getMa_cd());
        }
        if(StringUtil.isNotEmpty(args.getMa_pc())){
            sql.append(" AND T.MA_PC= ?  ");
            params.add(args.getMa_pc());
        }
        if(StringUtil.isNotEmpty(args.getBinnum())){
            sql.append(" AND T.BINNUM= ?  ");
            params.add(args.getBinnum());
        }
        sql.append(" ) T LEFT JOIN WR_MATERIAL_B WMB ON T.MA_CD=WMB.MA_CD ");
        sql.append(" LEFT JOIN WR_WH_B WH ON T.WH_CD=WH.WH_CD ");
        sql.append(" ) T WHERE 1=1  ");
        sql.append(" ) T  ");
        sql.append(" LEFT JOIN WR_MA_INVENTORY WMI ON WMI.WH_CD=T.WH_CD AND WMI.MA_CD=T.MA_CD ");
        sql.append(" LEFT JOIN T_SYS_DICTIONARY TSD ON TSD.ID=WMI.ORG_CD ");
        sql.append(" LEFT JOIN WR_MATERIAL_TYPE WMT ON T.MA_TYPE_ID=WMT.MA_TYPE_ID ");

        return this.findBySqlWithMap(sql.toString(),params.toArray());
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        if(StringUtil.isNotEmpty(ids)){
            String[] id = ids.split(",");
            for (int i = 0; i < id.length; i++) {
                removeById(WrMaterialB.class,id[i]);
            }
        }
        return true;
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        if(StringUtil.isNotEmpty(dataStr)){
            WrMaterialB model = JsonUtil.json2Object(dataStr,WrMaterialB.class);
            if(!StringUtil.isNotEmpty(model.getMa_cd())) {
                model.setMa_cd(DseSysCommonUtil.getNewId().toString());
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
