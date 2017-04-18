/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Logica.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.swing.*;


/**
 *
 * @author Carlos
 */
/*
interfaz principal del prigrama, esta clase es la que permite la visualisacon del programa
*/
public class InterfazDiscotienda extends JFrame{
    /*
    todos las variables necesarion, llamando a las diferentes clases del programa
    */
    private Discotienda discotienda;
    private Disco discoSeleccionado;
    private PanelDiscos panelDiscos;
    private PanelDatosCanciones panelDatosCanciones;
    private PanelImagen panelImagen;
    
    
    public InterfazDiscotienda( Discotienda d ){
        discotienda = d;

        // Panel con la Imagen
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        // Panel central con los datos del disco, de las canciones y el botón para cargar un pedido
        JPanel panelCentral = new JPanel( new BorderLayout( ) );
        add( panelCentral, BorderLayout.CENTER );

        panelDiscos = new PanelDiscos( this, discotienda.darDiscos( ) );
        panelCentral.add( panelDiscos, BorderLayout.CENTER );

        panelDatosCanciones = new PanelDatosCanciones( this );
        panelCentral.add( panelDatosCanciones, BorderLayout.EAST );

        ArrayList discos = discotienda.darDiscos( );
        if( discos.size( ) > 0 ){
            cambiarDiscoSeleccionado( ( ( String )discos.get( 0 ) ) );
        }

        setTitle( "¡¡¡  Disco Tienda  !!!" );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
       pack();
    }
    
    /*
    metodo del combox para poder cambiar el disco y poder selecionarlo
    */
    public void cambiarDiscoSeleccionado( String nombreDisco ){
        discoSeleccionado = discotienda.darDisco( nombreDisco );
        panelDiscos.cambiarDisco( discoSeleccionado );
        panelDatosCanciones.cambiarDisco( discoSeleccionado );
    }
    /*
    metodo que hace ver la clase de la pantalla auxiliar para agregar o crear un disco nuevo
    */
    public void mostrarDialogoAgregarDisco( ){
        DCrearDisco dialogo = new DCrearDisco( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }
    /*
    metodo que hace ver la clase de la pantalla auxiliar para agregar o crear una cancion
    */
    public void mostrarDialogoAgregarCancion( ){
        DCrearCancion dialogo = new DCrearCancion( this );
        dialogo.setLocationRelativeTo( this );
        dialogo.setVisible( true );
    }
    /*
    metodo para crear el disco creado y mostrado en el a interfaz del programa
    */
    public boolean crearDisco( String nombreDisco, String artista, String genero, String imagen ){
        boolean ok = false;
        try{
            discotienda.agregarDisco( nombreDisco, artista, genero, imagen );
            panelDiscos.refrescarDiscos( discotienda.darDiscos( ) );
            ok = true;
        }catch( ElementoExiste e ){
            JOptionPane.showMessageDialog( this, e.getMessage( ) );
        }
        return ok;
    }
    /*
    Crea una nueva canción en el disco que se muestra en los detalles de disco en la discotienda
    */
    public boolean crearCancion( String nombre, int minutos, int segundos, double precio, double tamano, int calidad ){
        boolean ok = false;
        if( discoSeleccionado != null ){
            try{
                discotienda.agregarCancionADisco( discoSeleccionado.darNombreDisco( ), nombre, minutos, segundos, precio, tamano, calidad );
                discoSeleccionado = discotienda.darDisco( discoSeleccionado.darNombreDisco( ) );
                panelDiscos.cambiarDisco( discoSeleccionado );
                ok = true;
            }catch( ElementoExiste e ){
                JOptionPane.showMessageDialog( this, e.getMessage( ) );
            }
        }
        return ok;
    }
    
    
}
    

     
     

    
    
