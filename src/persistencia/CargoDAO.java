package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import negocio.Cargo;

public class CargoDAO {
	// Propriedades da classe
	BancoDeDados objBanco = new BancoDeDados();
	
	// Métodos da classe
	public Collection<Cargo> getTodos() throws Exception {
		PreparedStatement objExecucao = null;
		ResultSet objCursor = null;
		ArrayList<Cargo> retorno = new ArrayList<Cargo>();
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
									"SELECT * FROM CRG_CARGO ORDER BY CRG_ID");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			retorno.add(new Cargo(objCursor.getInt("CRG_ID"),
								  objCursor.getString("CRG_NOME"),
								  objCursor.getDouble("CRG_SALARIO")));
		}
		
		objBanco.desconectar();
		
		return retorno;
	}
	
	public int getProximoId() throws Exception {
		PreparedStatement objExecucao = null;
		ResultSet objCursor = null;
		int retorno = 0;
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
									"SELECT MAX(CRG_ID) FROM CRG_CARGO");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			retorno = objCursor.getInt(1);
		}
		retorno++;
		
		objBanco.desconectar();
		
		return retorno;
	}
	
	public void persistir(Cargo objCargo) throws Exception {
		PreparedStatement objExecucao = null;
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
									"INSERT INTO CRG_CARGO " +
									"(CRG_ID, CRG_NOME, CRG_SALARIO) " +
									"VALUES " +
									"(?, ?, ?)");
		objExecucao.setInt(1, getProximoId());
		objExecucao.setString(2, objCargo.getNome());
		objExecucao.setDouble(3, objCargo.getSalario());
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
}