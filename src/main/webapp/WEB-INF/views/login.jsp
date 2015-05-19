
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in</title>
<style type="text/css">
	body {
    	background-image:
        url('http://www.polyvore.com/cgi/img-thing?.out=jpg&size=l&tid=5806364');
		background-size: 100% 100%;
	}
	
	label {
		color: #498406;
		width: 82px;
	}
	
	#submit {		
		margin: 8px;
		padding: 5px;
		margin-left: 200px;
		border-radius: 30px;
		color: #498406;
		background-color: black;
		cursor: pointer;
		font-weight: bold;		
		display: block;  
	}
	
	input:focus{
    	outline: 0;
    }
	
	#label, #username {
		margin-top: 25px;
	}
</style>
</head>
<body>
	<div>
		<form id="addUser" action="addUser" method="post"> 
			<label for="username" id ="label">Username: </label><input type="text" name="user" id="username" class="users" />
			<br><br>
			<label for="pass">Password: </label>
			<input type="password" class="users" name="password" id="pass" />
			<input type="submit" id="submit" value="Log in" />		    
		</form>
	</div>
</body>
</html>