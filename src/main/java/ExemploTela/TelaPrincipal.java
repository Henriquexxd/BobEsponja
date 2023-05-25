package ExemploTela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private PainelCadastroCliente painelCadastroCliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCliente = new JMenu("Menu Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		mntmCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				painelCadastroCliente = new PainelCadastroCliente();
				
				
			}
		});
		
		mnCliente.add(mntmCadastrarCliente);
		
		JMenuItem mntmListagemCliente = new JMenuItem("Listagem Cliente");
		mntmListagemCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				painelListagemCliente = new PainelListagemCliente();
			}
		});
		mnCliente.add(mntmListagemCliente);
		
		JMenu mnEndereco = new JMenu("Menu Endereço");
		menuBar.add(mnEndereco);
		
		JMenuItem mntmCadastrarEndereco = new JMenuItem("Cadastrar Endereço");
		mnEndereco.add(mntmCadastrarEndereco);
		
		JMenuItem mntmListagemEndereco = new JMenuItem("Listagem Endereço");
		mnEndereco.add(mntmListagemEndereco);
		
		JMenu mnNewMenu_1 = new JMenu("Menu Telefone");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmCadastrarTelefone = new JMenuItem("Cadastrar Telefone");
		mnNewMenu_1.add(mntmCadastrarTelefone);
		
		JMenuItem mntmListagemTelefone = new JMenuItem("Listagem Telefone");
		mnNewMenu_1.add(mntmListagemTelefone);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
