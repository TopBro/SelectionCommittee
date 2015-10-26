<%@ include file="/includes/AdminHeader.jsp" %>
		
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
									<div class="2u">
										<fmt:message key="faculty_name"/>
									</div>
									<div class="2u">
										<fmt:message key="budget_place"/>
									</div>
									<div class="2u">
										<fmt:message key="total_place"/>
									</div>
								</div>								
								<c:forEach var="faculty" items="${faculties}">
									<div class="row half no-collapse-1">
										<div class="2u">
											${faculty.name}
										</div>
										<div class="2u">
											${faculty.budget}
										</div>
										<div class="2u">
											${faculty.total}
										</div>
										<div class="3u">
											<form action="Faculty" method="post">
												<input type="hidden" name="faculty_id" value="${faculty.id}">
												<input class="button small" type="submit" value="<fmt:message key="edit"/>">
											</form>	
										</div>
										<div class="3u">
											<form action="Register" method="post">
												<input type="hidden" name="faculty_id" value="${faculty.id}">
												<input class="button small" type="submit" value="<fmt:message key="register"/>">
											</form>	
										</div>
									</div>
								</c:forEach>
								<br>
								<form action="Faculty" method="post">
									<div class="row">
										<div class="12u">
											<ul class="buttons">
												<li><input class="button" type="submit" value="<fmt:message key="add"/>"></li>
											</ul>
										</div>
									</div>
								</form>
							</div>							
					</section>				
			</article>

<%@ include file="/includes/footer.jsp" %>