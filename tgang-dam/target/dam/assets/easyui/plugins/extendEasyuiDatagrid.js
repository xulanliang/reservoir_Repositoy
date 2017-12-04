/*扩展easyui可编辑脚本*/
/*tab管理对象*/

var _dseBuildEasyuiEditor = function($) {
	var editIndex = undefined;
	var editIndexTableName = undefined;
	var editorCell = {

	};
	var extendTableEdit = function() {
		$.extend($.fn.datagrid.methods, {
			editCell : function(jq, param) {
				return jq.each(function() {
					var _this = $(this);
					var fields = _this.datagrid('getColumnFields', true)
							.concat($(this).datagrid('getColumnFields'));
					for ( var i = 0; i < fields.length; i++) {
						var col = $(this)
								.datagrid('getColumnOption', fields[i]);
						col.editor1 = col.editor;
						if (fields[i] != param.field)
							col.editor = null;
					}
					_this.datagrid('beginEdit', param.index);
					for ( var i = 0; i < fields.length; i++) {
						var col = _this.datagrid('getColumnOption', fields[i]);
						col.editor = col.editor1;
					}
				});
			}
		});
	};

	var extentMenu = function() {

		/**
		 * menu方法扩展
		 *
		 * @param {Object}
		 *            jq
		 * @param {Object}
		 *            region
		 */
		$.extend($.fn.menu.methods, {
			/**
			 * 激活选项（覆盖重写）
			 *
			 * @param {Object}
			 *            jq
			 * @param {Object}
			 *            itemEl
			 */
			enableItem : function(jq, itemEl) {
				return jq.each(function() {
					var t = $(itemEl);
					var state = t.data('menu.item');
					if (!state) {
						t.data('menu.item', {
							options : {}
						});
					}
					state = t.data('menu.item');
					if (state.onclickStr) {
						var newclick = new Function(state.onclickStr);
						t.bind('click', newclick);
					} else {
						if (state.onclick) {
							t.bind('click', state.onclick);
							state.onclick = null;
						}
					}
					t.removeClass('menu-item-disabled');
				});
			},
			/**
			 * 禁用选项（覆盖重写）
			 *
			 * @param {Object}
			 *            jq
			 * @param {Object}
			 *            itemEl
			 */
			disableItem : function(jq, itemEl) {
				return jq.each(function() {
					var t = $(itemEl);
					var state = t.data('menu.item');
					if (!state) {
						t.data('menu.item', {
							options : {}
						});
					}
					state = t.data('menu.item');
					var onclickStr = t.attr("onclick");
					if (onclickStr && onclickStr != "") {
						state.onclickStr = onclickStr;
						t.attr("onclick", "");
					} else {
						t.addClass('menu-item-disabled');
						if (t.data("events")["click"]) {
							var eventData = t.data("events")["click"];
							for ( var i = 0; i < eventData.length; i++) {
								if (eventData[i].namespace != "menu") {
									state.onclick = eventData[i]["handler"];
									t.unbind('click', eventData[i]["handler"]);
								}
							}
						}
					}
					t.addClass('menu-item-disabled');
				});
			}
		});

	};

	editorCell.endEditing = function(tar) {
		if (editIndex == undefined) {
			return true;
		}
		var $grid = $(tar);
		if (!$grid.datagrid('validateRow', editIndex))
			return false;
		$grid.datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	};

	editorCell.onClickCell = function(index, field, value) {

		if (field == 't') {
			return false;
		}
		/* 记录字段名称，用于移动编辑 */
		editorCell.fieldname = field;
		editorCell.lastIndex = index;
		/* 第一行不可编辑 */
		if (editorCell.endEditing(this)) {
			$(this).datagrid('selectRow', index).datagrid('editCell', {
				index : index,
				field : field
			});
			var editor = $(this).datagrid('getEditor', {
				index : index,
				field : field
			});
			if (editor)
				editor.target[0].select();
			editIndex = index;
			editIndexTableName = $(this).attr('name');
		}
	};

	extendTableEdit();
	extentMenu();

	return editorCell;
};

// jiangfl 扩展成支持seajs,王晓东说和地图有冲突，这里参考王晓东的代码
if (typeof dseDefine === 'function') {
	dseDefine(function(require) {
		return _dseBuildEasyuiEditor(require('easyui'));
	});
} else {
	// 依赖jquery
	_dseBuildEasyuiEditor(jQuery);
}
