<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
%><!DOCTYPE html>
<html>
<head>
<title>Display Reinbursments</title>
</head>
   <body>
         <h2>Display Reinbursments</h2>
         <c:choose>
            <c:when test="${empty roles}">
               <h3>Currently, there are no user roles.</h3>
            </c:when>
            <c:otherwise>
            	<c:forEach items ="${roles}" var = "curr">
	               <table id="beanTable">
	                  <tr>
	                     <td>Role Id:</td><td>${curr.USER_ROLES_ID}</td>
	                  </tr>
	                  <tr>
	                     <td>Role:</td><td>${curr.USER_ROLES}</td>
	                  </tr>
	               </table>
				</c:forEach>
            </c:otherwise>
         </c:choose>
   </body>
</html>