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
clase de la pantalla para ingresare los datos del disco
*/
public class DCrearDisco extends JDialog {
    
    private InterfazDiscotienda principal;// llama a la clase intefaz para añadirlo
    private PanelCrearDisco panelDatos;// llama a los datos del disco para que se puedan guardar
    private PanelBotonesDisco panelBotones;// llama la activacion de los botones
    
    /*
    contructor de la clase para hacer visible la patalla auxiliar
    id = refernecia de la calse interfaz 
    */
    public DCrearDisco( InterfazDiscotienda id ){
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearDisco( );
        panelBotones = new PanelBotonesDisco( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Disco" );
        pack();
    }
    
    /*
    metodo  de la creacion del disco
    ademas hace el la respectiva exepcion por si alguno de los campos esta vacio
    */   
    
    public void crearDisco( ){
        boolean parameter = true;
        String artista = panelDatos.darArtista( );
        String titulo = panelDatos.darTitulo( );
        String genero = panelDatos.darGenero( );
        String imagen = panelDatos.darImagen( );

        if( ( artista.equals( "" ) || titulo.equals( "" ) ) || ( genero.equals( "" ) || imagen.equals( "" ) ) )        {
            parameter = false;
            JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
        }
        if( parameter){
            boolean ok = principal.crearDisco( titulo, artista, genero, imagen );
            if( ok )
                dispose( );
        }
    }


}
