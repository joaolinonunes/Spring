package com.dadospostgres.ConexaoDados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
//import com.sun.el.stream.Optional;

@Controller
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	
	@PostMapping(path = "/add")
	public @ResponseBody String novoUsuario (@RequestParam String nome, @RequestParam  String carro, @RequestParam int placa, @RequestParam double tempo ) {
	
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setCarro(carro);
		user.setPlaca(placa);
		user.setTempo(tempo);
		repositorio.save(user);
		
	return 	"Salvo com sucesso";
	}
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Usuario> retornaTodos (){		
		return repositorio.findAll();
	}
	
	@GetMapping(path = "/user")
	public @ResponseBody Optional<Usuario> retornaUser (@RequestParam String id){		
		return repositorio.findById(Long.parseLong(id));
	}
	
	@DeleteMapping(path = "delete_user/{id}")
	public @ResponseBody String deleteUser (@PathVariable(required = true , name = "id") Long id) {	
		Optional<Usuario> user = repositorio.findById(id);
		if(user.isPresent()) {
			repositorio.delete(user.get());
			return "Usuario deletado com sucesso";
		}
	return "Usuario não encontrado";	
	}
	
	@PutMapping(path="update_user/{id}")
	public @ResponseBody Optional<Usuario> updateUser(@PathVariable(required = true, name="id") long id,
	@RequestBody Usuario user){
	Optional<Usuario> u = repositorio.findById(id);
	  if(u.isPresent()) {
		  u.get().setNome(user.getNome());
		  u.get().setCarro(user.getCarro());
		  u.get().setPlaca(user.getPlaca());
		  u.get().setTempo(user.getTempo());
		  repositorio.save(u.get());
		  return u;
	  }
		
		return null;
	}
	
	@GetMapping(path = "locate_by_nome/{Nome}")
	public @ResponseBody List<Usuario> locateByNome(@PathVariable(required = true, name="Nome") String Nome){
		return repositorio.findByNome(Nome);	
	}
	
	@GetMapping(path = "locate_by_carro/{Carro}")
	public @ResponseBody List<Usuario> locateByCarro(@PathVariable(required = true, name="Carro") String Carro){
		return repositorio.findByCarro(Carro);	
	}
}
