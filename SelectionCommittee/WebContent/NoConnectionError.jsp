<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<fmt:setBundle basename="ua.nure.zhabin.SelectionCommittee.locale.resources.resources"/>
	<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Display Faculties</title>
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
		
		<!-- Main -->
			<article id="main">

				<header class="special container">
					<span class="icon fa-laptop"></span>
				</header>
				<!-- One -->
					<section class="wrapper style4 special container small">					
						<!-- Content -->
							<div class="content">
								<h2>There is no connection to the database</h2>
								<h3>Details:</h3>
								<p>
									<b>Type:</b> <%= exception.getClass() %><br>
									<b>Cause:</b> <%= exception.getCause() %>
								</p>
							</div>							
					</section>				
			</article>

		<!-- Footer -->
			<footer id="footer">
			
				<span class="copyright">&copy; All rights reserved.</span>
			
			</footer>

</body>
</html>