package com.PabloRequena.ProyectoTienda_in5bv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoTiendaIn5bvApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoTiendaIn5bvApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Códigos de color ANSI para la consola
        String VERDE = "\u001B[32m";
        String AMARILLO = "\u001B[33m";
        String CYAN = "\u001B[36m";
        String RESET = "\u001B[0m";

        System.out.println("\n");
        System.out.println(VERDE + "=======================================================");
        System.out.println(AMARILLO + "  [✔] LOGRO DESBLOQUEADO! ");
        System.out.println(VERDE + "=======================================================" + RESET);
        System.out.println(CYAN + "  -> La API está funcionando..." + RESET);
        System.out.println("\n");
    }
}