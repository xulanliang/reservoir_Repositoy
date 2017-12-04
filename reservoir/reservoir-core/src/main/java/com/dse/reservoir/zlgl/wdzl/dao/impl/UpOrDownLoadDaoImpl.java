package com.dse.reservoir.zlgl.wdzl.dao.impl;

import com.dse.common.dao.BaseDao;
import com.dse.common.util.ConfigurationInfoUtil;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.UpOrDownLoadModel;
import com.dse.reservoir.zlgl.wdzl.dao.UpOrDownLoadDao;
import com.dse.reservoir.zlgl.wdzl.util.DseBeanUtils;
import com.dse.reservoir.zlgl.wdzl.util.DseJsonUtil;
import com.dse.reservoir.zlgl.wdzl.util.DseLoadConfig;
import org.apache.commons.collections.collection.CompositeCollection;
import org.springframework.stereotype.Repository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by XLL on 2017/6/23.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Repository("upOrDownLoadDao")
public class UpOrDownLoadDaoImpl extends BaseDao implements UpOrDownLoadDao {
    @Override
    public Object getListFileByBids(String bids) {
        String[] ids=bids.split(",");
        int length=ids.length;
        if(length>0){
            StringBuffer selectSql=new StringBuffer();
            ArrayList<Object> params=new ArrayList<Object>();
            //selectSql.append("select t.pkid,t.bid,t.btype,t.filename,t.filetype,t.filesize,to_char(t.createdate,'yyyy-mm-dd') as createdate from dse_common_file t where t.bid in (");
            selectSql.append("select t.pkid,t.bid,t.btype,t.filename,t.filetype,t.filesize,to_char(t.createdate,'yyyy-mm-dd hh24:mi:ss') as createdate from dse_common_file t where t.bid in (");
            for(int i=0;i<length;i++){
                if((i+1)==length){
                    selectSql.append("?)");
                }else{
                    selectSql.append("?,");
                }
                params.add(ids[i]);
            }
            selectSql.append(" order by t.pkid desc");
//            return getDao().executeSQLRetMap(selectSql.toString(),params.toArray());
            return findBySqlWithMap(selectSql.toString(),params.toArray());
        }
        return null;
    }

    @Override
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

    @Override
    public Boolean deleteFileByBid(String bid) {
        String sql="DELETE FROM DSE_COMMON_FILE WHERE BID=?";
        UpOrDownLoadModel model=new UpOrDownLoadModel();
        try{
            List list=this.getInfoByBId(bid);
            DseBeanUtils.copyProperties(DseJsonUtil.parseToMap(DseJsonUtil.toJson(list.get(0)).toString()),model);
            deleteDiskFileByPath(model.getFilepath());
//            getDao().executeSQLInsertOrUpdate(sql,pkid);

            if(list.size()>0){
                list.get(0);
                delete(model);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List getInfoById(String pkid) {
        //return getDao().executeSQLRetMap("select t.pkid,t.bid,t.btype,t.filename,t.filepath,t.filetype,t.filesize,t.creator,to_char(t.createdate,'yyyy-mm-dd hh24:mi') as createdate from dse_common_file t where t.pkid=?",pkid);
        ArrayList<Object> params=new ArrayList<Object>();
        params.add(pkid);
        String sql = "select t.pkid,t.bid,t.btype,t.filename,t.filepath,t.filetype,t.filesize,t.creator,to_char(t.createdate,'yyyy-mm-dd hh24:mi:ss') as createdate from dse_common_file t where t.pkid=?";

        return findBySqlWithMap(sql,params.toArray());
    }

    public List getInfoByBId(String bid) {
        //return getDao().executeSQLRetMap("select t.pkid,t.bid,t.btype,t.filename,t.filepath,t.filetype,t.filesize,t.creator,to_char(t.createdate,'yyyy-mm-dd hh24:mi') as createdate from dse_common_file t where t.pkid=?",pkid);
        ArrayList<Object> params=new ArrayList<Object>();
        params.add(bid);
        String sql = "select t.pkid,t.bid,t.btype,t.filename,t.filepath,t.filetype,t.filesize,t.creator,to_char(t.createdate,'yyyy-mm-dd hh24:mi:ss') as createdate from dse_common_file t where t.bid=?";

        return findBySqlWithMap(sql,params.toArray());
    }

    @Override
    public Boolean createFileForDisk(String fileId, String filePath) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        UpOrDownLoadModel model=(UpOrDownLoadModel)get(UpOrDownLoadModel.class,fileId);
        //List fileList=this.getFileBody(fileId);
        String fileDirePath = filePath.substring(0,filePath.lastIndexOf("/"));
        File fileDire = new File(fileDirePath);
        if (!fileDire.exists()) {// 创建文件目录
            fileDire.mkdirs();
        }
        File file=new File(filePath);
        byte[] blob = model.getFilebody();
        if(blob==null||blob.length==0){
            return false;
        }
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(blob);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
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


}
