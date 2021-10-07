var URL = 'http://localhost:8080/api/personas';

$(function() {
	$('body > button').click(function() {
		$('form')[0].reset();

		$('form button').html('Insertar').off('click').click(function() {
		$.ajax({
			url: URL,
			method: 'POST',
			data: JSON.stringify({ nombre: $('#nombre').val(), fechaNacimiento: $('#fechaNacimiento').val() }),
			dataType: 'json',
			contentType: 'application/json',
		}).done(function(datos, estado, peticion) {
			$('form').hide();
			refrescarTabla();
		}).fail(function(peticion, estado, error) {
			alert('Ha habido un error');

			console.log(peticion);
			console.log(estado);
			console.log(error);
		});
	});;



		$('form').show();
	});

	$('form').hide();

	refrescarTabla();
});

function refrescarTabla() {
	$('tbody').empty();

	$.getJSON(URL, function(datos) {
		var personas = datos._embedded.personas;

		console.log(personas);

		$(personas).each(function() {
			$('tbody').append('<tr><td>' + this.nombre + '</td><td>' + this.fechaNacimiento + '</td><td><a href="javascript:editar(\'' + this._links.self.href + '\')">Editar</a> <a href="javascript:borrar(\'' + this._links.self.href + '\')">Borrar</a></td></tr>');
		});
	});
}

function editar(href) {
	console.log('Editar ' + href);

	$.getJSON(href, function(persona) {
		console.log(persona);

		$('#nombre').val(persona.nombre);
		$('#fechaNacimiento').val(persona.fechaNacimiento);

		$('form button').html('Editar').off('click').click(function() {
			$.ajax({
				url: href,
				method: 'PUT',
				data: JSON.stringify({ nombre: $('#nombre').val(), fechaNacimiento: $('#fechaNacimiento').val() }),
				dataType: 'json',
				contentType: 'application/json',
			}).done(function(datos, estado, peticion) {
				$('form').hide();
				refrescarTabla();
			}).fail(function(peticion, estado, error) {
				alert('Ha habido un error');

				console.log(peticion);
				console.log(estado);
				console.log(error);
			});
		});
;
		$('form').show();
	});
}

function borrar(href) {
	console.log('Borrar ' + href);

	$.ajax({
		url: href,
		method: 'DELETE'
	}).done(function() {
		refrescarTabla();
	}).fail(function(peticion, estado, error) {
		alert('Ha habido un error');

		console.log(peticion);
		console.log(estado);
		console.log(error);
	});
}