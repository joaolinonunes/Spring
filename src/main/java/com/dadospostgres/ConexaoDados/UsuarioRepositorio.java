package com.dadospostgres.ConexaoDados;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepositorio extends CrudRepository < Usuario, Long> {

	List<Usuario> findByNome(String Nome);
	List<Usuario> findByCarro(String Carro);
	List<Usuario> findByPlaca(int Placa);
	List<Usuario> findByTempo(double Tempo);
	
	
	
}
