package com.dse.reservoir.zlgl.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dse.common.entity.EasyUiPage;
import com.dse.common.result.InvokeResult;
import com.dse.common.result.InvokeResultMessage;
import com.dse.common.util.ConfigurationInfoUtil;
import com.dse.reservoir.api.zlgl.wdzl.UpOrDownLoadService;
import com.dse.reservoir.api.zlgl.wdzl.upOrDownload.pojo.UpOrDownLoadModel;
import com.dse.reservoir.zlgl.wdzl.upordownload.pojo.UploadListerModel;
import com.dse.reservoir.zlgl.wdzl.util.DseBeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Xll on 2017/6/23.
 *
 * @Company 深圳市东深电子股份有限公司
 */
@Controller
@RequestMapping("/uporDownLoadCtrl")
public class UporDownLoadCtrl {

    @Autowired
    private UpOrDownLoadService service;
    private static Properties props = new Properties();

    // 保存正在上传的数据列表
    private static final Map<String, UploadListerModel> uploadingList = new HashMap<String, UploadListerModel>();

    @RequestMapping(value = "/getListFileByBid")
    @ResponseBody
    public Object getListFileByBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String bid=request.getParameter("bid");//业务IDs(带逗号分隔)
            return InvokeResult.success(service.getListFileByBids(bid));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  文件上传
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String tempPath =getTempFilePath();
        Calendar cal = Calendar.getInstance();
        String configPath="uploadFiles" + File.separator + cal.get(Calendar.YEAR) + File.separator + (cal.get(Calendar.MONTH) + 1) + File.separator;
        String saveDiskPath = getSaveDiskFilePath(configPath);
        String ywid = request.getParameter("rowId");// 业务Id
        String newName = request.getParameter("newName");// 文件新名称
        String randomId = request.getParameter("randomId");// 文件随机码，实时进度条要用到
        String btype = request.getParameter("btype");//业务类型
        String creator = request.getRemoteUser();//上传人

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(20 * 1024 * 1024); // 设定使用内存超过5M时，将产生临时文件并存储于临时目录中。
        factory.setRepository(new File(tempPath)); // 设定存储临时文件的目录。
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        UploadListerModel listerModel = new UploadListerModel();
        upload.setProgressListener(listerModel);
        uploadingList.put(randomId, listerModel);

        OutputStream os = null;
        InputStream is = null;
        String newFileName = null;
        File uploadedFile=null;
        Map saveJson = new HashMap();
        JSONObject json = new JSONObject();
        try{
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> itr = items.iterator();
            while (itr.hasNext()){
                FileItem item = (FileItem) itr.next();
                if (!item.isFormField()){
                    String oldFileName=item.getName();
//                    String fileName=newName.trim().length()>0?newName:oldFileName;
                    //数据库文件名
                    String fileName=oldFileName;
                    String fileType = oldFileName.substring(oldFileName.lastIndexOf(".") + 1).toLowerCase();// 获取文件格式
                    //本地保存文件名
                    newFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + "_"+ new Random().nextInt(1000) + "." + fileType;
                    uploadedFile = new File(saveDiskPath, newFileName);
                    os = new FileOutputStream(uploadedFile);
                    is = item.getInputStream();
                    byte buf[] = new byte[1024];// 可以修改 1024 以提高读取速度
                    int length = 0;
                    while ((length = is.read(buf)) > 0) {
                        os.write(buf, 0, length);
                    }

//                    saveJson.addProperty("isSaveDb","1");
                    saveJson.put("isSaveDb","1");
                    saveJson.put("creator",creator);
                    saveJson.put("realFilePath",saveDiskPath+newFileName);
                    fileName=fileName.substring(0,fileName.indexOf("."));
                    saveJson.put("fileName",fileName);//文件名称
                    saveJson.put("bid", ywid);// 相对路径
                    saveJson.put("filePath", configPath + newFileName);// 相对路径
                    saveJson.put("fileType", fileType);// 文件类型
                    saveJson.put("fileSize",new DecimalFormat("##0.0000").format(item.getSize() / 1024.0 / 1024.0));// 文件大小
                    saveJson.put("bType",btype);
                    UpOrDownLoadModel model=service.upload(JSON.toJSONString(saveJson));
                    if(model==null){
                        uploadedFile.delete();
//                        json.addProperty("status","fail");
                        json.put("status","fail");
                        json.put("randomId", randomId);
                    }else{
                        json.put("status","success");
                        json.put("randomId", randomId);
                        json.put("pkId", model.getPkid());
                        json.put("fileSize", item.getSize());
                        json.put("createDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(model.getCreatedate()));
                    }
                }
            }
        }catch (Exception e){
            if(uploadedFile!=null&&uploadedFile.exists()){
                uploadedFile.delete();
            }
            e.printStackTrace();
            json.put("status", "fail");
            json.put("randomId", randomId);
        }
        finally {
            if(os!=null){
                os.flush();
                os.close();
            }
            if(is!=null){
                is.close();
            }
        }
        return json.toString();
    }

