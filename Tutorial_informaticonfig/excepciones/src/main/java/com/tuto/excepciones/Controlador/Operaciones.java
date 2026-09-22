package com.tuto.excepciones.Controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/divide")
public class Operaciones {

    @GetMapping
    public String Divide(@RequestParam String numero) {

        try {
            int valor = Integer.parseInt(numero);
            int resultado = 20 / valor;

            return "Resultado: " + resultado;

        } catch (NumberFormatException ERROR) {
            return "Error: el valor ingresado ('" + numero + "') no es un numero";

        } catch (ArithmeticException ERROR) {
            return "Error: no se puede dividir entre 0";
        }
    }
}


@RestController
class ObjetoNulo {

    @GetMapping("valornulo")
    public String nulo() {
        String valorNulo = null;
        valorNulo.length();

        return "Valor nulo en la variable";

    }
}


