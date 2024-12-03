<%--
  Created by IntelliJ IDEA.
  User: 12755
  Date: 2024/11/28
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加到购物车</title>
</head>
<body style="background-color: rgb(226, 229, 231)">
<form action="addOrderServlet" method="post">
  <input type="hidden" name="goods_id" value="${goods.goods_id}">
  <input type="hidden" name="user_id" value="${user.user_id}">
  名字<input name="goods_name" value="${goods.goods_name}" readonly><br>
  价格<input name="price"value="${goods.price}" oninput="value=value.replace(/[^\-?\d.]/g,'')" readonly><br>
  <%--    介绍<textarea rows="5" cols="20" name="description"> ${goods.description}</textarea>--%>
  购买数量<input name="quantity" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" REQUIRED>
  <input type="submit" value="提交">
</form>
<p><a href="mall.jsp">返回商城</a> </p>
</body>
</html>
