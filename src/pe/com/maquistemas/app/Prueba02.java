package pe.com.maquistemas.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import pe.com.maquistemas.app.modelo.InvoiceDao;
import pe.com.maquistemas.app.modelo.InvoiceItem;

public class Prueba02 {

	
	public static void main(String[] args) {
		
	String masBarato = 	InvoiceDao.getFacturas()
		.stream()
        .flatMap(invoice -> invoice.getItems().stream())
        .min(Comparator.comparing(InvoiceItem::getPricePerUnit))
        .get().getProduct();
	
	System.out.println(masBarato);
	
	BigDecimal totalFactura = InvoiceDao.getFacturas().get(0).getTotal();
	System.out.println(totalFactura);
	
	

		
		
	}
	
	
	
	
	
	 public void getTotal() {
//	        return InvoiceDao.getFacturas().get(0).getItems()
//	        		.stream()
//	            .<BigDecimal>map(invoiceItem -> invoiceItem.getPricePerUnit()
//	                    .multiply(BigDecimal.valueOf(invoiceItem.getQuantity())))
//	            .collect(Collectors.reducing(
//	                    BigDecimal.ZERO,
//	                    (sum, elem) -> sum.add(elem)));
		 
		 
		InvoiceDao.getFacturas().get(0).getItems().stream()
			.<BigDecimal>map(invoiceItem->invoiceItem.getPricePerUnit().multiply(BigDecimal.valueOf(invoiceItem.getQuantity())))
			.collect(Collectors.reducing(BigDecimal.ZERO,(sum, elem)->sum.add(elem)));
												  
		 
		 
	    }
	
	
	
	
	
}
