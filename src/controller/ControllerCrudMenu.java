package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ModelPatients;
import view.ViewCrudMenu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;

import javax.swing.JOptionPane;

public class ControllerCrudMenu implements ActionListener {
	ViewCrudMenu viewCrudMenu;
	ModelPatients modelPatients;
	
	
	public ControllerCrudMenu(ViewCrudMenu viewCrudMenu) {
		this.viewCrudMenu = viewCrudMenu;
		modelPatients = new ModelPatients();
		this.viewCrudMenu.getClearInputs().addActionListener(this);
		this.viewCrudMenu.getAddBtn().addActionListener(this);
		this.viewCrudMenu.getSearchBtn().addActionListener(this);
		this.viewCrudMenu.getEditBtn().addActionListener(this);
		this.viewCrudMenu.getExitBtn().addActionListener(this);
		this.viewCrudMenu.getDeleteBtn().addActionListener(this);
	}
	
	public void showCrudMenu() throws SQLException {
		viewCrudMenu.setSize(800,400);
		viewCrudMenu.setDefaultCloseOperation(3);
		viewCrudMenu.setLocationRelativeTo(null);
		viewCrudMenu.setResizable(false);
		renderTable();
		viewCrudMenu.setVisible(true);
		
	}
	
	
	public void renderTable() throws SQLException{
		String[] patients = new String[7];
		viewCrudMenu.getTableModel().setRowCount(0); 
		ResultSet data = (ResultSet) modelPatients.getData();
		  while(data.next()) {
			  patients[0] = data.getString(1);
			  patients[1] = data.getString(2);
			  patients[2] = data.getString(3);
			  patients[3] = data.getString(4);
			  patients[4] = data.getString(5);
			  patients[5] = data.getString(6);
			  patients[6] = data.getString(7);
			  viewCrudMenu.getTableModel().addRow(patients);  
		  }
		  
		  viewCrudMenu.getTable().setModel(viewCrudMenu.getTableModel());
	}
	
	
	public void addUser() throws SQLException {
		String firstname = viewCrudMenu.getFirstNameTxt().getText();
		String lastname = viewCrudMenu.getLastNameTxt().getText();
		Date bornDate = viewCrudMenu.getCalendary().getDate();
		String telephone = viewCrudMenu.getTelephoneTxt().getText();
		String address = viewCrudMenu.getAddressTxt().getText();
		String dni = viewCrudMenu.getDniTxt().getText();
		
		if(firstname.isEmpty() && dni.isEmpty() || lastname.isEmpty() || telephone.isEmpty() || address.isEmpty() || bornDate.toString().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Sorry. Complete the fields");
			return;
		}
		
		boolean user_check = modelPatients.searchPatient(dni);
		if(user_check) {
			JOptionPane.showMessageDialog(null, "Sorry. Patients Already Registered");
		}else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
	        String formattedBornDate = dateFormat.format(bornDate);
			
			modelPatients.addUser(firstname,lastname,formattedBornDate ,telephone,address,dni);
			JOptionPane.showMessageDialog(null, "Patients Add");
			renderTable();
	}
}
	
	public void updatePatient() throws SQLException {
		String firstname = viewCrudMenu.getFirstNameTxt().getText();
		String lastname = viewCrudMenu.getLastNameTxt().getText();
		Date bornDate = viewCrudMenu.getCalendary().getDate();
		String telephone = viewCrudMenu.getTelephoneTxt().getText();
		String address = viewCrudMenu.getAddressTxt().getText();
		String dni = viewCrudMenu.getDniTxt().getText();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		 String formattedBornDate = "";
		if (bornDate != null) {
		    formattedBornDate = dateFormat.format(bornDate);
		} else {
		    formattedBornDate = "";
		}
		
        if(firstname.isEmpty() && dni.isEmpty() || lastname.isEmpty() || telephone.isEmpty() || address.isEmpty() || formattedBornDate.equals(null)) {
			JOptionPane.showMessageDialog(null, "Sorry. Complete the fields");
			return;
		}
		
		boolean userUpdated = modelPatients.editUser(firstname, lastname, formattedBornDate, telephone, address, dni);
		if(userUpdated) {
			JOptionPane.showMessageDialog(null, "Patient Update");
			renderTable();
		}else {
			JOptionPane.showMessageDialog(null, "Sorry. Problems");
		}
	}
	
	public void deletePatient() {
		try {
			String dni = viewCrudMenu.getDniTxt().getText();
			if(dni.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Complete Indentify Fields");
				return;
			}
			
			boolean userDeleted = modelPatients.deletePatient(dni);
			if(userDeleted) {
				JOptionPane.showMessageDialog(null, "Patient Deleted");
				renderTable();
			}else {
				JOptionPane.showMessageDialog(null, "Sorry. Problems");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clearInput() {
		viewCrudMenu.getFirstNameTxt().setText("");
		viewCrudMenu.getLastNameTxt().setText("");
		viewCrudMenu.getCalendary().setCalendar(null);;
		viewCrudMenu.getTelephoneTxt().setText("");
		viewCrudMenu.getAddressTxt().setText("");
		viewCrudMenu.getDniTxt().setText("");
		viewCrudMenu.getSearchUser().setText("");
	}
	
	public void getPatient() {
		try {
	    String dni = viewCrudMenu.getSearchUser().getText();
	    if(dni.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "Complete Search Field");
	    	return;
	    }
	    ResultSet patient = modelPatients.getPatient(dni);
	    while(patient.next()) {
	    	viewCrudMenu.getFirstNameTxt().setText(patient.getString(1));
	    	viewCrudMenu.getLastNameTxt().setText(patient.getString(2));
	    	viewCrudMenu.getCalendary().setDate(patient.getDate(3));
	    	viewCrudMenu.getTelephoneTxt().setText(patient.getString(4));
	    	viewCrudMenu.getAddressTxt().setText(patient.getString(5));
	    	viewCrudMenu.getDniTxt().setText(patient.getString(6));
	    }
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewCrudMenu.getClearInputs()){
			clearInput();
		}
		
		if(e.getSource() == viewCrudMenu.getAddBtn()) {
			try {
				addUser();
			} catch (SQLException e1) {
				e1.printStackTrace();

			}
			}
		if(e.getSource() == viewCrudMenu.getEditBtn()) {
			try {
				updatePatient();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == viewCrudMenu.getSearchBtn()){
			try {
				getPatient();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == viewCrudMenu.getDeleteBtn()) {
			try {
				deletePatient();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == viewCrudMenu.getExitBtn()) {
			viewCrudMenu.dispose();
		}
			
		}
	
	}
	

