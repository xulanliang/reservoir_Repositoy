package com.dse.reservoir.fxwz.wrmapatrolb.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.fxwz.pojo.FxWzArgModel;
import com.dse.reservoir.api.fxwz.wrmapatrolb.pojo.WrMaPatrolb;
import com.dse.reservoir.api.sgxc.xcsb.pojo.XcsbModel;
import com.dse.reservoir.fxwz.wrmapatrolb.dao.WrMaPatrolbDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by  on 2017-9-5.
 */
@Repository("wrmapatrolbDao")
public class WrmapatrolbDaoImpl extends BaseDao implements WrMaPatrolbDao {

    @Override
    public EasyUiPage getListInfoByParams(FxWzArgModel args, EasyUiPage easyUiPage) throws Exception {
        List<Object> params = new ArrayList<Object>();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT T.*, D.NAME AS ORG_CD_NAME, ");
        sql.append("   WWB.WH_NM AS WH_NM FROM  ( ");
        sql.append(" SELECT ID, PATROL_DESC, WH_CD, ORG_CD, TO_CHAR(PATROL_DATE,'yyyy-mm-dd') AS PATROL_DATE, ISSUES, MEASURES,TO_CHAR(PLAN_DATE,'yyyy-mm-dd') AS PLAN_DATE, ");
        sql.append( " CHECK_USER, RESULT_DESC,TO_CHAR(END_DATE,'yyyy-mm-dd') AS END_DATE, CREATE_USER, PA_STATUS, TS,");
        sql.append( "  NT, TECH_DUTY, PROJ_DUTY, IS_FLOOD FROM WR_MA_PATROL_B T WHERE 1=1 ");

        if(StringUtil.isNotEmpty(args.getDesc())){
            sql.append(" AND T.PATROL_DESC LIKE ? ");
            params.add("%"+args.getDesc()+"%");
        }
        if(StringUtil.isNotEmpty(args.getIs_flood())){
            sql.append( " AND T.IS_FLOOD = ? ");
            params.add(args.getIs_flood());
        }
        if(StringUtil.isNotEmpty(args.getStm())){
            sql.append(" AND T.PATROL_DATE>TO_DATE(?,'yyyy-mm-dd') ");
            params.add(args.getStm());
        }
        if(StringUtil.isNotEmpty(args.getEtm())){
            sql.append(" AND T.PATROL_DATE<(TO_DATE(?,'yyyy-mm-dd')+1) ");
            params.add(args.getEtm());
        }
        if(StringUtil.isNotEmpty(args.getOrg_cd())){
            sql.append( " AND T.ORG_CD = ? ");
            params.add(args.getOrg_cd());
        }
        if(StringUtil.isNotEmpty(args.getWh_cd())){
            sql.append( " AND T.WH_CD = ? ");
            params.add(args.getWh_cd());
        }
        if(StringUtil.isNotEmpty(args.getPa_status())){
            sql.append( " AND T.PA_STATUS = ? ");
            params.add(args.getPa_status());
        }
        sql.append(" ORDER BY T.TS ASC ");
        sql.append(" ) T ");
        sql.append("  LEFT JOIN T_SYS_DICTIONARY D ON D.ID=T.ORG_CD     ");
        sql.append("  LEFT JOIN WR_WH_B WWB ON WWB.WH_CD=T.WH_CD     ");
        sql.append("  ORDER BY  T.TS DESC  ");

        return findEasyUiPageBySql(sql.toString(), easyUiPage, params.toArray());
    }

    @Override
    public EasyUiPage getListWZXCNRInfoByParams(String isflood, EasyUiPage easyUiPage) throws Exception {
        StringBuffer sql = new StringBuffer("SELECT * FROM WR_CHK_CONTENTS S WHERE S.CK_TYPE = 1 ");
        if(isflood.equals("0")){
            //日常巡查
            sql.append(" AND S.TYPE= '1'");
        }else{
            sql.append(" AND S.TYPE = '0'");
        }

        return findEasyUiPageBySql(sql.toString(), easyUiPage);
    }

