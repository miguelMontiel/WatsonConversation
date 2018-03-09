<!DOCTYPE html>
<html>
	<head>
	    <meta charset = "utf-8">
	    <link href = 'https://fonts.googleapis.com/css?family=Roboto:400,100' rel = 'stylesheet' type = 'text/css'>
	    <link href = "css.css" rel = "stylesheet">

		<title>Ingresar incidencia</title>
	</head>

	<header>
		<img src = "tecmilenio.png">
	</header>

	<?php
		$user = 'id1554887_root';
		$password = 'password';
		$db = 'id1554887_miguelmg';
		$conn = new mysqli('localhost', $user, $password, $db) or die("No se pudo conectar");
	?>

	<body>
		<h1>Dudas y Aclaraciones</h1>

		<form action = "inicio.php" method = "post">
			<label>Correo</label> 
			<br>
			<input type = "text" name = "correo" autocomplete = "off" autofocus>
			<br> <br>

			<label>Descripción</label>
			<br>
			<textarea name = "descripcion" autocomplete = "off" rows = "8" cols = "75"></textarea>
			<br> <br>

			<input type = "submit" class = "submit" onclick = "return btn_Submit()" value = "Ingresar">
		</form>
	</body>

	<?php		
		if(isset($_POST['Submit']))
		{
			$Mail = $_POST['correo'];
			$Description = $_POST['description'];

			$sql = "INSERT INTO Incidencias (ID, MAIL, DESCRIPTION, ACTIVE) VALUES (NULL, '$Mail', '$Description', NULL)";

			if(!mysqli_query($conn, $sql))
			{
				echo "No se pudo insertar";
			}
			else
			{
				echo "Insertado!";
				?>
				<script language="javascript" type="text/javascript">
					   window.location.href = "Gracias.html";
				</script>
				<?php
			}
		}
	?>
</html>
