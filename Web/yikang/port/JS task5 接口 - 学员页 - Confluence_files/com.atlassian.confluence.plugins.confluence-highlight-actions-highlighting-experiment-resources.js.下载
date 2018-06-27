try {
/* module-key = 'com.atlassian.confluence.plugins.confluence-highlight-actions:highlighting-experiment-resources', location = '/js/doctheme-utils.js' */
Confluence.DocThemeUtils=Confluence.DocThemeUtils||(function(e){var d;function c(){return(a().length)?true:false}function a(){if(!d){d=e("#splitter-content")}return d}function f(h){var g=e(h);e(h).appendTo(c()?a():e("body"));return g}function b(){return c()?a().scrollTop():e("html").scrollTop()+e("body").scrollTop()}return{isDocTheme:c,appendAbsolutePositionedElement:f,getMainContentScrollTop:b,getDocThemeContentElement:a}})(AJS.$);
} catch (err) {
    if (console && console.log && console.error) {
        console.log("Error running batched script.");
        console.error(err);
    }
}


try {
/* module-key = 'com.atlassian.confluence.plugins.confluence-highlight-actions:highlighting-experiment-resources', location = '/js/scrolling-inline-dialog.js' */
Confluence.ScrollingInlineDialog=function(a,d,c,b){var g=Confluence.DocThemeUtils.getDocThemeContentElement();var e=Confluence.DocThemeUtils.isDocTheme();b=b||{};if(!b.container&&e){b.container=g}var f=function(k,s,H,z){var v;var J="auto";var E;var p=-7;var q;var w;var t=e?g.width():$(window).width();var I=s.target.position();I.top+=e?g.scrollTop():0;var i=s.target.outerWidth();var m=I.left+i/2;var B=e?g.scrollTop()+$(window).height()-$("#footer").outerHeight():(window.pageYOffset||document.documentElement.scrollTop)+$(window).height();var n=10;var o=20;E=I.top+s.target.outerHeight()+z.offsetY;var F=k.find(".arrow").outerWidth();var j=k.outerWidth();var C=s.target.outerWidth();if(z.centerOnHighlight){if(j>C){v=I.left-(j-C)/2;q=m-v-F/2}else{v=I.left+z.offsetX;q=(j-F)/2}}else{v=I.left+z.offsetX;if(j>C){q=m-v-F/2}else{q=(j-F)/2}}q=(q<0)?0:q;var h=(e)?(I.top-g.scrollTop()):(I.top-(window.pageYOffset||document.documentElement.scrollTop));var r=h>k.height();var l=(E+k.height())<B;w=(!l&&r)||z.onTop;z.onTop=w;var y=t-(v+j+n);if(w){E=I.top-k.height()-8;p=k.height()}if(w===false&&l===false){var x=(E+k.height())-B;var D=e?g.scrollTop()+x+$("#footer").outerHeight():(window.pageYOffset||document.documentElement.scrollTop)+x+o;var u=e?g:$("html, body");u.stop().animate({scrollTop:D},500)}if(z.isRelativeToMouse){if(y<0){J=n;v="auto";q=H.x-($(window).width()-z.width)}else{v=H.x-20;q=H.x-v}}else{if(y<0){J=n;v="auto";var G=t-J;var A=G-j;q=m-A-F/2}}return{displayAbove:w,popupCss:{left:v,right:J,top:E},arrowCss:{position:"absolute",left:q,right:"auto",top:p}}};if(!b.calculatePositions){b.calculatePositions=f}return AJS.InlineDialog.call(this,a,d,c,b)};
} catch (err) {
    if (console && console.log && console.error) {
        console.log("Error running batched script.");
        console.error(err);
    }
}


