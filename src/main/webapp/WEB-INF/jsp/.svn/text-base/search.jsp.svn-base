<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>微市场综合搜索 - ${keywords } - 微市场</title>
<link rel="stylesheet" href="${ctx }/css/list.css" />
<link rel="stylesheet" href="${ctx }/css/search.css" />
<!--[if lte IE 6]>
<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, img, ul, li, a');
    </script>
<![endif]--> 
<script src="${ctx }/js/slide.js"></script>
</head>

<body>
        
        <div class="content">
        	<div class="main_top"><img src="${ctx }/images/main_top.png" alt="" /></div>
            
        	<div class="main">
            	<div class="main_list fl">
                	<div class="pos">关于"<b class="label">${keywords }</b>"的微信，共找到<b class="label">${list.totalRecord }</b>条结果</div>
                    
                    <div class="list_box2">
                        <c:choose>
                        	<c:when test="${list.totalRecord > 0}">
                        		<c:forEach items="${list.result}" var="weChat">
	                        		<div class="search_box">
			                            <div class="search_img fl"><a href="${ctx }/wechat/${weChat.id }/"><img src="${imgPath }/${weChat.rowIcon }" alt="" /></a></div>
			                            <div class="search_txt fl">
			                            	<div>
			                                    <span><a href="${ctx }/wechat/${weChat.id }/">${weChat.name }</span>
			                                    <span class="xx star star5"></span>
			                                    <div class="clear"></div>
			                                </div>
			                                <p>${weChat.description }</p>
			                            </div>
			                            <div class="search_btn fr">
			                            	<a target="_blank" class="download s-index-icon tjitem" href="${ctx }/wechat/${weChat.id }/">关 注</a>
			                                <p>${weChat.action.read == null ? 0 : weChat.action.read}人关注</p>
			                            </div>
			                            <div class="clear"></div>
			                        </div>
                        		</c:forEach>
                        	</c:when>
                        	<c:otherwise>
                        		
                        	</c:otherwise>
                        </c:choose>
                    	
                    </div>
                    
                    <div class="page">
                    	<c:choose>
	                    	<c:when test="${list.page == 1}">
	                    		<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=1">上一页</a>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=${list.page - 1}">上一页</a>
	                    	</c:otherwise>
                    	</c:choose>
                    	<c:if test="${se[0] > 1}">
	                    	<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=1">1</a>
                    	</c:if>
                    	<c:if test="${se[0] > 3}">
	                    	<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=${list.page - 3 }">...</a>
                    	</c:if>
                    	<c:forEach begin="${se[0]}" end="${se[1]}" varStatus="i">
                    		<c:choose>
                    			<c:when test="${list.page == i.index}">
                    				<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=${i.index}" class="current">${i.index}</a>
                    			</c:when>
                    			<c:otherwise>
                    				<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=${i.index}">${i.index}</a>
                    			</c:otherwise>
                    		</c:choose>
                    	</c:forEach>
                    	<c:if test="${list.totalPage - list.page > 3}">
	                    	<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=${list.page + 3 }">...</a>
                    	</c:if>
                    	<c:if test="${se[1] < list.totalPage}">
                    		<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=${list.totalPage }">${list.totalPage }</a>
                    	</c:if>
                    	
                    	<c:choose>
	                    	<c:when test="${list.page == list.totalPage}">
	                    		<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=${list.totalPage}">下一页</a>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${infoClassId }&city=${city }&page=${list.page + 1}">下一页</a>
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
	                        				<li><a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${clazz.id }&city=${city }&page=1" class="ishover">${clazz.title }</a></li>
	                        			</c:when>
	                        			<c:otherwise>
	                        				<li><a href="${ctx }/weChat/search.do?keywords=${keywords }&infoClassId=${clazz.id }&city=${city }&page=1">${clazz.title }</a></li>
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
        
    </div>
    
</body>
</html>
