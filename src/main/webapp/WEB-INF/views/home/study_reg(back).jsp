<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/views/comm/header.jsp"%>
<main>
    <div class="container text-center">
        <div class="row mb-4">
            <div class="col">No</div>
            <div class="col">공부일자</div>
            <div class="col">공부내용</div>
            <div class="col">등록일자</div>
        </div>
    </div>
    <c:forEach var="item" items="${list}">
        <div class="container text-center">
            <div class="row mb-4">
                <div class="col">${item.id}</div>
                <div class="col">${item.study_day}</div>
                <div class="col">${item.contents}</div>
            </div>
        </div>
    </c:forEach>
<%--    <% for(Map<String, String> map : list) { %>--%>
<%--    <% } %>--%>
</main>

<!-- 푸터 -->
<%@include file="/WEB-INF/views/comm/footer.jsp"%>

</body>
</html>