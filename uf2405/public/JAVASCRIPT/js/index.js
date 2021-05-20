'use strict';

function basico() {

    //alert('hola a todos')

    console.log(prueba);

    console.log('Prueba en la consola');

    var nombre = prompt('Dime tu nombre');

    console.log('Hola ' + nombre);

    console.log(typeof nombre);

    console.log(typeof 1);

    console.log(typeof new Date());

    var prueba;

    console.log(typeof prueba);

    nombre = 5;

    console.log(typeof nombre);

    let sino = confirm('¿Estás seguro?');

    console.log(typeof sino, sino);

    sino = false;

    const apellido = prompt('Dime tu apellido');

    console.log(apellido);

    // apellido = 'Otro';

    const numero = parseInt(prompt('Dime un número'), 10);

    console.log(numero, numero + 2, typeof numero);

    if (isNaN(numero)) {
        console.log('No es un número');
    } else {
        console.log('Es un número');
    }

    const mes = parseInt(prompt('Mes'));
    let dias;

    switch (mes) {
        case 2: dias = 28; break;
        case 4:
        case 6:
        case 9:
        case 11: dias = 30; break;
        default: dias = 31;
    }

    console.log(mes, dias);

}

function arrays() {
    const arr = []; //Array(2);

    arr[0] = 3;
    arr[1] = 7;

    console.log(arr[0], arr[1]);

    arr[2] = 8;
    arr[7] = 3;
    arr[5] = 'Pepe';

    arr['Hola'] = 'Hello';
    arr.perro = 'dog';

    arr.push(new Date());

    arr.pero = 'bigdog';
    console.log(arr);

    for(let i = 0; i < arr.length; i++) {
        console.log(arr[i]);
    }

    for(let dato of arr) {
        console.log(dato);
    }

    for(let clave in arr) {
        console.log(clave, arr[clave]);
    }
}

function objetos() {
    const persona = new Object();

    persona.id = 1;
    persona.nombre = 'Javier';
    persona['apellido'] = 'Lete';

    persona.nombreCompleto = function() {
        return `${this.nombre} ${this.apellido}`;
    };

    console.log(persona, persona.id, persona.nombre);

    console.log(persona.nombreCompleto());

    const campo = 'id';

    console.log(persona[campo]);

    function Persona(id, nombre, apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    Persona.prototype.nombreCompleto = function() {
        return `${this.nombre}, ${this.apellido}`;
    }

    const persona1 = new Persona(1, 'Javier', 'Lete');

    console.log(persona1);

    const persona2 = new Persona();

    console.log(persona2);

    console.log(persona1.nombreCompleto());
    console.log(persona2.nombreCompleto());

    class Persona2 {
        constructor(id, nombre, apellido) {
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
        }

        nombreCompleto() {
            return `${this.nombre}, ${this.apellido}`;
        }
    }

    const personaA = new Persona2(2, 'yepa', 'yepez');
    personaA.edad = 25;
    console.log(personaA, personaA.nombreCompleto());
}

objetos();
