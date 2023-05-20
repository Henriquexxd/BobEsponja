package view.telefonia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.ClienteController;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class TelaBuscarClientes extends JFrame {
	private JTable tblClientes;
	private JButton btnBuscarTodos;
	private	ClienteController controller = new ClienteController();
	
	//Lista para armazenar os clientes consultados no banco
	private ArrayList<Cliente> clientes;
	private String[] nomeColunas = {"#", "NOME", "CPF", "ENDERECO", "TotalTelefones"};
	
	// Metodos usado no Jtable
	private void limparTabela() {
		tblClientes.setModel(new DefaultTableModel(new Object[][] {nomeColunas,}, nomeColunas));
		clientes = (ArrayList<Cliente>) controller.consultarTodos();
	}
	
	//Chamado sempre no Botao BuscarTodos
	private void atualizarTabelaClientes() {
		this.limparTabela();
		
		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
		//Preenche os valores na tabela linha a linha
		
		for(Cliente c : clientes) {
			Object[] novaLinhaDaTabela = new Object[5];
			novaLinhaDaTabela[0] = c.getId();
			novaLinhaDaTabela[1] = c.getNome();
			novaLinhaDaTabela[2] = c.getCpf();
			novaLinhaDaTabela[3] = c.getEndereco();
			novaLinhaDaTabela[4] = c.getTelefones();
			
			model.addRow(novaLinhaDaTabela);
		}
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarClientes frame = new TelaBuscarClientes();
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
	public TelaBuscarClientes() {
		setTitle("Buscar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 408);
		getContentPane().setLayout(null);
		
		btnBuscarTodos = new JButton("BUSCAR CLIENTES ");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuscarTodos.setBounds(229, 22, 142, 23);
		getContentPane().add(btnBuscarTodos);
		
		tblClientes = new JTable();
		tblClientes.setBounds(10, 71, 583, 262);
		getContentPane().add(tblClientes);
		
	}
}
