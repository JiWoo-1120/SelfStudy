<%@ page import="com.example.selfstudy.vo.Vo_study" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<!-- 헤더 -->
<%@include file="/WEB-INF/views/comm/header.jsp"%>
<main>
    <div class="container
">
    <h1> 축하합니다 <c:out value="${memVo.memName}" />님<br>회원가입을 완료하셨습니다 ^^</h1>
    </div>
</main>

<!-- 푸터 -->
<%@include file="/WEB-INF/views/comm/footer.jsp"%>

</body>
</html>


