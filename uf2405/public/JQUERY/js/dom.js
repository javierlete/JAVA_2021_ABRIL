$(function () {
    $('form').on('submit', function (e) {
        e.preventDefault();
        $('#resultado').html('Hola, ' + $('#nombre').val());

        $('<span>Generada dinĂ¡micamente' + $('#nombre').val() + '</span>').appendTo($('form'));
    });
});
