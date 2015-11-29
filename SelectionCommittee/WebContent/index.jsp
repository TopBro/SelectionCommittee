<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="ua.nure.zhabin.SelectionCommittee.bean.LoginBean" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<fmt:setBundle basename="resources"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign In</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.dropotron.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-noscript.css" />
		</noscript>
</head>
<body class="index loading">

		<!-- Header -->
			<header id="header" class="alt">
				<h1 id="logo"><fmt:message key="knure"/></h1>
				<nav id="nav">
					<ul>
						<li class="submenu">
							<a href=""><fmt:message key="menu"/></a>
							<ul>
								<li class="submenu">
									<a href=""><fmt:message key="language"/></a>
									<ul>
										<li><a href="<c:url value="Locale?lang=ru"/>"><fmt:message key="rus"/></a></li>
										<li><a href="<c:url value="Locale?lang=en"/>"><fmt:message key="eng"/></a></li>
									</ul>
								</li>
							</ul>
						</li>
						<li><a href="SignupPage.jsp" class="button special"><fmt:message key="signup"/></a></li>
					</ul>
				</nav>
			</header>

		<!-- Banner -->		
			<section id="banner">
				
				<!--
					".inner" is set up as an inline-block so it automatically expands
					in both directions to fit whatever's inside it. This means it won't
					automatically wrap lines, so be sure to use line breaks where
					appropriate (<br />).
				-->
				<div class="inner">
					
					<header>
						<h2><fmt:message key="signin"/></h2>
					</header>
					<form action="Login" method="post">
						<div class="row half">
							<div class="12u">
								<input type="text" name="login" placeholder="<fmt:message key="login"/>" value="${loginBean.login}" />
							</div>						
						</div>
						<div class="row half">						
							<div class="12u">
								<input type="password" name="password" placeholder="<fmt:message key="password"/>" value="${loginBean.password}" />
							</div>
						</div>
						${loginMessage}
						<footer>							
							<ul class="buttons vertical">
								<input class="button fit scrolly" type="submit" value="<fmt:message key="signin"/>">
							</ul>
						</footer>
					</form>
				
				</div>
				
			</section>
</body>
</html>