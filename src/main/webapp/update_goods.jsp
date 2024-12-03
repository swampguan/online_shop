<%--
  Created by IntelliJ IDEA.
  User: 12755
  Date: 2024/11/28
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品</title>
</head>
<body style="background-color: rgb(226, 229, 231)">

<form action="updategoodsServlet" method="post">
<input type="hidden" name="id" value="${goods.goods_id}">
名字<input name="name" value="${goods.goods_name}"><br>
价格<input name="price" value="${goods.price}" oninput="value=value.replace(/[^\-?\d.]/g,'')"><br>
介绍<textarea rows="5" cols="20" name="description">
    ${goods.description}
</textarea>
<input type="submit" value="提交">
</form>
<p><a href="mall.jsp">返回商城首页</a></p>
</body>
<script>
    document.getElementById("updateForm").addEventListener("submit", function(event) {
        event.preventDefault(); // Prevent the form from submitting normally

        var nameInput = document.querySelector('input[name="name"]');
        var priceInput = document.querySelector('input[name="price"]');
        var descriptionTextarea = document.querySelector('textarea[name="description"]');

        if (nameInput.value.trim() === "" || priceInput.value.trim() === "" || descriptionTextarea.value.trim() === "") {
            alert("所有的表单数据都不能为空，请重新填写.");
        } else {
            // Submit the form
            this.submit();
        }
    });
</script>
</html>
