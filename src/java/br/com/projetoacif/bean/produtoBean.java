/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoacif.bean;


import br.com.projetoacif.dao.produtoDAO;
import br.com.projetoacif.entidade.produto;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author Michel
 */
@ManagedBean
@SessionScoped
public class produtoBean extends crudBean<produto, produtoDAO>{
    
    private produtoDAO produtoDAO;
    
    @Override
    public produtoDAO getDao() {
        if(produtoDAO == null){
            produtoDAO = new produtoDAO();
        }
        return produtoDAO;
    }

    @Override
    public produto criarNovaEntidade() {
        return new produto();
    }
    
}
