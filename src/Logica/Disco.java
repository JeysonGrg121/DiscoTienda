/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import java.io.*;
import java.util.*;

/*
Clase del paquete logica de la lista disco
*/
public class Disco{
    /*
    variables necesrias de la clase incluyendo la lista
    */
    private ArrayList canciones;
    private String nombreDisco;
    private String artista;
    private String genero;
    private String imagen;
    private double precioTotal;
   /*
    contructor inicual donde se guardan los datos de las variables en la lista
    */ 

    public Disco( String nombreDiscoD, String artistaD, String generoD, String imagenD ){
        canciones = new ArrayList( );
        nombreDisco = nombreDiscoD;
        artista = artistaD;
        genero = generoD;
        imagen = imagenD;
        precioTotal = 0;

        verificar();
    }
/*
    metodo que llama a la clase cancion para dar la lista de las canciones del disco
    */
    public Cancion darCancion( String nombreC ){
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            if( c.equals( nombreC ) )
                return c;
        }
        return null;
    }
    /*
    metodo que verifica si al crear una cacione en el mismo disco con el mismo nombre manda mensaje
    */
    public void agregarCancion( Cancion c ) throws ElementoExiste{
        if( darCancion( c.darNombre( ) ) != null )
            throw new ElementoExiste( "La canción " + c.darNombre( ) + " ya existe en el disco" );

        canciones.add( c );
        precioTotal += c.darPrecio( );

        verificar();
    }
    /*
    getter and setter de las variables para retornarlas
    */
    public String darArtista(){
        return artista;
    }
/*
    muestra la lista de las canciones
    */
    public ArrayList darNombresCanciones(){
        ArrayList nombresCanciones = new ArrayList( );
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            nombresCanciones.add( c.darNombre( ) );
        }
        return nombresCanciones;
    }

    public String darGenero(){
        return genero;
    }

    public String darNombreDisco(){
        return nombreDisco;
    }

    public String darImagen(){
        return imagen;
    }

    public double darPrecioDisco(){
        return precioTotal;
    }

    public boolean equals( String nombre ){
        return nombreDisco.equalsIgnoreCase( nombre );
    }

    /*
    metodo que verifica si los datos de son correctso y si la lista de las canciones esta en null
    */
    private void verificar(){
        assert canciones != null : "La lista de canciones es nula";
        assert nombreDisco != null && !nombreDisco.equals( "" ) : "El nombre del disco es inválido";
        assert artista != null && !artista.equals( "" ) : "El nombre del artista es inválido";
        assert genero != null && !genero.equals( "" ) : "El nombre del género es inválido";
        assert imagen != null && !imagen.equals( "" ) : "El nombre del archivo con la imagen es inválido";

        assert !buscarCancionesConElMismoNombre( ) : "Hay dos canciones con el mismo nombre";
        assert precioTotal == recalcularPrecioDisco( ) : "Hay un error en el cálculo del precio total del disco";
    }
/*
    Metodo qeu calcula em precio del dsico de acuerdo con el precio de las canciones
    */
    private double recalcularPrecioDisco(){
        double acumPrecioTotal = 0;
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            acumPrecioTotal = acumPrecioTotal + c.darPrecio( );
        }
        return acumPrecioTotal;
    }
/*
    metodo que busca en la lista si hay caniones con el mismo nombre
    */
    private boolean buscarCancionesConElMismoNombre(){
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c1 = ( Cancion )canciones.get( i );
            for( int j = i + 1; j < canciones.size( ); j++ )
            {
                Cancion c2 = ( Cancion )canciones.get( j );
                if( c1.equals( c2.darNombre( ) ) )
                    return true;
            }
        }
        return false;
    }
}