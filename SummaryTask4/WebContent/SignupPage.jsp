<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<%@ page import="ua.nure.zhabin.SummaryTask4.bean.SignupBean" %>
	
		<!-- Header -->
			<header id="header">
				<h1 id="logo"><a href="index.html">Twenty <span>by HTML5 UP</span></a></h1>
				<nav id="nav">
					<ul>
						<li class="current"><a href="index.html">Welcome</a></li>
						<li class="submenu">
							<a href="">Layouts</a>
							<ul>
								<li><a href="left-sidebar.html">Left Sidebar</a></li>
								<li><a href="right-sidebar.html">Right Sidebar</a></li>
								<li><a href="no-sidebar.html">No Sidebar</a></li>
								<li><a href="contact.html">Contact</a></li>
								<li class="submenu">
									<a href="">Submenu</a>
									<ul>
										<li><a href="#">Dolore Sed</a></li>
										<li><a href="#">Consequat</a></li>
										<li><a href="#">Lorem Magna</a></li>
										<li><a href="#">Sed Magna</a></li>
										<li><a href="#">Ipsum Nisl</a></li>
									</ul>
								</li>
							</ul>
						</li>
						<li><a href="#" class="button special">Sign Up</a></li>
					</ul>
				</nav>
			</header>
		
		<!-- Main -->
			<article id="main">

				<header class="special container">
					<span class="icon fa-envelope"></span>
					<h2>SignUp</h2>
					<p>Use the form below to give information about yourself.</p>
				</header>
					
				<!-- One -->
					<section class="wrapper style4 special container small">
					
						<!-- Content -->
							<div class="content">
								<p class="italic"><b>${message}</b></p>
								<form action="Signup" method="post">
									<h3>Personal Information</h3>
									<div class="row half no-collapse-1">
										<div class="6u">
											<input type="text" name="login" placeholder="Login" value="${signupBean.login}" />
										</div>
										<div class="6u">
											<input type="password" name="password" placeholder="Password" value="${signupBean.password}" />
										</div>
									</div>
									<div class="row half no-collapse-1">
										<div class="6u">
											<input type="text" name="last_name" placeholder="Last Name" value="${signupBean.lastName}" />
										</div>
										<div class="6u">
											<input type="text" name="first_name" placeholder="First Name" value="${signupBean.firstName}" />
										</div>
										<div class="6u">
											<input type="text" name="middle_name" placeholder="Midle Name" value="${signupBean.midleName}" />
										</div>
									</div>
									<div class="row half">
										<div class="6u">
											<input type="text" name="email" placeholder="Email" value="${signupBean.email}" />
										</div>
									</div>
									<div class="row half no-collapse-1">
										<div class="6u">
											<input type="text" name="city" placeholder="City" value="${signupBean.city}" />
										</div>
										<div class="6u">
											<input type="text" name="region" placeholder="Region" value="${signupBean.region}" />
										</div>
									</div>
									<div class="row half">
										<div class="6u">
											<input type="text" name="education" placeholder="Education" value="${signupBean.education}" />
										</div>
									</div><br>
									<h3>Marks from external independent testing</h3>
									<div class="row half no-collapse-1">
										<div class="4u">
											<input type="text" name="ukrainian" placeholder="Ukrainian" value="${signupBean.ukrainian}" />
										</div>
										<div class="4u">
											<input type="text" name="mathematics" placeholder="Mathematics" value="${signupBean.mathematics}" />
										</div>
										<div class="4u">
											<input type="text" name="physics" placeholder="Physics" value="${signupBean.physics}" />
										</div>
									</div><br>
									<h3>Marks from certificate</h3>
									<div class="row half no-collapse-1">
										<div class="4u">
											<input type="text" name="literature" placeholder="Literature" value="${signupBean.literature}" />
										</div>
										<div class="4u">
											<input type="text" name="history" placeholder="History" value="${signupBean.history}" />
										</div>
										<div class="4u">
											<input type="text" name="english" placeholder="English" value="${signupBean.english}" />
										</div>			
									</div>
									<div class="row half no-collapse-1">
										<div class="4u">
											<input type="text" name="informatics" placeholder="Informatics" value="${signupBean.informatics}" />
										</div>
										<div class="4u">
											<input type="text" name="geography" placeholder="Geography" value="${signupBean.geography}" />
										</div>
										<div class="4u">
											<input type="text" name="biology" placeholder="Biology" value="${signupBean.biology}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u">
											<input type="text" name="chemistry" placeholder="Chemistry" value="${signupBean.chemistry}" />
										</div>
									</div>
									<div class="row">
										<div class="12u">
											<ul class="buttons">
												<li><input class="button special" type="submit" value="Sign Up"></li>
											</ul>
										</div>
									</div>
								</form>
							</div>
							
					</section>
				
			</article>

		<!-- Footer -->
			<footer id="footer">
			
				<span class="copyright">&copy; All rights reserved. EPAM &amp; Associates.</span>
			
			</footer>

</body>
</html>