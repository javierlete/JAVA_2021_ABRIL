window.onload = function () {
    const nombre = document.getElementById('nombre');

    console.log(nombre);

    const form = document.querySelector('form'); //document.forms[0]; //document.getElementsByTagName('form')[0];

    console.log(form);

    form.onsubmit = function (e) {
        e.preventDefault();
        console.log(nombre.value);
        const resultado = document.querySelector('#resultado');
        resultado.innerHTML = 'Hola, ' + nombre.value;

        const span = document.createElement('span');
        span.innerHTML = 'Generada dinámicamente' + nombre.value;

        form.appendChild(span);

        console.log(span);
    };

    // const boton = document.getElementsByTagName('button')[0];

    // console.log(boton);

    // boton.onclick = function(e) {
    //     e.preventDefault();
    //     console.log(nombre.value);
    // };
};
