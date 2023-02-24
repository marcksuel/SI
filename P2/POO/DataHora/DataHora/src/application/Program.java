package application;

import java.time.LocalDate;

import javax.xml.crypto.Data;

public class Program {
	public static void main(String[] args) {
	
		LocalDate localDate = LocalDate.now();
		
		System.out.println(localDate);
		System.out.println("Dia da semana: " + localDate.getDayOfWeek().name());
		System.out.println("Dia da semana: " + localDate.getDayOfWeek().ordinal());
		System.out.println("Mes: " + localDate.getMonthValue());
		System.out.println("Mes: " + localDate.getMonth().name());
		System.out.println("Ano: " + localDate.getYear());
		
		LocalDate date;
		
		date = LocalDate.of(5,6, 2000);
		
		System.err.println();
	
	}
}
