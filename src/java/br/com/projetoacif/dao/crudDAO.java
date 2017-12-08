/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoacif.dao;

/**
 *
 * @author Michel
 */
import br.com.projetoacif.util.exception.erroSistema;
import java.util.List;

public interface crudDAO<E> {
    public void salvar(E entidade) throws erroSistema;
    public void deletar(E entidade) throws erroSistema;
    public List<E> buscar() throws erroSistema;
    
}


