/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchmethods;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
/**
 *
 * @author juanf
 */
public class Main extends JFrame implements ActionListener {
private final List<Integer> path = new ArrayList<Integer>();//tania sabe que hace 

	public Main() {
            ///creamos botones paneles y esas cosas
            JToolBar barraHerramientas = new JToolBar();//creamos la barra para que el usuario escoja el tamaño
            JToolBar metodosBusqueda = new JToolBar(); // elegir el metodo de busqueda
            JLabel lblFilas = new JLabel("Filas");
            JLabel lblColumnas = new JLabel("Columnas");
            JLabel orix = new JLabel("seleccione el origen: x=");
            JLabel oriy = new JLabel("y=");
            JLabel destx = new JLabel("seleccione el destino: x=");
            JLabel desty = new JLabel("y=");
            txtColumnas = new JTextField("5");
            txtFilas = new JTextField("5");
            origenx = new JTextField("0");
            origeny = new JTextField("0");
            destinox = new JTextField("1");
            destinoy = new JTextField("1");
            btnCrear = new MainBoton("Crear");
            orides = new MainBoton("Generar");
            panel= new JScrollPane(null);
       
            
            //Para que el JFrame cierre la aplicacion
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ///barra de herramientas crear matriz
            barraHerramientas.add(lblFilas);
            txtFilas.setPreferredSize(new Dimension(25, 25));
            barraHerramientas.add(txtFilas);
            barraHerramientas.add(lblColumnas);
            txtColumnas.setPreferredSize(new Dimension(25, 25));
            barraHerramientas.add(txtColumnas);
            btnCrear.addActionListener(this);
            barraHerramientas.add(btnCrear);
            
            //origen y destino
            barraHerramientas.add(orix);
            origenx.setPreferredSize(new Dimension(25, 25));
            barraHerramientas.add(origenx);
            barraHerramientas.add(oriy);
            origeny.setPreferredSize(new Dimension(25, 25));
            barraHerramientas.add(origeny);
            //destino
            barraHerramientas.add(destx);
            destinox.setPreferredSize(new Dimension(25, 25));
            barraHerramientas.add(destinox);
            barraHerramientas.add(desty);
            destinoy.setPreferredSize(new Dimension(25, 25));
            barraHerramientas.add(destinoy);
          
            barraHerramientas.add(orides);
            
            ///los metodos
            barraHerramientas.add(dfs);
            barraHerramientas.add(breadthfs);
            barraHerramientas.add(hc);
            barraHerramientas.add(a);
            barraHerramientas.add(bestfs); 
            
            //Colocamos el JToolBar en la parte de arriba del JFrame
            this.add(barraHerramientas, BorderLayout.PAGE_START);
            //Se agrega el panel a boton
            this.add(panel, BorderLayout.CENTER);
            this.setSize(1100, 520);
            //Permite que la ventana se coloque al centro de la pantalla
            this.setLocationRelativeTo(null);
            
	}

	public void actionPerformed( ActionEvent evt ) {
            /*ox=orx=origen de x
            dx=desx=destino de x
            */
            //Se obtienen los datos
            String f = txtFilas.getText();
            String c = txtColumnas.getText();
            String orx = origenx.getText();
            String ory= origeny.getText();
            String desx = destinox.getText();
            String desy = destinoy.getText();
            //Se cambia de cadena de caracteres a numeros
            int filas = Integer.parseInt(f);
            int columnas = Integer.parseInt(c);
            int ox= Integer.parseInt(orx);
            int oy = Integer.parseInt(ory);
            int dx = Integer.parseInt(desx);
            int dy = Integer.parseInt(desy);
            //Eliminamos los anteriores botones
            panel.removeAll();
            //Se crea una matriz de botones y una matris a resolver segun las filas y columnas entrantes
            Boton [][] botones = new Boton[ filas ][ columnas ];
            int [][] maze = new int [filas] [columnas];
            //Se recorren las filas
            for( int fila = 0 ; fila < filas; fila++ ){
                //Estando en la fila se recorrer las columnas
                for( int columna = 0 ; columna < columnas; columna++ ){
                    //Se crea el boton y se agrega a las celda de la matriz
                    botones[fila][columna] = new Boton( 75 * columna, 30 * fila, 60, 30 );
                    maze[fila][columna] = 0;
                    //Se da el nombre en forma de coordenada enviando la fila y columna
                    botones[fila][columna].setNombre(fila, columna);
                    //Se agrega el boton al panel
                    panel.add( botones[fila][columna] );
                }
            }
            //acciones de los botones para ejecutarse
            /*llama al dfs*/
            orides.addActionListener (new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Boton a = null;
                    Boton b= null;
                    //se colorean los botones
                       for( int i = 0 ; i < filas; i++ ){
                            for( int j = 0 ; j < columnas; j++ ){
                                if(i==ox&&j==oy){
                                   a=botones[i][j];
                                }
                                if(i==dx&&j==dy){
                                    b=botones[i][j];
                                }
                            }
                        } 

                       //les pongo color al origen y al destino y los bloqueo
                       a.colorOrigen();
                       b.colorDestino();
                ;} }
            );
            dfs.addActionListener (new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("dfs wey");//aca va la funcion
                    maze[dx][dy]=9;//pongo el destino en la matriz
                    DepthFirstSearch.llenaUnos(maze, ox+1, oy+1, path,filas,columnas);//envio el origen con +1 ya que la matriz por el borde de 1 agrega 2 filas y 2 columnas
                    System.out.println(path);
                ;} }
            );
            breadthfs.addActionListener (new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Boton b=null;
                    for( int fila = 0 ; fila < filas; fila++ ){
                //Estando en la fila se recorrer las columnas
                for( int columna = 0 ; columna < columnas; columna++ ){
                    //Se crea el boton y se agrega a las celda de la matriz
                    b =botones[fila][columna];
                    if(b.)
                }
            }
                    System.out.println("resppira wey");//aca va la funcion 
                } 
            });
            hc.addActionListener (new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("hc wey");//aca va la funcion 
                } 
            });
            a.addActionListener (new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("a wey");//aca va la funcion 
                } 
            });
            bestfs.addActionListener (new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println("b wey");//aca va la funcion 
              } 
            });
            
            //Se actualiza el panel para que se vean los botones
                    panel.updateUI();
                    
	}                                        

	public static void main(String args[]) {
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
			ex.printStackTrace();
        }
		new Main().setVisible(true);
    }

	MainBoton btnCrear;
        MainBoton orides;
	JTextField txtColumnas;
        JTextField origenx;
        JTextField origeny;
        JTextField destinox;
        JTextField destinoy;
	JTextField txtFilas;
        JScrollPane panel;
        MainBoton dfs = new MainBoton("DepthFirstSearch");;
        MainBoton breadthfs = new MainBoton("BreadthFirstSearchFS");
        MainBoton hc = new MainBoton("Hill Climbing");
        MainBoton a = new MainBoton("A*");
        MainBoton bestfs = new MainBoton("Best First Search");
}