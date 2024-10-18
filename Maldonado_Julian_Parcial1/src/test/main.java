/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;
import java.time.LocalDate;
import model.*;

/**
 *
 * @author 1juli
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        // 1. Pruebas de Creacion de Objetos
        // 1-1) Intentar crear el objeto Gastronomia con codServicio de longitud incorrecta
        System.out.println("1-1");
        try {
            Gastronomia g1 = new Gastronomia("4892", "Hamburguesa criolla", 180.0, 4, 15.0, true);
            System.out.println("Error: El objeto tiene una longitud incorrecta.");
        } catch (IllegalArgumentException e) {
            System.out.println("Se capturo la excepcion: " + e.getMessage());
        }
        
        System.out.println("");

        // 1-2) Crear el objeto Gastronomia con los datos correctos
        Gastronomia g2 = null;
        System.out.println("1-2");
        try {
            g2 = new Gastronomia("489235", "Hamburguesa criolla", 180.0, 4, 15.0, true);
            sistema.agregarGastronomia("489235", 15.0, true, "Hamburguesa criolla", 180.0, 4);
            System.out.println("El objeto: " + g2.getGastronomia() + ", se creo correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear: " + e.getMessage());
        }
        
        System.out.println("");

        // 1-3) Intentar crear el objeto Hospedaje con codServicio de longitud incorrecta
        System.out.println("1-3");
        try {
            Hospedaje h1 = new Hospedaje("2872", "Cabaña 3 personas", 1500.0, 10.0, true);
            System.out.println("Error: El objeto tiene una longitud incorrecta.");
        } catch (IllegalArgumentException e) {
            System.out.println("Se capturo la excepcion: " + e.getMessage());
        }
        
        System.out.println("");

        // 1-4) Crear el objeto Hospedaje con los datos correctos
        Hospedaje h2 = null;
        System.out.println("1-4");
        try {
            h2 = new Hospedaje("287282", "Cabaña 3 personas", 1500.0, 10.0, true);
            sistema.agregarHospedaje("287282", 10.0, true, "Cabaña 3 personas", 1500.0);
            System.out.println("Hospedaje creado correctamenre: " + h2.getHospedaje()+ ".");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear: " + e.getMessage());
        }
        
        System.out.println("");

        // 2. Calculo de Precios Finales
        // 2-1) Calcular e imprimir precio final del servicio Gastronomia para el dia especificado
        if (g2 != null) {
            System.out.println("2-1");
            LocalDate fecha1 = LocalDate.of(2020, 10, 28);
            double precioFinalGastronomia = g2.calcularPrecioFinal(fecha1);
            System.out.println("Precio final de Gastronomia para el dia " + fecha1 + ": $" + precioFinalGastronomia);
        }
        
        System.out.println("");

        // 2-2) Calcular e imprimir precio final del servicio Hospedaje para el dia especificado
        if (h2 != null) {
            System.out.println("2-2");
            LocalDate fecha2 = LocalDate.of(2020, 10, 27);
            double precioFinalHospedaje = h2.calcularPrecioFinal(fecha2);
            System.out.println("Precio final para el dia " + fecha2 + ": $" + precioFinalHospedaje);
        }
        
        System.out.println("");

        // 3. Agregar Servicios
        System.out.println("3");
        try {
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
            sistema.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0);
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3);
            sistema.agregarHospedaje("758972", 15.0, false, "Habitacion simple", 1000.0);
            System.out.println("Servicios agregados correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar servicios: " + e.getMessage());
        }
        
        System.out.println("");

        if (sistema != null) {
            System.out.println("-------------------Lista de servicios disponibles -------------------");
            sistema.imprimirServicios(); 
            System.out.println("-----------------------------------------------------------------------");
        }
        
        System.out.println("");

        // 4. Consultas de Servicios
        // 4-1) Traer todos los objetos Servicios en promocion
        System.out.println("4-1");
        System.out.println("-------------------Lista de servicios en promocion ---------------------");
        for (Servicio servicio : sistema.traerServicio(true)) {
            System.out.println(servicio);         
        }
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("");

        // 4-2) Traer todos los objetos Servicios del dia 2020-10-28 y en promocion
        System.out.println("4-2");
        System.out.println("----------Lista de servicios en promocion del dia (28/10/2020)----------");
        for (Servicio servicio : sistema.traerServicio(true, LocalDate.of(2020, 10, 28))) {
            System.out.println(servicio);
        }
        System.out.println("-------------------------------------------------------------------------");
    }
}
