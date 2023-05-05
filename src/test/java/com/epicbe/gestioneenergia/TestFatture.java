package com.epicbe.gestioneenergia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.ECliente;
import com.epicbe.gestioneenergia.model.Fattura;
import com.epicbe.gestioneenergia.model.Stato;

public class TestFatture {

	static Cliente cl;
	static Fattura f;
	
	@BeforeAll
	public static void beforeTestFattura() {
		
		List<Fattura> listaFatture = new ArrayList<>();
		
		cl = new Cliente(12l, "regione sociale",
				ECliente.PA, "p. iva", "email",
				LocalDate.of(2023,  2, 5),
				LocalDate.of(2023,  3, 5), "pec",
				"num tel", "emailContato", "nome contatto",
				"cognome contatto", "tel contatto", null, null);

		f = Fattura.builder()
					.id(1l)
					.anno(2023)
					.data(LocalDate.of(2024, 5, 6))
					.importo(new BigDecimal(136.45d))
					.numero(56234)
					.stato(Stato.EMESSA)
					.cliente(cl)
					.build();
		
		listaFatture.add(f);
		cl.setFatture(listaFatture);
		
	}
	
	@Test
	public void testCliente() {
		assertEquals(cl, f.getCliente());
	}
	
	@Test
	public void testStato () {
		assertEquals(Stato.EMESSA, f.getStato());
	}
	
	@Test
	public void testImporto() {
		assertEquals(new BigDecimal(136.45d), f.getImporto());
	}
	
	@Test
	public void testRelazione() {
		assertEquals(f.getCliente(), cl);
		assertEquals(f, cl.getFatture().get(0));
	}
	
	
	
	
}
