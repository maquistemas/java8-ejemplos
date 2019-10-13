package pe.com.maquistemas.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountedCompleter;
import java.util.stream.Collectors;

import pe.com.maquistemas.app.modelo.Invoice;
import pe.com.maquistemas.app.modelo.InvoiceDao;
import pe.com.maquistemas.app.modelo.InvoiceItem;

public class Grupos {
	
	public static void main(String[] args) {
		
		List<Invoice> invoices = InvoiceDao.getFacturas();
		
		Map<String,Integer> cantidadPorProducto =	invoices.stream().flatMap(invoice->invoice.getItems().stream())
		.collect(Collectors.groupingBy(InvoiceItem::getProduct, Collectors.summingInt(InvoiceItem::getQuantity)));
		
		cantidadPorProducto.forEach((k,v)->{
			System.out.println(k + " "+v);
		});
		
		
		
		List<Integer> numeros = new ArrayList<Integer>(Arrays.asList(1,2,3));
		System.out.println(numeros.stream().count());
		
		
	}

}
