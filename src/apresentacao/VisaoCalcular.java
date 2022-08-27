package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VisaoCalcular extends JInternalFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;

	private JPanel objPainel = new JPanel();
	
	private JLabel lblFolha = new JLabel("Folha de Pagamento");
	private JTextArea txtFolha = new JTextArea();
	private JScrollPane jspFolha = new JScrollPane(txtFolha);
	
	private JButton btnCalcular = new JButton("Calcular");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	// Método construtor vazio da classe
	public VisaoCalcular() {
		// Configuração da janela
		super("Cálculo da Folha de Pagamento", true, true, true, true);
		setSize(785, 540);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		// Configuração do painel
		objPainel.setLayout(null);
		setContentPane(objPainel);
		
		// Nome
		lblFolha.setBounds(20, 20, 200, 20);
		objPainel.add(lblFolha);
		jspFolha.setBounds(20, 40, 700, 300);
		objPainel.add(jspFolha);
		txtFolha.setLineWrap(true);
		
		// Botões
		btnCalcular.setBounds(450, 450, 100, 30);
		btnCalcular.addActionListener(new ControladorCalcularFolha(txtFolha));
		objPainel.add(btnCalcular);
		
		btnLimpar.setBounds(550, 450, 100, 30);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFolha.setText("");
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