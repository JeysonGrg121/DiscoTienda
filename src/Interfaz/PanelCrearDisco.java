/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Carlos
 */

/*
panel de crear la cacnion donde se guardan los datos del disco
*/
public class PanelCrearDisco extends JPanel implements ActionListener{
    /*
    variables necesarias para la clase y datos de la cacion
    */
    private static final String Buscar_Imagen = "Buscar";
    private JLabel etiquetaTitulo;
    private JTextField txtTitulo;
    private JLabel etiquetaArtista;
    private JTextField txtArtista;
    private JLabel etiquetaGenero;
    private JTextField txtGenero;
    private JLabel etiquetaImagen;
    private JTextField txtImagen;
    private JButton btnExplorar;
    
    public PanelCrearDisco( ){
        setLayout( new GridLayout( 5, 2, 5, 5 ) );

        etiquetaTitulo = new JLabel( "Título: " );
        etiquetaTitulo.setFont( etiquetaTitulo.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaTitulo );

        txtTitulo = new JTextField( 2 );
        add( txtTitulo );

        etiquetaArtista = new JLabel( "Artista: " );
        etiquetaArtista.setFont( etiquetaArtista.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaArtista );

        txtArtista = new JTextField( 2 );
        add( txtArtista );

        etiquetaGenero = new JLabel( "Género: " );
        etiquetaGenero.setFont( etiquetaGenero.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaGenero );

        txtGenero = new JTextField( 2 );
        add( txtGenero );

        etiquetaImagen = new JLabel( "Imagen: " );
        etiquetaImagen.setFont( etiquetaImagen.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaImagen );

        txtImagen = new JTextField( 2 );
        add( txtImagen );

        add( new JLabel( ) );

        btnExplorar = new JButton( "Buscar" );
        btnExplorar.setActionCommand( Buscar_Imagen );
        btnExplorar.addActionListener( this );
        add( btnExplorar );

        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }
    /*
    getter an setter de las variables para poderlas retonarlas en otra clase
    */
     public String darTitulo( ){
        return txtTitulo.getText( );
    }
     
    public String darArtista( ){
        return txtArtista.getText( );
    }
    
    public String darGenero( ){
        return txtGenero.getText( );
    }

    public String darImagen( ){
        return txtImagen.getText( );
    }
    /*
    activacion del boton de buscar la imagne con su respectiva restriccion
    la carpeta donde busca la imagen
    y la pantalla para buscar la imagen visualizada en el programa
    */
    public void actionPerformed( ActionEvent evento ){
        String comando = evento.getActionCommand( );

        if( Buscar_Imagen.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "imagenes" );
            fc.setDialogTitle( "Imagen del Disco" );
            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                File archivo = fc.getSelectedFile( );
                String strArchivo = archivo.getAbsolutePath( );
                String strCarpetaImagenes = new File( "imagenes" ).getAbsolutePath( );

                if( strArchivo.startsWith( strCarpetaImagenes ) )
                {
                    txtImagen.setText( "imagenes/" + archivo.getName( ) );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La imagen debe estar en la carpeta " + strCarpetaImagenes );
                }
            }
        }
    }

    
}
