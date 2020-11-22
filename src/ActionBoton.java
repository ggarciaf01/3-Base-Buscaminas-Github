import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * De alguna manera tendrá que poder acceder a la ventana principal.
 * Se puede lograr pasando en el constructor la referencia a la ventana.
 * Recuerda que desde la ventana, se puede acceder a la variable de tipo ControlJuego
 * @author Guillermo García Fernández
 * 
 */
public class ActionBoton implements ActionListener{


	private VentanaPrincipal ventana;

	/**
	 * Posición en la coordenada x del tablero
	 */
	private int x;
	/**
	 * Posición en la coordenada y del tablero
	 */
	private int y;

	public ActionBoton(int i, int j, VentanaPrincipal ventana) {
		//Hacemos referencia a la ventana por parámetro, y le pasamos las coordenadas del botón
		this.ventana = ventana;
		this.x = i;
		this.y = j;
	}
	
	/**
	 *Acción que ocurrirá cuando pulsamos uno de los botones.
	 *<p>
	 *Cuando la casilla que abrimos es una mina, se acabará el juego. En caso contrario, 
	 *llamará al método mostrarNumMinasAlrededor(), que cambiará el botón por un JLabel
	 *con el número de minas que se encuentras alrededor de esa casilla. Si ya has abierto
	 *todas las casillas que no son minas, saldrá un mensaje de fin de juego.
	 *</p>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (ventana.getJuego().abrirCasilla(x, y) == true){
			ventana.mostrarNumMinasAlrededor(x, y);
			if (ventana.getJuego().esFinJuego()){
				ventana.mostrarFinJuego(false);
			}
		}else{
			ventana.mostrarFinJuego(true);
		}	
	}

}
