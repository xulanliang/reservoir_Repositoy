package com.dse.reservoir.tableEdit.rainLever.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fzjc.pojo.WrStatsModeRModel;
import com.dse.reservoir.api.tableEdit.pojo.*;
import com.dse.reservoir.api.util.Utility;
import com.dse.reservoir.tableEdit.rainLever.dao.RainLeverDao;
import org.springframework.stereotype.Repository;

import javax.rmi.CORBA.Util;
import java.awt.geom.QuadCurve2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by Xll on 2017/7/5.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Repository("rainLeverDao")
public class RainLeverDaoImpl extends BaseDao implements RainLeverDao {

    @Override
    public EasyUiPage getRainListInfoByParams(String stnm, String sTM, String eTM,String PROJ_NM, EasyUiPage easyUiPage) {
//        String sql = "select wr.stnm,st.tm,st.drp,st.intv,st.pdr,st.dyp,st.wth from ST_PPTN_R st left join WR_STAT_M wr on st.stcd = wr.stcd;";
        StringBuilder sql=new StringBuilder();
        ArrayList<Object> params=new ArrayList<Object>();
        sql.append("SELECT rain.stcd,bb.proj_nm,mm.stnm,rain.tm,rain.drp,rain.intv,rain.pdr,rain.dyp,rain.wth \n" +
                "FROM ST_PPTN_R rain LEFT JOIN WR_ST_PROJ_TYPE_MAP mid ON rain.stcd=mid.stcd LEFT JOIN WR_STAT_M mm ON rain.stcd=mm.stcd LEFT JOIN WR_PROJ_B bb ON mid.proj_cd = bb.proj_cd  where 1=1 ");
        if(StringUtil.isNotEmpty(stnm)){
            //测点名称
            sql.append(" and mm.stnm like ? ");
            params.add("%"+stnm+"%");
        }
        if(StringUtil.isNotEmpty(PROJ_NM)){
            //水库名称
            sql.append(" and bb.PROJ_CD = ? ");
            params.add(PROJ_NM);
        }
        if(StringUtil.isNotEmpty(sTM)){
            //开始时间
            sql.append(" and rain.tm >= to_date(?,'yyyy-mm-dd') ");
            params.add(sTM);
        }
        if(StringUtil.isNotEmpty(eTM)){
            //结束时间
            sql.append(" and rain.tm <= to_date(?,'yyyy-mm-dd') ");
            params.add(eTM);
        }
        sql.append( "order by rain.tm desc");
        return findEasyUiPageBySql(sql.toString(),easyUiPage,params.toArray());
    }

    @Override
    public EasyUiPage getProjectBaseListInfoByParams(String ITEM_NM, String MON_TP, String IS_AUTO, EasyUiPage easyUiPage) {
        StringBuffer str=new StringBuffer();
        ArrayList<Object> params = new ArrayList<Object>();
        str.append("select * from WR_ITEM_M where 1=1");
        if(StringUtil.isNotEmpty(ITEM_NM)){
            str.append(" and ITEM_NM like ?");
            params.add("%"+ITEM_NM+"%");
        }
        if(StringUtil.isNotEmpty(MON_TP)){
            str.append(" and MON_TP = ?");
            params.add(MON_TP);
        }
        if(StringUtil.isNotEmpty(IS_AUTO)){
            str.append(" and IS_AUTO = ?");
            params.add(IS_AUTO);
        }
        return findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
    }

    @Override
    public EasyUiPage getSectionBaseListInfoByParams(String RB_NM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList<Object> params = new ArrayList<Object>();
        str.append("select wrm.rb_cd,wrm.proj_cd_one,wrb.proj_nm proj_nm2,wrm.proj_cd_two,wrm.rb_nm,wrbb.proj_nm,wrm.ts,nvl(wrm.item_cd,'') item_cd ,nvl(wrm.nt,'') nt " +
                "from WR_RB_M wrm inner join WR_PROJ_B wrb on wrm.proj_cd_one = wrb.proj_cd inner join WR_PROJ_B wrbb on wrm.proj_cd_two = wrbb.proj_cd where 1=1 ");
        if(StringUtil.isNotEmpty(RB_NM)){
            str.append(" and wrm.rb_nm like ? ");
            params.add("%"+RB_NM+"%");
        }
        str.append(" order by wrm.ts asc");
        return findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
    }