    @Override
    public EasyUiPage getWZXCListInfoByParams(String search_ck_re_id,String search_ck_cnt_desc,String search_ch_status, EasyUiPage easyUiPage) throws Exception {
        StringBuffer str = new StringBuffer();
        List params = new ArrayList();
        str.append("SELECT D.ID,B.ISU_DESC,D.CK_RE_ID,D.CK_CNT_ID,D.CK_CNT_DESC,D.ISSUE_ID,TO_CHAR(D.TS,'yyyy-mm-dd') TS,decode(D.CH_STATUS, '0', '未开始', '1', '进行中', '2', '已完成') CH_STATUS FROM WR_CHK_RED_CHILD D LEFT JOIN WR_CH_ISSUES_B B ON D.ISSUE_ID = B.ID WHERE D.CK_OBJ_ID IS NULL ");
        if(StringUtils.isNotEmpty(search_ck_re_id)){
            str.append(" AND D.CK_RE_ID = ? ");
            params.add(search_ck_re_id);
        }
        if(StringUtils.isNotEmpty(search_ck_cnt_desc)){
            str.append(" AND D.CK_CNT_DESC LIKE ? ");
            params.add("%"+search_ck_cnt_desc+"%");
        }
        if(StringUtils.isNotEmpty(search_ch_status)){
            str.append(" AND D.CH_STATUS = ? ");
            params.add(search_ch_status);
        }
        return findEasyUiPageBySql(str.toString(),easyUiPage,params.toArray());
    }

    @Override
    public Object deleteInfoByIds(String ids) throws Exception {
        if(StringUtil.isNotEmpty(ids)){
            String[] id = ids.split(",");
            for (int i = 0; i < id.length; i++) {
                //删除防汛物资巡查登记表信息
                removeById(WrMaPatrolb.class,id[i]);
                //删除 巡查记录问题信息
                StringBuffer str1 = new StringBuffer();
                str1.append("SELECT D.ISSUE_ID FROM WR_CHK_RED_CHILD D WHERE D.CK_RE_ID = ?");
                List list = this.findBySqlWithMap(str1.toString(),id[i]);
                if(list.size()>0){
                    for(int j=0;j<list.size();j++){
                        Map map = (Map) list.get(j);
                        if(map.get("ISSUE_ID") != null){
                            String sql = "DELETE FROM WR_CH_ISSUES_B B WHERE B.ID = ? ";
                            this.updateBySql(sql,map.get("ISSUE_ID"));
                        }
                    }
                }
                //删除 巡查记录项目详 信息
                String str = "DELETE FROM WR_CHK_RED_CHILD D WHERE D.CK_RE_ID = ?";
                this.updateBySql(str,id[i]);
            }
        }
        return true;
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr) throws Exception {
        if(StringUtil.isNotEmpty(dataStr)){
            WrMaPatrolb model = JsonUtil.json2Object(dataStr,WrMaPatrolb.class);
            if(!StringUtil.isNotEmpty(model.getId())) {
                String newID = DseSysCommonUtil.getNewId().toString();
                //为空，新增巡查任务
                model.setId(newID);
                model.setTs(new Date());

                //巡查记录项目详情表  添加记录
                StringBuffer sql = new StringBuffer();
                sql.append("insert into wr_chk_red_child" +
                        "   (id,seq,ck_re_id,ck_obj_id,ck_cnt_id,ck_cnt_desc,ck_tag_desc,ts,ch_status,nt)" +
                        "    select wr_chk_red_child_id_seq.Nextval id,s.seq,'" +newID +"' ck_re_id,'',s.ck_cnt_id,s.ck_cnt_desc,s.ck_tag_desc,sysdate ts,'0' ch_status,s.nt" +
                        "    from wr_chk_contents s where s.ck_type = '1'"); //and s.type = '1'
                if(StringUtils.isNotEmpty(model.getIs_flood())){
                    //0:日常检查 1：汛前查询及养护 2：汛后检查及养护
                    if((model.getIs_flood()).equals("0")){
                        sql.append(" and s.type ='1'");
                    }else {
                        sql.append(" and s.type ='0'");
                    }
                }
                this.updateBySql(sql.toString());

            }
            saveOrUpdate(model);
            return model;
        }
        return null;
    }

    @Override
    public Object doSave(String taskID) throws Exception {
        StringBuffer str = new StringBuffer();
        StringBuffer sql = new StringBuffer();
        List params = new ArrayList();
        //更改巡查内容状态为完成
        str.append("UPDATE WR_CHK_RED_CHILD D SET CH_STATUS = '2' WHERE 1=1 ");
        if(StringUtil.isNotEmpty(taskID)){
            str.append(" AND D.CK_RE_ID = ?");
            params.add(taskID);
            this.updateBySql(str.toString(),params.toArray());
        }
        //更改防汛物资巡查登记表信息
        sql.append("UPDATE WR_MA_PATROL_B B SET PA_STATUS = 2,END_DATE = SYSDATE WHERE 1=1");
        if(StringUtil.isNotEmpty(taskID)){
            sql.append(" AND B.ID = ? ");
            params.clear();
            params.add(taskID);
            this.updateBySql(sql.toString(),params.toArray());
        }
        return true;
    }

