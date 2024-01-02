/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Cadastro {
    
    private int idcad;
    private String nomecad;
    private String cpf;
    private String cep;
    private String email;
    private String rua;
    private String bairro;
    private String uf;
    private String cidade;
    private String foto;
    
    private int numCadastros;
    
    
    public Cadastro() {
    }
    
    public Cadastro(String nomecad, String cpf, String email, String cep, String rua, String bairro, String cidade, String uf,String foto) {
        this.nomecad = nomecad;
        this.cpf = cpf;
        this.cep = cep;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.foto = foto;
    }

 public Cadastro(int idcad, String nomecad, String cpf, String email, String cep, String rua, String bairro, String cidade, String uf, String foto) {
        this.idcad = idcad;     
        this.nomecad = nomecad;
        this.cpf = cpf;
        this.cep = cep;
        this.email = email;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf; 
        this.foto = foto;
    }   
 public Cadastro(int numCadastros) {
        this.numCadastros = numCadastros;
    }  
    
    public int getIdCad() {
        return idcad;
    }

    public void setIdCad(int idcad) {
        this.idcad = idcad;
    }

    public String getNomecad() {
        return nomecad;
    }

    public void setNomeCad(String nomecad) {
        this.nomecad = nomecad;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf; 
    }
    

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getTotalCadastros() {
        return numCadastros;
    }

    public void setTotalCadastros(int numCadastros) {
        this.numCadastros = numCadastros;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


}



