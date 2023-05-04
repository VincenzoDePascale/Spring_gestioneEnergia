package com.epicbe.gestioneenergia.model;

import java.util.Locale;

import com.github.javafaker.Faker;

public enum Stato {
	 EMESSA,
	 INCASSATA,
	 DEPRECATA,
	 PAGATA,
	 NON_PAGATA,
	 
	 public static Stato statoRandom() {
			Faker fake = new Faker(new Locale("it-IT"));
			int size = Stato.values().length;
			int position = fake.number().numberBetween(0, size);
			return Stato.values()[position];
	 }
 
}
