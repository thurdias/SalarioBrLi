package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import negocio.FolhaDePagamento;

public class ControladorCalcularFolha implements ActionListener {
	// Propriedades da classe
	private JTextArea txtFolha = null;
	
	// Método construtor cheio da classe
	public ControladorCalcularFolha(JTextArea txtFolha) {
		super();
		this.txtFolha = txtFolha;
	}

	// Método sobrescrito da interface
	public void actionPerformed(ActionEvent e) {
		FolhaDePagamento objFolha = new FolhaDePagamento();
		
		try {
			txtFolha.setText(objFolha.calcular());
			JOptionPane.showMessageDialog(null, "Folha calculada com sucesso !");
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}