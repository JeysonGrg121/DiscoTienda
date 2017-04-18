/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */

/*
La pantalla o Dialogo para cerar la respectiva cancion del disco
*/
public class DCrearCancion extends JDialog{
    private InterfazDiscotienda principal; /// llama la clase interfaz para añadir esta clase a la calse interfaz
    private PanelCrearCancion panelDatos; // Panel para crear la nueva cancion, donde seran guardados los datos
    private PanelBotonesCancion panelBotones; // Pannel de los botones para guardar correctamente
     
    
    /*
    Contructor del codiggo
    el paramentro id = es una referencia a la calse interfaz 
    */
    public DCrearCancion( InterfazDiscotienda id ){
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearCancion( ); // hace el llamado del panel datos de la cancion
        panelBotones = new PanelBotonesCancion( this ); // la cativacion de los botones del panel datos

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );// ubicacion de la pantalla
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Canción" );// nombre de la pantalla auxiliar.
        pack();
    }
     /*
    metodo para crera la cacion
    */
    public void crearCancion(){
        boolean parameter = true; // restirccion para que los campos esten llenos
        /*
        Las variables estan inicializadas en ceros.
        */
        double precio = 0; 
        int calidad = 0;
        double tamano = 0;
        int minutos = 0;
        int segundos = 0;
        String nombre = panelDatos.darNombre( );// metodo de la clase panel datos para que retorne el nombre
        
        /*
        Restricciones de cada campo, para que sea llenado corectamente
        ademas, de que los datos ingresado sean correctos.
        */
        if( nombre.equals( "" ) ){
            parameter = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el nombre de la canción " );
        }try{
            precio = Double.parseDouble( panelDatos.darPrecio( ) );
            if( precio < 0 )
            {
                parameter = false;
                JOptionPane.showMessageDialog( this, "El precio ingresado no es un valor válido" );
            }
        }catch( Exception e ){
            parameter = false;
            JOptionPane.showMessageDialog( this, "El precio ingresado no es un valor válido" );
        }try{
            calidad = Integer.parseInt( panelDatos.darCalidad( ) );
            if( calidad < 0 )
            {
                parameter = false;
                JOptionPane.showMessageDialog( this, "La calidad ingresada no es un valor válido" );
            }
        }catch( Exception e ){
            parameter = false;
            JOptionPane.showMessageDialog( this, "La calidad ingresada no es un valor válido" );
        }try{
            tamano = Double.parseDouble( panelDatos.darTamano( ) );
            if( tamano < 0 )
            {
                parameter = false;
                JOptionPane.showMessageDialog( this, "El tamaño ingresado no es un valor válido" );
            }
        }catch( Exception e ){
            parameter = false;
            JOptionPane.showMessageDialog( this, "El tamaño ingresado no es un valor válido" );
        }try{
            minutos = Integer.parseInt( panelDatos.darMinutos( ) );
            if( minutos < 0 )
            {
                parameter = false;
                JOptionPane.showMessageDialog( this, "Los minutos ingresados no son un valor válido" );
            }
        }catch( Exception e ){
            parameter = false;
            JOptionPane.showMessageDialog( this, "Los minutos ingresados nos son un valor válido" );
        }try{
            segundos = Integer.parseInt( panelDatos.darSegundos( ) );
            if( segundos < 0 || segundos >= 60 )
            {
                parameter = false;
                JOptionPane.showMessageDialog( this, "Los segundos ingresados no son un valor válido" );
            }
        }catch( Exception e ){
            parameter = false;
            JOptionPane.showMessageDialog( this, "Los segundos ingresados nos son un valor válido" );
        }if( parameter ){
            boolean ok = principal.crearCancion( nombre, minutos, segundos, precio, tamano, calidad );
            if( ok )
                dispose( );
        }
    }
}
