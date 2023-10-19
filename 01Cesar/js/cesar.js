const desplazamiento = document.getElementById("desplazamiento");
const texto = document.getElementById("texto");
const textoCifrado = document.getElementById("cifrado");
const textoDescifrado = document.getElementById("descifrado");

function obtenerValorDesplazamiento() {
    const valor = desplazamiento.value;
    if (/^-?\d+$/.test(valor)) {
        const num = parseInt(valor);
        if (num >= -25 && num <= 25) {
            return num;
        }
    } else if (/^[a-zA-Z]$/.test(valor)) {
        return valor.toLowerCase().charCodeAt(0) - 'a'.charCodeAt(0);
    }
    return 0;  // Valor por defecto si no se pudo obtener un desplazamiento válido
}


function cifrado() {
    const textoIngresado = texto.value;
    const valorDesplazamiento = obtenerValorDesplazamiento();

    textoCifrado.value = textoIngresado.split('').map(c => {
        let valorEntero = c.charCodeAt(0);
        if (valorEntero >= 65 && valorEntero <= 90) {
            valorEntero = (valorEntero - 65 + valorDesplazamiento) % 26 + 65;
        } else if (valorEntero >= 97 && valorEntero <= 122) {
            valorEntero = (valorEntero - 97 + valorDesplazamiento) % 26 + 97;
        } else if (valorEntero >= 48 && valorEntero <= 57) {
            valorEntero = (valorEntero - 48 + valorDesplazamiento) % 10 + 48;
        }
        let cifrado = String.fromCharCode(valorEntero);
        return cifrado;
    }).join('');
}

texto.addEventListener("keyup", cifrado);
desplazamiento.addEventListener("input", cifrado);
desplazamiento.addEventListener("change", cifrado);
textoCifrado.addEventListener("keyup", descifrado);

function descifrado() {
    const textoIngresado = textoCifrado.value;
    const valorDesplazamiento = obtenerValorDesplazamiento();

    textoDescifrado.value = textoIngresado.split('').map(c => {
        let valorEntero = c.charCodeAt(0);

        if (c.match(/[A-Z]/)) {
            valorEntero = ((valorEntero - 65 - valorDesplazamiento + 26) % 26) + 65;
        } else if (c.match(/[a-z]/)) {
            valorEntero = ((valorEntero - 97 - valorDesplazamiento + 26) % 26) + 97;
        } else if (c.match(/[0-9]/)) {
            valorEntero = ((valorEntero - 48 - valorDesplazamiento + 10) % 10) + 48;
        }

        return String.fromCharCode(valorEntero);
    }).join('');
}
