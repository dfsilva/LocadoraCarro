/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.aedu.anhanghera.poo.locadora.carro.telas.modelo;

import br.aedu.anhanghera.poo.locadora.carro.dominio.Carro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diego
 */
public class CarrosTableModel extends AbstractTableModel{

    private List<Carro> carros;
    private String[] colunas;

    public CarrosTableModel(List<Carro> carros) {
        super();
        this.carros = carros;
        colunas = new String[]{"ID", "Nome", "Modelo"};
    }
    
    @Override
    public int getRowCount() {
        return this.carros.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           Carro carro = carros.get(rowIndex);
           switch(columnIndex){
               case 0: return carro.getId();
               case 1: return carro.getNome();
               case 2: return carro.getModelo();
           }
           return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public Carro getValueAt(int rowIndex){
        return carros.get(rowIndex);
    }
}
