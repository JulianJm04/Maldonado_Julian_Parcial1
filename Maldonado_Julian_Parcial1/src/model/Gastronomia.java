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
public class Gastronomia extends Servicio{
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio, String gastronomia, double precio, int diaSemDesc, double porcentajeDescuento, boolean enPromocion) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }
    
    //Calcula el precio final del servicio para la fecha dada.
    // TOma la fecha para la cual se calcula el precio.
    // Retorna el precio final del servicio.
    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precio;
        if (isEnPromocion() && dia.getDayOfWeek().getValue() == diaSemDesc) {
            precioFinal -= precioFinal * (getPorcentajeDescuento() / 100);
        }
        return precioFinal;
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }
    
    //Se mejoro el metodo toString para proporcionar una representación mas
    //clara de los objetos al imprimirlos.
    @Override
    public String toString() {
        System.out.println("- Gastronomia:");
        return "Codigo servicio: " + getCodServicio() + 
               ", gastronomia: " + gastronomia + 
               ", precio: " + precio + 
               ", descuento de dia de la semana: " + diaSemDesc + 
               ", porcentaje de descuento: " + porcentajeDescuento + "%" +
               ", en promocion: " + enPromocion ;
        
    }

}
