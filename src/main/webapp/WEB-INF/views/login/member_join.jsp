<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
    <meta name="generator" content="Hugo 0.104.2">
    <title>Checkout example · Bootstrap v5.2</title>

    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/docs/5.2/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/5.2/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/5.2/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/5.2/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
    <link rel="icon" href="/docs/5.2/assets/img/favicons/favicon.ico">
    <meta name="theme-color" content="#712cf9">


    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .b-example-divider {
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }

        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }

        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }

        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }

        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }

        .star{
            color: red;
        }
    </style>


    <!-- Custom styles for this template -->
    <link href="/css/form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- 유효성 검사에 걸렸을 때의 alert 창 -->
<c:if test="${not empty msg}">
    <script>
        function validateForm() {
            return false;
        }
        validateForm();
        alert("${msg}");
    </script>
</c:if>

<div class="container" style="width: 60%">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-2" src="/img/gdgd.jpg" alt="" width="150" height="150">
        </div>

        <div class="row g-5">
            <h4 class="mb-3">회원가입</h4>
            <hr class="my-4">
            <form class="needs-validation" action="/newMem/insert" method="post">
                <input type="hidden" id="email" name="email" value="">
                <input type="hidden" id="phone" name="phone" value="">
                <input type="hidden" id="baseAdres" name="baseAdres" value="">
                <div class="row g-3">
                    <div class="row">
                        <label for="memId" class="form-label">아이디<b><span class="star">*</span></b></label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="memId" name="memId" placeholder="아이디를 입력하세요." value="" required>
                                <div class="invalid-feedback">
                                    아이디를 입력하신 후 중복확인을 해주세요.
                                </div>
                            </div>
                            <div class="col-sm-3"><button class="btn btn-sm btn-outline-success mt-1">중복확인</button></div>
                    </div>

                    <div class="col-12">
                        <label for="memName" class="form-label">이름<b><span class="star">*</span></b></label>
                        <input type="text" class="form-control" id="memName" name="memName" placeholder="이름을 입력하세요." value="" required>
                        <div class="invalid-feedback">
                            이름을 입력해주세요
                        </div>
                    </div>

                    <div class="col-12" id="memPw">
                        <label for="memPassword" class="form-label">비밀번호<b><span class="star">*</span></b></label>
                        <input type="password" class="form-control" id="memPassword" name="memPassword" placeholder="비밀번호를 입력하세요.(숫자,문자,특수문자 한개이상씩 8~20자리)" value="" required>
                        <input type="password" class="form-control mt-1" id="memPassword1" placeholder="비밀번호를 한번 더 입력하세요." value="" required>
                        <div class="invalid-feedback">
                            비밀번호를 확인해주세요.
                        </div>
                    </div>

                    <div class="col-12">
                        <div class="row">
                            <label for="email1" class="form-label">이메일<b><span class="star">*</span></b></label>
                            <div class="col"><input type="text" class="form-control" id="email1" placeholder="이메일 아이디" required></div>
                            <div class="col"><input type="text" class="form-control" id="email2" placeholder="이메일을 선택하세요." required></div>
                            <div class="col">
                                <select class="form-select col" name="select" id="emailSelect" required>
                                    <option value="1">직접입력</option>
                                    <option value="@naver.com">@naver.com</option>
                                    <option value="@yahoo.com">@yahoo.com</option>
                                    <option value="@nate.com">@nate.com</option>
                                </select>
                            </div>
                            <div class="col"><button class="btn btn-sm btn-outline-success mt-1" id="idck"> 중복확인 </button></div>
                        </div>
                        <div class="invalid-feedback">
                            이메일을 입력해주세요.
                        </div>
                    </div>

                    <div>
                        <label for="zipcode" class="form-label">주소<b><span class="star">*</span></b></label>
                        <div class="row">
                            <div class="col-9"><input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="우편번호" required></div>
                            <div class="col-3"><button class="btn btn-sm btn-outline-success mt-1" onclick="daumPostcode()" type="button" >우편번호 찾기</button></div>
                        </div>
                        <input type="text" class="form-control mt-2" id="streetAdr" placeholder="기본주소" required>
                        <input type="text" class="form-control mt-2" id="extraAdr" placeholder="참고">
                        <input type="text" class="form-control mt-2" id="detailAdr" name="detailAdres" placeholder="상세주소" required>
                        <div class="invalid-feedback">
                            주소를 입력해주세요.
                        </div>
                    </div>

                    <div>
                        <label for="mempho" class="form-label" >번호<b><span class="star">*</span></b></label>
                        <div class="row">
                            <div class="col">
                                <select class="form-select" id="memPho" required>
                                    <option value="010">010</option>
                                    <option value="011">011</option>
                                    <option value="019">019</option>
                                </select>
                            </div>
                            -
                            <div class="col"><input id="memPho1" value="" type="number" maxlength="4" oninput="numberMaxLength(this)" class="form-control" placeholder="xxxx" required></div>
                            -
                            <div class="col"><input id="memPho2" value="" type="number" maxlength="4" oninput="numberMaxLength(this)" class="form-control"placeholder="xxxx" required></div>
                            <div class="invalid-feedback">
                                번호를 정확히 입력해주세요.
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <hr class="my-4">

                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button class="btn btn-primary" id="joinBtn" type="submit">가입하기</button>
                    <button class="btn btn-outline-primary" onclick="location.href='/'" type="button">취소</button>
                </div>
            </form>

        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017–2023 Company Name</p>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="#">Privacy</a></li>
            <li class="list-inline-item"><a href="#">Terms</a></li>
            <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
    </footer>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<script src="/js/form-validation.js"></script>
