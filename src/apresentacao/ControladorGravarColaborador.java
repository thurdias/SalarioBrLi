package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Cargo;
import negocio.Colaborador;

public class ControladorGravarColaborador implements ActionListener {
	// Propriedades da classe
	private JComboBox<String> cboCargo = null;
	private JTextField txtNome = null;
	
	// Método construtor cheio da classe
	public ControladorGravarColaborador(JComboBox<String> cboCargo, JTextField txtNome) {
		super();
		this.cboCargo = cboCargo;
		this.txtNome = txtNome;
	}

	// Método sobrescrito da interface
	public void actionPerformed(ActionEvent e) {
		// Críticas de dados
		if (cboCargo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Campo cargo obrigatório !");
			return;
		}
		if (txtNome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo nome obrigatório !");
			return;
		}
		
		// Composição do objeto
		Colaborador objColaborador = new Colaborador();
		objColaborador.setObjCargo(new Cargo(cboCargo.getSelectedIndex(), "", 0));
		objColaborador.setNome(txtNome.getText());
		
		try {
			objColaborador.persistir();
			JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso !");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}