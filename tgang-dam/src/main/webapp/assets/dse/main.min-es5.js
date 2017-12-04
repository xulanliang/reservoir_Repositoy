'use strict';
/**
 * 常量配置类
 * create by wangxd
 */

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine('dseConstant', function (require, exports, module) {

	var DseConstant = {
		/*路径配置项，约定放第一次出现配置路径。以便grunt进行打包*/
		DsePath: {
			SERVER_PATH: 'http://127.0.0.1:8080/baseweb/', /*打包时动态读取package.json进行读取*/
			CLIENT_PATH: 'http://127.0.0.1:8080/baseweb/' },
		/*请求配置项*/
		DseRequest: {
			SUCCESS_CODE: 1, /*成功状态码*/
			ERROR_CODE: 0 },
		VERSION: '1.0.0' };
	module.exports.DseConstant = DseConstant;
});; // 'use strict'
// /**
//  * 页面加载完成后默认执行的方法，用于给页面初始化添加效果等
//  * create by wangxd
//  */
// var dseDefine = dseDefine === null ? define : dseDefine;
// dseDefine('dseLoad',function(require,exports,module){
// 	let $ = require('jquery');

// });;// /*'use strict'
// /**
//  * 文件
//  * create by wangxd
//  */
// var dseDefine = dseDefine === null ? define : dseDefine;
// dseDefine('dseFile',function(require,exports,module){
// 	let utils = require('dseUtils').DseUtils,
// 		$ = require('bsFileinputZh');

// 	class DseFile{
// 		/**
// 		 * 构造函数
// 		 * @param  {Object} config {
// 		 *                         target: jquery对象，目标
// 		 *                         language: String,本地化配置，默认zh
// 		 *                         uploadUrl: String,上传url地址
// 		 *                         exts: Array,允许上传的文件后缀
// 		 *                         showUpload: Boolean,是否显示上传按钮
// 		 *                         showCaption: Boolean,是否显示input文件筐，默认false
// 		 *                         showRemove: Boolean,是否显示删除按钮，默认true
// 		 *                         showCancel: Boolean，是否显示取消按钮，当使用ajax上传时，默认true，
// 		 *                         showPreview: Boolean,是否显示预览图，默认true
// 		 *                         browseClass: String,选择文件按钮样式，默认'btn btn-primary'
// 		 *                         
// 		 *                         	}
// 		 * @return {[type]}        [description]
// 		 */
// 		constructor(config){
// 			this._targets = [];
// 			this.target = config.target;
// 			this.language = config.language || 'zh';
// 			this.uploadUrl = config.uploadUrl;
// 			this.exts = config.exts;
// 			this.showUpload = config.showUpload || false;
// 			this.showCaption = config.showCaption || false;
// 			this.showPreview = config.showPreview || true;
// 			this.showRemove = config.showRemove || true;
// 			this.showCancel = config.showCancel || true;
// 			this.browseClass = config.browseClass || 'btn btn-primary';
// 			this.previewFileIcon = config.previewFileIcon || '<i class="glyphicon glyphicon-king"></i>';
// 		}

// 		/**
// 		 * 初始化控件
// 		 * @return {[type]} [description]
// 		 */
// 		build(){
// 			let _that = this;
// 			_that.target.fileinput({
// 				language: _that.language,
// 				allowedFileExtensions: _that.exts,
// 				showUpload: _that.showUpload, //是否显示上传按钮
// 		        showCaption: _that.showCaption,//是否显示标题
// 		        browseClass: _that.browseClass, //按钮样式
// 		        showPreview: _that.showPreview, //按钮样式
// 		        previewFileIcon: _that.previewFileIcon,
// 		        enctype: 'multipart/form-data',
// 			});
// 			return _that;
// 		}
// 		/*private metho start*/

// 		/*private metho end*/

// 		/*setter/getter start*/
// 		set target(target){
// 			this._targets.push(target);
// 		}
// 		get target(){
// 			return utils.ArrayUtil.last(this._targets);
// 		}
// 		/*setter/getter end*/

// 	}

// 	module.exports.DseFile = DseFile;

// });*/;'use strict'

