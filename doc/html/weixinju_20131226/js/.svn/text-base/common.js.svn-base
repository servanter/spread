// JavaScript Document
$(document).ready(function() {
    var userInfo = USER.getCookie("DJ_MEMBER_INFO");
    var dmbi = USER.getCookie("dmbi");
    if (userInfo && dmbi) {
        $("#login_span").hide();
        $("#username").text(userInfo);
        $("#logined_span").show();
        $.ajax({
            url: 'http://www.d.cn/djwebst/asych/getmsgcnt/?jsonCallback=?&dmbi=' + dmbi,
            dataType: "jsonp",
            success: function(data) {
                $("#logined_span em").html(data.newMessageCnt);
            }
        });
    } else {
        $("#loginLink").attr("href", "http://my.d.cn/index.html?to=" + window.location.href);
    }
});
// JavaScript Document
function getCookie(c_name){
	if (document.cookie.length>0)
	  {
	  c_start=document.cookie.indexOf(c_name + "=")
	  if (c_start!=-1)
	    { 
	    c_start=c_start + c_name.length+1 
	    c_end=document.cookie.indexOf(";",c_start)
	    if (c_end==-1) c_end=document.cookie.length
	    return unescape(document.cookie.substring(c_start,c_end));
	    } 
	  }
	return "";
}
function SetCookie(name,value)//涓や釜鍙傛暟锛屼竴涓槸cookie鐨勫悕瀛愶紝涓€涓槸鍊�
{
    var Days = 30,
        exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/";
}
var oInput = {},
    $sEl=$("#searchKeyword"),
    reqPrefix="";
function initSelect() {
    var upKeyCode = 38;
    var downKeyCode = 40;
    var enterKeyCode = 13;
    oInput = document.getElementById("searchKeyword");
    oInput.options = $("#searchResult li")
    oInput.seletedIndex = -1;

    oInput.focus();
    oInput.onkeyup = function(event) {
        if (event == undefined) {
            event = window.event;
        }
        switch (event.keyCode) {
            case upKeyCode:
                clearSelectedOptBgColor(this);
                this.seletedIndex--;
                if (this.seletedIndex < 0)
                    this.seletedIndex = this.options.length - 1;
                setSelectedOptBgColor(this);
                break;

            case downKeyCode:
                clearSelectedOptBgColor(this);
                this.seletedIndex++;
                if (this.seletedIndex >= this.options.length)
                    this.seletedIndex = -1;
                setSelectedOptBgColor(this);
                break;

            case enterKeyCode:
                //if(this.seletedIndex!=-1){
                //genNewPage(this);
                //}
                break;
            default:
                genShortResult();
                clearSelectedOptBgColor(this);
                this.seletedIndex = -1;
                break;
        }
    };
    oInput.onblur = function() {
        clearSelectedOptBgColor(this);
        this.seletedIndex = -1;
        clearHover();
    };
}
function clearSelectedOptBgColor(target) {
    if (target.seletedIndex >= 0) {
        removeClass(target.options[target.seletedIndex], "searchTitleHoverLi");
    }
}
function setSelectedOptBgColor(target) {
    addClass(target.options[target.seletedIndex], "searchTitleHoverLi");
}

function genNewPage(target) {
    if (hasClass(target.options[target.seletedIndex], "searchTitleHoverLi")) {
        var url = target.options[target.seletedIndex].firstChild.getAttribute("href");
        window.open(url);
    }
}

function hasClass(obj, cls) {
    if (typeof (obj) == "undefined" || obj == null)
        return false;
    return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
}

function addClass(obj, cls) {
    if (typeof (obj) == "undefined" || obj == null)
        return;
    if (!this.hasClass(obj, cls))
        obj.className += " " + cls;
}

function removeClass(obj, cls) {
    if (hasClass(obj, cls)) {
        var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
        obj.className = obj.className.replace(reg, ' ');
    }
}
function searchSubmit() {
    var val = $sEl.val();
    val = $.trim(val);
    if (val == '璇疯緭鍏ユ悳绱㈠唴瀹�' || val == "") {
        if (oInput) {
            oInput.seletedIndex = -1;
        }
        return false;
    }
    if (typeof (oInput) == "undefined" || oInput == null || oInput.seletedIndex == -1) {
        return true;
    }
    if (oInput && oInput.seletedIndex >= 0) { // 鍥炶溅 杩涘叆閫変腑椤�
        var url = oInput.options[oInput.seletedIndex].firstChild.getAttribute("href");
        $("#form1").attr("action", url).attr("target", "_blank").attr("method", "post");
        /*setTimeout(function() {
            $("#form1").attr("action", "http://android.d.cn/search/app.html").attr("target", "").attr("method", "get");
        }, 100);*/
        return true;
    }
}

function redirectURL(url) {
    window.location.href = url;
}

