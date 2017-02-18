<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List,bean.*" %>
	
<% if(session.getAttribute("s_id")!=null){ %>
<form class="newtopic" name="newtopic" method="POST" action="main" onsubmit="checktopic();return false">
    <input type="text" id="nTOPIC" name="title" placeholder="Make a new topic">
    <input type="submit" value="作成" />
    <input type="hidden" name="do" value="writeTopic" >
</form>
<% } %>

<% List<Topic> tlist=(List<Topic>)request.getAttribute("threadlist");
	try{
		for(Topic t:tlist){ %>
			<a href="main?topic=<%=t.getId() %>" class="topic">
				<div class="tlist" id="t<%=t.getId() %>">
					<h2><%=t.getTitle() +"("+t.getCount()+")" %></h2>
	    			<div class="detail">
		    			<%=t.getId() +" / "+ t.getMaker() +" / "+ t.getFdate() +" / "+ t.getLdate() %>
						<% if( session.getAttribute("s_id")!=null && session.getAttribute("s_id").equals(t.getMaker()) ){ %>
						<form class="deletetopic" name="deletetopic" method="POST" action="main" onsubmit="checkdeletetopic();return false">
						    <input type="submit" value="×" >
				    		<input type="hidden" name="thid" value="<%=t.getId() %>" >
						    <input type="hidden" name="do" value="deleteTopic" >
						</form>
						<% } %>
					</div>
		    	</div>
    		</a>
		<% } 
	}catch(NullPointerException e){
		response.sendRedirect("main?page=1");
	}catch(Exception e){
		out.println("データベースにアクセスできません。");
	}
%>