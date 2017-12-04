package com.dse.reservoir.zlgl.wdzl.service.impl;

import com.dse.reservoir.api.zlgl.wdzl.UpOrDownLoadService;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.UpOrDownLoadModel;
import com.dse.reservoir.zlgl.wdzl.dao.UpOrDownLoadDao;
import com.dse.reservoir.zlgl.wdzl.util.DseJsonUtil;
import com.dse.reservoir.zlgl.wdzl.util.DseSysCommonUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 许兰良 on 2017/6/23.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Service("upOrDownLoadService")
@Transactional
public class UpOrDownLoadServiceImpl implements UpOrDownLoadService {
    @Resource(name = "upOrDownLoadDao")
    private UpOrDownLoadDao upOrDownLoadDao;
    @Override
    public Object getListFileByBids(String bids) {
        return upOrDownLoadDao.getListFileByBids(bids);
    }
    @Override
    public List getInfoByBId(String bid) {
        return upOrDownLoadDao.getInfoByBId(bid);
    }

    @Override
    public List getInfoById(String pkid) {
        return upOrDownLoadDao.getInfoById(pkid);
    }

    @Override
    public Boolean createFileForDisk(String fildId, String filePath) {
        return upOrDownLoadDao.createFileForDisk(fildId,filePath);
    }

    @Override
    public UpOrDownLoadModel upload(String jsonObjectString){
        Map<String, Object> map= DseJsonUtil.parseToMap(jsonObjectString);
        UpOrDownLoadModel dbFileModel=new UpOrDownLoadModel();
        dbFileModel.setPkid(DseSysCommonUtil.getNewId().toString());
        dbFileModel.setBtype("1");
        dbFileModel.setFilename(map.get("fileName").toString());
        dbFileModel.setFilepath(map.get("filePath").toString());
        dbFileModel.setFiletype(map.get("fileType").toString());
        dbFileModel.setFilesize(Double.valueOf(map.get("fileSize").toString()));
        dbFileModel.setBtype(map.get("bType").toString());
        dbFileModel.setBid(map.get("bid").toString());
//        dbFileModel.setCreator(map.get("creator").toString());
        dbFileModel.setCreatedate(new Timestamp(new Date().getTime()));
        try {
            if(map.get("isSaveDb").toString().equals("1")){
                File file = new File(map.get("realFilePath").toString());
                if(file.exists()){
                    dbFileModel.setFilebody(FileUtils.readFileToByteArray(file));
                }
            }
//            getDao().saveOrUpdate(dbFileModel);
            upOrDownLoadDao.saveOrUpdate(dbFileModel);
            return dbFileModel;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean deleteFileByPkid(String pkid) {
        return upOrDownLoadDao.deleteFileByPkid(pkid);
    }

    @Override
    public Boolean deleteFileByBid(String BID) {
        return upOrDownLoadDao.deleteFileByBid(BID);
    }
}
