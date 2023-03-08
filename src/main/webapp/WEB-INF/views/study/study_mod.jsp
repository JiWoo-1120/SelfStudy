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
</head>
<body>

<!-- 헤더 -->
<%@include file="/WEB-INF/views/comm/header.jsp"%>


<main>
    <form name="frm_study_mod" action="/study_reg/modify_exe" method="post">
        <div class="container px-4">
            <div class="col mt-3">keyID:     <input name="id" value="<c:out value="${vo_study.id}" default="데이터가 없습니다." />" disabled style="border:0 solid black;"> </div>
            <div class="col mt-3">           <input name="id" value="<c:out value="${vo_study.id}"/>" type="hidden"> </div>
            <div class="col mt-3">StudyDay:  <input name="studyDay" value="<c:out value="${vo_study.studyDay}" default="데이터가 없습니다." />" class="form-control gy-5"  style="width: 200px" type="text"></div>
            <div class="col my-3">Contents:  <input name="contents" value="<c:out value="${vo_study.contents}" default="데이터가 없습니다." />" class="form-control gy-5" style="width: 600px" type="text"></div>
            <input type="submit" value="수정하기">
        </div>
    </form>


</main>


<!-- 푸터 -->
<%@include file="/WEB-INF/views/comm/footer.jsp"%>

</body>
</html>