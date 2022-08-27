package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import negocio.Cargo;
import negocio.Colaborador;

public class ColaboradorDAO {
	// Propriedades da classe
	BancoDeDados objBanco = new BancoDeDados();
	
	// Métodos da classe
	public Collection<Colaborador> getTodos() throws Exception {
		PreparedStatement objExecucao = null;
		ResultSet objCursor = null;
		ArrayList<Colaborador> retorno = new ArrayList<Colaborador>();
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
									"SELECT * " +
									"FROM COL_COLABORADOR, CRG_CARGO " +
									"WHERE COL_IDCARGO = CRG_ID " +
									"ORDER BY COL_NOME");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			retorno.add(new Colaborador(objCursor.getInt("COL_ID"),
								  		new Cargo(objCursor.getInt("CRG_ID"),
								  				  objCursor.getString("CRG_NOME"),
								  				  objCursor.getDouble("CRG_SALARIO")),
								  		objCursor.getString("COL_NOME")));
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
									"SELECT MAX(COL_ID) FROM COL_COLABORADOR");
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			retorno = objCursor.getInt(1);
		}
		retorno++;
		
		objBanco.desconectar();
		
		return retorno;
	}
	
	public void persistir(Colaborador objColaborador) throws Exception {
		PreparedStatement objExecucao = null;
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
									"INSERT INTO COL_COLABORADOR " +
									"(COL_ID, COL_IDCARGO, COL_NOME) " +
									"VALUES " +
									"(?, ?, ?)");
		objExecucao.setInt(1, getProximoId());
		objExecucao.setInt(2, objColaborador.getObjCargo().getId());
		objExecucao.setString(3, objColaborador.getNome());
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
}