    /**
     *  垂直位移监测信息
     * @param RB_NM
     * @param STM
     * @param ETM
     * @param easyUiPage
     * @return
     */
    @Override
    public EasyUiPage getCzwyjcxxListInfoByParams(String RB_NM, String STM, String ETM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList params = new ArrayList();
        str.append("SELECT bb.stcd,mm.stnm,bb.tm,bb.origdata,bb.calcdata,bb.jcl,bb.transst,bb.otdesc,bb.gattype,bb.ts,bb.nt,bb.qs " +
                "FROM WR_VSFT_B bb LEFT JOIN WR_STAT_M mm ON bb.stcd=mm.stcd where 1=1 ");
        if(StringUtil.isNotEmpty(RB_NM)){
            str.append(" and mm.stnm LIKE ?");
            params.add("%"+RB_NM+"%");
        }if(StringUtil.isNotEmpty(STM)){
            str.append(" and bb.tm>=to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(STM);
        }if(StringUtil.isNotEmpty(ETM)){
            str.append(" and bb.tm<=to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(ETM);
        }
        str.append(" order by bb.tm desc");
        EasyUiPage easyUiPage1 = this.findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
        return easyUiPage1;
    }

    @Override
    public EasyUiPage getDdwyjcxxListInfoByParams(String RB_NM, String STM, String ETM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList params = new ArrayList();
        str.append("SELECT bb.stcd,mm.stnm,bb.tm,bb.origdata,bb.calcdata,bb.jcl,bb.transst,bb.otdesc,bb.gattype,bb.ts,bb.nt " +
                "FROM WR_MSFT_B bb LEFT JOIN WR_STAT_M mm ON bb.stcd=mm.stcd where 1=1 ");
        if(StringUtil.isNotEmpty(RB_NM)){
            str.append(" and mm.stnm LIKE ?");
            params.add("%"+RB_NM+"%");
        }if(StringUtil.isNotEmpty(STM)){
            str.append(" and bb.tm>=to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(STM);
        }if(StringUtil.isNotEmpty(ETM)){
            str.append(" and bb.tm<=to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(ETM);
        }
        str.append(" order by bb.tm desc");
        EasyUiPage easyUiPage1 = this.findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
        return easyUiPage1;
    }

    @Override
    public EasyUiPage getGcjbxxListInfoByParams(String RB_NM,String CK_ORG, String STM, String ETM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList params = new ArrayList();
        str.append("select * from WR_PROJ_B bb where 1=1 ");
        if(StringUtil.isNotEmpty(RB_NM)){
            str.append(" and bb.PROJ_NM like ? ");
            params.add("%"+RB_NM+"%");
        }
        if(StringUtil.isNotEmpty(CK_ORG)){
            str.append(" AND bb.DEPARTMENTID=?");
            params.add(CK_ORG);
        }
        if(StringUtil.isNotEmpty(STM)){
            str.append(" and bb.CREATE_TIME >= to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(STM);
        }
        if(StringUtil.isNotEmpty(ETM)){
            str.append(" and bb.CREATE_TIME <= to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(ETM);
        }
        str.append(" order by bb.CREATE_TIME desc");
        EasyUiPage easyUiPage1 = this.findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
        return easyUiPage1;
    }

    @Override
    public EasyUiPage getMkjbxxbListInfoByParams(String RB_NM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList params = new ArrayList();
        str.append("SELECT b.*,bb.proj_nm FROM WR_MONITOR_B b LEFT JOIN WR_PROJ_B bb ON b.proj_cd = bb.proj_cd where 1=1 ");
        if(StringUtil.isNotEmpty(RB_NM)){
            str.append(" and b.MDNAME=? ");
            params.add(RB_NM);
        }
        EasyUiPage easyUiPage1 = this.findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
        return easyUiPage1;
    }

    @Override
    public EasyUiPage getQwqyListInfoByParams(String STM, String ETM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList params = new ArrayList();
        str.append("SELECT rr.*,mm.stnm FROM ST_TMP_R rr LEFT JOIN WR_STAT_M mm ON rr.stcd=mm.stcd where 1=1 ");
        if(StringUtil.isNotEmpty(STM)){
            str.append(" and rr.TM>=to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(STM);
        }
        if(StringUtil.isNotEmpty(ETM)){
            str.append(" and rr.TM<=to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(ETM);
        }
        str.append(" order by rr.TM desc");
        EasyUiPage easyUiPage1 = this.findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
        return easyUiPage1;
    }

    @Override
    public EasyUiPage getSwbListInfoByParams(String STM, String ETM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList params = new ArrayList();
        str.append("SELECT rr.*,mm.stnm FROM WR_SW_R rr LEFT JOIN WR_STAT_M mm ON rr.stcd=mm.stcd where 1=1 ");
        if(StringUtil.isNotEmpty(STM)){
            str.append(" and rr.TM>=to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(STM);
        }
        if(StringUtil.isNotEmpty(ETM)){
            str.append(" and rr.TM<=to_date(?,'yyyy-mm-dd hh24:mi:ss') ");
            params.add(ETM);
        }
        str.append(" order by rr.TM desc");
        EasyUiPage easyUiPage1 = this.findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
        return easyUiPage1;
    }

    @Override
    public EasyUiPage getSksqbListInfoByParams(String STM, String ETM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList list = new ArrayList();
        str.append("SELECT mm.stnm,rr.* FROM ST_RSVR_R rr LEFT JOIN WR_STAT_M mm ON rr.stcd = mm.stcd where 1=1 ");
        if(StringUtil.isNotEmpty(STM)){
            str.append(" and rr.TM>=to_date(?,'yyyy-mm-dd hh24:mi:ss')");
            list.add(STM);
        }
        if(StringUtil.isNotEmpty(ETM)){
            str.append(" and rr.TM<=to_date(?,'yyyy-mm-dd hh24:mi:ss')");
            list.add(ETM);
        }
        str.append(" order by rr.TM desc");
        EasyUiPage easyUiPage1 = this.findEasyUiPageBySql(str.toString(),easyUiPage,list.toArray());
        return easyUiPage1;
    }

    @Override
    public EasyUiPage getSpwycjxxListInfoByParams(String STNM, String STM, String ETM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList list = new ArrayList();
        str.append("SELECT mm.stnm，bb.* FROM WR_HSFT_B bb LEFT JOIN WR_STAT_M mm ON bb.stcd = mm.stcd where 1=1 ");
        if(StringUtil.isNotEmpty(STNM)){
            str.append(" and mm.stnm = ?");
            list.add(STNM);
        }
        if(StringUtil.isNotEmpty(STM)){
            str.append(" and bb.TM>=to_date(?,'yyyy-mm-dd hh24:mi:ss')");
            list.add(STM);
        }
        if(StringUtil.isNotEmpty(ETM)){
            str.append(" and bb.TM<=to_date(?,'yyyy-mm-dd hh24:mi:ss')");
            list.add(ETM);
        }
        str.append(" order by bb.TM desc");
        EasyUiPage easyUiPage1 = this.findEasyUiPageBySql(str.toString(),easyUiPage,list.toArray());
        return easyUiPage1;
    }

    @Override
    public EasyUiPage getCdjcxxbListInfoByParams(String STNM, EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList list = new ArrayList();
        str.append("SELECT b.mdname,bb.proj_nm,m.* FROM WR_STAT_M m LEFT JOIN  WR_MONITOR_B b ON m.mdcd = b.mdcd LEFT JOIN WR_PROJ_B bb ON m.proj_cd = bb.proj_cd where 1=1 ");
        if(StringUtil.isNotEmpty(STNM)){
            str.append(" and m.STNM like ?");
            list.add("%"+STNM+"%");
        }
        EasyUiPage easyUiPage1 = this.findEasyUiPageBySql(str.toString(),easyUiPage,list.toArray());
        return easyUiPage1;
    }

    @Override
    public Object getInfoById(String id, String tm) {
        ArrayList<Object> params = new ArrayList<Object>();
        String sql = "select st.STCD,wr.stnm,st.tm,st.drp,st.intv,st.pdr,st.dyp,st.wth " +
                "       from ST_PPTN_R st left join WR_STAT_M wr on st.stcd = wr.stcd " +
                "       where st.tm = to_date(?,'yyyy-mm-dd hh24:mi:ss') " +
                "       and st.STCD = ?";
        params.add(tm);
        params.add(id);
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getProjectBaseInfoById(String id) {
        ArrayList<Object> params = new ArrayList<Object>();
        String sql = "select * from WR_ITEM_M where ITEM_CD=?";
        params.add(id);
        return findBySqlWithMap(sql,params.toArray());
    }

    /**
     *  根据检测项目id查询断面基础信息
     * @param id
     * @return
     */
    @Override
    public Object getSectionBaselnfoById(String id) {
        ArrayList<Object> params = new ArrayList<Object>();
//        String sql = "select wrm.rb_cd,wrm.rb_nm,wrb.proj_nm proj_nm2,wrbb.proj_nm,wrm.ts,nvl(wrm.item_cd,'') item_cd ,nvl(wrm.nt,'') nt " +
//                "   from WR_RB_M wrm inner join WR_PROJ_B wrb on wrm.proj_cd_one = wrb.proj_cd inner join WR_PROJ_B wrbb on wrm.proj_cd_two = wrbb.proj_cd where wrm.RB_CD=?  ";
        String sql = "SELECT * FROM WR_RB_M M WHERE 1=1 ";
        if(StringUtil.isNotEmpty(id)){
            sql+=" AND M.RB_CD =? ";
        }
        params.add(id);
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getCdjcxxbInfoById(String id) {
        String sql = "SELECT b.mdname,bb.proj_nm,m.* FROM WR_STAT_M m LEFT JOIN  WR_MONITOR_B b ON m.mdcd = b.mdcd LEFT JOIN WR_PROJ_B bb ON m.proj_cd = bb.proj_cd where m.STCD=?";
        return this.findBySqlWithMap(sql,id);
    }

    @Override
    public Object getSpwycjxxInfoById(String id) {
        String [] ids = id.split(",");
        ArrayList params = new ArrayList();
        String STCD=ids[0];
        String QS=ids[1];
        String TM=ids[2];
        String str = "SELECT mm.stnm，bb.* FROM WR_HSFT_B bb LEFT JOIN WR_STAT_M mm ON bb.stcd = mm.stcd where bb.stcd = ? and bb.QS=? and bb.TM=to_date(?,'yyyy-mm-dd hh24:mi:ss') order by bb.TM desc";
        params.add(STCD);
        params.add(QS);
        params.add(TM);

        return findBySqlWithMap(str,params.toArray());
    }

    @Override
    public Object getQwqyInfoById(String id) {
        String [] ids = id.split(",");
        ArrayList<Object> params = new ArrayList<Object>();
        String str="SELECT rr.*,mm.stnm FROM ST_TMP_R rr LEFT JOIN WR_STAT_M mm ON rr.stcd=mm.stcd where rr.STCD=? and rr.TM=to_date(?,'yyyy-mm-dd hh24:mi:ss')";
        params.add(ids[0]);
        params.add(ids[1]);
        return findBySqlWithMap(str,params.toArray());
    }

    @Override
    public Object getSksqbInfoById(String id) {
        String [] ids = id.split(",");
        ArrayList<Object> params = new ArrayList<Object>();
        String str="SELECT mm.stnm,rr.* FROM ST_RSVR_R rr LEFT JOIN WR_STAT_M mm ON rr.stcd = mm.stcd where rr.STCD=? and rr.TM=to_date(?,'yyyy-mm-dd hh24:mi:ss')";
        params.add(ids[0]);
        params.add(ids[1]);
        return findBySqlWithMap(str,params.toArray());
    }

    @Override
    public Object getSwbInfoById(String id) {
        String [] ids = id.split(",");
        ArrayList<Object> params = new ArrayList<Object>();
        String str="SELECT rr.*,mm.stnm FROM WR_SW_R rr LEFT JOIN WR_STAT_M mm ON rr.stcd=mm.stcd where rr.STCD =? and rr.TM=to_date(?,'yyyy-mm-dd hh24:mi:ss')";
        String stcd=ids[0];
        String TM=ids[1];
        params.add(stcd);
        params.add(TM);
        return findBySqlWithMap(str,params.toArray());
    }

    @Override
    public Object getCzwyjcxxlnfoById(String stcd, String TM,String QS) {
        ArrayList params = new ArrayList();
        params.add(TM);
        params.add(stcd);
        params.add(QS);
        String sql = "SELECT bb.stcd,mm.stnm,bb.tm,bb.origdata,bb.calcdata,bb.jcl,bb.transst,bb.otdesc,bb.gattype,bb.ts,bb.nt,bb.qs " +
                "     FROM WR_VSFT_B bb LEFT JOIN WR_STAT_M mm ON bb.stcd=mm.stcd where bb.tm=to_date(?,'yyyy-mm-dd hh24:mi:ss') and bb.stcd=? and bb.QS=? ";  //to_date('2017-10-10 15:00:00','yyyy-mm-dd hh24:mi:ss')
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getDdwyjcxxlnfoById(String stcd, String TM) {
        ArrayList params = new ArrayList();
        params.add(TM);
        params.add(stcd);
        String sql = "SELECT bb.stcd,mm.stnm,bb.tm,bb.origdata,bb.calcdata,bb.jcl,bb.transst,bb.otdesc,bb.gattype,bb.ts,bb.nt " +
                "     FROM WR_MSFT_B bb LEFT JOIN WR_STAT_M mm ON bb.stcd=mm.stcd where bb.tm=to_date(?,'yyyy-mm-dd hh24:mi:ss') and bb.stcd=? ";  //to_date('2017-10-10 15:00:00','yyyy-mm-dd hh24:mi:ss')
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getGcjbxxlnfoById(String id) {
        ArrayList params = new ArrayList();
        params.add(id);
        String sql = "SELECT * FROM WR_PROJ_B bb WHERE bb.proj_cd =?";  //to_date('2017-10-10 15:00:00','yyyy-mm-dd hh24:mi:ss')
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object getMkjbxxblnfoById(String id) {
        ArrayList params = new ArrayList();
        params.add(id);
        String sql = "SELECT b.*,bb.proj_nm FROM WR_MONITOR_B b LEFT JOIN WR_PROJ_B bb ON b.proj_cd = bb.proj_cd WHERE b.Mdcd = ?";
        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            RainLeverModel rainLeverModel =JsonUtil.json2Object(dataStr, RainLeverModel.class);
            saveOrUpdate(rainLeverModel);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("update st_pptn_r set ");
            JsonUtil.json2Map(dataStr).get("TM");
            int num=0;
            if(StringUtil.isNotEmpty(String.valueOf(rainLeverModel.getDRP())) && !String.valueOf(rainLeverModel.getDRP()).equals("null")){
                //时段降水量
                stringBuffer.append(" DRP='"+rainLeverModel.getDRP()+"'");
                num=num+1;
            }
            if(StringUtil.isNotEmpty(String.valueOf(rainLeverModel.getDYP())) && !String.valueOf(rainLeverModel.getDYP()).equals("null")){
                if(num!=0){
                    //日降水量
                    stringBuffer.append(" ,DYP='"+rainLeverModel.getDYP()+"'");
                }else {
                    stringBuffer.append(" DYP='"+rainLeverModel.getDYP()+"'");
                    num=num+1;
                }
            }
            if(StringUtil.isNotEmpty(String.valueOf(rainLeverModel.getINTV())) && !String.valueOf(rainLeverModel.getINTV()).equals("null")){
                if(num!=0) {
                    //时段长
                    stringBuffer.append(" ,INTV='" + rainLeverModel.getINTV() + "'");
                }else {
                    stringBuffer.append(" INTV='" + rainLeverModel.getINTV() + "'");
                    num=num+1;
                }
            }
            if(StringUtil.isNotEmpty(String.valueOf(rainLeverModel.getPDR())) && !String.valueOf(rainLeverModel.getPDR()).equals("null")){
                if(num!=0){
                    //时段长
                    stringBuffer.append(" ,PDR= '"+rainLeverModel.getPDR()+"'");
                }else{
                    stringBuffer.append(" PDR= '"+rainLeverModel.getPDR()+"'");
                    num=num+1;
                }

            }
            stringBuffer.append(" where tm= to_date('"+ JsonUtil.json2Map(dataStr).get("TM") +"','yyyy-mm-dd hh24:mi:ss') and stcd='"+rainLeverModel.getSTCD()+"' ");
            //避免主键冲突
            this.getSession().clear();
            this.updateBySql(stringBuffer.toString());
        }
        return true;
    }

    /**
     *   更新垂直位移监测信息
     * @param dataStr
     * @return
     */
    @Override
    public Object saveOrUpdateCzwyjcxxInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            CzwyjcxxPK czwyjcxxPK = JsonUtil.json2Object(dataStr,CzwyjcxxPK.class);
            CzwyjcxxModel czwyjcxxModel = JsonUtil.json2Object(dataStr,CzwyjcxxModel.class);
            czwyjcxxModel.setId(czwyjcxxPK);
            saveOrUpdate(czwyjcxxModel);
        }
        return true;
    }

    /**
     *  更新水平位移监测信息
     * @param dataStr
     * @return
     */
    @Override
    public Object saveOrUpdateSpwycjxxInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            String [] ids = dataStr.split(",");
            SpwycjxxPK spwycjxxPK = JsonUtil.json2Object(dataStr,SpwycjxxPK.class);
            SpwycjxxModel spwycjxxModel = JsonUtil.json2Object(dataStr,SpwycjxxModel.class);
            spwycjxxModel.setId(spwycjxxPK);
            this.saveOrUpdate(spwycjxxModel);
        }
        return true;
    }

    @Override
    public Object saveOrUpdateSksqbInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            SksqbPK sksqbPK = JsonUtil.json2Object(dataStr,SksqbPK.class);
            SksqbModel sksqbModel = JsonUtil.json2Object(dataStr,SksqbModel.class);
            sksqbModel.setId(sksqbPK);
            this.saveOrUpdate(sksqbModel);
        }
        return true;
    }

    @Override
    public Object saveOrUpdateMkjbxxInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            MkjbxxModel mkjbxxModel =JsonUtil.json2Object(dataStr,MkjbxxModel.class);
            saveOrUpdate(mkjbxxModel);
        }
        return true;
    }

    @Override
    public Object saveOrUpdateCdjcxxbInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            CdjcxxbModel cdjcxxbModel=JsonUtil.json2Object(dataStr,CdjcxxbModel.class);
            this.saveOrUpdate(cdjcxxbModel);
        }
        return true;
    }

    @Override
    public Object saveOrUpdateDdwyjcxxInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            DdwyjcxxPK ddwyjcxxPK = JsonUtil.json2Object(dataStr,DdwyjcxxPK.class);
            DdwyjcxxModel ddwyjcxxModel = JsonUtil.json2Object(dataStr,DdwyjcxxModel.class);
            ddwyjcxxModel.setId(ddwyjcxxPK);
            saveOrUpdate(ddwyjcxxModel);
        }
        return true;
    }

    @Override
    public Object saveOrUpdateGcjbxxInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            GcjbxxModel gcjbxxModel = JsonUtil.json2Object(dataStr,GcjbxxModel.class);
            saveOrUpdate(gcjbxxModel);
        }
        return true;
    }

    @Override
    public Object saveOrUpdateQwqyInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            QwqyPK qwqyPK = JsonUtil.json2Object(dataStr,QwqyPK.class);
            QwqyModel qwqyModel = JsonUtil.json2Object(dataStr,QwqyModel.class);
            qwqyModel.setId(qwqyPK);
            saveOrUpdate(qwqyModel);
        }
        return true;
    }

    @Override
    public Object saveOrUpdateSwbInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            SwbModel swbModel = JsonUtil.json2Object(dataStr,SwbModel.class);
            SwbPK swbPK = JsonUtil.json2Object(dataStr,SwbPK.class);
            swbModel.setId(swbPK);
            saveOrUpdate(swbModel);
        }
        return true;
    }

    @Override
    public Object saveOrUpdateProjectBaseInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            ProjectBaseInfoModel model =JsonUtil.json2Object(dataStr, ProjectBaseInfoModel.class);
            this.saveOrUpdate(model);
