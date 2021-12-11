<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<a href="/shirossm/goEdit">新增</a>
<table width="50%" align="center" border="1">
    <tr>
        <td>用户编号</td>
        <td>用户名</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${users}" var="i">
        <tr>
            <td>${i.userid}</td>
            <td>${i.username}</td>
            <td>
                <a href="/shirossm/goUpdate?userId=${i.userid}">修改</a>
                <a href="javascript:mya(${i.userid})">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    function mya(userid){
        var f=confirm("是否确认删除？");
        if(f){
            location.href="/shirossm/user/deluser?userId="+userid;
        }
    }
</script>
</body>
</html>
