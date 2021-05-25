$(function () {
    $('form').on('submit', function (e) {
        e.preventDefault();
        $('#resultado').html('Hola, ' + $('#nombre').val());

        $('<span>Generada dinámicamente' + $('#nombre').val() + '</span>').appendTo($('form'));
    });
});
