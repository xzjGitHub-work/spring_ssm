<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <%response.sendRedirect(request.getContextPath()+"/account/findAll");%>--%>
<button onclick="send()">
    发送请求
</button>
<script>
    function send() {
        $.ajax({
            url:"http://localhost:8090/route/openPlatform/developLogin.shtml",
            data:{"phone":15265855235,},
            type:"POST",
            success:function(result){
                alert(result)
            }});

    }
</script>
</body>
</html>
