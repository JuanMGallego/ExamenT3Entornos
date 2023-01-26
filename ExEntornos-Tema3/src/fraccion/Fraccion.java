package fraccion;

/**
 * 
 * Clase que define una fracci�n
 * 
 * @author jmgallego
 *
 */
public class Fraccion {
	/**
	 * Variable global Numerador
	 */
	private int num;

	/**
	 * Variable global Denominador
	 */
	private int den;

	/**
	 * Constructor por defecto
	 */
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	/**
	 * Constructor con par�metros
	 * 
	 * @param num Numerador de entrada
	 * @param den Denominador de entrada
	 */
	public Fraccion(int num, int den) {
		/**
		 * debo evitar crear fracciones con 0 en el divisor
		 */
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		/**
		 * devuelvo la fracci�n simplificada
		 */
		simplificar();
	}

	/**
	 * 
	 * Constructor copia
	 * 
	 * @param f par�metro de entrada de fracci�n
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	/**
	 * 
	 * getters y setters
	 * 
	 * @param num Par�metro de entrada de un n�mero
	 */

	public void setNum(int num) {
		this.num = num;

	}

	public int getNum() {
		return num;

	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getDen() {
		return den;
	}

	/**
	 * 
	 * C�lculo del m�ximo com�n divisor por el algoritmo de Euclides
	 * 
	 * @return u Devuelve el m�ximo com�n divisor
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	/**
	 * M�todo para simplificar fracciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	/**
	 * M�todo toString
	 */

	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	/**
	 * 
	 * Suma de fracciones
	 * 
	 * @param f Par�metro de entrada de las fracciones
	 * @return aux Devuelve el valor calculado en la suma despu�s de simplificarlo
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * 
	 * Restar fracciones
	 * 
	 * @param f Par�metro de entrada de las funciones
	 * @return aux Devuelve el valor calculado en la resta despu�s de simplificarlo
	 */

	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * 
	 * Multiplicar fracciones
	 * 
	 * @param f Par�metro de entrada de las funciones
	 * @return aux Devuelve el valor calculado en la multiplicaci�n despu�s de multiplicarlo.
	 */

	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * 
	 * Dividir fracciones
	 * 
	 * @param f Par�metro de entrada de las funciones
	 * @return aux Devuelve el valor calculado en la divisi�n despu�s de multiplicarlo.
	 */

	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
