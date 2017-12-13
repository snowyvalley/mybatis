<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
function submitFrm(){
	document.getElementById("frm").action;
	brand = document.getElementById("brand").value;
	category = document.getElementById("category").value;
	
	alert(brand);
	alert(category);
	document.getElementById("frm").action="/webstore2/filter/ByCriteria;brand="+brand+";category="+category+";"
	alert(document.getElementById("frm").action);
	document.getElementById("frm").submit();
	
}

</script>
<title>商品列表</title>
</head>
<body>
<h3>商品列表页面</h3>
<form action="filter/ByCriteria" method="post" id='frm'>
品牌:<input type="text" id='brand' value="">(使用逗号分隔) 分类:<input type='text' id='category' value="">(使用逗号分隔) 
<input type='button' value='search' onclick="submitFrm()">
</form><br>
<a href="<spring:url value='/add'/>">添加商品</a>
<hr>
<c:forEach var="product" items="${products }">
商品id:${product.productId }<br>
商品名称:${product.name}<br>
价格:${product.price }<br>
描述:${product.desc}<br>
厂商:${product.manufacturer }<br>
分类:${product.category }<br>
库存数量:${product.unitsInStock }<br>
<a href="<spring:url value='/order?pid=${product.productId }&quantity=1'/>">订购此商品</a>|<a href="product?pid=${product.productId }">详情</a>
<hr>
</c:forEach>
</body>
</html>