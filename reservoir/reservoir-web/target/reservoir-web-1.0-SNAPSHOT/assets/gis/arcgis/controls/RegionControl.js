/**
 * Created by wangsl on 2016/9/27.
 */
//
define(["dojo/_base/declare", "dojo/_base/lang", "dojo/dom", "dojo/on", "dojo/topic", "dojo/dom-construct",
    "dojo/_base/array", "dojo/string", "../conf/region",
    "./_BaseControl", "../utils/dseGisUtils", "esri/geometry/Extent"], function (declare, lang, dom, on, topic, domConstruct, Array, string, regionConfig, _BaseControl, dseGisUtils, Extent) {
    var self = null;
    //
    var regionClass = declare([_BaseControl], {
        /**
         *
         *@param {HTMLElement} div
         *@param {Object} {url:}
         * */
        constructor: function (node, options) {
            //
            // this.domNode = node;
            self = this;
            //
            //
            this._configLoaded(regionConfig);
            //
            this.setPosition(this.position, this.size);
            //
            this.addStyle("panel panel-default m-region-ctn");
        },
        _configLoaded: function (data) {
            //
            this._deepIndex = data.deepIndex;
            this._createDropListBy(this._deepIndex);
            //
            var firstList = this._horSelectItems[0];
            this._createCityItems(data.province, firstList);
            //
            this._showFirstDropList();
            //
            var firstItems = data.province[0].children;
            if (firstItems) {
                self._createCityItems(firstItems, this._horSelectItems[1]);
                //
                var current = firstItems[0];
                this._navigateToExtent(current.extent);
            }
        },
        //
        /***/
        _createDropListBy: function (deepIndex) {
            //
            for (var i = 0; i < deepIndex; i++) {
                //
                var selectId = "region" + i;
                var itemProps = {
                    id: selectId
                };
                var select = domConstruct.create("select", itemProps, this.domNode);
                this._horSelectItems.push(select);
            }
        },
        //
        _showFirstDropList: function () {
            //
            var items = this._horSelectItems;
            Array.forEach(items, function (item, iindex) {
                //
                if (iindex > 1) {
                    $(item).hide();
                }
            });
            //
            //var current=items[0];
            ////
            //var children=current.children;
            //if(children){
            //    //
            //    self._createCityItems(children,self._horSelectItems[1]);
            //}
            //this._navigateToExtent(current.extent);
            //
        },
        //
        _deepIndex: 0,
        //
        _createCityItems: function (infos, domNode) {
            //
            domConstruct.empty(domNode);
            Array.forEach(infos, function (info) {
                //
                var content = info.name;
                var itemProps = {
                    innerHTML: content
                };
                //
                var option = domConstruct.create("option", itemProps, domNode);
                on(domNode, "change", function (event) {
                    //
                    var currentItem = $(domNode).val();
                    if (info.name === currentItem) {
                        //
                        var nextIndex = info.index + 1;
                        if (nextIndex < self._deepIndex) {
                            //
                            var subNode = self._horSelectItems[nextIndex];
                            $(subNode).show();
                            self._createCityItems(info.children, subNode);
                            //
                            //self._navigateToExtent(info.extent);
                        }
                        info.index < self._deepIndex && self._navigateToExtent(info.extent);
                        //当前组合框之后的
                        if (info.children) {
                            self._showDropDownList(nextIndex);
                        }
                        else {
                            self._showDropDownList(nextIndex - 1);
                        }
                        /* var afters=self._horSelectItems.slice(nextIndex,self._deepIndex);
                         for(var i=0;i<afters.length;i++){
                         //
                         var hideItem=afters[i];
                         $(hideItem).hide();
                         }*/
                    }
                });
            });
        },
        //
        //
        _showDropDownList: function (splitIndex) {
            var items = this._horSelectItems;
            if (splitIndex && splitIndex < items.length) {
                //
                Array.forEach(items, function (item, iindex) {
                    //
                    if (iindex <= splitIndex) {
                        //
                        $(item).show();
                    }
                    else {
                        $(item).hide();
                    }
                });
            }
        },
        //
        _horSelectItems: [],
        /**
         * <description>导航到指定页面</description>
         *
         * @param {Array}  info format: [xmin,ymin,xmax,ymax]
         * */
        //
        _navigateToExtent: function (arrExtent) {
            if (arrExtent && arrExtent.length > 3) {
                //
                var extent = null;
                if (regionConfig.isConvert) {
                    var minEx = dseGisUtils.WgsToDqzb(arrExtent[0], arrExtent[1], this.mapType);
                    var maxEx = dseGisUtils.WgsToDqzb(arrExtent[2], arrExtent[3], this.mapType);
                    extent = new Extent(Number(minEx[0]), Number(minEx[1]), Number(maxEx[0]), Number(maxEx[1]), this.map.spatialReference);

                } else {
                    extent = new Extent(arrExtent[0], arrExtent[1], arrExtent[2], arrExtent[3], this.map.spatialReference);
                }
                this.map.setExtent(extent);
            }
        },
    });
    //
    return regionClass;
});
//# sourceMappingURL=RegionControl.js.map