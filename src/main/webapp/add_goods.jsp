<%--
  Created by IntelliJ IDEA.
  User: 12755
  Date: 2024/11/28
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body style="background-color: rgb(226, 229, 231)">

<h3>添加商品</h3>
<form action="addgoodsServlet" method="post" id="addgoods">
    名字<input name="name"><br>
    价格<input name="price" oninput="value=value.replace(/[^\-?\d.]/g,'')" ><br>
    介绍<textarea rows="5" cols="20" name="description" ></textarea><br>
    库存数量<input name="quantity" oninput="value=value.replace(/[^\-?\d.]/g,'')" ><br>
    <input type="submit" value="提交">
</form>
<p><a href="mall.jsp">返回商城主页</a> </p>

<script>
    // 表单提交事件处理函数
    function submitForm() {
        // 获取表单元素
        var form = document.getElementById("addgoods");

        // 表单提交
        form.submit();

        // 重置表单
        form.reset();
    }
</script>
</body>
