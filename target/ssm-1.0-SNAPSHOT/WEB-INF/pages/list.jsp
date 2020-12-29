<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js" type="text/javascript"></script>
</head>
<body>
    <a href="${pageContext.request.contextPath}/account/toAddPage">添加</a>
    <hr/>
    <table border="1">
        <thead>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>金额</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="a">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.name}</td>
                    <td>${a.money}</td>
                    <td><a href="${pageContext.request.contextPath}/account/toUpdatePage?id=${a.id}">修改</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
