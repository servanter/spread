<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册 - 微市场</title>
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
<script src="${ctx }/js/spread.js"></script>
<script src="${ctx }/js/jquery-1.7.2.js"></script>
<script>
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
		$("#regA").click(function(){
			var sign = true;
			var msg = '';
			if(sign && checkUserName($("input[name=userName]")) != ''){
				msg = checkUserName($("input[name=userName]"));
				sign = false;
			}
			if(sign && checkPwd($("#pwd"), $("#pwd2")) != ''){
				checkPwd($("#pwd"), $("#pwd2"))
				sign = false;
			}
			if(sign && checkNickname($("input[name=nickname]")) != ''){
				msg = checkNickname($("input[name=nickname]"));
				sign = false;
			}
			if(sign && checkEmail($("input[name=email]")) != ''){
				msg = checkEmail($("input[name=email]"));
				sign = false;
			}
			if(sign && checkCode($("#imageCheckCode")) != ''){
				msg = checkCode($("#imageCheckCode"));
				sign = false;
			}
			if(sign){
				document.form1.submit();
			} 
		});
		$("#imageCheckCode").blur(function(){
			checkCode($(this));
		});
		$("#pwd2").blur(function(){
			checkPwd($(this), $("#pwd"));			
		});
		$("#pwd").blur(function(){
			checkPwd($(this), $("#pwd2"));
		});
		$("input[name=userName]").blur(function(){
			checkUserName($(this));
		});
		$("input[name=nickname]").blur(function(){
			checkNickname($(this));
		});
		$("input[name=email]").blur(function(){
			checkEmail($(this));
		});
		
	});
	
	function emptyErrorMsg(){
		if($("#error_msg").text("") == ''){
			$("#error_msg").text("");
		}
	}
	
	function checkCode(obj){
		var code = $(obj).val();
		var sign = "";
		$.getJSON("${ctx}/checkCode.do?imageCheckCode=" + code, function(data){
			if(data.returnCode != 10000){
				$("#error_msg").text(data.returnMsg);
				sign =  data.returnMsg;
			} else {
				emptyErrorMsg();
			}
		});
		return sign;
	}
	
	function checkPwd(obj1, obj2){
		if($(obj1).val() == '' || $(obj2).val() == ''){
			var msg = "请输入密码";
			$("#error_msg").text(msg);
			return msg;
		}
		if($(obj1).val() != $(obj2).val()){
			var msg = "两次输入的密码不一致";
			$("#error_msg").text(msg);
			return msg;
		} else {
			emptyErrorMsg();
			return "";
		}
	}
	
	function checkUserName(obj){
		if($(obj).val() == ""){
			var msg = "请输入用户名";
			$("#error_msg").text(msg);
			return msg;
		} else {
			emptyErrorMsg();
			return "";
		}
	}
	
	function checkNickname(obj){
		if($(obj).val() == ""){
			var msg = "请输入昵称";
			$("#error_msg").text(msg);
			return msg;
		} else {
			emptyErrorMsg();
			return "";
		}
	}
	
	function checkEmail(obj){
		if($(obj).val() == ""){
			var msg = "请输入email";
			$("#error_msg").text(msg);
			return msg;
		} else {
			emptyErrorMsg();
			return "";
		}
	}
</script>
</head>

<body>
	<div id="container">
    	<div class="reg_head"><a href="#"><img src="${ctx }/images/logo.png" /></a></div>
        
        <div class="reg_main">
        	<h2 class="regtit">注册微信，一步完成，畅游最具权威的微信公众导航ª</h2>
        
        	<div>
                <div class="reg_box reg_box2 fl">
                <form name="form1" action="${ctx }/userRegister/" method="post">
                    <div class="info_list">
                        <div class="tit fl">用户名：</div>
                        <div class="ipt fl"><input type="text" name="userName" class="info_input" /><span></span></div>
                        <div class="clear"></div>
                    </div>
                    <div class="info_list">
                        <div class="tit fl">设置密码：</div>
                        <div class="ipt fl"><input id="pwd" type="password" name="password" class="info_input" /></div>
                        <div class="clear"></div>
                    </div>
                    <div class="info_list">
                        <div class="tit fl">确认密码：</div>
                        <div class="ipt fl"><input id="pwd2" type="password" name="confirmPassword" class="info_input" /></div>
                        <div class="clear"></div>
                    </div>
                    <div class="info_list">
                        <div class="tit fl">昵称：</div>
                        <div class="ipt fl"><input type="text" name="nickname" class="info_input" /></div>
                        <div class="clear"></div>
                    </div>
                    <div class="info_list">
                        <div class="tit fl">电子邮箱：</div>
                        <div class="ipt fl"><input type="text" name="email" class="info_input" /></div>
                        <div class="clear"></div>
                    </div>
                    <div class="info_list yzm">
                        <div class="tit fl">验证码：</div>
                        <div class="ipt fl">
                            <input id="imageCheckCode" type="text" name="imageCheckCode" class="info_input" />
                            <a href="#"><img src="${ctx }/identifyCode/" /></a>
                        </div>
                        <div class="clear"></div>
                    </div>
    
                    <div class="regbtn_box">
                        <a id="regA" href="javascript:void(0)" class="regbtn"></a>
                        <c:choose>
                        	<c:when test="${commonResponse.returnCode.code != returnOK}">
                        		<span id="error_msg">${commonResponse.returnCode.alias }</span>
                        	</c:when>
                        	<c:otherwise>
                        		<span id="error_msg"></span>
                        	</c:otherwise>
                        </c:choose>
                    </div>
                </form>
                </div>
                
                <div class="reg_side fl">
                    <h2>已有微信帐号？</h2>
                    <div class="loginbtn_box"><a href="${ctx }/login/" class="loginbtn"></a></div>
                    
                    <h2>或使用SNS社区帐号登录</h2>
                    <div class="snsbtn"><a href="#"><img src="${ctx }/images/weibo_login.png" /></a></div>
                    <div class="snsbtn"><a href="#"><img src="${ctx }/images/qq_login.png" /></a></div>
                </div>
                <div class="clear"></div>
            </div>
            
            <div class="footer">
            	 <p>©2012 WeiXinJu.Com 微信聚 - 最具权威的微信公众平台导航 皖ICP备12000796号 </p>
                <p>QQ超级群（1000人）：260206469（已满）149419623（已满）160317171（已满）246078487（已满）</p>
            </div>
        </div>
    </div>
</body>
</html>
