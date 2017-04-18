/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
/**
 *
 * @author Carlos
 */
/*
clase del paquete logica que guerda la lista de las canciones
*/


public class Cancion {
/*
    variables donde se guardan los datos en la lista de las canciones
    */
    private String nombre;
    private int minutos;
    private int segundos;
    private double tamano;
    private int calidad;
    private double precio;
    private int unidadesVendidas;

/*
    contructor inicial de la clase
    */   
    public Cancion( String nombreC, int minutosC, int segundosC, double precioC, double tamanoC, int calidadC, int cantidad ){
        nombre = nombreC;
        minutos = minutosC;
        segundos = segundosC;
        precio = precioC;
        tamano = tamanoC;
        calidad = calidadC;
        unidadesVendidas = cantidad;

        verificar();
    }

   //getter and setter de la clase para retornarlas en el paquete interfaz
    public String darNombre(){
        return nombre;
    }

    public int darMinutos(){
        return minutos;
    }

    public int darSegundos(){
        return segundos;
    }

    
    public double darPrecio(){
        return precio;
    }

    public double darTamano(){
        return tamano;
    }

   
    public int darCalidad(){
        return calidad;
    }

    public int darUnidadesVendidas(){
        return unidadesVendidas;
    }

    public void vender(){
        unidadesVendidas++;
    }

    public boolean equals(String nombreCancion){
        return nombre.equalsIgnoreCase( nombreCancion );
    }
    
/*
    metodo que verifica loas dotos si son correctos o no
    */
    private void verificar(){
        assert nombre != null && !nombre.equals( "" ) : "El nombre es inválido";
        assert minutos >= 0 : "Los minutos deben ser un valor positivo";
        assert 0 <= segundos && segundos < 60 : "Los segundos deben ser un valor entre 0 y 60";
        assert minutos + segundos > 0 : "La canción debe tener una duración positiva";
        assert tamano > 0 : "El tamaño debe ser un valor positivo";
        assert calidad > 0 : "La calidad debe ser un valor positivo";
        assert precio > 0 : "El precio debe ser un valor positivo";
        assert unidadesVendidas >= 0 : "El número de unidades vendidas debe ser un entero positivo";
    }
}
