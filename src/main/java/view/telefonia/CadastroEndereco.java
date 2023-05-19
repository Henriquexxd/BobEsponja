package view.telefonia;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.EnderecoController;
import model.vo.telefonia.Endereco;

public class CadastroEndereco {

	private JFrame frmCadastroDeEndereo;
	private MaskFormatter mascaraCep;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldMunicipio;
	private JTextField textFieldEstado;
	private JFormattedTextField formattedTextFieldCep;
	private Component lblRua;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblMunicpio;
	private JLabel lblEstado;
	private JButton btnSalvar;
	private JLabel lblCep;
	
	//Objeto usado paraarmazenar o endero que sera criado ou editado
	private Endereco endereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroEndereco window = new CadastroEndereco();
					window.frmCadastroDeEndereo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CadastroEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeEndereo = new JFrame();
		frmCadastroDeEndereo.getContentPane().setBackground(new Color(179, 181, 253));
		frmCadastroDeEndereo.setTitle("Cadastro de Endereço");
		frmCadastroDeEndereo.setBounds(100, 100, 450, 300);
		frmCadastroDeEndereo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeEndereo.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(19dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(40dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		try {
			//definicao da mascara
			mascaraCep = new MaskFormatter("####-####");
			//ajuste para devolver somente os numeros digitados
			mascaraCep.setValueContainsLiteralCharacters(false);
		} catch(ParseException e) {
			JOptionPane.showMessageDialog(null,"Erro ao criar Máscara de Cep");
		}
		
		lblCep = new JLabel("Cep:");
		frmCadastroDeEndereo.getContentPane().add(lblCep, "2, 4, 3, 1");
		
		formattedTextFieldCep = new JFormattedTextField(mascaraCep);
		frmCadastroDeEndereo.getContentPane().add(formattedTextFieldCep, "6, 4, fill, default");
		
		lblRua = new JLabel("Rua:");
		frmCadastroDeEndereo.getContentPane().add(lblRua, "2, 6, 3, 1");
		
		textFieldRua = new JTextField();
		frmCadastroDeEndereo.getContentPane().add(textFieldRua, "6, 6, fill, default");
		textFieldRua.setColumns(10);
		
		lblNumero = new JLabel("Número:");
		frmCadastroDeEndereo.getContentPane().add(lblNumero, "2, 8, 3, 1, left, default");
		
		textFieldNumero = new JTextField();
		frmCadastroDeEndereo.getContentPane().add(textFieldNumero, "6, 8, fill, default");
		textFieldNumero.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		frmCadastroDeEndereo.getContentPane().add(lblBairro, "2, 10, 3, 1, left, default");
		
		textFieldBairro = new JTextField();
		frmCadastroDeEndereo.getContentPane().add(textFieldBairro, "6, 10, fill, default");
		textFieldBairro.setColumns(10);
		
		lblMunicpio = new JLabel("Município");
		frmCadastroDeEndereo.getContentPane().add(lblMunicpio, "2, 12, 3, 1, left, default");
		
		textFieldMunicipio = new JTextField();
		frmCadastroDeEndereo.getContentPane().add(textFieldMunicipio, "6, 12, fill, default");
		textFieldMunicipio.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		frmCadastroDeEndereo.getContentPane().add(lblEstado, "2, 14, 3, 1, left, default");
		
		textFieldEstado = new JTextField();
		frmCadastroDeEndereo.getContentPane().add(textFieldEstado, "6, 14, fill, default");
		textFieldEstado.setColumns(10);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				endereco = new Endereco(); 
				
				endereco.setCep(formattedTextFieldCep.getText());
				endereco.setRua(textFieldRua.getText());
				endereco.setNumero(textFieldNumero.getText());
				endereco.setCidade(textFieldMunicipio.getText());
				endereco.setEstado(textFieldEstado.getText());
				endereco.setBairro(textFieldBairro.getText());
				
				EnderecoController controller = new EnderecoController();
				
								
			}
		});
		frmCadastroDeEndereo.getContentPane().add(btnSalvar, "1, 18, 6, 1");
	}

}