var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine('dseMenu', function (require, exports, module) {

	var utils = require('dseUtils').DseUtils;

	var HVMenu = require('hVMenu').HVMenu;

	var DseMenu = function () {
		function DseMenu(opt) {
			_classCallCheck(this, DseMenu);

			this._TYPE = {
				HV: 1
			};
			// 原始配置项
			this._opt = {
				sData: utils.ObjectUtil.getPropValue(opt, 'data'),
				url: utils.ObjectUtil.getPropValue(opt, 'url'),
				method: opt.method || 'GET',
				param: opt.param,
				async: opt.async || false,
				idField: opt.idField || 'id',
				pidField: opt.pidField || 'pid',
				dpName: opt.dpName || 'name',
				childField: opt.childField || 'children',
				iconField: opt.iconField || 'icon',
				cbMethod: opt.cbMethod
			};
		}

		/**
   * 创建HV菜单
   * @param target
   * @param opt
   * @returns {HVMenu}
   */


		_createClass(DseMenu, [{
			key: 'createHVMenu',
			value: function createHVMenu(target, opt) {
				return new HVMenu(target, utils.ObjectUtil.assign(opt, this._opt));
			}
		}]);

		return DseMenu;
	}();

	module.exports.DseMenu = DseMenu;
});;'use strict';
var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine('hVMenu', function (require, exports, module) {
	var utils = require('dseUtils').DseUtils;
	/**
  * 顶层为横向，子集都为垂直，如
  * a    b   c   d
  * a1 a1.1
  * a2 a1.2
  * ac a1.3
  */

	var HVMenu = function () {
		function HVMenu(target, opt) {
			_classCallCheck(this, HVMenu);

			this._TYPE = 1;
			this.target = target;
			this._opt = utils.ObjectUtil.depthCopy(opt);
			this._cbMethod = opt.cbMethod || {};
			this.data = utils.ObjectUtil.depthCopy(opt.sData);
			this.dataNode = [];
			this._html = {
				className: {
					content: 'g-nav-c',
					top: 'g-nav-top',
					topNode: 'g-nav-top-node',
					topNodeIcon: 'g-nav-top-icon',
					nodeContentDiv: 'g-nav-top-node-c',
					nodeChildDiv: 'g-nav-top-node-child g-nav-node-child g-nav-child-width',
					topNodeSelected: 'g-nav-top-node-selected',
					childNode: 'g-nav-c-node g-nav-child-width',
					childNodeSelected: 'g-nav-c-node-selected',
					childNodeContentDiv: 'g-nav-child-node-c',
					childNodeChildDiv: 'g-nav-child-node-child g-nav-node-child g-nav-child-width',
					childIcon: 'g-nav-child-icon'
				},
				content: {},
				top: {}
			};
			this._build();
		}

		_createClass(HVMenu, [{
			key: '_build',
			value: function _build() {
				this._buildContent()._buildTop()._hideEvent();
			}
		}, {
			key: '_hideEvent',
			value: function _hideEvent() {
				var _that = this;
				$(document).mouseover(function (e) {
					var target = $(e.target),
					    pclass = target.parent().attr('class'),
					    tclass = target.attr('class');
					if (!utils.StringUtil.isContain(pclass, 'g-nav') && !utils.StringUtil.isContain(tclass, 'g-nav')) {
						_that._hideTop();
					}
				});
				return _that;
			}
		}, {
			key: '_hideTop',
			value: function _hideTop() {
				this._html.top.find('.g-nav-top-node-child').each(function () {
					$(this).hide();
				});
			}
		}, {
			key: '_buildContent',
			value: function _buildContent() {
				this._html.content = $('<div class="' + this._html.className.content + '"></div>');
				this.target.append(this._html.content);
				return this;
			}
		}, {
			key: '_getChildDataOfPnode',
			value: function _getChildDataOfPnode(pnode) {
				var _that = this,
				    result = '';

				var _getDataOfAjax = function _getDataOfAjax(pid) {
					var pidObj = {},
					    result = '',
					    _that = this;
					pidObj[_that._opt.pidField] = pid;
					$.ajax({
						url: _that._opt.url,
						data: utils.ObjectUtil.assign(pidObj, _that._opt.param),
						method: _that._opt.method,
						async: _that._opt.async,
						success: function success(data) {
							result = data;
						}
					});
					return result;
				};

				if (_that._opt.url) {
					result = _getDataOfAjax(pnode[_that._opt.idField]);
				} else if (!pnode) {
					result = utils.ObjectUtil.depthCopy(_that.data);
				} else {
					utils.FunUtil.recursion(_that.data, function (parent, childrens, index) {
						if (parent[_that._opt.idField] === pnode[_that._opt.idField]) {
							result = utils.ObjectUtil.depthCopy(childrens);
							return;
						}
					}, { childrenField: _that._opt.childField });
				}

				if (!_that.dataNode.length) {
					_that.dataNode = result;
				} else {
					utils.FunUtil.recursion(_that.dataNode, function (parent, childrens, index) {
						if (parent[_that._opt.idField] === pnode[_that._opt.idField]) {
							if (!parent[_that._opt.childField] || !parent[_that._opt.childField].length) {
								parent[_that._opt.childField] = result;
							} else {
								result = parent[_that._opt.childField];
							}
							return;
						}
					}, { childrenField: _that._opt.childField });
				}
				if (!utils.ObjectUtil.isEmpty(result)) result.forEach(function (node) {
					return node._pNode = pnode;
				});
				return result;
			}
		}, {
			key: '_buildTop',
			value: function _buildTop() {
				var _that = this;
				_that._html.top = $('<ul class="' + this._html.className.top + '"></ul>');

				_that._getChildDataOfPnode().forEach(function (node) {
					node._isTop = true;
					node._html = _that._createTopNode(node);
					_that._addEventToTop(node);
					_that._html.top.append(node._html);
				});

				this._html.content.append(_that._html.top);

				return this;
			}
		}, {
			key: '_createTopNode',
			value: function _createTopNode(node) {
				var _that = this,
				    li = _that._createLi(this._html.className.topNode, { top: true, id: node[this._opt.idField], pid: node[this._opt.pidField] }),
				    ctdiv = _that._createContentDiv(this._html.className.nodeContentDiv, { content: true }),
				    cdiv = _that._createChildDiv(this._html.className.nodeChildDiv, { child: true }),
				    a = $('<a>' + node[this._opt.dpName] + '</a>'),
				    icon = node[_that._opt.iconField];
				if (icon) {
					var span = $('<span class="' + _that._html.className.topNodeIcon + '"></span>');
					if (utils.StringUtil.isContain(icon, '.') && utils.StringUtil.isContain(icon, '/')) {
						// icon = utils.StringUtil.relpaceAll(icon,'/','\\');
						// icon = 'pages/frame/main/main1/img/icon32' + icon.substring(icon.lastIndexOf('/'));
						span.css({
							'background': 'url(' + icon + ')',
							'background-repeat': 'no-repeat'
						});
					} else {
						span.addClass(icon);
					}
					ctdiv.append(span);
				}
				li.append(ctdiv.append(a)).append(cdiv);

				return li;
			}
		}, {
			key: '_createLi',
			value: function _createLi(clazzName, dataInfo) {
				return $('<li ' + utils.ObjectUtil.toData(dataInfo) + ' class="' + clazzName + '" ></li>');
			}
		}, {
			key: '_createContentDiv',
			value: function _createContentDiv(clazzName, dataInfo) {
				return $('<div ' + utils.ObjectUtil.toData(dataInfo) + ' class="' + clazzName + '"></div>');
			}
		}, {
			key: '_createChildDiv',
			value: function _createChildDiv(clazzName, dataInfo) {
				return $('<div ' + utils.ObjectUtil.toData(dataInfo) + ' class="' + clazzName + '"></div>');
			}
		}, {
			key: '_getLiOfNode',
			value: function _getLiOfNode(node) {
				return node._html;
			}
		}, {
			key: '_getContentDivOfNode',
			value: function _getContentDivOfNode(node) {
				return node._html.find('div[data-content=true]').eq(0);
			}
		}, {
			key: '_getTopLi',
			value: function _getTopLi() {
				return this._html.top.find('li[data-top=true]');
			}
		}, {
			key: '_getChildDivOfNode',
			value: function _getChildDivOfNode(node) {
				return node._html.find('div[data-child=true]').eq(0);
			}
		}, {
			key: '_clickCallBack',
			value: function _clickCallBack(node) {
				var _that = this;
				if (_that._cbMethod.onClick) _that._cbMethod.onClick(node);
				return _that;
			}
		}, {
			key: '_addEventToTop',
			value: function _addEventToTop(node) {
				var _that = this,
				    cdiv = _that._getContentDivOfNode(node);
				cdiv.unbind('click').on('click', function () {
					_that._removeTopState()._removeLeafStat()._addTopSelectedOfNode(node)._clickCallBack(node)._buildNodeChild(node);
				});
				return _that;
			}
		}, {
			key: '_removeTopState',
			value: function _removeTopState() {
				var _that = this;
				_that.dataNode.forEach(function (node) {
					node.selected = false;
					_that._getChildDivOfNode(node).hide();
					_that._getLiOfNode(node).removeClass(_that._html.className.topNodeSelected);
				});
				return _that;
			}
		}, {
			key: '_addTopSelectedOfNode',
			value: function _addTopSelectedOfNode(node) {
				var _that = this;
				node.selected = true;
				_that._getLiOfNode(node).addClass(_that._html.className.topNodeSelected);
				_that._getChildDivOfNode(node).show();
				return _that;
			}
		}, {
			key: '_buildTopNodeChild',
			value: function _buildTopNodeChild(node, children) {
				var _that = this;
				if (utils.ObjectUtil.isEmpty(children) || _that._getChildDivOfNode(node).children().length) return _that;
				children.forEach(function (cnode) {
					cnode._html = _that._createLeafNode(node, cnode);
					_that._addEventToLeafNode(node, cnode);
				});
				return _that;
			}
		}, {
			key: '_buildChildNodeChild',
			value: function _buildChildNodeChild(node, children) {
				var _that = this;

				return _that._buildTopNodeChild(node, children);
			}
		}, {
			key: '_hasChildren',
			value: function _hasChildren(node) {
				return !utils.ObjectUtil.isEmpty(this._getChildDataOfPnode(node));
			}
		}, {
			key: '_createLeafNode',
			value: function _createLeafNode(pnode, cnode) {
				var _that = this,
				    cDiv = _that._getChildDivOfNode(pnode).eq(0),
				    li = _that._createLi(_that._html.className.childNode, { isTop: false, id: cnode[_that._opt.idField], pid: cnode[_that._opt.pidField] }),
				    ctdiv = $('<div data-content="true" class="' + _that._html.className.childNodeContentDiv + '"></div>'),
				    cdiv = $('<div data-child="true" class="' + _that._html.className.childNodeChildDiv + '"></div>'),
				    a = $('<a>' + cnode[_that._opt.dpName] + '</a>');
				cDiv.append(li.append(ctdiv.append(a)).append(cdiv));

				var offset = cDiv.offset();
				var liOffset = li.offset();
				if (_that._hasChildren(cnode)) {
					var span = $('<span class="' + _that._html.className.childIcon + '"></span>');
					a.append(span);
				}

				cdiv.css({
					left: cDiv.width() + offset.left + utils.ObjectUtil.getPropValueInt(_that._opt.position, 'left'),
					top: liOffset.top + utils.ObjectUtil.getPropValueInt(_that._opt.position, 'top')
				});

				return li;
			}
		}, {
			key: '_buildNodeChild',
			value: function _buildNodeChild(node) {
				var _that = this,
				    children = _that._getChildDataOfPnode(node);
				if (node._isTop) return _that._buildTopNodeChild(node, children);
				return _that._buildChildNodeChild(node, children);
			}
		}, {
			key: '_addEventToLeafNode',
			value: function _addEventToLeafNode(pnode, cnode) {
				var _that = this,
				    cdiv = _that._getContentDivOfNode(cnode);
				cdiv.unbind("click").on('click', function () {
					_that._removeLeafStat()._addLeafSelectedOfNode(cnode)._addLeafPnodeSelected(cnode)._clickCallBack(cnode)._buildNodeChild(cnode);
				});

				return _that;
			}
		}, {
			key: '_removeLeafStat',
			value: function _removeLeafStat() {
				var _that = this;
				utils.FunUtil.recursion(_that.dataNode, function (pnode, children, index) {
					if (index !== 0) {
						pnode.selected = false;
						var html = _that._getLiOfNode(pnode);
						if (html) {
							html.removeClass(_that._html.className.childNodeSelected);
							_that._getChildDivOfNode(pnode).hide();
						}
					}
				}, { childrenField: _that._opt.childField });
				return _that;
			}
		}, {
			key: '_addLeafSelectedOfNode',
			value: function _addLeafSelectedOfNode(node) {
				var _that = this;
				if (node._isTop) return _that;
				node.selected = true;
				_that._getLiOfNode(node).addClass(_that._html.className.childNodeSelected);
				_that._getChildDivOfNode(node).show();
				return _that;
			}
		}, {
			key: '_addLeafPnodeSelected',
			value: function _addLeafPnodeSelected(cnode) {
				var _that = this,
				    pnode = cnode._pNode;
				if (!utils.ObjectUtil.isEmpty(pnode)) return _that._addLeafSelectedOfNode(pnode)._addLeafPnodeSelected(pnode);
				return _that;
			}
		}]);

		return HVMenu;
	}();

	module.exports.HVMenu = HVMenu;
});;'use strict';
/*扩展jquery的ajax请求，提供接口:DseRequest*/
var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine('dseRequest', function (require, exports, module) {
	/*声明依赖*/
	/*配置项*/
	var DseConstant = require('dseConstant').DseConstant,
	    _ = require('underscore'),
	    $ = require('jquery'),
	    DseUtils = require('dseUtils').DseUtils;
	/**
  * 请求类,_开头的方法请别调用，后台返回数据结构：
  * {
  * 	data: Obj,
  * 	status: Number,
  * 	message : {msg: String,...}
  * }
  */

	var DseRequest = function () {
		function DseRequest(config) {
			_classCallCheck(this, DseRequest);

			this.$ = config.$;
			this._ = config._;
			/*定义状态码，不可修改*/
			DseUtils.ObjectUtil.createReadOnlyProp(this, '_successCode', DseConstant.DseRequest.SUCCESS_CODE).createReadOnlyProp(this, '_errorCode', DseConstant.DseRequest.ERROR_CODE);
		}

		/**
   * 请求后台统一接口
   * @param  {Obj} params 请求对象：{
   *                      			success : function(data,msgObj),
   *                      			error : function(msgObj),
   *                      		   }
   * @return {this}       DseRequest对象
   */


		_createClass(DseRequest, [{
			key: 'request',
			value: function request(params) {
				return this._ajaxRequest(params);
			}

			/**
    * 获取模板，并渲染数据，返回渲染后的结果,如果不传数据则只返回模板。
    * @param  {Obj} params {
    *                      data : Object,// 渲染数据
    *                      success : Fun, // 成功回调
    *                      }
    * @return {String}        渲染之后的结果字符或模板
    */

		}, {
			key: 'getTemplate',
			value: function getTemplate(params) {
				var _that = this,
				    _ = _that._,
				    data = params.data,
				    successFun = params.success;
				params.success = function (html) {
					if (successFun) {
						if (!data) successFun(html);else successFun(_.template(html)(params.data));
					}
				};

				return _that._jqRequest(params);
			}

			/**
    * 下载文件请求
    * @param  {Obj} params {
    *                      url:String,//请求路径
    *                      }
    * @return {this}       DseRequest对象                     
    */

		}, {
			key: 'requestDownLoad',
			value: function requestDownLoad(params) {
				window.location.href = params.url;
				return this;
			}

			/**
    * 调用后台ajax请求，不使用Promise进行封装
    * @param  {Obj} params 请求对象：{
    *                      			success : function(data,msgObj),
    *                      			error : function(msgObj),
    *                      		   }
    * @return {this}       DseRequest对象
    */

		}, {
			key: '_ajaxRequest',
			value: function _ajaxRequest(params) {
				var _that = this,
				    successFun = params.success,
				    errorFun = params.error;
				params.success = '';
				params.complete = function (data) {
					var result = data.responseText;
					if (DseUtils.ObjectUtil.isString(result)) {
						result = JSON.parse(result);
					}
					if (result.status === _that._successCode && successFun) return successFun(result.data, result.message);
					if ((result.status === _that._errorCode || result.status >= 400) && errorFun) return errorFun(result.message);
				};
				return _that._jqRequest(params);
			}
			/**
    * jquery ajax请求方法
    * @param  {Obj} params 请求对象
    * @return {this}       DseRequest对象
    */

		}, {
			key: '_jqRequest',
			value: function _jqRequest(params) {
				this.$.ajax(params);
				return this;
			}
		}]);

		return DseRequest;
	}();

	module.exports.DseRequest = new DseRequest({ $: $, _: _ });
});;'use strict';
/**
 * 模糊查询
 * create by wangxd
 */
