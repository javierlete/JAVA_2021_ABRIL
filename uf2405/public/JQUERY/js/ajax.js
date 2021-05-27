var URL = 'http://localhost:3000/clientes/';

// Cuando se cargue el documento...
$(function () {
    // Ejecutamos una petición GET a la URL del json-server
    $.getJSON(URL, function (clientes) {
        // Cuando llegue la respuesta del servidor...
        // por cada cliente dentro del lote de clientes recibido...
        $(clientes).each(function () {
            // Creamos una fila de una tabla con la información de cada cliente que tenemos en this
            // y la agregamos (appendTo) a el cuerpo de la tabla (tbody)
            $('<tr><td>' + this.id + '</td><td>' + this.nombre + '</td><td>' + this.apellido +
                // href="javascript:" implica que se llamará a la función que ponemos detrás (editar o borrar)
                // cuando alguien pulse ese vínculo con un argumento que es el id del cliente
                '</td><td><a class="btn btn-primary" href="javascript:editar(' + this.id +
                ')">Editar</a> <a class="btn btn-danger" href="javascript:borrar(' + this.id +
                ')">Borrar</a></td></tr>').appendTo('tbody');
        });
    });

    // Cuando se envíe el formulario...
    $('form').on('submit', function(e) {
        // ...desactivamos la propagación del evento para que no se dispare una recarga de la página
        e.preventDefault();

        // Cogemos el valor guardado en el cuadro de texto cuyo id es "id" literalmente
        var numId = parseInt($('#id').val());
        // Si el id no se ha podido convertir a número lo convertimos en un null, y si no simplemente lo almacenamos en id
        var id = isNaN(numId) ? null : numId;
        // Creamos un objeto cliente con los datos del id creado anteriormente y el nombre y apellido que están en los cuadros
        // de texto de id nombre y apellido respectivamente.
        var cliente = { id, nombre: $('#nombre').val(), apellido: $('#apellido').val() };
        
        console.log(cliente);

        // Dependiendo de si tenemos id o no, usaremos una petición al json-server de PUT (tenemos id) o POST (no tenemos id)
        var metodo = cliente.id ? 'PUT' : 'POST';
        // La URL a la que tenemos que llamar será sólo la dirección base de clientes o la dirección con un id por detrás
        // http://localhost:3000/clientes/ (POST)
        // http://localhost:3000/clientes/3 (PUT)
        var url = cliente.id ? URL + id : URL;

        // Lanzamos la petición a la url correspondiente con el método correspondiente y con los datos del cliente metidos
        // en el objeto cliente
        $.ajax(url, { method: metodo, data: cliente });
    });
});

// Se llamará cuando pulsemos un enlace de editar
function editar(id) {
    console.log('EDITAR', id);

    // En el caso de que el id esté rellenado
    if (id) {
        // Lanzamos una petición a http://localhost:3000/clientes/2
        $.getJSON(URL + id, function (cliente) {
            // Y cuando nos llegue la información del cliente en un objeto llamado cliente literalmente
            // Pasamos los datos de ese cliente a los cuadros de texto respectivos
            // <input id = "id"
            $('#id').val(cliente.id);
            // <input id = "nombre"
            $('#nombre').val(cliente.nombre);
            // <input id = "apellido"
            $('#apellido').val(cliente.apellido);
        });
        // Si no hay id
    } else {
        // Vaciamos los cuadros del formulario
        $('#id').val('');
        $('#nombre').val('');
        $('#apellido').val('');
    }
}

// Cuando se pulse borrar
function borrar(id) {
    console.log('BORRAR', id);
    // Mandamos la petición de tipo DELETE a la URL http://localhost:3000/clientes/2
    $.ajax(URL + id, { method: 'DELETE' });
}