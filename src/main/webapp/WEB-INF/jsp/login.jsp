<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>用户登录</title>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function sub(value) {
        var action_url;
        if (value === "登录") {
            action_url = "${pageContext.request.contextPath}/user/testSave";
        }else {
            action_url = "${pageContext.request.contextPath}/user/testSave";
        }

        var $user_form = $("#user_form");
        $user_form.attr("action", action_url);
        $user_form.submit();
    }
</script>
<form id="user_form" method="post">
    <table>
        <tr>
            <td>账&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
            <td><input name="email" type="text"/></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
            <td><input name="password" type="password"/></td>
        </tr>
        <tr>
            <td><input value="登录" type="submit" onclick="sub(this.value)"/></td>
            <td><input value="注册" type="submit" onclick="sub(this.value)"/></td>
        </tr>
    </table>
</form>
</body>

</html>