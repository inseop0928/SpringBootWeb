<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP CRUD TEST</title>
    <jsp:include page="testCommon.jsp"></jsp:include>
    <script src="/js/testIndex.js"></script>

   <%-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>--%>
    <script>
        $(document).ready(function(){


        });

    </script>


</head>
<body>
<h2>게시판</h2>
<br/>
<form>

    <div class ="col-md-12">
        <div class="row">
            <div class="col-md-6">
                <a href="/testJspInfo" role="button" class="btn btn-primary">글등록</a>
            </div>
        </div>
        <br/>

        <table class="table table-horizontal table-bordered">
            <thead class ="thead_strong">
                <tr>
                    <th>순번</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>최종수정일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" varStatus="idx" items="${list}">
                    <tr>
                        <td>${item.seq}</td>
                        <td><a href="/testJspInfo?seq=${item.seq}">${item.title}</a></td>
                        <td>${item.content}</td>
                        <td>${item.regDt}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</form>
</body>
</html>

