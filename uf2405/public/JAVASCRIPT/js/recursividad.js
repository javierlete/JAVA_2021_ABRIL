// 5! = 5 * 4 * 3 * 2 * 1
// 5! = 5 * 4!
// 4! = 4 * 3!
// 3! = 3 * 2!
// 2! = 2 * 1!
// 1! = 1

// Versión recursiva
function factorial(numero) {
    return numero === 1 ? 1 : numero * factorial(numero - 1);
}

console.log(factorial(5));

// Versión no recursiva (iterativa)
function factorialIterativo(numero) {
    let total = 1;
    
    for(let i = 1; i <= numero; i++) {
        total *= i;
    }

    return total;
}

console.log(factorialIterativo(5));
