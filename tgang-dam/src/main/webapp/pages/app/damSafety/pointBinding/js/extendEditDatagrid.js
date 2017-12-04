/*扩展easyui可编辑脚本*/
/*tab管理对象*/

var _dseBuildExtendEditor = function($) {
	var editIndex1 = undefined;
	var editIndexTableName1 = undefined;

	var editIndex2 = undefined;
	var editIndexTableName2 = undefined;

	var editIndex3 = undefined;
	var editIndexTableName3 = undefined;

	var editorCell1 = {

	};

	var editorCell2 = {

	};

	var editorCell3 = {

	};

	var extendTableEdit = function() {
		$.extend($.fn.datagrid.methods, {
			editCell1 : function(jq, param) {
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

	editorCell1.endEditing = function(tar) {
		if (editIndex1 == undefined) {
			return true;
		}
		var $grid = $(tar);
		if (!$grid.datagrid('validateRow', editIndex1))
			return false;
		$grid.datagrid('endEdit', editIndex1);
		editIndex1 = undefined;
		return true;
	};

	editorCell1.onClickCell = function(index, field, value) {

		if (editorCell2.lastIndex != undefined) {
			$('#btdTab').datagrid('endEdit', editorCell2.lastIndex);
		}
		if (editorCell3.lastIndex != undefined) {
			$('#fsqTab').datagrid('endEdit', editorCell3.lastIndex);
		}

		/* 记录字段名称，用于移动编辑 */
		editorCell1.fieldname = field;
		editorCell1.penultIndex = editorCell1.lastIndex;
		editorCell1.lastIndex = index;
		/* 第一行不可编辑 */
		if (editorCell1.endEditing(this)) {
			$(this).datagrid('selectRow', index).datagrid('editCell1', {
				index : index,
				field : field
			});
			var editor = $(this).datagrid('getEditor', {
				index : index,
				field : field
			});
			if (editor)
				editor.target[0].select();
			editIndex1 = index;
			editIndexTableName1 = $(this).attr('name');
		}
	};

	editorCell2.endEditing = function(tar) {
		if (editIndex2 == undefined) {
			return true;
		}
		var $grid = $(tar);
		if (!$grid.datagrid('validateRow', editIndex2))
			return false;
		$grid.datagrid('endEdit', editIndex2);
		editIndex2 = undefined;
		return true;
	};

	editorCell2.onClickCell = function(index, field, value) {

		if (editorCell1.lastIndex != undefined) {
			$('#jkdTab').datagrid('endEdit', editorCell1.lastIndex);
		}
		if (editorCell3.lastIndex != undefined) {
			$('#fsqTab').datagrid('endEdit', editorCell3.lastIndex);
		}

		/* 记录字段名称，用于移动编辑 */
		editorCell2.fieldname = field;
		editorCell2.penultIndex = editorCell2.lastIndex;
		editorCell2.lastIndex = index;
		/* 第一行不可编辑 */
		if (editorCell2.endEditing(this)) {
			$(this).datagrid('selectRow', index).datagrid('editCell1', {
				index : index,
				field : field
			});
			var editor = $(this).datagrid('getEditor', {
				index : index,
				field : field
			});
			if (editor)
				editor.target[0].select();
			editIndex2 = index;
			editIndexTableName2 = $(this).attr('name');
		}
	};

	editorCell3.endEditing = function(tar) {
		if (editIndex3 == undefined) {
			return true;
		}
		var $grid = $(tar);
		if (!$grid.datagrid('validateRow', editIndex3))
			return false;
		$grid.datagrid('endEdit', editIndex3);
		editIndex3 = undefined;
		return true;
	};

	editorCell3.onClickCell = function(index, field, value) {

		if (editorCell1.lastIndex != undefined) {
			$('#jkdTab').datagrid('endEdit', editorCell1.lastIndex);
		}

		if (editorCell2.lastIndex != undefined) {
			$('#btdTab').datagrid('endEdit', editorCell2.lastIndex);
		}

		/* 记录字段名称，用于移动编辑 */
		editorCell3.fieldname = field;
		editorCell3.penultIndex = editorCell3.lastIndex;
		editorCell3.lastIndex = index;
		/* 第一行不可编辑 */
		if (editorCell3.endEditing(this)) {
			$(this).datagrid('selectRow', index).datagrid('editCell1', {
				index : index,
				field : field
			});
			var editor = $(this).datagrid('getEditor', {
				index : index,
				field : field
			});
			if (editor)
				editor.target[0].select();
			editIndex3 = index;
			editIndexTableName3 = $(this).attr('name');
		}
	};

	extendTableEdit();

	var editorCell = {
		editorCell1: editorCell1,
		editorCell2: editorCell2,
		editorCell3: editorCell3
	}

	return editorCell;
};

// jiangfl 扩展成支持seajs,王晓东说和地图有冲突，这里参考王晓东的代码
if (typeof dseDefine === 'function') {
	dseDefine(function(require) {
		return _dseBuildExtendEditor(require('easyui'));
	});
} else {
	// 依赖jquery
	_dseBuildExtendEditor(jQuery);
}
