<%@ page import="com.example.selfstudy.vo.Vo_study" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <% List<Vo_study> list = (List<Vo_study>) request.getAttribute("list"); %> -->
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<!-- 헤더 -->
<%@include file="/WEB-INF/views/comm/header.jsp"%>
<main>

    <div class="container text-center">
        <div class="row mb-4">
            <div> <button style="float: right;" onclick="location.href='/study_reg/insert'">등록하기</button></div>
            <div class="col">No</div>
            <div class="col">공부일자</div>
            <div class="col">공부내용</div>
            <div class="col">등록일자</div>
            <div class="col">수정</div>
            <div class="col">삭제</div>
        </div>
    </div>

    <c:forEach var="item" items="${list}">
        <div class="container text-center">
            <div class="row mb-4">
                <div class="col">${item.id}</div>
                <div class="col">${item.studyDay}</div>
                <div class="col">${item.contents}</div>
                <div class="col">${item.regDay}</div>
                <div class="col"> <a href="/study_reg/modify?id=${item.id}">수정</a> </div>
                <div class="col"> <a href="/study_reg/delete?id=${item.id}">삭제</a> </div>
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