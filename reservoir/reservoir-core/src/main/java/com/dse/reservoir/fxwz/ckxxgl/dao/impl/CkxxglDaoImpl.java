package com.dse.reservoir.fxwz.ckxxgl.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.ckxxgl.pojo.WrWhB;
import com.dse.reservoir.fxwz.ckxxgl.dao.CkxxglDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2017-8-2.
 */
@Repository("ckxxglDao")
public class CkxxglDaoImpl extends BaseDao<WrWhB,String> implements CkxxglDao {

    @Override
    public Object getOrg() throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT * FROM T_SYS_DICTIONARY WHERE PID = (SELECT ID FROM T_SYS_DICTIONARY WHERE CODE = 'SSGLBM')";

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getXcdListBycode(String depID,String objID) throws Exception {
        String sql = "SELECT * FROM WR_CHK_OBJECT t WHERE t.ck_item =1";
        List params = new ArrayList();
        if(StringUtil.isNotEmpty(depID)){
            sql=sql+" AND T.CK_ORG=?";
            params.add(depID);
        }
        if(StringUtil.isNotEmpty(objID)){
            sql=sql+" AND T.CK_OBJECT=?";
            params.add(objID);
        }
        sql=sql+" ORDER BY T.SEQ ASC";

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getGetType() throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT * FROM T_SYS_DICTIONARY WHERE PID = (SELECT ID FROM T_SYS_DICTIONARY WHERE CODE = 'cjfs')";

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getJclx() throws Exception {
        String sql = "SELECT * FROM T_SYS_DICTIONARY WHERE PID = (SELECT ID FROM T_SYS_DICTIONARY WHERE CODE = 'JCLX')";

        return findBySqlWithMap(sql);
    }

    @Override
    public Object getProject() throws Exception {
        String sql = "select * from WR_PROJ_B b where b.PROJ_CD in(1,2,3) ";
        return this.findBySqlWithMap(sql);
    }

    @Override
    public Object getMDNAME(String PROJ_CD) throws Exception {
        String str = "select * from WR_MONITOR_B b where b.PROJ_CD =?";
        return this.findBySqlWithMap(str,PROJ_CD);
    }

    @Override
    public Object getCdclzt() throws Exception {
        String sql = "SELECT * FROM T_SYS_DICTIONARY WHERE PID = (SELECT ID FROM T_SYS_DICTIONARY WHERE CODE = 'cdclzt')";
        return findBySqlWithMap(sql);
    }

    @Override
    public EasyUiPage getListInfoByParams(WrWhB args, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT B.*,T.NAME,decode(B.WH_STATUS,'0','活动','1','暂挂','2','停止使用') WH_STATUS_NAME  FROM WR_WH_B B LEFT JOIN T_SYS_DICTIONARY T ON B.ORG_CD = T.ID WHERE 1=1";

        if(StringUtil.isNotEmpty(args.getWh_nm())){
            sql += " AND B.WH_NM LIKE ? ";
            params.add("%"+args.getWh_nm()+"%");
        }
        if(StringUtil.isNotEmpty(args.getOrg_cd())){
            sql += " AND B.ORG_CD = ? ";
            params.add(args.getOrg_cd());
        }
        if(StringUtil.isNotEmpty(args.getWh_status())){
            sql += " AND B.WH_STATUS = ? ";
            params.add(args.getWh_status());
        }

        return findEasyUiPageBySql(sql, easyUiPage, params.toArray());
    }

    @Override
    public Object getListDataByParams(WrWhB args) throws Exception {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT B.*  FROM WR_WH_B B WHERE 1=1 ";

        if(StringUtil.isNotEmpty(args.getWh_nm())){
            sql += " AND B.WH_NM LIKE ? ";
            params.add("%"+args.getWh_nm()+"%");
        }
        if(StringUtil.isNotEmpty(args.getOrg_cd())){
            sql += " AND B.ORG_CD = ? ";
            params.add(args.getOrg_cd());
        }
        if(StringUtil.isNotEmpty(args.getWh_status())){
            sql += " AND B.WH_STATUS = ? ";
            params.add(args.getWh_status());
        }

        return this.findBySql(sql, params.toArray());
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        if(StringUtil.isNotEmpty(ids)){
            String[] id = ids.split(",");
            for (int i = 0; i < id.length; i++) {
                removeById(WrWhB.class,id[i]);
            }
        }
        return true;
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        if(StringUtil.isNotEmpty(dataStr)){
            WrWhB model = JsonUtil.json2Object(dataStr,WrWhB.class);
            if(!StringUtil.isNotEmpty(model.getWh_cd())) {
                model.setWh_cd(DseSysCommonUtil.getNewId().toString());
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
