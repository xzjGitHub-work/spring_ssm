<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/account/saveAccount" method="post">
        姓名：<input type="text" name="name"><br/>
        金额：<input type="text" name="money"><br/>
        <input type="submit" value="保存">
    </form>
</body>
</html>
