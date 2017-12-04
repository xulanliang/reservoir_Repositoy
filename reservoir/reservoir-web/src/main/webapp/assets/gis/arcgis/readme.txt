程序目录说明:

--common 用于存放框架中通用代码
--controls 用于存放自定义组件
--demo  程序示例程序
--layers 用于存放自定义图层
--themes 程序样式文件存存放位置
--tools 工具代码存放位置.
--utils 地图工具类存放位置.


demo 程序配置说明：

(1)在tomcat中部署 arcgis server api for javascript.

(2)在dseMap.Include.js文件中修改arcgis_js_api的部署地址. 如下所示:

//ArcGIS JS API 部署地址.
var __hostnameAndPathAndDojo ="localhost:8080/arcgis_js_api/library/3.16";
//当前启用的主题文件.
var styleName = "themes/claro";
//框架所在的项目位置
var dseGisPath =baseUrl+ "WebContent/assets/gis/arcgis/";



备注: 本文件夹中的所有程序之前版本的通用框架，只为兼容原有GIS项目，后期会持续修复该框架中的问题和添加信息能,在新版的框架设计中，将会按照新版的设计进行实现。
