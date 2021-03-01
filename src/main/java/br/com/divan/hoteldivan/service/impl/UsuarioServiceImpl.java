package br.com.divan.hoteldivan.service.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.divan.hoteldivan.exception.ErroAutenticacao;
import br.com.divan.hoteldivan.exception.RegraNegocioException;
import br.com.divan.hoteldivan.model.entity.Usuario;
import br.com.divan.hoteldivan.model.repository.UsuarioRepository;
import br.com.divan.hoteldivan.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	//@Autowired
	//EntityManager entityManager;
	
	
    @Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
	
		 Optional<Usuario> usuario = repository.findByEmail(email);
		 
		 if(!usuario.isPresent()) {
			 throw new ErroAutenticacao("Usuário não encontrado para o email informado.");
		 }
		 
		 if (!usuario.get().getSenha().equals(senha)) {
			 throw new ErroAutenticacao("Senha inválida.");
		 }
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		   validarEmail(usuario.getEmail());
		   
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		
		if(existe) {
			throw new RegraNegocioException("Já exite um usario cadastrado com este email.");
		}
	}

}
