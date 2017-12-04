//=========================================================================================
;(function($){
	
	var CONFIG={
			NAME:['雨量','水位','流量'],
			UNIT:['mm','m','m³/s'],
			KEYS:['DRP','Z','Q']
	};
	
  //雨量柱状图配置
	var dse_RainfallChartConfig={
        	color: ['#3398DB'],
        	grid:{
        		left:'40',
        		right:'20'
        	},
            tooltip : {
		        trigger: 'item',
		        formatter : function (params) {
		            return new Date(params.value[0]).format('yyyy-MM-dd hh:mm') + '<br/>'
		                   +params.seriesName+": "+ params.value[1]+"(mm)"
		        }
		    },
		    toolbox: {
		    	right:'20',
		        feature: {
		            dataZoom: {
		                yAxisIndex: 'none'
		            },
		            restore: {},
		            saveAsImage: {},
		            myShowLabel: {
		                show: true,
		                title: '显示值',
		                icon: 'path://M432.45,595.444c0,2.177-4.661,6.82-11.305,6.82c-6.475,0-11.306-4.567-11.306-6.82s4.852-6.812,11.306-6.812C427.841,588.632,432.452,593.191,432.45,595.444L432.45,595.444z M421.155,589.876c-3.009,0-5.448,2.495-5.448,5.572s2.439,5.572,5.448,5.572c3.01,0,5.449-2.495,5.449-5.572C426.604,592.371,424.165,589.876,421.155,589.876L421.155,589.876z M421.146,591.891c-1.916,0-3.47,1.589-3.47,3.549c0,1.959,1.554,3.548,3.47,3.548s3.469-1.589,3.469-3.548C424.614,593.479,423.062,591.891,421.146,591.891L421.146,591.891zM421.146,591.891',
		                onclick: function (chart){
		                	chart.dse_showLable = !chart.dse_showLable;
							chart.option.series[0].label= chart.dse_showLable ?
												{
								                	normal:{
								                		show:true,
								                		position:'top',
								                		formatter:function(p){
								                			return p.value[1];
								                		}
								                	},
								                	emphasis:{
								                		show:true,
								                		position:'top',
								                		formatter:function(p){
								                			return p.value[1];
								                		}
								                	}
								               }:{};
						chart.setOption(chart.getOption());
						
						console.log(arguments);
		              //console.log(chart);
		                }
		            }
		        }
		    },
            legend: {
            	show:false
            },
		    xAxis :{
	            type : 'time',
	            splitNumber:10,
	            splitLine:false
		    },
            yAxis: {
            	name:'雨量('+CONFIG.UNIT[0]+')',
            	boundaryGap:['0', '20%'], //在最大、最小值的基础上延伸范围
            	axisLine:{
            		lineStyle:{
            			color:"#B03A5B"
            		}
            	},
            	axisLabel:{
            		textStyle:{
            			color:"#000"
            		}
            	}
            },
            series: [{
                name: CONFIG.NAME[0],
                type: 'bar',
                barMaxWidth:'10px',
                barGap:'10%'
            }]
        },
        
//水位或者流量折线图（单线）
        dse_FlowChartConfig={
        	color: ['#3398DB'],
        	grid:{
        		left:'40',
        		right:'20'
        	},
            tooltip : {
		        trigger: 'axis',
		        formatter : function (params) {
		        	var unit = (function(n){
						return  n==CONFIG.NAME[1]?CONFIG.UNIT[1]:CONFIG.UNIT[2];		        		
		        	})(params[0].seriesName);
        	      return new Date(params[0].value[0]).format('yyyy-MM-dd hh:mm') + '<br/>'
                   +params[0].seriesName+": "+ params[0].value[1]+"("+unit+")";
		                   
		        }
		    },
		    toolbox: {
		    	right:'20',
		        feature: {
		            dataZoom: {
		                yAxisIndex: 'none'
		            },
		            restore: {},
		            saveAsImage: {}
		        }
		    },
            legend: {
            	show:false
            },
		    xAxis :{
	            type : 'time',
	            splitNumber:10,
	            splitLine:false
		    },
            yAxis: {
            	name:'单位(mm)',
            	boundaryGap:['0', '20%'], //在最大、最小值的基础上延伸范围
            	axisLine:{
            		lineStyle:{
            			color:"#B03A5B"
            		}
            	},
            	axisLabel:{
            		textStyle:{
            			color:"#000"
            		}
            	}
            },
            series: [{
                name: CONFIG.NAME[0],
                type: 'line',
                showSymbol:false
            }]
        },
//水位流量双轴
 	dse_ZQChartConfig={
        	color: ['#3398DB','#2F4554'],
        	grid:{
        		left:'40',
        		right:'60'
        	},
            tooltip : {
		        trigger: 'axis',
		        formatter : function (params,a,c) {
		        	//console.log(arguments);
		        	
        	      return new Date(params[0].value[0]).format('yyyy-MM-dd hh:mm') + '<br/>'
		           +'<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:'+params[0].color+'"></span>'
                   +params[0].seriesName+": "+ params[0].value[1]+"("+CONFIG.UNIT[1]+")"+ '<br/>'
		           +'<span style="display:inline-block;margin-right:5px;border-radius:10px;width:9px;height:9px;background-color:'+params[1].color+'"></span>'
                   +params[1].seriesName+": "+ params[1].value[1]+"("+CONFIG.UNIT[2]+")";
		        }
		    },
		    toolbox: {
		    	right:'20',
		        feature: {
		            dataZoom: {
		                yAxisIndex: 'none'
		            },
		            restore: {},
		            saveAsImage: {}
		        }
		    },
            legend: {
            	show:true,
            	left:20,
            	data: [CONFIG.NAME[1],CONFIG.NAME[2]]
            },
		    xAxis :{
	            type : 'time',
	            splitNumber:10,
	            splitLine:false
		    },
            yAxis: [
		            {
		            	name:'单位(m)',
		            	position:'left',
		            	boundaryGap:['20%', '20%'], //在最大、最小值的基础上延伸范围
		            	axisLine:{
		            		lineStyle:{
		            			color:"#B03A5B"
		            		}
		            	},
		            	axisLabel:{
		            		textStyle:{
		            			color:"#000"
		            		}
		            	}
		            },
		            {
		            	name:'单位(m³/s)',
		            	position:'right',
		            	boundaryGap:['0', '20%'], //在最大、最小值的基础上延伸范围
		            	axisLine:{
		            		lineStyle:{
		            			color:"#B03A5B"
		            		}
		            	},
		            	axisLabel:{
		            		textStyle:{
		            			color:"#000"
		            		}
		            	}
		            }
            ],
            series: [{
	                name: CONFIG.NAME[1],
	                yAxisIndex: 0,
	                type: 'line',
	                showSymbol:false
	            },
	            {
	                name: CONFIG.NAME[2],
	                yAxisIndex: 1,
	                type: 'line',
	                showSymbol:false
	            }
            ]
       },
 //水位流量降雨量 三轴      
 dse_PZQChartConfig={
 	color: ['#3398DB','#2F4554',"#1613FD"],
    grid: [
        { height: '30%',top:'10%',left:'50',right:'60'},
        { height: '40%',top:'44%',left:'50',right:'60'}
    ],
    legend: {
    	show:true,
    	left:20,
    	data: [CONFIG.NAME[0],CONFIG.NAME[1],CONFIG.NAME[2]]
    },
    tooltip: {
       
    },
	toolbox: {
		right:'20',
	    feature: {
	        dataZoom: {
	            yAxisIndex: 'none'
	        },
	        restore: {},
	        saveAsImage: {}
	    }
	},
    xAxis: [
		{
			gridIndex: 0,
			type : 'time',
			splitNumber:10,
			scale: true,
            boundaryGap : false,
            splitLine: {show: false},
            axisLabel: {show: false}
		},
		{
			gridIndex: 1,
			type : 'time',
			scale: true,
			splitNumber:10,
			splitLine:false
		}
    ],
    yAxis: [
		    		{
		            	name:'降雨(mm)',
		            	nameLocation:'middle',
		            	nameGap:'30',
		            	gridIndex: 0,
		            	boundaryGap:['0', '20%'], 
		            	inverse: true,
		            	axisLine:{
		            		lineStyle:{
		            			color:"#B03A5B"
		            		}
		            	},
		            	axisLabel:{
		            		textStyle:{
		            			color:"#000"
		            		}
		            	}
		           },
		            {
		            	name:'水位(m)',
		            	nameLocation:'middle',
		            	nameGap:'30',
		            	gridIndex: 1,
		            	position:'left',
		            	boundaryGap:['20%', '20%'],
		            	axisLine:{
		            		lineStyle:{
		            			color:"#B03A5B"
		            		}
		            	},
		            	axisLabel:{
		            		textStyle:{
		            			color:"#000"
		            		}
		            	}
		            },
		            {
		            	name:'流量(m³/s)',
		            	nameLocation:'middle',
		            	nameGap:'30',
		            	gridIndex: 1,
		            	position:'right',
		            	boundaryGap:['0', '20%'],
		            	axisLine:{
		            		lineStyle:{
		            			color:"#B03A5B"
		            		}
		            	},
		            	axisLabel:{
		            		textStyle:{
		            			color:"#000"
		            		}
		            	}
		            }
    ],
    series: [
        {//雨量
            name: CONFIG.NAME[0],
            type: 'bar',
            barMaxWidth:'10px',
	        barGap:'10%',
            xAxisIndex: 0,
            yAxisIndex: 0
        },
        {//水位
            name: CONFIG.NAME[1],
            xAxisIndex: 1,
            yAxisIndex: 1,
            type: 'line',
            showSymbol:false
        },
        {//流量
            name: CONFIG.NAME[2],
            xAxisIndex: 1,
            yAxisIndex: 2,
            type: 'line',
            showSymbol:false
        }
    ]
};
       
	
	
	function DseCharts(ele,opt,defaults){
		this.elem = ele[0];
        
        this.data = opt.data;
        this.desc = opt.desc
        
        delete opt.data;
        delete opt.desc;
        this.options = $.extend({},defaults,opt);
	}
	/**
	 * 雨量站柱状图
	 */
    var Dse_RainfallChart= function(ele,opt,defaults){
		DseCharts.apply(this,arguments);
		this.DATA_KEY = CONFIG.KEYS[0];
    };
    
      Dse_RainfallChart.prototype={
        init:function(){
        	var $this = this,
			dseChart = echarts.init($this.elem);
			
			$this.buildSeries();
			dseChart.setOption($this.options);
			return dseChart;
        },
        buildSeries:function(){
        	this.options.series[0].data = this.formatData()
        },
		formatData:function(){
			if(!this.data) return [];
			var DATA_KEY =this.DATA_KEY;
			//数据按照时间 默认的倒序	
			if(!this.dse_desc){
				var d=[],dt=this.data,i=dt.length-1,t;
				for (;i>-1;i--) {
					t = dt[i];
					d.push([new Date(t.TM.replace(/-/g,"/")),t[DATA_KEY]]);
				}
				return d;
			}else{//数据正序排列
				return this.data.map(function(t){
							return [new Date(t.TM.replace(/-/g,"/")),t[DATA_KEY]];
						});
				
			}
					
		}
    };
  
  var DSE_FlowChart= function(ele,opt,defaults){
		Dse_RainfallChart.apply(this,arguments);
		this.DATA_KEY = opt.dcType?opt.dcType:CONFIG.KEYS[1];

		if(this.DATA_KEY==CONFIG.KEYS[1]){
			 defaults.series[0].name= CONFIG.NAME[1];
			 defaults.yAxis.name = CONFIG.NAME[1]+'('+CONFIG.UNIT[1]+')'
		}else{
			 defaults.series[0].name= CONFIG.NAME[2];
			 defaults.yAxis.name = CONFIG.NAME[2]+'('+CONFIG.UNIT[2]+')'
		}
    };
    
  var DSE_ZQChart = function (ele,opt,defaults){
		DseCharts.apply(this,arguments);
    };
    DSE_ZQChart.prototype={
		init:function(){
        	var $this = this,
			dseChart = echarts.init($this.elem);
			
			$this.buildSeries();
			dseChart.setOption($this.options);
			return dseChart;
        },
        buildSeries:function(){
        	var datas=this.formatData();
        	this.options.series[0].data = datas[0];
        	this.options.series[1].data = datas[1];
        },
		formatData:function(){
			if(!this.data) return [[],[]];
			//数据按照时间 默认的倒序	
			if(!this.dse_desc){
				var z=[],q=[],dt=this.data,i=dt.length-1,t,_tm;
				for (;i>-1;i--) {
					t = dt[i];
					_tm = new Date(t.TM.replace(/-/g,"/"));
					z.push([_tm,t[CONFIG.KEYS[1]]]);
					q.push([_tm,t[CONFIG.KEYS[2]]]);
				}
				return [z,q];
			}else{//数据正序排列
				var z=[],q=[],dt=this.data,i=0,t,_tm;
				for (;i<dt.length;i++) {
					t = dt[i];
					_tm = new Date(t.TM.replace(/-/g,"/"));
					z.push([_tm,t[CONFIG.KEYS[1]]]);
					q.push([_tm,t[CONFIG.KEYS[2]]]);
				}
				return [z,q];
			}
    }
   };
  var DSE_PZQChart = function (ele,opt,defaults){
		DseCharts.apply(this,arguments);
    };
    DSE_PZQChart.prototype={
		init:function(){
        	var $this = this,
			dseChart = echarts.init($this.elem);
			
			$this.buildSeries();
			dseChart.setOption($this.options);
			return dseChart;
        },
        buildSeries:function(){
        	var datas=this.formatData();
        	this.options.series[0].data = datas[0];
        	this.options.series[1].data = datas[1];
        	this.options.series[2].data = datas[2];
        },
		formatData:function(){
			if(!this.data) return [[],[]];
			//数据按照时间 默认的倒序	
			if(!this.dse_desc){
				var p=[],z=[],q=[],dt=this.data,i=dt.length-1,t,_tm;
				for (;i>-1;i--) {
					t = dt[i];
					_tm = new Date(t.TM.replace(/-/g,"/"));
					p.push([_tm,t[CONFIG.KEYS[0]]]);
					z.push([_tm,t[CONFIG.KEYS[1]]]);
					q.push([_tm,t[CONFIG.KEYS[2]]]);
				}
				return [p,z,q];
			}else{//数据正序排列
				var p=[],z=[],q=[],dt=this.data,i=0,t,_tm;
				for (;i<dt.length;i++) {
					t = dt[i];
					_tm = new Date(t.TM.replace(/-/g,"/"));
					p.push([_tm,t[CONFIG.KEYS[0]]]);
					z.push([_tm,t[CONFIG.KEYS[1]]]);
					q.push([_tm,t[CONFIG.KEYS[2]]]);
				}
				return [p,z,q];
			}
    }
   };
    
    
  var methods = {
     rainfall : function(options) {  
        var dsechart = new Dse_RainfallChart(this,options,dse_RainfallChartConfig);
           return  dsechart.init();
     },  
     flow : function(options) {  
		DSE_FlowChart.prototype = Dse_RainfallChart.prototype;
        var dsechart = new DSE_FlowChart(this,options,dse_FlowChartConfig);
        return  dsechart.init();
     },
     zzqq : function(options){
     	var dsechart = new DSE_ZQChart(this,options,dse_ZQChartConfig);
         return  dsechart.init();
     },
     ppzzqq : function(options){
     	var dsechart = new DSE_PZQChart(this,options,dse_PZQChartConfig);
         return  dsechart.init();
     }     
  };  
  
  $.fn.dseChart = function( method ) {  
      
    if ( methods[method] ) {  
      return methods[method].apply( this, Array.prototype.slice.call( arguments, 1 ));  
    } else if ( typeof method === 'object' || ! method ) {  
      return methods.init.apply( this, arguments );  
    } else {  
      $.error( 'Method ' +  method + ' 不存在!' );  
    }      
    
  };  
  
})( jQuery );  



