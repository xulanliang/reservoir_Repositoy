//>>built
define("dojox/data/AppStore",["dojo","dojox","dojo/data/util/simpleFetch","dojo/data/util/filter","dojox/atom/io/Connection"],function(h,g){h.experimental("dojox.data.AppStore");var m=h.declare("dojox.data.AppStore",null,{url:"",urlPreventCache:!1,xmethod:!1,_atomIO:null,_feed:null,_requests:null,_processing:null,_updates:null,_adds:null,_deletes:null,constructor:function(a){a&&a.url&&(this.url=a.url);a&&a.urlPreventCache&&(this.urlPreventCache=a.urlPreventCache);if(!this.url)throw Error("A URL is required to instantiate an APP Store object");
},_setFeed:function(a,b){this._feed=a;var c;for(c=0;c<this._feed.entries.length;c++)this._feed.entries[c].store=this;if(this._requests)for(c=0;c<this._requests.length;c++){var d=this._requests[c];d.request&&d.fh&&d.eh?this._finishFetchItems(d.request,d.fh,d.eh):d.clear?this._feed=null:d.add?this._feed.addEntry(d.add):d.remove&&this._feed.removeEntry(d.remove)}this._requests=null},_getAllItems:function(){for(var a=[],b=0;b<this._feed.entries.length;b++)a.push(this._feed.entries[b]);return a},_assertIsItem:function(a){if(!this.isItem(a))throw Error("This error message is provided when a function is called in the following form: getAttribute(argument, attributeName).  The argument variable represents the member or owner of the object. The error is created when an item that does not belong to this store is specified as an argument.");
},_assertIsAttribute:function(a){if("string"!==typeof a)throw Error("The attribute argument must be a string. The error is created when a different type of variable is specified such as an array or object.");for(var b in g.atom.io.model._actions)if(b==a)return!0;return!1},_addUpdate:function(a){this._updates?this._updates.push(a):this._updates=[a]},getValue:function(a,b,c){a=this.getValues(a,b);return 0<a.length?a[0]:c},getValues:function(a,b){this._assertIsItem(a);if(this._assertIsAttribute(b)){if(("author"===
b||"contributor"===b||"link"===b)&&a[b+"s"])return a[b+"s"];if("category"===b&&a.categories)return a.categories;if(a[b])return a=a[b],"Content"==a.nodeType?[a.value]:[a]}return[]},getAttributes:function(a){this._assertIsItem(a);var b=[],c;for(c in g.atom.io.model._actions)this.hasAttribute(a,c)&&b.push(c);return b},hasAttribute:function(a,b){return 0<this.getValues(a,b).length},containsValue:function(a,b,c){var d=void 0;"string"===typeof c&&(d=h.data.util.filter.patternToRegExp(c,!1));return this._containsValue(a,
b,c,d)},_containsValue:function(a,b,c,d,f){a=this.getValues(a,b);for(b=0;b<a.length;++b){var e=a[b];if("string"===typeof e&&d)return f&&(e=e.replace(RegExp(/^\s+/),""),e=e.replace(RegExp(/\s+$/),"")),e=e.replace(/\r|\n|\r\n/g,""),null!==e.match(d);if(c===e)return!0}return!1},isItem:function(a){return a&&a.store&&a.store===this},isItemLoaded:function(a){return this.isItem(a)},loadItem:function(a){this._assertIsItem(a.item)},_fetchItems:function(a,b,c){if(this._feed)this._finishFetchItems(a,b,c);else{var d=
!1;this._requests||(this._requests=[],d=!0);this._requests.push({request:a,fh:b,eh:c});d&&(this._atomIO=new g.atom.io.Connection(!1,this.urlPreventCache),this._atomIO.getFeed(this.url,this._setFeed,null,this))}},_finishFetchItems:function(a,b,c){var d=null,f=this._getAllItems();if(a.query){var e=a.queryOptions?a.queryOptions.ignoreCase:!1,d=[],g={},k,l;for(k in a.query)l=a.query[k]+"","string"===typeof l&&(g[k]=h.data.util.filter.patternToRegExp(l,e));for(e=0;e<f.length;++e){var m=!0,n=f[e];for(k in a.query)l=
a.query[k]+"",this._containsValue(n,k,l,g[k],a.trim)||(m=!1);m&&d.push(n)}}else 0<f.length&&(d=f.slice(0,f.length));try{b(d,a)}catch(p){c(p,a)}},getFeatures:function(){return{"dojo.data.api.Read":!0,"dojo.data.api.Write":!0,"dojo.data.api.Identity":!0}},close:function(a){this._feed=null},getLabel:function(a){if(this.isItem(a))return this.getValue(a,"title","No Title")},getLabelAttributes:function(a){return["title"]},getIdentity:function(a){this._assertIsItem(a);return this.getValue(a,"id")},getIdentityAttributes:function(a){return["id"]},
fetchItemByIdentity:function(a){this._fetchItems({query:{id:a.identity},onItem:a.onItem,scope:a.scope},function(a,c){var d=c.scope;d||(d=h.global);1>a.length?c.onItem.call(d,null):c.onItem.call(d,a[0])},a.onError)},newItem:function(a){var b=new g.atom.io.model.Entry,c=null,d=null,f,e;for(e in a)if(this._assertIsAttribute(e))switch(c=a[e],e){case "link":for(f in c)d=c[f],b.addLink(d.href,d.rel,d.hrefLang,d.title,d.type);break;case "author":for(f in c)d=c[f],b.addAuthor(d.name,d.email,d.uri);break;
case "contributor":for(f in c)d=c[f],b.addContributor(d.name,d.email,d.uri);break;case "category":for(f in c)d=c[f],b.addCategory(d.scheme,d.term,d.label);break;case "icon":case "id":case "logo":case "xmlBase":case "rights":b[e]=c;break;case "updated":case "published":case "issued":case "modified":b[e]=g.atom.io.model.util.createDate(c);break;case "content":case "summary":case "title":case "subtitle":b[e]=new g.atom.io.model.Content(e);b[e].value=c;break;default:b[e]=c}b.store=this;b.isDirty=!0;this._adds?
this._adds.push(b):this._adds=[b];this._feed?this._feed.addEntry(b):this._requests?this._requests.push({add:b}):(this._requests=[{add:b}],this._atomIO=new g.atom.io.Connection(!1,this.urlPreventCache),this._atomIO.getFeed(this.url,h.hitch(this,this._setFeed)));return!0},deleteItem:function(a){this._assertIsItem(a);this._deletes?this._deletes.push(a):this._deletes=[a];this._feed?this._feed.removeEntry(a):this._requests?this._requests.push({remove:a}):(this._requests=[{remove:a}],this._atomIO=new g.atom.io.Connection(!1,
this.urlPreventCache),this._atomIO.getFeed(this.url,h.hitch(this,this._setFeed)));return!0},setValue:function(a,b,c){this._assertIsItem(a);var d={item:a};if(this._assertIsAttribute(b))switch(b){case "link":return d.links=a.links,this._addUpdate(d),a.links=null,a.addLink(c.href,c.rel,c.hrefLang,c.title,c.type),a.isDirty=!0;case "author":return d.authors=a.authors,this._addUpdate(d),a.authors=null,a.addAuthor(c.name,c.email,c.uri),a.isDirty=!0;case "contributor":return d.contributors=a.contributors,
this._addUpdate(d),a.contributors=null,a.addContributor(c.name,c.email,c.uri),a.isDirty=!0;case "category":return d.categories=a.categories,this._addUpdate(d),a.categories=null,a.addCategory(c.scheme,c.term,c.label),a.isDirty=!0;case "icon":case "id":case "logo":case "xmlBase":case "rights":return d[b]=a[b],this._addUpdate(d),a[b]=c,a.isDirty=!0;case "updated":case "published":case "issued":case "modified":return d[b]=a[b],this._addUpdate(d),a[b]=g.atom.io.model.util.createDate(c),a.isDirty=!0;case "content":case "summary":case "title":case "subtitle":return d[b]=
a[b],this._addUpdate(d),a[b]=new g.atom.io.model.Content(b),a[b].value=c,a.isDirty=!0;default:return d[b]=a[b],this._addUpdate(d),a[b]=c,a.isDirty=!0}return!1},setValues:function(a,b,c){if(0===c.length)return this.unsetAttribute(a,b);this._assertIsItem(a);var d={item:a},f;if(this._assertIsAttribute(b))switch(b){case "link":d.links=a.links;a.links=null;for(f in c)b=c[f],a.addLink(b.href,b.rel,b.hrefLang,b.title,b.type);return a.isDirty=!0;case "author":d.authors=a.authors;a.authors=null;for(f in c)b=
c[f],a.addAuthor(b.name,b.email,b.uri);return a.isDirty=!0;case "contributor":d.contributors=a.contributors;a.contributors=null;for(f in c)b=c[f],a.addContributor(b.name,b.email,b.uri);return a.isDirty=!0;case "categories":d.categories=a.categories;a.categories=null;for(f in c)b=c[f],a.addCategory(b.scheme,b.term,b.label);return a.isDirty=!0;case "icon":case "id":case "logo":case "xmlBase":case "rights":return d[b]=a[b],a[b]=c[0],a.isDirty=!0;case "updated":case "published":case "issued":case "modified":return d[b]=
a[b],a[b]=g.atom.io.model.util.createDate(c[0]),a.isDirty=!0;case "content":case "summary":case "title":case "subtitle":return d[b]=a[b],a[b]=new g.atom.io.model.Content(b),a[b].values[0]=c[0],a.isDirty=!0;default:return d[b]=a[b],a[b]=c[0],a.isDirty=!0}this._addUpdate(d);return!1},unsetAttribute:function(a,b){this._assertIsItem(a);if(this._assertIsAttribute(b)&&null!==a[b]){var c={item:a};switch(b){case "author":case "contributor":case "link":c[b+"s"]=a[b+"s"];break;case "category":c.categories=
a.categories;break;default:c[b]=a[b]}a.isDirty=!0;a[b]=null;this._addUpdate(c);return!0}return!1},save:function(a){for(var b in this._adds)this._atomIO.addEntry(this._adds[b],null,function(){},a.onError,!1,a.scope);this._adds=null;for(b in this._updates)this._atomIO.updateEntry(this._updates[b].item,function(){},a.onError,!1,this.xmethod,a.scope);this._updates=null;for(b in this._deletes)this._atomIO.removeEntry(this._deletes[b],function(){},a.onError,this.xmethod,a.scope);this._deletes=null;this._atomIO.getFeed(this.url,
h.hitch(this,this._setFeed));a.onComplete&&a.onComplete.call(a.scope||h.global)},revert:function(){for(var a in this._adds)this._feed.removeEntry(this._adds[a]);this._adds=null;var b,c,d;for(a in this._updates)for(d in b=this._updates[a],c=b.item,b)"item"!==d&&(c[d]=b[d]);this._updates=null;for(a in this._deletes)this._feed.addEntry(this._deletes[a]);this._deletes=null;return!0},isDirty:function(a){return a?(this._assertIsItem(a),a.isDirty?!0:!1):null!==this._adds||null!==this._updates}});h.extend(m,
h.data.util.simpleFetch);return m});