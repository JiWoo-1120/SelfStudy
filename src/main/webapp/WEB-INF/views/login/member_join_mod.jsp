<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<!-- 헤더 -->
<%@include file="/WEB-INF/views/comm/header.jsp"%>
<link rel="stylesheet" href="/css/login.css">

<main class="form-signin w-100 m-auto">
    <!-- member, admin 데이터 값 -->
    <input value="<c:out value="${memberVo.role}"/>" id="roleVal" type="text">
    <form action="/member/modify_exe" method="post">
        <h1 class="h3 mb-3 fw-normal">Please Sign-up</h1>

        <input type="date" id="todayDate" style="border:0 solid black" readonly>
        <input type="text" name="memberId" value="<c:out value="${memberVo.memberId}"/>">

        <div class="form-floating">
            <input type="text" value="<c:out value="${memberVo.loginId}"/>" name="loginId" class="form-control" id="floatingInput">
            <button id="chkId" class="w-30 btn btn-sm btn-primary" type="submit"> 아이디 중복 체크</button>
            <label for="floatingInput">Login ID</label>
        </div>
        <div class="form-floating">
            <input type="text" value="<c:out value="${memberVo.password}"/>" name="password" class="form-control" id="floatingPassword">
            <label for="floatingPassword">Password</label>
        </div>
        <div class="form-floating">
            <input type="text" value="<c:out value="${memberVo.name}"/>" name="name" class="form-control">
            <label for="floatingPassword">Name</label>
        </div>
        <div style="margin-bottom: 10px; margin-top: 10px" >
        <div class="form-check form-check-inline">
            <input value="member" name="role" id="member" class="form-check-input" type="radio" checked>
            <label class="form-check-label" for="member">
                member
            </label>
        </div>
        <div class="form-check form-check-inline">
            <input value="admin" name="role" id="admin" class="form-check-input" type="radio">
            <label class="form-check-label" for="admin">
                admin
            </label>
        </div>
        </div>

        <!-- 저장 버튼 -->
        <button class="w-100 btn btn-lg btn-primary" type="submit">수정하기</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2017–2023</p>
    </form>


    <!-- 홈 버튼 -->
    <button class="w-20 btn btn-sm btn-primary" style="float: top;" onclick="location.href='/'">홈화면으로</button>
</main>


<!-- 푸터 -->
<%@include file="/WEB-INF/views/comm/footer.jsp"%>
</body>
</html>

<script>
    $(document).ready(function () {

        var chkValMem = $('#member').val();
        var chkValAdm = $('#admin').val();
        var chkRoleVal = $('#roleVal').val();

        console.log("chkValMem => " + chkValMem);
        console.log("chkValAdm => " + chkValAdm)
        console.log("chkRoleVal => " + chkRoleVal)

        if(chkRoleVal == "member"){
            $('#member').attr('checked', true);
            $('#admin').attr('checked', false);
        } else if(chkRoleVal == "admin") {
            $('#member').attr('checked', false);
            $('#admin').attr('checked', true);

        }




    });


    <!-- 현재 날짜 나오게 -->
    document.getElementById('todayDate').valueAsDate = new Date();
</script>