// All material copyright ESRI, All Rights Reserved, unless otherwise specified.
// See http://js.arcgis.com/3.16/esri/copyright.txt for details.
//>>built
define("esri/dijit/analysis/utils","dojo/_base/declare dojo/_base/lang dojo/_base/array dojo/_base/connect dojo/_base/event dojo/_base/json dojo/dom-attr dojo/has dojo/i18n dojo/io-query dojo/i18n!../../nls/jsapi dojo/json dojo/string dojo/query dojo/date/locale dojo/dom-style dojo/dom-class dojo/dom-construct dojo/Deferred dojo/number dojo/_base/window dojo/when dojo/data/ItemFileWriteStore dijit/registry dijit/Dialog dijit/form/CheckBox ../../kernel ../../lang ../../request ./HelpWindow ../../tasks/query ../../dijit/BrowseItems ../../layers/FeatureLayer ./PluginAnalysisLayers ../../tasks/Geoprocessor ../../dijit/SingleFilter".split(" "),
function(t,f,n,B,C,D,w,E,U,F,r,G,p,x,y,s,H,k,z,u,I,J,K,L,M,A,N,l,O,P,Q,R,S,V,T,W){t={};f.mixin(t,{_helpDialog:null,i18n:null,initHelpLinks:function(a,b,d){this._helpDialog||(this._helpDialog=new P);if(a){var c=L.byNode(a),e=c?c.get("helpFileName"):d&&d.helpFileName?d.helpFileName:null,g=c?c.get("isSingleTenant"):d&&d.isSingleTenant?d.isSingleTenant:!1;x("[esriHelpTopic]",a).forEach(function(c,m,X){c&&(s.set(c,"display",!l.isDefined(b)||!0===b?"":"none"),B.connect(c,"onclick",f.hitch(this,function(b){C.stop(b);
this._helpDialog.show(b,{helpId:w.get(c,"esriHelpTopic"),helpFileName:e,analysisGpServer:d&&d.analysisGpServer?d.analysisGpServer:null,helpParentNode:a,isPortal:g})})))},this)}},constructAnalysisFeatColl:function(a){var b={},d;b.featureCollection=a.layerDefinition;for(d in b.featureCollection)b.featureCollection.hasOwnProperty(d)&&"objectIdField"===d&&(b.featureCollection.objectIdFieldName=f.clone(b.featureCollection.objectIdField),delete b.featureCollection.objectIdField);b.featureCollection.features=
a.featureSet.features;return b},constructAnalysisInputLyrObj:function(a){var b={},d,c=a.getMap()||a._map,e;if(a.url&&!a._collection){b={url:a.url};d=this.isHostedService(a.url);e=10.2<=a.version&&a._useStandardizedQueries;a.getDefinitionExpression&&a.getDefinitionExpression()?b.filter=a.getDefinitionExpression():l.isDefined(a.definitionExpression)&&""!==a.definitionExpression&&(b.filter=a.definitionExpression);if(a.useMapTime&&a.timeInfo&&c.timeExtent&&(e||d||10.2<=a.version))e="",a.timeInfo.startTimeField&&
!a.timeInfo.endTimeField?(c.timeExtent.startTime&&(e=a.timeInfo.startTimeField+" \x3e "+(d?"":"timestamp ")+"'"+this.formatDate(c.timeExtent.startTime)+"'"),c.timeExtent.endTime&&(c.timeExtent.startTime&&(e+=" AND "),e+=a.timeInfo.startTimeField+" \x3c "+(d?"":"timestamp ")+"'"+this.formatDate(c.timeExtent.endTime)+"'")):!a.timeInfo.startTimeField&&a.timeInfo.endTimeField?(c.timeExtent.startTime&&(e=a.timeInfo.endTimeField+" \x3e "+(d?"":"timestamp ")+"'"+this.formatDate(c.timeExtent.startTime)+"'"),
c.timeExtent.endTime&&(c.timeExtent.startTime&&(e+=" AND "),e+=a.timeInfo.endTimeField+" \x3c "+(d?"":"timestamp ")+"'"+this.formatDate(c.timeExtent.endTime)+"'")):a.timeInfo.startTimeField&&a.timeInfo.endTimeField&&(c.timeExtent.startTime&&(e=a.timeInfo.startTimeField+" \x3e "+(d?"":"timestamp ")+"'"+this.formatDate(c.timeExtent.startTime)+"'"),c.timeExtent.endTime&&(c.timeExtent.startTime&&(e+=" AND "),e+=a.timeInfo.endTimeField+" \x3c "+(d?"":"timestamp ")+"'"+this.formatDate(c.timeExtent.endTime)+
"'")),b.filter=b.filter?b.filter+(" AND "+e):e;a.credential&&(b.serviceToken=a.credential.token);-1!==b.url.indexOf("?")&&(a=b.url.substring(b.url.indexOf("?")+1,b.url.length),a=F.queryToObject(a),f.mixin(b,a),b.url=b.url.substring(0,b.url.indexOf("?")))}else if(!a.url||a._collection)try{b=a.toJson()}catch(g){a._json=G.parse(a._json),b=a.toJson()}return b},formatDate:function(a){return y.format(a,{datePattern:"yyyy-MM-dd",selector:"date"})+" "+y.format(a,{selector:"time",timePattern:"HH:mm:ss"})},
isHostedService:function(a){if(!a)return!1;var b=-1!==a.indexOf(".arcgis.com/");a=-1!==a.indexOf("//services")||-1!==a.indexOf("//tiles")||-1!==a.indexOf("//features");return b&&a},buildReport:function(a,b){var d="";b||(b={},f.mixin(b,r.analysisMsgCodes));n.forEach(a,function(a,e){var g,h,m;"string"===typeof a.message?(g=l.isDefined(b[a.messageCode])?b[a.messageCode]:a.message,d+=a.style.substring(0,a.style.indexOf("\x3c/"))+(!this._isEmptyObject(a.params)?p.substitute(g,a.params):g)+a.style.substring(a.style.indexOf("\x3c/"))):
f.isArray(a.message)&&(m=[],h=f.clone(a.style),n.forEach(a.message,function(d,e){h=h.replace(/<\//,"${"+e+"}");g=l.isDefined(b[a.messageCode+"_"+e])?b[a.messageCode+"_"+e]:d;g=!this._isEmptyObject(a.params)?p.substitute(g,a.params):g;m.push(g+"\x3c/")},this),h=p.substitute(h,m),d+=h)},this);return d},getLayerFeatureCount:function(a,b){var d=new Q;d.geometry=b.geometry||"";d.where=b.where||"1\x3d1";d.geometryType=b.geometryType||"esriGeometryEnvelope";return a.queryCount(d)},createPolygonFeatureCollection:function(a){var b;
b={layerDefinition:null,featureSet:{features:[],geometryType:"esriGeometryPolygon"}};b.layerDefinition={currentVersion:10.2,copyrightText:"",defaultVisibility:!0,relationships:[],isDataVersioned:!1,supportsRollbackOnFailureParameter:!0,supportsStatistics:!0,supportsAdvancedQueries:!0,geometryType:"esriGeometryPolygon",minScale:0,maxScale:0,objectIdField:"OBJECTID",templates:[],type:"Feature Layer",displayField:"TITLE",visibilityField:"VISIBLE",name:a,hasAttachments:!1,typeIdField:"TYPEID",capabilities:"Query",
allowGeometryUpdates:!0,htmlPopupType:"",hasM:!1,hasZ:!1,globalIdField:"",supportedQueryFormats:"JSON",hasStaticData:!1,maxRecordCount:-1,indexes:[],types:[],drawingInfo:{renderer:{type:"simple",symbol:{color:[0,0,0,255],outline:{color:[0,0,0,255],width:3,type:"esriSLS",style:"esriSLSSolid"},type:"esriSFS",style:"esriSFSNull"},label:"",description:""},transparency:0,labelingInfo:null,fixedSymbols:!0},fields:[{alias:"OBJECTID",name:"OBJECTID",type:"esriFieldTypeOID",editable:!1},{alias:"Title",name:"TITLE",
length:50,type:"esriFieldTypeString",editable:!0},{alias:"Visible",name:"VISIBLE",type:"esriFieldTypeInteger",editable:!0},{alias:"Description",name:"DESCRIPTION",length:1073741822,type:"esriFieldTypeString",editable:!0},{alias:"Type ID",name:"TYPEID",type:"esriFieldTypeInteger",editable:!0}]};return b},createPointFeatureCollection:function(a){var b;b={layerDefinition:null,featureSet:{features:[],geometryType:"esriGeometryPoint"}};b.layerDefinition={objectIdField:"OBJECTID",templates:[],type:"Feature Layer",
drawingInfo:{renderer:{field1:"TYPEID",type:"simple",symbol:{height:24,xoffset:0,yoffset:12,width:24,contentType:"image/png",type:"esriPMS",url:"http://static.arcgis.com/images/Symbols/Basic/GreenStickpin.png"},description:"",value:"0",label:"Stickpin"}},displayField:"TITLE",visibilityField:"VISIBLE",name:a,hasAttachments:!1,typeIdField:"TYPEID",capabilities:"Query",types:[],geometryType:"esriGeometryPoint",fields:[{alias:"OBJECTID",name:"OBJECTID",type:"esriFieldTypeOID",editable:!1},{alias:"Title",
name:"TITLE",length:50,type:"esriFieldTypeString",editable:!0},{alias:"Visible",name:"VISIBLE",type:"esriFieldTypeInteger",editable:!0},{alias:"Description",name:"DESCRIPTION",length:1073741822,type:"esriFieldTypeString",editable:!0},{alias:"Type ID",name:"TYPEID",type:"esriFieldTypeInteger",editable:!0}]};return b},createFolderStore:function(a,b){var d=new K({data:{identifier:"id",label:"name",items:[]}});d.newItem({name:b,id:""});n.forEach(a,function(a){d.newItem({name:a.title,id:a.id})});return d},
setupFoldersUI:function(a){a.folderSelect.set("store",a.folderStore);a.folderSelect.set("required",!0);a.folderSelect.set("searchAttr","name");l.isDefined(a.folderId)?a.folderStore.get(a.folderId).then(f.hitch(this,function(b){l.isDefined(b)?a.folderSelect.set("item",b):a.folderStore.get("").then(function(b){a.folderSelect.set("item",b)},this)})):a.folderName?a.folderStore.fetch({query:{name:a.folderName},onComplete:f.hitch(this,function(b){l.isDefined(b)&&0<b.length?a.folderSelect.set("item",b[0]):
a.folderStore.get("").then(function(b){a.folderSelect.set("item",b)},this)})}):a.username?a.folderSelect.set("displayedValue",a.username):a.folderStore.get("").then(function(b){a.folderSelect.set("item",b)},this)},_isEmptyObject:function(a){for(var b in a)if(a.hasOwnProperty(b))return!1;return!0},validateServiceName:function(a,b){var d=/(:|&|<|>|%|#|\?|\\|\"|\/|\+)/.test(a),c=!0,e,g;l.isDefined(b)&&b.textInput&&(g=b.textInput);this.initI18n();0===a.length||0===p.trim(a).length?(e=this.i18n.requiredValue,
c=!1):d?(e=this.i18n.invalidServiceName,c=!1):98<a.length?(e=this.i18n.invalidServiceNameLength,c=!1):170<encodeURIComponent(a).length&&(e=this.i18n.invalidEncodedServiceNameLength,c=!1);g&&!c&&g.set("invalidMessage",e);return c},getStepNumber:function(a){x(".esriAnalysisNumberLabel",a).forEach(function(a,d){var c=this._getNumberLabel(d);w.set(a,"innerHTML",c)},this)},_getNumberLabel:function(a){var b="";this.initI18n();switch(a){case 0:b=this.i18n.oneLabel;break;case 1:b=this.i18n.twoLabel;break;
case 2:b=this.i18n.threeLabel;break;case 3:b=this.i18n.fourLabel;break;case 4:b=this.i18n.fiveLabel;break;case 5:b=this.i18n.sixLabel;break;case 6:b=this.i18n.sevenLabel;break;case 7:b=this.i18n.eightLabel;break;case 8:b=this.i18n.nineLabel}return b},populateAnalysisLayers:function(a,b,d,c){if(a){var e=[],g=a.get(b);a._titleRow&&s.set(a._titleRow,"display","none");a._analysisLabelRow&&s.set(a._analysisLabelRow,"display","table-row");a._selectAnalysisRow&&(s.set(a._selectAnalysisRow,"display","table-row"),
H.add(a._analysisSelect.domNode,"esriTrailingMargin3"),s.set(a._analysisSelect.domNode.parentNode,"padding-bottom","1em"));a.domNode&&this.getStepNumber(a.domNode);l.isDefined(c)&&c.chooseLabel&&e.push({value:-1,label:this.i18n.chooseLabel});if(!l.isDefined(c)||!l.isDefined(c.posIncrement))l.isDefined(c)||(c={}),c.posIncrement=0;n.forEach(a.get(d),function(a,b){b+=c.posIncrement;var d={value:l.isDefined(c)&&c.chooseLabel?b+1:b,label:a.name};g&&a.name===g.name&&(d.selected=!0);e.push(d)},this);a._analysisSelect.addOption(e);
a._analysisSelect.set("required",!0)}},isValidAnalysisLayer:function(a){var b,d,c,e,g,h,m,f="",q=!0;b={isValid:q,validationMessage:f};var v,k,r=0,s=0,t=0;if(!l.isDefined(a)||!l.isDefined(a.toolName))return b;this.initI18n();l.isDefined(this.i18n.cblPointMsg)||(this.i18n.cblPointMsg="You need to have at least one point feature layer to run ${toolName}.",console.log("was empty initialized"));b=a.toolName;d=a.featureLayers;c=a.analysisLayer;e=b.charAt(0).toLowerCase()+b.substring(1);m=this.i18n;a=a.showReadyToUseLayers||
!1;n.forEach(d,function(a){"esriGeometryPoint"===a.geometryType&&(h=!0,r++);if("esriGeometryPoint"===a.geometryType||"esriGeometryMultipoint"===a.geometryType)v=!0;"esriGeometryPolyline"===a.geometryType&&(k=!0,t++);"esriGeometryPolygon"===a.geometryType&&(g=!0,s++)},this);if(-1!==n.indexOf(["CreateDriveTimeAreas","PlanRoutes","ConnectOriginsToDestinations"],b)&&(!h||c&&"esriGeometryPoint"!==c.geometryType))f=p.substitute(this.i18n.selectPointLayer,{toolName:m[e]}),q=!1;else if(("AggregatePoints"===
b||"InterpolatePoints"===b)&&(c&&!("esriGeometryPoint"===c.geometryType||"esriGeometryMultipoint"===c.geometryType)||!v))f=p.substitute(this.i18n.selectPointLayer,{toolName:m[e]}),q=!1;else if("CalculateDensity"===b&&(!v&&!k||c&&!("esriGeometryPoint"===c.geometryType||"esriGeometryMultipoint"===c.geometryType||"esriGeometryPolyline"===c.geometryType)))f=p.substitute(this.i18n.areaFeatureInvalidMsg,{toolName:m[e]}),q=!1;else if("FindHotSpots"===b&&(!v&&!g||c&&!("esriGeometryPoint"===c.geometryType||
"esriGeometryMultipoint"===c.geometryType||"esriGeometryPolygon"===c.geometryType)))f=p.substitute(this.i18n.hotspotsLineFeatureMsg,{toolName:m[e]}),q=!1;else if(("OverlayLayers"===b||"AggregatePoints"===b||"SummarizeWithin"===b||"SummarizeNearby"===b||"FindNearest"===b||"MergeLayers"===b)&&!a&&(0===d.length||1===d.length&&(d[0]===c||!l.isDefined(c))))f=p.substitute(this.i18n.overlayValidationMsg,{toolName:m[e]}),q=!1;else if("ConnectOriginsToDestinations"===b&&!a&&(0===d.length||2>r))f=p.substitute(this.i18n.odPointMsg,
{toolName:m[e]}),q=!1;else if("ChooseBestFacilities"===b&&(0===d.length||0===r))f=p.substitute(this.i18n.cblPointMsg,{toolName:m[e]}),q=!1;else if("AggregatePoints"===b&&!a&&1<d.length)g=n.some(d,function(a){return"esriGeometryPolygon"===a.geometryType}),g||(f=p.substitute(this.i18n.aggregatePolyMsg,{toolName:m[e]}),q=!1);else if("MergeLayers"===b&&!a&&1<d.length)1<r||(1<t||1<s)||(f=this.i18n.mergeValidationMsg,q=!1);else if(("SummarizeWithin"===b||"DissolveBoundaries"===b)&&(c&&"esriGeometryPolygon"!==
c.geometryType||!g))f=p.substitute(this.i18n.selectPolyLayer,{toolName:m[e]}),q=!1;else if("ExtractData"===b)(q=n.some(d,function(a){return-1!==a.capabilities.indexOf("Extract")}))||(f=p.substitute(this.i18n.extractValidationMsg));else if(("ConnectOriginsToDestinations"===b||"ChooseBestFacilities"===b)&&1<d.length)h=n.some(d,function(a){var b=l.isDefined(c)&&c.id===a.id;return"esriGeometryPoint"===a.geometryType&&!b}),h||(f=p.substitute("ChooseBestFacilities"===b?this.i18n.cblPointMsg:this.i18n.odPointMsg,
{toolName:m[e]}),q=!1);return b={isValid:q,validationMessage:f}},initI18n:function(){this.i18n||(this.i18n={},f.mixin(this.i18n,r.common),f.mixin(this.i18n,r.analysisTools),f.mixin(this.i18n,r.analysisMsgCodes),f.mixin(this.i18n,r.browseLayersDlg),f.mixin(this.i18n,r.driveTimes))},addBrowseAnalysisDialog:function(a){var b=[];if(a&&a.widget){this.i18n||this.initI18n();b.push({label:this.i18n.categoryAll,value:"analysis ready"});b.push({label:this.i18n.categoryBoundaries,value:"boundaries OR places"});
b.push({label:"\x26nbsp;\x26nbsp;\x26nbsp;\x26nbsp;"+this.i18n.subCategoryBoundaries,value:"boundaries"});b.push({label:"\x26nbsp;\x26nbsp;\x26nbsp;\x26nbsp;"+this.i18n.subCategoryPlaces,value:"places"});b.push({label:this.i18n.categoryHexBins,value:"hex"});b.push({label:this.i18n.categoryTransportation,value:"transportation"});var d=I.doc.createDocumentFragment(),d=k.create("div",{style:"width:100%;height:100%;"},d),c=k.create("div",{style:"width:100%;height:10%;","class":""},d),e=k.create("div",
{style:"width:100%"},d),g=new R({portalUrl:a.widget.get("portalUrl"),message:"",plugin:"esri/dijit/analysis/PluginAnalysisLayers",sortDescending:!0,sort:"title",self:a.widget.get("portalSelf"),categories:b,categoryType:"tags",selectedCategory:"boundaries OR places",pagingLinks:3,itemsPerPage:6,"class":"esriBrowseAnalysisLayers itemsGallery esriFloatLeading",closePopupPerRow:!1,extent:a.widget.get("map").extent,useExtent:!0,fetchTimeout:600,galleryTemplate:'\x3cdiv style\x3d\'opacity:1;\' class\x3d\'grid-item gallery-view galleryNode\'\x3e${item:_formatItemTitle}${item:_formatThumbnail}\x3cdiv class\x3d"linksDiv" style\x3d\'display:none;\'\x3e\x3cdiv class\x3d"esriItemLinks"\x3e\x3cdiv class\x3d"esriFloatLeading"\x3e\x3ca style\x3d"text-decoration: none;"\x3e\x3cspan\x3eAdd layer to analysis\x3c/span\x3e\x3cdiv class\x3d"dijitReset dijitInline esriArrows"\x3e\x3c/div\x3e\x3c/a\x3e\x3c/div\x3e\x3c/div\x3e\x3c/div\x3e',
formatThumbnail:function(a){return"\x3cimg class\x3d'grid-item galleryThumbnail' width\x3d'120px' height\x3d'80px' alt\x3d'' src\x3d'"+(a.thumbnailUrl||this._portal.staticImagesUrl+"/desktopapp.png")+"'\x3e"},formatItemTitle:function(a){return'\x3cdiv class\x3d"galleryLabelContainer"\x3e\x3cspan alt\x3d\''+(a.title||a.name||"\x3cNo Title\x3e")+"'\x3e"+(a.title.replace(/_/g," ")||a.name.replace(/_/g," ")||"\x3cNo Title\x3e")+"\x3c/span\x3e\x3c/div\x3e"},style:"width:600px;height:90%;clear:both;"},
e),e=k.toDom('\x3ctable cellpadding\x3d"0" cellspacing\x3d"0" class\x3d"esriFloatTrailing"\x3e');k.place(e,c);var h,c=k.create("tr",null,e),b=k.create("td",null,c);k.create("td",{innerHTML:"\x26nbsp;"},c);c=k.create("td",null,c);h=k.create("tr",null,e);e=k.create("td",{style:"padding-bottom: 0.5em"},h);k.create("td",{style:"padding-bottom: 0.5em",innerHTML:"\x26nbsp;"},h);h=k.create("td",{style:"padding-bottom: 0.5em"},h);k.create("label",{"for":a.widget.id+"_addlayercheck","class":"",innerHTML:this.i18n.addLayer},
c);b=new A({name:"addlayer",id:a.widget.id+"_addlayercheck","class":"",value:!1,checked:!1},k.create("input",{},b));k.create("label",{"for":a.widget.id+"_addextentcheck","class":"",innerHTML:this.i18n.withinMapArea},h);new A({name:"extentcheck",id:a.widget.id+"_addextentcheck","class":"",value:!0,checked:!0,onChange:f.hitch(this,function(a){g.set("useExtent",a)})},k.create("input",{},e));d=new M({title:this.i18n.browseAnalysisTitle,content:d,doLayout:!0,browseItems:g,addlayerCheckBox:b,style:"padding:.75em 0;background-color: #fff;"});
a.widget.own(a.widget.get("map").on("extent-change",f.hitch(a.widget,function(b){console.log("new extent",a.widget.get("map").extent);g.set("extent",a.widget.get("map").extent)})));return d}},addAnalysisReadyLayer:function(a){if(l.isDefined(a)&&l.isDefined(a.item)&&l.isDefined(a.layersSelect)&&l.isDefined(a.layers)&&l.isDefined(a.browseDialog)){a.browseDialog.browseItems._closePopup();a.browseDialog.hide();var b={url:a.item.url&&-1!==window.location.protocol.indexOf("https:")?a.item.url.replace("http:",
"https:")+"/0":a.item.url+"/0",itemId:a.item.id,title:a.item.title,analysisReady:!0},d,c=n.some(a.layers,function(a,c){var e=a.analysisReady&&b.analysisReady&&a.itemId===b.itemId;e&&(d=c);return e}),e,g,h,m=new z,k;c?(a.posIncrement&&(d+=a.posIncrement),a.browseDialog.addlayerCheckBox.get("checked")&&(a.posIncrement||(a.posIncrement=0),k=a.layers[d-a.posIncrement],a.widget.map.getLayer(k.lyr.id)||(this._addLayerHandle&&this._addLayerHandle.remove(),this._addLayerHandle=a.widget.map.on("layer-add",
f.hitch(this,function(b){this._addLayerHandle.remove();a.widget.emit("add-ready-to-use-layer",{layer:b.layer,layerInfo:k.linfo,item:k})})),a.widget.map.addLayer(k.lyr))),a.layersSelect.set("value",d),a.browseDialog.browseItems.clear(),m.resolve()):(m=O({url:b.url,content:{f:"json"}}),m.then(f.hitch(this,function(d){var c=new S(b.url,{outFields:["*"]});f.mixin(b,c);f.mixin(b,d);b.id=b.title+"_"+d.id;b.title=b.title.replace(/_/g," ");b.name=b.title;b.version=b.currentVersion;h=a.layersSelect.getOptions();
e=h.splice(h.length-2,2);a.layersSelect.removeOption(e);g=a.layers.length;a.posIncrement&&(g+=a.posIncrement);e.unshift({value:g,label:b.title,selected:!0});a.layersSelect.addOption(e);a.layersSelect.set("value",g);b.lyr=c;b.linfo=d;a.layers.push(b);c.name=b.name;a.browseDialog.addlayerCheckBox.get("checked")&&(this._addLayerHandle&&this._addLayerHandle.remove(),this._addLayerHandle=a.widget.map.on("layer-add",f.hitch(this,function(c){this._addLayerHandle.remove();a.widget.emit("add-ready-to-use-layer",
{layer:c.layer,layerInfo:d,item:b})})),a.widget.map.addLayer(c));a.browseDialog.browseItems.clear()})));return m.promise}},addReadyToUseLayerOption:function(a,b){a&&a.showReadyToUseLayers&&(b||(b=[]),a.signInPromise.then(f.hitch(this,function(){n.forEach(b,function(b){b.addOption({type:"separator",value:""});b.addOption({value:"browse",label:a.i18n.browseAnalysisTitle})},this);l.isDefined(a._browsedlg)||(a._browsedlg=this.addBrowseAnalysisDialog({widget:a}),a.own(a._browsedlg.browseItems.on("select-change",
f.hitch(a,a._handleBrowseItemsSelect)),a._browsedlg.on("hide",f.hitch(a,function(){a._browsedlg.browseItems._closePopup();n.forEach(b,function(a){"browse"===a.get("value")&&a.reset()})}))))})))},getMaxInputByMode:function(a){var b;if(a&&a.units&&a.type){if("StraightLine"===a.type)"Miles"===a.units?b=1E3:"Yards"===a.units?b=176E4:"Kilometers"===a.units?b=u.format(1609.34,{places:2}):"Meters"===a.units?b=u.format(1609340,{places:2}):"Feet"===a.units&&(b=528E4);else if("DrivingDistance"===a.type||"TruckingDistance"===
a.type||"WalkingDistance"===a.type)"Miles"===a.units?b=300:"Yards"===a.units?b=528E3:"Kilometers"===a.units?b=u.format(482.802,{places:2}):"Meters"===a.units?b=u.format(482802,{places:2}):"Feet"===a.units&&(b=1584E3);else if("DrivingTime"===a.type||"TruckingTime"===a.type||"WalkingTime"===a.type)"Minutes"===a.units?b=300:"Seconds"===a.units?b=18E3:"Hours"===a.units&&(b=5);return b}},updateModeConstraints:function(a){var b;a&&(a.validateWidget&&a.units&&a.type)&&(b=a.validateWidget.get("constraints"),
b.max=this.getMaxInputByMode(a),a.validateWidget.set(b))},getTravelModes:function(a){var b=new z,d,c,e,g;l.isDefined(this.travelModes)&&0<this.travelModes.length?b.resolve(this.travelModes):!a||!a.widget?b.reject(Error("Missing parameter: params.widget required parameter")):a.widget.signInPromise.then(f.hitch(this,function(h){(g=a.widget.get("helperServices"))&&g.routingUtilities?(e=g.routingUtilities.url,d="sync"):d=a.widget._getSelf(a.widget.portalUrl);J(d,f.hitch(this,function(a){var d={};a&&(a.helperServices&&
a.helperServices.routingUtilities)&&(e=a.helperServices.routingUtilities.url);l.isDefined(e)?(c=new T(e+"/GetTravelModes"),c.execute(d).then(f.hitch(this,function(a){this.travelModes=n.map(a[0].value&&a[0].value.features,function(a){return D.fromJson(a.attributes.TravelMode)});a[1]&&(a[1].paramName&&"defaultTravelMode"===a[1].paramName)&&(this.defaultTravelModeId=a[1].value);b.resolve(this.travelModes)}),f.hitch(this,function(a){b.reject(a)}))):b.reject(Error("Missing Routing Utility Service to get Travel Modes"))}),
function(a){b.reject(a)})}));return b.promise},populateTravelModes:function(a){if(a&&a.selectWidget&&a.widget){var b=[],d=a.allowmode||"all";this.initI18n();a.addStraightLine&&b.push({value:"StraightLine",label:'\x3cdiv class\x3d"esriFloatLeading bufferIcon esriStraightLineDistanceIcon"\x3e\x3c/div\x3e\x3cdiv class\x3d"esriLeadingMargin4" style\x3d"height:20px;margin-top:10px;"\x3e'+this.i18n.straightLineDistance+"\x3c/div\x3e"});this.getTravelModes({widget:a.widget}).then(f.hitch(this,function(c){n.forEach(c,
function(c,f){var h=c.name,k=h.replace(/\s/g,a.separator||""),p="AUTOMOBILE"===c.type?"Driving":"TRUCK"===c.type?"Trucking":"WALK"===c.type?"Walking":"Other",q=p.toLowerCase(),n=c.units||h.split(/\s/)[1],r=l.isDefined(a.enableTravelModes)&&!a.enableTravelModes,n=c.impedanceAttributeName===c.timeAttributeName?"Time":c.impedanceAttributeName===c.distanceAttributeName?"Distance":"Other",h={label:'\x3cdiv class\x3d"esriFloatLeading bufferIcon esri'+p+n+'Icon"\x3e\x3c/div\x3e\x3cdiv class\x3d"esriLeadingMargin4" style\x3d"height:20px;margin-top:10px;"\x3e'+
h+"\x3c/div\x3e",value:k,travelMode:c,disabled:r,modei18nKey:q,units:n};if("all"===d||d===n.toLowerCase())"all"!==d&&(h.value=h.value.replace(n,"")),a.selectDefaultMode&&(this.defaultTravelModeId&&this.defaultTravelModeId===c.id)&&(h.selected=!0),b.push(h)},this);a.selectWidget.removeOption();a.selectWidget.addOption(b);a.selectWidget.set("value",a.value);a.widget.emit("travelmodes-added",{travelOptions:b})}),f.hitch(this,function(c){b&&0<b.length&&(a.selectWidget.removeOption(),a.selectWidget.addOption(b),
a.selectWidget.set("value",a.value),a.widget.emit("travelmodes-added",{travelOptions:b}))}))}}});E("extend-esri")&&f.setObject("dijit.analysis.utils",t,N);return t});