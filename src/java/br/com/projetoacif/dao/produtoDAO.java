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


import br.com.projetoacif.entidade.produto;
import br.com.projetoacif.util.exception.erroSistema;
import br.com.projetoacif.utiu.conexaoAcif;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class produtoDAO implements crudDAO<produto>{
                
    @Override
    public void salvar(produto produto) throws erroSistema{
        try {
            Connection conexao = conexaoAcif.getConexao();
            PreparedStatement ps;
            if(produto.getId() == null){
                ps = conexao.prepareStatement("INSERT INTO `produtos` (`id`,`idgrupo`,`descricao`,`marca`,`datacadastro`) VALUES (?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update produtos set idgrupo=?, descricao=?,marca=?, datacadastro=? where id=?");
                ps.setInt(5, produto.getId());
            }
           
            ps.setString(1, produto.getDescricao());
            ps.setString(2, produto.getMarca());
            ps.setDate(3, new Date(produto.getDataCadastro().getTime()));
            ps.execute();
            conexaoAcif.fecharConexao();
        } catch (SQLException ex) {
            throw new erroSistema("Erro ao tentar salvar!", ex);
        }
    }
    
    @Override
    public void deletar(produto produto) throws erroSistema{
        try {
            Connection conexao = conexaoAcif.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("delete from produtos where id = ?");
            ps.setInt(1, produto.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new erroSistema("Erro ao deletar o produto!", ex);
        }
    }
    
    @Override
    public List<produto> buscar() throws erroSistema{
        try {
            Connection conexao = conexaoAcif.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from produtos");
            ResultSet resultSet = ps.executeQuery();
            List<produto> produtos = new ArrayList<>();
            while(resultSet.next()){
                produto produto = new produto();
                produto.setId(resultSet.getInt("id"));
                produto.setIdGrupo(resultSet.getInt("idgrupo"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setMarca(resultSet.getString("marca"));
                produto.setDataCadastro(resultSet.getDate("datacadastro"));
                produtos.add(produto);
            }
            conexaoAcif.fecharConexao();
            return produtos;
            
        } catch (SQLException ex) {
            throw new erroSistema("Erro ao buscar os grupos!",ex);
        }
    }
    
}
