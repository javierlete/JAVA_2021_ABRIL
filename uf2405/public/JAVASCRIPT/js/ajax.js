document.addEventListener('DOMContentLoaded', async () => {
    const respuesta = await fetch('json/clientes.json');
    const clientes = await respuesta.json();

    console.log(clientes);

    const ul = document.getElementById('lista');
    let li;

    clientes.forEach((cliente) => {
        li = document.createElement('li');
        li.innerHTML = `${cliente.nombre} ${cliente.apellido}`;

        ul.appendChild(li);
    });
});

// ES2015
// document.addEventListener('DOMContentLoaded', function () {
//     fetch('json/clientes.json'
//     ).then(function (respuesta) {
//         console.log(respuesta);
//         return respuesta.json();
//     }).then(function (clientes) {
//         console.log(clientes);

//         const ul = document.getElementById('lista');
//         let li;

//         for (let cliente of clientes) {
//             li = document.createElement('li');
//             li.innerHTML = `${cliente.nombre} ${cliente.apellido}`;

//             ul.appendChild(li);
//         }
//     });
// });