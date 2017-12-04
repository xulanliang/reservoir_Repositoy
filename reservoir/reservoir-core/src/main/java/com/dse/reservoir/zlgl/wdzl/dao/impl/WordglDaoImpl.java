package com.dse.reservoir.zlgl.wdzl.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.util.ConfigurationInfoUtil;
import com.dse.common.util.StringUtil;
import com.dse.common.util.json.JsonUtil;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.QuestionModel;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.UpOrDownLoadModel;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.WdglModel;
import com.dse.reservoir.zlgl.wdzl.dao.WordglDao;
import com.dse.reservoir.zlgl.wdzl.util.DseBeanUtils;
import com.dse.reservoir.zlgl.wdzl.util.DseJsonUtil;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Xull on 2017/6/22.
 *  文档管理
 * @Company 深圳市东深电子股份有限公司
 */
@Repository("wordglDao")
public class WordglDaoImpl extends BaseDao implements WordglDao {
    @Override
    public EasyUiPage getListInfoByParams(String adcd, String ttype, String keyword, String strDate, String endDate, EasyUiPage easyUiPage) {
        StringBuffer selectSql=new StringBuffer();
        ArrayList<Object> params=new ArrayList<Object>();// T.DID,to_char(T.IN_DT,'yyyy-mm-dd') AS TM,FILES.PKID AS FILEID,
        //
        selectSql.append("SELECT DIV.NAME AS ADCD,FILES.FILENAME,T.UPDATE_DT,T.IN_DT TM,T.INFO_CD,T.INFO_TP,T.INFO_TITLE,T.UPDATE_USER,FILES.Pkid FILEID FROM DSE_ZL_MANAGER T ");
        selectSql.append(" inner join T_SYS_ORGANIZATION div on t.adcd=div.ID");
        selectSql.append(" inner join dse_common_file files on files.bid=TO_CHAR(t.did)");
        selectSql.append(" where 1=1");
        //标题
        if(StringUtil.isNotEmpty(keyword)){
            selectSql.append(" and t.INFO_TITLE||t.UPDATE_USER||t.INFO_CD like ?");
            params.add("%"+keyword+"%");
        }
        //开始时间
        if(StringUtil.isNotEmpty(strDate)){
            selectSql.append(" and t.UPDATE_DT >=to_date(?,'yyyy-mm-dd')");
            params.add(strDate);
        }
        //结束时间
        if(StringUtil.isNotEmpty(endDate)){
            selectSql.append(" and t.UPDATE_DT-1 <=to_date(?,'yyyy-mm-dd')");
            params.add(endDate);
        }
        //文档类型
        if(StringUtil.isNotEmpty(ttype)){
            selectSql.append(" and t.INFO_TP =?");
            params.add(ttype);
        }
        //组织机构
        if(StringUtil.isNotEmpty(adcd)){
            selectSql.append(" and t.adcd like ?");
            params.add(getCode(adcd)+"%");
        }
        selectSql.append(" order by t.did desc");
        System.out.println("查询语句为："+selectSql.toString());
//        return getDao().findSQLByEasyUiPage(selectSql.toString(),easyUiPage,params.toArray());
        System.out.println("Hibernate sql: " + selectSql.toString());
        return this.findEasyUiPageBySql(selectSql.toString(),easyUiPage,params.toArray());
    }

    @Override
    public Object saveOrUpdateInfo(String dataStr,String creator) {
        if(StringUtil.isNotEmpty(dataStr)){
            WdglModel model = JsonUtil.json2Object(dataStr,WdglModel.class);
            model.setUPDATE_USER(creator);
//            List list=(List)getInfoByInfoCD(model.getINFO_CD().toString());
//            if(list==null||list.size()==0){
                 model.setUPDATE_DT(new Timestamp(new Date().getTime()));
//            }
            saveOrUpdate(model);
        }
        return true;
    }
    public List getInfoByInfoCD(String infoCD) {
        String selectSql="SELECT T.INFO_CD,T.INFO_TITLE,T.UPDATE_DT,T.IN_DT,T.INFO_TP,T.UPDATE_USER from DSE_ZL_MANAGER T WHERE T.INFO_CD=?";
        return findBySqlWithMap(selectSql,infoCD);
    }

