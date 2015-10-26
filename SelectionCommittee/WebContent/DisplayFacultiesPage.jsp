<%@ include file="/includes/header.jsp" %>
		
		<!-- Main -->
			<article id="main">

				<header class="special container">
					<span class="icon fa-laptop"></span>
					<h2><fmt:message key="faculties"/></h2>
				</header>
					
				<!-- One -->
					<section class="wrapper style4 special container small">					
						<!-- Content -->
							<div class="content">
								<h4><b class="italic">${message}</b></h4>
							
								<div class="row half no-collapse-1">
									<div class="3u">
										<h3><fmt:message key="faculty_name"/></h3>
									</div>
									<div class="3u">
										<h3><fmt:message key="budget_place"/></h3>
									</div>
									<div class="3u">
										<h3><fmt:message key="total_place"/></h3>
									</div>
								</div>								
								<c:forEach var="faculty" items="${faculties}">
									<div class="row half no-collapse-1">
										<div class="3u">
											${faculty.name}
										</div>
										<div class="3u">
											${faculty.budget}
										</div>
										<div class="3u">
											${faculty.total}
										</div>
										<div class="3u">
											<form action="FacultyRegistration" method="post">
												<input type="hidden" name="userId" value="${CurrentUser.id}">
												<input type="hidden" name="facultyId" value="${faculty.id}">
												<input class="button small" type="submit" value="<fmt:message key="registration"/>">
											</form>	
										</div>
									</div>
								</c:forEach>
								
							</div>							
					</section>				
			</article>

<%@ include file="/includes/footer.jsp" %>