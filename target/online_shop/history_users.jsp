<%--
  Created by IntelliJ IDEA.
  User: 12755
  Date: 2024/11/28
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>购买记录</title>
</head>
<body style="background-color: rgb(226, 229, 231)">
<table>
  <p> <a href="mall.jsp">返回商城主页</a> </p>
  <h1>${user.user_name}的购买记录</h1>

</table>

<table border="1" cellspacing="0" width="800">
  <tr>
    <th>订单ID</th>
    <th>商品ID</th>
    <th>商品名字</th>

    <th>价格</th>
    <th>数量</th>
    <th>购买时间</th>
  </tr>
  <c:forEach items="${orderhistory}" var="cart">
    <tr>
      <td>${cart.order_id}</td>
      <td>${cart.goods_id}</td>
      <td>${cart.goods_name}</td>

      <td>${cart.price}</td>
      <td>${cart.quantity}</td>
      <td>${cart.updated_at}</td>


    </tr>
  </c:forEach>
</table>


</body>
</html>