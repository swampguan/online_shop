<%--
  Created by IntelliJ IDEA.
  User: 12755
  Date: 2024/11/30
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更新订单信息</title>
</head>
<body style="background-color: rgb(226, 229, 231)">
<h3>修改订单</h3>
<form action="updateOrderServlet" method="post">
    <input type="hidden" name="id" value="${order.order_id}">
    ID<input name="name" value="${order.goods_id}" readonly><br>
    名字<input name="name" value="${order.goods_name}" readonly><br>
    价格<input name="price"value="${order.price}" oninput="value=value.replace(/[^\-?\d.]/g,'')" readonly><br>
    购买数量<input name="quantity" value="${order.quantity}" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" REQUIRED>
    <input type="submit" value="确认">
</form>
<p><a href="order.jsp">返回</a> </p>
</body>
</html>
