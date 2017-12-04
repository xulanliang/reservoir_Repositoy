//相关配置参数
var _operConfig = {

    start_year: 2000, //起始年,用于循环遍历出起始年至今的所有年份
    default_data_length: 20, //图表默认显示20条数据

    /**==值班中心==**/
    loadTime: 1, //数据刷新预加载时间，默认1秒
    refDataTime: 10,  //数据刷新时间，默认10秒
    marqueeTime: 300, //滚动提示刷新时间，默认300秒

    "东方祥云": "http://www.dfsjcloud.com/login",
    "水情系统": "http://220.163.43.236:8090/ynfxkhbb/login.jsp",
    "山洪系统": "http://220.163.43.236:8090/ynfxkhbb/login.jsp",
    "水库实时管理系统": "http://220.163.43.236:8090/ynfxkhbb/login.jsp",
    "防汛系统":"http://10.52.1.17"

    /**==end 值班中心==**/
};


DSE.uploadConfig = {
    fileToUpload_actionUrl: '/uporDownLoadCtrl/upload.do', //上传请求
    fileToUpload_progressUrl: '/uporDownLoadCtrl/getUploadProgress.do?randomId=', //进度条轮询请求, randomId 为后台接收字段名
    fileToUpload_deleteUrl: '/uporDownLoadCtrl/deleteFileByPkid.do?pkid=', //文件删除请求, pkid 为后台接收字段名
    fileToUpload_FilesListUrl: '/uporDownLoadCtrl/getListFileByBid.do?bid=', //获取已上传文件列表，bid 为后台接收字段名
    fileToUpload_downloadUrl: '/uporDownLoadCtrl/download.do?id=', //上传成功后下载请求，id 为后台接收字段名
    fileToUpload_rename: {
        url: 'uporDownLoadCtrl/renameUpFileById.do', //上传文件重命名请求
        id: 'pkid', //pkid 为后台接收字段名
        name: 'rename' //rename 为后台接收字段名
    },
    model:null,
};

//存储业务类主键,全局参数
DSE.pageConfig = {};

//存储 window 对象
DSE.window = {};

//html 相关
DSE.html = {};

//存储表单相关函数变量
DSE.form = {};

//存储用户数据
DSE.user = {};

//导出
DSE.export= {};
