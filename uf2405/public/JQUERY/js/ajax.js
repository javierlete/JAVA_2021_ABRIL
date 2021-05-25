$(function() {
    console.log('1');
    $.getJSON('json/clientes.json', function(clientes) {
        console.log('2');
        $(clientes).each(function() {
            console.log('3');
            $('ul').append($('<li>').html(this.nombre + ' ' + this.apellido));
        });

        console.log('4');
    });
    console.log('5');
});
