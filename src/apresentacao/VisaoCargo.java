package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VisaoCargo extends JInternalFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;

	private JPanel objPainel = new JPanel();
	
	private JLabel lblNome = new JLabel("Nome");
	private JTextField txtNome = new JTextField();
	
	private JLabel lblSalario = new JLabel("Salário");
	private JTextField txtSalario = new JTextField();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	// Método construtor vazio da classe
	public VisaoCargo() {
		// Configuração da janela
		super("Cadastro de Cargos", true, true, true, true);
		setSize(785, 540);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		// Configuração do painel
		objPainel.setLayout(null);
		setContentPane(objPainel);
		
		// Nome
		lblNome.setBounds(20, 20, 200, 20);
		objPainel.add(lblNome);
		txtNome.setBounds(20, 40, 400, 20);
		objPainel.add(txtNome);
		
		// Salário
		lblSalario.setBounds(20, 80, 200, 20);
		objPainel.add(lblSalario);
		txtSalario.setBounds(20, 100, 100, 20);
		objPainel.add(txtSalario);
		
		// Botões
		btnGravar.setBounds(450, 450, 100, 30);
		btnGravar.addActionListener(new ControladorGravarCargo(txtNome, txtSalario));
		objPainel.add(btnGravar);
		
		btnLimpar.setBounds(550, 450, 100, 30);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtSalario.setText("");
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