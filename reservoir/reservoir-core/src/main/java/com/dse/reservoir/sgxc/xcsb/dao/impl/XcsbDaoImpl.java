package com.dse.reservoir.sgxc.xcsb.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.util.StringUtil;
import com.dse.reservoir.api.sgxc.xcsb.pojo.XcsbModel;
import com.dse.reservoir.sgxc.xcsb.dao.XcsbDao;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dse on 2017/8/22.
 */
@Repository("xcsbDao")
public class XcsbDaoImpl extends BaseDao implements XcsbDao {
    @Override
    public Object saveXcsb(String taskID,String ckID, String issure,String issueID) {
        ArrayList params = new ArrayList();
        if(!StringUtil.isNotEmpty(issueID)){
            if(StringUtil.isNotEmpty(issure)){
                //问题ID为空,但问题描述不为空,新建问题
                issueID = DseSysCommonUtil.getNewId().toString();
                //该巡查任务异常数加1
                String sele = "SELECT D.CK_RE_ECOUNT FROM WR_CHK_RECORD D WHERE D.CK_RE_ID = ?";
                List list=  this.findBySqlWithMap(sele,taskID);
                Map map= (Map) list.get(0);
                Integer count = new Integer(String.valueOf(map.get("CK_RE_ECOUNT")));
                String update = "UPDATE WR_CHK_RECORD D SET D.CK_RE_ECOUNT=? WHERE D.CK_RE_ID = ?";
                this.updateBySql(update,count+1,taskID);
            }

        }
        if(StringUtil.isNotEmpty(issure)){
            XcsbModel model = new XcsbModel();
            model.setID(issueID);
            model.setISU_DESC(issure);
            model.setTS(new Date());
            model.setISU_STATUS("0");
            //保存问题信息
            this.saveOrUpdate(model);
        }
        if(StringUtil.isNotEmpty(issueID) && !StringUtil.isNotEmpty(issure)){
            //该巡查任务异常数减1
            String sele = "SELECT D.CK_RE_ECOUNT FROM WR_CHK_RECORD D WHERE D.CK_RE_ID = ?";
            List list=  this.findBySqlWithMap(sele,taskID);
            Map map= (Map) list.get(0);
            Integer count = new Integer(String.valueOf(map.get("CK_RE_ECOUNT")));
            String update = "UPDATE WR_CHK_RECORD D SET D.CK_RE_ECOUNT=? WHERE D.CK_RE_ID = ?";
            this.updateBySql(update,count-1,taskID);
            //删除问题
            String del="DELETE FROM WR_CH_ISSUES_B B WHERE B.ID=?";
            this.updateBySql(del,issueID);
            issueID="";
        }
        //更新巡查内容信息
        String sql1="UPDATE WR_CHK_RED_CHILD D SET D.ISSUE_ID=? WHERE D.ID = ?";
        params.add(issueID);
        params.add(ckID);
        this.updateBySql(sql1,params.toArray());
        return true;
    }

    @Override
    public Object doSave(String taskID) {
        //更改巡查内容状态(0、未开始    1、未完成    2、已完成
        String update1="UPDATE WR_CHK_RED_CHILD DD SET DD.CH_STATUS = '2' WHERE DD.CK_RE_ID=?";
        this.updateBySql(update1,taskID);
        //更改巡查任务状态  (0:未开始;   1:进行中 ; 2:已完成)
        String update2="UPDATE WR_CHK_RECORD D SET D.STATUS= '2' WHERE D.CK_RE_ID=?";
        this.updateBySql(update2,taskID);
        return true;
    }
}
