<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<%@ taglib uri ="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加商品</title>
</head>
<body>
<a href="?language=en">english</a>|<a href="?language=zn">中文</a>
<hr>
<h3><spring:message code='please.input.product.info'/></h3>
<form:form action="add" method="post" modelAttribute="newProduct" enctype="multipart/form-data">
<spring:message code="product.id"/>:<form:input path="productId" id="prod"/><br>
商品名称:<form:input path="name" /><br>
价格:<form:input path="price" /><br>
描述:<br>
<form:textarea path="desc"/><br>
制造商:<form:input path="manufacturer"/><br>
分类:<form:input path="category"/><br>
库存数量:<form:input path="unitsInStock"/><br>
<!-- 
订单数量:<form:input path="unitsInOrder"/><br>

是否继续：<form:checkbox path="discontinued"/><br> -->
商品状态:<form:radiobutton path="condition" value='new'/>新
<form:radiobutton path="condition" value='old'/>旧
<form:radiobutton path="condition" value='refurbished'/>翻新<br>
生产日期<form:input   path="pubDate"/><br>
上传产品图片:<form:input path="productImageFile" type='file'/><br>
<input type='submit' value='add'>


</form:form>
</body>
</html>