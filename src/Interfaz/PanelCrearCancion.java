/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Carlos
 */
/*
Panel de crear la cacniom, aqui es donde se guardan las variables o string o datos de la cada cancion
*/
public class PanelCrearCancion extends JPanel {
    /*
    variables necesarias para la creacion del la cacion
    */
    private JLabel etiquetaNombre;
    private JTextField txtNombre;
    private JLabel etiquetaPrecio;
    private JTextField txtPrecio;
    private JLabel etiquetaMinutos;
    private JTextField txtMinutos;
    private JLabel etiquetaSegundos;
    private JTextField txtSegundos;
    private JLabel etiquetaCalidad;
    private JTextField txtCalidad;
    private JLabel etiquetaTamano;
    private JTextField txtTamano;
    
    /*
    contructor principal del la clase, donde se hace el llenado correspondiente en cada variable
    */
    public PanelCrearCancion( ){
        setLayout( new GridLayout( 6, 2, 5, 5 ) );

        etiquetaNombre = new JLabel( "Nombre: " );
        etiquetaNombre.setFont( etiquetaNombre.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaNombre );

        txtNombre = new JTextField( 2 );
        add( txtNombre );

        etiquetaPrecio = new JLabel( "Precio ($): " );
        etiquetaPrecio.setFont( etiquetaPrecio.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaPrecio );

        txtPrecio = new JTextField( 2 );
        add( txtPrecio );

        etiquetaCalidad = new JLabel( "Calidad (kbps): " );
        etiquetaCalidad.setFont( etiquetaCalidad.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaCalidad );

        txtCalidad = new JTextField( 2 );
        add( txtCalidad );

        etiquetaTamano = new JLabel( "Tamaño (mb): " );
        etiquetaTamano.setFont( etiquetaTamano.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaTamano );

        txtTamano = new JTextField( 2 );
        add( txtTamano );

        etiquetaMinutos = new JLabel( "Minutos: " );
        etiquetaMinutos.setFont( etiquetaMinutos.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaMinutos );

        txtMinutos = new JTextField( 2 );
        add( txtMinutos );

        etiquetaSegundos = new JLabel( "Segundos: " );
        etiquetaSegundos.setFont( etiquetaSegundos.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaSegundos );

        txtSegundos = new JTextField( 2 );
        add( txtSegundos );

        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }
    
    /*
    getter an setter corespondientes de las variables para retornarlas y poderlas llamar en otras clases
    */
    public String darNombre(){
        return txtNombre.getText( );
    }
    
    public String darPrecio(){
        return txtPrecio.getText( );
    }
    
    public String darCalidad(){
        return txtCalidad.getText( );
    }
    
    public String darTamano(){
        return txtTamano.getText( );
    }
    
    public String darMinutos(){
        return txtMinutos.getText( );
    }
    
    public String darSegundos(){
        return txtSegundos.getText( );
    }
    
}
