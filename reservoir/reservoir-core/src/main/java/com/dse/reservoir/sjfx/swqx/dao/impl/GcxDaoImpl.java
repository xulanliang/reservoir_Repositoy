package com.dse.reservoir.sjfx.swqx.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sjfx.pojo.entity.GcxEntity;
import com.dse.reservoir.sjfx.swqx.dao.GcxDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于获取过程线数据信息
 * Created by pengzx on 2017/6/2.
 *
 * 测点类型(1:渗压 2 渗流 3 水平位移4垂直位移5水位6雨量7气温<含气压>8深层位移9渡槽沉降)
 *
 */
@Repository("gcxDao")
public class GcxDaoImpl extends BaseDao implements GcxDao {

    @Override
    public Object getStRsvrrChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();

        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.rz,2) rz,t.inq,t.w,t.blrz,t.otq,t.rwchrcd,t.rwptn,t.inqdr,t.gattype from (  " );
        sqlsb.append(" select t.stcd,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.rz,t.inq,t.w,t.blrz,t.otq,t.rwchrcd,t.rwptn,t.inqdr,t.gattype from st_rsvr_r t where 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append("  AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }
        //5水位
        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('5') and wsm.proj_cd in  (    ");
            sqlsb.append(" select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd  ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }
        //5水位
        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('5') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('5') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }

        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }

        sqlsb.append(" order by stcd, TM asc ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");

        return findBySqlWithMap(sqlsb.toString(),params);

    }

    /**
     * 查询 水库水情表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object getStRsvrrChartDataMaxMin(GcxEntity gcxArgs, String stm, String etm) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();

        return null;
    }

    @Override
    public Object getStPptnrChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,tm,round(t.drp,2) drp,t.intv,t.pdr,t.dyp,t.wth from ( ");
        sqlsb.append(" select t.stcd,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.drp,t.intv,t.pdr,t.dyp,t.wth from St_Pptn_r t where 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('6') and wsm.proj_cd in  ( ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('6') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('6') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }

        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }
        sqlsb.append(" order by stcd, TM asc ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd , TM asc  ");

        return findBySqlWithMap(sqlsb.toString(),params);
    }

    @Override
    public Object getStTmprChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,tm,round(t.atmp,2) atmp,round(catmp,2) catmp,round(t.airp,2) airp,round(cairp,2) cairp from ( ");
        sqlsb.append(" select t.stcd,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.atmp,nvl(t.catmp,t.atmp) catmp,t.airp,nvl(t.cairp,airp) cairp from ST_TMP_R t  WHERE 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }
        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('7') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('7') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('7') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }
        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }
        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append( " AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }
        sqlsb.append(" order by stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");

        return findBySqlWithMap(sqlsb.toString(),params);
    }

    /**
     * 查询 渗压过程线 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年05月27日
     */
    public Object  getShenYaGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.calcdata,2) calcdata from ( ");
        sqlsb.append(" select t.stcd,t.tm,t.calcdata from ( select t.stcd,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.origdata,nvl(t.calcdata,origdata) calcdata,t.jcl,t.nt from wr_hydo_b t where 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('1') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrprojb_proj_cd())){
            sqlsb.append(" AND t.stcd in (    ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('1') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("wrprojb_proj_cd", gcxArgs.getWrprojb_proj_cd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
           // sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('1') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('1') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }
        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }
        sqlsb.append(" ) t group by t.stcd,t.tm,t.calcdata order by t.stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
        return findBySqlWithMap(sqlsb.toString(),params);
    }

    /**
     * 查询 渗压过程线 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年07月21日
     */
    public Object  getShenLiuGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception{
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.calcdata,2) calcdata from ( ");
        sqlsb.append(" select t.stcd,t.tm,t.calcdata from ( select t.stcd,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.origdata,nvl(t.calcdata,origdata) calcdata from WR_WEIO_B t where 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('2') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrprojb_proj_cd())){
            sqlsb.append(" AND t.stcd in (    ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('2') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("wrprojb_proj_cd", gcxArgs.getWrprojb_proj_cd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            // sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('2') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('2') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }
        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }
        sqlsb.append(" ) t group by t.stcd,t.tm,t.calcdata order by t.stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
        return findBySqlWithMap(sqlsb.toString(),params);

    }


    /**
     * 查询 水平位移监测数据表 监测信息数据
     *
     * @param  gcxArgs
     * @param
     * @param
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getSpwyZxfbtGcxChartData(GcxEntity gcxArgs, String year, String endYear,String season) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.fshift,2) fshift from ( ");
        sqlsb.append(" select t.stcd,t.tm,t.fshift from ( select t.stcd,t.qs,TO_CHAR(t.tm,'YYYY')||'年' tm,t.lshift,t.fshift,t.nt,t.type from wr_hsft_b t where 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('3') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('3') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('3') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrprojb_proj_cd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('3') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('3') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("wrprojb_proj_cd", gcxArgs.getWrprojb_proj_cd());
        }

        String staStr ="";
        String endStr ="";
        if(season.equals("1")){
            staStr="-01-01";
            endStr="-03-31";
        }else if(season.equals("2")){
            staStr="-04-01";
            endStr="-06-31";
        }else if(season.equals("3")){
            staStr="-07-01";
            endStr="-09-31";
        }else if(season.equals("4")){
            staStr="-10-01";
            endStr="-12-31";
        }
        int yearSta = Integer.valueOf(year);
        int yearEnd = Integer.valueOf(endYear);
        int index = (yearEnd - yearSta)+1;
        sqlsb.append("  AND ( 1=1");
        for(int i=0;i<index;i++){
            if(i==0){
                sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
                sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
                params.put("stm", year+staStr);
                params.put("etm", year+endStr);
            }else{
                sqlsb.append(" OR( TO_CHAR(TM,'YYYY-MM-DD') >= (:stm"+i+") AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm"+i+") ) ");
                params.put("stm"+i, String.valueOf(yearSta+i)+staStr);
                params.put("etm"+i, String.valueOf(yearSta+i)+endStr);
            }
        }

//        if(StringUtil.isNotEmpty(stm)){
//            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
//            params.put("stm", stm);
//        }
//        if(StringUtil.isNotEmpty(etm)){
//            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
//            params.put("etm", etm);
//        }
        sqlsb.append(" )) t group by t.stcd,t.tm,t.fshift order by t.stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
        return findBySqlWithMap(sqlsb.toString(),params);
    }

    /**
     * 查询 水平位移监测数据表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getSpwyGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.fshift,2) fshift from ( ");
        sqlsb.append(" select t.stcd,t.tm,t.fshift from ( select t.stcd,t.qs,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.lshift,t.fshift,t.nt,t.type from wr_hsft_b t where 1=1 ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('3') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrprojb_proj_cd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('3') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('3') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("wrprojb_proj_cd", gcxArgs.getWrprojb_proj_cd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('3') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('3') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }
        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }
        sqlsb.append(" ) t group by t.stcd,t.tm,t.fshift order by t.stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
        return findBySqlWithMap(sqlsb.toString(),params);
    }


    /**
     * 查询  垂直位移监测信息表 监测信息数据
     *
     * @param  gcxArgs
     * @param       开始时间
     * @param       结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getCzwyZxfbtGcxChartData(GcxEntity gcxArgs, String year, String endYear, String season) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.calcdata,2) calcdata from ( ");
        sqlsb.append(" select t.stcd,t.tm,t.calcdata from ( select t.stcd,TO_CHAR(t.tm,'YYYY')||'年' tm,t.origdata,nvl(t.calcdata,t.origdata) calcdata from wr_vsft_b t where 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('4') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrprojb_proj_cd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('4') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('4') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("wrprojb_proj_cd", gcxArgs.getWrprojb_proj_cd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('4') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('4') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        String staStr ="";
        String endStr ="";
        if(season.equals("1")){
            staStr="-01-01";
            endStr="-03-31";
        }else if(season.equals("2")){
            staStr="-04-01";
            endStr="-06-31";
        }else if(season.equals("3")){
            staStr="-07-01";
            endStr="-09-31";
        }else if(season.equals("4")){
            staStr="-10-01";
            endStr="-12-31";
        }
        int yearSta = Integer.valueOf(year);
        int yearEnd = Integer.valueOf(endYear);
        int index = (yearEnd - yearSta)+1;
        sqlsb.append("  AND ( 1=1");
        for(int i=0;i<index;i++){
            if(i==0){
                sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
                sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
                params.put("stm", year+staStr);
                params.put("etm", year+endStr);
            }else{
                sqlsb.append(" OR( TO_CHAR(TM,'YYYY-MM-DD') >= (:stm"+i+") AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm"+i+") ) ");
                params.put("stm"+i, String.valueOf(yearSta+i)+staStr);
                params.put("etm"+i, String.valueOf(yearSta+i)+endStr);
            }
        }


//        if(StringUtil.isNotEmpty(stm)){
//            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
//            params.put("stm", stm);
//        }
//        if(StringUtil.isNotEmpty(etm)){
//            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
//            params.put("etm", etm);
//        }
        sqlsb.append(" )) t group by t.stcd,t.tm,t.calcdata order by t.stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
//        sqlsb.append(" )) t group by t.stcd,t.tm,t.fshift order by t.stcd, TM asc  ");
//        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
        return findBySqlWithMap(sqlsb.toString(),params);
    }

    /**
     * 查询 垂直位移监测信息表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询到的结果集
     * @author pengzx
     * @date 2017年06月17日
     */
    public Object  getCzwyGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.calcdata,2) calcdata from ( ");
        sqlsb.append(" select t.stcd,t.tm,t.calcdata from ( select t.stcd,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.origdata,nvl(t.calcdata,t.origdata) calcdata from wr_vsft_b t where 1=1 ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('4') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrprojb_proj_cd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('4') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('4') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("wrprojb_proj_cd", gcxArgs.getWrprojb_proj_cd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('4') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('4') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }
        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }
        sqlsb.append(" ) t group by t.stcd,t.tm,t.calcdata order by t.stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
        return findBySqlWithMap(sqlsb.toString(),params);
    }

    /**
     * 查询 WR_SW_R 水位表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询 WR_SW_R 水位表 结果集
     * @author pengzx
     * @date 2017年06月19日
     */
    public Object  getWrswrGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.z,2) z from ( ");
        sqlsb.append(" select t.stcd,t.tm,t.z from ( select t.stcd,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.z,t.bd,t.rmsy from WR_SW_R t where 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('5') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrprojb_proj_cd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('5') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('5') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("wrprojb_proj_cd", gcxArgs.getWrprojb_proj_cd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('5') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('5') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }
        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }
        sqlsb.append(" ) t group by t.stcd,t.tm,t.z order by t.stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
        return findBySqlWithMap(sqlsb.toString(),params);
    }

    /**
     * 查询 WR_MSFT_B 多点位移监测信息表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询 WR_MSFT_B 多点位移监测信息表 结果集
     * @author pengzx
     * @date 2017年06月20日
     */
    public Object  getWrmsftbGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.calcdata,2) calcdata from ( ");
        sqlsb.append(" select t.stcd,t.tm,t.calcdata from ( select t.stcd,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.origdata,nvl(t.calcdata,t.origdata) calcdata from WR_MSFT_B t where 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('8') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrprojb_proj_cd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('8') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('8') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("wrprojb_proj_cd", gcxArgs.getWrprojb_proj_cd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('8') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('8') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }
        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }
        sqlsb.append(" ) t group by t.stcd,t.tm,t.calcdata order by t.stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
        return findBySqlWithMap(sqlsb.toString(),params);
    }

    /**
     * 查询 WR_CSFT_B 渡槽沉降监测信息表 监测信息数据
     *
     * @param  gcxArgs
     * @param stm      开始时间
     * @param etm      结束时间
     * @return List<Map>:查询 WR_CSFT_B 渡槽沉降监测信息表 结果集
     * @author pengzx
     * @date 2017年06月20日
     */
    public Object  getWrcsftbGcxChartData(GcxEntity gcxArgs, String stm, String etm) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        StringBuffer sqlsb=new StringBuffer();
        sqlsb.append(" select w.stnm stcd,t.tm,round(t.calcdata,2) calcdata from ( ");
        sqlsb.append(" select t.stcd,t.tm,t.calcdata from ( select t.stcd,TO_CHAR(t.tm,'YYYY/MM/DD') tm,t.origdata,nvl(t.calcdata,t.origdata) calcdata from WR_CSFT_B t where 1=1  ");
        sqlsb.append("  and exists ( select wsm.stcd from wr_stat_m wsm where wsm.isjidian='0' and t.stcd=wsm.stcd ) ");

        if(StringUtil.isNotEmpty(gcxArgs.getStcd())){
            sqlsb.append(" AND t.stcd=:stcd ");
            params.put("stcd", gcxArgs.getStcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrrbm_rbcd())){
            sqlsb.append(" AND t.stcd in ( ");
            /*
            sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('9') and wsm.proj_cd in  (  ");
            sqlsb.append("  select wsm.proj_cd from WR_STAT_M wsm where wsm.proj_cd in  ( SELECT wpb.proj_cd FROM WR_PROJ_B wpb START WITH wpb.proj_cd=(select nvl(pct.proj_cd_two,pct.proj_cd_one) proj_cd_two  from wr_rb_m pct where pct.rb_cd=:wrrbm_rbcd ) CONNECT BY PRIOR wpb.proj_cd=wpb.pid ) ");
            sqlsb.append(" )  ");
            */
            sqlsb.append(" select wsrm.stcd from wr_st_rb_map wsrm where wsrm.rb_cd=:wrrbm_rbcd  ");
            sqlsb.append(" )  ");
            params.put("wrrbm_rbcd", gcxArgs.getWrrbm_rbcd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getWrprojb_proj_cd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('9') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('9') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:wrprojb_proj_cd or wpb.pid=:wrprojb_proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("wrprojb_proj_cd", gcxArgs.getWrprojb_proj_cd());
        }

        if(StringUtil.isNotEmpty(gcxArgs.getProjcd())){
            sqlsb.append(" AND t.stcd in (    ");
            //sqlsb.append(" select wsm.stcd from WR_STAT_M wsm where wsm.st_tp in ('9') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" select wsm.stcd from wr_st_proj_type_map wsm where wsm.st_tp in ('9') and wsm.proj_cd in ( select wpb.proj_cd from wr_proj_b wpb where ( wpb.proj_cd=:proj_cd or wpb.pid=:proj_cd )) ");
            sqlsb.append(" )  ");
            params.put("proj_cd", gcxArgs.getProjcd());
        }

        if(StringUtil.isNotEmpty(stm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') >= (:stm) ");
            params.put("stm", stm);
        }
        if(StringUtil.isNotEmpty(etm)){
            sqlsb.append(" AND TO_CHAR(TM,'YYYY-MM-DD') <= (:etm) ");
            params.put("etm", etm);
        }
        sqlsb.append(" ) t group by t.stcd,t.tm,t.calcdata order by t.stcd, TM asc  ");
        sqlsb.append(" ) t left join wr_stat_m w on t.stcd=w.stcd  order by t.stcd, TM asc  ");
        return findBySqlWithMap(sqlsb.toString(),params);
    }


}
