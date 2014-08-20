<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆 - 微市场</title>
<meta content="" name="keywords" />
<meta content="" name="description" />
<link rel="icon" href="${imgPath }/spread.ico"/>
<link href="${ctx }/css/common.css" rel="stylesheet" />
<link href="${ctx }/css/login.css" rel="stylesheet" />
<!--[if lte IE 6]>
<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, img, li, a');
    </script>
<![endif]--> 
<script src="${ctx }/js/jquery-1.7.2.js"></script>
<script><!--鼠标点击账号密码输入框value暂隐效果-->
	var $=jQuery.noConflict();
	$(document).ready(function() {
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
		$("#subA").click(function(){
			document.form1.submit();
		});
	});
</script>
</head>

<body>
	<div id="container">
    	<div class="reg_head"><a href="#"><img src="${ctx }/images/logo.png" /></a></div>
        
        <div class="reg_main">
        	<div>
                <div class="reg_box fl">
                <form name="form1" action="${ctx }/userLogin/" method="post">
                    <h2>请您登录微信或者<a href="${ctx }">返回首页>></a></h2>
                    <div class="inputBox">
                        <input type="text" value="请输入帐号" name="userName" onfocus="if (value =='请输入帐号'){value =''}" onblur="if (value ==''){value='请输入帐号'}" /><!--通行证输入框--> <span style="display:none;">请输入正确email</span>
                    </div>
                    <div class="inputBox">
                      <input type="password" name="password" id="password" style="display:none;">
                        <input type="type" id="password3_$loginhash" name="hidenpassword" value='请输入密码' />
                    </div>
                            
                    <div class="forget">
                        <input type="checkbox" />记住我
                        <a href="#" class="cf60">忘记密码</a>
                    </div>           
                         
                    <div class="loginbtn_box">
                        <a id="subA" href="javascript:void(0)" class="loginbtn"></a>
                        <c:choose>
                        	<c:when test="${param.sign == false}">
                        		<span>用户名或密码错误！</span>		
                        	</c:when>
                        	<c:otherwise>
		                        <span style="display:none;">用户名或密码错误！</span>
                        	</c:otherwise>
                        </c:choose>
                    </div>
                </form>
                </div>
                
                <div class="reg_side fl">
                    <h2>还没有微信帐号？</h2>
                    <div class="regbtn_box"><a href="${ctx }/register/" class="regbtn"></a></div>
                    
                    <h2>或使用SNS社区帐号登录</h2>
                    <div class="snsbtn"><a href="#"><img src="${ctx }/images/weibo_login.png" /></a></div>
                    <div class="snsbtn"><a href="#"><img src="${ctx }/images/qq_login.png" /></a></div>
                </div>
                <div class="clear"></div>
            </div>
            
            <!--以下是PK社区底部区域-->
            <div class="footer">
                <p>©2012 WeiXinJu.Com 微市场 - 最具权威的微信公众平台导航 皖ICP备12000796号 </p>
                <p>QQ超级群（1000人）：260206469（已满）149419623（已满）160317171（已满）246078487（已满）</p>
            </div>
            <!--以上是PK社区底部区域-->
        </div>
    </div>
</body>
</html>
