<%@ include file="/includes/header.jsp" %>
		
		<!-- Main -->
			<article id="main">

				<header class="special container">
					<span class="icon fa-envelope"></span>
					<h2><fmt:message key="marks"/></h2>
				</header>
					
				<!-- One -->
					<section class="wrapper style4 special container small">
					<h4><b class="italic">${message}</b></h4>
						<!-- Content -->
							<div class="content">
								
								<form action="Marks" method="post">
									<h3><fmt:message key="vno_marks"/></h3>
									<div class="row half">
										<div class="4u"><fmt:message key="ukrainian"/></div>
										<div class="4u">
											<input class="center" type="text" name="ukrainian" value="${marksBean.ukrainian}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="mathematics"/></div>
										<div class="4u">
											<input class="center" type="text" name="mathematics" value="${marksBean.mathematics}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="physics"/></div>
										<div class="4u">
											<input class="center" type="text" name="physics" value="${marksBean.physics}" />
										</div>
									</div>
									<br>									
									<h3><fmt:message key="certificate_marks"/></h3>
									<div class="row half">
										<div class="4u"><fmt:message key="literature"/></div>
										<div class="4u">
											<input class="center" type="text" name="literature" value="${marksBean.literature}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="history"/></div>
										<div class="4u">
											<input class="center" type="text" name="history" value="${marksBean.history}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="english"/></div>
										<div class="4u">
											<input class="center" type="text" name="english" value="${marksBean.english}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="informatics"/></div>
										<div class="4u">
											<input class="center" type="text" name="informatics" value="${marksBean.informatics}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="geography"/></div>
										<div class="4u">
											<input class="center" type="text" name="geography" value="${marksBean.geography}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="biology"/></div>
										<div class="4u">
											<input class="center" type="text" name="biology" value="${marksBean.biology}" />
										</div>
									</div>
									<div class="row half">
										<div class="4u"><fmt:message key="chemistry"/></div>
										<div class="4u">
											<input class="center" type="text" name="chemistry" value="${marksBean.chemistry}" />
										</div>
									</div>
									<div class="row">
										<div class="12u">
											<ul class="buttons">
												<li><input class="button special" type="submit" value="<fmt:message key="submit"/>"></li>
											</ul>
										</div>
									</div>
								</form>
							</div>
							
					</section>
				
			</article>

<%@ include file="/includes/footer.jsp" %>