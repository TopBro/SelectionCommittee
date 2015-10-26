<%@ include file="/includes/header.jsp" %>

		<!-- Main -->
			<article id="main">

				<header class="special container">
					<span class="icon fa-laptop"></span>
					<h2><fmt:message key="registrations"/></h2>
				</header>
					
				<!-- One -->
					<section class="wrapper style4 special container small">					
						<!-- Content -->
							<div class="content">
							
								<div class="row half no-collapse-1">
									<div class="6u">
										<h3><fmt:message key="faculty"/></h3>
									</div>
									<div class="6u">
										<h3><fmt:message key="status"/></h3>
									</div>
								</div>
								<h4><b class="italic">${message}</b></h4>
								<c:forEach var="regRecord" items="${registrations}">
									<div class="row half no-collapse-1">
									<div class="6u">
										${regRecord.facultyName}
									</div>
									<div class="6u">
										<fmt:message key="${regRecord.statusName}"/>
									</div>
								</div>
								</c:forEach>
								
							</div>							
					</section>				
			</article>
			
<%@ include file="/includes/footer.jsp" %>