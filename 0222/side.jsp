<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List" %>
	
<div class="searchform">
	<form name="search" method="GET" onsubmit="searchform(); return false">
		<input type="text" name="keyword" >
		<input type="submit" value="����" >
		<input type="hidden" name="page" value="1" >
	</form>
</div>

<div class="recent">
	<% try{
		List<Content> rlist=(List<Content>)request.getAttribute("recent");
       for(Content r:rlist){ %>
		<div class="rlist">
    		 	<a href="main?topic=<%=r.getThid() %>#<%=r.getId() %>">
    		 	<div class="rcont">
    		 	<% if(r.getFile()!=null && !r.getFile().equals("null")){
    		 		if(r.getFile().indexOf(".jpg")>0 || r.getFile().indexOf(".jpeg")>0 || r.getFile().indexOf(".png")>0 || r.getFile().indexOf(".bmp")>0 || r.getFile().indexOf(".gif")>0 ){ %>
    		 			<div><img src="upload/<%=r.getFile() %>"></div>
    		 		<% }else if(r.getFile().indexOf(".webm")>0 || r.getFile().indexOf(".avi")>0 || r.getFile().indexOf(".mp4")>0 || r.getFile().indexOf(".wmv")>0){ %>
    		 			<span class="video">[����]</span>
    		 		<% }else{
    		 		} %>
    		 	<% } %><%=r.getContent() %></div>
    		 	<div class="rdate"><%=r.getDate().substring(5,16) %></div>
    		 	</a>
    	</div>
	<% }
	}catch(Exception e){
		out.println("�f�[�^�x�[�X�ɃA�N�Z�X�ł��܂���B");
	} %>
</div>

<div class="loginwrap">
    <% if(session.getAttribute("s_id")==null){%>
   	<form name="login" method="POST" action="main?<%=request.getQueryString() %>">
        <input type="text" name="username" placeholder="�����Ń��O�C��">
        <input type="password" name="userpass" placeholder="password">
        <input type="submit" value="Login" />
        <input type="hidden" name="do" value="login" />
    </form>
        <a class="openpage" href="javascript:openaccount()">
        New Account
        </a>
        <div id="newaccountwrap">
		   	<form name="newaccount" method="POST" action="main" onsubmit="check();return false">
		        <input type="text" id="nID" name="username" placeholder="�Ȃ܂�">
		        <input type="password" id="nPW" name="userpass" placeholder="�p�X���[�h">
		        <input type="password" id="nPWPW" name="userpasspass" placeholder="�������">
		        <input type="submit" value="�m�F" />
		        <input type="hidden" name="do" value="newAccount" />
		    </form>
		</div>
    <% }else{ %>
   	<form name="logout" method="POST" action="main?<%=request.getQueryString() %>">
    	����ɂ��́A<%=session.getAttribute("s_id") %> ����
        <input type="submit" value="Logout" />
        <input type="hidden" name="do" value="logout" />
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
<div id="totop">
	<a href="#top"><div class="btn">Top��</div></a>
</div>