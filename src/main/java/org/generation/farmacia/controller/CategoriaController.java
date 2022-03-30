package org.generation.farmacia.controller;

import java.util.List;

import org.generation.farmacia.model.Categoria;
import org.generation.farmacia.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//indicação de controller o que me permite a utilização de verbos e métodos http
@RequestMapping("/categorias")//localização dos métodos do controller na url(insomia/postman)
@CrossOrigin(origins="*",allowedHeaders="*")// indica que esta classe aceita requisições de qualquer origem // AllowedHeaders??
public class CategoriaController {
	
	@Autowired // permite que seja usado tudo do repositorio no controller
	private CategoriaRepository repository; // demos um nome para o repository
	
	/* não se escreve as requisições do banco de dados no controller, 
	com a utilização do autowired se transfere a responsabilidade do controller para o repository,
	 e com isso, acessamos o repository pelo controller */
	
	@GetMapping // rota padrão, retorna tudo que tiver em categoria ao usar Get .... /categorias
	public ResponseEntity<List<Categoria>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") // subrota de consulta pelo id, mediante a passagem de um valor{na rota PathVariable}
	public ResponseEntity<Categoria>getById(@PathVariable Long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}//função vai acessar a tb_categoria usando a função getById para procurar pelo id dado pelo usuário. O respositório então vai acessar banco de dados e pode retornar duas respostas. 
	
	@GetMapping("/menu/{menu}")
	public ResponseEntity<List<Categoria>>getByName(@PathVariable String menu){
		return ResponseEntity.ok(repository.findAllByMenuContainingIgnoreCase(menu));
	}
	
	@PostMapping
	public ResponseEntity<Categoria>post(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria>put(@RequestBody Categoria categoria){
		return ResponseEntity.ok(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	

}
