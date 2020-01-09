<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
 <style>
        body { background-image: url('https://wallpaperstream.com/wallpapers/full/white/Grid-Hexagonal-White-HD-Wallpaper.jpg');
        }
        </style>
</head>
<body>

<h1> Welcome</h1> 
<h2>The Telecom Mobile-User details are:</h2>
<h2>
Id is  <c:out value="${user.id}"/> <br>
Name is <c:out value="${user.name}"/> <br>
Balance is <c:out value="${user.balance}"/> <br>
Phone number is <c:out value="${user.mobileNo}"/> <br>
</h2>
<h3>
<b><a href="/signout" style="color:green">Sign out</a>
&nbsp;
<a href="/recharge" style="color:green" >Recharge</a></b>
</h3>
</body>
</html>