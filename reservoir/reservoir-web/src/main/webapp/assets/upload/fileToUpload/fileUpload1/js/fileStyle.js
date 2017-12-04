define(function(require, exports, module) {
    var _fileToUpload = require('fileToUpload');
    var o = {};

    o.fileStyle = _fileToUpload.app;

    //定义业务参数配置
    var  userName1='';
    if(DSE.user!=null){
        userName1=DSE.user.userName;
    }else{
            if(parent.DSE.user!=null){
                userName1=parent.DSE.user.userName;
            }
    }
    //o.fileStyle.userName = DSE.user.userName || parent.DSE.user.userName;
    o.fileStyle.userName = userName1;
    var  rowId1='';
    var  operType1='';

    if(DSE.pageConfig!=null){
        //rowId1=DSE.pageConfig.rowId;
        operType1=DSE.pageConfig.operType;
    }else{
        if(parent.DSE.pageConfig!=null){
            //rowId1=parent.DSE.pageConfig.rowId;
            operType1=parent.DSE.pageConfig.operType;
        }
    }
    o.fileStyle.rowId = DSE.pageConfig.rowId || parent.DSE.pageConfig.rowId;
    //o.fileStyle.rowId =rowId1;
    //o.fileStyle.operType = DSE.pageConfig.operType || parent.DSE.pageConfig.operType;
    o.fileStyle.operType =operType1;

    if (o.fileStyle.operType != 'add') {
        var bid = DSE.pageConfig.bid ? DSE.pageConfig.bid : o.fileStyle.rowId;
        //获取上传文件列表
        o.fileStyle.getFilesList(bid);
    }

    return o;
});
