# EmpleadosAdmin
<p dir="auto">Este README describe cómo utilizar la aplicación de gestión de empleados diseñada para ser ejecutada desde la terminal. Una vez iniciada, esta se ejecutará indefinidamente hasta que el usuario decida acabar su ejecución. La aplicacón está diseñada de modo que creará la tabla automáticamente en su BBDD "empleados" si no existiese la tabla previamente. La aplicación permite a los usuarios realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una base de datos de empleados directamente desde la línea de comandos.</p>

<!-- Tecnologías Utilizadas -->

<h2 dir="auto">Tecnologías utilizadas</h2>
<ul dir="auto">
	<li>Back-end: <a target="_blank" rel="noopener noreferrer nofollow" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTHiXC1J0Tu16Edwsnf83qnm-O3DfPLxYmJw&usqp=CAU"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTHiXC1J0Tu16Edwsnf83qnm-O3DfPLxYmJw&usqp=CAU" alt="Java" data-canonical-src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSTHiXC1J0Tu16Edwsnf83qnm-O3DfPLxYmJw&usqp=CAU" style="max-width: 7%;"></a>
	<li>Base de datos: <a target="_blank" rel="noopener noreferrer nofollow" href=""><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnO0xHQrNDbCdgefmnjSjUPAMIKBx2F-NOww&usqp=CAU" alt="MySQL" data-canonical-src="" style="max-width: 5%;"></a></li>
</ul>

<!-- Información General -->

<h2 dir="auto">Información General</h2>
<ul dir="auto">
	<li><b>Agregar un nuevo empleado:</b> Permite a los usuarios ingresar información sobre un nuevo empleado, incluyendo nombre, apellido, cargo, salario y fecha de inicio. Se validarán los datos de entrada para que no se pueda registrar usuarios con campos vacíos.</li>
	<li><b>Listar empleados:</b> Visualización de la lista de todos los empleados activos en la base de datos.</li>
	<li><b>Actualizar empleados:</b> Los usuarios pueden modificar la información de un empleado existente, incluyendo nombre, apellido, cargo, salario o fecha de inicio.  mediante su id. Se validará los datos de entrada para no poder actualizar un empleado con un campo vacío.</li>
	<li><b>Eliminar un empleado:</b> Borrado lógico de un usuario mediante la modificación de un atributo de su clase.</li>
	<li><b>Buscar empleados por cargo:</b> Búsqueda personalizada de los empleados activos mediante coincidencia en nombre, apellido o cargo.</li>
    <li><b>Salir:</b> La ejecución del programa finalizará</li>
</ul>

<!-- Instalación y configuración -->

<h2 dir="auto">Instalación y configuración</h2>
<b>Para Windows</b>
<ul dir="auto"><b></b>
	<li>Visita el sitio web oficial de Oracle, e instala  <a href="https://www.oracle.com/java/technologies/downloads/#java17">JDK</a> en el equipo.</li>
	<li>Una vez completada la instalación, verifica que el JDK esté correctamente configurado ejecutando java -version en la línea de comandos de la terminal de su PC.</li>
</ul>
<b>Para macOS</b>
<ul dir="auto">
<li>Abre la Terminal.</li>
<li>Instala Homebrew si aún no lo tienes: /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"</li>
<li>Usa Homebrew para instalar el JDK: brew install openjdk</li>
<li>Verifica la instalación ejecutando java -version en la Terminal.</li>
</ul>

<b>Instalar Mysql y mysql workbench para la Base de Datos</b>
   <ul>
    <li><a href="https://dev.mysql.com/doc/refman/8.0/en/windows-installation.html">Instalación Windows</a></li>
    <li><a href="https://dev.mysql.com/doc/refman/5.7/en/macos-installation-pkg.html">Instalación Mac</a></li>
    <li>En la carpeta del proyecto incluimos el script para crear la base de datos, si está Workbench instalado correctamente solo hay que importar el archivo que contiene estructura y los datos de la BBDD predeterminados para las pruebas.</li>
  </ul>


<!-- EJECUCIÓN -->

<h2 dir="auto">Abrir y Ejecutar Proyecto</h2>
<ul dir="auto">
    <li>Clona el repositorio</li>
  	<li>Abrir proyecto en su IDE</li>
	<li>Actualiza dependencias si fuera necesario</li>
	<li>Ejecuta el programa mediante el archivo `PruebaTecnicaJPA.java`
    <li>Sigue las instrucciones proporcionadas en la consola.</li>
</ul>

<!-- BBDD -->

<h2 dir="auto">Información de la Base de Datos y la Tabla</h2>
<ul dir="auto">
	<li>EMPLEADOS: Almacena todos los datos de cada empleado, que tendrá por defecto el id, nombre, apellido, cargo, salario, fechaInicio. Además de ello tiene un campo llamada "activo" (para el borrado lógico).</li>
</ul>

<!-- SUPUESTOS -->

<h2 dir="auto">Supuestos aplicados por el desarrollador</h2>
<ul dir="auto">
	<li>1) Para el borrado lógico y edición de un usuario, se ha partido del supuesto de que el usuario conoce previamente los id de todos los empleados</li>
	<li>2) Para la búsqueda personalizada, se ha partido del supuesto de que el usuario conoce los valores de los atributos guardados.</li>
	<li>3) Para la validación de datos en los atributos String, se ha partido del supuesto de que el usuario no introducirá caracteres que no sean letras, es decir, números o caracteres especiales.</li>
    <li>4) Para la validación de datos numéricos, se ha partido del supuesto que el usuario no introducirá valores que no sean numéricos.</li>
    <li>5) Para la introducción de datos tipo fecha, se ha partido del supuesto que sólo se permitirá introducir los datos en un formato predeterminado el cuál se le indicará al usuario cada vez que interactúe con este tipo de dato.</li>
    <li>6) Para la introducción de datos en general, se ha partido del supuesto de que no será permitido ingresar campos vacíos, el código tiene la correspondiente lógica implementada para controlar este punto.</li>
    <li>7) Para cumplir con el punto 4 de los requisitos técnicos, se ha partido del supuesto que se refiere al uso de colecciones para gestionar los datos cuando se solicita la lista de empleados y como añadido para el envío de los parámetros en el filtro de búsqueda personalizada.</li>
</ul>

<!-- DESARROLLADORES -->

<h2 dir="auto">Desarrollador</h2>
<p dir="auto">Esta aplicación ha sido desarrollada por: </p>
<ul dir="auto">
	<li><a href="https://www.linkedin.com/in/antonio-padilla-carrillo" rel="nofollow">Antonio Padilla</a></li>
</ul>

<h2 dir="auto"><a id="user-content-licencia" class="anchor" aria-hidden="true" href="#licencia"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>Licencia de uso</h2>

<p>El código del proyecto aquí alojado se encuentra bajo licencia <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/" rel="nofollow"><img alt="Licencia Creative Commons" src="https://camo.githubusercontent.com/f05d4039b67688cfdf339d2a445ad686a60551f9891734c418f7096184de5fac/68747470733a2f2f692e6372656174697665636f6d6d6f6e732e6f72672f6c2f62792d6e632d73612f342e302f38387833312e706e67" data-canonical-src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" style="max-width: 100%;"></a><br> <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/" rel="nofollow">Licencia Creative Commons Atribución-NoComercial-CompartirIgual 4.0 Internacional</a></p>




