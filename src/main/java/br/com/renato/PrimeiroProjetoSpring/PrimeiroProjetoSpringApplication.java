package br.com.renato.PrimeiroProjetoSpring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.renato.domain.Cliente;
import br.com.renato.repository.IClienteRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.renato.repository")
@EntityScan(basePackages = "br.com.renato.domain")
public class PrimeiroProjetoSpringApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(PrimeiroProjetoSpringApplication.class);
	
	@Autowired
	private IClienteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Cliente cliente = createCliente();
		repository.save(cliente);
		
	}
	
	private Cliente createCliente() {
		return Cliente.builder()
				.cidade("São Paulo")
				.cpf(3213133112L)
				.email("Teste@teste.com")
				.end("End")
				.estado("SP")
				.nome("SpringBoot")
				.numero(102030)
				.tel(10203040L)
				.build();
		}
	}
