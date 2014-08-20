<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="${weChat.description }" />
<meta name="description" content="${weChat.keywords }" />
<title>${weChat.name } - wechat.surroundlife.com</title>
<link rel="stylesheet" href="${ctx }/css/article.css" />
<script type="text/javascript">
	$(function(){
		$(".button-green").click(function(){
			$.post("${ctx}/comment/comment/", {wechat_id:"${weChat.id}", content:$(".info_text").val()},function(data){
				rendering(data);
			});
		});
	});
	function pageTurning(o1, o2){
		var msg = '${ctx}/comment/commentList/${weChat.id}/' + o2 + '/' + o1 + '/';
		$.get(msg, function(data){
			rendering(data);
		});
		
		
	}
	
	function rendering(data){
		$(".pinglunbox").empty();
			$.each(data.data, function(index, item){
				var text = "<dl>" + "<dt class='fl user_head'><img src='${imgPath }/" + item.picUrl + "' /></dt>" + "<dd class='fl'>";
				text += "<p><b>" + item.userName + "</b><span class='cf9'>" + item.commentTime + "</span></p>" + "<p class='pingluntxt'>" + item.content + "</p>";
				text +="</dd>" + "<div class='clear'></div>" + "</dl>";
				$(".pinglunbox").append(text);
				// 以上是评论内容
			});
			$(".page.fr").empty();
			var text = "";
			if(data.page == 1){
				var text = "<a href='javascript:void(0)' onclick=\"pageTurning('" + data.pageSize + "','1')\">上一页</a>&nbsp;";
			} else {
				var text = "<a href='javascript:void(0)' onclick=\"pageTurning('" + data.pageSize + "','" + (data.page - 1) + "')\">上一页</a>&nbsp;";
			}
			if(data.start > 1){
				text += "<a href='javascript:void(0)' onclick=\"pageTurning('" + data.pageSize + "','1')\">1</a>&nbsp;";
			}
			if(data.start > 3){
				text += "<a href='javascript:void(0)' onclick=\"pageTurning('" + data.pageSize + "','" + (data.page - 3) + "')\">...</a>&nbsp;";
			}
			for(var i = data.start; i <= data.end; i++){
				if(data.page == i){
					text += "<a href='javascript:void(0)' class='current' onclick=\"pageTurning('" + data.pageSize + "','" + i + "')\">" + i + "</a>&nbsp;";
				} else {
					text += "<a href='javascript:void(0)' onclick=\"pageTurning('" + data.pageSize + "','" + i + "')\">" + i + "</a>&nbsp;";
				} 
			}
			if(data.totalPage - data.page > 3){
				text += "<a href='javascript:void(0' onclick=\"pageTurning('" + data.pageSize + "','" + (data.page + 3 ) + "')\">...</a>&nbsp;";
			}
			if(data.end < data.totalPage){
				text += "<a href='javascript:void(0)' onclick=\"pageTurning('" + data.pageSize + "','" + data.totalPage + "')\">" + data.totalPage + "</a>&nbsp;";
			}
			if(data.page == data.totalPage){
				text += "<a href='javascript:void(0)' onclick=\"pageTurning('" + data.pageSize + "','" + data.totalPage + "')\">下一页</a>";
			} else {
				text += "<a href='javascript:void(0)' onclick=\"pageTurning('" + data.pageSize + "','" + (data.page + 1) + "')\">下一页</a>";
			}
			
			text += "</div>";
			$(".page.fr").html(text);
			$(".info_text").val('');
			// 以上是分页信息
	}
</script>
</head>