</body>
</html>

<!-- 아이디 중복 검사 -->
<script>


</script>



<script>
    $(document).ready(function (){
        <!-- 저장 버튼 클릭 -->
        $('#joinBtn').click(function() {
           // 입력확인
            console.log("버튼 눌러버림 ");
            var id = $('#memId').val();
            var email1 = $('#email1').val();
            var email2 = $('#email2').val();
            var pw1 = $('#memPassword').val();
            var pw2 = $('#memPassword1').val();
            var streetAdr = $('#streetAdr').val();
            var extraAdr = $('#extraAdr').val();
            var detailAdr = $('#detailAdr').val();
            var mempho = $('#memPho').val();
            var mempho1 = $('#memPho1').val();
            var mempho2 = $('#memPho2').val();
            var pwChk = /^(?=.*?[0-9])(?=.*?[A-Za-z])(?=.*?[#?!@$ %^&*~-]).{8,20}$/;    // 비밀번호 정규식(숫자,문자,특수문자 8~20)
            var emailChk1 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*$/;       // 이메일 정규식
            var emailChk2 = /^@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;        // 이메일 정규식

            // 비밀번호 형식 체크
            // if(pw1 == pw2) {
            //     console.log(pw1);
            //     // 정규식 체크
            //     if (pw1.match(pwChk) == null && pw2.match(pwChk) == null){
            //         alert("비밀번호는 숫자, 문자, 특수문자를 포함한 8~20자리 입력해주세요.");
            //         pwNull();
            //         return false;
            //     }
            //     if (pw1.search(/\s/) != -1){
            //         alert("비밀번호는 공백 없이 입력해주세요.")
            //         pwNull();
            //         return false;
            //     }
            // } else if(pw1 != pw2){
            //     alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            //     pwNull();
            //     return false;
            // }
            //
            // // 이메일 형식 체크
            // if(email1 != null && email2 != null ){
            //     // 정규식체크
            //     if(email1.match(emailChk1) == null && email2.match(emailChk2) == null ){
            //         alert("이메일 형식에 맞게 기입해주세요.");
            //         $('#email1').focus();
            //         return false;
            //     }
            // }

            // memEmail 인풋값
            var memEmail = email1 + email2;
            $('#email').val(memEmail);

            // memphone 인풋값
            var memphone = mempho + mempho1 + mempho2;
            $('#phone').val(memphone);
            console.log("phone 인풋에 담긴 값 => " + memphone);

            // baseAdres 인풋값
            var baseAdres = streetAdr + extraAdr;
            $('#baseAdres').val(baseAdres);
            console.log("baseAdres 인풋에 담긴 값 => " + baseAdres);

            // document.getElementById('#joinBtn').submit();


        });
    });

    <!-- 번호 4자리까지만 입력 제한 -->
    function numberMaxLength(e){
        if(e.value.length > e.maxLength){
            e.value = e.value.slice(0, e.maxLength);
        }
    }

    <!-- 비밀번호가 조건에 맞지않을 시 값 초기화 -->
    function pwNull(){
        $("#memPw input").each(function () {
            $(this).val("");
        });
        $('#memPassword').focus();
    }

    <!-- 이메일 도메인 선택(직접입력) -->
    $(function() {
        $('#emailSelect').change(function() {
            if ($(this).val()=="1"){
                $('#email2').val("");
                $("#email2").attr("readonly", false);
            } else {
                $('#email2').val($(this).val());
                $("#email2").attr("readonly", true);
            }
        });
    });

</script>



<!-- 우편번호 찾기 api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function daumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R') {
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraAddr !== '') {
                        extraAddr = ' (' + extraAddr + ')';
                    }

                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("extraAdr").value = extraAddr;

                } else {
                    document.getElementById("extraAdr").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("zipcode").value = data.zonecode;
                document.getElementById("streetAdr").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAdr").focus();
            }
        }).open();
    }
</script>


