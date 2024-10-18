/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;

/**
 *
 * @author 1juli
 */
public abstract class Servicio {
    private String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) {
        if (codServicio.length() != 6) {
          throw new IllegalArgumentException("Debe tener una longitud de 6 caracteres.");
        }
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }
    
    // Metodo abstracto para calcular el precio final del servicio.
    // Toma la fecha para calcualr el precio.
    // Retrona el precio final del servicio.
    public abstract double calcularPrecioFinal(LocalDate dia);
      
}
