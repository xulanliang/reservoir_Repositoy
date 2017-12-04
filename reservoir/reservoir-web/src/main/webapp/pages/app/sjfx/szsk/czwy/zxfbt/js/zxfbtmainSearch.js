/**
 * Created by Administrator on 2017/10/30.
 */
DSE.form.sform = "#search"; //定义form选择器
DSE.form.initSearch = function () {
    var year = "#stm_auto";
    var yearEnd = "#etm_auto";
    var season = "#season_auto";
    $(year).combobox({
        url: DSE.serverPath + '/swqxCtrl/getYear.do',
        valueField: 'id',
        textField: 'text',
        width: '150px',
        panelHeight: 'auto',
        panelMaxHeight: '220px',
        method:'GET',
        mode : 'remote' ,
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            DSE.app.changeDateVal();
            //this.doReset();
        },
        loadFilter: function(data){
            return data.data;
        },
        onLoadSuccess: function(){
            var d = $(year).combobox('getData');
            $(year).combobox('select',d[2].id);
        }
    });
    $(yearEnd).combobox({
        url: DSE.serverPath + '/swqxCtrl/getYear.do',
        valueField: 'id',
        textField: 'text',
        width: '150px',
        panelHeight: 'auto',
        panelMaxHeight: '220px',
        method:'GET',
        mode : 'remote' ,
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            DSE.app.changeDateVal();
            //this.doReset();
        },
        loadFilter: function(data){
            return data.data;
        },
        onLoadSuccess: function(){
            var d = $(yearEnd).combobox('getData');
            $(yearEnd).combobox('select',d[0].id);
        }
    });


    $(season).combobox({
        data: [
            { id: "1", text: "第一季度" },
            { id: "2", text: "第二季度" },
            { id: "3", text: "第三季度" },
            { id: "4", text: "第四季度" }
        ],
        valueField: 'id',
        textField: 'text',
        width: '150px',
        panelHeight: 'auto',
        panelMaxHeight: '220px',
        prompt: '-请选择-',
        editable: false,
        onChange: function(rec){
            DSE.app.changeDateVal();
            //this.doReset();
        },
        onLoadSuccess: function(){
            var data = new Date();
            var m = data.getMonth() + 1;
            if(m >= 1 && m <= 3){
                $(season).combobox('select','1');
            }else if(m >= 4 && m <= 6){
                $(season).combobox('select','2');
            }else if(m >= 7 && m <= 9){
                $(season).combobox('select','3');
            }else if(m >= 10 && m <= 12){
                $(season).combobox('select','4');
            }
        }
    });

    DSE.app.wrrbm_rbcd= $.getParam("wrrbm_rbcd");//断面编码
    DSE.app.projcd= $.getParam("projcd");//工程编码
    DSE.app.ppcd=$.getParam("ppcd");//一级工程编码
    //设定工程编码
    $('#projcd_auto').val(DSE.app.projcd);

    //定义查询元件的选择器
    var adcd = '#adcd_auto',
        id_proj_cd = '#wrprojb_proj_cd';

    // if(DSE.app.projcd!==undefined && DSE.app.projcd.length>0){
    //!==3 //!(DSE.app.projcd.indexOf('3')==0)
    if(true){
        if(	$(adcd).length>0){
            var st_tp='';
            if(!(DSE.app.projcd.indexOf('3')==0) || (DSE.app.projcd=='3018')){
                st_tp=$.getParam("st_tp");
            }
            var $data = $ajax({
                    url: DSE.baseUrl + '/wrrbmCtrl/getWrrbmListData.do',
                    data:{
                        'proj_cd_one': $.getParam("ppcd"),
                        'proj_cd_two': $.getParam("projcd"),
                        'st_tp': st_tp ,
                        'rb_type': $.getParam("rb_type"),
                    }
                }) || [];
            //$data.unshift({"id":'',"text":'-请选择-'});
            // console.log('$data:'+JSON.stringify($data));
            $(adcd).combotree({
                data: $data,
                /*
                 data: [{
                 id: "1",
                 text: "广东省",
                 children: [
                 { id: "2", text: "广州市" },
                 { id: "3", text: "深圳市" },
                 { id: "4", text: "珠海市" }
                 ]
                 }],
                 */
                /*
                 url:DSE.baseUrl+'/wrrbmCtrl/getWrrbmListData.do',
                 queryParams: {
                 'proj_cd_one': $.getParam("ppcd"),
                 'proj_cd_two': $.getParam("projcd"),
                 },
                 */
                valueField: 'id',
                textField: 'text',
                width: '180px',
                panelHeight: 'auto',
                panelMaxHeight: '220px',
                prompt: '-请选择-',
                editable: false,
                onSelect: function(rec){
                    //console.log($(adcd).combotree('getValue').id);
                    // console.log('rec.id : '+rec.id);
                    DSE.app.wrrbm_rbcd = rec.id;
                    DSE.app.doReset();
                },
                onLoadSuccess: function(node,data){
                    if(data!=null && data.length>0){
                        $(adcd).combotree('setValue',data[0].id);
                        DSE.app.wrrbm_rbcd = data[0].id;
                    }
                    DSE.app.doReset();
                }
            });
        }else{
            DSE.app.doReset();
        }
    } else if((DSE.app.projcd.indexOf('3')==0)){
        /*
         $(id_proj_cd).combobox({
         url: DSE.serverPath + '/shenyaCtrl/getProject.do',
         queryParams: {
         projcd: $.getParam("ppcd"),
         },
         valueField: 'PROJ_CD',
         textField: 'PROJ_NM',
         width: '150px',
         panelHeight: 'auto',
         panelMaxHeight: '220px',
         prompt: '-请选择-',
         editable: false,
         onChange: function(rec){
         //console.log(' rec:'+rec);
         DSE.app.wrprojb_proj_cd = rec;
         DSE.app.doReset();
         },
         loadFilter: function(data){
         return data.data;
         },
         onLoadSuccess: function(){
         var p = $(id_proj_cd).combobox('getData');
         if(p.length > 0) {
         $(id_proj_cd).combobox('select',p[0].PROJ_CD);
         DSE.app.wrprojb_proj_cd = p[0].PROJ_CD;
         DSE.app.doReset();
         }
         }
         });
         */
        DSE.app.doReset();
    }else{
        DSE.app.doReset();
    }
//	}else{
//		DSE.app.doReset();
//	}

}

