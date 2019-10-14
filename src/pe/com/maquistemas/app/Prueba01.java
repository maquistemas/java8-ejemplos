package pe.com.maquistemas.app;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import pe.com.maquistemas.app.modelo.Empleado;

public class Prueba01 {
	
	
	
	
	public static void main(String[] args) {
		Double promedioEdad = Empleado.getEmpleados().stream().mapToInt(e->e.getEdad()).average().getAsDouble();
		Integer masViejo = Empleado.getEmpleados().stream().mapToInt(e->e.getEdad()).max().getAsInt();
		IntSummaryStatistics suma = Empleado.getEmpleados().stream().mapToInt(e->e.getEdad()).summaryStatistics();
		String union = Empleado.getEmpleados().stream().map(e->e.getNombre()).collect(Collectors.joining(", "));
		
		System.out.println(union);
	}

}
