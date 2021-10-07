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
			$('table').append('<tr><td>' + this.nombre + '</td><td>' + this.fechaNacimiento + '</td></tr>');
		});
	});
});
