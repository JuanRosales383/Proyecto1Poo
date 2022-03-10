package application;

import java.util.ArrayList;

public class CuentaPalabras{
	
	/** Método que cuenta cuántas veces aparece una palabra en el ArrayList a analizar
	 * 
	 * @param list: ArrayList con los elementos a analizar
	 * @param palabra: Palabra que se debe buscar y contabilizar las veces que aparece
	 * @return coincidencias: Cantidad de veces que aparece una determinada palabra 
	 */
	public int cuentaPalabras(ArrayList<String>list, String palabra){
		ArrayList<Integer> lista = new ArrayList<>();
		int i=0;
		int coincidencias=0;
		
		for(String txt: list) {
			if(txt.contains(palabra)) {
				coincidencias++;
			}
		}
		return coincidencias; 
	}
}
