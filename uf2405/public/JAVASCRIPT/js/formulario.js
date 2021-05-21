document.addEventListener('DOMContentLoaded', function () {
    const inputDni = document.querySelector('#dni');
    const form = document.querySelector('form');

    form.addEventListener('submit', function (e) {
        e.preventDefault();

        console.log(inputDni.value);

        if (dniValido(inputDni.value)) {
            form.submit();
        } else {
            //inputDni.style.border = '1px solid red';

            if (!inputDni.classList.contains('error')) {
                inputDni.classList.add('error');
                const span = document.createElement('span');
                span.className = 'error';
                span.innerHTML = 'El DNI es incorrecto';
                inputDni.insertAdjacentElement("afterend", span);
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