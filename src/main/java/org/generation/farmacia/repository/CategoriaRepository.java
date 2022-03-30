package org.generation.farmacia.repository;

import java.util.List;

import org.generation.farmacia.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria>findAllByMenuContainingIgnoreCase(String menu); 
	
	/* Em resumo, para que pudessemos utilizar a super classe JPA, criamos uma classe filha para poder
	 * utilizar suas funções. E neste caso, irá consultar o bando de dados pela variável menu
	  */

}