//            this.saveOrUpdate(model);
        }
        return true;
    }

    @Override
    public Object saveOrUpdateSectionBaseInfo(String dataStr) {
        if(StringUtil.isNotEmpty(dataStr)){
            SectionBaseInfoModel model =JsonUtil.json2Object(dataStr, SectionBaseInfoModel.class);
            this.update(model);
        }
        return true;
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @Override
    public Object deleteInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            String[] params =ids.split(",");
            String stcd = params[0];
            String tm = params[1];
            String sql = "delete from ST_PPTN_R where stcd = '"+stcd+"' and tm = to_date('"+ tm +"','yyyy-mm-dd hh24:mi:ss')";
            this.updateBySql(sql);
        }
        return true;
    }

    @Override
    public Object deleteProjectBaseInfoByIds(String ids) {
        ArrayList<Object> params = new ArrayList<Object>();
        if(StringUtil.isNotEmpty(ids)){
            String[] id = ids.split(",");
            StringBuffer str= new StringBuffer();
            str.append("delete from WR_ITEM_M where ITEM_CD in(");
            for(int i=0;i<id.length;i++){
                if(i+1==id.length){
                    str.append("?");
                    params.add(id[i]);
                }else{
                    str.append(",?");
                    params.add(id[i]);
                }
            }
            str.append(")");
            this.updateBySql(str.toString(),params.toArray());
        }
        return true;
    }

    @Override
    public Object deleteCdjcxxbInfoByIds(String ids) {
        String sql = "delete from WR_STAT_M m where m.STCD =?";
        this.updateBySql(sql,ids);
        return true;
    }

    @Override
    public Object deleteSpwycjxxInfoByIds(String ids) {
        ArrayList params = new ArrayList();
        String []id=ids.split(",");
        String STCD = id[0];
        String QS = id[1];
        String TM = id[2];
        String str = "delete from WR_HSFT_B bb where bb.stcd = ? and bb.QS =? and bb.TM=to_date(?,'yyyy-mm-dd hh24:mi:ss')";
        params.add(STCD);
        params.add(QS);
        params.add(TM);
        this.updateBySql(str,params.toArray());
        return true;
    }

    @Override
    public Object deleteSksqbInfoByIds(String ids) {
        ArrayList params = new ArrayList();
        String []id=ids.split(",");
        String STCD = id[0];
        String TM = id[1];
        String str = "delete from ST_RSVR_R bb where bb.stcd = ? and bb.TM=to_date(?,'yyyy-mm-dd hh24:mi:ss')";
        params.add(STCD);
        params.add(TM);
        this.updateBySql(str,params.toArray());
        return true;
    }

    @Override
    public Object deleteCzwyjcxxByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