var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine('dseQuickSearch', function (require, exports, module) {
	var utils = require('dseUtils').DseUtils,
	    $ = require('jquery'),
	    request = require('dseRequest').DseRequest;

	var DseQuickSearch = function () {
		function DseQuickSearch(options) {
			_classCallCheck(this, DseQuickSearch);

			this._panel = ''; /*面板*/
			this._targetInfo = {}; /*目标元素信息*/
			this._requestData = []; /*渲染数据*/
			this._panelCssInfo = {};
			this._clearTime = ''; /*定时器时间值，解决查询先后问题导致显示错误*/
			this._classInfo = { /*样式信息*/
				panel: 'dse-qsearch-panel',
				node: 'dse-qsearch-node'
			};
			this.data = options.data; /*数据源*/
			this.isAutoHide = options.isAutoHide;
			this.appendTo = options.appendTo;
			this.panelClasses = options.panelClasses;
			this.target = options.target; /*目标元素*/
			this.url = options.url; /*访问地址*/
			this.params = options.params; /*请求参数*/
			this.markId = options.markId; /*标示id*/
			this.displayField = options.displayField; /*显示字段*/
			this.onClick = options.onClick; /*点击事件*/
			this.onInputClick = options.onInputClick; /*点击事件*/
			this.onClose = options.onClose; /*消失事件*/
			this.position = options.position;
			this.type = options.type;
			this.quickSearch = options.quickSearch;
			this.build(); /*构建*/
		}

		/**
   * 构建流程
   * @return {this} 
   */


		_createClass(DseQuickSearch, [{
			key: 'build',
			value: function build() {
				var _that = this;
				_that._resolveTarget(). /*解析目标元素信息*/
				_createPanel(). /*创建面板*/
				_buildPnaelCss(). /*创建css*/
				_buildPanelEvent()._buildEvent(). /*添加输入框事件*/
				_show(); /*显示*/
				return _that;
			}
		}, {
			key: '_getElStyleTop',
			value: function _getElStyleTop(el) {
				if (!el) return 0;
				return el.style.top.replace(/[^0-9]/ig, "");
			}
		}, {
			key: '_setElStyleTop',
			value: function _setElStyleTop(el, top) {
				if (!el) return this;
				el.style.top = top + 'px';
				return this;
			}
			/**
    * 创建节点
    * @return {this} 
    */

		}, {
			key: 'buildNode',
			value: function buildNode() {
				var _that = this;
				/*清除面板内容*/
				_that._panel.html('');
				/*遍历添加节点*/
				_that._setElStyleTop(_that._panel.get(0), _that._panelCssInfo.top);
				var index = 0;
				_that._requestData.forEach(function (node) {
					var nodeDiv = _that._createNode(node);
					node.dom = nodeDiv;
					/*添加点击事件*/
					node.dom.on('click', function () {
						/*点击隐藏面板*/
						_that._panel.hide();
						/*设置值到输入框*/
						_that.target.val(node[_that.displayField]);
						/*回调onClick事件*/
						if (_that.onClick) _that.onClick(node, _that._requestData);
					});
					_that._panel.append(node.dom);
					index += 22;
				});
				if (_that.type === _that.quickSearch._TYPE.TOP) if (index <= 200) _that._setElStyleTop(_that._panel.get(0), _that._getElStyleTop(_that._panel.get(0)) - index);else _that._setElStyleTop(_that._panel.get(0), _that._getElStyleTop(_that._panel.get(0)) - 200);
				return _that;
			}
			/**
    * 创建节点
    * @param  {Object} node 节点
    * @return {jqObject}      dom节点
    */

		}, {
			key: '_createNode',
			value: function _createNode(node) {
				return $('<div class=' + this._classInfo.node + '>' + node[this.displayField] + '</div>');
			}

			/*private methos start*/
			/**
    * 解析目标对象
    * @return {Object} 返回目标对象的配置信息
    */

		}, {
			key: '_resolveTarget',
			value: function _resolveTarget() {
				var target = this.target;
				/*获取位置对象*/
				var targetOffset = target.offset();

				var zIndex = target.css('z-index');
				if (zIndex === 'auto' || !zIndex) zIndex = this.zIndex++;

				/*获取元素基本信息*/
				this.targetInfo = {
					left: targetOffset.left,
					top: targetOffset.top,
					width: target.outerWidth(),
					height: target.height(),
					zIndex: zIndex
				};
				return this;
			}
			/**
    * 创建面板
    * @return {this} 
    */

		}, {
			key: '_createPanel',
			value: function _createPanel() {
				var _that = this;

				_that._panel = $('<div class=' + _that._classInfo.panel + '></div>');
				if (_that.panelClasses) _that.panelClasses.forEach(function (className) {
					return _that._panel.addClass(className);
				});
				if (_that.appendTo) _that.appendTo.append(_that._panel);else $('body').append(_that._panel);
				return _that;
			}
			/**
    * 给面板添加样式
    * @return {this} 
    */

		}, {
			key: '_buildPnaelCss',
			value: function _buildPnaelCss() {
				var _that = this;
				/*解析对象的样式信息*/
				var targetInfo = _that.targetInfo;
				var panel = _that._panel;
				var position = _that.position;
				/*生成默认样式*/
				var classInfo = {
					'position': 'absolute',
					'z-index': targetInfo.zIndex + utils.ObjectUtil.getPropValueInt(position, 'zIndex'),
					'top': targetInfo.top + targetInfo.height + 4 + utils.ObjectUtil.getPropValueInt(position, 'offsetTop'),
					'left': targetInfo.left + utils.ObjectUtil.getPropValueInt(position, 'offsetLeft'),
					'height': utils.ObjectUtil.getPropValueInt(position, 'height') || 'auto',
					'width': targetInfo.width - 2 + utils.ObjectUtil.getPropValueInt(position, 'width') };
				if (_that.type === _that.quickSearch._TYPE.TOP) classInfo.top = classInfo.top - 4 - targetInfo.height;
				if (utils.ObjectUtil.getPropValueInt(position, 'isNotSet')) {
					classInfo.top -= targetInfo.top;
					classInfo.left -= targetInfo.left;
				}
				_that._panelCssInfo = utils.ObjectUtil.depthCopy(classInfo);
				panel.css(classInfo);
				return _that;
			}
		}, {
			key: '_buildPanelEvent',
			value: function _buildPanelEvent() {
				var _that = this,
				    panel = _that._panel,
				    divTarget = _that.target;
				/*添加点击区域外消失事件*/
				$(document).mouseover(function (e) {
					var target = $(e.target);
					var isShow = panel.css('display') !== 'none';
					if (target.closest(divTarget).length === 0 && target.closest(panel).length === 0) {
						if (isShow) {
							if (_that.onClose) _that.onClose(_that._requestData);
							panel.hide();
						}
					} else {
						if (!isShow) panel.show();
					}
				});
				$(document).click(function (e) {
					var target = $(e.target);
					var isShow = panel.css('display') !== 'none';
					if (target.closest(divTarget).length === 0 && target.closest(panel).length === 0) {
						if (isShow) {
							if (_that.onClose) _that.onClose(_that._requestData);
							panel.hide();
						}
					} else {
						if (!isShow) panel.show();
					}
				});
				return _that;
			}
			/**
    * 添加输入框事件
    * @return {this} 
    */

		}, {
			key: '_buildEvent',
			value: function _buildEvent() {
				var _that = this;
				_that.target.bind('click', function () {
					_that._search();
					if (_that.onInputClick) _that.onInputClick(_that._requestData);
				});
				_that.target.bind('keyup', function () {
					_that._search();
				});
				return _that;
			}
			/**
    * 进行查询
    * @return {void}
    */

		}, {
			key: '_search',
			value: function _search() {
				var _that = this,
				    data = {},
				    defaultParamName = utils.ObjectUtil.getPropValue(_that.params, 'key');
				/*获取参数信息*/
				for (var key in _that.params) {
					if (key !== 'key') data[key] = _that.params[key];else data[defaultParamName] = _that.target.val();
				}if (_that.data) {
					(function () {
						var resultData = [];
						_that.data.forEach(function (dataNode) {
							var dataVal = dataNode[_that.displayField] + '',
							    inputVal = _that.target.val() + '';
							if (dataVal.indexOf(inputVal) != -1) resultData.push(utils.ObjectUtil.depthCopy(dataNode));
						});
						_that._requestData = resultData;
						_that.buildNode()._show();
					})();
				} else {
					/*延迟请求后台，解决输入后台返回先后问题*/
					clearTimeout(_that._clearTime);
					_that._clearTime = setTimeout(function () {
						request.request({
							data: data,
							url: _that.url,
							success: function success(data) {
								/*设置数据、建立节点、显示面板*/
								_that._requestData = data;
								_that.buildNode()._show();
							}
						});
					}, 500);
				}
			}
			/**
    * 显示面板
    * @return {this} 
    */

		}, {
			key: '_show',
			value: function _show() {
				var _that = this;
				if (!_that._requestData || !_that._requestData.length) {
					// _that._panel.css('display','none');
					_that._panel.get(0).style.display = 'none';
					return _that;
				}
				// _that._panel.css('display','block');
				_that._panel.get(0).style.display = 'block';
				return _that;
			}
			/*private methos end*/

		}]);

		return DseQuickSearch;
	}();

	module.exports.DseQuickSearch = DseQuickSearch;
});'use strict';
/**
 * 模糊查询
 * create by wangxd
 */
