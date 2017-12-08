/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoacif.entidade;

/**
 *
 * @author Michel
 */

import java.util.Date;
import java.util.Objects;

public class produto {
    
    private Integer id;
    private Integer idgrupo;
    private String descricao;
    private String marca;
    private Date datacadastro;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getIdGrupo() {
        return idgrupo;
    }

    public void setIdGrupo(Integer idgrupo) {
        this.idgrupo = idgrupo;
    }
    
     public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
     public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDataCadastro() {
        return datacadastro;
    }

    public void setDataCadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final produto other = (produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
