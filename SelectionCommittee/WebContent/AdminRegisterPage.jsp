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
										<fmt:message key="last_name"/>
									</div>
									<div class="2u">
										<fmt:message key="first_name"/>
									</div>
									<div class="2u">
										<fmt:message key="middle_name"/>
									</div>
									<div class="2u">
										<fmt:message key="vno_sum"/>
									</div>
								</div>								
								<c:forEach var="regRecord" items="${list}">
									<div class="row half no-collapse-1">
										<div class="2u">
											${regRecord.lastName}
										</div>
										<div class="2u">
											${regRecord.firstName}
										</div>
										<div class="2u">
											${regRecord.middleName}
										</div>
										<div class="2u">
											${regRecord.vnoSum}
										</div>
									</div>
								</c:forEach>
								<br>
								<form action="CloseRegister" method="post">
								<input type="hidden" name="faculty_id" value="${faculty_id}"/>
									<div class="row">
										<div class="12u">
											<ul class="buttons">												
												<li><input class="button" type="submit" value="<fmt:message key="close_register"/>"></li>
											</ul>
										</div>
									</div>
								</form>
							</div>							
					</section>				
			</article>

<%@ include file="/includes/footer.jsp" %>