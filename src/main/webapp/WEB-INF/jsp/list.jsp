<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${infoClassTitle } - wechat.surroundlife.com</title>
<link rel="stylesheet" href="${ctx }/css/list.css" />
</head>

<body>
    	
        
        <div class="content">
            <div class="main_top"><img src="${ctx }/images/main_top.png" alt=""></div>
        	<div class="main">
            	<div class="main_list fl">
                	<div class="pos">您的位置：<a href="${ctx }/">首页</a> >> ${infoClassTitle }</div>
                    
                    <div class="list_box">
                    	<c:forEach var="w" items="${list.result}">
                    		<dl>
	                            <dt><a href="${ctx }/wechat/${w.id }/"><img src="${imgPath }/${w.rowIcon }" alt="" /></a></dt>
	                            <dd>
	                                <p><a href="${ctx }/wechat/${w.id }/">${w.name }</a></p>
	                                <p class="star star5"></p>
	                                <a target="_blank" class="download s-index-icon tjitem" href="${ctx }/wechat/${w.id }/">关 注</a>
	                            </dd>
	                            <div class="clear"></div>
	                        </dl>
                    	</c:forEach>
                    	
                        <div class="clear"></div>
                    </div>
                    
                    <div class="page">
                    	<c:choose>
	                    	<c:when test="${list.page == 1}">
	                    		<a href="${ctx }/wechat/list/${infoClassId }/${city }/1/${list.pageSize }/">上一页</a>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<a href="${ctx }/wechat/list/${infoClassId }/${city }/${list.page - 1}/${list.pageSize }/">上一页</a>
	                    	</c:otherwise>
                    	</c:choose>
                    	<c:if test="${se[0] > 1}">
	                    	<a href="${ctx }/wechat/list/${infoClassId }/${city }/1/${list.pageSize }/">1</a>
                    	</c:if>
                    	<c:if test="${se[0] > 3}">
	                    	<a href="${ctx }/wechat/list/${infoClassId }/${city }/${list.page - 3 }/${list.pageSize }/">...</a>
                    	</c:if>
                    	<c:forEach begin="${se[0]}" end="${se[1]}" varStatus="i">
                    		<c:choose>
                    			<c:when test="${list.page == i.index}">
                    				<a href="${ctx }/wechat/list/${infoClassId }/${city }/${i.index}/${list.pageSize }/" class="current">${i.index}</a>
                    			</c:when>
                    			<c:otherwise>
                    				<a href="${ctx }/wechat/list/${infoClassId }/${city }/${i.index}/${list.pageSize }/">${i.index}</a>
                    			</c:otherwise>
                    		</c:choose>
                    	</c:forEach>
                    	<c:if test="${list.totalPage - list.page > 3}">
	                    	<a href="${ctx }/wechat/list/${infoClassId }/${city }/${list.page + 3 }/${list.pageSize }/">...</a>
                    	</c:if>
                    	<c:if test="${se[1] < list.totalPage}">
                    		<a href="${ctx }/wechat/list/${infoClassId }/${city }/${list.totalPage }/${list.pageSize }/">${list.totalPage }</a>
                    	</c:if>
                    	
                    	<c:choose>
	                    	<c:when test="${list.page == list.totalPage}">
	                    		<a href="${ctx }/wechat/list/${infoClassId }/${city }/${list.totalPage}/${list.pageSize }/">下一页</a>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<a href="${ctx }/wechat/list/${infoClassId }/${city }/${list.page + 1}/${list.pageSize }/">下一页</a>
	                    	</c:otherwise>
                    	</c:choose>
                    </div>
                </div>
                
                <div class="side_bar fr">
                	<div class="class">
                    	<div class="class_tit">分类</div>
                        <div class="class_list">
                        	<ul>
                            	<c:forEach var="clazz" items="${classes}">
                            		<c:choose>
	                        			<c:when test="${infoClassId == clazz.id}">
	                        				<li><a href="${ctx }/wechat/list/${clazz.id }/${city }/1/${list.pageSize }/" class="ishover">${clazz.title }</a></li>
	                        			</c:when>
	                        			<c:otherwise>
	                        				<li><a href="${ctx }/wechat/list/${clazz.id }/${city }/1/${list.pageSize }/">${clazz.title }</a></li>
	                        			</c:otherwise>
	                        		</c:choose>
                            		
                            	</c:forEach>
                                <div class="clear"></div>
                            </ul>
                        </div>
                    </div>
                    
                    
                    <div class="class">
                    	<div class="class_tit">地区</div>
                        <div class="class_list">
                        	<ul>
                            	<c:forEach var="area" items="${areas}">
                            		<c:choose>
	                        			<c:when test="${city == area.id}">
	                        				<li><a href="${ctx }/wechat/list/${infoClassId }/${area.id }/1/${list.pageSize }/" class="ishover">${area.areaName }</a></li>
	                        			</c:when>
	                        			<c:otherwise>
	                        				<li><a href="${ctx }/wechat/list/${infoClassId }/${area.id }/1/${list.pageSize }/">${area.areaName }</a></li>
	                        			</c:otherwise>
	                        		</c:choose>
                            		
                            	</c:forEach>
                                <div class="clear"></div>
                            </ul>
                        </div>
                    </div>
                
                    <jsp:include page="inc_recently.jsp"></jsp:include>
                    
                    <div class="side_ad"><a href="javascript:;"><img src="${ctx }/images/ad2.jpg" alt="" /></a></div>
                    
                    <jsp:include page="inc_hot.jsp"></jsp:include>
                </div>
                <div class="clear"></div>
            </div>
            
        	<div class="main_bottom"><img src="${ctx }/images/main_bottom.png" alt="" /></div>
        </div>
        
    
    <script src="js/common.js"></script>
</body>
</html>
