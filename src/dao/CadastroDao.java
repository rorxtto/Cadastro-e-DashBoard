/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cadastro;


public class CadastroDao implements DaoGenerica<Cadastro>{

    private ConexaoBanco conexao;
    
    public CadastroDao()
    {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Cadastro cadastro) {
        //string com a consulta que será executada no banco
        String sql = "INSERT INTO tb_dentista1 (id_dentista,nome, cpf, cep, email, rua, bairro, cidade, uf,foto, data_criacao, data_alteracao) \n" +
             "VALUES (?,?,?,?,?,?,?,?,?,?, current_timestamp(), current_timestamp());";

    try
    {
        //tenta realizar a conexão, se retornar verdadeiro entra no IF
        if(this.conexao.conectar())
        {
            //prepara a sentença com a consulta da string
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

            //subtitui as interrogações da consulta, pelo valor específico
            sentenca.setInt(1,cadastro.getIdCad());
            sentenca.setString(2,cadastro.getNomecad());
            sentenca.setString(3,cadastro.getCpf());
            sentenca.setString(4,cadastro.getCep());
            sentenca.setString(5,cadastro.getEmail());
            sentenca.setString(6,cadastro.getRua());
            sentenca.setString(7,cadastro.getBairro());
            sentenca.setString(8,cadastro.getCidade());
            sentenca.setString(9,cadastro.getUf());
            sentenca.setString(10,cadastro.getFoto());   
            sentenca.execute(); //executa o comando no banco
            sentenca.close(); //fecha a sentença
            this.conexao.getConnection().close(); //fecha a conexão com o banco
        }
    }
    catch(SQLException ex)
    {
       throw new RuntimeException(ex);
    }
    }

    @Override
    public void alterar(Cadastro cadastro) {
        String sql = "UPDATE tb_dentista1 SET id_dentista = ?, nome = ?, cpf = ?, email = ?,cep = ?,rua = ?,bairro = ?,cidade = ?,uf = ?, foto = ?  where id_dentista = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                try (PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql)) {
                    
                    
                    sentenca.setInt(1, cadastro.getIdCad());
                    sentenca.setString(2, cadastro.getNomecad());
                    sentenca.setString(3, cadastro.getCpf());
                    sentenca.setString(4, cadastro.getEmail());
                    sentenca.setString(5, cadastro.getCep());
                    sentenca.setString(6, cadastro.getRua());
                    sentenca.setString(7, cadastro.getBairro());
                    sentenca.setString(8, cadastro.getCidade());
                    sentenca.setString(9, cadastro.getUf());
                    sentenca.setString(10,cadastro.getFoto());
                    sentenca.setInt(11, cadastro.getIdCad());
                    
                    sentenca.execute(); //executa o comando no banco
                }
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    public void excluirID(int id) {
        String sql = "DELETE FROM tb_dentista1 WHERE id_dentista = ?";
        
        try
        {
            if(this.conexao.conectar())
            {
                try (PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql)) {
                    sentenca.setInt(1, id);
                    
                    sentenca.execute();
                }
                this.conexao.getConnection().close();
            }
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

    @Override
   public ArrayList<Cadastro> consultar() {
    ArrayList<Cadastro> lista_pacientes = new ArrayList<Cadastro>();
    String sql = "SELECT c.id_dentista, c.nome, c.cpf, c.email,c.cep, c.rua, c.bairro, c.cidade, c.uf " + 
                 "FROM tb_dentista1 AS c";
                 
    
    try {
        if (this.conexao.conectar()) {
            // Recebe o resultado da consulta
            try (PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql)) {
                // Recebe o resultado da consulta
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                // Percorre cada linha do resultado
                while (resultadoSentenca.next()) {
                    // Resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Cadastro
                    Cadastro cadastro = new Cadastro();
                    cadastro.setIdCad(resultadoSentenca.getInt("id_dentista"));
                    cadastro.setNomeCad(resultadoSentenca.getString("nome"));
                    cadastro.setCpf(resultadoSentenca.getString("cpf"));
                    cadastro.setCep(resultadoSentenca.getString("cep"));
                    cadastro.setEmail(resultadoSentenca.getString("email"));
                    cadastro.setRua(resultadoSentenca.getString("rua"));
                    cadastro.setBairro(resultadoSentenca.getString("bairro"));
                    cadastro.setCidade(resultadoSentenca.getString("cidade"));
                    cadastro.setUf(resultadoSentenca.getString("uf"));
                    

                    // Adiciona cada tupla na lista_pacientes que será retornada para a janela Cadastro
                    lista_pacientes.add(cadastro);
                }
            }
            this.conexao.getConnection().close();
        }
        
        return lista_pacientes;
    } catch (SQLException ex) {
       throw new RuntimeException(ex);
    }
}


    @Override
    public void excluirID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Cadastro> consultar(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
public ArrayList<Cadastro> dashboard() {
        
        ArrayList<Cadastro> ListarDashBoard = new ArrayList<Cadastro>();
        String sql = "select count(id_dentista) as numcad from tb_dentista1;";
        
        try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                //recebe o resultado da consulta
                 ResultSet resultadoSentenca = sentenca.executeQuery();

                //percorrer cada linha do resultado
                while(resultadoSentenca.next()) 
                {
                    //resgata o valor de cada linha, selecionando pelo nome de cada coluna da tabela Escola
                    Cadastro cadastro = new Cadastro();
                    cadastro.setTotalCadastros(resultadoSentenca.getInt("numcad"));
                    
                    ListarDashBoard.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return ListarDashBoard;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }
    }

public Cadastro obterPorId(int id) {
        String sql = "SELECT id_dentista, nome, cpf, email, cep, rua, bairro, cidade, uf " +
                     "FROM tb_dentista1 WHERE id_dentista = ?";
        Cadastro cadastro = null;

        try {
            if (this.conexao.conectar()) {
                try (PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql)) {
                    sentenca.setInt(1, id);

                    // Recebe o resultado da consulta
                    ResultSet resultadoSentenca = sentenca.executeQuery();

                    // Verifica se há um resultado
                    if (resultadoSentenca.next()) {
                        cadastro = new Cadastro();
                        cadastro.setIdCad(resultadoSentenca.getInt("id_dentista"));
                        cadastro.setNomeCad(resultadoSentenca.getString("nome"));
                        cadastro.setCpf(resultadoSentenca.getString("cpf"));
                        cadastro.setEmail(resultadoSentenca.getString("email"));
                        cadastro.setCep(resultadoSentenca.getString("cep"));
                        cadastro.setRua(resultadoSentenca.getString("rua"));
                        cadastro.setBairro(resultadoSentenca.getString("bairro"));
                        cadastro.setCidade(resultadoSentenca.getString("cidade"));
                        cadastro.setUf(resultadoSentenca.getString("uf"));
                    }
                }
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return cadastro;
    }
    
}


