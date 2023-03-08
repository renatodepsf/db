package com.cadastro.db.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "dbCliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpfcnpj;
    private String dtNascimento;
    private Date dataInsercao;
    private Date dataAlteracao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dbEndereco")
    Endereco endereco;

}
