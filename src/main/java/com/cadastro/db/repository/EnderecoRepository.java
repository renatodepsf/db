package com.cadastro.db.repository;
import com.cadastro.db.domain.EnderecoViaCep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoViaCep, Long> {
}
