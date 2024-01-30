<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success Page</title>
</head>
<body>
<style>
    body {
  background-image: url('https://e1.pxfuel.com/desktop-wallpaper/934/320/desktop-wallpaper-web-design-backgrounds-1920%C3%971200-3-web-designer.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
h2{
color:white;
}
</style>
<br><br><br><br><br><br><br><br><br><br><br><br>

    <h2><center><%String str=(String)request.getParameter("name");
    out.println( str+",Your leave request was updated sucessfully");
    
    %></center></h2>
    
    <!-- Add any additional content or functionality as needed -->

</body>
</html>