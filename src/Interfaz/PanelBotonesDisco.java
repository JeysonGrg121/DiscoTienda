/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Es el panel con los botones para agregar un nuevo disco
 * 
 */
public class PanelBotonesDisco extends JPanel implements ActionListener{
    private static final String CREAR_DISCO = "CrearDisco"; // nombre del boton
    private static final String CANCELAR = "Cancelar";// nombre del boton
    private DCrearDisco ventana;// llama a la clase del disco
    private JButton botonAgregarDisco;
    private JButton botonCancelar;
/*
    contructor del programa
    dcd  hace refenecia a la clase del panel de crear disco
    */
    public PanelBotonesDisco( DCrearDisco dcd ){

        ventana = dcd;

        botonAgregarDisco = new JButton( "Crear" );
        botonAgregarDisco.setActionCommand( CREAR_DISCO );
        botonAgregarDisco.addActionListener( this );
        add( botonAgregarDisco );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );

    }
/*
    activacion de los botones segun el usuario
    */
    public void actionPerformed( ActionEvent evento ){
        String comando = evento.getActionCommand( );

        if( CREAR_DISCO.equals( comando ) ) {
            ventana.crearDisco( );
        }else if( CANCELAR.equals( comando ) ){
            ventana.dispose( );
        }

    }
}
