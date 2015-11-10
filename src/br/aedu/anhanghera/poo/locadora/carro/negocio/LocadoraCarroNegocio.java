package br.aedu.anhanghera.poo.locadora.carro.negocio;

import br.aedu.anhanghera.poo.locadora.carro.bd.CarroDAO;
import java.util.HashMap;
import java.util.Map;

import br.aedu.anhanghera.poo.locadora.carro.dominio.Cliente;
import br.aedu.anhanghera.poo.locadora.carro.dominio.Autenticavel;
import br.aedu.anhanghera.poo.locadora.carro.dominio.Funcionario;
import br.aedu.anhanghera.poo.locadora.carro.dominio.Carro;
import br.aedu.anhanghera.poo.locadora.carro.excecao.LoginException;
import br.aedu.anhanghera.poo.locadora.carro.excecao.ReservarCarroException;
import java.util.List;

public class LocadoraCarroNegocio {

    private Map clientesSistema = new HashMap();
    private Map funcionariosSistema = new HashMap();
    private Map usuariosAutenticados = new HashMap();
    private Map carrosReservados = new HashMap();

    public Cliente carregarCliente(String id) {
        return (Cliente) clientesSistema.get(id);
    }

    public Funcionario carregarFuncionario(String id) {
        return (Funcionario) funcionariosSistema.get(id);
    }

    public void popularClientes() {
        System.out.println("Populando tabelas de clientes");
        for (int i = 0; i < 100; i++) {
            Cliente a = new Cliente("Cliente " + i, i + "C", "0000" + i);
            clientesSistema.put(a.getId(), a);
        }
        System.out.println(clientesSistema.size() + " clientes populados no sistema");
    }

    public void popularFuncionarios() {
        for (int i = 0; i < 100; i++) {
            Funcionario f = new Funcionario("Funcionario " + i, i + "F", "0000" + i);
            funcionariosSistema.put(f.getId(), f);
        }
        System.out.println(funcionariosSistema.size() + " funcionarios populados no sistema");
    }

    public void popularCarros() throws Exception {
        List<Carro> carros = CarroDAO.listar();
        if(carros.isEmpty()){
            for (int i = 0; i < 500; i++) {
                Carro l = new Carro("Carro " + i, "4P");
                CarroDAO.inserir(l);
            }
        }
    }

    public void autenticar(Autenticavel autenticavel, String senha) throws LoginException {
        System.out.println("Iniciando a autenticacao do usuário: " + autenticavel.getId());

        if (!clientesSistema.containsKey(autenticavel.getId()) && !funcionariosSistema.containsKey(autenticavel.getId())) {
            throw new LoginException("Pessoa inesistente no sistema");
        }

        autenticavel.autentica(senha);
        usuariosAutenticados.put(autenticavel.getId(), autenticavel);

        System.out.println("Usuário autenticado com sucesso " + autenticavel.getId());
    }

    public void reservar(Autenticavel autenticavel, int idCarro) throws ReservarCarroException {
        System.out.println("Reservando o carro " + idCarro + " para o usuario " + autenticavel.getId());

        if (!usuariosAutenticados.containsKey(autenticavel.getId())) {
            throw new ReservarCarroException("Usuário " + autenticavel.getId() + " não está autenticado no sistema, não pode reserva um carro");
        }

        if (carrosReservados.containsKey(idCarro)) {
            throw new ReservarCarroException("O carro já está reservado para o usuário " + carrosReservados.get(idCarro));
        } else {
            //carrosDisponiveis.remove(idCarro);
            carrosReservados.put(idCarro, autenticavel.getId());
        }

        System.out.println("Carro " + idCarro + " reservado com sucesso para o usuario " + autenticavel.getId());
    }

}
