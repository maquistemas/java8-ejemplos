package pe.com.maquistemas.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	
	private int id;
	private String nombre;
	private int edad;
	private BigDecimal sueldo;
	public Empleado() {
	}
	public Empleado(int id, String nombre, int edad, BigDecimal sueldo) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public BigDecimal getSueldo() {
		return sueldo;
	}
	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}
	
	
	public static List<Empleado> getEmpleados(){
		List<Empleado> lista = new ArrayList<>();
		
		lista.add(new Empleado(1, "John", 10, new BigDecimal(1000)));
		lista.add(new Empleado(2, "Jorge", 20, new BigDecimal(2000)));
		lista.add(new Empleado(3, "Raul", 30, new BigDecimal(1033)));
		lista.add(new Empleado(4, "Saul", 40, new BigDecimal(10470)));
		return lista;
	}
	

}
