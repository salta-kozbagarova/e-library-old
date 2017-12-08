<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="header.jsp"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><spring:message code="label.studentLibrary" /></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${contextPath}/profile"><span class="glyphicon glyphicon-user"></span>${pageContext.request.userPrincipal.name}</a></li>
      <li><a href="${contextPath}/library">Page 1</a></li>
      <li><a href="${contextPath}/books-to-return">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li>
      	<form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <a onclick="document.forms['logoutForm'].submit()"><span class="glyphicon glyphicon-log-in"></span>Logout</a>
      </li>
    </ul>
  </div>
</nav>