    /**
     *  上传Excel表导入数据
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/uploadExcel")
    @ResponseBody
    public Object uploadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String tempPath =getTempFilePath();
        Calendar cal = Calendar.getInstance();
        String configPath="uploadFiles" + File.separator;
        String saveDiskPath = getSaveDiskFilePath(configPath);
        String ywid = request.getParameter("newId");// 业务Id
        String newName = request.getParameter("newName");// 文件新名称
        String randomId = request.getParameter("randomId");// 文件随机码，实时进度条要用到
        String btype = request.getParameter("btype");//业务类型

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(20 * 1024 * 1024); // 设定使用内存超过5M时，将产生临时文件并存储于临时目录中。
        factory.setRepository(new File(tempPath)); // 设定存储临时文件的目录。
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        UploadListerModel listerModel = new UploadListerModel();
        upload.setProgressListener(listerModel);
        uploadingList.put(randomId, listerModel);

        OutputStream os = null;
        InputStream is = null;
        String newFileName = null;
        File uploadedFile=null;
        JSONObject json = new JSONObject();
        Map saveJson = new HashMap();
//        Map<Object,Object> myMap = new HashMap<Object,Object>();
        try{
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> itr = items.iterator();
            while (itr.hasNext()){
                FileItem item = (FileItem) itr.next();
                if (!item.isFormField()){
                    String oldFileName=item.getName();
                    String fileName=newName.trim().length()>0?newName:oldFileName;
                    String fileType = oldFileName.substring(oldFileName.lastIndexOf(".") + 1).toLowerCase();// 获取文件格式
                    newFileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date()) + "_"+ new Random().nextInt(1000) + "." + fileType;
//                    newFileName = oldFileName;
                    uploadedFile = new File(saveDiskPath, newFileName);
                    os = new FileOutputStream(uploadedFile);
                    is = item.getInputStream();
                    byte buf[] = new byte[1024];// 可以修改 1024 以提高读取速度
                    int length = 0;
                    while ((length = is.read(buf)) > 0) {
                        os.write(buf, 0, length);
                    }

                    saveJson.put("isSaveDb","1");
//                    saveJson.put("creator",creator);
                    saveJson.put("realFilePath",saveDiskPath+newFileName);
                    saveJson.put("fileName",newFileName);//文件名称
                    saveJson.put("bid", ywid);// 相对路径
                    saveJson.put("filePath", configPath + newFileName);// 相对路径
                    saveJson.put("fileType", fileType);// 文件类型
                    saveJson.put("fileSize",new DecimalFormat("##0.0000").format(item.getSize() / 1024.0 / 1024.0));// 文件大小
                    saveJson.put("bType",btype);
                    UpOrDownLoadModel model=service.upload(JSON.toJSONString(saveJson));
                        json.put("status","success");
                        json.put("randomId", randomId);
//                        json.put("pkId", model.getPkid());
                        json.put("fileSize", item.getSize());
                        json.put("createDate", new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date()));
                    //将文件名放入到配置文件中，以便在文件删除、保存时使用
                    try {
                        props.load(new FileInputStream("reservoir.properties"));
                        // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
                        // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
                        OutputStream fos = new FileOutputStream("reservoir.properties");
                        props.setProperty("name", "测试");
                        // 以适合使用 load 方法加载到 Properties 表中的格式，
                        // 将此 Properties 表中的属性列表（键和元素对）写入输出流
                        props.store(fos, "Update '" + "name" + "' 测试");
                    } catch (IOException e) {
                        System.err.println("属性文件更新错误");
                    }
                }
            }
        }catch (Exception e){
            if(uploadedFile!=null&&uploadedFile.exists()){
                uploadedFile.delete();
            }
            e.printStackTrace();
            json.put("status", "fail");
            json.put("randomId", randomId);
        }
        finally {
            if(os!=null){
                os.flush();
                os.close();
            }
            if(is!=null){
                is.close();
            }
        }
        return json.toString();
    }

    @RequestMapping(value = "/download")
    @ResponseBody
    public Object download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String pkid=request.getParameter("id");

            UpOrDownLoadModel model=this.getModel(pkid);

            if(model!=null){
                response.setContentType("application/octet-stream");
                response.addHeader("Content-Type", "text/html; charset=utf-8");
                String downLoadName = new String(model.getFilename().getBytes("gbk"),"iso8859-1");
                response.addHeader("Content-Disposition", "attachment;filename="+ downLoadName+"."+model.getFiletype());
                //获取本地文件相对路径
                String filePath= ConfigurationInfoUtil.get("reservoir.properties","file.path")+File.separator+model.getFilepath();
                InputStream inputStream = new FileInputStream(new File(filePath));
                OutputStream os = response.getOutputStream();
                byte[] b = new byte[2048];
                int length;
                while ((length = inputStream.read(b)) > 0) {
                    os.write(b, 0, length);
                }
                os.flush();
                os.close();
                inputStream.close();
            }
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
        return null;
    }

    public UpOrDownLoadModel getModel(String pkid){
        List list = service.getInfoById(pkid);
        if(list!=null&&list.size()>0){
            UpOrDownLoadModel model=new UpOrDownLoadModel();
            DseBeanUtils.copyProperties((Map<String,Object>)list.get(0),model);
            String filePath=joinFileDiskPath(model.getFilepath());
            File file = new File(filePath);
            if (!file.exists()) {
                if(service.createFileForDisk(pkid,filePath))
                    return model;
            }else{
                return model;
            }
        }
        return null;
    }


    /**
     * 根据主键PKID删除(并且也会将对应磁盘上的文件也进行删除)
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteFileByPkid")
    @ResponseBody
    public Object deleteFileByPkid(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception {
        try {
            String pkid=request.getParameter("pkid");
            return InvokeResult.success(service.deleteFileByPkid(pkid));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     *  根据BID删除(并且也会将对应磁盘上的文件也进行删除)
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteFileByBid")
    @ResponseBody
    public Object deleteFileByBid(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception {
        try {
            String pkid=request.getParameter("pkid");
            return InvokeResult.success(service.deleteFileByBid(pkid));
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取PDF文件所在磁盘的路径
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getPdfFilePath")
    @ResponseBody
    public Object getPdfFilePath(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception {
        try {
            String pkid=request.getParameter("pkid");
//            return InvokeResult.success(service.getPdfFilePath(pkid));
            UpOrDownLoadModel model=null;
            String filePath="";
            List list=service.getInfoById(pkid);
            if(list!=null&&list.size()>0){
                model=new UpOrDownLoadModel();
                //拷贝属性，将源map里面的属性值，拷贝到obj对象中属性中去
                DseBeanUtils.copyProperties((Map<String,Object>)list.get(0),model);
                filePath=this.joinFileDiskPath(model.getFilepath()).replace("/",File.separator);
            }
            return filePath;
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }

    /**
     * 获取文件磁盘路径
     * @param dbPath
     * @return
     */
    private String joinFileDiskPath(String dbPath){
        return ConfigurationInfoUtil.get("reservoir.properties","file.path")+File.separator+dbPath;
    }


