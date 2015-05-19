
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in</title>
<style type="text/css">
	body {
		background: rgb(254,191,1); /* Old browsers */
		/* IE9 SVG, needs conditional override of 'filter' to 'none' */
		background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIxMDAlIiB5Mj0iMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIxMyUiIHN0b3AtY29sb3I9IiNmZWJmMDEiIHN0b3Atb3BhY2l0eT0iMSIvPgogICAgPHN0b3Agb2Zmc2V0PSI4MyUiIHN0b3AtY29sb3I9IiM2YWEzNmYiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
		background: -moz-linear-gradient(left,  rgba(254,191,1,1) 13%, rgba(106,163,111,1) 83%); /* FF3.6+ */
		background: -webkit-gradient(linear, left top, right top, color-stop(13%,rgba(254,191,1,1)), color-stop(83%,rgba(106,163,111,1))); /* Chrome,Safari4+ */
		background: -webkit-linear-gradient(left,  rgba(254,191,1,1) 13%,rgba(106,163,111,1) 83%); /* Chrome10+,Safari5.1+ */
		background: -o-linear-gradient(left,  rgba(254,191,1,1) 13%,rgba(106,163,111,1) 83%); /* Opera 11.10+ */
		background: -ms-linear-gradient(left,  rgba(254,191,1,1) 13%,rgba(106,163,111,1) 83%); /* IE10+ */
		background: linear-gradient(to right,  rgba(254,191,1,1) 13%,rgba(106,163,111,1) 83%); /* W3C */
		filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#febf01', endColorstr='#6aa36f',GradientType=1 ); /* IE6-8 */		
	}
	#submit {		
		  margin: 0;
		  padding: 0;
		  border: none;
		  color: #6AA36F;
		  background-color: transparent;
		  text-decoration: underline;
		  cursor: pointer;
		  display: inline-block;		  
	}
</style>
</head>
<body>
	<div>
		<form id="addUser" action="addUser" method="post"> 
			<label for="username">Username: </label><input type="text" name="user" id="username" class="users" />
			<br><br>
			<label for="pass">Password: </label>
			<input type="password" class="users" name="password" id="pass" />
			<input type="submit" id="submit" value="Log in" />		    
		</form>
	</div>
</body>
</html>