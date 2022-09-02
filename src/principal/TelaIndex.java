package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Casa;
import bean.Condominio;
import dao.CasaDAO;
import dao.CondominioDAO;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaIndex extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIndex frame = new TelaIndex();
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
	public TelaIndex() {
		
		CondominioDAO coDAO = new CondominioDAO();
		CasaDAO caDAO = new CasaDAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1360, 738);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Condominio", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 9, 153, 39);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alterar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(1152, 9, 153, 39);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Remover");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(615, 9, 153, 39);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(50, 112, 153, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(50, 212, 153, 30);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(50, 312, 153, 30);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(615, 112, 153, 30);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(1152, 112, 153, 30);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(1152, 212, 153, 30);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(1152, 312, 153, 30);
		panel.add(textField_6);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				int qntCasas = Integer.parseInt(textField_1.getText());
				String cidade = textField_2.getText();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				Condominio co = new Condominio(nome, qntCasas, cidade);
				int c = coDAO.Inserir(co);
				if (c > 0) {
					JOptionPane.showMessageDialog(null, "Condominio Cadastrado com Sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Condominio Não Cadastrado");
				}
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				((DefaultTableModel)table.getModel()).setRowCount(0);
				for (Condominio cod : coDAO.getLista()) {
					model.addRow(new Object[] {cod.getNome(), cod.getQntCasas(), cod.getCidade()});
				}
				
				DefaultTableModel model3 = (DefaultTableModel)table_2.getModel();
				((DefaultTableModel)table_2.getModel()).setRowCount(0);
			}
		});
		btnNewButton.setBounds(50, 372, 153, 30);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Alterar");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_4.getText();
				int qntCasas = Integer.parseInt(textField_5.getText());
				String cidade = textField_6.getText();
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				boolean achou = false;
				boolean espacoDisponivel = false;
				ArrayList<Condominio> condominios = coDAO.getLista();
				ArrayList<Casa> casas = caDAO.getListaCond(nome);
				int qntCasasCO = casas.size();
				for (Condominio co : condominios) {
					if (co.getNome().equals(nome)) {
						achou = true;
					}
				}
				if (qntCasas < qntCasasCO) {
					espacoDisponivel = false;
				}
				else {
					espacoDisponivel = true;
				}
				
				if (achou == true && espacoDisponivel == true) {
					coDAO.Alterar(nome, qntCasas, cidade);
					JOptionPane.showMessageDialog(null, "Condominio Alterado com Sucesso");
				} else if (!achou) {
					JOptionPane.showMessageDialog(null, "Condominio não Encontrado");
				} else {
					JOptionPane.showMessageDialog(null, "Caso alterado, irá ultrapassar o limite de casas!");
				}
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				((DefaultTableModel)table.getModel()).setRowCount(0);
				for (Condominio cod : coDAO.getLista()) {
					model.addRow(new Object[] {cod.getNome(), cod.getQntCasas(), cod.getCidade()});
				}
				
				DefaultTableModel model3 = (DefaultTableModel)table_2.getModel();
				((DefaultTableModel)table_2.getModel()).setRowCount(0);
			}
		});
		btnUpdate.setBounds(1152, 372, 153, 30);
		panel.add(btnUpdate);
		
		JButton btnDrop = new JButton("Remover");
		btnDrop.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_3.getText();
				textField_3.setText("");
				int c = coDAO.Remover(nome);
				if (c > 0) {
					JOptionPane.showMessageDialog(null, "Condominio Removido com Sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Condominio não Encontrado ou Impossivel Remover");
				}
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				((DefaultTableModel)table.getModel()).setRowCount(0);
				for (Condominio cod : coDAO.getLista()) {
					model.addRow(new Object[] {cod.getNome(), cod.getQntCasas(), cod.getCidade()});
				}
				
				DefaultTableModel model3 = (DefaultTableModel)table_2.getModel();
				((DefaultTableModel)table_2.getModel()).setRowCount(0);
			}
		});
		btnDrop.setBounds(615, 172, 153, 30);
		panel.add(btnDrop);
		
		JLabel lblNewLabel_3 = new JLabel("Nome");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(50, 92, 153, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantidade Casas");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(50, 192, 153, 21);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cidade");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(50, 292, 153, 20);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_2 = new JLabel("Nome");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2.setBounds(615, 92, 153, 20);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Nome");
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_2_1.setBounds(1152, 92, 153, 20);
		panel.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Quantidade Casas");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(1152, 192, 153, 21);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Cidade");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(1152, 292, 153, 20);
		panel.add(lblNewLabel_5_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		tabbedPane.addTab("Casa", null, panel_4, null);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_14.setColumns(10);
		textField_14.setBounds(50, 112, 153, 30);
		panel_4.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_15.setColumns(10);
		textField_15.setBounds(50, 212, 153, 30);
		panel_4.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_16.setColumns(10);
		textField_16.setBounds(50, 312, 153, 30);
		panel_4.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_17.setColumns(10);
		textField_17.setBounds(615, 112, 153, 30);
		panel_4.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_18.setColumns(10);
		textField_18.setBounds(1152, 112, 153, 30);
		panel_4.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_19.setColumns(10);
		textField_19.setBounds(1152, 212, 153, 30);
		panel_4.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_20.setColumns(10);
		textField_20.setBounds(1152, 312, 153, 30);
		panel_4.add(textField_20);
		
		JButton btnNewButton_2 = new JButton("Adicionar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero = Integer.parseInt(textField_14.getText());
				String proprietario = textField_15.getText();
				String condominio = textField_16.getText();
				boolean achou = false;
				boolean espacoDisponivel = false;
				int qntCasasAdd = 0;
				textField_14.setText("");
				textField_15.setText("");
				textField_16.setText("");
				ArrayList<Condominio> condominios = coDAO.getLista();
				ArrayList<Casa> casas = caDAO.getLista();
				for (Condominio co : condominios) {
					if (co.getNome().equals(condominio)) {
						achou = true;
						for (Casa ca : casas) {
							if (ca.getNomeCondominio().equals(co.getNome())) {
								qntCasasAdd++;
								System.out.println(qntCasasAdd);
							}
						}
						if (qntCasasAdd >= co.getQntCasas()) {
							espacoDisponivel = false;
						}
						else {
							espacoDisponivel = true;
						}
					}
				}
				if (achou == true && espacoDisponivel == true) {
					Casa c = new Casa(numero, proprietario, condominio);
					int co = caDAO.inserir(c);
					if (co > 0) {
						JOptionPane.showMessageDialog(null, "Casa Cadastrada com Sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Casa Não Cadastrada");
					}
					
					
				} else if (!achou) {
					JOptionPane.showMessageDialog(null, "Condominio citado não cadastrado");
				} else {
					JOptionPane.showMessageDialog(null, "Condominio já está no seu Limite de Casas!");
				}
				
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				((DefaultTableModel)table_1.getModel()).setRowCount(0);
				for (Casa cas : caDAO.getLista()) {
					model.addRow(new Object[] {cas.getNumeroCasa(), cas.getProprietario(), cas.getNomeCondominio()});
				}
				
				DefaultTableModel model3 = (DefaultTableModel)table_2.getModel();
				((DefaultTableModel)table_2.getModel()).setRowCount(0);
			}
		});
		btnNewButton_2.setBounds(50, 372, 153, 30);
		panel_4.add(btnNewButton_2);
		
		JButton btnUpdate_2 = new JButton("Alterar");
		btnUpdate_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 18, 19, 20
				int numero = Integer.parseInt(textField_18.getText());
				String proprietario = textField_19.getText();
				String condominio = textField_20.getText();
				textField_18.setText("");
				textField_19.setText("");
				textField_20.setText("");
				boolean achou = false;
				boolean espacoDisponivel = false;
				int qntCasas = caDAO.getListaCond(condominio).size();
				ArrayList<Condominio> condominios = coDAO.getLista();
				for (Condominio co : condominios) {
					if (co.getNome().equals(condominio)) {
						achou = true;
						if (qntCasas >= co.getQntCasas()) {
							espacoDisponivel = false;
						}
						else {
							espacoDisponivel = true;
						}
					}
				}
				if (achou == true && espacoDisponivel == true) {
					caDAO.Alterar(numero, proprietario, condominio);
					JOptionPane.showMessageDialog(null, "Casa Alterada com Sucesso");
				}
				else if (!achou) {
					JOptionPane.showMessageDialog(null, "Casa não Encontrada");
				} else {
					JOptionPane.showMessageDialog(null, "Impossivel Alterar, irá passar do maximo de casas do condominio");
				}
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				((DefaultTableModel)table_1.getModel()).setRowCount(0);
				for (Casa cas : caDAO.getLista()) {
					model.addRow(new Object[] {cas.getNumeroCasa(), cas.getProprietario(), cas.getNomeCondominio()});
				}
				
				DefaultTableModel model3 = (DefaultTableModel)table_2.getModel();
				((DefaultTableModel)table_2.getModel()).setRowCount(0);
			}
		});
		btnUpdate_2.setBounds(1152, 372, 153, 30);
		panel_4.add(btnUpdate_2);
		
		JButton btnDrop_2 = new JButton("Remover");
		btnDrop_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDrop_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numero = Integer.parseInt(textField_17.getText());
				textField_17.setText("");
				int removeu = caDAO.Remover(numero);
				if (removeu > 0) {
					JOptionPane.showMessageDialog(null, "Casa removida com sucesso");
				}
				else {
					JOptionPane.showMessageDialog(null, "Casa não Encontrada");
				}
				
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				((DefaultTableModel)table_1.getModel()).setRowCount(0);
				for (Casa cas : caDAO.getLista()) {
					model.addRow(new Object[] {cas.getNumeroCasa(), cas.getProprietario(), cas.getNomeCondominio()});
				}
				
				DefaultTableModel model3 = (DefaultTableModel)table_2.getModel();
				((DefaultTableModel)table_2.getModel()).setRowCount(0);
			}
		});
		btnDrop_2.setBounds(615, 172, 153, 30);
		panel_4.add(btnDrop_2);
		
		JLabel lblNewLabel_7 = new JLabel("Adicionar");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_7.setBounds(50, 9, 153, 39);
		panel_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3_1 = new JLabel("Numero");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(50, 92, 153, 20);
		panel_4.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("Propriet\u00E1rio");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_3.setBounds(50, 192, 153, 20);
		panel_4.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Nome Condominio");
		lblNewLabel_3_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_3_1.setBounds(50, 292, 153, 20);
		panel_4.add(lblNewLabel_3_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Remover");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_2_1.setBounds(615, 9, 153, 39);
		panel_4.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Numero");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBounds(615, 92, 153, 20);
		panel_4.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Alterar");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_1.setBounds(1152, 9, 153, 39);
		panel_4.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Numero");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1.setBounds(1152, 92, 153, 20);
		panel_4.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_3_2 = new JLabel("Propriet\u00E1rio");
		lblNewLabel_3_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_3_2.setBounds(1152, 192, 153, 20);
		panel_4.add(lblNewLabel_3_3_2);
		
		JLabel lblNewLabel_3_3_1_1 = new JLabel("Nome Condominio");
		lblNewLabel_3_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_3_1_1.setBounds(1152, 292, 153, 20);
		panel_4.add(lblNewLabel_3_3_1_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("ShowCase", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 84, 400, 400);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "qntCasas", "Cidade"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("Condominios");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(67, 2, 400, 84);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Casas");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setBounds(888, 2, 400, 84);
		panel_3.add(lblNewLabel_6_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(888, 84, 400, 400);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_1.setEnabled(false);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Proprietario", "Condominio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table_1.getModel();
				((DefaultTableModel)table_1.getModel()).setRowCount(0);
				for (Casa cas : caDAO.getLista()) {
					model.addRow(new Object[] {cas.getNumeroCasa(), cas.getProprietario(), cas.getNomeCondominio()});
				}
				
				DefaultTableModel model2 = (DefaultTableModel)table.getModel();
				((DefaultTableModel)table.getModel()).setRowCount(0);
				for (Condominio cod : coDAO.getLista()) {
					model2.addRow(new Object[] {cod.getNome(), cod.getQntCasas(), cod.getCidade()});
				}
				
				DefaultTableModel model3 = (DefaultTableModel)table_2.getModel();
				((DefaultTableModel)table_2.getModel()).setRowCount(0);
				for (Casa cass : caDAO.getListaCond(textField_7.getText())){
					model3.addRow(new Object[] {cass.getNumeroCasa(), cass.getProprietario()});
				}
				textField_7.setText("");
			}
		});
		btnNewButton_1.setBounds(607, 530, 150, 75);
		panel_3.add(btnNewButton_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(477, 84, 400, 400);
		panel_3.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Proprietario"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("Pesquisa");
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_6_2.setBounds(478, 2, 400, 34);
		panel_3.add(lblNewLabel_6_2);
		
		textField_7 = new JTextField();
		textField_7.setBounds(617, 47, 125, 30);
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		((DefaultTableModel)table_1.getModel()).setRowCount(0);
		for (Casa cas : caDAO.getLista()) {
			model.addRow(new Object[] {cas.getNumeroCasa(), cas.getProprietario(), cas.getNomeCondominio()});
		}
		
		DefaultTableModel model2 = (DefaultTableModel)table.getModel();
		((DefaultTableModel)table.getModel()).setRowCount(0);
		for (Condominio cod : coDAO.getLista()) {
			model2.addRow(new Object[] {cod.getNome(), cod.getQntCasas(), cod.getCidade()});
		}
	}
}