function clearHover() {
    var el = $sEl;
    var val = el.val();
    if (val == '' || val == '璇疯緭鍏ユ悳绱㈠唴瀹�') {
        el.val('璇疯緭鍏ユ悳绱㈠唴瀹�');
    }
    el.css("color", '#B8B7B7');
    //el.removeClass("searchTextHover");
    hideShortResult();
}

var shortResultTimeOut = "";

function genShortResult() {
    var val = $sEl.val();
    if (val == '璇疯緭鍏ユ悳绱㈠唴瀹�') {
        $sEl.val('');
    }
    $sEl.css("color", 'black');
    //$sEl.addClass("searchTextHover");
    if (shortResultTimeOut == "") {
        shortResultTimeOut = "aaa";
        setTimeout('shortResultTime()', 100);
    }
}

function shortResultTime() {
    shortResultTimeOut = "";
    var keyWord = $sEl.val();
    if ($.trim(keyWord).length > 0) {
        var url = "http://api.search.d.cn/shortresult.html?jsonCallback=?";
        $
            .ajax({
                url: url,
                data: {
                    'kwd': keyWord,
                    'from': 'web_android',
                    'cgy': 10,
                    'os': 1,
                    'pn': 1
                },
                dataType: "jsonp",
                success: function(data) {
                    var html = "";
                    if (data.RESOURCE && data.RESOURCE.foundCnt > 0) {
                        html += '<div class="s-l-cont clearfix">';
                        html += '<a href="/search/app/?keyword=' + keyWord
                            + '" class="s-r-tit">搴旂敤&gt;&gt;</a>';
                        html += '<ul class="resource-con">';
                        $
                            .each(
                            data.RESOURCE.resultList,
                            function(ind, obj) {
                                var v = obj.url.indexOf("ng.d.cn") >= 0 ? '' : 'v';
                                html += '<li><a href="' + obj.url + '" target="_blank" title="' + obj.name + '&nbsp;' + v + obj.version + '"><img src="'
                                    + obj.icon + '" alt="' + obj.name + '" />' + obj.nameWithHighLight + '&nbsp;' + v + obj.version + '</a></li>';
                            });
                        html += '</ul></div>';
                    }
//                    if (data.MEMBER && data.MEMBER.foundCnt > 0) {
//                        html += '<div class="s-l-cont clearfix"><ul class="s-l-cont">';
//                        $.each(data.MEMBER.resultList, function(ind, obj) {
//                            html += '<li><a href="' + obj.url + '" target="_blank" title="' + obj.showName
//                                + '"><span class="img"><img src="' + obj.avatar + '" alt="' + obj.showName + '" /></span><span>'
//                                + obj.showNameWithHighLight + '(' + obj.memberIdWithHighLight + ')</span></a></li>';
//                        });
//                        html += '</ul></div>';
//                    }
                    if (data.FORUM_AND_NEWS && data.FORUM_AND_NEWS.foundCnt > 0) {
                        html += '<div class="s-r-cont clearfix">';
                        html += '<a href="/search/news/?keyword=' + keyWord
                            + '" class="s-r-tit">璧勮&gt;&gt;</a>';
                        html += '<ul class="artical-con">';
                        $.each(data.FORUM_AND_NEWS.resultList, function(ind, obj) {
                            html += '<li><a href="' + obj.url + '" target="_blank" title="' + obj.title + '">' + obj.titleWithHighLight
                                + '</a></li>';
                        });
                        html += '</ul></div>';
                    }
                    if (html != "") {
                        var srEl = $("#searchResult");
                        srEl.html(html);
                        initSelect();
                        if (html != "") {
                            srEl.show();
                        } else {
                            srEl.hide();
                        }
                    }
                }
            });
    } else {
        hideShortResult();
        if (typeof (oInput) == "undefined" || oInput == null) {
            oInput.seletedIndex = -1;
        }
    }
}

function hideShortResult() {
    $("#searchResult").fadeOut();
}

function stopEvent(event) {
    if ($.browser.msie && ($.browser.version == "6.0") && !$.support.style) {
        event.cancelBubble = true;
    } else {
        event.stopPropagation();
    }
}

function redirectURL(url) {
    window.location.href = url;
}

