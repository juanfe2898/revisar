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
public class MainBoton extends JButton implements ActionListener {

    ////////// Constructor /////////
    public MainBoton( String nombre ){
        setText(nombre);
        addActionListener( this );
        setBackground(Color.BLUE);
    }
    ///////////// Se asigna una el nombre del Boton ///////
    public void setNombre( String nombre ){
        setText( nombre);
    }    
    /////Al darle click realizara este metodo/////
    public void actionPerformed( ActionEvent e ){
        setBackground(Color.RED);
        setForeground(Color.BLUE);
        System.out.println("funciono");
    }
  
}

