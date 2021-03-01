package br.com.divan.hoteldivan.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.divan.hoteldivan.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//Optional<Usuario> findByEmail(String email); ou a próxima linha
	
	boolean existsByEmail(String email);

	Optional<Usuario> findByEmail(String email);
}
