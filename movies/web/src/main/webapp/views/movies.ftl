<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movies</title>
</head>

<body>
	<h1>List of movies</h1>

	<table>
		<thead>
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<#list movies as movie>
			<tr>
				<td>${movie.name}</td>
			</tr>
		</#list>
	</table>
</body>
</html>