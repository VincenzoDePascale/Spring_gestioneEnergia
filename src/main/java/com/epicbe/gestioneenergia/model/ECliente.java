package com.epicbe.gestioneenergia.model;

import java.util.Locale;

import com.github.javafaker.Faker;

public enum ECliente {
	PA,
	SAS,
	SPA,
	SRL;
	
	public static ECliente eClienteRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		int size = ECliente.values().length;
		int position = fake.number().numberBetween(0, size);
		return ECliente.values()[position];
	}
}
