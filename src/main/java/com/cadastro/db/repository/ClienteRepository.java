package com.cadastro.db.repository;
import com.cadastro.db.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String name);
    List<Cliente> findByCpfcnpj(String cpfcnpj);
}
