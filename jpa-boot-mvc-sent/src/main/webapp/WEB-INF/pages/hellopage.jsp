<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style>
        body {
          background-image: url('https://wallpaperstream.com/wallpapers/full/white/Grid-Hexagonal-White-HD-Wallpaper.jpg');
        }
        </style>
</head>
<body>
<h1>User information </h1>
<h2>

<c:out value="${message}"/>
<br>
<c:out value="hello" />

<br>
<c:out value="${10*2}" />
</h2>
</body>
</html>