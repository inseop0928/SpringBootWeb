<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP CRUD TEST</title>

<%--    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>--%>
    <jsp:include page="testCommon.jsp"></jsp:include>

    <script src="/js/testIndex.js"></script>

   <%-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>--%>
    <script>

        $(document).ready(function(){

            $('#test-save').on('click',function(){

                fn_save();
            })

            $('#test-delete').on('click',function(){

                fn_delete();
            })


        });

        function fn_save(){

            var data = {
                title : $('#title').val(),
                content : $('#content').val(),
                seq : $('#seq').val()
            }

            $.ajax({
                type :'POST',
                url : '/test/saveTest',
                dataType :'json',
                contentType : 'application/json;charset=utf-8',
                data:JSON.stringify(data)
            }).done(function(){
                alert("저장이 완료되었습니다.");
                window.location.href = '/testJspList';
            }).fail(function (error){
                alert(JSON.stringify(error));
            })
        }


        function fn_delete(){
            var data ={
                seq : $('#seq').val()
            }

            $.ajax({
                type: 'DELETE',
                url : '/test/deleteTest',
                dataType: 'json',
                contentType : 'application/json;charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                alert('삭제가 완료되었습니다.');
                window.location.href='/testJspList';
            }).fail(function (error){
                alert(JSON.stringify(error));
            })
        }
    </script>


</head>
<body>
<h2>게시판</h2>
<br/>
<form>

    <input type="hidden" name ="seq" id ="seq" value='${info.seq}'>
    <div class ="col-md-12">
        <div class ="col-md-5">

        <div class="form-group">
            <label for ="title">제목</label>
            <input type ="text" id = "title" name ="title" class = "form-control" placeholder="제목" maxlength="20" value="${info.title}">
        </div>
        <div class="form-group">
            <label for ="content">내용</label>
            <textarea type ="text" id = "content" name ="content" class = "form-control" placeholder="내용" maxlength="100" style="height: 100px">${info.content}</textarea>
        </div>
        <br/>
            <div class="form-group">
                <button class="btn btn-primary" type="button" id ="test-save">저장</button>
                <c:if test="${info.seq !=null and info.seq !=''}">
                    <button class="btn btn-danger" type="button" id ="test-delete">삭제</button>
                </c:if>
                <a href ="/" class="btn btn-secondary" type="button">취소</a>
            </div>
        </div>
    </div>
</form>
</body>
</html>