    /**
     * 获取临时缓存文件路径
     * @return
     */
    private String getTempFilePath(){
        String tempPath = ConfigurationInfoUtil.get("reservoir.properties","file.path") + File.separator+"temp"+ File.separator + new SimpleDateFormat("yyyyMM").format(new Date()) + File.separator;
        File dirTempFile = new File(tempPath);
        if (!dirTempFile.exists()) {
            dirTempFile.mkdirs();
        }
        return tempPath;
    }


    /**
     * 获取文件磁盘保存路径
     * @return
     */
    private String getSaveDiskFilePath(String configPath) {
        String savePath = ConfigurationInfoUtil.get("reservoir.properties","file.path") + File.separator+configPath;
        // 创建文件夹
        File dirFile = new File(savePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        return savePath;
    }


    /**
     * 根据randomId查询上传进度
     * @param request
     * @param response
     * @param easyUiPage
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getUploadProgress")
    @ResponseBody
    public Object getUploadProgress(HttpServletRequest request, HttpServletResponse response, EasyUiPage easyUiPage) throws Exception {
        try {
//            String randomId = request.getParameter("randomIdrandomId");
            String randomId = request.getParameter("randomId");
            UploadListerModel up = uploadingList.get(randomId);
            String json = "No results";
            if (up != null) {
                // 打印给客户端
                json = up.getJson();
                // 如果已经上传完毕，则移除对象
                if (up.getUploadSize().longValue() == up.getTotalSize().longValue()) {
                    uploadingList.remove(randomId);
                }
            }
            return json;
        } catch (Exception e) {
            return InvokeResult.failure(new InvokeResultMessage(e.getMessage()));
        }
    }


}
