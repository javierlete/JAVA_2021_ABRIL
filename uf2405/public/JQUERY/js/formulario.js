$(function () {
    const $inputDni = $('#dni');
    const $form = $('form');

    $('form button').on('click', function (e) {
        e.preventDefault();

        console.log($inputDni.val());

        if (dniValido($inputDni.val())) {
            $form.submit();
        } else {
            //inputDni.style.border = '1px solid red';

            if (!$inputDni.hasClass('error')) {
                $inputDni.addClass('error').after(
                    $('<span class="error">El DNI es incorrecto</span>'));
            }
        }
    });
});

const letras = 'TRWAGMYFPDXBNJZSQVHLCKE';

function dniValido(dni) {
    const numero = dni.substring(0, dni.length - 1);
    const resto = numero % 23;
    const letra = letras[resto];

    return letra === dni[8];
}