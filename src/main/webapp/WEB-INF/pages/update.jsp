<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/account/updateAccount" method="post">
        <input type="hidden" name="id" value="${account.id}">
        姓名：<input type="text" name="name" value="${account.name}"><br/>
        金额：<input type="text" name="money" value="${account.money}"><br/>
        <input type="submit" value="保存">
    </form>
</body>
</html>
