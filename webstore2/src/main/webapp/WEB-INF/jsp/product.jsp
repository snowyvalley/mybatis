<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>商品详情</title>
</head>
<body>
<h3>商品详情页面</h3>

<img src='<spring:url value="/images/${product.productId}.jpg"/>'  width="200" height="200" /><br>
商品id:${product.productId }<br>
商品名称:${product.name}<br>
价格:${product.price }<br>
描述:${product.desc}<br>
厂商:${product.manufacturer }<br>
分类:${product.category }<br>
库存数量:${product.unitsInStock }<br>
<a href="<spring:url value='/order?pid=${product.productId }&quantity=1'/>">订购此商品</a>|<a href="<spring:url value='/list'/>">返回列表</a>

<hr>

</body>
</html>