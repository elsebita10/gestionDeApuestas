package ar.com.buildingways;

import java.util.ArrayList;
import java.util.Arrays;

public class Juego {
	
	public ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
		
	public ArrayList<Integer> getListaNumeros() {
		return listaNumeros;
	}

	public void setListaNumeros(ArrayList<Integer> listaNumeros) {
		this.listaNumeros = listaNumeros;
	}
	
	public String generarApuesta(String juego) {
		String apuesta = "Apuesta generada: ";
		switch (juego) {
		case Constantes.QUINI : apuesta = this.getNumeros(apuesta, juego, Constantes.VALOR_FINAL_QUINI);
		break;
		case Constantes.LOTO : apuesta = this.getNumeros(apuesta, juego, Constantes.VALOR_FINAL_LOTO);
							   apuesta = this.getJackPot(apuesta);
		break;
		default : apuesta = "No se pudo generar la apuesta. No existe el juego ingresado.";
		break;
		}
		return apuesta;
	}
	
	private String getNumeros(String apuesta, String juego, int valorFinal){
		int [] numerosElegidos = new int [Constantes.CANTIDAD_BOLILLAS];
		numerosElegidos = armarApuesta(Constantes.VALOR_INICIAL, valorFinal, Constantes.CANTIDAD_BOLILLAS);
		for (int i = 0; i < numerosElegidos.length; i++) {
			apuesta += numerosElegidos[i] + " - ";
		}
		return apuesta.substring(0, apuesta.length()-3);
	}
		
	private String getJackPot(String apuesta){
		apuesta += ". Jackpot: ";
		int [] numerosElegidos = new int [Constantes.CANTIDAD_BOLILLAS_JACKPOT];
		numerosElegidos = armarApuesta(Constantes.VALOR_INICIAL, Constantes.VALOR_FINAL_JACKPOT, Constantes.CANTIDAD_BOLILLAS_JACKPOT);
		for (int i = 0; i < numerosElegidos.length; i++) {
			apuesta += numerosElegidos[i] + " - ";
		}
		return apuesta.substring(0, apuesta.length()-3);
	}
	
	private int generar(int valorInicial, int valorFinal) {
		if(listaNumeros.size() < (valorFinal - valorInicial) + 1) {
			int numero = (int)(Math.random()*(valorFinal - valorInicial + 1) + valorInicial);
			if(listaNumeros.isEmpty()) {
				listaNumeros.add(numero);
				return numero;
			} else {
				if(listaNumeros.contains(numero)) {
					return generar(valorInicial, valorFinal);
	        } else {
	        	listaNumeros.add(numero);
	          return numero;
	        }
	      }
	   } else {
		   return -1;
	   }
	}
	
	private int [] armarApuesta(int valorInicial, int valorFinal, int cantidad) {
		int [] numerosElegidos = new int [cantidad];
		for (int i = 0; i < numerosElegidos.length; i++) {
			numerosElegidos[i] = generar(valorInicial, valorFinal);
		}
		Arrays.sort(numerosElegidos);
		return numerosElegidos;
	}
}