//            ArrayList param = new ArrayList();
            String [] params = ids.split(",");
            String stcd = params[0];
            String TM = params[1];
            String QS = params[2];
            String sql = "delete from WR_VSFT_B bb where bb.stcd = '"+stcd+"' and bb.tm = to_date('"+TM+"','yyyy-mm-dd hh24:mi:ss') and bb.QS = "+QS;
//            param.add(stcd);
//            param.add(TM);
//            param.add(QS);
            this.updateBySql(sql);
        }
        return true;
    }

    @Override
    public Object deleteQwqyInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            ArrayList params = new ArrayList();
            String [] name = ids.split(",");
            String STCD = name[0];
            String TM = name[1];
            String sql = "delete from ST_TMP_R rr where rr.STCD=? and rr.TM=to_date(?,'yyyy-mm-dd hh24:mi:ss') ";
            params.add(STCD);
            params.add(TM);
            this.updateBySql(sql,params.toArray());
        }
        return true;
    }

    @Override
    public Object deleteSwbInfoByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            ArrayList params = new ArrayList();
            String [] name = ids.split(",");
            String STCD = name[0];
            String TM = name[1];
            String sql = "delete from WR_SW_R rr where rr.STCD=? and rr.TM=to_date(?,'yyyy-mm-dd hh24:mi:ss') ";
            params.add(STCD);
            params.add(TM);
            this.updateBySql(sql,params.toArray());
        }
        return true;
    }

    @Override
    public Object deleteDdwyjcxxByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
