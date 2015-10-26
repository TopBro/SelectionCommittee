<%@ include file="/includes/AdminHeader.jsp" %>
		
		<!-- Main -->
			<article id="main">

				<header class="special container">
					<span class="icon fa-envelope"></span>
					<h2><fmt:message key="faculty"/></h2>
				</header>
					
				<!-- One -->
					<section class="wrapper style4 special container small">
					<h4><b class="italic">${message}</b></h4>
						<!-- Content -->
							<div class="content">
								
								<form action="UpdateFaculty" method="post">
									<input type="hidden" name="faculty_id" value="${faculty.id}" />
									<div class="row half">
										<div class="4u"><fmt:message key="faculty_name"/></div>
										<div class="4u">
											<input class="center" type="text" name="name" value="${faculty.name}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="budget_place"/></div>
										<div class="4u">
											<input class="center" type="text" name="budget" value="${faculty.budget}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="total_place"/></div>
										<div class="4u">
											<input class="center" type="text" name="total" value="${faculty.total}" />
										</div>
									</div>
									<br>									
									<div class="row">
										<div class="12u">
											<ul class="buttons">
												<li><input class="button special" type="submit" value="<fmt:message key="update"/>"></li>
											</ul>
										</div>
									</div>									
								</form>
								<br>
								<form action="DeleteFaculty" method="post">
									<input type="hidden" name="faculty_id" value="${faculty.id}" />
									<div class="row">
										<div class="12u">
											<ul class="buttons">
												<li><input class="button special" type="submit" value="<fmt:message key="delete"/>"></li>
											</ul>
										</div>
									</div>
								</form>
							</div>
							
					</section>
				
			</article>

<%@ include file="/includes/footer.jsp" %>