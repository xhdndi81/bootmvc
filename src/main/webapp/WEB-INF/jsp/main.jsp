<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>    

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <title>JSP Title</title>

    <script>

        jQuery.fn.serializeObject = function() { 
            var obj = null; 
            try { 
                if(this[0].tagName && this[0].tagName.toUpperCase() == "FORM" ) { 
                    var arr = this.serializeArray(); 
                    if(arr){ obj = {}; 
                    jQuery.each(arr, function() { 
                        obj[this.name] = this.value; }); 
                    } 
                } 
            }catch(e) { 
                alert(e.message); 
            }finally {} 

            return obj; 
        }

        $(function() {

            $('#btn').click(function() {

                var jsonObj = JSON.stringify( $('#frm').serializeObject() );

                $.ajax({
                    type: 'post',
                    url: '/update',                    
                    dataType: 'json',
                    contentType: 'application/json; charset=UTF-8',
                    data: jsonObj,
                    error: function(err) {
                        console.log('저장중 오류 발생', err);
                    },
                    success: function(res) {
                        console.log('저장완료', res);
                    }
                    
                });
            });

            $('#btn_del').click(function() {

                $('#frm').attr('action', '/delete').submit();
            });

            $('#btn_ins').click(function() {

                var jsonObj = JSON.stringify( $('#frm').serializeObject() );

                $.ajax({
                    type: 'post',
                    url: '/insert',                    
                    dataType: 'json',
                    contentType: 'application/json; charset=UTF-8',
                    data: jsonObj,
                    error: function(err) {
                        alert('저장 중 오류 발생');
                    },
                    success: function(res) {
                        $('#frm').attr('method', 'get')
                                 .attr('action', '/main')
                                 .submit();
                    }
                    
                });
            });
        });
    </script>
    
</head>
<body>
    <h1>Main Jsp Page & Use JSTL</h1>

    <c:forEach var="item" items="${list}">
        <p>${item.ID} / ${item.NAME} / ${item.EMAIL}</p>        
    </c:forEach>

    <br>

    <h1>찾은 사용자</h1>
    <p>${user.ID} / ${user.NAME} / ${user.EMAIL}</p>    

    <br>    

    <h2>사용자 변경</h2>
    <form id="frm" action="/update" method="post">
        <input type="text" name="ID" value="${user.ID}">
        <input type="text" name="NAME" value="${user.NAME}">
        <input type="text" name="EMAIL" id="EMAIL" value="${user.EMAIL}">
        <Button type="button" id="btn">변경</Button>
    </form>

    <br>

    <Button type="button" id="btn_ins">추가</Button>
    <Button type="button" id="btn_del">삭제</Button>

    <br>
    <br>    

</body>
</html>