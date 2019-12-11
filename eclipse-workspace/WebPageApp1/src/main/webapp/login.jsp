<%@page import="java.util.*"%>
<%
	String emailID = "";
	String display = "none",displayerr = "none";
	if (request.getParameter("eid") != null)
		emailID = request.getParameter("eid");
	if (request.getAttribute("regsucs") != null) {
		if (request.getAttribute("regsucs").equals("success")) {
			display = "block";
		} else if (request.getAttribute("regsucs").equals("error")){
			displayerr = "block";
		}
	}
%>
<div class="form-container">
	<div class="form-header">
		<h2>Login</h2>
	</div>
	<form id="lgnForm" class="my-form">
		<div class="form-group">
			<p class="hd-lbl" id="errormsg"
				style="text-align: center;display:<%=displayerr%>;">Invalid User
				Name or Password!!!!</p>
			<p class="hd-lbl" id="successmsg"
				style="text-align: center;display:<%=display%>;">Thanks for
				Register with us!!!</p>
			<p class="hd-lbl username" hidden>Enter valid email id</p>
			<input id="usr" type="text" name="username" required="required"
				placeholder="Email" value=<%=emailID%>>
		</div>
		<div class="form-group">
			<p class="hd-lbl password" hidden>Password should not be empty</p>
			<input type="password" name="password" value="" required="required"
				placeholder="Password">
		</div>
		<input class="button" type="submit" value="Login">
	</form>
</div>