    @Override
    public Object saveXcsb(String ckID, String issue, String issueID, String taskID) throws Exception {
        List params = new ArrayList();
        if(StringUtil.isNotEmpty(issueID)){
            if(StringUtil.isNotEmpty(issue)){
                //更新问题信息
                StringBuffer str1= new StringBuffer();
                str1.append("UPDATE WR_CH_ISSUES_B B SET ISU_DESC = ? WHERE B.ISSUE_ID = ?");
                params.add(issue);
                params.add(issueID);
            }else{
                //问题为空，删除该问题
                StringBuffer str2 = new StringBuffer();
                str2.append("UPDATE WR_CHK_RED_CHILD D SET D.ISSUE_ID = '' WHERE D.ID = ?");
                params.clear();
                params.add(ckID);
                this.updateBySql(str2.toString(),params.toArray());
                StringBuffer str3 = new StringBuffer();
                str3.append("DELETE FROM WR_CH_ISSUES_B B WHERE B.ID = ? ");
                params.clear();
                params.add(issueID);
                this.updateBySql(str3.toString(),params.toArray());
            }
        }else if(StringUtil.isNotEmpty(issue)){
            //问题ID为空，问题不为空，则是新增问题
            StringBuffer str3 = new StringBuffer();
            XcsbModel model = new XcsbModel();
            issueID = DseSysCommonUtil.getNewId().toString();
            model.setID(issueID);
            model.setISU_DESC(issue);
            model.setTS(new Date());
            model.setISU_STATUS("0");
            //保存问题信息
            this.saveOrUpdate(model);
            str3.append("UPDATE WR_CHK_RED_CHILD D SET D.ISSUE_ID = ? WHERE D.ID = ?");
            params.clear();
            params.add(issueID);
            params.add(ckID);
            this.updateBySql(str3.toString(),params.toArray());
        }
        return true;
    }

    @Override
    public Object getInfoById(String id) throws Exception {
        StringBuffer sql=new StringBuffer();
        sql.append(" select t.*, d.name as org_cd_name, ");
        sql.append("   wwb.wh_nm as wh_nm from  ( ");//
        sql.append(" select id, patrol_desc, wh_cd, org_cd,to_char(patrol_date,'yyyy-mm-dd hh24:mi:ss') as patrol_date, issues, measures,to_char(plan_date,'yyyy-mm-dd hh24:mi:ss') as plan_date, ");
        sql.append( " check_user, result_desc,to_char(end_date,'yyyy-mm-dd hh24:mi:ss') as end_date, create_user, pa_status, ts,");
        sql.append( "  nt, tech_duty, proj_duty, is_flood from wr_ma_patrol_b t where 1=1  ");
        sql.append("  and id=? ");
        sql.append(" ) t ");
        sql.append("  left join t_sys_dictionary d on d.id=t.org_cd     ");
        sql.append("  left join wr_wh_b wwb on wwb.wh_cd=t.wh_cd     ");

        return this.findBySqlWithMap(sql.toString(),id);
        // return getDao().executeSQLRetMap(selectSql.toString(),ckid);
        //return get(id);
    }

    /***
     *
     * @param ids
     * @param stauts
     * @return
     */
    public Object updateStautsByIds(String ids,String stauts){
        if(!StringUtil.isNotEmpty(stauts)){
            stauts="0";
        }
        if (StringUtil.isNotEmpty(ids)) {
            StringBuffer sql =new StringBuffer();
            String[] arrIds = ids.split(",");
            sql.append(" AND ID IN ( ");
            StringBuffer idsStr = new StringBuffer();
            for (int i = 0; i < arrIds.length; i++) {
                if ((i + 1) == arrIds.length) {
                    idsStr.append(" '" + arrIds[i] + "' ");
                } else {
                    idsStr.append(" '" + arrIds[i] + "', ");
                }
            }
            sql.append(idsStr.toString());
            sql.append(" ) ");
            StringBuffer sql2 = new StringBuffer(" UPDATE WR_MA_PATROL_B T SET T.PA_STATUS='"+stauts+"' WHERE 1=1 ");
            sql2.append(sql);
            this.updateBySql(sql2.toString());
        }
        return true;
    }

}
