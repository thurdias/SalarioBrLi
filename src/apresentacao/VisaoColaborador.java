package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.Cargo;

public class VisaoColaborador extends JInternalFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;

	private JPanel objPainel = new JPanel();
	
	private JLabel lblCargo = new JLabel("Cargo");
	private JComboBox<String> cboCargo = new JComboBox<String>();
	
	private JLabel lblNome = new JLabel("Nome");
	private JTextField txtNome = new JTextField();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	// Método construtor vazio da classe
	public VisaoColaborador() {
		// Configuração da janela
		super("Cadastro de Colaboradores", true, true, true, true);
		setSize(785, 540);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		// Configuração do painel
		objPainel.setLayout(null);
		setContentPane(objPainel);
		
		// Cargo
		lblCargo.setBounds(20, 20, 200, 20);
		objPainel.add(lblCargo);
		cboCargo.setBounds(20, 40, 400, 20);
		objPainel.add(cboCargo);
		cboCargo.addItem("");
		try {
			for (Cargo objCargo : Cargo.getTodos()) {
				cboCargo.addItem(objCargo.getNome());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		// Nome
		lblNome.setBounds(20, 60, 200, 20);
		objPainel.add(lblNome);
		txtNome.setBounds(20, 100, 400, 20);
		objPainel.add(txtNome);
		
		// Botões
		btnGravar.setBounds(450, 450, 100, 30);
		btnGravar.addActionListener(new ControladorGravarColaborador(cboCargo, txtNome));
		objPainel.add(btnGravar);
		
		btnLimpar.setBounds(550, 450, 100, 30);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboCargo.setSelectedIndex(0);
				txtNome.setText("");
			}
		});
		objPainel.add(btnLimpar);
		
		btnSair.setBounds(650, 450, 100, 30);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		objPainel.add(btnSair);
	}
}