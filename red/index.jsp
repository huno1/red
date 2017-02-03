
<%@ include file="header.jsp" %>
<% 
	if(request.getParameter("topic")!=null){ %>
		<%@ include file="content.jsp" %>
	<% }else{ %>
		<%@ include file="topic.jsp" %>
	<% }
%>	
<%@ include file="side.jsp" %>
<%@ include file="footer.jsp" %>