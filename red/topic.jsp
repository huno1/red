<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List,bean.*" %>
	
<div class="wrapper">

<% if(session.getAttribute("s_id")!=null){ %>
<form class="newtopic" name="newtopic" method="POST" action="main" onsubmit="checktopic();return false">
    <input type="text" id="nTOPIC" name="title" placeholder="Make a new topic"></textarea>
    <input type="submit" value="投稿" />
    <input type="hidden" name="action" value="writeTopic" >
</form>
<% } %>

<% List<Topic> tlist=(List<Topic>)request.getAttribute("threadlist");
	try{
		for(Topic t:tlist){
			String count = t.getCount();
			if(count==null){
				count="0";
			} %>
			<a href="main?topic=<%=t.getId() %>" class="topic">
				<div class="tlist" id="t<%=t.getId() %>">
					<h2><%=t.getTitle() +"("+count+")" %></h2>
	    			<div class="detail">
		    			<%=t.getId() +" / "+ t.getMaker() +" / "+ t.getFdate() +" / "+ t.getLdate() %>
						<% if( session.getAttribute("s_id")!=null && session.getAttribute("s_id").equals(t.getMaker()) ){ %>
						<form class="deletetopic" name="deletetopic" method="POST" action="main" onsubmit="checkdeletetopic();return false">
						    <input type="submit" value="×" >
				    		<input type="hidden" name="id" value="<%=t.getId() %>" >
						    <input type="hidden" name="action" value="deleteTopic" >
						</form>
						<% } %>
					</div>
		    	</div>
    		</a>
		<% } 
	}catch(NullPointerException e){
		response.sendRedirect("main");
	}catch(Exception e){
		out.println("データベースにアクセスできません。");
	}
%>
</div>
