//css引入(__***css执行配置时会自动加载，不需要再require调用***__)
require_css('css!pages/app/demos/baseui/css/index.css');

//执行配置
require.config(DSE.requireConfig);
define('index', function(require, exports, module) {
	var _common = require('common');

	$('#combotree').combotree({
		data: [{
			id: "1",
			text: "广东省",
			children: [
				{ id: "2", text: "广州市" },
				{ id: "3", text: "深圳市" },
				{ id: "4", text: "珠海市" }
			]
		}],
		valueField: 'id',
		textField: 'text',
		width: '150px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		editable: false,
		prompt: '-请选择-'
	});

	$('#combobox').combobox({
		data: [
			{ id: "1", text: "男" },
			{ id: "2", text: "女" }
		],
		valueField: 'id',
		textField: 'text',
		width: '150px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		editable: false,
		prompt: '-请选择-'
	});

	$('#combobox2').combobox({
		data: [{
			"value": "f20",
			"text": "Firefox 2.0 or higher",
			"group": "Firefox"
		}, {
			"value": "f15",
			"text": "Firefox 1.5.x",
			"group": "Firefox"
		}, {
			"value": "f10",
			"text": "Firefox 1.0.x",
			"group": "Firefox"
		}, {
			"value": "ie7",
			"text": "Microsoft Internet Explorer 7.0 or higher",
			"group": "Microsoft Internet Explorer"
		}, {
			"value": "ie6",
			"text": "Microsoft Internet Explorer 6.x",
			"group": "Microsoft Internet Explorer"
		}, {
			"value": "ie5",
			"text": "Microsoft Internet Explorer 5.x",
			"group": "Microsoft Internet Explorer"
		}, {
			"value": "ie4",
			"text": "Microsoft Internet Explorer 4.x",
			"group": "Microsoft Internet Explorer"
		}, {
			"value": "op9",
			"text": "Opera 9.0 or higher",
			"group": "Opera"
		}, {
			"value": "op8",
			"text": "Opera 8.x",
			"group": "Opera"
		}, {
			"value": "op7",
			"text": "Opera 7.x",
			"group": "Opera"
		}, {
			"value": "Safari",
			"text": "Safari"
		}, {
			"value": "Other",
			"text": "Other"
		}],
		method: 'get',
		valueField: 'value',
		textField: 'text',
		groupField: 'group',
		width: '150px',
		panelWidth: '260px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		editable: false,
		prompt: '-请选择-'
	});

	$('#combogrid').combogrid({
		data: [
			{ "productid": "FI-SW-01", "productname": "Koi", "unitcost": 10.00, "status": "P", "listprice": 36.50, "attr1": "Large", "itemid": "EST-1" },
			{ "productid": "K9-DL-01", "productname": "Dalmation", "unitcost": 12.00, "status": "P", "listprice": 18.50, "attr1": "Spotted Adult Female", "itemid": "EST-10" },
			{ "productid": "RP-SN-01", "productname": "Rattlesnake", "unitcost": 12.00, "status": "P", "listprice": 38.50, "attr1": "Venomless", "itemid": "EST-11" },
			{ "productid": "RP-SN-01", "productname": "Rattlesnake", "unitcost": 12.00, "status": "P", "listprice": 26.50, "attr1": "Rattleless", "itemid": "EST-12" },
			{ "productid": "RP-LI-02", "productname": "Iguana", "unitcost": 12.00, "status": "P", "listprice": 35.50, "attr1": "Green Adult", "itemid": "EST-13" },
			{ "productid": "FL-DSH-01", "productname": "Manx", "unitcost": 12.00, "status": "P", "listprice": 158.50, "attr1": "Tailless", "itemid": "EST-14" },
			{ "productid": "FL-DSH-01", "productname": "Manx", "unitcost": 12.00, "status": "P", "listprice": 83.50, "attr1": "With tail", "itemid": "EST-15" },
			{ "productid": "FL-DLH-02", "productname": "Persian", "unitcost": 12.00, "status": "P", "listprice": 23.50, "attr1": "Adult Female", "itemid": "EST-16" },
			{ "productid": "FL-DLH-02", "productname": "Persian", "unitcost": 12.00, "status": "P", "listprice": 89.50, "attr1": "Adult Male", "itemid": "EST-17" },
			{ "productid": "AV-CB-01", "productname": "Amazon Parrot", "unitcost": 92.00, "status": "P", "listprice": 63.50, "attr1": "Adult Male", "itemid": "EST-18" }
		],
		columns: [
			[
				{ field: 'itemid', title: 'Item ID', width: 80 },
				{ field: 'productname', title: 'Product', width: 120 },
				{ field: 'listprice', title: 'List Price', width: 80, align: 'right' },
				{ field: 'unitcost', title: 'Unit Cost', width: 80, align: 'right' },
				{ field: 'attr1', title: 'Attribute', width: 200 },
				{ field: 'status', title: 'Status', width: 60, align: 'center' }
			]
		],
		idField: 'itemid',
        textField: 'productname',
		fitColumns: true,
		width: '150px',
		panelWidth: '560px',
		panelHeight: 'auto',
		panelMaxHeight: '220px',
		editable: false,
		prompt: '-请选择-'
	});

});
