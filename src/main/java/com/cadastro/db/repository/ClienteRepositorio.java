package com.cadastro.db.repository;

import com.cadastro.db.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String name);
    List<Cliente> findByCpfcnpj(String cpfcnpj);
}
