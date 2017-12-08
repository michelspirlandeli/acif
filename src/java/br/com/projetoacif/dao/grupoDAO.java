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

import br.com.projetoacif.entidade.grupo;

import br.com.projetoacif.util.exception.erroSistema;
import br.com.projetoacif.utiu.conexaoAcif;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class grupoDAO implements crudDAO<grupo>{
    
    @Override
    public void salvar(grupo grupo) throws erroSistema{
        try {
            Connection conexao = conexaoAcif.getConexao();
            PreparedStatement ps;
            if(grupo.getId() == null){
                ps = conexao.prepareStatement("INSERT INTO `grupos` (`descricao`,`datacadastro`) VALUES (?,?)");
            } else {
                ps = conexao.prepareStatement("update grupos set descricao=?, datacadastro=? where id=?");
                ps.setInt(3, grupo.getId());
            }
            ps.setString(1, grupo.getDescricao());
            ps.setDate(2, new Date(grupo.getDataCadastro().getTime()));
            ps.execute();
            conexaoAcif.fecharConexao();
        } catch (SQLException ex) {
            throw new erroSistema("Erro ao tentar salvar!", ex);
        }
    }
    
    @Override
    public void deletar(grupo grupo) throws erroSistema{
        try {
            Connection conexao = conexaoAcif.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("delete from grupos where id = ?");
            ps.setInt(1, grupo.getId());
            ps.execute();
        } catch (SQLException ex) {
            throw new erroSistema("Erro ao deletar o grupo!", ex);
        }
    }
    
    @Override
    public List<grupo> buscar() throws erroSistema{
        try {
            Connection conexao = conexaoAcif.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from grupos");
            ResultSet resultSet = ps.executeQuery();
            List<grupo> grupos = new ArrayList<>();
            while(resultSet.next()){
                grupo grupo = new grupo();
                grupo.setId(resultSet.getInt("id"));
                grupo.setDescricao(resultSet.getString("descricao"));
                grupo.setDataCadastro(resultSet.getDate("datacadastro"));
                grupos.add(grupo);
            }
            conexaoAcif.fecharConexao();
            return grupos;
            
        } catch (SQLException ex) {
            throw new erroSistema("Erro ao buscar os grupos!",ex);
        }
    }
  
}
