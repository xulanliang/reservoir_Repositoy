/**
 * @license Highcharts JS v3.0.9 (2014-01-15) Exporting module
 * 
 * (c) 2010-2014 Torstein Honsi
 * 
 * License: www.highcharts.com/license
 */

// JSLint options:
/* global Highcharts, document, window, Math, setTimeout */
var _buildHichartsExp = function($) {
(function(Highcharts) { // encapsulate

	// create shortcuts
	var Chart = Highcharts.Chart, addEvent = Highcharts.addEvent, removeEvent = Highcharts.removeEvent, createElement = Highcharts.createElement, discardElement = Highcharts.discardElement, css = Highcharts.css, merge = Highcharts.merge, each = Highcharts.each, extend = Highcharts.extend, math = Math, mathMax = math.max, doc = document, win = window, isTouchDevice = Highcharts.isTouchDevice, M = 'M', L = 'L', DIV = 'div', HIDDEN = 'hidden', NONE = 'none', PREFIX = 'highcharts-', ABSOLUTE = 'absolute', PX = 'px', UNDEFINED, symbols = Highcharts.Renderer.prototype.symbols, defaultOptions = Highcharts
			.getOptions(), buttonOffset;

	// Add language
	extend(defaultOptions.lang, {
		printChart : '打印图表',
		downloadPNG : '下载 png 图片',
		downloadJPEG : '下载 jpeg 图片',
		downloadPDF : '下载 pdf 文档',
		downloadSVG : '下载 svg 图片',
		contextButtonTitle : '请选择'
	});

	// Buttons and menus are collected in a separate config option set called
	// 'navigation'.
	// This can be extended later to add control buttons like zoom and pan right
	// click menus.
	defaultOptions.navigation = {
		menuStyle : {
			border : '1px solid #A0A0A0',
			background : '#FFFFFF',
			padding : '5px 0'
		},
		menuItemStyle : {
			padding : '0 10px',
			background : NONE,
			color : '#303030',
			fontSize : isTouchDevice ? '14px' : '11px'
		},
		menuItemHoverStyle : {
			background : '#4572A5',
			color : '#FFFFFF'
		},

		buttonOptions : {
			symbolFill : '#E0E0E0',
			symbolSize : 14,
			symbolStroke : '#666',
			symbolStrokeWidth : 3,
			symbolX : 12.5,
			symbolY : 10.5,
			align : 'right',
			buttonSpacing : 3,
			height : 22,
			// text: null,
			theme : {
				fill : 'white', // capture hover
				stroke : 'none'
			},
			verticalAlign : 'top',
			width : 24
		}
	};

	// Add the export related options
	defaultOptions.exporting = {
		// enabled: true,
		// filename: 'chart',
		type : 'image/png',
		 url: 'http://export.highcharts.com/',
		//modify by chens
		//url : __path + '/highcharts/export',
		// width: undefined,
		// scale: 2
		buttons : {
			contextButton : {
				menuClassName : PREFIX + 'contextmenu',
				// x: -10,
				symbol : 'menu',
				_titleKey : 'contextButtonTitle',
				menuItems : [ {
					textKey : 'printChart',
					onclick : function() {
						this.print();
					}
				}, {
					separator : true
				}, {
					textKey : 'downloadPNG',
					onclick : function() {
						this.exportChart();
					}
				}, {
					textKey : 'downloadJPEG',
					onclick : function() {
						this.exportChart({
							type : 'image/jpeg'
						});
					}
				}, {
					textKey : 'downloadPDF',
					onclick : function() {
						this.exportChart({
							type : 'application/pdf'
						});
					}
				}
				/*
				modify by chens
				 , {
					textKey : 'downloadSVG',
					onclick : function() {
						this.exportChart({
							type : 'image/svg+xml'
						});
					}
				}
				*/
				// Enable this block to add "View SVG" to the dropdown menu
				/*
				 * ,{
				 * 
				 * text: 'View SVG', onclick: function () { var svg =
				 * this.getSVG() .replace(/</g, '\n&lt;') .replace(/>/g,
				 * '&gt;');
				 * 
				 * doc.body.innerHTML = '<pre>' + svg + '</pre>'; } } //
				 */
				]
			}
		}
	};

	// Add the Highcharts.post utility
	Highcharts.post = function(url, data, formAttributes) {
		var name, form;

		// create the form
		form = createElement('form', merge({
			method : 'post',
			action : url
			//modify by chens
		//	,			enctype : 'multipart/form-data'
		}, formAttributes), {
			display : NONE
		}, doc.body);
		// add the data
		for (name in data) {
			createElement('input', {
				type : HIDDEN,
				name : name,
				value : data[name]
			}, null, form);
		//	console.log(name + " = " + data[name])
		//	console.log("===================")
		}
		// submit
		form.submit();
		// clean up
		discardElement(form);
	};

	extend(
			Chart.prototype,
			{

				/**
				 * Return an SVG representation of the chart
				 * 
				 * @param additionalOptions
				 *            {Object} Additional chart options for the
				 *            generated SVG representation
				 */
				getSVG : function(additionalOptions) {
					var chart = this, chartCopy, sandbox, svg, seriesOptions, sourceWidth, sourceHeight, cssWidth, cssHeight, options = merge(
							chart.options, additionalOptions); // copy the
					// options and
					// add extra
					// options

					// IE compatibility hack for generating SVG content that it
					// doesn't really understand
					if (!doc.createElementNS) {
						/* jslint unparam: true *//*
													 * allow unused parameter ns
													 * in function below
													 */
						doc.createElementNS = function(ns, tagName) {
							return doc.createElement(tagName);
						};
						/* jslint unparam: false */
					}

					// create a sandbox where a new chart will be generated
					sandbox = createElement(DIV, null, {
						position : ABSOLUTE,
						top : '-9999em',
						width : chart.chartWidth + PX,
						height : chart.chartHeight + PX
					}, doc.body);

					// get the source size
					cssWidth = chart.renderTo.style.width;
					cssHeight = chart.renderTo.style.height;
					sourceWidth = options.exporting.sourceWidth || options.chart.width || (/px$/.test(cssWidth) && parseInt(cssWidth, 10)) || 600;
					sourceHeight = options.exporting.sourceHeight || options.chart.height || (/px$/.test(cssHeight) && parseInt(cssHeight, 10))
							|| 400;

					// override some options
					extend(options.chart, {
						animation : false,
						renderTo : sandbox,
						forExport : true,
						width : sourceWidth,
						height : sourceHeight
					});
					options.exporting.enabled = false; // hide buttons in print

					// prepare for replicating the chart
					options.series = [];
					each(chart.series, function(serie) {
						seriesOptions = merge(serie.options, {
							animation : false, // turn off animation
							showCheckbox : false,
							visible : serie.visible
						});

						if (!seriesOptions.isInternal) { // used for the
							// navigator series
							// that has its own
							// option set
							options.series.push(seriesOptions);
						}
					});

					// generate the chart copy
					chartCopy = new Highcharts.Chart(options, chart.callback);

					// reflect axis extremes in the export
					each(
							[ 'xAxis', 'yAxis' ],
							function(axisType) {
								each(
										chart[axisType],
										function(axis, i) {
											var axisCopy = chartCopy[axisType][i], extremes = axis.getExtremes(), userMin = extremes.userMin, userMax = extremes.userMax;

											if (axisCopy && (userMin !== UNDEFINED || userMax !== UNDEFINED)) {
												axisCopy.setExtremes(userMin, userMax, true, false);
											}
										});
							});

					// get the SVG from the container's innerHTML
					svg = chartCopy.container.innerHTML;

					// free up memory
					options = null;
					chartCopy.destroy();
					discardElement(sandbox);

					// sanitize
					svg = svg.replace(/zIndex="[^"]+"/g, '').replace(/isShadow="[^"]+"/g, '').replace(/symbolName="[^"]+"/g, '').replace(
							/jQuery[0-9]+="[^"]+"/g, '').replace(/url\([^#]+#/g, 'url(#').replace(/<svg /,
							'<svg xmlns:xlink="http://www.w3.org/1999/xlink" ').replace(/ href=/g, ' xlink:href=').replace(/\n/, ' ').replace(
							/<\/svg>.*?$/, '</svg>') // any HTML added to the
					// container after the
					// SVG (#894)
					/*
					 * This fails in IE < 8 .replace(/([0-9]+)\.([0-9]+)/g,
					 * function(s1, s2, s3) { // round off to save weight return
					 * s2 +'.'+ s3[0]; })
					 */

					// Replace HTML entities, issue #347
					.replace(/&nbsp;/g, '\u00A0') // no-break space
					.replace(/&shy;/g, '\u00AD') // soft hyphen

					// IE specific
					.replace(/<IMG /g, '<image ').replace(/height=([^" ]+)/g, 'height="$1"').replace(/width=([^" ]+)/g, 'width="$1"').replace(
							/hc-svg-href="([^"]+)">/g, 'xlink:href="$1"/>').replace(/id=([^" >]+)/g, 'id="$1"').replace(/class=([^" >]+)/g,
							'class="$1"').replace(/ transform /g, ' ').replace(/:(path|rect)/g, '$1').replace(/style="([^"]+)"/g, function(s) {
						return s.toLowerCase();
					});

					// IE9 beta bugs with innerHTML. Test again with final IE9.
					svg = svg.replace(/(url\(#highcharts-[0-9]+)&quot;/g, '$1').replace(/&quot;/g, "'");

					return svg;
				},

				/**
				 * Submit the SVG representation of the chart to the server
				 * 
				 * @param {Object}
				 *            options Exporting options. Possible members are
				 *            url, type, width and formAttributes.
				 * @param {Object}
				 *            chartOptions Additional chart options for the SVG
				 *            representation of the chart
				 */
				exportChart : function(options, chartOptions) {
					options = options || {};

					var chart = this, chartExportingOptions = chart.options.exporting, svg = chart.getSVG(merge({
						chart : {
							borderRadius : 0
						}
					}, chartExportingOptions.chartOptions, chartOptions, {
						exporting : {
							sourceWidth : options.sourceWidth || chartExportingOptions.sourceWidth,
							sourceHeight : options.sourceHeight || chartExportingOptions.sourceHeight
						}
					}));

					// merge the options
					options = merge(chart.options.exporting, options);

					// do the post
					Highcharts.post(options.url, {
						filename : options.filename || 'chart',
						type : options.type,
						width : options.width || 0, // IE8 fails to post
						// undefined correctly, so
						// use 0
						scale : options.scale || 2,
						svg : svg
					}, options.formAttributes);

				},

				/**
				 * Print the chart
				 */
				print : function() {

					var chart = this, container = chart.container, origDisplay = [], origParent = container.parentNode, body = doc.body, childNodes = body.childNodes;

					if (chart.isPrinting) { // block the button while in
						// printing mode
						return;
					}

					chart.isPrinting = true;

					// hide all body content
					each(childNodes, function(node, i) {
						if (node.nodeType === 1) {
							origDisplay[i] = node.style.display;
							node.style.display = NONE;
						}
					});

					// pull out the chart
					body.appendChild(container);

					// print
					win.focus(); // #1510
					win.print();

					// allow the browser to prepare before reverting
					setTimeout(function() {

						// put the chart back in
						origParent.appendChild(container);

						// restore all body content
						each(childNodes, function(node, i) {
							if (node.nodeType === 1) {
								node.style.display = origDisplay[i];
							}
						});

						chart.isPrinting = false;

					}, 1000);

				},

				/**
				 * Display a popup menu for choosing the export type
				 * 
				 * @param {String}
				 *            className An identifier for the menu
				 * @param {Array}
				 *            items A collection with text and onclicks for the
				 *            items
				 * @param {Number}
				 *            x The x position of the opener button
				 * @param {Number}
				 *            y The y position of the opener button
				 * @param {Number}
				 *            width The width of the opener button
				 * @param {Number}
				 *            height The height of the opener button
				 */
				contextMenu : function(className, items, x, y, width, height, button) {
					var chart = this, navOptions = chart.options.navigation, menuItemStyle = navOptions.menuItemStyle, chartWidth = chart.chartWidth, chartHeight = chart.chartHeight, cacheName = 'cache-'
							+ className, menu = chart[cacheName], menuPadding = mathMax(width, height), // for
					// mouse
					// leave
					// detection
					boxShadow = '3px 3px 10px #888', innerMenu, hide, hideTimer, menuStyle, docMouseUpHandler = function(e) {
						if (!chart.pointer.inClass(e.target, className)) {
							hide();
						}
					};

					// create the menu only the first time
					if (!menu) {

						// create a HTML element above the SVG
						chart[cacheName] = menu = createElement(DIV, {
							className : className
						}, {
							position : ABSOLUTE,
							zIndex : 1000,
							padding : menuPadding + PX
						}, chart.container);

						innerMenu = createElement(DIV, null, extend({
							MozBoxShadow : boxShadow,
							WebkitBoxShadow : boxShadow,
							boxShadow : boxShadow
						}, navOptions.menuStyle), menu);

						// hide on mouse out
						hide = function() {
							css(menu, {
								display : NONE
							});
							if (button) {
								button.setState(0);
							}
							chart.openMenu = false;
						};

						// Hide the menu some time after mouse leave (#1357)
						addEvent(menu, 'mouseleave', function() {
							hideTimer = setTimeout(hide, 500);
						});
						addEvent(menu, 'mouseenter', function() {
							clearTimeout(hideTimer);
						});

						// Hide it on clicking or touching outside the menu
						// (#2258, #2335, #2407)
						addEvent(document, 'mouseup', docMouseUpHandler);
						addEvent(chart, 'destroy', function() {
							removeEvent(document, 'mouseup', docMouseUpHandler);
						});

						// create the items
						each(items, function(item) {
							if (item) {
								var element = item.separator ? createElement('hr', null, null, innerMenu) : createElement(DIV, {
									onmouseover : function() {
										css(this, navOptions.menuItemHoverStyle);
									},
									onmouseout : function() {
										css(this, menuItemStyle);
									},
									onclick : function() {
										hide();
										item.onclick.apply(chart, arguments);
									},
									innerHTML : item.text || chart.options.lang[item.textKey]
								}, extend({
									cursor : 'pointer'
								}, menuItemStyle), innerMenu);

								// Keep references to menu divs to be able to
								// destroy them
								chart.exportDivElements.push(element);
							}
						});

						// Keep references to menu and innerMenu div to be able
						// to destroy them
						chart.exportDivElements.push(innerMenu, menu);

						chart.exportMenuWidth = menu.offsetWidth;
						chart.exportMenuHeight = menu.offsetHeight;
					}

					menuStyle = {
						display : 'block'
					};

					// if outside right, right align it
					if (x + chart.exportMenuWidth > chartWidth) {
						menuStyle.right = (chartWidth - x - width - menuPadding) + PX;
					} else {
						menuStyle.left = (x - menuPadding) + PX;
					}
					// if outside bottom, bottom align it
					if (y + height + chart.exportMenuHeight > chartHeight && button.alignOptions.verticalAlign !== 'top') {
						menuStyle.bottom = (chartHeight - y - menuPadding) + PX;
					} else {
						menuStyle.top = (y + height - menuPadding) + PX;
					}

					css(menu, menuStyle);
					chart.openMenu = true;
				},

				/**
				 * Add the export button to the chart
				 */
				addButton : function(options) {
					var chart = this, renderer = chart.renderer, btnOptions = merge(chart.options.navigation.buttonOptions, options), onclick = btnOptions.onclick, menuItems = btnOptions.menuItems, symbol, button, symbolAttr = {
						stroke : btnOptions.symbolStroke,
						fill : btnOptions.symbolFill
					}, symbolSize = btnOptions.symbolSize || 12;
					if (!chart.btnCount) {
						chart.btnCount = 0;
					}

					// Keeps references to the button elements
					if (!chart.exportDivElements) {
						chart.exportDivElements = [];
						chart.exportSVGElements = [];
					}

					if (btnOptions.enabled === false) {
						return;
					}

					var attr = btnOptions.theme, states = attr.states, hover = states && states.hover, select = states && states.select, callback;

					delete attr.states;

					if (onclick) {
						callback = function() {
							onclick.apply(chart, arguments);
						};

					} else if (menuItems) {
						callback = function() {
							chart.contextMenu(button.menuClassName, menuItems, button.translateX, button.translateY, button.width, button.height,
									button);
							button.setState(2);
						};
					}

					if (btnOptions.text && btnOptions.symbol) {
						attr.paddingLeft = Highcharts.pick(attr.paddingLeft, 25);

					} else if (!btnOptions.text) {
						extend(attr, {
							width : btnOptions.width,
							height : btnOptions.height,
							padding : 0
						});
					}

					button = renderer.button(btnOptions.text, 0, 0, callback, attr, hover, select).attr({
						title : chart.options.lang[btnOptions._titleKey],
						'stroke-linecap' : 'round'
					});
					button.menuClassName = options.menuClassName || PREFIX + 'menu-' + chart.btnCount++;

					if (btnOptions.symbol) {
						symbol = renderer.symbol(btnOptions.symbol, btnOptions.symbolX - (symbolSize / 2), btnOptions.symbolY - (symbolSize / 2),
								symbolSize, symbolSize).attr(extend(symbolAttr, {
							'stroke-width' : btnOptions.symbolStrokeWidth || 1,
							zIndex : 1
						})).add(button);
					}

					button.add().align(extend(btnOptions, {
						width : button.width,
						x : Highcharts.pick(btnOptions.x, buttonOffset)
					// #1654
					}), true, 'spacingBox');

					buttonOffset += (button.width + btnOptions.buttonSpacing) * (btnOptions.align === 'right' ? -1 : 1);

					chart.exportSVGElements.push(button, symbol);

				},

				/**
				 * Destroy the buttons.
				 */
				destroyExport : function(e) {
					var chart = e.target, i, elem;

					// Destroy the extra buttons added
					for (i = 0; i < chart.exportSVGElements.length; i++) {
						elem = chart.exportSVGElements[i];

						// Destroy and null the svg/vml elements
						if (elem) { // #1822
							elem.onclick = elem.ontouchstart = null;
							chart.exportSVGElements[i] = elem.destroy();
						}
					}

					// Destroy the divs for the menu
					for (i = 0; i < chart.exportDivElements.length; i++) {
						elem = chart.exportDivElements[i];

						// Remove the event handler
						removeEvent(elem, 'mouseleave');

						// Remove inline events
						chart.exportDivElements[i] = elem.onmouseout = elem.onmouseover = elem.ontouchstart = elem.onclick = null;

						// Destroy the div by moving to garbage bin
						discardElement(elem);
					}
				}
			});

	symbols.menu = function(x, y, width, height) {
		var arr = [ M, x, y + 2.5, L, x + width, y + 2.5, M, x, y + height / 2 + 0.5, L, x + width, y + height / 2 + 0.5, M, x, y + height - 1.5, L,
				x + width, y + height - 1.5 ];
		return arr;
	};

	// Add the buttons on chart load
	Chart.prototype.callbacks.push(function(chart) {
		var n, exportingOptions = chart.options.exporting, buttons = exportingOptions.buttons;

		buttonOffset = 0;

		if (exportingOptions.enabled !== false) {

			for (n in buttons) {
				chart.addButton(buttons[n]);
			}

			// Destroy the export elements at chart destroy
			addEvent(chart, 'destroy', chart.destroyExport);
		}

	});

}(Highcharts));
	function buildDoubleYChart(t, e, o, i, a, r) {
		$("#" + t).highcharts({
			credits: {
				enabled: !1
			},
			chart: {
				zoomType: "xy"
			},
			title: {
				text: "<br/>" + e,
				useHTML: !0
			},
			subtitle: {
				text: "<br/>",
				useHTML: !0
			},
			plotOptions: {
				series: {
					lineWidth: 1,
					marker: {
						enabled: !1
					}
				}
			},
			xAxis: [{
				type: "datetime",
				gridLineWidth: 1,
				dateTimeLabelFormats: {
					minute: "%H:%M",
					hour: "%H:%M",
					day: "%b月%e号",
					week: "%b月%e号",
					month: "%y年%b月",
					year: "%Y年"
				}
			}],
			yAxis: [{
				gridLineWidth: 0,
				labels: {
					format: "{value}" + a,
					style: {
						color: "#b94a74"
					}
				},
				title: {
					text: o,
					style: {
						color: "#b94a74"
					}
				}
			},
				{
					gridLineWidth: 1,
					title: {
						text: i,
						style: {
							color: "#4da2db"
						}
					},
					labels: {
						format: "{value}" + r,
						style: {
							color: "#4da2db"
						}
					},
					opposite: !0
				}],
			tooltip: {
				xDateFormat: "%Y-%m-%d %H:%M",
				shared: !0,
				useHTML: !0,
				crosshairs: [!0, !0],
				headerFormat: "时间：{point.key}<br/>"
			},
			legend: {
				layout: "horizontal",
				align: "left",
				x: 10,
				verticalAlign: "top",
				y: 35,
				floating: !0,
				backgroundColor: "#FFFFFF"
			},
			series: [{
				name: i,
				color: "#4da2db",
				type: "spline",
				yAxis: 1,
				tooltip: {
					valueSuffix: r
				}
			},
				{
					name: o,
					color: "#b94a74",
					type: "spline",
					tooltip: {
						valueSuffix: a
					}
				}]
		})
	}
	function buildDoubleXChart(t, e, o, i, a) {
		$("#" + t).highcharts({
			credits: {
				enabled: !1
			},
			chart: {
				zoomType: "xy"
			},
			title: {
				text: e
			},
			subtitle: {
				text: "<br/><br/><br/>",
				useHTML: !0
			},
			plotOptions: {
				series: {
					lineWidth: 1,
					marker: {
						enabled: !0
					}
				}
			},
			xAxis: [{
				type: "linear",
				gridLineWidth: 1,
				title: {
					enabled: !0,
					text: i,
					style: {
						fontWeight: "normal",
						color: "#4da2db"
					}
				}
			},
				{
					type: "linear",
					gridLineWidth: 0,
					title: {
						enabled: !0,
						text: a,
						style: {
							fontWeight: "normal",
							color: "#b94a74"
						}
					}
				}],
			yAxis: [{
				gridLineWidth: 1,
				labels: {
					format: "{value}",
					style: {
						color: "#6D869F"
					}
				},
				title: {
					text: o,
					style: {
						color: "#6D869F"
					}
				}
			}],
			tooltip: {
				useHTML: !0,
				formatter: function() {
					var t = '<font style="color: ' + this.series.color + '">' + this.series.name + "：" + this.point.x + "<br/>";
					return t += "#ff0000" == this.series.color ? "汛限水位(m)：" + this.point.y: "#009900" == this.series.color ? "当前水位(m)：" + this.point.y: o + this.point.y
				},
				crosshairs: [!0, !0]
			},
			legend: {
				layout: "horizontal",
				align: "left",
				x: 10,
				verticalAlign: "top",
				y: 30,
				floating: !0,
				backgroundColor: "#FFFFFF",
				labelFormatter: function() {
					return "#009900" == this.color ? "当前水位": "#ff0000" == this.color ? "汛限水位": this.name
				}
			},
			series: [{
				name: i,
				color: "#4da2db",
				type: "spline",
				marker: {
					enabled: !1
				}
			},
				{
					name: a,
					color: "#b94a74",
					xAxis: 1,
					type: "spline",
					marker: {
						enabled: !1
					}
				}]
		})
	}
	function buildSimpleChart(t, e, o) {
		$("#" + t).highcharts({
			credits: {
				enabled: !1
			},
			legend: {
				layout: "horizontal",
				align: "left",
				x: 10,
				verticalAlign: "top",
				y: 40,
				floating: !0,
				backgroundColor: "#FFFFFF"
			},
			title: {
				text: "<br/>" + e,
				useHTML: !0
			},
			subtitle: {
				text: "<br/><br/>",
				useHTML: !0
			},
			xAxis: [{
				type: "datetime",
				gridLineWidth: 1,
				dateTimeLabelFormats: {
					minute: "%H:%M",
					hour: "%H:%M",
					day: "%b月%e号",
					week: "%b月%e号",
					month: "%y年%b月",
					year: "%Y年"
				}
			}],
			yAxis: [{
				labels: {
					format: "{value}" + o,
					style: {
						color: "#b94a74"
					}
				},
				title: {
					style: {
						color: "#b94a74"
					}
				}
			}],
			tooltip: {
				xDateFormat: "%Y-%m-%d %H:%M",
				shared: !0,
				useHTML: !0,
				crosshairs: [!0, !0],
				headerFormat: "时间：{point.key}<br/>"
			},
			plotOptions: {
				column: {
					pointPadding: .2,
					borderWidth: 0
				}
			}
		})
	}
	function buildSimpleDoubleChart(t, e, o, i) {
		$("#" + t).highcharts({
			credits: {
				enabled: !1
			},
			legend: {
				layout: "horizontal",
				align: "left",
				x: 10,
				verticalAlign: "top",
				y: 30,
				floating: !0,
				backgroundColor: "#FFFFFF"
			},
			title: {
				text: "<br/>" + e,
				useHTML: !0
			},
			subtitle: {
				text: "<br/><br/>",
				useHTML: !0
			},
			xAxis: [{
				type: "datetime",
				gridLineWidth: 1,
				dateTimeLabelFormats: {
					minute: "%H:%M",
					hour: "%H:%M",
					day: "%b月%e号",
					week: "%b月%e号",
					month: "%y年%b月",
					year: "%Y年"
				}
			}],
			yAxis: [{
				labels: {
					format: "{value}" + o,
					style: {
						color: "#b94a74"
					}
				},
				title: {
					style: {
						color: "#b94a74"
					}
				}
			},
				{
					gridLineWidth: 1,
					labels: {
						format: "{value}" + i,
						style: {
							color: "#4da2db"
						}
					},
					opposite: !0,
					title: {
						style: {
							color: "#4da2db"
						}
					}
				}],
			tooltip: {
				xDateFormat: "%Y-%m-%d %H:%M",
				shared: !0,
				useHTML: !0,
				crosshairs: [!0, !0],
				headerFormat: "时间：{point.key}<br/>"
			},
			plotOptions: {
				column: {
					pointPadding: .2,
					borderWidth: 0
				}
			}
		})
	}
	Highcharts.setOptions({
		lang: {
			contextButtonTitle: "选项",
			printChart: "打印图表",
			downloadJPEG: "下载 jpeg 图片",
			downloadPDF: "下载 pdf 文档",
			downloadPNG: "下载 png 图片",
			downloadSVG: "下载 svg 图片",
			loading: "加载...",
			resetZoom: "还原",
			resetZoomTitle: "还原原始大小",
			shortMonths: ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"]
		}
	});
}

//jiangfl 扩展成支持seajs,王晓东说和地图有冲突，这里参考王晓东的代码
if (typeof dseDefine === 'function') {
	dseDefine(function(require, exports, module) {
		return _buildHichartsExp(require('jquery'));
	});
} else {
	// 依赖jquery
	_buildHichartsExp(jQuery);
}