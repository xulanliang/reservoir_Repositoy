package com.dse.reservoir.tableEdit.cdgclx.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.tableEdit.cdgclx.dao.CdgclxDao;
import com.dse.reservoir.tableEdit.cdgclx.dao.entity.HgEntity;
import com.dse.reservoir.tableEdit.cdgclx.dao.entity.SyjcEntity;
import com.dse.reservoir.tableEdit.cdgclx.dao.vo.CdgclxVo;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by yuan_feng on 2017/8/21.
 */
@Repository("cdgclxDao")
public class CdgclxDaoImpl extends BaseDao implements CdgclxDao {
    //    测点工程类型映射
    @Override
    public EasyUiPage getCdgclxList(String ITEM_NM, String MON_TP, String IS_AUTO, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList<Object> params = new ArrayList<Object>();
//        str.append("select * from WR_ST_PROJ_TYPE_MAP where 1=1");
//        str.append("select d.wr_proj_id,d.stnm as stcd,d.proj_nm as proj_cd,\n" +
//                "decode(d.st_tp,'1','渗压','2','渗流','3','水平位移','4','垂直位移','5','水位','6','雨量','7','气温<含气压>','8','深层位移','9','渡槽沉降') ST_TP,d.nt as nt\n" +
//                "from( select * from WR_ST_PROJ_TYPE_MAP a left join WR_STAT_M b on a.stcd=b.stcd left join WR_PROJ_B c on a.proj_cd=c.proj_cd) d where 1=1");
        str.append("select a.WR_PROJ_ID,a.STCD as STCD,b.STNM as STNM,a.PROJ_CD as PROJ_CD,c.proj_nm as PROJ_NAME,a.ST_TP as ST_TP, a.NT as NT " +
                "from WR_ST_PROJ_TYPE_MAP a left join WR_STAT_M b on a.stcd=b.stcd left join WR_PROJ_B c on a.proj_cd=c.proj_cd " +
                "where 1=1");
        if (StringUtil.isNotEmpty(ITEM_NM)) {
            str.append(" and  c.proj_nm like ?");
            params.add("%" + ITEM_NM + "%");
        }
        if (StringUtil.isNotEmpty(MON_TP)) {
            str.append(" and a.ST_TP  = ?");
            params.add(MON_TP);
        }
        if (StringUtil.isNotEmpty(IS_AUTO)) {
            str.append(" and  a.WR_PROJ_ID = ?");
            params.add(IS_AUTO);
        }
        return findEasyUiPageBySql(str.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object deleteCdgcByIds(String ids) {
        ArrayList<Object> params = new ArrayList<Object>();
        if (StringUtil.isNotEmpty(ids)) {
            String[] id = ids.split(",");
            StringBuffer str = new StringBuffer();
            str.append("DELETE FROM WR_ST_PROJ_TYPE_MAP WHERE 1=1 AND  WR_PROJ_ID IN(");
            for (int i = 0; i < id.length; i++) {
                if (i + 1 == id.length) {
                    str.append("?");
                    params.add(id[i]);
                } else {
                    str.append(",?");
                    params.add(id[i]);
                }
            }
            str.append(")");
            this.updateBySql(str.toString(), params.toArray());
        }
        return true;
    }

    @Override
    public Object saveOrUpdateCdgcListDao(String dataStr) {
        if (StringUtil.isNotEmpty(dataStr)) {
            CdgclxVo cdgclxVo = JsonUtil.json2Object(dataStr, CdgclxVo.class);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("update WR_ST_PROJ_TYPE_MAP set ");
            int num = 0;
            if (StringUtil.isNotEmpty(String.valueOf(cdgclxVo.getST_TP())) && !String.valueOf(cdgclxVo.getST_TP()).equals("null")) {
                //测点类型
                stringBuffer.append(" ST_TP='" + cdgclxVo.getST_TP() + "'");
                num = num + 1;
            }
                if (num != 0) {
                    //备注
                    stringBuffer.append(" ,NT='" + cdgclxVo.getNT() + "'");
                } else {
                    stringBuffer.append(" NT='" + cdgclxVo.getNT() + "'");
                }
            stringBuffer.append(" where WR_PROJ_ID=" + cdgclxVo.getWR_PROJ_ID());
            //避免主键冲突
            this.updateBySql(stringBuffer.toString());
        }
        return true;
    }

    //   涵管基本信息
    @Override
    public EasyUiPage getHgList(String HG_NM, String HG_DESC, String ids, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList<Object> params = new ArrayList<Object>();
        str.append("select * from WR_HG_M  where 1=1");
        if (StringUtil.isNotEmpty(HG_NM)) {
            str.append(" and HG_NM like ?");
            params.add("%" + HG_NM + "%");
        }
        if (StringUtil.isNotEmpty(HG_DESC)) {
            str.append(" and HG_DESC = ?");
            params.add(HG_DESC);
        }
        if (StringUtil.isNotEmpty(ids)) {
            str.append(" and HG_CD = ?");
            params.add(ids);
        }
        return findEasyUiPageBySql(str.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object deleteHgByIds(String ids) {
        ArrayList<Object> params = new ArrayList<Object>();
        if (StringUtil.isNotEmpty(ids)) {
            String[] id = ids.split(",");
            StringBuffer str = new StringBuffer();
            str.append("DELETE FROM WR_HG_M WHERE 1=1 AND  HG_CD IN(");
            for (int i = 0; i < id.length; i++) {
                if (i + 1 == id.length) {
                    str.append("?");
                    params.add(id[i]);
                } else {
                    str.append(",?");
                    params.add(id[i]);
                }
            }
            str.append(")");
            this.updateBySql(str.toString(), params.toArray());
        }
        return true;
    }

    @Override
    public Object saveOrUpdateHgList(String dataStr) {
        if (StringUtil.isNotEmpty(dataStr)) {
            HgEntity hgEntity =JsonUtil.json2Object(dataStr, HgEntity.class);
            Date date=new Date();
            hgEntity.setTS(date);
            this.saveOrUpdate(hgEntity);
        }
        return true;
    }

    //    渗压监测数据
    @Override
    public EasyUiPage getSyjc(String ids, String tm, String getType, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList<Object> params = new ArrayList<Object>();
        str.append("select B.*,M.STNM from WR_HYDO_B B LEFT JOIN WR_STAT_M M ON B.STCD=M.STCD  where 1=1");
        if (StringUtil.isNotEmpty(ids)) {
            str.append(" and STCD like ?");
            params.add("%" + ids + "%");
        }
        if (StringUtil.isNotEmpty(tm)) {
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long times=Long.parseLong(tm);
            String d = format.format(times);
            str.append(" and to_char(TM,'yyyy-MM-dd hh24:mi:ss')= ?");
            params.add(d);
        }
        if (StringUtil.isNotEmpty(getType)) {   //采集方式
            str.append(" and GETTYPE = ?");
            params.add(getType);
        }
        str.append(" ORDER BY B.TM DESC");
        return findEasyUiPageBySql(str.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object deleteSyjcByIds(String ids ,String tm) {
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long times=Long.parseLong(tm);
        String d = format.format(times);
        if (StringUtil.isNotEmpty(ids)) {
            StringBuffer str = new StringBuffer();
            String sql="DELETE FROM WR_HYDO_B WHERE 1=1 AND  STCD ='"+ids+"' and to_char(TM,'yyyy-MM-dd hh24:mi:ss')='"+d+"'";
//            str.append("DELETE FROM WR_HYDO_B WHERE 1=1 AND  STCD ='"+ids+"'");
//            str.append(" and to_char(TM,'yyyy-MM-dd hh24:mi:ss')="+"'"+date+"'");
            this.updateBySql(sql);
        }
        return true;
    }
    @Override
    public Object saveOrUpdateSyjc(String dataStr) {
        if (StringUtil.isNotEmpty(dataStr)) {
            SyjcEntity syjcEntity =JsonUtil.json2Object(dataStr, SyjcEntity.class);
            Date date=new Date();
            syjcEntity.setTs(date);
            this.saveOrUpdate(syjcEntity);
        }
        return true;
    }
}