var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine('dseSearch', function (require, exports, module) {
	var utils = require('dseUtils').DseUtils;
	var QuickSearch = require('dseQuickSearch').DseQuickSearch;

	var DseSearch = function () {
		/**
   * @param Object options，配置项{
   * 				url: String,检索url地址
   * 				data: Array,渲染数据，如果存在则不会发请求
   * 				target: JqObject,输入框元素
   * 				params: Object,请求参数，如果由插件进行请求，默认必须有key属性，key属性的值为参数的名称
   * 				displayField: String,显示字段名称
   * 				onClick: function(node,nodes),点击节点事件，node为被点击节点，nodes为所有节点
   * 				position: Object,位置配置
   *                      				{
   *                      					offsetLeft: 左边偏移量
   *                      					offsetTop: 上方偏移量
   *                      					width: 宽度
   *                      					height: 高度
   *                      					zIndex:
   *                      				}
   * 				}
   */
		function DseSearch(options) {
			_classCallCheck(this, DseSearch);

			if (!utils.ObjectUtil.isObject(options)) throw new Error('options is not a Object.');
			this._TYPE = { DOWN: 'down', TOP: 'top' };
			this._targets = [];
			this._idSearch = {}; /*建立id对应*/
			this.appendTo = options.appendTo;
			this.panelClasses = options.panelClasses;
			this.url = options.url; /*搜索url*/
			this.data = options.data; /*数据源*/
			this.isAutoHide = options.isAutoHide;
			this.target = options.target; /*目标元素*/
			this.params = options.params; /*请求参数*/
			this.displayField = options.displayField; /*显示字段*/
			this.onClick = options.onClick; /*点击事件*/
			this.onInputClick = options.onInputClick; /**/
			this.onClose = options.onClose; /*消失事件*/
			this.type = options.type; /*类型，down为向下，top为向上，默认向下*/
			this.position = options.position;
		}
		/**
   * 创建输入框输入搜索下拉插件
   * @return {QuickSearch} QuickSearch对象
   */


		_createClass(DseSearch, [{
			key: 'createQuickSearch',
			value: function createQuickSearch() {
				var _that = this;
				var markId = utils.StringUtil.uuid();
				var quickSearch = new QuickSearch({
					quickSearch: _that,
					target: _that.target,
					url: _that.url,
					appendTo: _that.appendTo,
					panelClasses: _that.panelClasses,
					data: _that.data,
					isAutoHide: _that.isAutoHide,
					params: _that.params,
					markId: markId, /*标示改插件的id*/
					displayField: _that.displayField,
					onClick: _that.onClick,
					onInputClick: _that.onInputClick,
					onClose: _that.onClose,
					position: _that.position,
					type: _that.type || _that._TYPE.DOWN
				});
				_that._idSearch[markId] = quickSearch;
				return quickSearch;
			}

			/*setter/getter  start*/

		}, {
			key: 'target',
			set: function set(target) {
				this._targets.push(target);
			},
			get: function get() {
				return utils.ArrayUtil.last(this._targets);
			}
			/*setter/getter  end*/

		}]);

		return DseSearch;
	}();

	module.exports.DseSearch = DseSearch;
});'use strict';
/*工具类*/
var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine('dseUtils', function (require, exports, module) {
	var _ = require('underscore');
	var $ = require('nicescroll');

	var DseUtils = {
		/*对象工具类*/
		ObjectUtil: {
			/**
    * 创建对象的只读属性
    * @param  {Object} obj      被创建对象
    * @param  {String} propName 属性名称
    * @param  {Object} value    属性的值
    * @return {this}          返回ObjectUtil对象
    */
			createReadOnlyProp: function createReadOnlyProp(obj, propName, value) {
				Object.defineProperty(obj, propName, {
					value: value,
					writable: false,
					enumerable: false,
					configurable: false
				});
				return this;
			},

			/**
    * 将多个对象合并为一个对象
    * @return {[Object]} 合并后对象
    */
			assign: function assign() {
				var obj = {};
				for (var i = 0, len = arguments.length; i < len; i++) {
					obj = _.assign(obj, arguments[i]);
				}return obj;
			},

			/**
    * 将对象的信息转换成data-attr=""的字符串
    * @param obj
    */
			toData: function toData(obj) {
				if (!this.isObject(obj)) return '';
				var str = '';
				for (var prop in obj) {
					str += 'data-' + prop + '=' + obj[prop] + ' ';
				}return str;
			},

			/**
    * 深度复制一个对象为全新的对象,不存在引用
    * @param  {Object} target 目标对象
    * @return {Object}        新对象,如果传入的为非对象,则返回一个空对象{}
    */
			depthCopy: function depthCopy(target) {
				return !target ? {} : JSON.parse(JSON.stringify(target));
			},

			/**
    * 返回对象的属性的值，用于不清楚传入对象是否为空的情况，如果对象为空则返回undefined
    * @param  {Object} target   目标对象
    * @param  {String} propName 对象的属性
    * @return {Object}          对象的值
    */
			getPropValue: function getPropValue(target, propName) {
				return _.propertyOf(target)(propName);
			},

			/**
    * 返回对象的属性的值，用于不清楚传入对象是否为空的情况，如果对象为空则返回0
    * @param  {Object} target   目标对象
    * @param  {String} propName 对象的属性
    * @return {Object}          对象的值
    */
			getPropValueInt: function getPropValueInt(target, propName) {
				return this.getPropValue(target, propName) || 0;
			},

			/**
    * 将数组转换成树
    * @param  {[Array]} target 目标数组
    * @param  {Object} config 配置项{
    *                         		idField:String,id的属性名称，如果没有默认拿id
    *                         		pidField:String,pid的属性名称,如果没有默认拿pid
    *                         		childrenField:String,children的属性名称,如果没有默认拿children
    *                         		isChild: function(node,pnode)自定义判断是否为孩子节点方法
    *                         		isParent: function(pnode,node) 判断该节点是否为根节点方法
    *                         		 }
    * @return {Object}       返回树结构对象，如果传入为非数组，则返回空对象
    */
			arrayToTree: function arrayToTree(target, config) {
				if (!_.isArray(target)) return {};
				var idField = DseUtils.ObjectUtil.getPropValue(config, 'idField') || 'id';
				var pidField = DseUtils.ObjectUtil.getPropValue(config, 'pidField') || 'pid';
				var childrenField = DseUtils.ObjectUtil.getPropValue(config, 'childrenField') || 'children';
				var childFun = DseUtils.ObjectUtil.getPropValue(config, 'isChild') || function (node, parent) {
					return node[idField] !== parent[idField] && node[pidField] === parent[idField];
				};
				var parentFun = DseUtils.ObjectUtil.getPropValue(config, 'isParent') || function (pnode, node) {
					return !(pnode[idField] !== node[idField] && pnode[pidField] === node[idField]);
				};

				/*根对象*/
				var _that = this;
				var array = _that.depthCopy(target);
				/*查找每个节点的孩子节点*/
				var findMyChild = function findMyChild(parent, nodes) {
					if (!nodes) return;
					if (!parent[childrenField]) parent[childrenField] = [];
					nodes.forEach(function (node) {
						if (childFun(node, parent)) parent[childrenField].push(node);
					});
				};
				array.forEach(function (node) {
					return findMyChild(node, array);
				});
				/*查找根节点*/
				var root = [];
				var findRoot = function findRoot(nodes) {
					nodes.forEach(function (pnode) {
						var isParent = true;
						nodes.forEach(function (node) {
							if (!parentFun(pnode, node)) {
								isParent = false;
								return;
							}
						});
						if (isParent) root.push(pnode);
					});
				};
				findRoot(array);
				return root;
			},

			/**
    * 树转成array数组
    * @param  {Object||Array} tree   目标对象
    * @param  {Object} config 配置信息
    *                         {
    *                         		childrenField:String 子节点的名称,如果没有默认为children
    *                         }
    * @return {[Array]}        转换后数组
    */
			treeToArray: function treeToArray(tree, config) {
				var result = [];
				DseUtils.FunUtil.recursion(tree, function (node) {
					return result.push(node);
				}, config);
				return result;
			},

			/**
    * 将树处理为list
    * @param  {Array} array 树数组
    * @param  {Object} config 配置项
    *                         {	
    *                         		keyField: 对象的key属性，如果没有默认为id的值作为key
    *                         		valueField: key对应的值属性，如果没有传，默认采用的是对象
    *                         }
    * @return {Array}       返回一个key对应的对象，如果传入非数组，则返回空对象{};
    */
			treeToMap: function treeToMap(array, config) {
				if (!_.isArray(array)) return {};
				if (!_.isObject(config)) config = {};
				var keyField = config.keyField || 'id';
				var valueField = config.valueField;

				var result = {};
				DseUtils.FunUtil.recursion(array, function (parent, children) {
					if (!result[parent[keyField]]) result[parent[keyField]] = {};
					result[parent[keyField]] = parent[valueField] || parent;
				});
				return result;
			},

			/**
    * 检查是否为字符串
    * @param  {Obj}  target 被检查对象
    * @return {Boolean}        true为字符串，false为非字符串
    */
			isString: function isString(target) {
				return _.isString(target);
			},

			/**
    * 检查是否为对象
    * @param  {Object}  target 被检查对象
    * @return {Boolean}        true为对象，false为非对象
    */
			isObject: function isObject(target) {
				return _.isObject(target);
			},

			/**
    * 判断目标对象是否为空，[],{}等都为空
    * @param  {Object||Array}  target 目标对象
    * @return {Boolean}        true表示为空，false表示不为空
    */
			isEmpty: function isEmpty(target) {
				return _.isEmpty(target);
			},

			/**
    * 判断对象是否为false值
    * @param  {Object}  target 目标对象
    * @return {Boolean}        [如果为'',null,'null',false,'false',undefine,'undefine',0]
    */
			isFalse: function isFalse(target) {
				return !target || target === 'null' || target === 'false' || target === 'undefined';
			}
		},
		NumberUtil: {
			toFixed: function toFixed(num, n) {
				if (!num || !_.isNumber(num)) return num;
				return parseFloat(num).toFixed(n || 0);
			},
			formatBigNum: function formatBigNum(num, n) {
				if (!num || !_.isNumber(num)) return num;
				n = n > 0 && n <= 20 ? n : 0;
				num = parseFloat((num + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
				var l = num.split(".")[0].split("").reverse(),
				    r = num.split(".")[1];
				var t = "";
				for (var i = 0; i < l.length; i++) {
					t += l[i] + ((i + 1) % 3 == 0 && i + 1 != l.length ? "," : "");
				}
				return t.split("").reverse().join("") + "." + r;
			},
			formatBigNumToNum: function formatBigNumToNum(strNum) {
				if (!strNum) return strNum;
				var num = strNum.replace(/,/g, '');
				if (!num || !_.isNumber(num)) return strNum;
				return parseFloat(num);
			}
		},
		/*路径处理工具类*/
		PathUtil: {
			/**
    * 跳转路径，自动进行utf-8编码
    * @param  {String} url 目标路径
    * @return {Object}     this
    */
			jumpTo: function jumpTo(url) {
				window.location.href = encodeURI(url);
				return this;
			},
			/**
    * 解析地址上面的参数
    * @return {Object}     返回对象，如果传入的为非字符串则返回空对象
    */
			resolvePath: function resolvePath() {
				var str = decodeURI(window.location.href, 'utf-8');
				if (!_.isString(str) || str.indexOf('?') === -1) return {};
				str = str.split('?')[1].split('&');
				var obj = {};
				str.forEach(function (key) {
					key = key.split('=');
					obj[key[0]] = key[1];
				});
				return obj;
			}
		},
		/*弹出工具类*/
		LayerUtil: {},
		/*字符处理工具类*/
		StringUtil: {
			/**
    * 获取字符串真实的长度，即汉子为两个字节的长度
    * @param  {String} str 目标字符串
    * @return {Number}     字符串长度:-1表示传入的是非字符串
    */
			realLength: function realLength(str) {
				if (!_.isString(str)) return -1;
				var realLength = 0;
				for (var i = 0; i < str.length; i++) {
					var charCode = str.charCodeAt(i);
					if (charCode >= 0 && charCode <= 128) realLength += 2;else realLength += 1;
				}
				return realLength;
			},

			/**
    * 转义HTML字符串，替换&, <, >, ", ', 和 /字符
    * @param  {String} str 目标字符串
    * @return {String}     转换结果
    */
			htmlEscape: function htmlEscape(str) {
				return _.escape(str);
			},

			/**
    * 和htmlEscape相反。转义HTML字符串，替换&, &lt;, &gt;, &quot;, &#96;, 和 &#x2F;字符。
    * @param  {String} str 目标字符串
    * @return {String}     转换结果
    */
			htmlUnEscape: function htmlUnEscape(str) {
				return _.unescape(str);
			},

			/**
    * 替换字符串中所有指定的字符为新字符
    * @param  {String} str    目标字符串
    * @param  {String} oldStr 要被替换的字符串
    * @param  {String} newStr 替换为新的字符串
    * @return {String}        返回替换结果字符串
    */
			relpaceAll: function relpaceAll(str, oldStr, newStr) {
				return _.isString(str) ? str.replace(new RegExp('\\' + oldStr, 'g'), newStr) : str;
			},

			/**
    * 将字符串首字符大写，之后的小写,如果isFirst为true则只对第一个进行大写转换
    * @param  {String} str 目标字符串
    * @param  {Boolean} isFirst 是否只转换第一个字符
    * @return {String}     转换结果
    */
			capitalize: function capitalize(str, isFirst) {
				return !_.isString(str) ? str : isFirst ? str.charAt(0).toUpperCase() + str.substring(1) : str.charAt(0).toUpperCase() + str.substring(1).toLowerCase();
			},

			/**
    * 是否包含某个字符串
    * @param  {String}  str     目标字符串
    * @param  {String}  destStr 包含字符串
    * @return {Boolean}         true为包含，false不包含
    */
			isContain: function isContain(str, destStr) {
				return !_.isString(str) ? false : str.indexOf(destStr) !== -1;
			},

			/**
    * 移除字符串最后一个字符
    * @param  {String} str 目标字符串
    * @return {String}     返回移除后的字符串，如果传入为非字符串，则返回空字符''
    */
			removeLast: function removeLast(str) {
				return !_.isString(str) ? '' : str.substring(0, str.length - 1);
			},

			/**
    * 将字符串转换成小写，如果为空字符串则返回空字符
    * @param  {String} str 目标字符
    * @return {String}     转换结果，如果传入为非字符串，则返回空字符''
    */
			toLowerCase: function toLowerCase(str) {
				return !_.isString(str) ? '' : str.toLowerCase();
			},

			/**
    * 将对象的属性名称转换成小写,如果传入为非对象，则返回空对象
    * @param  {Object} target 目标对象
    * @return {Object}     转换后的对象，如果传入为非对象，则返回空对象
    */
			propToLowerCase: function propToLowerCase(target) {
				if (!_.isObject(target)) return {};
				var obj = {};
				for (var prop in target) {
					obj[this.toLowerCase(prop)] = target[prop];
				}return obj;
			},

			/**
    * 将空对象替换成指定的字符
    * @param  str 目标字符串，
    * @param  sp：转后的字符(默认‘--’)
    * @return {String}     替换后的字符串
    */
			nullToSP: function nullToSP(str, sp) {
				return !str && str !== 0 ? !sp ? '--' : sp : str;
			},

			/**
    * uuid生成器
    * @return {String} 产生uuid
    */
			uuid: function uuid() {
				return _.now() + 'uuid' + _.random(0, 10000000);
			}
		},
		/*时间日期处理工具类*/
		DateUtil: {
			/**
    * 一天时间戳
    * @return {Number} 一天的时间戳
    */
			oneDayMs: function oneDayMs() {
				return 1000 * 60 * 60 * 24;
			},

			/**
    * 获取当前客户端时间戳
    * @return {Number} 当前客户端时间戳
    */
			now: function now() {
				return _.now();
			},

			/**
    * 获取某年某月的最后一天时间戳
    * @param  {Number} year  年
    * @param  {Number} month 月
    * @return {Number}       那一天的时间戳,如果传入为非时间则返回-1
    */
			getLastDayOfYearMonth: function getLastDayOfYearMonth(year, month) {
				if (!_.isNumber(year) || !_.isNumber(month)) return -1;
				var _year = year;
				var _month = month++;
				if (month > 12) {
					_month -= 12;
					_year++;
				}
				return new Date(_year, _month, 1).getTime() - this.oneDayMs();
			},

			/**
    * 获取离当前时间近n天的时间戳
    * @param  {Number} n 整数，代表n天,如果为负数，表示当前天之后几天
    * @return {Number}   n天的时间戳,如果传入的不是数值，则返回-1
    */
			getNearDayTimeStamp: function getNearDayTimeStamp(n) {
				/**一天毫秒数*/
				return !_.isNumber(n) ? -1 : new Date().getTime() - n * this.oneDayMs();
			},

			/**
    * 将时间戳转换为时间对象
    * @param  {Number} timeStamp 时间戳
    * @return {Object}           时间对象{year:'',month:'',day:'',hour:'',minu:'',seconds : ''}
    */
			timeStampFormatDateObj: function timeStampFormatDateObj(timeStamp) {
				var dateObj = { year: '', month: '', day: '', hour: '', minu: '', seconds: '' };
				if (!_.isNumber(timeStamp)) return dateObj;
				var date = new Date(timeStamp);
				dateObj.year = date.getFullYear();
				dateObj.month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
				dateObj.day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
				dateObj.hour = date.getHours() < 10 ? '0' + date.getHours() : date.getHours();
				dateObj.minu = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes();
				dateObj.seconds = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds();
				return dateObj;
			},

			/**
    * 将时间戳转换成yyyy-MM-dd
    * @param  {Number} timeStamp 时间戳
    * @return {String}           返回转换后格式,如果传入为非数值类型,则返回''字符串
    */
			timeStampFormatDate: function timeStampFormatDate(timeStamp) {
				if (!_.isNumber(timeStamp)) return '';
				var _Obj = this.timeStampFormatDateObj(timeStamp);
				return _Obj.year + '-' + _Obj.month + '-' + _Obj.day;
			},

			/**
    * 将时间戳转换成yyyy-MM-dd hh:mm:ss
    * @param  {Number} timeStamp 时间戳
    * @return {String}           返回转换后格式,如果传入为非数值类型,则返回''字符串
    */
			timeStampFormatDateTime: function timeStampFormatDateTime(timeStamp) {
				if (!_.isNumber(timeStamp)) return '';
				var _Obj = this.timeStampFormatDateObj(timeStamp);
				return _Obj.year + '-' + _Obj.month + '-' + _Obj.day + ' ' + _Obj.hour + ':' + _Obj.minu + ':' + _Obj.seconds;
			}
		},
		/*数组处理工具类*/
		ArrayUtil: {
			/**
    * 去除重复数组
    * @param  {Array} array 目标数组
    * @return {Array}       返回去除重复数据的数组,如果传入的为非数组则返回一个空数组
    */
			unique: function unique(array) {
				return !_.isArray(array) ? [] : _.uniq(array);
			},

			/**
    * 返回多个数组的并集，并去除重复的
    * @return {Array} 并集数组
    */
			union: function union() {
				return this.unique(_.flatten(arguments));
			},

			/**
    * 返回多个数组的交集
    * @return {Array} 交集数组，如果存入非数组返回空数组[]
    */
			intersection: function intersection(array) {
				if (!_.isArray(array)) return [];
				var result = [];
				var argsLength = arguments.length;
				for (var i = 0, length = array.length; i < length; i++) {
					var item = array[i];
					if (_.contains(result, item)) continue;
					var j = 1;
					for (; j < argsLength; j++) {
						if (!_.contains(arguments[j], item)) break;
					}
					if (j === argsLength) result.push(item);
				}
				return result;
			},

			/**
    * 移除数组中为false的值，即移除 false, null, 0, "", undefined 和 NaN值
    * @param  {Array} array 目标数组
    * @return {Array}       结果数组,如果传入的为非数组则返回一个空数组[]
    */
			removeFalse: function removeFalse(array) {
				return !_.isArray(array) ? [] : _.compact(array);
			},

			/**
    * 从数组中，移除指定值		
    * @param  {Array} array 目标数组
    * @param  {...} 被移除的值
    * @return {Array}       结果数组，如果传入为非数组则返回一个空数组[]
    */
			without: function without(array) {
				if (!_.isArray(array)) return [];
				return _.difference(array, Array.prototype.slice.call(arguments, 1));
			},

			/**
    * 将元素插入到指定位置，如果没传index默认插入到首位
    * @param  {Array} array 目标数组
    * @param  {Object} obj   元素
    * @param  {int} index 插入位置0为第一个位置
    * @return {this}       ArrayUtil工具对象
    */
			insertOfIndex: function insertOfIndex(array, obj, index) {
				if (!_.isArray(array)) return this;
				array = array.splice(index || 0, 0, obj);
				return this;
			},

			/**
    * 返回array（数组）的最后一个元素。传递 n参数将返回数组中从最后一个元素开始的n个元素
    * @param  {Array} array [目标数组]
    * @param  {int} n     元素数
    * @return {[type]}       [description]
    */
			last: function last(array, n) {
				if (!_.isArray(array)) return [];
				return _.last(array, n);
			}
		},
		/*函数处理工具类*/
		FunUtil: {
			/**
    * 递归树结果
    * @param  {Array||Object} root 被递归对象
    * @param  {Function} fun   业务处理对象
    * @param  {Object} config   配置信息
    *                           {
    *                           	childrenField:String,子节点的属性名称如果没有默认为children
    *                           }
    * @return {Void}       
    */
			recursion: function recursion(root, fun, config) {
				var index = 0;
				var childrenField = DseUtils.ObjectUtil.getPropValue(config, 'childrenField') || 'children';
				var resolve = function resolve(node, children, index) {
					fun(node, children, index);
					if (DseUtils.ObjectUtil.isEmpty(children)) return;
					index++;
					children.forEach(function (node) {
						resolve(node, node[childrenField], index);
					});
				};
				return _.isArray(root) ? root.forEach(function (node) {
					return resolve(node, node[childrenField], index);
				}) : resolve(root, node[childrenField], index);
			}
		},
		/*函数处理工具类*/
		ScrollUtil: {
			/**
    * 生成默认的滚动条
    * @return {Void}
    */
			defaultScroll: function defaultScroll() {
				$('*[data-scroll="true"]').each(function () {
					var $color = $(this).attr('data-cursor-color') || '#ccc',
					    //滚动条颜色
					$opacity = $(this).attr('data-cursor-opacity') || 0.8,
					    //滚动条颜色不透明度，范围从1到0
					$touch = Boolean($(this).attr('data-cursor-touch')) || false,
					    //是否启用touch事件拖动滚动，默认false
					$width = $(this).attr('data-cursor-width') || '5px',
					    //滚动条宽度
					$border = $(this).attr('data-cursor-border') || '0',
					    //滚动条边框
					$radius = $(this).attr('data-cursor-radius') || '2px',
					    //滚动条圆角
					$autohide = Boolean($(this).attr('data-cursor-autohide')) || false; //是否隐藏滚动条
					$(this).niceScroll({
						cursorcolor: $color,
						cursoropacitymax: $opacity,
						touchbehavior: $touch,
						cursorwidth: $width,
						cursorborder: $border,
						cursorborderradius: $radius,
						autohidemode: $autohide
					});
				});
			}
		},
		/*文档处理*/
		DocUtil: {
			/**
    * 去除doc的选中文本事件
    * @param  {[type]} target [description]
    * @return {[type]}        [description]
    */
			clearSelection: function clearSelection(target) {
				if (target.selection && target.selection.empty) {
					target.selection.empty();
				} else if (window.getSelection) {
					window.getSelection().removeAllRanges();
				}
				return this;
			}
		}
	};

	module.exports.DseUtils = DseUtils;
});;'use strict';
/**
 * 树形下拉的弹出窗体
 * create by wangxd
 */
var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine('dseDistWin', function (require, exports, module) {
	var dseUtils = require('dseUtils').DseUtils,
	    $ = require('jquery');

	var DistWin = function () {
		function DistWin(config) {
			_classCallCheck(this, DistWin);

			this._underWin = config._underWin; /*DseUnderWin 对象*/
			this.classInfo = dseUtils.ObjectUtil.depthCopy(config.classInfo);
			this.displayField = config.displayField; /*显示字段的属性名称*/
			this.idField = config.idField;
			this.pidField = config.pidField;
			this.data = dseUtils.ObjectUtil.depthCopy(config.data);
			this.sourceData = config.sourceData; /*原始数据*/
			this.onClick = config.onClick;
			this.onDbClick = config.onDbClick;
			this.onRenderHeader = config.onRenderHeader;
			this.maxHeight = config.maxHeight;
			this.headerHtml = config.headerHtml;
			this.appendHtml = config.appendHtml;
			this.groupInfo = dseUtils.ObjectUtil.depthCopy(config.groupInfo);
			this.allInfo = dseUtils.ObjectUtil.depthCopy(config.allInfo);
			this.isAllSelect = config.isAllSelect;
			this.isSelectedNotTrigger = config.isSelectedNotTrigger;
			this.headerTextSubWidth = config.headerTextSubWidth || 64;
			this.panel = config.panel;
			this.panelId = config.panelId;
			this.isMultiSelect = config.isMultiSelect;
			/*节点的标示属性*/
			this.elementAttr = {
				continer: 'data-flag-continer', /*容器*/
				header: 'data-flag-header', /*头部标示*/
				footer: 'data-flag-footer', /*头部标示*/
				headerLabel: 'data-flag-header-label', /*头部label*/
				headerSelect: 'data-flag-header-text', /*头部被选中节点容器*/
				nodeContent: 'data-flag-node-content', /*节点容器*/
				nodeDetailContent: 'data-flag-node-detail', /*一层节点的容器*/
				nodeGroup: 'data-flag-group', /*分组节点的标示*/
				nodeGroupStap: 'data-group-stap', /*分组节点的当前级*/
				nodeGroupText: 'data-group-text', /*分组节点的名称*/
				node: 'data-flag-node' };
			this.nodeMap = {};
			this.selectedNode = [];
			this.groupNodes = [];
			this.continer = null;
			this.header = null;
			this.nodeContent = null;
			this._buildAllInfoToData().bulid();
		}

		_createClass(DistWin, [{
			key: 'destroy',
			value: function destroy() {
				this.isDestory = true;
				this.panel.remove();
				return this;
			}
		}, {
			key: '_createAllInfoNode',
			value: function _createAllInfoNode(node, array, text, isAllSelect) {
				var _that = this,
				    allTextNode = dseUtils.ObjectUtil.depthCopy(node);
				if (!allTextNode) return _that;
				allTextNode[_that.displayField] = text;
				allTextNode[_that.idField] += 'all';
				allTextNode.children = [];
				allTextNode.isAllInfo = true;
				allTextNode.selected = true;
				dseUtils.ArrayUtil.insertOfIndex(array, allTextNode, 0);
				return _that;
			}
			/**
    * 将allInfo信息put进data
    * @return {this} DistWin对象
    */

		}, {
			key: '_buildAllInfoToData',
			value: function _buildAllInfoToData() {
				var _that = this,
				    text = dseUtils.ObjectUtil.getPropValue(_that.allInfo, 'text');
				if (!text) return _that;
				dseUtils.FunUtil.recursion(_that.data, function (node, children, index) {
					if (children && children.length) {
						if (_that.isAllSelect && index === 0) {
							_that._createAllInfoNode(children[0], children, text, true);
						} else {
							_that._createAllInfoNode(children[0], children, text, false);
						}
					}
				});
				_that._createAllInfoNode(_that.data[0], _that.data, text);
				return _that;
			}
			/**
    * 创建窗体
    * @return {this} DistWin对象
    */

		}, {
			key: 'bulid',
			value: function bulid() {
				var _that = this;
				/*创建容器以及头部*/
				_that._createContiner() /*创建容器*/
				._createHeader() /*创建头部信息*/
				._createCustomFooter() /*创建头部信息*/
				._createNode() /*创建节点*/
				._buildRelation() /*建立关联关系*/
				.buildNodeContent(_that.data) /*构建node节点的显示*/
				.buildEvent() /*添加事件*/
				.buildSelectedNode(); /*根据状态进行默认显示*/
				return _that;
			}
			/**
    * 创建容器
    * @return {this} DistWin对象
    */

		}, {
			key: '_createContiner',
			value: function _createContiner() {
				this.continer = $('<div ' + this.elementAttr.continer + ' class="' + this.classInfo.continer + '"></div>');
				return this;
			}

			/**
    * 创建头部
    * @return {this} DistWin对象
    */

		}, {
			key: '_createHeader',
			value: function _createHeader() {
				var _that = this,
				    header = $('<div ' + _that.elementAttr.header + ' class="' + _that.classInfo.header + '" ></div>'),
				    selectLabel = $('<label ' + _that.elementAttr.headerLabel + ' class="' + _that.classInfo.headerSelectLabel + '">已选 : </label>'),
				    selectText = $('<div ' + _that.elementAttr.headerSelect + ' class="' + _that.classInfo.headerSelectText + '"></div>');
				selectText.css({ 'max-width': _that.panel.width() - _that.headerTextSubWidth });
				if (!_that.headerHtml) {
					header.append(selectLabel).append(selectText);
				} else {
					header.append(_that.headerHtml).append(selectText);
				}
				_that.header = header;
				return _that;
			}

			/**
    * 创建自定义尾部dom对象
    * @return {this} DistWin对象
    */

		}, {
			key: '_createCustomFooter',
			value: function _createCustomFooter() {
				var _that = this,
				    footer = $('<div ' + _that.elementAttr.footer + ' class="' + _that.classInfo.footer + '"></div>');
				_that.footer = footer;
				_that.appendHtml && _that.footer.append(_that.appendHtml);
				return _that;
			}
			/**
    * 创建节点
    * @return {this} DistWin对象
    */

		}, {
			key: '_createNode',
			value: function _createNode() {
				var _that = this;
				/*构建group节点*/
				var groups = dseUtils.ObjectUtil.getPropValue(_that.groupInfo, 'groups') || [];
				if (groups) for (var i = 0; i < groups.length; i++) {
					_that.groupNodes.push({ stap: i, text: groups[i], html: $('<div ' + _that.elementAttr.nodeGroupStap + '="' + i + '" ' + _that.elementAttr.nodeGroupText + '="' + groups[i] + '" ' + _that.elementAttr.nodeGroup + ' class="' + _that.classInfo.group + '">' + groups[i] + '</div>') });
				} /**
       * 构建html节点
       */

				dseUtils.FunUtil.recursion(_that.data, function (node, children, index) {
					var group = _that.groupNodes[index];
					if (group) node.group = group;
					node.html = _that._createNodeEl(node);
					node.index = index;
					_that.nodeMap[node[_that.idField]] = node;
				});
				/*节点容器*/
				_that.nodeContent = $('<div ' + _that.elementAttr.nodeContent + ' class="' + _that.classInfo.nodeContent + '"></div>');
				return _that;
			}

			/**
    * 创建节点内容
    * @param  {Array} nodes 节点数组
    * @return {this} DistWin对象
    */

		}, {
			key: 'buildNodeContent',
			value: function buildNodeContent(nodes) {
				if (dseUtils.ObjectUtil.isEmpty(nodes)) return this;
				var _that = this,
				    _underWin = _that._underWin,
				    panel = _that.panel,
				    nodeContent = _that.nodeContent,
				    nodeDetailContent = $('<div ' + _that.elementAttr.nodeDetailContent + ' class="' + _that.classInfo.nodeDetail + '"></div>');

				nodeContent.append(nodeDetailContent);
				/*构建第一层*/
				nodes.forEach(function (node) {
					var groupNode = node.group;
					/*添加group*/
					/**
      * TODO 目前测试并无存在多个时的问题
      * if(groupNode && nodeDetailContent.find(groupNode.html).length === 0){
      */
					if (groupNode && _underWin.findElement(panel, groupNode.html).length === 0) nodeDetailContent.append(groupNode.html);
					nodeDetailContent.append(node.html);
					node.contentHtml = nodeDetailContent;
				});
				if (nodeDetailContent.height() > _that.maxHeight) {

					nodeDetailContent.addClass(_that.classInfo.nodeDetailScroll);
				}
				return _that;
			}
			/**
    * 添加初始化点击事件
    * @return {this} DistWin对象
    */

		}, {
			key: 'buildEvent',
			value: function buildEvent() {
				return this._addClickEvent(this.data);
			}
			/**
    * 根据默认状态进行显示结构
    * @return {this} DistWin对象
    */

		}, {
			key: 'buildSelectedNode',
			value: function buildSelectedNode() {
				var _that = this;
				var changeNode = {};
				dseUtils.FunUtil.recursion(_that.sourceData, function (node, children) {
					if (!node.selected || node.isAllInfo) return;
					changeNode[node[_that.idField]] = node;
				});
				dseUtils.FunUtil.recursion(_that.data, function (node) {
					if (!changeNode[node[_that.idField]]) return;
					node.selected = false;
					_that._clickEvent(node, _that.isSelectedNotTrigger);
					// node.html.trigger('click');
				});
				return _that;
			}
			/**
    * 添加点击事件,改变node的状态
    * @param {Array} nodes 节点数/
    * @return {this} DistWin对象
    */

		}, {
			key: '_addClickEvent',
			value: function _addClickEvent(nodes) {
				var _that = this,
				    hasClick = false;
				if (dseUtils.ObjectUtil.isEmpty(nodes)) return _that;
				nodes.forEach(function (node) {
					var nodeHtml = node.html;
					nodeHtml.unbind('click');
					nodeHtml.unbind('dblclick');
					nodeHtml.on('dblclick', function (e) {
						if (_that.onDbClick) _that.onDbClick(node, _that.data, _that._getNodesOfAllNode(node));
					});
					nodeHtml.on('click', function (e) {
						_that._clickEvent(node);
					});
				});

				return _that;
			}
			/**
    * 根据"全部"节点返回节点数据
    * @param  {Object} node 节点
    * @return {Array}      结果集
    */

		}, {
			key: '_getNodesOfAllNode',
			value: function _getNodesOfAllNode(node) {
				var _that = this,
				    results = [];
				if (!node.isAllInfo || !node.selected) return results;
				dseUtils.FunUtil.recursion(_that.data, function (data, children, index) {
					if (index !== node.index || data.isAllInfo || node[_that.pidField] !== data[_that.pidField]) return;
					results.push(data);
				});
				return results;
			}
			/**
    * 点击渲染事件
    * @param  {Object} node 被点击节点
    * @return {this}      DistWin对象
    */

		}, {
			key: '_clickEvent',
			value: function _clickEvent(node, isNoCallback) {
				var _that = this;
				_that.clearAllChildStat(node) /*1、清除所有下级的状态*/
				.setBrothersStat(node) /*2、设置同级节点的状态*/
				.setNodeStat(node, !node.selected) /*3、设置选中状态*/
				.clearChildHtml(node) /*4、清除下级所有html*/
				.setLastSelectNodeStat(); /*5、设置选中或者取消的最后一个节点*/
				/*如果为选中状态则根据当前节点生成child的html,并添加事件*/
				if (node.selected) _that.buildNodeContent(node.children)._addClickEvent(node.children);
				/*显示已选*/
				_that.buildSelectText(node);
				/*回调调用*/
				if (_that.onClick && !isNoCallback) _that.onClick(node, _that.data, _that._getNodesOfAllNode(node));
				return this;
			}
			/**
    * 构建头部选中的显示
    * @param  {Object} clickNode 被点击节点
    * @return {this} DistWin对象
    */

		}, {
			key: 'buildSelectText',
			value: function buildSelectText(clickNode) {
				var _that = this,
				    _underWin = _that._underWin;
				var header = _underWin.findElement(_that.panel, _that.header);
				var str = '';
				var beSelectedNode = [];
				dseUtils.FunUtil.recursion(_that.data, function (node, children, index) {
					if (node.selected) {
						str += node[_that.displayField] + '>';
						beSelectedNode.push(node);
					}
				});
				str = dseUtils.StringUtil.removeLast(str);
				if (_that.onRenderHeader) {
					header.find('div[' + _that.elementAttr.headerSelect + ']').html(_that.onRenderHeader(clickNode, beSelectedNode));
				} else {
					header.find('div[' + _that.elementAttr.headerSelect + ']').html(str);
				}

				return _that;
			}
			/**
    * 清除所有节点的状态
    * @return {this} DistWin对象
    */

		}, {
			key: 'clearAllStat',
			value: function clearAllStat() {
				var _that = this;
				dseUtils.FunUtil.recursion(_that.data, function (node) {
					return _that.setNodeStat(node, false);
				});
				return _that;
			}
			/**
    * 清除下级所有的html
    * @param  {Object} parentNode 父节点
    * @return {this}            DistWin对选
    */

		}, {
			key: 'clearChildHtml',
			value: function clearChildHtml(parentNode) {
				var _that = this,
				    _underWin = _that._underWin;
				var parentHtml = _underWin.findElement(_that.panel, parentNode.contentHtml),
				    nextHtml = parentHtml.next();
				while (nextHtml.length) {
					nextHtml.remove();
					nextHtml = parentHtml.next();
				}
				return _that;
			}

			/**
    * 清除所有下级节点的状态
    * @param  {Object} parentNode 父节点
    * @return {this}            DistWin对象
    */

		}, {
			key: 'clearAllChildStat',
			value: function clearAllChildStat(parentNode) {
				var _that = this;
				dseUtils.FunUtil.recursion(_that.data, function (node, children, index) {
					/*同级别不需要清除*/
					if (index <= parentNode.index) return;
					_that.setNodeStat(node, false);
				});
				return _that;
			}
			/**
    * 设置兄弟节点的状态，根据是否配置了可以同层多选
    * @param {Object} targetNode 目标节点
    * @return {this}            DistWin对象
    */

		}, {
			key: 'setBrothersStat',
			value: function setBrothersStat(targetNode) {
				var _that = this;
				if (_that.isMultiSelect) return _that;
				dseUtils.FunUtil.recursion(_that.data, function (node, children, index) {
					if (targetNode.index !== node.index) return;
					if (targetNode[_that.idField] === node[_that.idField]) return;
					_that.setNodeStat(node, false);
				});
				return _that;
			}
			/**
    * 设置节点的状态
    * @param {Object}  node       目标节点
    * @param {Boolean} isSelected 是否选中
    * @return {this}            DistWin对象
    */

		}, {
			key: 'setNodeStat',
			value: function setNodeStat(node, isSelected) {
				var _that = this;
				node.selected = isSelected;
				if (node.selected && node.html) node.html.addClass(_that.classInfo.nodeSelect);else if (node.html) node.html.removeClass(_that.classInfo.nodeSelect);
				return _that;
			}
			/**
    * 设置节点的最后一个状态
    * @param {Object}  node       目标节点
    * @param {Boolean} isSelected 是否选中
    * @return {this}            DistWin对象
    */

		}, {
			key: 'setNodeStatLast',
			value: function setNodeStatLast(node, isSelected) {
				var _that = this;
				node.html.removeClass(_that.classInfo.nodeSelectLast);
				if (isSelected) node.html.addClass(_that.classInfo.nodeSelectLast);
				return _that;
			}
			/**
    * 遍历已选中节点，设置最后一个的状态样式
    * @return {this}            DistWin对象
    */

		}, {
			key: 'setLastSelectNodeStat',
			value: function setLastSelectNodeStat() {
				var _that = this,
				    lastNode = '';
				dseUtils.FunUtil.recursion(_that.data, function (node, children, index) {
					_that.setNodeStatLast(node, false);
					if (node.selected) lastNode = node;
				});
				if (lastNode) _that.setNodeStatLast(lastNode, true);
				return _that;
			}
		}, {
			key: 'delNodeHtml',
			value: function delNodeHtml() {
				var _that = this;
				dseUtils.FunUtil.recursion(_that.data, function (node, children, index) {
					if (node.html) node.html = '';
					if (node.contentHtml) node.contentHtml = '';
				});
				return _that;
			}
			/**
    * 建立关系
    * @return {this} DistWin对象
    */

		}, {
			key: '_buildRelation',
			value: function _buildRelation() {
				var _that = this;
				var resultContent = _that.continer.append(_that.header).append(_that.nodeContent);
				_that.panel.append(resultContent).append(_that.footer);
				return _that;
			}

			/**
    * 创建一个节点
    * @param  {Object} node 节点对象
    * @return {JQObject}      返回一个element
    */

		}, {
			key: '_createNodeEl',
			value: function _createNodeEl(node) {
				return $('<div ' + this.elementAttr.node + ' data-pid="' + node[this.pidField] + '" data-id="' + node[this.idField] + '" class="' + this.classInfo.node + '">' + node[this.displayField] + '</div>');
			}
		}]);

		return DistWin;
	}();

	module.exports.DistWin = DistWin;
});;'use strict';
/**
 * 点击元素在下方弹出框，多余产生的元素会追加在body标签下
 * create by wangxd
 */
var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine('dseUnderWin', function (require, exports, module) {
	var $ = require('jquery'),
	    dseUtils = require('dseUtils').DseUtils,
	    DistWin = require('dseDistWin').DistWin;

	var DseUnderWin = function () {
		/**
   * 初始化构造函数
   * 默认情况下生成一个在下方且宽度等于元素，自适应的元素
   * @param  {Object} config {
   *                      	target : Object,目标Jq对象
   *                      	data : Object,渲染数据,
   *                      	displayField : String,显示字段，如果没有则拿text进行显示,
   *                      	idField:String,id属性名称,如果没有则为id,
   *                      	pidField:String,pid属性名称,如果没有则为pid,
   *                      	appendTo : Object,Jquery标签对象，如果有值则弹窗会将dom生成到该元素下，且自动为target添加点击显示事件,
   *                      	groupInfo: Object,分组信息对象，如果需要分组则填写改对象
   *                      				{
   *                      					groups:['一级','二级','三级']
   *                      				},
   *                      	allInfo: Object,全选信息对象，
   *                      			{
   *                      				text: '全部',全选的显示命名
   *                      			},
   *                      	onClick: function(node,nodes),注册点击事件，返回被点击的节点，以及所有的节点
   *                      	onDbClick: function(node,nodes),注册双击事件，返回被点击的节点，以及所有的节点
   *                      	isClickReset:Boolean,是否隐藏panel后再点击显示需要重置panel的状态,默认false
   *                      	isMultiSelect:Boolean,是否支持同层多选,默认为false,
   *                      	position: Object,位置配置
   *                      				{
   *                      					offsetLeft: 左边偏移量
   *                      					offsetTop: 上方偏移量
   *                      					width: 宽度
   *                      					height: 高度
   *                      				}
   *                          }
   */
		function DseUnderWin(config) {
			_classCallCheck(this, DseUnderWin);

			if (!dseUtils.ObjectUtil.isObject(config)) throw new Error('config is not a Object.');
			this._targets = [];
			this._data = [];
			this.target = config.target;
			this.targetInfo = {}; /*目标div的样式信息*/
			this.idPanel = {}; /*id为自定义生成对应panel*/
			this.idDistWin = {}; /*id为自定义生成对应DistWin对象*/
			this.idAppendTo = {}; /*id为自定义生成对应appendTo对象*/
			this.appendTo = config.appendTo;
			this.maxHeight = config.maxHeight || 180;
			this.displayField = config.displayField || 'text';
			this.idField = config.idField || 'id';
			this.pidField = config.pidField || 'pid';
			this.isClickShow = config.isClickShow || false;
			this.onClick = config.onClick; /*点击事件*/
			this.onDbClick = config.onDbClick; /*双击事件*/
			this.onClose = config.onClose;
			this.data = config.data;
			this.groupInfo = config.groupInfo;
			this.allInfo = config.allInfo;
			this.isSelectedNotTrigger = config.isSelectedNotTrigger || false;
			this.isAllSelect = config.isAllSelect || false;
			this.isClickReset = config.isClickReset || false;
			this.isCustomShow = config.isCustomShow || false;
			this.isMultiSelect = config.isMultiSelect || false;
			this.position = config.position;
			this.zIndex = 1000;
			/*属性标示*/
			this.elementAttr = {
				panel: 'data-flag-panel-id'
			};
			/*样式信息*/
			this.classInfo = {
				panel: {
					content: 'dse-underwin-panel'
				},
				distWin: {
					continer: 'dse-underwin-continer',
					header: 'dse-underwin-header',
					footer: 'dse-underwin-footer',
					headerSelectLabel: 'dse-underwin-header-label',
					headerSelectText: 'dse-underwin-header-text',
					nodeContent: 'dse-underwin-content',
					nodeDetail: 'dse-underwin-node-detail',
					nodeDetailScroll: 'dse-underwin-node-detail-scroll',
					group: 'dse-underwin-group',
					node: 'dse-underwin-node',
					nodeSelect: 'dse-underwin-node-selected',
					nodeSelectLast: 'dse-underwin-node-selected-last'
				}
			};
		}
		/*setter/getter  start*/
		/**
   * 设置data数据
   * @param  {Object} data 数据源
   * @return {this}      DseUnderWin对象
   */


		_createClass(DseUnderWin, [{
			key: '_generatorPanelId',

			/*setter/getter  end*/

			/**
    * 产生panel的id
    * @return {String} id
    */
			value: function _generatorPanelId() {
				return dseUtils.StringUtil.uuid();
			}
			/**
    * 创建一个空白面板，是否创建样式，由参数决定
    * @return {String}    panel的id
    */

		}, {
			key: 'createPanel',
			value: function createPanel() {
				var _that = this,
				    panelId = _that._generatorPanelId(),
				    panel = $('<div onselectstart="return false" ' + _that.elementAttr.panel + '="' + panelId + '"></div>');
				_that.idPanel[panelId] = panel;
				/*添加事件*/
				_that._buildPanelEvent(panelId)._buildCss(panel);
				return panelId;
			}

			/**
    * 重置面板状态
    * @return {this}
    */

		}, {
			key: 'resetPanel',
			value: function resetPanel(panelId) {
				var _that = this,
				    panel = _that.getPanelOfId(panelId),
				    _distWin = _that.getDistWinOfId(panelId);
				panel.empty();
				_distWin.clearAllStat();
				_distWin.delNodeHtml();
				_distWin.allInfo = {};
				_distWin = new DistWin(_distWin);
				return _that;
			}
			/**
    * 获取面板
    * @param  {String} id [panel的Id值]
    * @return {JQObject} 返回面板的jquery对象
    */

		}, {
			key: 'getPanelOfId',
			value: function getPanelOfId(id) {
				return this.idPanel[id];
			}
			/**
    * 获取DistWin对象
    * @param  {String} id [panel的Id值]
    * @return {JQObject} 返回面板的jquery对象
    */

		}, {
			key: 'getDistWinOfId',
			value: function getDistWinOfId(id) {
				return this.idDistWin[id];
			}
			/**
    * 查找div
    * @param  {Element} panel 元素
    * @param  {Element} element 元素
    * @return {JQObject}         返回元素
    */

		}, {
			key: 'findElement',
			value: function findElement(panel, element) {
				return panel.find(element);
			}
			/**
    * 创建创建行政区划下拉
    * @param  {Object} config配置
    *         			{	
    *         				headerHtml:'',头部自定义的html代码
    *         				onRenderHeader:function(clickNode,beSelectedNode){
    *         					return html
    *         				}
    *         			}
    * @return {Object} panel对象
    */

		}, {
			key: 'createDistWin',
			value: function createDistWin(config) {
				/*生成一个面板*/
				var _underWin = this,
				    panelId = _underWin.createPanel(),
				    panel = _underWin.getPanelOfId(panelId),
				    _distWin = new DistWin({
					_underWin: _underWin,
					classInfo: _underWin.classInfo.distWin,
					displayField: _underWin.displayField,
					idField: _underWin.idField,
					pidField: _underWin.pidField,
					data: _underWin._data,
					sourceData: _underWin._data,
					maxHeight: _underWin.maxHeight,
					onClick: _underWin.onClick,
					onDbClick: _underWin.onDbClick,
					headerHtml: dseUtils.ObjectUtil.getPropValue(config, 'headerHtml'),
					onRenderHeader: dseUtils.ObjectUtil.getPropValue(config, 'onRenderHeader'),
					appendHtml: dseUtils.ObjectUtil.getPropValue(config, 'appendHtml'),
					headerTextSubWidth: dseUtils.ObjectUtil.getPropValue(config, 'headerTextSubWidth'),
					groupInfo: _underWin.groupInfo,
					allInfo: _underWin.allInfo,
					isAllSelect: _underWin.isAllSelect,
					isSelectedNotTrigger: _underWin.isSelectedNotTrigger,
					panelId: panelId,
					panel: panel,
					isMultiSelect: _underWin.isMultiSelect
				});
				_underWin.idDistWin[panelId] = _distWin;
				return _distWin;
			}

			/*private method start*/
			/**
    * 设置样式
    * @return {this}
    */

		}, {
			key: '_buildCss',
			value: function _buildCss(panel) {
				/*解析对象的样式信息*/
				var targetInfo = this._resolveTarget().targetInfo;
				/*位置信息*/
				var position = this.position;
				panel.addClass(this.classInfo.panel.content);
				/*生成默认样式*/
				var classInfo = {
					'position': 'absolute',
					'z-index': targetInfo.zIndex,
					'top': targetInfo.top + targetInfo.height + dseUtils.ObjectUtil.getPropValueInt(position, 'offsetTop'),
					'left': targetInfo.left + dseUtils.ObjectUtil.getPropValueInt(position, 'offsetLeft'),
					'height': dseUtils.ObjectUtil.getPropValueInt(position, 'height') || 'auto',
					'width': dseUtils.ObjectUtil.getPropValueInt(position, 'width') || targetInfo.width - 2 };
				if (dseUtils.ObjectUtil.getPropValueInt(position, 'isNotSet')) {
					classInfo.top -= targetInfo.top;
					classInfo.left -= targetInfo.left;
				}
				panel.css(classInfo);
				return this;
			}
			/**
    * 添加事件到panel中
    * @return {this} [description]
    */

		}, {
			key: '_buildPanelEvent',
			value: function _buildPanelEvent(panelId) {
				var _that = this,
				    panel = _that.getPanelOfId(panelId);

				if (_that.isCustomShow) {
					_that.idAppendTo[panelId] = $(_that.appendTo);
					$(_that.idAppendTo[panelId]).append(panel);
					return _that;
				}
				if (_that.appendTo) {
					_that.idAppendTo[panelId] = $(_that.appendTo);

					if (_that.isClickShow) {
						_that.target.on('click', function () {
							if (!_that.idDistWin[panelId].isDestory) $(_that.idAppendTo[panelId]).append(panel);
						});
					} else {
						_that.target.mouseover(function () {
							if (!_that.idDistWin[panelId].isDestory) $(_that.idAppendTo[panelId]).append(panel);
						});
					}
				}

				var divTarget = _that.target;
				/*添加点击区域外消失事件*/
				if (_that.isClickShow) {
					$(document).on('click', function (e) {
						var target = $(e.target);
						var isShow = panel.css('display') !== 'none';
						var targetIsDisabled = divTarget.attr('disabled') === 'disabled';
						if (targetIsDisabled) {
							panel.hide();
						}
						if (target.closest(divTarget).length === 0 && target.closest(panel).length === 0) {
							if (isShow) {
								if (_that.isClickReset) _that.resetPanel(panelId);
								if (_that.onClose) _that.onClose(_that.idDistWin[panelId]);
								panel.hide();
							}
						} else {
							if (!_that.idDistWin[panelId].isDestory && !isShow && !targetIsDisabled) panel.show();
						}
					});
				} else {
					$(document).mouseover(function (e) {
						var target = $(e.target);
						var isShow = panel.css('display') !== 'none';
						var targetIsDisabled = divTarget.attr('disabled') === 'disabled';
						if (targetIsDisabled) {
							panel.hide();
						}
						if (target.closest(divTarget).length === 0 && target.closest(panel).length === 0) {
							if (isShow) {
								if (_that.isClickReset) _that.resetPanel(panelId);
								if (_that.onClose) _that.onClose(_that.idDistWin[panelId]);
								panel.hide();
							}
						} else {
							if (!_that.idDistWin[panelId].isDestory && !isShow && !targetIsDisabled) panel.show();
						}
					});
				}

				/*添加点击区域外消失事件*/
				$(document).click(function (e) {
					var target = $(e.target);
					var isShow = panel.css('display') !== 'none';
					var targetIsDisabled = divTarget.attr('disabled') === 'disabled';
					if (targetIsDisabled) {
						panel.hide();
					}
					if (target.closest(divTarget).length === 0 && target.closest(panel).length === 0) {
						if (isShow) {
							if (_that.isClickReset) _that.resetPanel(panelId);
							panel.hide();
						}
					} else {
						if (!_that.idDistWin[panelId].isDestory && !isShow && !targetIsDisabled) panel.show();
					}
				});
				return _that;
			}
			/**
    * 解析目标对象
    * @return {Object} 返回目标对象的配置信息
    */

		}, {
			key: '_resolveTarget',
			value: function _resolveTarget() {
				var target = this.target;
				/*获取位置对象*/
				var targetOffset = target.offset();

				var zIndex = target.css('z-index');
				if (zIndex === 'auto' || !zIndex) zIndex = this.zIndex++;

				/*获取元素基本信息*/
				this.targetInfo = {
					left: targetOffset.left,
					top: targetOffset.top,
					width: target.width(),
					height: target.height(),
					zIndex: zIndex
				};
				return this;
			}
			/*private method end*/

		}, {
			key: 'data',
			set: function set(data) {
				this._data = dseUtils.ObjectUtil.depthCopy(data);
			},
			get: function get() {
				return this._data;
			}
		}, {
			key: 'target',
			set: function set(target) {
				this._targets.push(target);
			},
			get: function get() {
				return dseUtils.ArrayUtil.last(this._targets);
			}
		}]);

		return DseUnderWin;
	}();

	module.exports.DseUnderWin = DseUnderWin;
});;'use strict';
/*common唯一入口*/
/**
 * common对外提供的服务类
 * create by wangxd
 */
var dseDefine = dseDefine === null ? define : dseDefine;
dseDefine(function (require, exports, module) {
	/**
  * 配置对外提供的服务
  * @type {Object}
  */
	module.exports.DseCommon = {
		DseRequest: require('dseRequest').DseRequest, /*请求服务*/
		DseConstant: require('dseConstant').DseConstant, /*常量配置*/
		DseUtils: require('dseUtils').DseUtils, /*工具类*/
		// DseLoad: require('dseLoad'),/*加载触发类*/
		DseUnderWin: require('dseUnderWin').DseUnderWin, /*下拉窗体*/
		DseSearch: require('dseSearch').DseSearch, /*搜索框*/
		DseMenu: require('dseMenu').DseMenu /*菜单*/
		// DseFile: require('dseFile').DseFile/*搜索框*/
	};
});
