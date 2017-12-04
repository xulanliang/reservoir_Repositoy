//普通 table 滚动分页
DSE.form.tablePager = function (data, params, obj) {
	if(!data){
		return false;
	}
	obj = obj || '.g-tb-cont';
	var _flag = true;
	$(obj).scroll(function() {
		var $t = $(this);
		if($t.scrollTop() >= ($t.find('table').height() - $t.height() - 10)) {
			if(DSE.form.pageNo && DSE.form.pageSize && DSE.form.dataTotal) {
				_flag = false;
				if(data) {
					var _data;
					if(typeof data == 'object') {
						if(DSE.form.pageNo <= Math.ceil(data.length / DSE.form.pageSize)) {
							DSE.form.pageNo += 1;
							if(DSE.form.pageSize * (DSE.form.pageNo - 1) <= data.length) {
								_data = data.slice(DSE.form.pageSize * (DSE.form.pageNo - 1), DSE.form.pageSize * DSE.form.pageNo);
							} else {
								_data = data.slice(DSE.form.pageSize * (DSE.form.pageNo - 1), data.length - 1);
							}
							if(DSE.form.createTableTr) {
								$t.find('tbody').append(DSE.form.createTableTr(_data));
								_flag = true;
							}
						}
					} else if(typeof data == 'string') {
						if(params) {
							if(Math.ceil(DSE.form.dataTotal / DSE.form.pageSize) > DSE.form.pageNo) {
								DSE.form.pageNo += 1;
								params["page"] = DSE.form.pageNo;
								params["rows"] = DSE.form.pageSize;
								_data = $ajax({url:data, data:params})["rows"] || [];
								if(data.length > 0) {
									if(DSE.form.createTableTr) {
										$t.find('tbody').append(DSE.form.createTableTr(_data));
										_flag = true;
									}
								}
							}
						}
					}
				}
			}
		}
	});
};

//easyui datagrid 本地分页
DSE.form.datagridPager = function (obj, data) {
	if(!data){
		return false;
	}
	obj = obj || DSE.form.datagrid;
	var $t = $(obj),
		pager = $t.datagrid("getPager"),
		info = $t.data().datagrid,
		view1 = info.dc.view1,
		_pageSize = info.options.pageSize,
		_pageNo = info.options.pageNumber,
		_dataTotal = data.length;
	pager.pagination({
		total: _dataTotal,
		onSelectPage: function(_pageNo, _pageSize) {
			var start = (_pageNo - 1) * _pageSize,
				end = start + _pageSize;
			$t.datagrid("loadData", data.slice(start, end));
			pager.pagination('refresh', {
				total: _dataTotal,
				pageNumber: _pageNo
			});
			view1.find('.datagrid-cell-rownumber').text(function() {
				return parseInt($(this).text()) + (_pageNo - 1) * _pageSize;
			});
		}
	});
};

//easyui datagrid 滚动分页
DSE.form.datagridScrollPage = function (pageSize, data, params, obj) {
	if(!data){
		return false;
	}
	obj = obj || DSE.form.datagrid;
	var info = $(obj).data().datagrid,
		body2 = info.dc.body2,
		view2 = info.dc.view2,
		_pageSize = info.options.pageSize,
		_pageNo = info.options.pageNumber,
		_dataTotal = !params ? data.length : info.data.tatal;
	var _flag = true;
	body2.scroll(function() {
		var $t = $(this);
		if($t.scrollTop() >= ($t.find('tbody').height() - $t.height() - 10) && _flag) {
			if(_pageNo && pageSize && _dataTotal) {
				_flag = false;
				if(data) {
					var _data;
					if(typeof data == 'object') {
						if(_pageNo <= Math.ceil(data.length / pageSize)) {
							_pageNo += 1;
							if(pageSize * (_pageNo - 1) <= data.length) {
								_data = data.slice(pageSize * (_pageNo - 1), pageSize * _pageNo);
							} else {
								_data = data.slice(pageSize * (_pageNo - 1), data.length - 1);
							}
							$.each(_data, function(i) {
								$(obj).datagrid('appendRow', _data[i]);
							});
							$(obj).datagrid('reload');
							_flag = true;
						}
					} else if(typeof data == 'string') {
						if(params) {
							if(Math.ceil(_dataTotal / pageSize) > _pageNo) {
								_pageNo += 1;
								params["page"] = _pageNo;
								params["rows"] = pageSize;
								_data = $ajax({url:data, data:params})["rows"] || [];
								if(data.length > 0) {
									$.each(_data["rows"], function(i) {
										$(obj).datagrid('appendRow', _data["rows"][i]);
									});
								}
								_flag = true;
							}
						}
					}
				}
			}
		}
	});
};
