 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up List</title>
</head>
<body>
<h1>Succesful Login !!!</h1>
<h2>You received your wand!! here's a list of wand holders including you</h2>
<table>
  <c:forEach items="${added}" var="temp">
   <tr>
     <td>${temp}</td>
  </tr>
  </c:forEach>
</table>
</body>
</html>