try {
/* module-key = 'com.atlassian.confluence.plugins.confluence-highlight-actions:highlighting-experiment-resources', location = '/js/hilight-panel.js' */
Confluence.HighlightAction=(function(f){var e={};var h;var c;var l;var b={MAINCONTENT_AND_COMMENT:function(n){h=h||f(".wiki-content");return Confluence.HighlightAction.RangeHelper.isSelectionInsideContent(h,n)},MAINCONTENT_ONLY:function(n){c=c||f(".wiki-content").first();return Confluence.HighlightAction.RangeHelper.isSelectionInsideContent(c,n)},COMMENT_ONLY:function(n){l=l||f(".comment-content");return Confluence.HighlightAction.RangeHelper.isSelectionInsideContent(l,n)}};function a(o,p){var n={onClick:function(){},shouldDisplay:b.MAINCONTENT_AND_COMMENT};e[o]=f.extend(n,p)}function k(n){var o=e[n];if(!o){o=function(){AJS.logError("The button with key "+n+" doesn't have a registered handler")}}return o}function d(o){var n=Confluence.getContextPath()+"/rest/highlighting/1.0/insert-storage-fragment";return f.ajax({type:"POST",contentType:"application/json",url:n,data:JSON.stringify(o)})}function g(n){var o=Confluence.getContextPath()+"/rest/highlighting/1.0/insert-storage-column-table";return f.ajax({type:"POST",contentType:"application/json",url:o,data:JSON.stringify(n)})}function j(p,o,q){var n=i(p,q);n.tableColumnIndex=o;return n}function i(n,p){var o={};o.pageId=p.pageId;o.selectedText=p.selectedText;o.index=p.index;o.numMatches=p.numMatches;o.cellXmlInsertionBeans=n;o.lastFetchTime=m();return o}function m(){return f("meta[name='confluence-request-time']").attr("content")}return{registerButtonHandler:a,getButtonHandler:k,insertContentAtSelectionEnd:d,insertContentsInTableColumnCells:g,createTableInsertionBean:j,createInsertionBean:i,WORKING_AREA:b}})(AJS.$);Confluence.HighlightAction.RangeHelper=(function(h){var i;function j(o){return{area:c(o),text:k(o),html:m(o),containingElement:d(o),range:o}}function c(p){var q=Confluence.DocThemeUtils.getMainContentScrollTop();var u=p.getClientRects();if(!u.length&&p.parentElement()){var v=h(p.parentElement());var o=v.offset();u=[{top:o.top-((Confluence.DocThemeUtils.isDocTheme())?0:q),left:o.left,bottom:o.top+v.height(),right:o.left+v.width()}]}var x=g(p,u);var s=function(C,B){var A={};A.top=C.top;A.left=C.left;A.bottom=B.bottom;if(C.left>=B.right){A.right=C.right}else{A.right=B.right}A.top=A.top+q;A.bottom=A.bottom+q;A.width=A.right-A.left;A.height=A.bottom-A.top;return A};var r=function(B){var A={};A.width=B.right-B.left;A.height=B.bottom-B.top;A.left=B.left;A.right=B.right;A.top=B.top+q;A.bottom=B.bottom+q;return A};var z=function(A){if(Confluence.DocThemeUtils.isDocTheme()){var B=Confluence.DocThemeUtils.getDocThemeContentElement().offset();A.left=A.left-B.left;A.right=A.right-B.left;A.top=A.top-B.top;A.bottom=A.bottom-B.top}return A};var y=z(s(x.first,x.last));var t=z(r(x.first));if(Confluence.HighlightAction.debug){var w=h("<div>").attr("id","highlight-actions-debug-helper");Confluence.DocThemeUtils.appendAbsolutePositionedElement(w).css(h.extend({position:"absolute",outline:"1px solid red"},y))}return{first:t,average:y}}function k(o){return(o.text!=undefined)?o.text:o.toString()}function m(o){return(o.cloneContents)?h("<div>").append(o.cloneContents()).html():o.htmlText}function d(p){if(p.commonAncestorContainer){var o=p.commonAncestorContainer;if(o.nodeType==3){return o.parentNode}return o}else{if(p.parentElement){return p.parentElement()}}}function g(q,p){var o={};o.first=p[0];o.last=p[p.length-1];if(q.endOffset!=="undefined"){if(q.endOffset==0){o.last=p[p.length-2]}}return o}function e(){if(window.getSelection&&window.getSelection().isCollapsed){return false}if(document.selection&&(document.selection.type=="None"||document.selection.createRange().htmlText=="")){return false}var r;if(window.getSelection){var o=window.getSelection();r=o.getRangeAt(o.rangeCount-1)}else{if(document.selection){r=document.selection.createRange()}}if(/^\s*$/.test(k(r))){var p=m(r);if(!p){return false}var q=p.toLowerCase().indexOf("<img ")!=-1;if(!q){return false}}i=i||h(".wiki-content");if(!l(i,r)){return false}return r}function l(o,r){var p=d(r);var q=function(){var s=false;h.each(o,function(t,u){if(u===p||h.contains(u,p)){s=true;return false}});return s};return q()}function b(r,q){var p=f(r);var o=k(n(r,q));var t=k(q);var s=a(p,t);return{pageId:AJS.Meta.get("page-id"),selectedText:t,index:h.inArray(o.length-t.length,s),numMatches:s.length}}function f(o){if(document.createRange){return o.text()}else{range=document.body.createTextRange();range.moveToElementText(o.get(0));return range.text}}function n(q,p){var o;if(document.createRange){o=document.createRange();o.setStart(q.get(0),0);o.setEnd(p.endContainer,p.endOffset)}else{o=document.body.createTextRange();o.moveToElementText(q.get(0));o.setEndPoint("EndToEnd",p)}return o}function a(r,p){var s=0;var q=-1;var o=[];while((q=r.indexOf(p,s))>-1){o.push(q);s=q+1}return o}return{getRangeOption:j,getUserSelectionRange:e,getSelectionRects:c,getSelectionText:k,getSelectionHTML:m,getContainingElement:d,getFirstAndLastSelectionRect:g,isSelectionInsideContent:l,computeSearchTextObject:b}})(AJS.$);AJS.toInit(function(e){var h=e(".wiki-content").first();var a=e("<div>").attr("id","action-dialog-target");var d;var i="selection-action-panel";var b;var f;function n(){var q=Confluence.getContextPath()+"/rest/highlighting/1.0/panel-items";var p=AJS.Meta.get("page-id");if(p!=undefined){q=q+"?pageId="+p}e.get(q,function(r){if(r.length){k(r);g()}})}var m=function(){if(e.browser.msie&&e.browser.version<=8){var p=document.getElementsByTagName("head")[0];var q=document.createElement("style");q.type="text/css";q.styleSheet.cssText=" #inline-dialog-"+i+" :before, #inline-dialog-"+i+" :after { content:none !important;}";p.appendChild(q);setTimeout(function(){p.removeChild(q)},0)}};function k(u){var x=c();var p=29;var y=false;var A=u.length*p;var z=Confluence.HighlightPanel.Templates.panelContent({webItems:u});var w=false;var r=function(C,B,D){if(!w){C.append(z);C.find(".aui-button").tooltip({gravity:"s"});j(C.parent());C.find("button").click(function(G){var E=e(this).attr("data-key");var H=Confluence.HighlightAction.getButtonHandler(E);y=true;d.hide();var F=Confluence.HighlightAction.RangeHelper.getRangeOption(b);if(e.trim(F.text)!==""){F.searchText=Confluence.HighlightAction.RangeHelper.computeSearchTextObject(h,b)}H.onClick(F)})}D();if(!w){setTimeout(m,0)}w=true;return false};var v=function(B){var C=false;B.find("button").each(function(D){var F=e(this);var E=F.attr("data-key");var H=Confluence.HighlightAction.getButtonHandler(E);var G=H.shouldDisplay(b);F.css("display",G?"inline-block":"none");C=C||G});if(!C){d.hide()}else{B.find(".contents").width("auto")}};var q=function(){Confluence.HighlightAction.Analytics.sendAnalyticsForOpeningHighlightOptionPanel();v(this.popup);x.bindHideEvents();a.show()};var t=function(){x.unbindHideEvents();a.hide()};var s={centerOnHighlight:true,onTop:true,fadeTime:0,width:A,persistent:true,initCallback:q,hideCallback:t};d=Confluence.ScrollingInlineDialog(a,i,r,s)}function j(p){p.children().attr("unselectable","on").on("selectstart",false)}function g(){var p;var q=0;var r=1000;e(document).mouseup(function(t){var s=e(t.target);if(s.closest(".aui-inline-dialog").length!==0){return}setTimeout(function(){clearTimeout(p);var u=r;if(e(d[0]).is(":visible")){u=q}p=setTimeout(function(){l()},u)},q)});AJS.bind("quickedit.success",function(){d.hide()})}function l(){b=Confluence.HighlightAction.RangeHelper.getUserSelectionRange();if(!b){d.hide();return}var q=Confluence.HighlightAction.RangeHelper.getSelectionRects(b);if(!q){return}var p=o(q);if(p||!e(d[0]).is(":visible")){e(d[0]).hide();d.show()}}function c(){var s=function(){u();r()};var v=function(){p();x()};var q=false;var w=i+".inline-dialog-check";var u=function(){if(!q){e("body").bind("click."+w,function(z){var y=e(z.target);if(y.closest("#inline-dialog-"+i+" .contents").length===0){if(!b){d.hide()}}});q=true}};var p=function(){if(q){e("body").unbind("click."+w)}q=false};var t=function(y){if(y.keyCode===27){d.hide()}};var r=function(){e(document).on("keydown",t)};var x=function(){e(document).off("keydown",t)};return{bindHideEvents:s,unbindHideEvents:v}}function o(q){Confluence.DocThemeUtils.appendAbsolutePositionedElement(a);var p=false;if(!f||q.first.top!=f.first.top||q.first.height!=f.first.height||q.first.left!=f.first.left||q.first.width!=f.first.width){a.css({top:q.first.top,height:q.first.height,left:q.first.left,width:q.first.width});f=q;p=true}return p}n()});
} catch (err) {
    if (console && console.log && console.error) {
        console.log("Error running batched script.");
        console.error(err);
    }
}