<body>
        
       <div class="content">
        	<div class="main_top"><img src="${ctx }/images/main_top.png" alt=""></div>
            
        	<div class="main">
            	<div class="main_article fl">
                	<div class="pos">您的位置：<a href="${ctx }/">首页</a> >>  <a href="${ctx }/wechat/list/${weChat.infoClass.id }/0/1/24/">${weChat.infoClass.title }</a> >> ${weChat.name }</div>
                    
                    <div class="article_box">
                    	<div class="info">
                            <dl class="gamecon">
	                                <dt class="fl">
	                                    <img src="${imgPath }/${weChat.rowIcon }" alt="" />
	                                    <p>二维码扫描订阅</p>
	                                    <img src="${imgPath }/${weChat.qrCode }" alt="" />
	                                </dt>
	                                <dd class="text fl">
	                                    <h2 class="fs16 hide">${weChat.name }</h2>
	                                    <div class="wxinfo">
	                                        <p>微信原始号：${weChat.rowAliasNum }</p>
	                                        <p>微信号：${weChat.aliasNum }<a href="#">[复制微信原始号]</a></p>
	                                        <p>账号类型：订阅号</p>
	                                        <p>网站地址：${weChat.url }</p>
	                                        <p>地区：${weChat.province.areaName } > ${weChat.city.areaName }</p>
	                                        <p>收录时间：${weChat.createTime }</p>
	                                        <p>关键词：${weChat.keywords }</p>
	                                        <div class="clear"></div>
	                                    </div>
	                                    
	                                    <div class="sharebox">
	                                        <!-- 将此标记放在您希望显示like按钮的位置 -->
	                                        <div class="bdlikebutton ding"></div>
	                                        <!-- Baidu Button BEGIN -->
	                                        <div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare">
	                                            <span class="bds_more">分享到：</span>
	                                            <a class="bds_tsina"></a>
	                                            <a class="bds_tqq"></a>
	                                            <a class="bds_renren"></a>
	                                            <a class="bds_t163"></a>
	                                            <a class="bds_tsohu"></a>
	                                            <a class="bds_qzone"></a>
	                                            <a class="bds_douban"></a>
	                                            <a class="shareCount"></a>
	                                        </div>
	                                        <script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=6887146" ></script>
	                                        <script type="text/javascript" id="bdshell_js"></script>
	                                        <script type="text/javascript">
	                                        document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
	                                        </script>
	                                        <!-- Baidu Button END -->
	                                        <div class="clear"></div>
	                                    </div>
	                                    
	                                    <h4>微信描述：</h4>
	                                    <p>${weChat.description }</p>
	                                    <div class="fansbox">
	                                        <span class="item">
	                                            <i class="num dls">${weChat.action.share == null ? 0 : weChat.action.share}</i><span class="txt">分享</span>
	                                        </span>
	                                        <span class="item likes">
	                                            <i class="num">${weChat.action.enjoy == null ? 0 : weChat.action.enjoy}</i><span class="txt">喜欢</span>
	                                        </span>
	                                        <span class="item likes">
	                                            <i class="num">${weChat.action.read == null ? 0 : weChat.action.read}</i><span class="txt">浏览</span>
	                                        </span>
	                                    </div>
	                                </dd>
                                	<div class="clear"></div>
                            	</dl>
                        	</div>
                        
                        <div class="pinglun">
                            <h2 class="fs14 cf4">评论：</h2>
                            
                            <div class="pinglunbox">
                            	<c:forEach var="c" items="${list.result}">
                            		<dl>
	                                    <dt class="fl user_head"><img src="${imgPath }/${c.picUrl }" /></dt>
	                                    <dd class="fl">
	                                        <p><b>${c.userName }</b> <span class="cf9">${c.commentTime }</span></p>
	                                        <p class="pingluntxt">${c.content }</p>
	                                    </dd>
	                                    <div class="clear"></div>
	                                </dl>
                            	</c:forEach>
                            </div>
                            
                            <div class="page_box">
                            	<div class="page fr">
                            		<c:choose>
				                    	<c:when test="${list.page == 1}">
				                    		<a href="javascript:void(0)" onclick="pageTurning('${list.pageSize }','1')">上一页</a>
				                    	</c:when>
				                    	<c:otherwise>
					                    	<a href="javascript:void(0)" onclick="pageTurning('${list.pageSize }','${list.page - 1 }')">上一页</a>
				                    	</c:otherwise>
			                    	</c:choose>
			                    	<c:if test="${se[0] > 1}">
				                    	<a href="javascript:void(0)" onclick="pageTurning('${list.pageSize }','1')">1</a>
			                    	</c:if>
			                    	<c:if test="${se[0] > 3}">
				                    	<a href="javascript:void(0)" onclick="pageTurning('${list.pageSize }','${list.page - 3}')">...</a>
			                    	</c:if>
			                    	
			                    	<c:forEach begin="${se[0]}" end="${se[1]}" varStatus="i">
			                    		<c:choose>
			                    			<c:when test="${list.page == i.index}">
			                    				<a href="javascript:void(0)" class="current" onclick="pageTurning('${list.pageSize }','${i.index}')">${i.index}</a>
			                    			</c:when>
			                    			<c:otherwise>
			                    				<a href="javascript:void(0)" onclick="pageTurning('${list.pageSize }','${i.index}')">${i.index}</a>
			                    			</c:otherwise>
			                    		</c:choose>
			                    	</c:forEach>
			                    	<c:if test="${list.totalPage - list.page > 3}">
				                    	<a href="javascript:void(0)" onclick="pageTurning('${list.pageSize }','${list.page + 3}')">...</a>
			                    	</c:if>
			                    	<c:if test="${se[1] < list.totalPage}">
			                    		<a href="javascript:void(0)" onclick="pageTurning('${list.pageSize }','${list.totalPage}')">${list.totalPage }</a>
			                    	</c:if>
			                    	<c:choose>
				                    	<c:when test="${list.page == list.totalPage}">
				                    		<a href="javascript:void(0)" onclick="pageTurning('${list.pageSize }','${list.totalPage}')">下一页</a>
				                    	</c:when>
				                    	<c:otherwise>
				                    		<a href="javascript:void(0)" onclick="pageTurning('${list.pageSize }','${list.page + 1}')">下一页</a>
				                    	</c:otherwise>
			                    	</c:choose>
                    	
                            	</div>
                                <div class="clear"></div>
                            </div>
                            
                            <div class="quick_reply">
                            <form>
                                <div>
                                    <textarea class="info_text"></textarea>
                                </div>
                                <div class="reply_btn">
                                    <span class="fl">请您登录后再评论! <a href="#">登录</a> | <a href="#">注册</a></span>
                                    <a href="javascript:void(0)" class="button-green">发表评论</a>
                                    <span class="fr">您还可以输入<i>140</i>字</span>
                                    <div class="clear"></div>
                                </div>														                        
                            </form>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="side_bar fr">
                	<div class="slide_ad"><a href="javascript:;"><img src="${ctx }/images/ad.jpg" alt="" /></a></div>
                	<jsp:include page="inc_like.jsp"></jsp:include>
                    
                    <div class="side_ad"><a href="javascript:;"><img src="${ctx }/images/ad2.jpg" alt="" /></a></div>
                </div>
                <div class="clear"></div>
            </div>
            
        	<div class="main_bottom"><img src="${ctx }/images/main_bottom.png" alt="" /></div>
        </div>

<!-- 将此代码放在适当的位置，建议在body结束前 -->
<script id="bdlike_shell"></script>
<script>
var bdShare_config = {
	"type":"small",
	"color":"green",
	"uid":"6887146"
};
document.getElementById("bdlike_shell").src="http://bdimg.share.baidu.com/static/js/like_shell.js?t=" + Math.ceil(new Date()/3600000);
</script>
</body>
</html>
