<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item</title>
<link rel="stylesheet"
	href="<%= request.getContextPath()%>/resources/css/jquery-ui.css">
<script
	src="<%= request.getContextPath()%>/resources/js/jquery-1.12.1.min.js"></script>
<script src="<%= request.getContextPath()%>/resources/js/jquery-ui.js"></script>
<link rel="stylesheet"
	href="<%= request.getContextPath()%>/resources/css/style.css">

</head>
<body>
	<div id="tabs">
	<form:form name="productForm" method="post" action="save.do"
			methodAttribute="item">
		<ul>
			<li><a href="#tabs-1">Add Item</a></li>
			<li><a href="#tabs-2" id="searchTab">Search Item</a></li>
			<li><a href="#tabs-3" id="listTab">Display Items</a></li>
			<li><a href="#tabs-4" id="updateTab">Update Items</a></li>
		</ul>
		
			<div id="tabs-1">
			<jsp:include page="error.jsp"></jsp:include>
				<input name="item_code" type="hidden" value="${item.item_code}">
				<div align="center">
					<h1>Item Details</h1>
					<table border="1">

						<tr>
							<th>Item Name</th>
							<td><input name="item_name" id="itemname" required
								value="${item.item_name}"></td>

						</tr>
						<tr>
							<th>Price</th>
							<td><input name="price" id="price" required
								value="${item.price}"></td>

						</tr>
						<tr>
							<th>Quantity</th>
							<td><input name="quantity" id="qty" required
								value="${item.quantity}"></td>

						</tr>
						<tr>
							<th><input type="submit" value="Add New Item"></th>
							<!-- <th><input type="button" value="Update" onclick="update()" />
								<input type="button" value="List" onclick="list()" /> --> 
								<th><input type="button" value="Clear" onClick="clearFields()"></th>

						</tr>

					</table>

				</div>
			</div>

		</form:form>
		<form:form name="searchForm" method="post" action="searchlist.do" methodAttribute="itemname">
		<div id="tabs-2">
		<div align="center">
			
			<table>
				<tr>
					<td>
					<input type="text" name="itemname"/>
					<%-- <select name="itemname">
							<option value="Select" label="Select Item" />
							<c:forEach var="itemname" items="${dropdownList}">
							<option value="${itemname}">${itemname}</option>
							</c:forEach>
						</select> --%>
					</td>
				<td><input type="submit" value="Search"/></td>
				</tr>
			</table>
			</div>
			<div align="center">
				<h1>Item List</h1>
				<table border="1">
					<tr>
						<th>S.No.</th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Action</th>
						<th>Action</th>

					</tr>
					<c:forEach var="item" items="${searchitemList}" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${item.item_code}</td>
							<td>${item.item_name}</td>
							<td>${item.price}</td>
							<td>${item.quantity}</td>
							<td><a href="edit.do?id=${item.item_code}">Edit</a></td>
							<td><a href="delete.do?id=${item.item_code}">Delete</a></td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		</form:form>
		<form:form name="listForm" method="post" action="list.do" methodAttribute="item">
		<div id="tabs-3">
			<div align="center">
				<h1>Item List</h1>
				<table border="1">
					<tr>
						<th>S.No.</th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Action</th>
						<th>Action</th>

					</tr>
					<c:forEach var="item" items="${itemList}" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td>${item.item_code}</td>
							<td>${item.item_name}</td>
							<td>${item.price}</td>
							<td>${item.quantity}</td>
							<td><a href="edit.do?id=${item.item_code}">Edit</a></td>
							<td><a href="delete.do?id=${item.item_code}">Delete</a></td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		</form:form>
		<form:form name="updateForm" method="post" action="update.do"
			methodAttribute="item">
		<div id="tabs-4">
				<input name="item_code" type="hidden" value="${item.item_code}">
				<div align="center">
					<h1>Item Details</h1>
					<table>

						<tr>
							<th>Item Name</th>
							<td><input name="item_name" id="itemname" required
								value="${item.item_name}"></td>

						</tr>
						<tr>
							<th>Price</th>
							<td><input name="price" id="price" required
								value="${item.price}"></td>

						</tr>
						<tr>
							<th>Quantity</th>
							<td><input name="quantity" id="qty" required
								value="${item.quantity}"></td>

						</tr>
						<tr>
						<td a="center"><input type="submit" value="Update"></td>
							<!-- <th><input type="submit" value="Add New Item"></th><th> -->
							
								<!-- <input type="button" value="List" onclick="list()" /> <input
								type="button" value="Clear" onClick="clearFields()"></th>-->

						</tr> 

					</table>

				</div>
			</div>

		</form:form>
	</div>
	
	<script type="text/javascript">
  $(function() {
    $( "#tabs" ).tabs();
    var searchModelAttr = '${searchModelAttr}';
    if(searchModelAttr == "search"){
    	$( "#tabs" ).tabs( "option", "active", 1 );
    }
    var searchlistModelAttr = '${searchitemlist}';
    if(searchlistModelAttr == "searchlist"){
    	$( "#tabs" ).tabs( "option", "active", 1 );
    }
   
    $( "#searchTab").on("click",function(){
    	var activeTab = $( "#tabs" ).tabs( "option", "active" );
    	$( "#tabs" ).tabs( "option", "active", 1 );
    	document.searchForm.action="search.do";
    	document.searchForm.submit();
    	
    });
    var editlistattr = '${editlistattr}';
    if(editlistattr == "edit"){
    	$( "#tabs" ).tabs( "option", "active", 3 );
    }
    var updatelistattr = '${updatelistattr}';
    if(updatelistattr == "update"){
    	$( "#tabs" ).tabs( "option", "active", 2 );
    }
    $( "#updateTab").on("click",function(){
    	var activeTab = $( "#tabs" ).tabs( "option", "active" );
    	$( "#tabs" ).tabs( "option", "active", 3 );
    	    	
    });
    var listModelAttr = '${itemlist}';
    if(listModelAttr == "list"){
    	$( "#tabs" ).tabs( "option", "active", 2 );
    }
    $( "#listTab").on("click",function(){
    	var activeTab = $( "#tabs" ).tabs( "option", "active" );
    	//alert("Search Tab Clicked " +activeTab) ;
    	// Setter
    	$( "#tabs" ).tabs( "option", "active", 2 );
    	document.listForm.action="list.do";
    	document.listForm.submit();
    	
    });
  });

   function update()
    {
    document.productForm.action="update.do";
    document.productForm.submit();
 
    }
  /*  function search()
   {
   document.searchForm.action="search.do";
   document.searchForm.submit();

   } */
  
   function list()
    {
    document.productForm.action="list.do";
    document.productForm.submit();
 
    }
   function clearFields()
   { 
	 document.getElementById("itemname").value="";	
	 document.getElementById("price").value="";
	 document.getElementById("qty").value="";
   } 
</script>
</body>
</html>