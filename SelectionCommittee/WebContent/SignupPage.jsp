<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="ua.nure.zhabin.SelectionCommittee.bean.SignupBean" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<fmt:setBundle basename="ua.nure.zhabin.SelectionCommittee.locale.resources.resources"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign Up</title>
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
<body class="contact loading">

		<!-- Header -->
			<header id="header">
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
						<li><a href="index.jsp" class="button special"><fmt:message key="signin"/></a></li>
					</ul>
				</nav>
			</header>
		
		<!-- Main -->
			<article id="main">

				<header class="special container">
					<span class="icon fa-envelope"></span>
					<h2><fmt:message key="signup"/></h2>
					<p><fmt:message key="informationAboutYourself"/></p>
				</header>
					
				<!-- One -->
					<section class="wrapper style4 special container small">
					<b class="italic">${signupMessage}</b>
						<!-- Content -->
							<div class="content">
								
								<form action="Signup" method="post">
									<h3><fmt:message key="personalInfo"/></h3>
									<div class="row half no-collapse-1">
										<div class="6u">
											<input type="text" name="login" placeholder="<fmt:message key="login"/>" value="${signupBean.login}" />
										</div>
										<div class="6u">
											<input type="password" name="password" placeholder="<fmt:message key="password"/>" value="${signupBean.password}" />
										</div>
									</div>
									<div class="row half no-collapse-1">
										<div class="6u">
											<input type="text" name="last_name" placeholder="<fmt:message key="last_name"/>" value="${signupBean.lastName}" />
										</div>
										<div class="6u">
											<input type="text" name="first_name" placeholder="<fmt:message key="first_name"/>" value="${signupBean.firstName}" />
										</div>
										<div class="6u">
											<input type="text" name="middle_name" placeholder="<fmt:message key="middle_name"/>" value="${signupBean.midleName}" />
										</div>
									</div>
									<div class="row half">
										<div class="6u">
											<input type="text" name="email" placeholder="<fmt:message key="email"/>" value="${signupBean.email}" />
										</div>
									</div>
									<div class="row half no-collapse-1">
										<div class="6u">
											<input type="text" name="city" placeholder="<fmt:message key="city"/>" value="${signupBean.city}" />
										</div>
										<div class="6u">
											<input type="text" name="region" placeholder="<fmt:message key="region"/>" value="${signupBean.region}" />
										</div>
									</div>
									<div class="row half">
										<div class="6u">
											<input type="text" name="education" placeholder="<fmt:message key="education"/>" value="${signupBean.education}" />
										</div>
									</div><br>
									<div class="row">
										<div class="12u">
											<ul class="buttons">
												<li><input class="button special" type="submit" value="<fmt:message key="signup"/>"></li>
											</ul>
										</div>
									</div>
								</form>
							</div>
							
					</section>
				
			</article>

<%@ include file="/includes/footer.jsp" %>