package br.aedu.anhanghera.poo.locadora.carro;

import br.aedu.anhanghera.poo.locadora.carro.negocio.LocadoraCarroNegocio;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
	
	private static LocadoraCarroNegocio locadoraCarroNegocio = new LocadoraCarroNegocio();
	
	public static void main(String[] args) {
	
           
            try {
                locadoraCarroNegocio.popularCarros();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
           
		
	}

}
