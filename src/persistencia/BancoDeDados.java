package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDeDados {
	// Propriedades da classe
	private Connection objConexao = null;
	
	// Método get da classe
	Connection getObjConexao() {
		return objConexao;
	}
	
	// Métodos da classe
	void conectar() throws Exception {
		objConexao = DriverManager.getConnection(
			"jdbc:oracle:thin:@//192.168.2.3:1521/xe?" +
			"user=AUTO&password=AUTO");
	}
	
	void desconectar() throws Exception {
		objConexao.close();
	}
}