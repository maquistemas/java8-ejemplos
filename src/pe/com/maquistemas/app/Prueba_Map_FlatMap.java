package pe.com.maquistemas.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prueba_Map_FlatMap {
	
	/*
	 * MAP
	 * La diferencia es que map() devuelve el mismo número de elementos que el Stream de entrada 
	 * ya que es simplemente una proyección de los elementos de entrada. 
	 * Es decir cada elemento de entrada se transforma en un elemento de salida.
		
		FLATMAP
		Por otro lado .flatMap(), proyecta una lista de elementos de cada elemento original y los concatena en un único stream.
	 */
	
	public static void main(String[] args) {
		
		List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		List<List<Integer>> numerosBi = new ArrayList<List<Integer>>(Arrays.asList(
																					new ArrayList<Integer>(Arrays.asList(1,2)), 
																					new ArrayList<Integer>(Arrays.asList(3,4))));
		
		System.out.println("***************MAP***************");
		numeros.stream().map(x->x*2).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("*************************************");
		System.out.println("***************FLATMAP***************");
		numerosBi.stream().flatMap(x->x.stream()).map(x->x*2).collect(Collectors.toList()).forEach(System.out::println);
	}

}
