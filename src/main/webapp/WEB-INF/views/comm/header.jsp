<%--
 헤더 파일
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="/home/study_reg" class="nav-link px-2 text-white">공부일지</a></li>
                <li><a href="/home/member_list" class="nav-link px-2 text-white">회원목록</a></li>
                <li><a href="/base" class="nav-link px-2 text-white">About</a></li>
            </ul>

            <div class="text-end">
                <button type="button" class="btn btn-outline-light me-2" onclick="location.href='/login/login'">Login</button>
                <button type="button" class="btn btn-warning" onclick="location.href='/member/insert1'">Sign-up</button>
            </div>
        </div>
    </div>
</header>

