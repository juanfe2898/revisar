/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchmethods;
 import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author juanf
 */
public class Boton extends JButton implements ActionListener {
    boolean act=false;
    //constructor//
    public Boton( int pos_x, int pos_y, int ancho, int alto ){ 
        //Se coloca el Boton en un lugar y se le da un tamanio
        setBounds(pos_x, pos_y, ancho, alto);
        
        //Se agrega el action listener en este caso la misma clase
        addActionListener( this );
    }
    //nombre del boton//
    public void setNombre( int f, int c ){
        setText( f + " , " + c );
    }
   //metodo al darle clic///
    public void actionPerformed( ActionEvent e ){
        //Se asigna el color de fondo azul
        setBackground(Color.RED);
        //Se asigna un color de letra color blanco
        setForeground(Color.WHITE);
        act=true;
    }
    public void colorOrigen(){
        setBackground(Color.BLUE);
        
    }
    public void colorDestino(){
        setBackground(Color.GREEN);
        
    }
   public boolean activado (){
       return act;
   }
}

