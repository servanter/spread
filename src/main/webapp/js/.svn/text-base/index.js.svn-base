// JavaScript Document
/* 初始化数据 */
//var ajaxHead=()?"djwebandroid":"";

/* 下载时间 */
function delayJsonDate() {
    var randomNum = parseInt(Math.random() * (2 - 0 + 1) + 0);
    var str = randomNum + "秒前";
    return str;
}

function writeDownloadHtml(data) {
    var list = data;
    var size = list.length;
    var str = "";
    for ( var i = 1; i <= (size >= 20 ? 20 : size); i++) {
        var resource = list[i - 1];
        var resourceTypeStr = "";
        if (resource.categoryTO.resourceType == 2) {
            resourceTypeStr = "software";
        } else if (resource.categoryTO.resourceType == 3) {
            resourceTypeStr = "news";
        } else if (resource.categoryTO.resourceType == 4) {
            resourceTypeStr = "flash";
        } else if (resource.categoryTO.resourceType == 5) {
            resourceTypeStr = "netgame";
        } else {
            resourceTypeStr = "game";
        }
        str += '';
        str += '<li class="down-now">';
        str += '  <a href="/' + resourceTypeStr + '/' + resource.id + '.html" title="' + resource.name + '" target="_blank">';
        str += '<img src="' + resource.icon + '" alt="' + resource.name + '" />';
        str += ' <p class="down-time">' + delayJsonDate() + '</p><p>' + resource.name + ' </p>';
        str += '  </a>';
        str += '</li>';
    }
    $("#down-now>ul").append(str);
}
function subScript(data,language,time){
	var dataType=data&2,
	    dataSf=data&8,
	    now=new Date(),
	    creatTime,
	    html="";
	creatTime=Math.round((now.getTime()-time)/1000/60/60/24);
	if(dataSf==8 && time<=5){
		html='<span class="sub-icon sub-sf"></span>';
	}else if(dataType==2){
		html='<span class="sub-icon sub-bt"></span>';
	}else if(language==0){
		html='<span class="sub-icon sub-zw"></span>';
	}
	return html;
}
function setTab(type,mode,tab){
  var url="",
      resource="",
	  rMode=["new","hot","good","stars"],
	  showCont,
      ajaxNot=true,
      firstCont="new";
  $(tab).addClass("curr").siblings().removeClass("curr");
  switch(type){
     case 1:
	     url=reqPrefix+"/asych/lsresource?rt="+type+"&st="+mode;
		 resource="game";
		 break;
	 case 2:
		 url=reqPrefix+"/asych/lsresource?rt="+type+"&st="+mode;
		 resource="software";
		 break;
	 case 5:
	     url=reqPrefix+"/asych/lsnetgame?rt=5&st="+mode;
		 resource="netgame";
         firstCont="hot" ;
		 break;
	 default:
	     break;
  }
  showCont=$("#"+rMode[mode-1]+resource);
  showCont.show().siblings(".thumb-wrap").hide();
	if((type==5&&mode==2)||(type!=5&&mode==1)){
	    ajaxNot=false;
	}
  if(ajaxNot){
	  showCont.addClass("tab-load");
	  $.ajax({
		url:url,
		type:'GET',
		dataType:"json",
		success:function(data){
			showCont.removeClass("tab-load").html(writeHtml(data,mode,resource));
            $(".th-grid li").hover(function() {
                    $(this).addClass("th-hover");
                },
                function() {
                    $(this).removeClass("th-hover");
                });
		}
	  });
  } else{
    $("#"+firstCont+resource).show().siblings(".thumb-wrap").hide();
  } 
}
function writeHtml(data,mode,resource){
  var html="";
  html+=spellHtml(data, mode,0,resource)+spellHtml(data, mode,6,resource);
  html+=spellHtml(data, mode,12,resource);
  return html;
}
function spellHtml(data, mode,num,resource){
   var html="";
   html+='<ul class="th-grid">';
   for(var i=num;i<num+6;i++){
	   var lbHtml="",
	       liClass="",
		   appName=data[i].name,
		   appHref="",
		   enName,
           icon,
           subHtml="";
	   if(resource=="netgame"){
	      appHref="/"+data[i].pinyin;
		  enName=data[i].tagNames;
          icon=data[i].hdIcon;
	   } else{
	      appHref='/'+resource+'/'+data[i].id+'.html';
		  enName=(data[i].enName!="")?data[i].enName:data[i].categoryTO.name;
          icon=data[i].icon;
	   }
	   subHtml=subScript(data[i].dataType,data[i].languageType,data[i].gCreatedDate);
	   switch(mode){
		  case 2:
		   lbHtml='<span class="detail-hot">'+data[i].hotCnt+'℃</span>';
		   break;
		  case 3:
		   lbHtml='<span class="detail-up detail-high fr">'+data[i].goodRatingCnt+'</span>';
		   break;
		  case 4:
		   lbHtml='<span class="detail-new d-5f fr"><span class="index-tag fr">更新</span>'+data[i].updateTimeStr+'</span>'
		   break;
		  default:
              lbHtml='<span class="detail-new d-5f fr"><span class="index-tag fr">更新</span>'+data[i].updateTimeStr+'</span>'
	   }
	   if(i==5||i==11||i==17){
		  liClass="thumb";
	   } else liClass="thumb m29";
	   html+='<li class="'+liClass+'">';
	   html+='<a class="th-a" title="'+appName+'" target="_blank"';
	   html+='href="'+appHref+'">'+subHtml;
	   html+='<img alt="'+appName+'" src="'+icon+'" /></a>';
	   html+='<a class="th-txt" title="'+appName+'" target="_blank"';
	   html+='href="'+appHref+'">'
	   html+=appName+'</a>';
	   html+='<div class="th-detail detail-tips"><div class="th-m">';
	   html+='<a class="detail-tit" title="'+appName+'" target="_blank"';
	   html+='href="'+appHref+'">';
	   html+=appName+'</a>';
	   html+='<p class="detail-en d-5f">'+enName+'</p>';
	   html+='<p class="d-b0">'+data[i].publishDateFormat+'&nbsp;|&nbsp;';
	   html+=data[i].fileSizeFormatShort+'&nbsp;|&nbsp;v'+data[i].latestVersionNameFormatShort+'</p></div>';
	   html+='<div class="detail-bottom"><span class="fl star star'+data[i].stars+'"></span>';
	   html+=lbHtml+'</div></div></li>';
   }
   html+='</ul>';
   return html;
}
(function($) {
    $.fn.extend({
        Scroll: function(opts, callback) {
            opts = opts || {};
            var _this = this.find("ul"),
            lineH = _this.find("li:first").height(),
            line = opts.line ? parseInt(opts.line) : parseInt(this.height() / lineH),
            speed = opts.speed ? parseInt(opts.speed) : 500,
            timer = opts.timer ? parseInt(opts.timer) : 3000;
            if (line == 0) line = 1;
            var downHeight = 0 - line * lineH;
            scrollDown = function() {
                for (var i = 1; i <= line; i++) {
                    _this.find("li:last").prependTo(_this);
                }

                _this.css({
                    marginTop: downHeight
                });
                _this.animate({
                    marginTop: 0
                },
                speed);
            }
            _this.hover(function() {
                clearInterval(timerID);
            },
            function() {
                timerID = setInterval(scrollDown, timer);
            }).trigger("mouseout");
        },
		InvSlide:function(opts,callback){
			opts = opts || {};
			var defaults = {
				imgEl: ".focus li",
				autoPlay: true,
				speed: 4000,
				indexBar: true,
				initIndex: 0
			};
			opts = $.extend(defaults, opts);
			this.each(function() {
				var $This = $(this),
				banner,
				//移动的区域
				length,
				//总的数目
				timer,
				nowzIndex,
				//当前的z-index
				h,//当前的index
				indexBarSpan,
				//切换按钮
				fadeTimer,
				l;
				banner = $This.find(opts.imgEl);
				length = banner.length;
				nowzIndex = (!this.style.zIndex ? 0 : parseInt(this.style.zIndex));
				h = opts.initIndex;
				for (var i = 0; i < length; i++) { (function(i) {
						banner[i].style.zIndex = length + nowzIndex - i;
					})(i);
				}
				init();
				if (opts.autoPlay) {
					timer = setInterval(function() {
						h = h < length - 1 ? h + 1 : 0;
						show(h);
					},
					opts.speed);
				}
				function init() {
					var html;
					if (opts.indexBar) {
						html = '<div class="focus-bd" style="z-index:' + (nowzIndex + length + 10) + '">';
						for (var j = 0; j < length; j++) {
							html += '<span class="focus-btn ' + (j == 0 ? 'curr">': '">') + '</span>';
						}
						html += '</div>';
						$("#focusBd").append(html);
						indexBarSpan = $This.find("div.focus-bd>span");
						indexBarSpan.hover(function() {
							if (opts.autoPlay) {
								clearInterval(timer);
							}
							h = indexBarSpan.index($(this));
							if (!$(this).hasClass("curr")) {
								show(h);
							}
						},
						function() {
							if (opts.autoPlay) {
								timer = setInterval(function() {
									h = h < length - 1 ? h + 1 : 0;
									show(h);
								},
								opts.speed);
							}
						});
					}
				}
				function show(index) {
					var x, w;
					clearInterval(fadeTimer);
					for (x = 0; x < length; x++) {
						if (x != index) {
							w = parseInt(banner[x].style.zIndex);
							banner[x].style.zIndex = w > nowzIndex + 1 ? w - 1 : nowzIndex + 1;
							banner[x].style.opacity = 1;
							banner[x].style.filter = "alpha(opacity=100)";
						}
					}
					banner[index].style.opacity = 0;
					banner[index].style.filter = "alpha(opacity=0)";
					banner[index].style.zIndex = length + nowzIndex;
					l = 0;
					fadeTimer = setInterval(function() {
						inOut(banner[index]);
					},
					22);
					if (opts.indexBar) {
						indexBarSpan.removeClass("curr");
						indexBarSpan.eq(index).addClass("curr");
					}
				}
				function inOut(i) {
					l += !document.all ? 4 : 7;
					i.style.opacity = l / 100;
					i.style.filter = "alpha(opacity=" + l + ")";
					if (l > 100) {
						clearInterval(fadeTimer);
					}
				}
			});
		}
    });
})(jQuery);
//JavaScript Document
var sina = {
  $ : function(objName) {
    if (document.getElementById) {
      return eval('document.getElementById("' + objName + '")')
    } else {
      return eval('document.all.' + objName)
    }
  },
  isIE : navigator.appVersion.indexOf("MSIE") != -1 ? true : false,
  addEvent : function(l, i, I) {
    if (l.attachEvent) {
      l.attachEvent("on" + i, I)
    } else {
      l.addEventListener(i, I, false)
    }
  },
  delEvent : function(l, i, I) {
    if (l.detachEvent) {
      l.detachEvent("on" + i, I)
    } else {
      l.removeEventListener(i, I, false)
    }
  },
  readCookie : function(O) {
    var o = "", l = O + "=";
    if (document.cookie.length > 0) {
      var i = document.cookie.indexOf(l);
      if (i != -1) {
        i += l.length;
        var I = document.cookie.indexOf(";", i);
        if (I == -1)
          I = document.cookie.length;
        o = unescape(document.cookie.substring(i, I))
      }
    }
    ;
    return o
  },
  writeCookie : function(i, l, o, c) {
    var O = "", I = "";
    if (o != null) {
      O = new Date((new Date).getTime() + o * 3600000);
      O = "; expires=" + O.toGMTString()
    }
    ;
    if (c != null) {
      I = ";domain=" + c
    }
    ;
    document.cookie = i + "=" + escape(l) + O + I
  },
  readStyle : function(I, l) {
    if (I.style[l]) {
      return I.style[l]
    } else if (I.currentStyle) {
      return I.currentStyle[l]
    } else if (document.defaultView && document.defaultView.getComputedStyle) {
      var i = document.defaultView.getComputedStyle(I, null);
      return i.getPropertyValue(l)
    } else {
      return null
    }
  }
};

