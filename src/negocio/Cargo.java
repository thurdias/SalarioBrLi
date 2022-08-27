package negocio;

import java.util.Collection;

import persistencia.CargoDAO;

public class Cargo {
	// Propriedades da classe
	private int id = 0;
	private String nome = "";
	private double salario = 0;
	
	// Métodos construtores da classe
	public Cargo() {
		super();
	}

	public Cargo(int id, String nome, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	// Métodos get/set da classe
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	// Métodos da classe
	public static Collection<Cargo> getTodos() throws Exception {
		return new CargoDAO().getTodos();
	}
	
	public void persistir() throws Exception {
		new CargoDAO().persistir(this);
	}
}