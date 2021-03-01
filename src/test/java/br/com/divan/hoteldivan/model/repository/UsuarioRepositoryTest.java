package br.com.divan.hoteldivan.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.divan.hoteldivan.model.entity.Usuario;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@ActiveProfiles("Test")
public class UsuarioRepositoryTest {
	
	@Autowired
	UsuarioRepository repository;
	
	@Test
	public void deveVerificarAExistenciaDeUmEmail() {
		
		//cenario
		Usuario usuario = Usuario.builder().nome("Usuario").email("gvan1961@hotmail.com").build();
		repository.save(usuario);
		//Execucao
		boolean result = repository.existsByEmail("gvan1961@hotmail.com");
		//Verificacao
		Assertions.assertThat(result).isTrue();
	}

}
