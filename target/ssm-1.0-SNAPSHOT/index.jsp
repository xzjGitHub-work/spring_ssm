<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery.min.js"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button onclick="send()">
    发送请求
</button>
<script>
    function send() {
        $.post("http://localhost:8080/account/findAll","",function (data) {
            alert(data)
        })
        // location.href
        // $.post({
        //
        // }).ajax({
        //     url:"http://localhost:8080/route/openPlatform/developLogin.shtml",
        //     data:{"phone":15265855235,},
        //     type:"POST",
        //     success:function(result){
        //         alert(result)
        //     }});

    }
</script>
</body>
</html>
