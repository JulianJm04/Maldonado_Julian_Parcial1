/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1juli
 */
public class Sistema {
    private List<Servicio> lstServicio;

    public Sistema() {
        lstServicio = new ArrayList<>();
    }

    
    // Busca un servicio por su codigo.
    // Toma el codigo del servicio.
    // Retorna si el servicio es encontrado.
    public Servicio traerServicio(String codServicio) {
        for (Servicio s : lstServicio) {
            if (s.getCodServicio().equals(codServicio)) {
                return s;
            }
        }
        return null;
    }

    // Retorna una lista de servicios en promocion.
    // TOma enPromocion para indicar si los servicios buscados estan en promocion.
    // Retorna lista de servicios en promocion.
    public List<Servicio> traerServicio(boolean enPromocion) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    // Retorna una lista de servicios en promocion y que apliquen descuentos en una fecha dada.
    // Toma la fecha.
    // Retorna la lista de servicios en promocion.
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        List<Servicio> resultado = new ArrayList<>();
        for (Servicio s : lstServicio) {
            if (s.isEnPromocion() == enPromocion && s.calcularPrecioFinal(dia) != 0) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    // Agrega un servicio a la lista de servicios.
    // Toma codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc.
    // Retorna a true si el servicio fue agregado con correctamente, false en caso contrario.
    // throws IllegalArgumentException si ya existe un servicio con el mismo codigo
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("Ya existe un servicio con el mismo codigo.");
        }
        Gastronomia nuevo = new Gastronomia(codServicio, gastronomia, precio, diaSemDesc, porcentajeDescuento, enPromocion);
        return lstServicio.add(nuevo);
    }

    // Agrega un servicio de hospedaje a la lista de servicios.
    // Toma codServicio, porcentajeDescuento, enPromocion,hospedaje, precioPorNoche.
    // Retorna a true si el servivio se agrego correctamente, si no retorna a flase.
    // throws IllegalArgumentException si ya existe un servicio con el mismo codigo
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("Ya existe un servicio con el mismo codigo.");
        }
        Hospedaje nuevo = new Hospedaje(codServicio, hospedaje, precioPorNoche, porcentajeDescuento, enPromocion);
        return lstServicio.add(nuevo);
    }
    
    //Se agregu un metodo para imprimir la lista de servicios de manera organizada.
    public void imprimirServicios() {
    if (lstServicio.isEmpty()) {
        System.out.println("No hay servicios disponibles.");
    } else {
        for (Servicio servicio : lstServicio) {
            System.out.println(servicio);
        }
    }
}
}
    
    
    
