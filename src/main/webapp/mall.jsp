

<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城首页</title>
    <link rel="stylesheet" href="<c:url value="/css/mall.css"/>">
</head>
<body style="background-color: rgb(226, 229, 231);">


<div class="header motif">
    <div class="logo">
        <img src="<c:url value="/imgs/logo.png"/>" alt="" height="42px"></img>
    </div>
    <div class="nav">
        <ul>
            <c:if test="${user.user_name !='admin'}"> <li><a href="orderServlet">购物车</a></li></c:if>
            <c:if test="${user.user_name =='admin'}"><li><a href="historyServlet?operation=1">购买总记录 </a></li></c:if>
            <c:if test="${user.user_name !='admin'}"> <li> <a href="historyServlet?operation=2&usersid=${user.user_id}">订单记录</a></li> </c:if>
            <c:if test="${user.user_name =='admin'}">  <li>  <a href="historyServlet?operation=3">商品销售记录</a></li></c:if>
        </ul>
    </div>
    <div class="user">
        <img src="<c:url value="/imgs/user.jpg"/>" alt="" height="42px">${user.user_name} <a href="logoutServlet">  退出登录</a>

    </div>
</div>

<div class="motif">


<table>


    <form action="mallSearchServlet" method="post">
        <label for="name">商品名:</label>
        <input type="text" id="name" name="name" >
        <label for="id">商品id:</label>
        <input type="text" id="id" name="id"   oninput="value=value.replace(/^(0+)|[^\d]+/g,'')">

        <input type="submit" value="查询">
    </form>
</table>
<c:if test="${user.user_name =='admin'}">
    <input type="button" value="新增" id="add"><br>
</c:if>

<table  border="1" cellspacing="0" width="800">
    <tr>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品介绍</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${goodsList}" var="goods">
        <tr>
            <td>${goods.goods_id}</td>
            <td>${goods.goods_name}</td>
            <td>${goods.price}</td>
            <td>${goods.description}</td>
            <td>
                <c:if test="${user.user_name =='admin'}">
                    <a href="selectIdServlet?id=${goods.goods_id}&operation=1">修改 </a>
                    <a href="selectIdServlet?id=${goods.goods_id}&operation=2">删除 </a>
                </c:if>
                <c:if test="${user.user_name !='admin'}">
                    <a href="selectIdServlet?id=${goods.goods_id}&operation=3">添加至购物车</a>
                </c:if>
            </td>

        </tr>
    </c:forEach>
</table>
</div>
<script>
    document.getElementById("add").onclick = function () {
        location.href = "add_goods.jsp";
    }

</script>

</body>

</html>
