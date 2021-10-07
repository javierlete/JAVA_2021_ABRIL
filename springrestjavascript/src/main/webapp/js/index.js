$(function() {
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
	alert('Editar ' + href);
	
	$.getJSON(href, function(persona) {
		console.log(persona);
	})
	
	// $.ajax({
	// 	url: href,
	// 	method: 'DELETE'
	// }).done(function(datos, estado, peticion){
	// 	
	// }).fail(function(peticion, estado, error){
	// 	console.log(peticion);
	// 	console.log(estado);
	// 	console.log(error);
	// });
}

function borrar(href) {
	alert('Borrar ' + href);
	
	$.ajax({
		url: href,
		method: 'DELETE'
	}).fail(function(peticion, estado, error){
		console.log(peticion);
		console.log(estado);
		console.log(error);
	});
}