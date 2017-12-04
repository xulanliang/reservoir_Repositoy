package com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liuxu on 2016/11/22.
 */
@Entity
@Table(name = "DSE_COMMON_FILE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UpOrDownLoadModel implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    /** 主键**/
    private String pkid;
    /** 业务ID**/
    private String bid;
    /** 业务类型:1开头为防汛业务类11收发文**/
    private String btype;
    /** 文件名称**/
    private String filename;
    /** 文件路径**/
    private String filepath;
    /** 文件类型**/
    private String filetype;
    /** 文件大小**/
    private Double filesize;
    /** 文件二进制流**/
    //private byte[] filebody;
    /** 创建人**/
    private String creator;
    /** 报建时间**/
    private Date createdate;
    private byte[] filebody;

    @Id
    @Column(name = "PKID" ,  length = 32   )
    @Length(min=0, max=32, message="主键长度必须介于 0 和 32 之间")
    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }
    @Column(name = "BID" ,  length = 32   )
    @Length(min=0, max=32, message="业务ID长度必须介于 0 和 32 之间")
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
    @Column(name = "BTYPE" ,  length = 2   )
    @Length(min=0, max=2, message="业务类型:1开头为防汛业务类11收发文长度必须介于 0 和 2 之间")
    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }
    @Column(name = "FILENAME" ,  length = 100   )
    @Length(min=0, max=100, message="文件名称长度必须介于 0 和 100 之间")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    @Column(name = "FILEPATH" ,  length = 100   )
    @Length(min=0, max=100, message="文件路径长度必须介于 0 和 100 之间")
    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
    @Column(name = "FILETYPE" ,  length = 10   )
    @Length(min=0, max=10, message="文件类型长度必须介于 0 和 100 之间")
    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
    @Column(name = "FILESIZE" ,  precision = 12, scale = 3   )
    public Double getFilesize() {
        return filesize;
    }

    public void setFilesize(Double filesize) {
        this.filesize = filesize;
    }
    @Column(name = "FILEBODY")
    public byte[] getFilebody() {
        return filebody;
    }

    public void setFilebody(byte[] filebody) {
        this.filebody = filebody;
    }
    @Column(name = "CREATOR" ,  length = 20   )
    @Length(min=0, max=20, message="创建人长度必须介于 0 和 100 之间")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATEDATE" ,  length = 23   )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
