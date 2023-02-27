package com.cadastro.db.repository;

import com.cadastro.db.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String name);
    List<Cliente> findByCpfcnpj(String cpfcnpj);
}
