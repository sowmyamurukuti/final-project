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
        <style>
            form { 
              display: block;
                
              margin-top: 0em;
              margin-left: 36em;
              margin-right: 36em;
              margin-bottom: 0em;
                  
                 
                 
                  box-sizing: border-box;
                  text-align: center;
              
              background-color: grey;
                padding: 5px ;
                border: 1px solid grey ;
                position:fixed;
                
                
            }
            </style>
            <style> 
                input[type=submit] {
                  width: 30%;
                  padding: 10px 10px;
                  margin: 8px 0;
                  box-sizing: border-box;
                  border: none;
                  background-color: #3CBC8D;
                  color: white;
                }
 </style>
 </head>
<body style= "background-color:white">
  <div class="text">  
<h2 style="text-align:center;"> TELECOM MOBILE-USER REGISTRATION FORM</h2>
</div>
<form method="get" action="processregister">
 
<div class="input">
<span style="text-align:center;">Name </span>
<input name="name" type="text" />
</div>
<div class="input">
<span style="text-align:center;">Password</span>
<input name="password" type="password" />
</div>
</div>
<div class="input">
<span style="text-align:center;">Mobile Number</span>
<input name="mobileNo" type="text" />
</div>
</div>
<div class="input">
<span style="text-align:center;">Balance</span>
<input name="balance" type="number" />
</div>

<div class="input">
<input type="submit" value="Submit"/>
</div>
</form>

<div>

<c:out value="${message}"/>
</body>
</html>