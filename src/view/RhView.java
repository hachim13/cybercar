package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import service.EmployeService;

public class RhView extends JFrame  {

	private JTextField txtPrenom;
	private JTextField txtAndecedant;
	private JTextField txtAdresse;
	private JTextField txtDateNaiss;
	private JTextField txtNom;
	private JTextField txtSalaire;
	private JTextField txtEmail;
	private JTextField txtNumEmploye;
	private JTextField txtStatut;
	private JComboBox cbxPoste;
	private JComboBox cbxDept;
	DefaultTableModel model;
	String[]Departement = {"Administration", "Ventes", "Comptabilit�", "Ressources humaines"};
    String[]Poste = {"Recruteur", "Vendeur", "Comptable", "Administrateur"};
    private JTextField txtDebutConge;
    private JTextField txtTelephone;
    private JTextField txtFinContrat;
    private JTextField txtDateEmbauche;
    private JTextField txtFinConge;
    private JTable table;
	private JPanel contentPane;
	private EmployeService employeService;
    private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RhView frame = new RhView();
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

	public RhView() {
		buttonGroup = new ButtonGroup();
		table = new JTable();
		
		creationInterface();
		employeService = new EmployeService(table);
		employeService.toutAfficher();
		
	}
	
	
	private void creationInterface() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 766);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 7));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue dans RH");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(494, 11, 282, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 77, 70, 22);
		panel.add(lblNewLabel_1);
		
		txtPrenom = new JTextField();
		txtPrenom.setBounds(153, 104, 241, 20);
		panel.add(txtPrenom);
		txtPrenom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 110, 85, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 164, 70, 14);
		panel.add(lblNewLabel_3);
		
		txtAndecedant = new JTextField();
		txtAndecedant.setBounds(899, 163, 159, 20);
		panel.add(txtAndecedant);
		txtAndecedant.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("D_Naissance :");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(10, 284, 118, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Adresse :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 189, 85, 24);
		panel.add(lblNewLabel_5);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(153, 193, 241, 20);
		panel.add(txtAdresse);
		txtAdresse.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Telephone :");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(713, 219, 96, 14);
		panel.add(lblNewLabel_6);
		
		txtDateNaiss = new JTextField();
		txtDateNaiss.setBounds(153, 278, 241, 20);
		panel.add(txtDateNaiss);
		txtDateNaiss.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Poste :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(10, 232, 63, 14);
		panel.add(lblNewLabel_7);
		
		txtNom = new JTextField();
		txtNom.setBounds(153, 74, 241, 23);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Num_Employe :");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(10, 47, 137, 14);
		panel.add(lblNewLabel_8);
		
		txtSalaire = new JTextField();
		txtSalaire.setBounds(899, 194, 159, 20);
		panel.add(txtSalaire);
		txtSalaire.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Sexe :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setBounds(10, 139, 56, 14);
		panel.add(lblNewLabel_9);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(153, 159, 241, 24);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("S.Conjugale :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(713, 244, 115, 22);
		panel.add(lblNewLabel_10);
		
		txtNumEmploye = new JTextField();
		txtNumEmploye.setBounds(153, 42, 241, 24);
		panel.add(txtNumEmploye);
		txtNumEmploye.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Salaire :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setBounds(713, 194, 85, 14);
		panel.add(lblNewLabel_11);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBackground(Color.GREEN);
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnEnregistrer.setBounds(68, 324, 141, 43);
		panel.add(btnEnregistrer);
		
		
		
		
		JButton btnModifier = new JButton("Modifier");
		
		btnModifier.setBackground(Color.CYAN);
		btnModifier.setToolTipText("");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnModifier.setBounds(287, 324, 147, 43);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(Color.RED);
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnSupprimer.setBounds(537, 324, 129, 43);
		panel.add(btnSupprimer);
		
		JButton btnEffacer = new JButton("Effacer la selection");
		btnEffacer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnEffacer.setBounds(778, 324, 237, 43);
		btnEffacer.setVisible(false);
		panel.add(btnEffacer);
		
		txtStatut = new JTextField();
		txtStatut.setBounds(899, 247, 159, 20);
		panel.add(txtStatut);
		txtStatut.setColumns(10);
		
		JRadioButton rbtBtnMale = new JRadioButton("M.");
		rbtBtnMale.setFont(new Font("Tahoma", Font.BOLD, 16));
		rbtBtnMale.setBounds(185, 131, 57, 23);
		panel.add(rbtBtnMale);
		
		JRadioButton rbtBtnFemale = new JRadioButton("Mme");
		rbtBtnFemale.setFont(new Font("Tahoma", Font.BOLD, 16));
		rbtBtnFemale.setBounds(287, 131, 70, 23);
		panel.add(rbtBtnFemale);
		
		// ajout des bouttons dans le groupe
		buttonGroup.add(rbtBtnMale);
		buttonGroup.add(rbtBtnFemale);
		
		rbtBtnMale.setSelected(true);
		
		cbxPoste = new JComboBox<Object>(Poste);
		cbxPoste.setBounds(153, 224, 241, 22);
		panel.add(cbxPoste);
		
		
		
		cbxDept = new JComboBox<Object>(Departement);
		cbxDept.setBounds(153, 251, 241, 22);
		panel.add(cbxDept);
		
		JLabel lblNewLabel_12 = new JLabel("D\u00E9partement :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setBounds(10, 259, 129, 14);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("D\u00E9but cong\u00E9 :");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_13.setBounds(713, 47, 129, 14);
		panel.add(lblNewLabel_13);
		
		
		JLabel lblNewLabel_14 = new JLabel("Fin cong\u00E9 :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_14.setBounds(713, 77, 105, 17);
		panel.add(lblNewLabel_14);
		
		
		
		JLabel lblNewLabel_15 = new JLabel("Date d'embauche :");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_15.setBounds(713, 105, 154, 14);
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Fin de contrat :");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_16.setBounds(713, 139, 187, 14);
		panel.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Ant\u00E9c\u00E9dant m\u00E9dical :");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_17.setBounds(713, 164, 187, 14);
		panel.add(lblNewLabel_17);
		
		txtDebutConge = new JTextField();
		txtDebutConge.setBounds(899, 46, 159, 20);
		panel.add(txtDebutConge);
		txtDebutConge.setColumns(10);
		
		txtTelephone = new JTextField();
		txtTelephone.setBounds(899, 218, 159, 20);
		panel.add(txtTelephone);
		txtTelephone.setColumns(10);
		
		txtFinContrat = new JTextField();
		txtFinContrat.setBounds(899, 138, 159, 20);
		panel.add(txtFinContrat);
		txtFinContrat.setColumns(10);
		
		txtDateEmbauche = new JTextField();
		txtDateEmbauche.setBounds(899, 104, 159, 20);
		panel.add(txtDateEmbauche);
		txtDateEmbauche.setColumns(10);
		
		txtFinConge = new JTextField();
		txtFinConge.setBounds(899, 77, 159, 20);
		panel.add(txtFinConge);
		txtFinConge.setColumns(10);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num_Employ\u00E9", "Nom", "Pr\u00E9nom", "Sexe", "Email", "Adresse", "Telephone", "Poste", "Departement"
			}
		) {
			boolean[] canEdit = new boolean[] {
					false,false,false,false,false,false,false,false,false
			};
			public 	boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		table.setCellSelectionEnabled(true);
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		table.setBounds(10, 461, 1048, 218);
		panel.add(table);
		
		

		// Action a faire quand on clique sur le button ajouter
		btnEnregistrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(verifierChamps()) {
					JRadioButton selectedButton;

					if (rbtBtnMale.isSelected()) {
					    selectedButton = rbtBtnMale;
					}else {
					    selectedButton = rbtBtnFemale;
					}
					
					try {
						employeService.ajouter(txtNumEmploye.getText(), txtNom.getText(), txtPrenom.getText(), selectedButton.getText(), txtEmail.getText(), txtAdresse.getText(), 
								cbxPoste.getSelectedItem().toString(), cbxDept.getSelectedItem().toString(), txtDateNaiss.getText(), txtDebutConge.getText(), txtFinConge.getText(), 
								txtDateEmbauche.getText(), txtFinContrat.getText(), txtAndecedant.getText(), txtSalaire.getText(), txtTelephone.getText(), txtStatut.getText());
						viderChamps();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Veillez remplir tous les champs!");
				}
			}
		});
		//Cette action permet de remettre les deonnes dans le formulaire apres avoir cliquer sur un employe du tableau
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				
				btnEffacer.setVisible(true);
				txtNumEmploye.setEnabled(false);
				TableModel model = table.getModel();
		        txtNom.setText(model.getValueAt(i, 1).toString());
		        txtPrenom.setText(model.getValueAt(i, 2).toString());
		        txtEmail.setText(model.getValueAt(i, 3).toString());
		        if(model.getValueAt(i, 4).toString().equals(rbtBtnMale.getText())) {
			        rbtBtnMale.setSelected(true);
		        } else {
		        	rbtBtnFemale.setSelected(true);
		        }
		        cbxPoste.setSelectedItem(model.getValueAt(i, 5).toString());
		        cbxDept.setSelectedItem(model.getValueAt(i, 6).toString());
		        txtSalaire.setText(model.getValueAt(i, 7).toString());
		        txtTelephone.setText(model.getValueAt(i, 8).toString());
		        txtNumEmploye.setText(model.getValueAt(i, 9).toString());
		        txtDateNaiss.setText(model.getValueAt(i, 10).toString());
		        txtAdresse.setText(model.getValueAt(i, 11).toString());
		        txtStatut.setText(model.getValueAt(i, 12).toString());
		        txtDebutConge.setText(model.getValueAt(i, 13).toString());
		        txtFinConge.setText(model.getValueAt(i, 14).toString());
		        txtDateEmbauche.setText(model.getValueAt(i, 15).toString());
		        txtFinContrat.setText(model.getValueAt(i, 16).toString());
		        txtAndecedant.setText(model.getValueAt(i, 17).toString());
			
			}
		});
		
		//Quand on modifie 
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(verifierChamps()) {
					JRadioButton selectedButton;

					if (rbtBtnMale.isSelected()) {
					    selectedButton = rbtBtnMale;
					}else {
					    selectedButton = rbtBtnFemale;
					}
					
					employeService.modifEmploye(txtNumEmploye.getText(), txtNom.getText(), txtPrenom.getText(), selectedButton.getText(), txtEmail.getText(), txtAdresse.getText(), 
							cbxPoste.getSelectedItem().toString(), cbxDept.getSelectedItem().toString(), txtDateNaiss.getText(), txtDebutConge.getText(), txtFinConge.getText(), 
							txtDateEmbauche.getText(), txtFinContrat.getText(), txtAndecedant.getText(), txtSalaire.getText(), txtTelephone.getText(), txtStatut.getText());
					viderChamps();
				}else {
					JOptionPane.showMessageDialog(null, "Veillez remplir tous les champs!");
				}
			}
		});
		
		
		//Quand on clique sur le boutton supprimer
		btnSupprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				employeService.supprEmploye(txtNumEmploye.getText());
				viderChamps();
			}
		});
		
		// Quand on annule la selection
		btnEffacer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viderChamps();
				txtNumEmploye.setEnabled(true);
				btnEffacer.setVisible(false);
				
			}
		});
	}
	
	private boolean verifierChamps() {
		if(txtNumEmploye.getText().equals("") || txtNom.getText().equals("") || txtPrenom.getText().equals("") || txtEmail.getText().equals("") || txtAdresse.getText().equals("")
			|| txtDateNaiss.getText().equals("")  || txtDebutConge.getText().equals("")  || txtFinConge.getText().equals("")  || txtDateEmbauche.getText().equals("") || txtFinContrat.getText().equals("")
			|| txtAndecedant.getText().equals("") || txtSalaire.getText().equals("") || txtTelephone.getText().equals("") || txtStatut.getText().equals("")) {
			return false;
		}else {
			return true;
		}
	}
	
	private void viderChamps() {
		txtAdresse.setText("");
		txtAndecedant.setText("");
		txtDateEmbauche.setText("");
		txtDateNaiss.setText("");
		txtDebutConge.setText("");
		txtEmail.setText("");
		txtFinConge.setText("");
		txtFinContrat.setText("");
		txtNom.setText("");
		txtNumEmploye.setText("");
		txtPrenom.setText("");
		txtSalaire.setText("");
		txtStatut.setText("");
		txtTelephone.setText("");
		buttonGroup.clearSelection();
	}
	
	
}