try {
/* module-key = 'com.atlassian.confluence.plugins.confluence-highlight-actions:highlighting-experiment-resources', location = '/js/quote-in-comment.js' */
AJS.toInit(function(f){var a=true;var h=false;var d="com.atlassian.confluence.plugins.confluence-highlight-actions:quote-comment";function b(m){var l=m.getBody().createTextRange();l.moveToElementText(m.getBody());l.collapse(false);l.select()}function i(){if(window.getSelection){window.getSelection().empty&&window.getSelection().empty();window.getSelection().removeAllRanges&&window.getSelection().removeAllRanges()}else{window.document.selection&&window.document.selection.empty()}}function e(){var l=40;if(Confluence.DocThemeUtils.isDocTheme()){var m=Confluence.DocThemeUtils.getDocThemeContentElement();var n=m.scrollTop()-f("#header").height()+f("#rte-toolbar").offset().top;m.scrollTop(n-l)}else{var n=f("#rte-toolbar").offset().top;f("html,body").scrollTop(n-l)}}function k(m,n){var o="<p><br/></p>";if(f.browser.msie&&!h){b(m);o="<p></p>"}var l="<blockquote><p>"+n.html+"</p></blockquote>"+o;m.execCommand("mceInsertContent",false,l);h=false}function j(l){i();setTimeout(function(){var m=AJS&&AJS.Rte&&AJS.Rte.getEditor&&AJS.Rte.getEditor();if(m){Confluence.HighlightAction.Analytics.sendAnalyticsForQuoteInComment();e();k(m,l)}else{Confluence.HighlightAction.Analytics.sendAnalyticsForQuoteInComment(a);h=true;var n=function(){k(AJS.Rte.getEditor(),l);AJS.unbind("quickedit.visible",n)};AJS.bind("quickedit.visible",n);c(g(l.containingElement))}},0)}function g(l){var m=f(l).closest("div.comment");return m}function c(l){if(!l.length>0){f(".quick-comment-prompt").click()}else{l.find(".comment-actions .action-reply-comment").click()}}Confluence&&Confluence.HighlightAction&&Confluence.HighlightAction.registerButtonHandler(d,{onClick:j,shouldDisplay:Confluence.HighlightAction.WORKING_AREA.MAINCONTENT_AND_COMMENT})});
} catch (err) {
    if (console && console.log && console.error) {
        console.log("Error running batched script.");
        console.error(err);
    }
}


