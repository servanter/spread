<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<div class="side_box">
	<h2>每日排行</h2>
	<ul class="sub-main rank-ul">
	
		<c:forEach var="hot" items="${hotWeChats}" varStatus="i">
			<c:choose>
				<c:when test="${i.count == 1}">
					<li class="hover">
				</c:when>
				<c:otherwise>
					<li>
				</c:otherwise>
			</c:choose>
             <a class="rank-item" href="${ctx }/weChat/${hot.id }/" target="_blank">
                 <span class="rank-num fl">${i.count }</span>
                 <p class="rank-tit fl">${hot.name }</p>
             </a>
             <a class="rank-detail" href="${ctx }/weChat/${hot.id }/" target="_blank">
                 <span class="rank-num rank-num-d fl">${i.count }</span>
                 <div class="rank-thumb fl">
                     <img src="${imgPath }/${hot.rowIcon }" alt="" class="fl">
                     <div class="rank-info fl">
                         <p class="rank-type d-5f">${hot.infoClass.title }</p>
                         <p class="rank-name">${hot.name }</p>
                     </div>
                 </div>
             </a>
         </li>
		</c:forEach>
        <div class="clear"></div>
    </ul>
</div>