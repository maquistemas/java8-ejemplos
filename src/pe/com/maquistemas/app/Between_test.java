package pe.com.maquistemas.app;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import pe.com.maquistemas.app.modelo.Person;
import pe.com.maquistemas.app.modelo.Person.Gender;

public class Between_test {
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		
		Person p1 = new Person("John", "Diaz", LocalDate.parse("1979-05-29"), Gender.MALE);
		Person p2 = new Person("Jorge", "Lopez", LocalDate.parse("1980-05-29"), Gender.MALE);
		Person p3 = new Person("Sara", "Torres", LocalDate.parse("2010-05-29"), Gender.FEMALE);
		
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		
		//Obtener las personas mayores de 18 años
		persons.stream().filter(p->Period.between(p.getBirthDay(), LocalDate.now()).getYears() > 18 )
		.forEach(x->System.out.println(x));
		
		
	}
	

}
