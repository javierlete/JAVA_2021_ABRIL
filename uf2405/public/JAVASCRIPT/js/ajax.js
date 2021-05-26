const URL = 'http://localhost:3000/clientes/';

document.addEventListener('DOMContentLoaded', async () => {
    const respuesta = await fetch(URL);
    const clientes = await respuesta.json();

    console.log(clientes);

    const tbody = document.querySelector('tbody');
    let tr;

    clientes.forEach((cliente) => {
        tr = document.createElement('tr');
        tr.innerHTML = `
            <th>${cliente.id}</th>
            <td>${cliente.nombre}</td>
            <td>${cliente.apellido}</td>
            <td>
                <a class="btn btn-primary" href="javascript:editar(${cliente.id})">Editar</a>
                <a class="btn btn-danger" href="javascript:borrar(${cliente.id})">Borrar</a>
            </td>`;

        tbody.appendChild(tr);
    });

    document.querySelector('form').addEventListener('submit', async (e) => {
        e.preventDefault();
        console.log('ACEPTAR');

        const id = document.querySelector('#id').value;
        const nombre = document.querySelector('#nombre').value;
        const apellido = document.querySelector('#apellido').value;

        const cliente = { nombre, apellido };

        console.log(cliente);

        // debugger;

        if (id) {
            cliente.id = id;
            await fetch(URL + id, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(cliente)
            });
        } else {
            await fetch(URL, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(cliente)
            });
        }
    });
});

async function editar(id) {
    console.log('EDITAR', id);

    const respuesta = await fetch(URL + id);
    const cliente = await respuesta.json();

    console.log(cliente);

    document.getElementById("id").value = cliente.id;
    document.getElementById("nombre").value = cliente.nombre;
    document.getElementById("apellido").value = cliente.apellido;
}

async function borrar(id) {
    console.log('BORRAR', id);

    await fetch(URL + id, { method: 'DELETE' });

    console.log('Borrado');
}

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