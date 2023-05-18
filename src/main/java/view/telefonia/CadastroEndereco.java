package view.telefonia;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.EnderecoController;
import model.vo.telefonia.Endereco;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		lblCep = new JLabel("Cep:");
		frmCadastroDeEndereo.getContentPane().add(lblCep, "4, 4");
		try {
			//definicao da mascara
			mascaraCep = new MaskFormatter("####-####");
			//ajuste para devolver somente os numeros digitados
			mascaraCep.setValueContainsLiteralCharacters(false);
		} catch(ParseException e) {
			JOptionPane.showMessageDialog(null,"Erro ao criar Máscara de Cep");
		}
		
		formattedTextFieldCep = new JFormattedTextField(mascaraCep);
		frmCadastroDeEndereo.getContentPane().add(formattedTextFieldCep, "6, 4, fill, default");
		
		lblRua = new JLabel("Rua:");
		frmCadastroDeEndereo.getContentPane().add(lblRua, "4, 6");
		
		textFieldRua = new JTextField();
		frmCadastroDeEndereo.getContentPane().add(textFieldRua, "6, 6, fill, default");
		textFieldRua.setColumns(10);
		
		lblNumero = new JLabel("Número:");
		frmCadastroDeEndereo.getContentPane().add(lblNumero, "4, 8, left, default");
		
		textFieldNumero = new JTextField();
		frmCadastroDeEndereo.getContentPane().add(textFieldNumero, "6, 8, fill, default");
		textFieldNumero.setColumns(10);
		
		lblBairro = new JLabel("Bairro:");
		frmCadastroDeEndereo.getContentPane().add(lblBairro, "4, 10, left, default");
		
		textFieldBairro = new JTextField();
		frmCadastroDeEndereo.getContentPane().add(textFieldBairro, "6, 10, fill, default");
		textFieldBairro.setColumns(10);
		
		lblMunicpio = new JLabel("Município");
		frmCadastroDeEndereo.getContentPane().add(lblMunicpio, "4, 12, left, default");
		
		textFieldMunicipio = new JTextField();
		frmCadastroDeEndereo.getContentPane().add(textFieldMunicipio, "6, 12, fill, default");
		textFieldMunicipio.setColumns(10);
		
		lblEstado = new JLabel("Estado:");
		frmCadastroDeEndereo.getContentPane().add(lblEstado, "4, 14, left, default");
		
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
		frmCadastroDeEndereo.getContentPane().add(btnSalvar, "2, 18, 5, 1");
	}

}