//            ArrayList param = new ArrayList();
            String [] params = ids.split(",");
            String stcd = params[0];
            String TM = params[1];
            String sql = "delete from WR_MSFT_B bb where bb.stcd = '"+stcd+"' and bb.tm = to_date('"+TM+"','yyyy-mm-dd hh24:mi:ss') ";
            this.updateBySql(sql);
        }
        return true;
    }

    @Override
    public Object deleteGcjbxxByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            ArrayList params = new ArrayList();
            params.add(ids);
            String sql = "delete from WR_PROJ_B bb where bb.PROJ_CD = ? ";
            this.updateBySql(sql,params.toArray());
        }
        return true;
    }

    @Override
    public Object deleteMkjbxxByIds(String ids) {
        if(StringUtil.isNotEmpty(ids)){
            ArrayList params = new ArrayList();
            params.add(ids);
            String sql = "delete from WR_MONITOR_B b where b.MDCD = ?";
            this.updateBySql(sql,params.toArray());
        }
        return true;
    }

    @Override
    public Object getShenyaStatsParamList(Map<String, Object> conditionMap,EasyUiPage easyUiPage) {
        StringBuffer str = new StringBuffer();
        ArrayList<Object> params = new ArrayList<Object>();
        str.append("SELECT T.* FROM  WR_STATS_MODE_R T " )
                .append(" WHERE 1=1 ") ;
        if(Utility.isNotEmpty(conditionMap) && conditionMap.containsKey("STNM") && Utility.isNotEmpty(conditionMap.get("STNM"))){
            str.append(" AND T.STNM LIKE ? ");
            params.add("%"+conditionMap.get("STNM")+"%");
        }
        return findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
    }

    @Override
    public Object getShenyaStatsInfoById(Map<String, Object> conditionMap) {
        StringBuilder querySql = new StringBuilder();
        ArrayList params = new ArrayList();
        querySql.append(" select * from  WR_STATS_MODE_R T ")
                .append(" WHERE 1=1 ") ;
        if(Utility.isNotEmpty(conditionMap) && conditionMap.containsKey("ID") && Utility.isNotEmpty(conditionMap.get("ID"))){
            querySql.append(" AND T.ID = ? ");
            params.add(conditionMap.get("ID"));
            return findBySqlWithMap(querySql.toString(),params.toArray());
        }else{
            return null;
        }
    }

    @Override
    public Object saveOrUpdateShenyaStatsParamInfo(String dataStr) {
        try {
            if (StringUtil.isNotEmpty(dataStr)) {
                WrStatsModeRModel wrStatsModeRModel = JsonUtil.json2Object(dataStr, WrStatsModeRModel.class);
                wrStatsModeRModel.setTS(new Date());
                this.saveOrUpdate(wrStatsModeRModel);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;

        }
    }
}
