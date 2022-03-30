package org.generation.farmacia.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // indica a criação de uma tabela
@Table(name="tb_categoria") //nomeação da tabela e equivale ao create table
public class Categoria {

	@Id // indica uma correspondencia ao que seria a chave primária no banco de dados
	@GeneratedValue(strategy=GenerationType.IDENTITY)// A estratégia de incremento é o de auto-increment cuja responsabilidade é do próprio banco de dados
	private long id;// declaração da variável id
	
	@NotNull
	private String menu;// declaração da variável menu: categorias de opções de produtos da farmácia
	
	private int codigo; //código do produto
	
	private String quantidade; // quantidade de produto comprada
	
	@UpdateTimestamp // formata a data no padrão do notebook
	private LocalDate data; // utiliza a data no estilo americano. Para mostrar a hora da compra
	
	private boolean desc5; // o cliente tem desconto de 5%?
	
	@OneToMany(mappedBy = "categoria", cascade=CascadeType.ALL)//estabelecendo o relacionamento com a tabela produto
	@JsonIgnoreProperties("categoria")
	private List<Produto>produto;//criei uma variável que é uma lista de produtos
	
	//get e set para acesso a tabela

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public boolean isDesc5() {
		return desc5;
	}

	public void setDesc5(boolean desc5) {
		this.desc5 = desc5;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
	
	
}
