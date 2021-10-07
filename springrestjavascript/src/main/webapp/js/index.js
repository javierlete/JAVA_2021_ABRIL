$(function() {
	$('form').hide();

	$.getJSON('http://localhost:8080/api/personas', function(datos) {
		var personas = datos._embedded.personas;

		console.log(personas);

		var pre = $('body').append('<pre>');

		$(personas).each(function() {
			pre.append(this.nombre + ', ' + this.fechaNacimiento);
			pre.append('<br/>');
		});

		$(personas).each(function() {
			$('table').append('<tr><td>' + this.nombre + '</td><td>' + this.fechaNacimiento + '</td><td><a href="javascript:editar(\'' + this._links.self.href + '\')">Editar</a> <a href="javascript:borrar(\'' + this._links.self.href + '\')">Borrar</a></td></tr>');
		});
	});
});

function editar(href) {
	console.log('Editar ' + href);

	$.getJSON(href, function(persona) {
		console.log(persona);
		
		$('#nombre').val(persona.nombre);
		$('#fechaNacimiento').val(persona.fechaNacimiento);

		$('form button').html('Editar').click(function() {
			$.ajax({
				url: href,
				method: 'PUT',
				data: JSON.stringify({ nombre: $('#nombre').val(), fechaNacimiento: $('#fechaNacimiento').val() }),
				dataType: 'json',
				contentType: 'application/json',
			}).done(function(datos, estado, peticion){
				alert('Todo correcto');
			}).fail(function(peticion, estado, error){
				alert('Ha habido un error');
				
				console.log(peticion);
				console.log(estado);
				console.log(error);
			});
		});

		$('form').show();
	});



}

function borrar(href) {
	alert('Borrar ' + href);

	$.ajax({
		url: href,
		method: 'DELETE'
	}).fail(function(peticion, estado, error) {
		alert('Ha habido un error');
		
		console.log(peticion);
		console.log(estado);
		console.log(error);
	});
}