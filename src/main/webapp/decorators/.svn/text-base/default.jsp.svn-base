<%@ include file="/common/taglibs.jsp" %>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
 		<title><decorator:title default="默认title"/></title>
 		<link rel="icon" href="${imgPath }/spread.ico"/>
 		<link rel="stylesheet" href="${ctx }/css/common.css" />
		<link rel="stylesheet" href="${ctx }/css/spread.css" />
		<script src="${ctx }/js/jquery-1.7.2.js"></script>
		<!--[if lte IE 6]>
		<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
		    <script type="text/javascript">
		        DD_belatedPNG.fix('div, img, ul, li, a');
		    </script>
		<![endif]--> 
		<script src="${ctx }/js/common.js" type="text/javascript"></script>
		<script src="${ctx }/js/slide.js" type="text/javascript"></script>
		<script src="${ctx }/js/spread.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$("#sear_btn").click(function(){
					document.searchBox.submit();
				});
			})
		</script>
        <decorator:head/>
    </head>

    <body>
    	<div id="container">
	    	<div class="header">
	        	<div class="logo_box">
	                <div class="logo fl"><img src="${ctx }/images/logo.png" alt="" /></div>
	                <div class="search fr">
	                	<div class="search_btn"><a id="sear_btn" href="javascript:void(0)">搜索</a></div>
	                	<form name="searchBox" class="search-box" action="${ctx}/weChat/search.do">
	                        <input id="search_text" placeholder="游戏 娱乐" value="${keywords }" name="keywords" class="search-ipt">
	                        <span class="search-btn"></span>
	                        <div class="clear"></div>
	                    </form>
	                </div>
	                <div class="clear"></div>
	            </div>
	            
	            <div class="nav">
	            	<ul>
	                	<li><a href="${ctx }/">首页</a></li>
	                	<li><a href="${ctx }/wechat/list/">最新收录</a></li>
	                	<li><a href="javascript:;">推荐关注</a></li>
	                	<li><a href="javascript:;">微信百科</a></li>
	                	<li><a href="javascript:;">免费提交</a></li>
	                	<li><a href="javascript:;">公号管理</a></li>
	                	<li><a href="javascript:;">微信网页版</a></li>
	                	<li><a href="${ctx }/login/">登陆</a></li>
	                    <div class="clear"></div>
	                </ul>
	            </div>
	            
	            <div class="bottom_bar">
	            	<div class="date fl">最新公告：微市场，最具权威的微信公众平台导航网站正式开通，审核请加群！<span>QQ三群（千人群）：149419623（可加）</span></div>
	                <div class="clear"></div>
	            </div>
	        </div>
		    <!-- 从被装饰页面获取body标签内容 -->
		    <decorator:body />
	    </div>
	    
	    <div class="footer">
        	<p>©2012 WeiXinJu.Com 微市场 - 最具权威的微信公众平台导航 皖ICP备12000796号 </p>
            <p>QQ超级群（1000人）：260206469（已满）149419623（已满）160317171（已满）246078487（已满）</p>
        </div>
    </body>
</html>