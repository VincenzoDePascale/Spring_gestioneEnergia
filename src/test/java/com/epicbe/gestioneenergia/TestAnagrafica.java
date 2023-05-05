package com.epicbe.gestioneenergia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.Comune;
import com.epicbe.gestioneenergia.model.ECliente;
import com.epicbe.gestioneenergia.model.Indirizzo;

class TestAnagrafica {
	
	static Comune co;
	static Cliente cl;
	static Indirizzo i;

	@BeforeAll
	public static void beforeTestCliente() {
		
		co = new Comune(1l, 33l, 22l, "nome", "provincia");
		
		cl = new Cliente(12l, "regione sociale",
				ECliente.PA, "p. iva", "email",
				LocalDate.of(2023,  2, 5),
				LocalDate.of(2023,  3, 5), "pec",
				"num tel", "emailContato", "nome contatto",
				"cognome contatto", "tel contatto", null, null);
		
		i = new Indirizzo(2l, "via", "civico", co, 80044, cl);
		
		List<Indirizzo> listIndirizzo = new ArrayList<>();
		listIndirizzo.add(i);
		
		cl.setIndirizzi(listIndirizzo);
				
	}
		
	@Test
	@DisplayName("id ")
	public void testId () {
		assertEquals(12l, cl.getId());
	}
	
	@Test
	public void testAgioneSociale () {
		assertEquals("regione sociale", cl.getRagioneSociale());
	}
	
	@Test
	public void testTtipoCliente () {
		assertEquals(ECliente.PA, cl.getTipoCliente());
	}
	
	@Test
	public void testPartitaIva () {
		assertEquals("p. iva", cl.getPartitaIva());
	}
	
	@Test
	public void testEmail () {
		assertEquals("email", cl.getEmail());
	}
	
	@Test
	public void testInserimento () {
		assertEquals(LocalDate.of(2023,  2, 5), cl.getInserimento());
	}
	
	@Test
	public void testUltimocontatto () {
		assertEquals(LocalDate.of(2023,  3, 5), cl.getUltimocontatto());
	}
	
	//relazioni
	
	@Test
	@DisplayName("relazione indirizzi")
	public void testIndirizzi() {
		assertEquals(i, cl.getIndirizzi().get(0));
	}
	
	@Test
	@DisplayName("relazione comuni")
	public void testComune() {
		assertEquals(co, i.getComune());
	}
	
	@AfterAll
	public static void afterAllTestCliente() {

		cl = null;
		i = null;
		co = null;
		
	}
	
	
}
