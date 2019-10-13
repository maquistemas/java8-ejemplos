package pe.com.maquistemas.app.modelo;

import java.math.BigDecimal;
import java.util.stream.Collectors;

public class Total_Factura_BigDecimal {
	
	public static void main(String[] args) {
		
		BigDecimal TotalFactura = InvoiceDao.getFacturas().get(0).getItems().stream()
				.<BigDecimal>map(invoiceItem->invoiceItem.getPricePerUnit().multiply(BigDecimal.valueOf(invoiceItem.getQuantity())))
				.collect(Collectors.reducing(BigDecimal.ZERO,(sum, elem)->sum.add(elem)));
		
		BigDecimal TotalFactura1 = InvoiceDao.getFacturas().get(1).getItems().stream()
				.<BigDecimal>map(invoiceItem->invoiceItem.getPricePerUnit().multiply(BigDecimal.valueOf(invoiceItem.getQuantity())))
				.collect(Collectors.reducing(BigDecimal.ZERO,(sum, elem)->sum.add(elem)));
		
//		System.out.println(TotalFactura);
//		System.out.println(TotalFactura1);
		
		
		//suma total de todas las facturas
		BigDecimal TotalFacturas = InvoiceDao.getFacturas().stream().flatMap(x->x.getItems().stream())
		.<BigDecimal>map(y->y.getPricePerUnit().multiply(BigDecimal.valueOf(y.getQuantity())))
		.collect(Collectors.reducing(BigDecimal.ZERO,(sum,elem)->sum.add(elem)));
		
		
		//sumas totales por factura (2 facturas)
		InvoiceDao.getFacturas().stream().map(x->x.getTotal()).forEach(System.out::println);
		
		
			
		
		//Precios * cantidad de una factura
		InvoiceDao.getFacturas().get(0).getItems().stream()
		.<BigDecimal>map(invoiceItem->invoiceItem.getPricePerUnit().multiply(BigDecimal.valueOf(invoiceItem.getQuantity())))
		.forEach(System.out::println);
		
		
		
		
	}

}
