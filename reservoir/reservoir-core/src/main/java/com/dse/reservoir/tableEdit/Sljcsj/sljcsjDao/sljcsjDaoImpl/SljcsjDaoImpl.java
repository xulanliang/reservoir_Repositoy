package com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.sljcsjDaoImpl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.pojo.vo.Sljcsj;
import com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.SljcsjDao;
import com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.entity.DcEntity;
import com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.entity.DccjEntity;
import com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.entity.JcdmCdEntity;
import com.dse.reservoir.tableEdit.Sljcsj.sljcsjDao.entity.SljcsjEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yuan_feng on 2017/9/6.
 */
@Repository("sljcsjDao")
public class SljcsjDaoImpl extends BaseDao implements SljcsjDao{
//    渗流监测数据表
    @Override
    public EasyUiPage getSljcsjList(Sljcsj slj,EasyUiPage easyUiPage) {
        ArrayList<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append("select stcd,to_char(tm,'yyyy-MM-dd') as tm,origdata,calcdata,jcl,transst,otdesc,gattype,nt from WR_WEIO_B where 1=1 ");
       if((StringUtil.isNotEmpty(slj.getStcd()))){
           sql.append(" and stcd like ? ");
           params.add("%"+slj.getStcd()+"%");
       }
        if((StringUtil.isNotEmpty(slj.getTm()))){
            sql.append(" and to_char(tm,'yyyy-MM-dd')= ?  ");
            params.add(slj.getTm());
        }
        if((StringUtil.isNotEmpty(slj.getGattype()))){
            sql.append(" and gattype=? ");
            params.add(slj.getGattype());
        }
        sql.append(" ORDER BY TM DESC");
        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object deleteSljcsjDao(Sljcsj slj) {
        String sql="DELETE FROM WR_WEIO_B WHERE 1=1 AND  STCD ='"+slj.getStcd()+"' and to_char(TM,'yyyy-MM-dd')='"+slj.getTm()+"'";
        this.updateBySql(sql);
        return true;
    }

    @Override
    public Object saveSljcsjDao(String  dataStr) {
        if (StringUtil.isNotEmpty(dataStr)) {
            SljcsjEntity sljcEntity = JsonUtil.json2Object(dataStr, SljcsjEntity.class);
            Date date=new Date();
            sljcEntity.setTs(date);
            this.saveOrUpdate(sljcEntity);
        }
        return true;
    }
    //  渡槽基本信息表
    @Override
    public EasyUiPage getDcListDao(String dcCd,String dcNm, EasyUiPage easyUiPage) {
        ArrayList<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append("select * from WR_DC_M where 1=1 ");
        if((StringUtil.isNotEmpty(dcCd))){
            sql.append(" and DC_CD=? ");
            params.add(dcCd);
        }
        if(StringUtil.isNotEmpty(dcNm)){
            sql.append(" and DC_NM like ? ");
            params.add("%"+dcNm+"%");
        }
        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }

    @Override
    public Object deleteDcByIdDao(String id) {
        String sql="DELETE FROM WR_DC_M  WHERE DC_CD ='"+id+"'";
        this.updateBySql(sql);
        return true;
    }

    @Override
    public Object savevDcDao(String dataStr) {
        if (StringUtil.isNotEmpty(dataStr)) {
            DcEntity dcEntity = JsonUtil.json2Object(dataStr, DcEntity.class);
            dcEntity.setTS(new Date());
            this.saveOrUpdate(dcEntity);
        }
        return true;
    }
//   渡槽沉降监测信息表
    @Override
    public EasyUiPage getDccjListDao(Sljcsj slj, EasyUiPage easyUiPage) {
        ArrayList<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append("select stcd,to_char(tm,'yyyy-MM-dd hh24:mi:ss') as tm,origdata,calcdata,jcl,transst,otdesc,gattype,nt from WR_CSFT_B where 1=1 ");
        if((StringUtil.isNotEmpty(slj.getStcd()))){
            sql.append(" and stcd like ? ");
            params.add("%"+slj.getStcd()+"%");
        }
        if((StringUtil.isNotEmpty(slj.getTm()))){
            sql.append(" and to_char(tm,'yyyy-MM-dd hh24:mi:ss')= ?  ");
            params.add(slj.getTm());
        }
        if((StringUtil.isNotEmpty(slj.getGattype()))){
            sql.append(" and gattype=? ");
            params.add(slj.getGattype());
        }
        sql.append(" ORDER BY TM DESC");
        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }


    @Override
    public Object deleteDccjDao(Sljcsj slj) {
        String sql = "DELETE FROM WR_CSFT_B WHERE 1=1 AND  STCD ='" + slj.getStcd() + "' and to_char(TM,'yyyy-MM-dd hh24:mi:ss')='" + slj.getTm() + "'";
        this.updateBySql(sql);
        return true;
    }
    @Override
        public Object saveDccjDao(String  dataStr){
            if (StringUtil.isNotEmpty(dataStr)) {
                DccjEntity dccjEntity = JsonUtil.json2Object(dataStr, DccjEntity.class);
                dccjEntity.setTs(new Date());
                this.saveOrUpdate(dccjEntity);
            }
            return true;
        }
    //监测断面与测点映射表 测点：WR_STAT_M 工程：WR_PROJ_B
    public EasyUiPage getJcdmCdDao(String id, String name,EasyUiPage easyUiPage) {
        ArrayList<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append("select a.wr_rb_id,a.stcd, b.stnm ,a.rb_cd,c.rb_nm,a.nt from  WR_ST_RB_MAP a  left join WR_STAT_M b on a.STCD=b.STCD left join WR_RB_M c on a.RB_CD=c.RB_CD   where 1=1 ");
        if(StringUtil.isNotEmpty(id)){
            sql.append(" and a.WR_RB_ID = ?");
            params.add(id);
        }
        if(StringUtil.isNotEmpty(name)){
            sql.append(" and a.stcd like ?  or b.stnm like ?  or c.rb_nm like ?  or a.rb_cd like ? ");
            params.add("%"+name+"%");
            params.add("%"+name+"%");
            params.add("%"+name+"%");
            params.add("%"+name+"%");

        }
        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }


    @Override
    public Object deleteJcdmCdDao(String id) {
        String sql = "DELETE FROM WR_ST_RB_MAP WHERE  WR_RB_ID ='" + id + "'";
        this.updateBySql(sql);
        return true;
    }
    @Override
    public Object saveJcdmCdDao(String  dataStr){
        if (StringUtil.isNotEmpty(dataStr)) {
            JcdmCdEntity jcdmCdEntity = JsonUtil.json2Object(dataStr, JcdmCdEntity.class);
            this.saveOrUpdate(jcdmCdEntity);
        }
        return true;
    }

}
