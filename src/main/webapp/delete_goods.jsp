<%--
  Created by IntelliJ IDEA.
  User: 12755
  Date: 2024/11/28
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>删除商品</title>
    <script>
        function confirmDelete() {
            return confirm("删除商品后会删除所有的该商品的未支付订单，是否继续？");
        }
    </script>
</head>
<body style="background-color: rgb(226, 229, 231)">
<h3>修改商品</h3>
<form action="deletegoodsServlet" method="post" onsubmit="return confirmDelete()">
    <input type="hidden" name="id" value="${goods.goods_id}">
    名字<input name="name" value="${goods.goods_name}" readonly><br>
    价格<input name="price"value="${goods.price}" oninput="value=value.replace(/[^\-?\d.]/g,'')" readonly><br>
    介绍<textarea rows="5" cols="20" name="description" readonly> ${goods.description}</textarea>
    <input type="submit" value="确认删除该商品">
</form>
<p><a href="mall.jsp">返回</a> </p>
</body>
