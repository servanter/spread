<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>微信 - wechat.surroundlife.com</title>
<meta name="keywords" content="微信导航,微信公众号,微信公众平台,微信营销,微信二维码,明星微信,微信推广,微信,微信网页版" />
<meta name="description" content="微信官网最权威的微信公众平台导航网站,集微信营销、微信公众号、微信二维码、微信推广、微信导航等功能为一体的微信公众平台导航。" />
<link rel="stylesheet" href="${ctx }/css/index.css" />
<script src="${ctx }/js/slide.js"></script>
<script type="text/javascript">
	$(function() {
		$(".tipMsg").hide();
		$("input[name='hidenpassword']").focus(function() {
			$(this).hide();
			$("#password").show().focus();
		});
		$("#password").focus(function() {
			}).blur(function() {
			if($(this).val() == '') {
			$(this).hide();
			$("input[name='hidenpassword']").show();
			}
		});
		$("#loginIndexBtn").click(function(){
			$.getJSON("${ctx}/ajaxUserLogin.do?userName=" + $("input[name='userName']").val() + "&password=" + $("#password").val() + "&isCookie=" + $("#isCookie_").val(), function(data){
				if(data.returnCode == returnOk){
					$(".login_box").hide();
					$(".user_box").show();
					$("#loginUserName").text(data.userName);
					$(".tipMsg").show().hide();
				} else {
					$(".tipMsg").show().text(data.returnMsg);
				}
			});
		});
		$("#logoutIndexBtn").click(function(){
			$.get("${ctx}/ajaxUserLogout.do", function(data){
				$(".login_box").show();
				$(".user_box").hide();
				$("#password").val("");
				$("input[name='userName']").val("");
				$("input[name='hidenpassword']").focus();
				$("input[name='hidenpassword']").blur();
				$("input[name='userName']").focus();
				$("input[name='userName']").blur();
			});
		});
		
		$("#isCookie").click(function(){
			$("#isCookie_").val(1);
		})
	});
$(function () { $('.focus').slide({ slideItem: '.f-item', slideNav: '.f-nav', navSelected: 'current', itemSelected: 'active', navParent: '.f-nav-bd', effect: 'fade', speed: 200, addAutoNav: '<span class="f-nav"><\/span>' }); }); $.cookie("ios.d.cn", "", { platform: 'iphone' }, { expires: 1, path: "/", secure: false }); 
</script>
</head>

