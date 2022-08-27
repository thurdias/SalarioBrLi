package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Cargo;

public class ControladorGravarCargo implements ActionListener {
	// Propriedades da classe
	private JTextField txtNome = null;
	private JTextField txtSalario = null;
	
	// Método construtor cheio da classe
	public ControladorGravarCargo(JTextField txtNome, JTextField txtSalario) {
		super();
		this.txtNome = txtNome;
		this.txtSalario = txtSalario;
	}

	// Método sobrescrito da interface
	public void actionPerformed(ActionEvent e) {
		// Críticas de dados
		if (txtNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo nome obrigatório !");
			return;
		}
		if (txtSalario.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo salário obrigatório !");
			return;
		}
		try {
			Double.parseDouble(txtSalario.getText());
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Campo salário deve ser numérico !");
			return;
		}
		
		// Composição do objeto
		Cargo objCargo = new Cargo();
		objCargo.setNome(txtNome.getText());
		objCargo.setSalario(Double.parseDouble(txtSalario.getText()));
		
		try {
			objCargo.persistir();
			JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso !");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}