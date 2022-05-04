package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import bd.BdConnexion;
import utils.Utils;


public class EmployeService {

	static Connection conn;
	static JTable table;
	
	public EmployeService() {
		conn = BdConnexion.getConnect();
	}
	
	public EmployeService(JTable newTable) {
		conn = BdConnexion.getConnect();
		table = newTable;
	}
	
	public void toutAfficher() {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM employe";
	        java.sql.Statement stmt = conn.createStatement();
			java.sql.ResultSet RS = stmt.executeQuery(sql);
			table.setModel(Utils.resultSetToTableModel(RS));
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void ajouter(String numEmp, String nom, String prenom, String sexe, String email, String adresse, String poste, String dep, 
			String DateNaiss, String debutConge, String finConge, String dateEmbauche, String finContrat, String antecedant, String salaire, 
			String telephone, String status ) throws SQLException {
		// TODO Auto-generated method stub
		boolean rs;
		String sql = "INSERT INTO employe (nom, prenom, email, sexe, poste, departement, salaire, telephone, num_employe, date_naissance, adresse, s_conjugale, debut_conge, fin_conge, date_embauche, date_fin_contrat, antecedant_medical) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// BDD
		PreparedStatement pst = conn.prepareStatement(sql); // preparation de la syntaxe SQL
		pst.setString(1,nom);
		pst.setString(2,prenom);
		pst.setString(3, email);
		pst.setString(4, sexe);
		pst.setString(5, poste);
		pst.setString(6, dep);
		pst.setString(7, salaire);
		pst.setString(8, telephone);
		pst.setString(9, numEmp);
		pst.setString(10, DateNaiss);
		pst.setString(11, adresse);
		pst.setString(12, status);
		pst.setString(13, debutConge);
		pst.setString(14, finConge);
		pst.setString(15, dateEmbauche);
		pst.setString(16, finContrat);
		pst.setString(17, antecedant);
		rs = pst.execute(); // execution de la syntaxe SQL
		if (rs == false) {
			toutAfficher();
			JOptionPane.showMessageDialog(null, "l'employe a bien ete enregistrer");
		} else {
			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
			
	}
	
	public void supprEmploye(String num) {
		// TODO Auto-generated method stub
		try {
			String sql = "Delete FROM employe where num_employe='"+num+"'";
	        java.sql.Statement stmt = conn.createStatement();
			@SuppressWarnings("unused")
			int RS = stmt.executeUpdate(sql);
			toutAfficher();
			JOptionPane.showMessageDialog(null, "l'employe a bien ete supprimer");
		} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
		}
	}
	
	public void modifEmploye(String numEmp, String nom, String prenom, String sexe, String email, String adresse, String poste, String dep, 
			String DateNaiss, String debutConge, String finConge, String dateEmbauche, String finContrat, String antecedant, String salaire, 
			String telephone, String status ) {
		boolean rs;
		String sql;
		
          try {
        	  sql = "UPDATE employe SET nom=?, prenom=?, email=?, sexe=?, poste=?, departement=?, salaire=?, telephone=?, date_naissance=?, adresse=?, s_conjugale=?, debut_conge=?, fin_conge=?, date_embauche=?, date_fin_contrat=?, antecedant_medical=? WHERE num_employe=? ";
        	  PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
        	  pst.setString(1,nom);
      		pst.setString(2,prenom);
      		pst.setString(3, email);
      		pst.setString(4, sexe);
      		pst.setString(5, poste);
      		pst.setString(6, dep);
      		pst.setString(7, salaire);
      		pst.setString(8, telephone); 	
      		pst.setString(9, DateNaiss);
      		pst.setString(10, adresse);
      		pst.setString(11, status);
      		pst.setString(12, debutConge);
      		pst.setString(13, finConge);
      		pst.setString(14, dateEmbauche);
      		pst.setString(15, finContrat);
      		pst.setString(16, antecedant);
      		pst.setString(17, numEmp);
        	 rs = pst.execute();
        	 pst.close();
        	 if (rs == false) {
      			toutAfficher();
     			JOptionPane.showMessageDialog(null, "le modification a bien ete enregistrer");
     		} else {
     			JOptionPane.showInternalMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur", 0);
     		}
          } catch (SQLException insertException) {
        	   System.out.println("Error:"+insertException.getMessage());
          }
        }

}
