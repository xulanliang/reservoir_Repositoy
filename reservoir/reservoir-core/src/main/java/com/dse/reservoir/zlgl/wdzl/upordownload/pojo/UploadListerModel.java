package com.dse.reservoir.zlgl.wdzl.upordownload.pojo;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.ProgressListener;
/**
 * 上传监听实体类
 * Created by liuxu on 2016/12/1.
 */
public class UploadListerModel implements ProgressListener {
    /***
     * 当前上传数据(字节)
     */
    private long uploadSize;

    /**
     * 总共上传数据(字节)
     */
    private long totalSize;
    /**
     * 当前进度百分比
     */
    private String percent;

    public Long getUploadSize() {
        return uploadSize;
    }

    public void setUploadSize(Long uploadSize) {
        this.uploadSize = uploadSize;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    /***
     * 文件上传后会自动更新状态
     */
    public void update(long uploadSize, long totalSize, int items) {
        this.uploadSize = uploadSize;
        this.totalSize = totalSize;
    }

    public String getJson() {
        percent = Math.round((uploadSize / new Double(totalSize))*100) + "%";
//        return JSONObject.toJSONString(this);
        return percent;
//        return new Gson().toJson(this);
    }
}
