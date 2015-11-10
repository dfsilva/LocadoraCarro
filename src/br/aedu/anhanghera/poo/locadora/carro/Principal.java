package br.aedu.anhanghera.poo.locadora.carro;

import br.aedu.anhanghera.poo.locadora.carro.negocio.LocadoraCarroNegocio;
import br.aedu.anhanghera.poo.locadora.carro.telas.TelaPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Principal {
	
	private static LocadoraCarroNegocio locadoraCarroNegocio = new LocadoraCarroNegocio();
	
        private static TelaPrincipal telaPrincipal;
        
	public static void main(String[] args) {
	
           
            try {
                locadoraCarroNegocio.popularCarros();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
    
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            telaPrincipal = new TelaPrincipal();
            telaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
            telaPrincipal.setVisible(true);
            }});
            
	}

}
