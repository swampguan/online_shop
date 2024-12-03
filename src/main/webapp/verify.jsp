<%--
  Created by IntelliJ IDEA.
  User: 12755
  Date: 2024/11/28
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>确认支付</title>
</head>
<body style="background-color: rgb(226, 229, 231)">
<h3>确认购买</h3>
<table border="1" cellspacing="0"width="800" >
    <tr>
        <th>购物车ID</th>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品数量</th>

    </tr>
    <c:forEach items="${orderList}" var="order">
        <tr>
            <td>${order.order_id}</td>
            <td>${order.goods_id}</td>
            <td>${order.goods_name}</td>
            <td>${order.price}</td>
            <td>${order.quantity}</td>


        </tr>
    </c:forEach>
    <tr>
        总价格:${totalprice}<input type="button" value="支付" id="purchase">
    </tr>
</table>
<p><a href="order.jsp">返回购物车</a> </p>
<script>
    document.getElementById("purchase").onclick=function ()
    {
        location.href="purchaseServlet?operation=1";
    }

</script>
</body>
</html>
