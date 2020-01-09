<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge</title>
<style>
        body {
          background-image: url('https://wallpaperstream.com/wallpapers/full/white/Grid-Hexagonal-White-HD-Wallpaper.jpg');
        }
        </style>
</head>
<body>     
        <h1 style="text-align: center; margin:10px"> RECHARGE </h1>
        <form id="form2" method="get" action="processrecharge">
        <div>
        <Label>Phone Number</Label>
       	<input type="text" id="mobileNo" name="mobileNo" value=""/> <br>
       	</div>
       	<div>
       	<label>Amount</label>
       <input type="text" id="amount" name="amount" value=""/> <br>
       </div>
       <div>
        <input type="submit" name="Submit" value="Submit" onclick="javascript:add()"/> <br>
       </div>


</form>
</body>
</html>