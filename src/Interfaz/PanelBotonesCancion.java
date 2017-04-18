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
 *
 * @author Carlos
 */

/*
La clase hace la activacion de los botones para crear o cancelar el llenado de los datos de la cancion
*/
public class PanelBotonesCancion extends JPanel implements ActionListener {

    private static final String CREAR_CANCION = "CrearCancion";// string del nombre del boton
    private static final String CANCELAR = "Cancelar";// string del nombre del boton
    private DCrearCancion ventana; // variable para visulizar dond ellenar la informacion
    private JButton botonAgregarCancion;
    private JButton botonCancelar;
     
    /*
    contructor del panel de botones
    dcc es una referencia al diálogo que contiene a este panel
    */
    public PanelBotonesCancion( DCrearCancion dcc ){

        ventana = dcc;

        botonAgregarCancion = new JButton( "Crear" );
        botonAgregarCancion.setActionCommand( CREAR_CANCION );
        botonAgregarCancion.addActionListener( this );
        add( botonAgregarCancion );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );

    }

    /*
    Activacion de los botones segun el usuario
    */
    public void actionPerformed( ActionEvent evento ){
        String comando = evento.getActionCommand( );

        if( CREAR_CANCION.equals( comando ) )
        {
            ventana.crearCancion( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            ventana.dispose( );
        }

    }

}

