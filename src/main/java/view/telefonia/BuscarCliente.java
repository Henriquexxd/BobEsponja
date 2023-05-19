package view.telefonia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.vo.telefonia.Endereco;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class BuscarCliente extends JFrame {
	private JTable table;
	private JButton btnBuscarTodos;
	private ArrayList<Endereco> enderecos;
	private String[] nomeColunas = {"#", "NOME", "CPF", "ENDERECO", "TotalTelefones"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarCliente frame = new BuscarCliente();
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
	public BuscarCliente() {
		setTitle("Buscar Endereço");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 408);
		getContentPane().setLayout(null);
		
		btnBuscarTodos = new JButton("Buscar Todos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuscarTodos.setBounds(251, 22, 106, 23);
		getContentPane().add(btnBuscarTodos);
		
		table = new JTable();
		table.setBounds(10, 71, 583, 262);
		getContentPane().add(table);
		
	}
}
