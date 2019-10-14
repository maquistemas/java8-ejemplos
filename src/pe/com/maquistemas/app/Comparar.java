package pe.com.maquistemas.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import pe.com.maquistemas.app.modelo.Invoice;
import pe.com.maquistemas.app.modelo.InvoiceDao;
import pe.com.maquistemas.app.modelo.InvoiceItem;

public class Comparar {
	
	public static void main(String[] args) {
		
		
		List<Invoice> invoices = InvoiceDao.getFacturas();
		
		BigDecimal menor = invoices.stream().flatMap(invoice->invoice.getItems().stream())
		.min(Comparator.comparing(InvoiceItem::getPricePerUnit)).get().getPricePerUnit();
		
		BigDecimal mayor = invoices.stream().flatMap(invoice->invoice.getItems().stream())
				.max(Comparator.comparing(InvoiceItem::getPricePerUnit)).get().getPricePerUnit();
		
		System.out.println(menor + " - "+mayor);
		System.out.println(menor.setScale(2, RoundingMode.HALF_EVEN) + " - "+mayor.setScale(2, RoundingMode.HALF_UP));
		
		
		//Obtener la mayor factura
		Invoice factura = 
			invoices.stream()
			.collect(
					Collectors.<Invoice>maxBy(Comparator.comparing(Invoice::getTotal))
					).get();
		
		//System.out.println(factura);
	
		System.out.println(
		invoices.stream().collect(Collectors.groupingBy(Invoice::getRecipient)).toString()
		);
		
		
		/**
		 * ORDERNAR
		 */
		
		System.out.println(">>>facturas");
		
		Comparator<InvoiceItem> compa = (i1, i2) -> i1.getProduct().compareTo(i2.getProduct());
		
		invoices.stream().flatMap(invoice->invoice.getItems().stream())
		.map(invoiceItem->invoiceItem.getProduct().toUpperCase()).distinct()
		.sorted().forEach(x->System.out.println(x));
		
		System.out.println(">>>frutas");
		List<String> frutas = new ArrayList<>(Arrays.asList("Platano", "Algo", "Algo", "Limon"));
		frutas.stream().sorted(Comparator.reverseOrder()).distinct().forEach(x->System.out.println(x));
		
		
		
		
	}

}
