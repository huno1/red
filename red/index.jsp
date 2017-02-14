<%@ include file="header.jsp" %>

<div class="wrapper">
	<div class="main">
	<% 
		if(request.getParameter("topic")!=null){ %>
			<%@ include file="content.jsp" %>
		<% }else{ %>
			<%@ include file="topic.jsp" %>
		<% }
	%>
	</div>
<%@ include file="side.jsp" %>

</div>

<%@ include file="footer.jsp" %>