<body>
	<c:choose>
     	<c:when test="${user != null}">
     		<script type="text/javascript">
     			$(function(){
     				$(".login_box").hide();
     			})
     		</script>
     	</c:when>
     	<c:otherwise>
  			<script type="text/javascript">
	      		$(function(){
      				$(".user_box").hide();
     			})
   			</script>
     	</c:otherwise>
     </c:choose>
        
        <div class="content">
        	<div class="main_top"><img src="images/main_top.png" alt="" /></div>
            
        	<div class="main">
            	<div class="main_index fl">
                	<div class="slide_box">
                    	<div class="focus">
                        	<div class="f-bd f-501">
                        		<c:forEach var="w" items="${rec100WeChats}">
	                                <div class="f-item">
	                                    <a target="_blank" href="${ctx }/weChat/${w.id }/" title="">
	                                        <img src="${w.weResource[0].url }" class="f-501" alt="" />
	                                    </a>
	                                    <span class="f-txt">${w.name }</span>
	                                    <div class="alpha"></div>
	                                </div>
                        		</c:forEach>
                            </div>
                            
                            <div class="f-nav-bd"></div>
                        </div>
                    </div>
                    
                  	<div class="main_box">
                    	<div class="title">
                            <a href="${ctx }/wechat/list/" class="more fr">更多</a>
                            推荐关注
                            <a href="javascript:;">【我要上推荐】</a>
                        </div>
                        
                        <div id="newsoftware" class="thumb-wrap">
                        	<ul class="th-grid">
								<c:forEach var="w" items="${rec201WeChats}">
	                                <li class="thumb m29">
	                                    <a href="weChat/${w.id }/" target="_blank" title="" class="th-a">
	                                        <span class="sub-icon sub-zw"></span>
	                                        <img alt="" src="${imgPath }/${w.rowIcon }">
	                                    </a>
	                                    <a href="weChat/${w.id }/" target="_blank" title="" class="th-txt">${w.name }</a>
	                                    <div class="th-detail detail-tips">
	                                        <div class="th-m">
	                                            <a href="weChat/${w.id }/" target="_blank" title="" class="detail-tit">${w.name }</a>
	                                            <p class="detail-en d-5f"> ${w.infoClass.title } </p>
	                                            <p class="d-b0">${w.description }</p>
	                                        </div>
	                                        <div class="detail-bottom">
	                                            <span class="fl star star5"></span>
	                                        </div>
	                                    </div>
	                                </li>
								</c:forEach>                        		
                            </ul>
                            <ul class="th-grid">
								<c:forEach var="w" items="${rec202WeChats}">
	                                <li class="thumb m29">
	                                    <a href="weChat/${w.id }/" target="_blank" title="" class="th-a">
	                                        <span class="sub-icon sub-zw"></span>
	                                        <img alt="" src="${imgPath }/${w.rowIcon }">
	                                    </a>
	                                    <a href="weChat/${w.id }/" target="_blank" title="" class="th-txt">${w.name }</a>
	                                    <div class="th-detail detail-tips">
	                                        <div class="th-m">
	                                            <a href="weChat/${w.id }/" target="_blank" title="" class="detail-tit">${w.name }</a>
	                                            <p class="detail-en d-5f"> ${w.infoClass.title } </p>
	                                            <p class="d-b0">${w.description }</p>
	                                        </div>
	                                        <div class="detail-bottom">
	                                            <span class="fl star star5"></span>
	                                        </div>
	                                    </div>
	                                </li>
								</c:forEach>                        		
                            </ul>
                            <ul class="th-grid">
								<c:forEach var="w" items="${rec203WeChats}">
	                                <li class="thumb m29">
	                                    <a href="weChat/${w.id }/" target="_blank" title="" class="th-a">
	                                        <span class="sub-icon sub-zw"></span>
	                                        <img alt="" src="${imgPath }/${w.rowIcon }">
	                                    </a>
	                                    <a href="weChat/${w.id }/" target="_blank" title="" class="th-txt">${w.name }</a>
	                                    <div class="th-detail detail-tips">
	                                        <div class="th-m">
	                                            <a href="weChat/${w.id }/" target="_blank" title="" class="detail-tit">${w.name }</a>
	                                            <p class="detail-en d-5f"> ${w.infoClass.title } </p>
	                                            <p class="d-b0">${w.description }</p>
	                                        </div>
	                                        <div class="detail-bottom">
	                                            <span class="fl star star5"></span>
	                                        </div>
	                                    </div>
	                                </li>
								</c:forEach>                        		
                            </ul>
                        </div>
                    </div>
                    
                    <div class="main_ad">
                    	<div class="ad_box fl"><a href="#"><img src="images/main_ad1.jpg" alt="" /></a></div>
                    	<div class="ad_box fl"><a href="#"><img src="images/main_ad3.jpg" alt="" /></a></div>
                    	<div class="ad_box fl" style="margin:0;"><a href="#"><img src="images/main_ad4.jpg" alt="" /></a></div>
                        <div class="clear"></div>
                    </div>
                    
                  	<div class="main_box industry">
                    	<div class="title">
                            <a href="${ctx }/wechat/list/" class="more fr">更多</a>
                            按行业分类
                            <a href="javascript:;">【我要上推荐】</a>
                        </div>
                        
                        <div class="thumb-wrap">
                        	<div class="industry_box fl">
                            	<h1><a href="${ctx }/wechat/list/10000/0/1/24/">资讯阅读</a></h1>
                            	<c:forEach var="w" items="${info10000WeChats}">
                            		<dl>
	                                	<dt><a href="weChat/${w.id }/"><img src="${imgPath }/${w.rowIcon }" alt="${w.name }" /></a></dt>
	                                	<dd>
	                                    	<p><a href="weChat/${w.id }/">${w.name }</a></p>
	                                        <p class="star star5"></p>
	                                        <a target="_blank" class="download s-index-icon tjitem" href="weChat/${w.id }/">关 注</a>
	                                    </dd>
	                                    <div class="clear"></div>
	                                </dl>
                            	</c:forEach>
                            </div>
                        	<div class="industry_box fl">
                            	<h1><a href="${ctx }/wechat/list/90000/0/1/24/">游戏</a></h1>
                            	<c:forEach var="w" items="${info90000WeChats}">
                            		<dl>
	                                	<dt><a href="weChat/${w.id }/"><img src="${imgPath }/${w.rowIcon }" alt="${w.name }" /></a></dt>
	                                	<dd>
	                                    	<p><a href="weChat/${w.id }/">${w.name }</a></p>
	                                        <p class="star star5"></p>
	                                        <a target="_blank" class="download s-index-icon tjitem" href="weChat/${w.id }/">关 注</a>
	                                    </dd>
	                                    <div class="clear"></div>
	                                </dl>
                            	</c:forEach>
                            </div>
                        	<div class="industry_box fl">
                            	<h1><a href="${ctx }/wechat/list/30000/0/1/24/">生活购物</a></h1>
                            	<c:forEach var="w" items="${info30000WeChats}">
                            		<dl>
	                                	<dt><a href="weChat/${w.id }/"><img src="${imgPath }/${w.rowIcon }" alt="${w.name }" /></a></dt>
	                                	<dd>
	                                    	<p><a href="weChat/${w.id }/">${w.name }</a></p>
	                                        <p class="star star5"></p>
	                                        <a target="_blank" class="download s-index-icon tjitem" href="weChat/${w.id }/">关 注</a>
	                                    </dd>
	                                    <div class="clear"></div>
	                                </dl>
                            	</c:forEach>
                            </div>
                        	<div class="industry_box fl">
                            	<h1><a href="${ctx }/wechat/list/40000/0/1/24/">行业商家</a></h1>
                            	<c:forEach var="w" items="${info40000WeChats}">
                            		<dl>
	                                	<dt><a href="weChat/${w.id }/"><img src="${imgPath }/${w.rowIcon }" alt="${w.name }" /></a></dt>
	                                	<dd>
	                                    	<p><a href="weChat/${w.id }/">${w.name }</a></p>
	                                        <p class="star star5"></p>
	                                        <a target="_blank" class="download s-index-icon tjitem" href="weChat/${w.id }/">关 注</a>
	                                    </dd>
	                                    <div class="clear"></div>
	                                </dl>
                            	</c:forEach>
                            </div>
                        	<div class="industry_box fl">
                            	<h1><a href="${ctx }/wechat/list/50000/0/1/24/">影音娱乐</a></h1>
                            	<c:forEach var="w" items="${info50000WeChats}">
                            		<dl>
	                                	<dt><a href="weChat/${w.id }/"><img src="${imgPath }/${w.rowIcon }" alt="${w.name }" /></a></dt>
	                                	<dd>
	                                    	<p><a href="weChat/${w.id }/">${w.name }</a></p>
	                                        <p class="star star5"></p>
	                                        <a target="_blank" class="download s-index-icon tjitem" href="weChat/${w.id }/">关 注</a>
	                                    </dd>
	                                    <div class="clear"></div>
	                                </dl>
                            	</c:forEach>
                            </div>
                        	<div class="industry_box fl">
                            	<h1><a href="${ctx }/wechat/list/20000/0/1/24/">名人明星</a></h1>
                            	<c:forEach var="w" items="${info20000WeChats}">
                            		<dl>
	                                	<dt><a href="weChat/${w.id }/"><img src="${imgPath }/${w.rowIcon }" alt="${w.name }" /></a></dt>
	                                	<dd>
	                                    	<p><a href="weChat/${w.id }/">${w.name }</a></p>
	                                        <p class="star star5"></p>
	                                        <a target="_blank" class="download s-index-icon tjitem" href="weChat/${w.id }/">关 注</a>
	                                    </dd>
	                                    <div class="clear"></div>
	                                </dl>
                            	</c:forEach>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>
                </div>
                
                <div class="side_bar fr">
                	
                	<div class="login_box"><!--登录前输入框版块-->
                    	<form>
                    	<div class="title">会员登录</div>
                        
                        <div class="input_box">
                            <input type="text" name="userName" value="请输入用户名" onfocus="if (value =='请输入用户名'){value =''}" onblur="if (value ==''){value='请输入用户名'}" />
                        </div>
                        
                        <div class="input_box">
                             <input type="password" name="password" id="password" style="display: none;"/>
                        	 <input type="type" id="password3_$loginhash" name="hidenpassword" value='请输入密码'/>
                    	</div>
                    	<div class="input_box tipMsg"></div>
                        <div class="forget">
                        	<input id="isCookie_" type="hidden" value=""/>
                            <input id="isCookie" type="checkbox"/>记住我<a href="javasript:;">忘记密码?</a>
                        </div>
                        
                        <div class="btn_box">
                        	<div class="fl"><a id="loginIndexBtn" href="javascript:void(0)"><img src="${ctx }/images/login_btn.png" alt="" /></a></div>
                            <div class="fr"><a href="${ctx }/register/"><img src="${ctx }/images/reg_btn.png" alt="" /></a></div>
                            <div class="clear"></div>
                        </div>
                        </form>
                    </div>
                    
                    <div class="user_box"><!--登录后用户信息版块-->
                        <div class="user_info">
                            <div class="user_head fl"><a href="javascript:;"><img src="${ctx }/images/logo.png" alt="lvhongtao" /></a></div>
                            <div class="user_name fl">
                                <p><span id="loginUserName">${user.userName }</span>您好,</p>
                                <p>欢迎光临！</p>
                            </div>
                            <div class="clear"></div>
                        </div>
                        
                        <div class="btn_box">
                            <div class="fl"><a href="javasript:;"><img src="${ctx }/images/center_btn.png" alt="会员中心" /></a></div>
                            <div class="fr"><a id="logoutIndexBtn" href="javascript:void(0)"><img src="${ctx }/images/exit_btn.png" alt="退出" /></a></div>
                            <div class="clear"></div>
                        </div>
                        
                        <div class="tuijian">
                        	<div class="tuijian_tit">推荐微信<a href="#" class="fr">更多&gt;&gt;</a></div>
                            <div class="tuijian_list">
                            	<div class="tuijian_box">
                                	<div class="tuijian_game fl" title="糗事百科">糗事百科</div>
                                    <div class="tuijian_btn fr"><a href="http://w.game.tom.com/plus/list.php?tid=38&amp;gtype=1026&amp;gid=1380" title="糗事百科"></a></div>
                                    <div class="clear"></div>
                                </div>
                            	<div class="tuijian_box">
                                	<div class="tuijian_game fl" title="舌尖上的美食">舌尖上的美食</div>
                                    <div class="tuijian_btn fr"><a href="http://w.game.tom.com/plus/list.php?tid=38&amp;gtype=1021&amp;gid=1379" title="舌尖上的美食"></a></div>
                                    <div class="clear"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <jsp:include page="inc_recently.jsp"></jsp:include>
                    
                    <div class="side_ad"><a href="javascript:;"><img src="images/ad2.jpg" alt="" /></a></div>
                    
                    <jsp:include page="inc_hot.jsp"></jsp:include>
                </div>
                <div class="clear"></div>
            </div>
            
        	<div class="main_bottom"><img src="images/main_bottom.png" alt="" /></div>
        </div>
        
    
    <script src="js/common.js"></script>
    <script src="js/index.js"></script>
</body>
</html>
