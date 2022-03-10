package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CrearArrayList {
		
	/**
	 * Método encargador de leer un archivo y agregar su contenido a un ArrayList
	 * @param ruta: Ubicación del archivo a leer
	 * @return lista: ArrayList con el contenido del archivo
	 */
	public ArrayList<String> ArrayList(String ruta){
		ArrayList<String> lista = new ArrayList<>();
		try {
			Scanner csvData = new Scanner (new File (ruta));
			while(csvData.hasNext()) {
				lista.add(csvData.nextLine());
			}
		}catch(FileNotFoundException ex){
			System.out.println(ex.toString());
		}
		return lista;
	}
					
	
	/** Método encargado de eliminar todos los carácteres que no son necesarios en el archivo
	 * 
	 * @param list: ArrayList con el contenido del archivo
	 * @return lista: Nuevo ArrayList ya sin los carácteres innecesarios
	 */
	public ArrayList<String>cambiaArrayList(ArrayList<String>list){		
		ArrayList<String> lista = new ArrayList<>();
				
		String numeros;
		String caracteres;
		String palabras;
				
		for(String txt : list) {
			numeros = txt.replaceAll("\\d", "");
			caracteres = numeros.replaceAll("\\W", " ");
			palabras = caracteres.toLowerCase();
			lista.add(palabras);
		}
		return lista;
	}
}
