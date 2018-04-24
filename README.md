<h1> Watson Conversation </h1>
<div>
	<a href = '#Instalacion'>Instalación</a> |
	<a href = '#Requerimientos'>Requerimientos</a> |
	<a href = '#FAQ'>Preguntas Frecuentes</a>
</div>
<br>
<div id = "Resumen">
	<p>WatsonConversation es una aplicación de escritorio desarrollada en Java 9 junto con las librerias de Bluemix para poder utilizar sus APIs, al igual que el interpretador y formateo de apache para conservar los encodings 'UTF-8' para el envío y regreso de respuestas dinamicas de preguntas previamente solucionadas.<p>
</div>
<br>
<div id = "Instalacion">
	<h2>Instalación del ejecutable</h2>
	<p>Para hacer uso de este programa no es necesario hacer una instalación, el proyecto viene con una construcción del mismo en formato de Jar, haciendolo muy portable para diversos sitemas operativos, gracias a Java.</p>
	<h3>Java</h3>
	<p>http://www.oracle.com/technetwork/java/javase/downloads/index.html</p>
	<h2>Instalación para código fuente</h2>
	<h3>JDK</h3>
	<p>http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html</p>
	<h3>IDE</h3>
	<p>Netbeans: https://netbeans.org/downloads/</p>
	<p>Eclipse: http://www.eclipse.org/downloads/eclipse-packages/</p>
	<h3>Bluemix</h3>
	<p>https://console.bluemix.net/</p>
	<h3>Watson Assistant</h3>
	<p>https://watson-assistant.ng.bluemix.net</p>
</div>
<br>
<div id = "Requerimientos">
	<h2>Requerimientos</h2>
	<ul>
		<li>Sistema Operativo Windows 7, 8, 8.1, 10, MacOS, Linux</li>
		<li>Java 9 o superior</li>
	</ul>
</div>
<br>
<div id = "FAQ">
	<h2>Preguntas Frecuentes</h2>
	<h3>¿Qué tipos de archivos puedo enviar?</h3>
	<p>Únicamente se pueden enviar archivos con extensión CSV, al momento de ser guardados asegurarse que tengan un encoding UTF-8 para que se consideren caracteres latinoamericanos.</p>
	<h3>¡Mi archivo tarda mucho en procesar!</h3>
	<p>La rápidez del programa y de la respuesta de Watson tarda dependiendo de la cantidad de preguntas que se le están mandando a la vez, un archivo de 10000 preguntas obviamente va a tardar mucho más que uno de 10</p>
	<h3>El CSV de respuesta generá caracteres raros en la nueva columna</h3>
	<p>Asegurate de tener al menos Java 9 instalado en tu computadora, a partir de está versión se consideran los caracteres latinoamericanos, evitando ese tipo de problemas</p>
	<h3>No me regresa una respuesta, a pesar de haberla formulado de muchas formas</h3>
	<p>La pregunta no está cargada en el sistema, por lo que no va a generar respuesta.</p>
	<h3>El campo de la descripción regresa cortado después de ser envíado. ¿Por qué?</h3>
	<p>Existe un límite al enviar información a Watson Assistant, después de 2000 caracteres no acepta más y termina el proceso, por lo que se va a cortar la descripción después de sobrepasar ese número.</p>
	<h3>¡No encuentro el CSV de respuesta!</h3>
	<p>La respuesta siempre se va a generar dónde se encuentra el mismo .jar, asegurate de tenerlo en una ubicación fácil de encontrar.</p>
	<h3>¿Hasta cuantas preguntas puedo envíar?</h3>
	<p>No existe límite en cuanto al programa se refiere, sin embargo Watson Assistant si, especialmente por estar utilizando un plan gratuito, así que 10,000 llamadas son las que se pueden hacer al mes.</p>
	<h3>Quiero hacer modificaciones a la estructura de la conversación</h3>
	<p>El workspace cargado en el programa es uno personal, no se puede editar por otras personas. Sin embargo el JSON del mismo se encuentra dentro del código fuente para poder ser cargado en el de los usuarios.</p>
	<h3>¡Ya no estoy recibiendo respuestas! ¿Qué pasa?</h3>
	<p>Muy probablemente ya se acabaron las llamadas mensuales que se otorgan a los usuarios grátis del servicio, de ser así lo mejor es esperarse hasta el 1ro del siguiente mes para realizar más consultas.</p>
	<h3>¿Se implementará 'x' proceso en el futuro?</h3>
	<p>Por ahora no se tienen planes de hacer mejoras o correcciones al programa o al workspace, implementaciones posibles a futuro se pueden leer en los Documentos oficiales.</p>
</div>
