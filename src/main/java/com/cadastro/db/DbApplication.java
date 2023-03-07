package com.cadastro.db;

import com.cadastro.db.domain.Endereco;
import com.cadastro.db.repository.EnderecoRepository;
import com.cadastro.db.service.ClienteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DbApplication {
	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);

	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
