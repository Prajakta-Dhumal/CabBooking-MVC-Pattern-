<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Final Bill</title>
</head>
<body>
<%--view Page --%>
  <%   double total_amount=(double)request.getAttribute("totalamount");
       double waiting_charges=(double)request.getAttribute("waitingcharges");
       double final_bill=(double)request.getAttribute("finalbill");
  %>
     <h1 style="color: green;">TOTAL AMOUNT    <%= total_amount %></h1>
     <h1 style="color: green; ">WAITING CHARGES <%= waiting_charges%></h1>
     <h1 style="color: red">YOUR FINAL BILL IS  <%= final_bill %></h1>
</body>
</html>