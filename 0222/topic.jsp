<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List,bean.*" %>
	
<% 
try{
	String keypara = "";
	if(request.getParameter("keyword")!=null){
		keypara = "keyword="+new String(request.getParameter("keyword").getBytes("ISO-8859-1"), "Shift_JIS")+"&";
	}
	int curr = 1;
	if(request.getParameter("page")!=null){
		curr = Integer.parseInt(request.getParameter("page"));
	}
	int total = 1;
	if(request.getAttribute("totalpages")!=null){
		total = (Integer)request.getAttribute("totalpages");
	}
	
	if(session.getAttribute("s_id")!=null){ %>
	
		<form class="newtopic" name="newtopic" method="POST" action="main?<%=keypara %>page=<%=curr %>" onsubmit="checktopic();return false">
		    <input type="text" id="nTOPIC" name="title" placeholder="Make a new topic">
		    <input type="submit" value="ì¬" />
		    <input type="hidden" name="do" value="writeTopic" >
		</form>
	<% } %>

	<% List<Topic> tlist=(List<Topic>)request.getAttribute("threadlist");
		for(Topic t:tlist){ %>
			<a href="main?topic=<%=t.getId() %>" class="topic">
				<div class="tlist" id="t<%=t.getId() %>">
					<h2><%=t.getTitle() +"("+t.getCount()+")" %></h2>
	    			<div class="detail">
		    			<%=t.getId() +" / "+ t.getMaker() +" / "+ t.getFdate() +" / "+ t.getLdate() %>
						<% if( session.getAttribute("s_id")!=null && session.getAttribute("s_id").equals(t.getMaker()) ){ %>
						<form class="deletetopic" name="deletetopic" method="POST" action="main?<%=keypara %>page=<%=curr %>" onsubmit="checkdeletetopic();return false">
						    <input type="submit" value="~" >
				    		<input type="hidden" name="thid" value="<%=t.getId() %>" >
						    <input type="hidden" name="do" value="deleteTopic" >
						</form>
						<% } %>
					</div>
		    	</div>
    		</a>
		<% } %>
	
	<div class="page">
	
		<a href="main?<%=keypara %>page=1" class="first"> á </a>
	
	<div class="pagecenter">
	
	<%
	 if(curr-1>0){
		if(curr-2>0){ 
			if(curr-3>0){ %>
				c
			<% } %>
			<a href="main?<%=keypara %>page=<%=curr-2 %>"> <%=curr-2 %> </a>
		<% } %>
		<a href="main?<%=keypara %>page=<%=curr-1 %>"> <%=curr-1 %> </a>
	<% } %>

	<a href="main?<%=keypara %>page=<%=curr %>" class="current"> <%=curr %> </a>

	<% if(curr+1<=total){%>
		<a href="main?<%=keypara %>page=<%=curr+1 %>"> <%=curr+1 %> </a>
		<% if(curr+2<=total){ %>
			<a href="main?<%=keypara %>page=<%=curr+2 %>"> <%=curr+2 %> </a>
			<% if(curr+2<total){ %>
				c
			<% }
			}
		} %>
	
	</div>
	
		<a href="main?<%=keypara %>page=<%=total %>" class="last"> â </a>
		
	</div>
	
	<% 
	}catch(Exception e){
		response.sendRedirect("main?page=1");
} %>