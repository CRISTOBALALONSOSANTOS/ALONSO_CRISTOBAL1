package calculadora;

/** Reverse Polish notation (RPN) Notación Polaca inversa
*/

public class RPN {
	public void empujaPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, up);
		up = nuevo_nodo;
	}
	
	/** Método pPila, 
	 * 
	 * @return Devuelve la variable dato_arriba (double)
	 */
	
	
	public double pPila( ) {
		double dato_arriba = up.dato;
		up = up.abajo;
		return dato_arriba;
	}
	
	/**
	 * Constructor de la clase RPN
	 * 
	 * @param commando
	 *            campo de la clase de tipo String
	 	 */
	public RPN(String commando) {
		up = null;
		this.command = commando;
	}
	
	/** Método resul, calula el resultado de la operación
	 * 
	 * @return Devuelve el resultado en la variable val (double)
	 */

		
	public double resul( ) {
		double a, b;
		int j;
		for(int i = 0; i < command.length( ); i++) {
			// si es un digito
			if(Character.isDigit(command.charAt(i))) {
				double numero;
				// obtener un string a partir del numero
				String temp = "";
				for(j = 0; (j < 100) && (Character.isDigit(
						command.charAt(i)) || (command.charAt(i) == '.')); j++, i++) {
					temp = temp + String.valueOf(command.
							charAt(i));
				}
				// convertir a double y añadir a la pila
				numero = Double.parseDouble(temp);
				empujaPila(numero);
			} else if(command.charAt(i) == '+') {
				b = pPila( );
				a = pPila( );
				empujaPila(a + b);
			} else if(command.charAt(i) == '-') {
				b = pPila( );
				a = pPila( );
				empujaPila(a - b);
			} else if(command.charAt(i) == '*') {
				b = pPila( );
				a = pPila( );
				empujaPila(a * b);
			} else if(command.charAt(i) == '/') {
				b = pPila( );
				a = pPila( );
				empujaPila(a / b);
			}
			else if(command.charAt(i) == '^') {
				b = pPila( );
				a = pPila( );
				empujaPila(Math.pow(a, b));}
			else if(command.charAt(i) == '%') {
				b = pPila( );
				a = pPila( );
				empujaPila(a%b);
			} else if(command.charAt(i) != ' ') {
				throw new IllegalArgumentException( );
			}
		}
		double val = pPila( );
		if(up != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}
	private String command;
	private NodoPila up;
}