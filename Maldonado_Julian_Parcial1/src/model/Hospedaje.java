/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import java.time.DayOfWeek;

/**
 *
 * @author 1juli
 */
public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio, String hospedaje, double precioPorNoche, double porcentajeDescuento, boolean enPromocion) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;       
    }
    
    //Calcula el precio final del hospedaje para la fecha dada.
    // Recibe la fecha para la cual se calcula el precio.
    // Retorna el precio final del hospedaje.
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precioPorNoche;
        if (isEnPromocion() && dia.getDayOfWeek() != DayOfWeek.SATURDAY && dia.getDayOfWeek() != DayOfWeek.SUNDAY) {
            precioFinal -= precioFinal * (getPorcentajeDescuento() / 100);
        }
        return precioFinal;
    }
    
    public String getHospedaje() {
        return hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    
    //Representacion del hospedaje.
    // Retorna cadena que describe el hospedaje
    @Override
    public String toString() {
        System.out.println("- Hospedaje:");
        return "Codigo servicio: " + getCodServicio() +
               ", hospedaje: " + hospedaje + 
               ", precio por noche: $" + precioPorNoche + 
               ", porcentaje de descuento: " + porcentajeDescuento + "%" +
               ", en promocion=" + enPromocion ;
    }

}
