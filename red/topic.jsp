<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List,bean.*" %>
	
<div class="wrapper">
<form class="newtopic" name="newtopic" method="POST" action="main" onsubmit="checktopic();return false">
    <input type="text" id="nTOPIC" name="title" placeholder="Make a new topic"></textarea>
    <input type="submit" value="投稿" />
    <input type="hidden" name="action" value="writeTopic" >
</form>
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
	    			<div class="detail"><%=t.getId() +" / "+ t.getFdate() +" / "+ t.getLdate() %></div>
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

<div class="loginwrap">
    <% if(session.getAttribute("s_id")==null){%>
   	<form name="login" method="POST" action="main">
        <input type="text" name="loginID" placeholder="ここでログイン">
        <input type="password" name="loginPW" placeholder="password">
        <input type="submit" value="ログイン" />
        <input type="hidden" name="action" value="login" />
    </form>
        <a class="openpage" href="javascript:openaccount()">
        契約する
        </a>
        <div id="newaccountwrap">
		   	<form name="newaccount" method="POST" action="main" onsubmit="check();return false">
		        <input type="text" id="nID" name="newID" placeholder="なまえ">
		        <input type="password" id="nPW" name="newPW" placeholder="パスワード">
		        <input type="password" id="nPWPW" name="newPWPW" placeholder="もう一回">
		        <input type="submit" value="確認" />
		        <input type="hidden" name="action" value="newaccount" />
		    </form>
		</div>
    <% }else{ %>
   	<form name="login" method="POST" action="main">
    	こんにちは、<%=session.getAttribute("s_id") %> さん
        <input type="submit" value="ログアウト" />
        <input type="hidden" name="action" value="logout" />
    </form>
    <% }
    if(session.getAttribute("message")!=null){ %>
    	<div class="message"><%=session.getAttribute("message") %></div>
    <% session.setAttribute("message",null);
    }
    if(request.getAttribute("message")!=null){ %>
    	<div class="message"><%=request.getAttribute("message") %></div>
    <% request.setAttribute("message",null);
    } %>
</div>