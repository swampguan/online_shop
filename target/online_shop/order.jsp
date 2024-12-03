<%--
  Created by IntelliJ IDEA.
  User: 12755
  Date: 2024/11/28
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
</head>
<body style="background-color: rgb(226, 229, 231)">
<table>
    欢迎,${user.user_name}
    <p><a href="mall.jsp">返回商城</a> </p>

</table>

<table border="1" cellspacing="0"width="800" >
    <tr>
        <th>订单ID</th>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品数量</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${orderList}" var="order">
        <tr>
            <td>${order.order_id}</td>
            <td>${order.goods_id}</td>
            <td>${order.goods_name}</td>
            <td>${order.price}</td>
            <td>${order.quantity}</td>

            <td><a href="selectOrderServlet?id=${order.order_id}&operation=1">修改 </a>
                <a href="selectOrderServlet?id=${order.order_id}&operation=2">删除 </a>
                    <%--                <a href="/online_shop_war/selectidServlet?id=${goods.id}&operation=3">添加至购物车</a>--%>
            </td>

        </tr>
    </c:forEach>
    <tr>
        总价格:${totalprice}<input type="button" value="结算" id="purchase">
    </tr>
</table>


<script>
    document.getElementById("purchase").onclick=function ()
    {
        location.href="verify.jsp";
    }

</script>
</body>
</html>