try {
/* module-key = 'com.atlassian.confluence.plugins.confluence-highlight-actions:highlighting-experiment-resources', location = '/js/highlight-analytics.js' */
Confluence.HighlightAction.Analytics=(function(c){var b="confluence.highlight.actions.open";var e="confluence.quote.in.comment.insert";var g="confluence.quote.in.comment.append";function d(h,i){AJS.EventQueue=AJS.EventQueue||[];AJS.EventQueue.push({name:h,properties:i})}function a(){d(b)}function f(h){if(h){d(e)}else{d(g)}}return{sendAnalyticsForOpeningHighlightOptionPanel:a,sendAnalyticsForQuoteInComment:f}})(AJS.$);
} catch (err) {
    if (console && console.log && console.error) {
        console.log("Error running batched script.");
        console.error(err);
    }
}


try {
/* module-key = 'com.atlassian.confluence.plugins.confluence-highlight-actions:highlighting-experiment-resources', location = '/soy/templates.soy' */
// This file was automatically generated from templates.soy.
// Please don't edit this file by hand.

if (typeof Confluence == 'undefined') { var Confluence = {}; }
if (typeof Confluence.HighlightPanel == 'undefined') { Confluence.HighlightPanel = {}; }
if (typeof Confluence.HighlightPanel.Templates == 'undefined') { Confluence.HighlightPanel.Templates = {}; }


Confluence.HighlightPanel.Templates.panelContent = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  var webItemList3 = opt_data.webItems;
  var webItemListLen3 = webItemList3.length;
  for (var webItemIndex3 = 0; webItemIndex3 < webItemListLen3; webItemIndex3++) {
    var webItemData3 = webItemList3[webItemIndex3];
    output.append('<button data-key="', soy.$$escapeHtml(webItemData3.key), '" class="aui-button aui-button-compact aui-button-subtle" title="', soy.$$escapeHtml(webItemData3.label), '"><span class="aui-icon aui-icon-small ', soy.$$escapeHtml(webItemData3.styleClass), '"/></button>');
  }
  return opt_sb ? '' : output.toString();
};

} catch (err) {
    if (console && console.log && console.error) {
        console.log("Error running batched script.");
        console.error(err);
    }
}