// 滚动图片构造函数
// UI&UE Dept. mengjia
// 080623
function ScrollPic(scrollContId, arrLeftId, arrRightId, dotListId) {
  this.scrollContId = scrollContId;
  this.arrLeftId = arrLeftId;
  this.arrRightId = arrRightId;
  this.dotListId = dotListId;
  this.dotClassName = "dotItem";
  this.dotOnClassName = "dotItemOn";
  this.dotObjArr = [];
  this.pageWidth = 0;
  this.frameWidth = 0;
  this.speed = 10;
  this.space = 10;
  this.pageIndex = 0;
  this.autoPlay = true;
  this.autoPlayTime = 5;
  var _autoTimeObj, _scrollTimeObj, _state = "ready";
  this.stripDiv = document.createElement("DIV");
  this.listDiv01 = document.createElement("DIV");
  this.listDiv02 = document.createElement("DIV");
  if (!ScrollPic.childs) {
    ScrollPic.childs = []
  }
  ;
  this.ID = ScrollPic.childs.length;
  ScrollPic.childs.push(this);
  this.initialize = function() {
    if (!this.scrollContId) {
      throw new Error("必须指定scrollContId.");
      return
    }
    ;
    this.scrollContDiv = sina.$(this.scrollContId);
    if (!this.scrollContDiv) {
      throw new Error("scrollContId不是正确的对象.(scrollContId = \""
          + this.scrollContId + "\")");
      return
    }
    ;
    this.scrollContDiv.style.width = this.frameWidth + "px";
    this.scrollContDiv.style.overflow = "hidden";
    this.listDiv01.innerHTML = this.listDiv02.innerHTML = this.scrollContDiv.innerHTML;
    this.scrollContDiv.innerHTML = "";
    this.scrollContDiv.appendChild(this.stripDiv);
    this.stripDiv.appendChild(this.listDiv01);
    this.stripDiv.appendChild(this.listDiv02);
    this.stripDiv.style.overflow = "hidden";
    this.stripDiv.style.zoom = "1";
    this.stripDiv.style.width = "32766px";
    this.listDiv01.style.cssFloat = "left";
    this.listDiv02.style.cssFloat = "left";
    sina.addEvent(this.scrollContDiv, "mouseover", Function("ScrollPic.childs["
        + this.ID + "].stop()"));
    sina.addEvent(this.scrollContDiv, "mouseout", Function("ScrollPic.childs["
        + this.ID + "].play()"));
    if (this.arrLeftId) {
      this.arrLeftObj = sina.$(this.arrLeftId);
      if (this.arrLeftObj) {
        sina.addEvent(this.arrLeftObj, "mousedown",
            Function("ScrollPic.childs[" + this.ID + "].rightMouseDown()"));
        sina.addEvent(this.arrLeftObj, "mouseup", Function("ScrollPic.childs["
            + this.ID + "].rightEnd()"));
        sina.addEvent(this.arrLeftObj, "mouseout", Function("ScrollPic.childs["
            + this.ID + "].rightEnd()"))
      }
    }
    ;
    if (this.arrRightId) {
      this.arrRightObj = sina.$(this.arrRightId);
      if (this.arrRightObj) {
        sina.addEvent(this.arrRightObj, "mousedown",
            Function("ScrollPic.childs[" + this.ID + "].leftMouseDown()"));
        sina.addEvent(this.arrRightObj, "mouseup", Function("ScrollPic.childs["
            + this.ID + "].leftEnd()"));
        sina.addEvent(this.arrRightObj, "mouseout",
            Function("ScrollPic.childs[" + this.ID + "].leftEnd()"))
      }
    }
    ;
    if (this.autoPlay) {
      this.play()
    }
  };
  this.leftMouseDown = function() {
    if (_state != "ready") {
      return
    }
    ;
    _state = "floating";
    _scrollTimeObj = setInterval(
        "ScrollPic.childs[" + this.ID + "].moveLeft()", this.speed)
  };
  this.rightMouseDown = function() {
    if (_state != "ready") {
      return
    }
    ;
    _state = "floating";
    _scrollTimeObj = setInterval("ScrollPic.childs[" + this.ID
        + "].moveRight()", this.speed)
  };
  this.moveLeft = function() {
    if (this.scrollContDiv.scrollLeft + this.space >= this.listDiv01.scrollWidth) {
      this.scrollContDiv.scrollLeft = this.scrollContDiv.scrollLeft
          + this.space - this.listDiv01.scrollWidth
    } else {
      this.scrollContDiv.scrollLeft += this.space
    }
    ;
  };
  this.moveRight = function() {
    if (this.scrollContDiv.scrollLeft - this.space <= 0) {
      this.scrollContDiv.scrollLeft = this.listDiv01.scrollWidth
          + this.scrollContDiv.scrollLeft - this.space
    } else {
      this.scrollContDiv.scrollLeft -= this.space
    }
    ;
  };
  this.leftEnd = function() {
    if (_state != "floating") {
      return
    }
    ;
    _state = "stoping";
    clearInterval(_scrollTimeObj);
    var fill = this.pageWidth - this.scrollContDiv.scrollLeft % this.pageWidth;
    this.move(fill)
  };
  this.rightEnd = function() {
    if (_state != "floating") {
      return
    }
    ;
    _state = "stoping";
    clearInterval(_scrollTimeObj);
    var fill = -this.scrollContDiv.scrollLeft % this.pageWidth;
    this.move(fill)
  };
  this.move = function(num, quick) {
    var thisMove = num / 5;
    if (!quick) {
      if (thisMove > this.space) {
        thisMove = this.space
      }
      ;
      if (thisMove < -this.space) {
        thisMove = -this.space
      }
    }
    ;
    if (Math.abs(thisMove) < 1 && thisMove != 0) {
      thisMove = thisMove >= 0 ? 1 : -1
    } else {
      thisMove = Math.round(thisMove)
    }
    ;
    var temp = this.scrollContDiv.scrollLeft + thisMove;
    if (thisMove > 0) {
      if (this.scrollContDiv.scrollLeft + thisMove >= this.listDiv01.scrollWidth) {
        this.scrollContDiv.scrollLeft = this.scrollContDiv.scrollLeft
            + thisMove - this.listDiv01.scrollWidth
      } else {
        this.scrollContDiv.scrollLeft += thisMove
      }
    } else {
      if (this.scrollContDiv.scrollLeft - thisMove <= 0) {
        this.scrollContDiv.scrollLeft = this.listDiv01.scrollWidth
            + this.scrollContDiv.scrollLeft - thisMove
      } else {
        this.scrollContDiv.scrollLeft += thisMove
      }
    }
    ;
    num -= thisMove;
    if (Math.abs(num) == 0) {
      _state = "ready";
      if (this.autoPlay) {
        this.play()
      }
      ;
      return
    } else {
      setTimeout("ScrollPic.childs[" + this.ID + "].move(" + num + "," + quick
          + ")", this.speed)
    }
  };
  this.next = function() {
    if (_state != "ready") {
      return
    }
    ;
    _state = "stoping";
    this.move(this.pageWidth, true)
  };
  this.play = function() {
    if (!this.autoPlay) {
      return
    }
    ;
    clearInterval(_autoTimeObj);
    _autoTimeObj = setInterval("ScrollPic.childs[" + this.ID + "].next()",
        this.autoPlayTime * 1000)
  };
  this.stop = function() {
    clearInterval(_autoTimeObj)
  };
  this.pageTo = function(num) {
    if (_state != "ready") {
      return
    }
    ;
    _state = "stoping";
    var fill = num * this.frameWidth - this.scrollContDiv.scrollLeft;
    this.move(fill, true)
  };
};
$(function() {
    var srctime = setInterval(function() {
        getJsonData();
    }, 59000);
    $("ul.th-grid li").hover(function() {
        $(this).addClass("th-hover");
    },
    function() {
        $(this).removeClass("th-hover");
    });
    $("#hotnetgame li").hover(function() {
        $(this).find("span.img-bg,span.img-txt").stop(true,true).slideDown(200);
    },
    function() {
    	$(this).find("span.img-bg,span.img-txt").stop(true,true).slideUp(200);
    });
	$("#banner").InvSlide();
	$("#down-now").Scroll({
		line: 1,
		speed: 500,
		timer: 2000
	});
	var scrollPic_02 = new ScrollPic();
	scrollPic_02.scrollContId = "roll";
	scrollPic_02.arrLeftId = "roll-btn-l";
	scrollPic_02.arrRightId = "roll-btn-r";
	scrollPic_02.frameWidth = 896;
	scrollPic_02.pageWidth = 896;
	scrollPic_02.speed = 8;
	scrollPic_02.space = 10;
	scrollPic_02.autoPlay = false;
	scrollPic_02.autoPlayTime = 3;
	scrollPic_02.initialize(); 
}); 
