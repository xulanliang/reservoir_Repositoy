package com.dse.reservoir.zlgl.wdzl.dao;

import com.dse.common.dao.IBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XLL on 2017/6/23.
 *
 * @Company 深圳市东深电子股份有限公司
 */
public interface UpOrDownLoadDao extends IBaseDao {
    public Object getListFileByBids(String bids);


    public List getInfoById(String pkis);

    public List getInfoByBId(String bid);

    public Boolean createFileForDisk(String fileId,String filePath);



    /**
     * 根据主键删除文件信息
     * @param pkid
     * @return
     */
    public Boolean deleteFileByPkid(String pkid);

    /**
     *  根据BID删除文件信息
     * @param bid
     * @return
     */
    public Boolean deleteFileByBid(String bid);
}
