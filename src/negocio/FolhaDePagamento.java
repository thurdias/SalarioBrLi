package negocio;

public class FolhaDePagamento {
	// Métodos da classe
	public String calcular() throws Exception {
		String retorno = "Nome\tBruto\tDescontos\tLíquido\r\n";
		
		for (Colaborador objColaborador : Colaborador.getTodos()) {
			retorno += objColaborador.getNome() + "\t";
			retorno += objColaborador.getObjCargo().getSalario() + "\t";
			
			double descontos = ((objColaborador.getObjCargo().getSalario() * 0.11) +
								(objColaborador.getObjCargo().getSalario() * 0.275));
			
			retorno += descontos + "\t";
			retorno += (objColaborador.getObjCargo().getSalario() - descontos) + "\r\n";
		}
		
		return retorno;
	}
}