<%@ include file="/includes/AdminHeader.jsp" %>
		
		<!-- Main -->
			<article id="main">

				<header class="special container">
					<span class="icon fa-laptop"></span>
				</header>
				<!-- One -->
					<section class="wrapper style4 special container small">					
						<!-- Content -->
							<div class="content">
								<h2>Registration for this faculty is closed</h2>
								<br>
								<form action="OpenRegister" method="post">
									<input type="hidden" name="faculty_id" value="${faculty_id}"/>
									<div class="row">
										<div class="12u">
											<ul class="buttons">												
												<li><input class="button" type="submit" value="<fmt:message key="open_register"/>"></li>
											</ul>
										</div>
									</div>
								</form>
							</div>							
					</section>				
			</article>

<%@ include file="/includes/footer.jsp" %>