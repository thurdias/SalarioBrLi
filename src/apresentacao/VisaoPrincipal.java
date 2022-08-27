package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VisaoPrincipal extends JFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	
	private JDesktopPane jdpRepositorio = new JDesktopPane();
	
	private JMenuBar barraDeMenu = new JMenuBar();
	
	private JMenu mnuCadastros = new JMenu("Cadastros");
	JMenuItem mniCargos = new JMenuItem("Cargos");
	JMenuItem mniColaboradores = new JMenuItem("Colaboradores");
	JMenuItem mniSair = new JMenuItem("Sair");
	
	private JMenu mnuFolhaDePagamento = new JMenu("Folha de Pagamento");
	JMenuItem mniCalcular = new JMenuItem("Calcular");
	
	// Método principal de execução do sistema
	public static void main(String[] args) {
		new VisaoPrincipal().setVisible(true);
	}
	
	// Método construtor vazio da classe
	public VisaoPrincipal() {
		// Configuração da janela
		setTitle("Sistema de Folha de Pagamento");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Configuração do repositório de janelas
		setContentPane(jdpRepositorio);
		
		// Configuração do menu
		setJMenuBar(barraDeMenu);
		
		barraDeMenu.add(mnuCadastros);
		barraDeMenu.add(mnuFolhaDePagamento);
		
		mnuCadastros.add(mniCargos);
		mnuCadastros.add(mniColaboradores);
		mnuCadastros.addSeparator();
		mnuCadastros.add(mniSair);
		
		mnuFolhaDePagamento.add(mniCalcular);

		mniCargos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoCargo janela = new VisaoCargo();
				jdpRepositorio.add(janela);
				janela.setVisible(true);
			}
		});
		
		mniColaboradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoColaborador janela = new VisaoColaborador();
				jdpRepositorio.add(janela);
				janela.setVisible(true);
			}
		});
		
		mniCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoCalcular janela = new VisaoCalcular();
				jdpRepositorio.add(janela);
				janela.setVisible(true);
			}
		});
		
		mniSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}