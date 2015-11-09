package br.aedu.anhanghera.poo.locadora.carro.dominio;

import br.aedu.anhanghera.poo.locadora.carro.excecao.LoginException;

public interface Autenticavel {
	
	void autentica(String senha) throws LoginException;
	
	String getId();

}
