<#import "/spring.ftl" as spring />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movies</title>
</head>

<body>
	<fieldset>
		<legend>New movie</legend>
		<form action="/movies-web/movies/movies" method="POST">
			<label for="nameInput">Name: </label> <input type="text" name="name" id="nameInput"/>	
			<input type="submit" value="Save"/>
		</form>
	</fieldset>
</body>
</html>