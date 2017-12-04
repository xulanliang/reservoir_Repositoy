/**
 *
 */
define(["dojo/_base/declare", "dojo/on", "dojo/dom",
    "dojo/_base/array"
], function (declare, on, dom, arrayUtils) {
    //
    //va
    // var _domNode=null;
    //
    var _map = null;
    var _self = null;
    var _baseLayers = null;
    return declare(null, {
        //
        constructor: function (options) {
            //
            _map = options.map;
            _baseLayers = options.layers || [];
            _self = this;
        },
        //
        init: function () {
            //
            $("#" + _map.id).append('<div id="m-map-type" class="s-width1">');
            var $mapType = $("#m-map-type"), nums = (function () {
                var t = 0;
                //
                _baseLayers.forEach(function (cfg) {
                    //
                    t++;
                });
                return t;
            })(), 
            //
            minLeft = (1 / nums) * (1 / 16), //间隙
            withP = (1 / nums) - 2 * minLeft, //图片宽度占比
            initItemWidth = $mapType.width() * (7 / 8), //初始化 图片 宽度
            initItemLeft = $mapType.width() * (1 / 16); //初始化 图片 left
            $mapType.html((function (layersCfg) {
                var items = "";
                //
                arrayUtils.forEach(layersCfg, function (cfg) {
                    //
                    //
                    var item = cfg, template = '<div class="m-layer-switch {active}"  style="background-image: url({url});width:{w};left:{l}" data-mtype="{tp}"><span>{nm}</span></div>';
                    items += template.replace(/{url}/g, window.dseGisPath + item.img_src).replace(/{tp}/g, item.id).replace(/{nm}/g, item.name)
                        .replace(/{w}/g, initItemWidth + "px").replace(/{l}/g, initItemLeft + "px")
                        .replace(/{active}/g, (item.initShow ? 'active' : ''));
                });
                return items;
                //
            })(_baseLayers))
                .on("click", '.m-layer-switch', function () {
                var $this = $(this);
                if ($this.hasClass("active"))
                    return;
                $this.addClass("active").siblings().removeClass("active");
                //切换地图
                _self._changeMapTypeHandle($this.data("mtype"));
            }).hover(function () {
                $(this).addClass("s-width" + nums).children().each(function (i) {
                    $(this).css('left', ((i == 0) ? minLeft : ((2 * i + 1) * minLeft + i * withP)) * 100 + '%');
                });
            }, function () {
                $(this).removeClass("s-width" + nums).children().css('left', initItemLeft + "px");
            });
        },
        _changeMapTypeHandle: function (type) {
            //
            //
            $.each(_map.layerIds, function (i, lId) {
                //
                if (_self._isBaseLayer(lId)) {
                    //
                    _map.getLayer(lId).setVisibility(false);
                }
            });
            //
            var vecLayer = _map.getLayer(type);
            var labelLayer = _map.getLayer(type + "w");
            //
            if (vecLayer) {
                vecLayer.show();
            }
            if (labelLayer) {
                labelLayer.show();
            }
        },
        //
        _isBaseLayer: function (layerId) {
            //
            var items = _baseLayers.filter(function (layer) {
                //
                return layer.id === layerId;
            });
            return items.length > 0 ? items[0] : null;
        }
    });
});
//# sourceMappingURL=LayerSwitchControl.js.map