    @Override
    public Object saveOrUpdateQuestion(List<QuestionModel> list) {
        if(list.size()>0){
            saveOrUpdate(list);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 删除信息
     * @param ids  业务ID
     * @return
     */
    @Override
    public Object deleteInfoByIds(String ids) {
        String[] arrIds=ids.split(",");
        if(arrIds!=null&&arrIds.length>0){
            String sql="DELETE FROM DSE_ZL_MANAGER  WHERE DID=?";
            for(int i=0;i<arrIds.length;i++){
                WdglModel model=new WdglModel();
                UpOrDownLoadModel upOrDownLoadModel = new UpOrDownLoadModel();
                DseBeanUtils.copyProperties((Map<String,Object>)this.getupOrDownLoadModelInfoById(arrIds[i]).get(0),upOrDownLoadModel);
                DseBeanUtils.copyProperties((Map<String,Object>)this.getInfoById(upOrDownLoadModel.getBid()).get(0),model);

                //删除文件   DSE_COMMON_FILE 实体类是   UpOrDownLoadModel
                delete(upOrDownLoadModel);
                //删除文档基本信息  DSE_ZL_MANAGER  实体类是 WdglModel
                StringBuffer str = new StringBuffer();
                str.append("DELETE FROM DSE_ZL_MANAGER R WHERE R.INFO_CD = ?");
                this.updateBySql(str.toString(),model.getINFO_CD());
                //删除本地文件
                deleteFileByPkid(upOrDownLoadModel.getPkid());

            }
        }
        return true;
    }

    public Boolean deleteFileByPkid(String pkid) {
        String sql="delete from dse_common_file where pkid=?";
        UpOrDownLoadModel model=new UpOrDownLoadModel();
        try{
            List list=this.getInfoById(pkid);
            DseBeanUtils.copyProperties(DseJsonUtil.parseToMap(DseJsonUtil.toJson(list.get(0)).toString()),model);
            //删除本地文件
            deleteDiskFileByPath(model.getFilepath());
//            getDao().executeSQLInsertOrUpdate(sql,pkid);

            if(list.size()>0){
                list.get(0);
                //删除数据库文件
                delete(model);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private boolean deleteDiskFileByPath(String bdFilePath){
        String diskPath=joinFileDiskPath(bdFilePath);
        File file=new File(diskPath);
        if(file.exists()){
            file.delete();
        }
        return true;
    }

    /**
     * 获取文件磁盘路径
     * @param dbPath
     * @return
     */
    private String joinFileDiskPath(String dbPath){
//        return DseLoadConfig.getValueByKey("uploadDir")+File.separator+dbPath;
        return ConfigurationInfoUtil.get("reservoir.properties","file.path")+File.separator+dbPath;
    }

    public List getInfoById(String id) {
        String selectSql="SELECT T.INFO_CD,T.INFO_TITLE,T.UPDATE_DT,T.IN_DT,T.INFO_TP,T.UPDATE_USER from DSE_ZL_MANAGER T WHERE T.DID=?";
        return findBySqlWithMap(selectSql,id);
    }

    public List getupOrDownLoadModelInfoById(String id) {
        String selectSql="SELECT T.PKID,T.BID,T.BTYPE,T.FILENAME,T.FILEPATH,T.FILETYPE,T.FILESIZE,T.CREATOR,T.CREATEDATE FROM DSE_COMMON_FILE T WHERE T.PKID=?";
        return findBySqlWithMap(selectSql,id);
    }


    /**
     * 去除行政区划右边‘000’
     */
    public static String getCode(String adcd) {
        String code = adcd.trim();
        if (code != null && !code.toString().trim().equals("")&& !code.toString().trim().toLowerCase().equals("null")) {
            while (code.length()>6 &&"000".equals(code.substring(code.length() - 3, code.length()))) {
                code = code.substring(0, code.length() - 3);
            }

            while (code.length() < 7&& "00".equals(code.substring(code.length() - 2,code.length()))) {
                code = code.substring(0, code.length() - 2);
            }
        }
        return code;
    }

}
