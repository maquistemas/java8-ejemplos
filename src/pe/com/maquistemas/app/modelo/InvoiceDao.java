package pe.com.maquistemas.app.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDao {
	
	
	public static List<Invoice> getFacturas(){
		List<Invoice> facturas = new ArrayList<>();
		
		List<InvoiceItem> invoiceItems1 = new ArrayList<>();
		InvoiceItem detalle1 = new InvoiceItem("Gaseosa", 10, new BigDecimal(10.51));
		InvoiceItem detalle2 = new InvoiceItem("Cerveza", 20, new BigDecimal(20.37));
		InvoiceItem detalle3 = new InvoiceItem("Frugo", 30, new BigDecimal(30.57));
		invoiceItems1.add(detalle1);
		invoiceItems1.add(detalle2);
		invoiceItems1.add(detalle3);
		
		Invoice factura1 = new Invoice("Tienda1", "Cliente1", invoiceItems1);
		
		List<InvoiceItem> invoiceItems2 = new ArrayList<>();
		InvoiceItem detalle1_2 = new InvoiceItem("Gaseosa", 40, new BigDecimal(14.51));
		InvoiceItem detalle2_2 = new InvoiceItem("camote", 50, new BigDecimal(25.37));
		InvoiceItem detalle3_2 = new InvoiceItem("yuca", 60, new BigDecimal(36.57));
		invoiceItems2.add(detalle1_2);
		invoiceItems2.add(detalle2_2);
		invoiceItems2.add(detalle3_2);
		
		Invoice factura2 = new Invoice("Tienda2", "Cliente2", invoiceItems2);
		
		facturas.add(factura1);
		facturas.add(factura2);
		
		return facturas;
		
	}
	
	

}
