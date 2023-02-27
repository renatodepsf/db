package com.cadastro.db.domain;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dbCadastro")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpfcnpj;
    private String dtNascimento;
    private Date dataInsercao;
    private Date dataExclusao;

    public Cliente() {
    }

    public Cliente(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public Cliente(Long id, String nome, String cpfcnpj, String dtNascimento, Date dataInsercao, Date dataExclusao) {
        this.id = id;
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
        this.dtNascimento = dtNascimento;
        this.dataInsercao = dataInsercao;
        this.dataExclusao = dataExclusao;
    }


    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataAlteracao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
