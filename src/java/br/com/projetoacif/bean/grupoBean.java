/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoacif.bean;


import br.com.projetoacif.dao.grupoDAO;
import br.com.projetoacif.entidade.grupo;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Michel
 */
@ManagedBean
@SessionScoped
public abstract class grupoBean extends crudBean<grupoDAO, grupoDAO>{
    
     private grupoDAO grupoDAO;
    
    
    @Override
    public grupoDAO getDao() {
        if(grupoDAO == null){
            grupoDAO = new grupoDAO();
        }
        return grupoDAO;
    }

}


