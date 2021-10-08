var URL = 'http://localhost:8080/api/personas';

// Al cargar el documento...
$(function() {
	// Cuando alguien pulse un botón que esté directamente colgando de la etiqueta body...
	$('body > button').click(insertarClick);

	// Ocultamos los formularios
	$('form').hide();

	// Refrescamos la tabla
	refrescarTabla();
});

// Vamos a hacer esto cuando alguien pulse insertar en el botón principal de la página
function insertarClick() {
	// Vaciamos los campos del primer form del documento (el único que hay)
	$('form')[0].reset();

	// A los botones que hay dentro de los formularios les cambiamos el texto a "Insertar",
	// les vaciamos el evento click y les asociamos un nuevo gestor de eventos...
	$('form button').html('Insertar').off('click').click(insertarFormClick);

	// Mostramos los formularios
	$('form').show();
}

// Para ejecutar cuando alguien pulse el botón del formulario para insertar
function insertarFormClick(e) {
	// Cancelamos el evento de botón para que no lo use el formulario e intente enviarlo
	e.preventDefault();
	
	var persona = { 
		nombre: $('#nombre').val(), 
		fechaNacimiento: $('#fechaNacimiento').val() 
	};

	var opciones = {
		// a la URL
		url: URL,
		// por método POST
		method: 'POST',
		// con los datos del formulario convertidos a un objeto que convertimos a JSON
		data: JSON.stringify(persona),
		// en formato JSON
		dataType: 'json',
		// con tipo de contenido application/json
		contentType: 'application/json',
		// En el caso de que la petición vaya bien
	};

	// Hacemos una petición AJAX...
	$.ajax(opciones).done(bien).fail(error);
}

// Refrescar todos los datos que hay en la tabla de HTML
function refrescarTabla() {
	// Vaciamos de filas el tbody
	$('tbody').empty();

	// Pedimos por ajax los datos para rellenar las filas
	$.getJSON(URL, function(datos) {
		// Extraemos de la petición sólo las personas, sin el resto de datos extra
		var personas = datos._embedded.personas;

		// Lo mostramos por consola
		console.log(personas);

		// Por cada una de las personas
		$(personas).each(function() {
			// creamos una nueva fila con varias celdas que contienen los datos de cada persona dentro de this
			// También incluimos enlaces que tienen la dirección donde se puede pedir el registro concreto por REST
			$('tbody').append('<tr>' + 
				'<td>' + this.nombre + '</td>' + 
				'<td>' + this.fechaNacimiento + '</td>' + 
				'<td>' +
					'<a href="javascript:editar(\'' + this._links.self.href + '\')">Editar</a>'+
			 		' <a href="javascript:borrar(\'' + this._links.self.href + '\')">Borrar</a>' + 
				'</td>' +
			'</tr>');
		});
	});
}

// Función que se ejecutará cuando se pulse el enlace editar de la tabla (de cada registro)
// Recibiremos href como la dirección del registro concreto para acceder por REST
function editar(href) {
	console.log('Editar ' + href);

	// Hacemos una petición AJAX para recibir la persona concreta que se ha seleccionado mediante su URL
	$.getJSON(href, function(persona) {
		console.log(persona);

		// Rellenamos los campos de formulario por su id con los valores de la persona seleccionada
		$('#nombre').val(persona.nombre);
		$('#fechaNacimiento').val(persona.fechaNacimiento);

		// Modificamos los botones de los formularios para que pongan "Editar" y borramos todos los gestores de eventos de click
		// que tuvieran asociados
		// Almacenamos la dirección como un dato extra del botón
		// También asociamos un nuevo gestor de click
		$('form button').html('Editar').off('click').data('href', href).click(editarForm);

		// Mostramos el formulario
		$('form').show();
	});
}

// Para ejecutar cuando se de al botón de editar dentro del formulario
function editarForm(e) {
	// Cancelamos el evento de botón para que no lo use el formulario e intente enviarlo
	e.preventDefault();
	
	// Recuperamos la información del botón
	var href = $(this).data('href');
	 
	var opciones = {
		// a la dirección recibida
		url: href,
		// con método PUT
		method: 'PUT',
		// enviando la conversión a JSON de un objeto creado con los datos del formulario
		data: JSON.stringify({ nombre: $('#nombre').val(), fechaNacimiento: $('#fechaNacimiento').val() }),
		// en tipo de datos JSON
		dataType: 'json',
		// con contenido tipo application/json
		contentType: 'application/json',
		// Si va bien la petición
	};
	// Hacemos una petición AJAX
	$.ajax(opciones).done(bien).fail(error);
}

// Función que se ejecutará desde el enlace de borrar de la tabla por cada registro
// Recibimos la dirección del registro a borrar
function borrar(href) {
	console.log('Borrar ' + href);

	var opciones = {
		// a la dirección recibida
		url: href,
		// con el método DELETE
		method: 'DELETE'
		// Si todo va bien
	};
	// Hacemos una llamada AJAX
	$.ajax(opciones).done(bien).fail(error);
}

// Para ejecutar cuando todo vaya bien en AJAX
function bien(datos, estado, peticion) {
	// Ocultamos los formularios
	$('form').hide();
	// Refrescamos la tabla
	refrescarTabla();
	// Si va mal la petición
}

// Para ejecutar cuando haya un error de AJAX
function error(peticion, estado, error) {
	// Mostramos una alerta de que hay un error
	alert('Ha habido un error');

	// y enviamos los datos del error a consola
	console.log(peticion);
	console.log(estado);
	console.log(error);
}