var USER = {
    memberId: 0,
    init: function(options) {
        USER.memberId = options.memberId;
    },
    checkLogin: function(memberId, url, submitFormId, doFunc, funcParaArray) {
        if (memberId == null || memberId == 0) {
            USER.showLoginForm(url, submitFormId, 1, doFunc, funcParaArray);
            return false;
        }
        return true;
    },
    showLoginForm: function(url, submitForumId, errorTip, doFunc, funcParaArray) {
        var name;
        var pwd;
        var type;
        var isRememberPsw;
        var errorTip1 = '<div class="user"><p style="font-size:12px">鎮ㄩ渶瑕佺櫥褰曞悗鎵嶈兘杩涜鎿嶄綔锛�</p></div>';
        var errorTip2 = '<div class="user"><p style="color:#be0000; font-size:12px">鐧诲綍澶辫触锛佽纭鎮ㄧ殑鐧诲綍淇℃伅鏄惁姝ｇ‘锛�</p></div>';
        var htmlContent = '<form id="textInput" style="margin:0; padding:0">';
        if (errorTip == 1) {
            htmlContent = htmlContent + errorTip1;
        } else if (errorTip == 2) {
            htmlContent = htmlContent + errorTip2;
        } else if (errorTip) {
            htmlContent = htmlContent + '<div class="user"><p style="color:#be0000; font-size:12px">' + errorTip + '</p></div>';
            ;
        }
        var qqLogin = $("#qqLoginBtn").html();
        htmlContent = htmlContent
            + '<div class="user">\
                        <p class="left40">璐﹀彿锛�</p> \
                        <input id="name" tabIndex="1" type="text" class="input" onFocus="if(this.value==\'涔愪箰鍙�/鐢ㄦ埛鍚�/閭\'){this.value=\'\'};this.style.color=\'black\';" value="涔愪箰鍙�/鐢ㄦ埛鍚�/閭"/> \
                        <span id="wb_connect_btn" ><a class="sinalogin" href="javascript:void(0)" onclick="USER.weiboLogin();"></a></span>\
                      </div>\
                      <div class="user">\
                        <p class="left40">瀵嗙爜锛�</p> \
                        <input id="password" tabIndex="2" type="password" class="input" /> \
                        <span id="qqLoginBtnInner">'
            + qqLogin
            + '</span> \
                        </div>\
                        <div class="user" style="width:80%; margin-left:20%">\
                        <a href="http://my.d.cn/goFindPassword.html" target="_blank" class="forgot">蹇樿瀵嗙爜锛�</a><a href="http://my.d.cn/register.html" target="_blank" class="signnew">娉ㄥ唽鏂扮敤鎴�</a>\
                      </div>\
                      <div class="clear"></div>\
                    <div class="clear"></div>\
                      </form>';
        $.fn.jmodal({
            title: "鐧诲綍",
            fixed: true,
            content: function(body) {
                body.html(htmlContent);
                name = $('#name');
                pwd = $('#password');
            },
            buttonText: {
                ok: '纭畾',
                cancel: '鍙栨秷'
            },
            okEvent: function(data, args) {
                if ($.trim(name.val()) == '') {
                    args.isCancelling = true;
                    alert('璇峰～鍐欑敤鎴峰悕/涔愬彿.');
                } else if ($.trim(pwd.val()) == '') {
                    args.isCancelling = true;
                    alert('璇峰～鍐欏瘑鐮�.');
                } else {
                    args.isCancelling = false;
                    var qsData = {
                        'userName': name.val(),
                        'password': pwd.val()
                    };
                    $.ajax({
                        async: true,
                        url: "http://d.cn/connect/dj/asyncLogin",
                        type: "GET",
                        contentType: "application/json; charset=utf-8",
                        dataType: 'jsonp',
                        jsonp: 'jsoncallback',
                        data: qsData,
                        timeout: 5000,
                        success: function(json) { // 瀹㈡埛绔痡query棰勫厛瀹氫箟濂界殑callback鍑芥暟,鎴愬姛鑾峰彇璺ㄥ煙鏈嶅姟鍣ㄤ笂鐨刯son鏁版嵁鍚�,浼氬姩鎬佹墽琛岃繖涓猚allback鍑芥暟
                            USER.loginResult(json[0], url, submitForumId, doFunc, funcParaArray);
                        },
                        complete: function(XMLHttpRequest, textStatus) {
                            USER.loginResult(XMLHttpRequest.responseText);
                        },
                        error: function(xhr) {
                            alert("璇锋眰鍑洪敊(璇锋鏌ョ浉鍏冲害缃戠粶鐘跺喌.)");
                        }
                    });
                }
            }
        });
    },
    writeMemberIdRadio: function(num, midArray, infoArray, sigArray, toUrl, age) {
        var midsDiv = '<form method="post" action="http://d.cn/connect/dj/dealNumLogin" id="mid_form">\
              <div class="jmodal-content-mob" id="jmodal-container-content" >\
              <div style="font-size:12px">\
              <div class="wz"><img src="http://res.d.cn/buggy/em73.gif" />浜诧紝鎮ㄧ殑鎵嬫満鍙�<span style="color:#be0000;margin:0 5px;font-size:12px" id="num_span">'
            + num
            + '</span>宸查獙璇佸涓箰鍙枫€�<br/>璇烽€夋嫨闇€鐧诲綍鐨勪箰鍙凤細</div>\
              </div>\
              <div class="mob" id="radio-div"></div>';
        for (var i = 0; i < midArray.length; i++) {
            midsDiv = midsDiv + "<div class=\"yhm\"><a href=\"javascript:void(0);\" onclick=\"submitMid('" + midArray[i] + "|"
                + sigArray[i] + "')\" >" + infoArray[i] + "</a>" + "</div>";
        }
        midsDiv = midsDiv + '<input name="info" type="hidden" id="mid_info_input"/>';
        midsDiv = midsDiv + '<input name="toUrl" type="hidden" value="' + toUrl + '"/>';
        midsDiv = midsDiv + '<input name="age" type="hidden" value="' + age + '"/>';
        midsDiv = midsDiv + "</form>";

        $.fn.jmodal({
            title: "鐧诲綍",
            fixed: true,
            noCancel: true,
            content: function(body) {
                body.html(midsDiv);
            },
            buttonText: {
                ok: '鍙栨秷',
                cancel: '鍙栨秷'
            }

        });
    },
    submitMid: function(info) {
        $("#mid_info_input").val(info);
        $("#mid_form").submit();
    },
    loginResult: function(json, url, submitForumId, doFunc, funcParaArray) {
        var data = json.msg;
        if (data != undefined && data.length > 0) {
            USER.showLoginForm(url, submitForumId, data, doFunc, funcParaArray);
        } else {
            if (!json.dmbi) {
                if (json.mids && json.infos && json.sigs && json.num && json.toUrl && json.age) {
                    var num = json.num;
                    var mids = json.mids;
                    var infos = json.infos;
                    var sigs = json.sigs;
                    var midArray = mids.split(",");
                    var infoArray = infos.split(",");
                    var sigArray = sigs.split(",");
                    USER.writeMemberIdRadio(json.num, midArray, infoArray, sigArray, json.toUrl, json.age);
                } else {
                    USER.showLoginForm(url, submitForumId, data, doFunc, funcParaArray);
                }
            } else {
                var dmbi = json.dmbi;
                var info = json.info;
                var age = json.age;
                var to = json.url;

                var _frm = document.createElement("iframe");
                _frm.style.display = "none";
                _frm.src = "http://my.d.cn/setcookie.html?type=add&dmbi=" + dmbi + "&info=" + info + "&age=" + age;
                document.body.appendChild(_frm);
                if (_frm.attachEvent) {
                    _frm.attachEvent("onload", USER.test(url, submitForumId, doFunc, funcParaArray));
                } else {
                    _frm.addEventListener("load", USER.test(url, submitForumId, doFunc, funcParaArray), false);
                }
            }
        }
    },
    test: function(url, submitForumId, doFunc, funcParaArray) {
        if (url != null && url.length > 0) {
            window.location.href = url;
        } else if (submitForumId != null && submitForumId.length > 0) {
            $("#" + submitForumId).submit();
        } else if (doFunc != null) {
            doFunc(funcParaArray[0], funcParaArray[1], funcParaArray[2], funcParaArray[3], funcParaArray[4]);
        } else {
            window.location.reload();
        }
    },
    weiboLogin: function() {
        WB2.login(function() {
            WB2.anyWhere(function(W) {
                W.parseCMD("/account/get_uid.json", function(sResult, bStatus) {
                    if (bStatus == true) {
                        var accessToken = USER.getCookie('weibojs_1936015137').split('&')[0].split('=')[1];
                        $.ajax({
                            async: true,
                            url: "http://d.cn/connect/weibo/trylogin",
                            type: "GET",
                            dataType: 'jsonp',
                            jsonp: 'jsoncallback',
                            data: {
                                uid: sResult.uid,
                                token: accessToken
                            },
                            success: function(json) {
                                var msg = json[0].msg;
                                if (msg.length != 0) { // 濡傛灉鏈夐敊璇俊鎭�
                                    alert(msg);
                                    return;
                                }
                                var dmbi = json[0].dmbi;
                                var to = json[0].url;
                                if (dmbi) {
                                    var info = json[0].info;
                                    var age = json[0].age;
                                    var _frm = document.createElement("iframe");
                                    _frm.style.display = "none";
                                    _frm.src = "http://my.d.cn/setcookie.html?type=add&dmbi=" + dmbi + "&info=" + info + "&age=" + age;
                                    document.body.appendChild(_frm);
                                    if (_frm.attachEvent) {
                                        _frm.attachEvent("onload", redirectURL(to));
                                    } else {
                                        _frm.addEventListener("load", redirectURL(to), false);
                                    }
                                } else {
                                    redirectURL(to);
                                }
                            },
                            error: function(xhr) {
                                alert("\u8bf7\u6c42\u51fa\u9519(\u8bf7\u68c0\u67e5\u76f8\u5173\u5ea6\u7f51\u7edc\u72b6\u51b5.)");
                            }
                        });
                    }
                }, {}, {
                    method: 'get'
                });
            });
        });
    },
    logout: function() {
        $.ajax({
            async: true,
            url: "http://d.cn/connect/dj/logout",
            type: "GET",
            dataType: 'jsonp',
            jsonp: 'jsoncallback',
            data: {},
            success: function(json) {
                $.ajax({
                    async: true,
                    url: "http://my.d.cn/setcookie.html",
                    type: "GET",
                    dataType: 'jsonp',
                    jsonp: 'jsoncallback',
                    data: {
                        type: 'remove'
                    },
                    success: function(json) {
                        try {
                            QC.Login.signOut();
                            if (WB2.checkLogin()) {
                                WB2.logout(function() {
                                });
                            }
                        } catch (e) {
                            var url = document.URL;
                            if (url.indexOf("my.d.cn") >= 0) {
                                url = 'http://my.d.cn/';
                            }
                            window.location.href = url;
                        }
                        var url = document.URL;
                        if (url.indexOf("my.d.cn") >= 0) {
                            url = 'http://my.d.cn/';
                        }
                        window.location.href = url;
                    }
                });
            }
        });
    },
    getCookie: function(name) { // 鍙朿ookies鍑芥暟
        var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
        if (arr != null)
            return decodeURI(unescape(arr[2], 'utf-8'));
        return null;
    } 
};
(function ($) {
    $.overlay = function (param) {
        var opts = $.extend({}, $.overlay.defaults, param),
		    clickElem = opts.clickId,
			windowElem = $("#" + opts.contentId),
			closeElem = $("#" + opts.closeId),
			overlay=$("#overlay"),
			height =document.body.clientHeight + "px";
        function windowHide() {
            overlay.hide(); 
            windowElem.css("visibility","hidden");
        }
		function overlaySize() { 
			overlay.css({ "height": height });
		}
        $(clickElem).unbind("click").bind("click", function () {
            overlay.show();
            overlay.css({ "height": height });
            windowElem.css({"left":"50%","visibility":"visible"});
        });
        $(window).resize(function () {
            overlaySize();
        });
		$(window).bind("scroll",function(){
		  overlaySize();
		});
        closeElem.unbind("click").bind("click", function (e) {
            windowHide();
            $("#login-reg-msg").text("");
        });
    };
    $.overlay.defaults = {
        clickId: "#demo",
        contentId: "windows",
        closeId: "close"
    };
})(jQuery);
var Adapt={
    $siteA:$("#site-adapt"),
    $dbW:$("#db-w"),
    $brand:$("#brand"),
    $type:$("#type"),
    $bVal:$("#brandValue"),
    $tVal:$("#typeValue"),
    //$area:$("p.set-area"),
    $mName:$("span.m-name"),
    $adaptBtn:$("#adpatation"),
    $pack:$("#pkgDownloadUrl"),
	$cpu:"",
    $array:"",
	//reqPrefix:"",
	dami:getCookie("dami"),
	damiInfo:unescape(String(getCookie("damiInfo")).replace(/\\/g, "%")),  
	ifLog:(getCookie("DJ_MEMBER_INFO") && getCookie("dmbi"))?true:false,
	init:function(){
		var len,
		    di=Adapt.damiInfo;
		if(di){
			if( di!="other"){
				Adapt.$array=di.split("#"),
			    Adapt.$cpu=di?Adapt.$array[2]:'';
			    //鏀瑰彉澶撮儴鐨勫嚱鏁�
			    Adapt.topArea(di,Adapt.$array[0],Adapt.$array[1]);
			    if(Adapt.$pack.length>0){
			    	len=eval(Adapt.$pack.html()).length;
					if(len>1){
						Adapt.$adaptBtn.hide();
						Adapt.$dbW.show();
						//Adapt.$area.html(Adapt.areaHtml(di,Adapt.$array[0],Adapt.$array[1]));//纭畾璁剧疆鏈哄瀷鍏ュ彛HTML
						Adapt.adaptLink(Adapt.$cpu);
					}	
			    }
			}else{
	            Adapt.topArea(false);
	            if(Adapt.$pack.length>0 && eval(Adapt.$pack.html()).length>1){
				   Adapt.showAll();
	            }
			}
		}else{ return true;}
	    //$.overlay({ clickId: ".set-adapt", contentId: "adapt", closeId: "atClose" });
	},
	topArea:function(ifCook,a,b){
	   a=a||"";
	   b=b||"";
       var  html="";
	   if(ifCook){
			html+='鏈哄瀷锛�<span class="m-name">'+a+' '+b+'</span>';
			html+='<a class="set-adapt" href="javascript:" title="璁剧疆鏈哄瀷">';
			html+='(淇敼)</a>';
			Adapt.$bVal.html(a);
			Adapt.$tVal.html(b);
			$(".at-name").html(a+" "+b);
		}else{
		    html='<a class="set-adapt" href="javascript:">璁剧疆鏈哄瀷</a>'; 
		}
	   Adapt.$siteA.html(html);
	},
//	areaHtml:function(ifCook,a,b){ //璁剧疆鏈哄瀷灞曠ず
//	    var aHtml="";
//		if(ifCook){
//			aHtml+='鎮ㄧ殑鏈哄瀷鏄細<span class="m-name">'+a+b+'</span>';
//			aHtml+='<a class="set-btn set-adapt" href="javascript:" title="璁剧疆鏈哄瀷">';
//			aHtml+='(淇敼)</a>';
//			Adapt.$bVal.html(a);
//			Adapt.$tVal.html(b);
//			$("#adapt .at-name").html(a+b);
//		}else{
//		    aHtml='<a class="set-m set-adapt" href="javascript:">璁剧疆鏈哄瀷鍙互鑾峰彇鎸囧畾搴斿寘,绔嬪嵆璁剧疆!</a>'; 
//		}
//		return aHtml;
//	},
	setAdapt:function(ifLog){ //
	   var $bValT=Adapt.$bVal.html(),
	       $tValT=Adapt.$tVal.html(),
	       len,
		   cpu=Adapt.$cpu;
	   if($bValT=="璇烽€夋嫨" || $tValT=="璇烽€夋嫨"){
	       return false;
	   }else{
	       if(ifLog){
			   $.ajax({
			       type:"POST",
				   url:reqPrefix+'/asych/addModel',
			       data:{
			    	   dami:Adapt.dami,
			    	   brand:$bValT,
			    	   model:$tValT
			       },
			       success:function(){
			    	   return true;
			       }
			   });
		   }
		   SetCookie("damiInfo",escape($bValT+"#"+$tValT+"#"+cpu));
		 //鏀瑰彉澶撮儴鐨勫嚱鏁�
		   Adapt.topArea(true,$bValT,$tValT);
           if(Adapt.$pack.length>0){
			   len=eval(Adapt.$pack.html()).length;
			   if(len>1){
				  // Adapt.$area.html(Adapt.areaHtml(true,$bValT,$tValT)); 
				   Adapt.adaptLink(cpu);
				   Adapt.$adaptBtn.hide();
				   $("#db-w").show();
			   }
		   }
		   $.overlay({ clickId: ".set-adapt", contentId: "adapt", closeId: "atClose" });
	   }
	},
	adapt:function(){
		$("#adapt .at-name").html("");
	   $.ajax({
    		type:"GET",
    		dataType:"json",
    		url:reqPrefix+'/asych/lsmodelbrand',
    		success:function(data){
    			var len=data.length,
    			    html="";
    			for(var i=0;i<len;i++){
    					html+='<li><a href="javascript:">'+data[i].value+'</a></li>';
    			}
    			$("#brandUl").html(html);
    			Adapt.$brand.scrollBar();//璁剧疆婊氬姩鏉�
				//if($("#db-w").length>0){
    			  // Adapt.$area.html(Adapt.areaHtml(true,Adapt.$array[0],Adapt.$array[1]));
				//}
    		}
    	});
    	if(Adapt.$bVal.html()!="璇烽€夋嫨"){//濡傛灉鏈夐粯璁ょ殑鍝佺墝锛屽氨鍘昏姹傛満鍨�
	    	$.ajax({
			    type:"GET",
				url:reqPrefix+'/asych/lsmodel?brand='+Adapt.$bVal.html(),
				dataType:"json",
				success:function(data){
					var len=data.length,
					    html="";
					for(var i=0;i<len;i++){
						html+='<li cpu="'+data[i].cpu+'"><a href="javascript:">'+data[i].modelName+'</a></li>';
					}
					$("#typeUl").html(html);
					Adapt.$type.scrollBar({showCont:"typeLi",tri:"typeTri"});
					$("#adapt .at-name").html(Adapt.$bVal.html()+" "+Adapt.$tVal.html());
			    }	 
			 });
	    }
    	$("#atSubmit").unbind("click").bind("click",function(){Adapt.setAdapt(Adapt.ifLog); $("#adapt").css("visibility","hidden"); $("#overlay").hide();});//瀹屾垚鎸夐挳浜嬩欢缁戝畾
    	$("#atNot").unbind("click").bind("click",function(){ Adapt.noAdapt(); $("#adapt").css("visibility","hidden"); $("#overlay").hide();});//娌℃壘鍒版満鍨嬫寜閽簨浠�
	},
	adaptLink:function(cpu){
		var packAll=eval(Adapt.$pack.html()),
		    packLen=packAll.length,
		    index=[],
		    $dbw=$("#db-w"),//鏈€澶栧眰鐨勫畾浣嶆
		    $db1=$dbw.find(".downbtn1"),
		    $db2=$dbw.find(".downbtn2"),
		    html="",
		    iHtml="",
		    url,
		    packId,
		    local,
		    wdj;
		    //$qrc=$("#db-dim");
			 for(var i=0;i<packLen;i++){
				// (function(i){
				 if((packAll[i].cpu).indexOf(cpu)!=-1){
						index[index.length]=packAll[i];
				 }
				// })(i);
			 }
             try{
            	 if(index.length==1){
                     url=index[0].url;
                     packId=index[0].i;
                     local=reqPrefix+url[0].value;
                     wdj=(url[1].value).split("?")[1];
                       //  u360='zhushou360://type=apk&name='+packAll[0].name+'&refer=34&url='+url[2].value.split("?")[1],
                        // qq=(url[3].value).split("?")[1];
                         //qrc=Adapt.reqPrefix+'/qrcode/-'+url[4].value;                   
                         html+='<a class="btn-down" title="鏈湴涓嬭浇" href="'+local+'">绔嬪嵆涓嬭浇</a>';
                         iHtml+='<a class="btn-down" title="浣跨敤璞岃眴鑽氫竴閿畨瑁呭埌鎵嬫満" onclick="logPV(1, 2362, '+packId+',\'wdj\',0);return wdapi_apkdl_m(this,\'api_303\');"';
                         iHtml+='name="'+index[0].name+'" href="'+wdj+'">瀹夎鍒版墜鏈�</a>';
                         //iHtml+='<a class="db-btn db-360" title="浣跨敤360鎵嬫満鍔╂墜涓€閿畨瑁呭埌鎵嬫満"';
                        // iHtml+='onclick="logPV(1, 2362, ,\'qihu\',0)" href="'+u360+'">360鎵嬫満鍔╂墜</a>';
                        // iHtml+='<a class="db-btn db-qq" title="浣跨敤鑵捐鎵嬫満绠″涓€閿畨瑁呭埌鎵嬫満"';
                         //iHtml+='appicon="http://img.android.d.cn/android/new/game_image/62/2362/icon.png" asistanturl=""';
                        // iHtml+='asistanturlid="990464" appname="'+packAll[index].name+'"';
                        // iHtml+='ex_url="'+qq+'" onclick="logPV(1, 2362, 13460,\'tencent\',0);qqapp_dl_apk(this);" href="javascript:">QQ鎵嬫満绠″</a>';
                         $db1.html(html);
                         $db2.html(iHtml);
                 } else if(index.length>1){
                	 html+='<a class="btn-down" href="javascript:">涓嬭浇鍒扮數鑴�</a>';
                	 html+='<div class="downbtn-box db-b1"><p class="db-padding clearfix">';
                	 iHtml+='<a class="btn-down" href="javascript:">瀹夎鍒版墜鏈�</a>';
                	 iHtml+='<div class="downbtn-box db-b2"><p class="db-padding clearfix">';
                	 for(var j=0;j<index.length;j++){ 
                		 local=(index[j].url[0]).value;
                		 wdj=((index[j].url[1]).value).split("?")[1];
                		 html+='<a class="db-btn" title="'+index[j].name+'" href="'+local+'">'+index[j].name+'</a>';
                		 iHtml+='<a class="db-btn db-wandou" title="'+index[j].name+'" onclick="logPV(1, 2362, '+index[j].id+',\'wdj\',0);return wdapi_apkdl_m(this,\'api_303\');"';
                         iHtml+='name="'+index[j].name+'" href="'+wdj+'">'+index[j].name+'</a>';
                	 }
                	 html+='</p></div>';
                	 iHtml+='</p></div>';
                	 $db1.html(html);
                     $db2.html(iHtml);
                 }else if(index.length==0){
                	 Adapt.showAll();
                 }
             }
             catch(e){}									
	},
	noAdapt:function(){
		 SetCookie("damiInfo",escape("other"));
		 Adapt.$bVal.html("璇烽€夋嫨");
		 Adapt.$tVal.html("璇烽€夋嫨");
		 $("#adapt .at-name").html("");
         Adapt.topArea(false);
		 if(Adapt.$pack.length>0 && eval(Adapt.$pack.html()).length>1 ){
			 Adapt.showAll(); 
		 } else{
             $.overlay({ clickId: ".set-adapt", contentId: "adapt", closeId: "atClose" });
         }
	},
	showAll:function(){
		var downWrap=Adapt.$dbW,
		    $db1=downWrap.find(".downbtn1"),
		    $db2=downWrap.find(".downbtn2"),
		    html="",
		    iHtml="",
		    packAll=eval(Adapt.$pack.html()),
		    packLen=packAll.length,
		    req=reqPrefix;
		Adapt.$adaptBtn.hide();
		downWrap.show();
        $.overlay({ clickId: ".set-adapt", contentId: "adapt", closeId: "atClose" });
		//Adapt.$area.html(Adapt.areaHtml(false));
        html+='<a class="btn-down" href="javascript:">涓嬭浇鍒扮數鑴�</a>';
	   	 html+='<div class="downbtn-box db-b1"><p class="db-padding clearfix">';
	   	 iHtml+='<a class="btn-down" href="javascript:">瀹夎鍒版墜鏈�</a>';
	   	 iHtml+='<div class="downbtn-box db-b2"><p class="db-padding clearfix">';
		for(var i=0;i<packLen;i++){
			var url=packAll[i].url,
            local=req+url[0].value,
            wdj=(url[1].value).split("?")[1];
			html+='<a class="db-btn" title="鏈湴涓嬭浇" href="'+local+'">'+packAll[i].name+'</a>';
			iHtml+='<a class="db-btn db-wandou" title="'+packAll[i].name+'" onclick="logPV(1, 2362, 13460,\'wdj\',0);return wdapi_apkdl_m(this,\'api_303\');" href="'+wdj+'">'+packAll[i].name+'</a>';
		}
		html+='</p></div>';
   	    iHtml+='</p></div>';
   	    $db1.html(html);
        $db2.html(iHtml);
	}
};
(function($){
	$.fn.scrollBar=function(opts){
	   opts=opts||{};
	   var t=$(this),
		   defaults={
			   showCont:"brandLi",
			   tri:"brandTri"
		   },
	   isOut;
	   opts=$.extend(defaults,opts);
	   var $show=$("#"+opts.showCont),
		   $tri=$("#"+opts.tri),
		   $allInput=$(".at-input"),
		   $allShow=$(".at-li"),
		   isOut;
	   function init(){
		  setEvents();
	   }
	   $allInput.hover(function(){
		   isOut=false;	
		},function(){
		  isOut=true;	
	    });
	   function showCont(){
		   $show.show().tinyscrollbar();
	   }
	   function hide(){
	       $allShow.hide();
	   }
	   function setEvents(){
		  $(document).unbind("click").bind('click',function(){
			  if(isOut){
			    hide();
			  } 
		  });
		  t.find(".at-value").unbind("click").bind('click',function(){
				   showCont();
				 });
		  $tri.unbind("click").bind("click",function(){
			   if($show.css("display")=="none"){
				  hide();
                  showCont();
			   }else{
			      hide();
			   }
			 }); 
		  $show.find("li").unbind("click").bind("click",function(){
			  var txt=$(this).find("a").text();
		      t.find(".at-value").html(txt);
			  hide();
			  if(opts.showCont=="brandLi"){
			     $.ajax({
				    type:"GET",
					url:reqPrefix+'/asych/lsmodel?brand='+txt,
					dataType:"json",
					success:function(data){
						var len=data.length,
						    html="";
                        if(len!=0){
                            for(var i=0;i<len;i++){
                                html+='<li cpu="'+data[i].cpu+'"><a href="javascript:">'+data[i].modelName+'</a></li>';
                            }
                            Adapt.$tVal.html(data[0].modelName);
                            Adapt.$cpu=data[0].cpu;
                            $("#typeUl").html(html);
                            Adapt.$type.scrollBar({showCont:"typeLi",tri:"typeTri"});
                            $("#adapt .at-name").html(Adapt.$bVal.html()+" "+Adapt.$tVal.html());
                        }  else{
                        	Adapt.$tVal.html("璇烽€夋嫨");
                            $("#typeUl").html("");
                        }
				    }	 
				 });
			  }else{
			       $("#adapt .at-name").html(Adapt.$bVal.html()+' '+Adapt.$tVal.html());
			       Adapt.$cpu=$(this).attr("cpu");
			  }
		  })
	   }
	   return init();
	}
})(jQuery)
$(function(){
    $("#form1").submit(function(){
        var searchKey = $("#searchKeyword").val();
        $(this).attr("action","/search/app/?keyword="+encodeURI(searchKey));
        return searchSubmit();
    });
   //try{
	    Adapt.init();
		$.overlay({ clickId: ".set-adapt", contentId: "adapt", closeId: "atClose" });
	    $(".set-adapt").click(function(){
	    	Adapt.adapt();
	    });
   // }
    //catch(e){}
    $("ul.rank-ul li").mouseover(function(){
		 var t=$(this),
		     varImg=t.find("img[data-original]");
		 if(varImg.length>0){
			 varImg.attr("src",varImg.attr("data-original")).removeAttr("data-original");
		 }
		 t.addClass("hover").siblings().removeClass("hover");
		 
	});
    $("#roll-btn-l").hover(function(){
    	$(this).addClass("roll-hover-l");
    },function(){
    	$(this).removeClass("roll-hover-l");
    });
    $("#roll-btn-r").hover(function(){
    	$(this).addClass("roll-hover-r");
    },function(){
    	$(this).removeClass("roll-hover-r");
    });
})
