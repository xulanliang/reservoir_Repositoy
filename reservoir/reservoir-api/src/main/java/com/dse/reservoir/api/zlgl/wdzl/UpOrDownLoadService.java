package com.dse.reservoir.api.zlgl.wdzl;


import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.UpOrDownLoadModel;

import java.io.IOException;
import java.util.List;

/**
 * Created by 许兰良 on 2017/6/23.
 *
 * @Company 深圳市东深电子股份有限公司
 */

public interface UpOrDownLoadService {
    public Object getListFileByBids(String bids);

    /**
     *  公国pkid获取文件List
     * @param pkid
     * @return
     */
    public List getInfoById(String pkid);
    public List getInfoByBId(String bid);

    public Boolean createFileForDisk(String fildId,String filePath);

    public UpOrDownLoadModel upload(String jsonObject) throws IOException;

    /**
     * 根据主键删除文件信息
     * @param pkid
     * @return
     */
    public Boolean deleteFileByPkid(String pkid);

    /**
     *  根据BID删除文件信息
     * @param pkid
     * @return
     */
    public Boolean deleteFileByBid(String pkid);

}
