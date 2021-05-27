var URL = 'http://localhost:3000/clientes/';

$(function () {
    $.getJSON(URL, function (clientes) {
        $(clientes).each(function () {
            $('<tr><td>' + this.id + '</td><td>' + this.nombre + '</td><td>' + this.apellido +
                '</td><td><a href="javascript:editar(' + this.id +
                ')">Editar</a> <a href="javascript:borrar(' + this.id +
                ')">Borrar</a></td></tr>').appendTo('tbody');
        });
    });

    $('form').on('submit', function(e) {
        e.preventDefault();
        var numId = parseInt($('#id').val());
        var id = isNaN(numId) ? null : numId;
        var cliente = { id, nombre: $('#nombre').val(), apellido: $('#apellido').val() };
        
        console.log(cliente);

        var metodo = cliente.id ? 'PUT' : 'POST';
        var url = cliente.id ? URL + id : URL;

        $.ajax(url, { method: metodo, data: cliente });
    });
});

function editar(id) {
    console.log('EDITAR', id);

    if (id) {
        $.getJSON(URL + id, function (cliente) {
            $('#id').val(cliente.id);
            $('#nombre').val(cliente.nombre);
            $('#apellido').val(cliente.apellido);
        });
    } else {
        $('#id').val('');
        $('#nombre').val('');
        $('#apellido').val('');
    }
}

function borrar(id) {
    console.log('BORRAR', id);

    $.ajax(URL + id, { method: 'DELETE' });
}