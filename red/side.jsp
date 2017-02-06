<%@ page pageEncoding="Windows-31J"
    contentType="text/html;charset=Windows-31J"
	import="java.util.List" %>
	
<div class="loginwrap">
    <% if(session.getAttribute("s_id")==null){%>
   	<form name="login" method="POST" action="main?<%=request.getQueryString() %>">
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
		        <input type="hidden" name="action" value="newAccount" />
		    </form>
		</div>
    <% }else{ %>
   	<form name="logout" method="POST" action="main?<%=request.getQueryString() %>">
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
<div id="totop">
	<a href="#top"><div class="btn">Topへ</div></a>
</div>