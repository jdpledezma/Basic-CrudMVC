package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.util.Calendar;
import java.util.Vector;
import java.sql.ResultSet;

public class ViewCrudMenu extends JFrame{
	
	DefaultTableModel tableModel;
	JScrollPane scrollPane;
	Font font = new Font("Dialog",Font.BOLD,18);
	 JTable table;
	 
	private JButton addBtn = new JButton(),edit,delete,exit;
	private JLabel labelTitle = new JLabel("Register Patients");
	private JLabel firstName = new JLabel("First Name");
	private JLabel lastName = new JLabel("Last Name");
	private JLabel bornDate = new JLabel("Born Date");
	private JLabel telephone = new JLabel("Telephone");
	private JLabel address = new JLabel("Address");
	private JLabel dni = new JLabel("Identify");
	private JTextField firstNameTxt = new JTextField();
	private JTextField lastNameTxt = new JTextField();
	private JDateChooser calendary = new JDateChooser();
	private JTextField telephoneTxt = new JTextField();
	private JTextField addressTxt = new JTextField();
	private JTextField dniTxt = new JTextField();
	private JButton clearInputs = new JButton("Clear");
	private JTextField searchUser = new JTextField();
	private JButton searchBtn = new JButton();
	private JLabel searchLabel = new JLabel("Search with identify");
	private JButton editBtn = new JButton();
	private JButton exitBtn = new JButton("Exit");
	private JButton deleteBtn = new JButton();
	Vector <Object> data;
	
	

	public ViewCrudMenu() {
		getContentPane().setLayout(null);
        JLabel label = new JLabel("Register Patients");
        label.setFont(font);
        
        tableModel = new DefaultTableModel();
        
        table = new JTable(tableModel) {
        	
        	public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };
        
        String[] columnTitles = {"ID","First Name","Last Name","Born","Telephone","Address","DNI"}; 
        for(String titles: columnTitles) {
			  tableModel.addColumn(titles);
		  }
  
     
        table.setModel(tableModel);
        
        labelTitle.setBounds(240, 5, 250, 50);
		
		firstName.setBounds(125,45,150,50);
		firstNameTxt.setBounds(205,60,150,25);
		
		lastName.setBounds(365,45,150,50);
		lastNameTxt.setBounds(445,60,150,25);
		
		bornDate.setBounds(125,90,150,50);
		calendary.setBounds(205,105,150,25);
		calendary.setDateFormatString("yy-MM-dd");
		
		telephone.setBounds(365,90,150,50);
		telephoneTxt.setBounds(445,105,150,25);	
		
		address.setBounds(125,140,150,50);
		addressTxt.setBounds(205,150,150,25);
		
		dni.setBounds(365,140,150,50);
		dniTxt.setBounds(445, 150, 150, 25);
		
		searchUser = new JTextField();
		searchUser.setBounds(230, 220, 150, 25);
        
		searchLabel.setBounds(190,190,150,25);
		
        table.setPreferredScrollableViewportSize(new Dimension(250, 100));
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(80,300,650,216);
        label.setBounds(300,0,250,50);
        
        addBtn.setText("Add");
        addBtn.setBounds(630,40,100,30);
        
        editBtn.setText("Edit");
        editBtn.setBounds(630,85,100,30);

        deleteBtn.setText("Delete");
        deleteBtn.setBounds(630,130,100,30);

        clearInputs.setBounds(630,175,100,30);
        
        exitBtn.setText("Exit");
        exitBtn.setBounds(630,220,100,30);
        
        searchBtn = new JButton("Search");
        searchBtn.setBounds(125, 220, 100, 25);
        
        getContentPane().add(label);
		getContentPane().add(firstName);
		getContentPane().add(firstNameTxt);
		getContentPane().add(lastName);
		getContentPane().add(lastNameTxt);
		getContentPane().add(bornDate);
		getContentPane().add(calendary);
		getContentPane().add(telephone);
		getContentPane().add(telephoneTxt);
		getContentPane().add(address);
		getContentPane().add(addressTxt);
		getContentPane().add(dni);
		getContentPane().add(dniTxt);
		getContentPane().add(searchUser);
		getContentPane().add(searchLabel);
		
		getContentPane().add(clearInputs);
        getContentPane().add(scrollPane);
        getContentPane().add(addBtn);
        getContentPane().add(searchBtn);
        
        getContentPane().add(editBtn);
        getContentPane().add(deleteBtn);
        getContentPane().add(exitBtn);
        setSize(800,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
	}

	
	
	public JButton getAddBtn() {
		return addBtn;
	}



	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}



	public JLabel getLabelTitle() {
		return labelTitle;
	}

	
	

	public JButton getExitBtn() {
		return exitBtn;
	}



	public void setExitBtn(JButton exitBtn) {
		this.exitBtn = exitBtn;
	}



	public Vector<Object> getData() {
		return data;
	}



	public void setData(Vector<Object> data) {
		this.data = data;
	}



	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}


	

	public JButton getDeleteBtn() {
		return deleteBtn;
	}



	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}



	public JLabel getFirstName() {
		return firstName;
	}



	public void setFirstName(JLabel firstName) {
		this.firstName = firstName;
	}


	
	
	public JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}



	public JLabel getLastName() {
		return lastName;
	}



	public void setLastName(JLabel lastName) {
		this.lastName = lastName;
	}



	public JLabel getBornDate() {
		return bornDate;
	}



	public void setBornDate(JLabel bornDate) {
		this.bornDate = bornDate;
	}



	public JLabel getTelephone() {
		return telephone;
	}



	public void setTelephone(JLabel telephone) {
		this.telephone = telephone;
	}



	public JLabel getAddress() {
		return address;
	}



	public void setAddress(JLabel address) {
		this.address = address;
	}



	public JLabel getDni() {
		return dni;
	}



	public void setDni(JLabel dni) {
		this.dni = dni;
	}



	public JTextField getFirstNameTxt() {
		return firstNameTxt;
	}



	public void setFirstNameTxt(JTextField firstNameTxt) {
		this.firstNameTxt = firstNameTxt;
	}



	public JTextField getLastNameTxt() {
		return lastNameTxt;
	}



	public void setLastNameTxt(JTextField lastNameTxt) {
		this.lastNameTxt = lastNameTxt;
	}



	public JDateChooser getCalendary() {
		return calendary;
	}



	public void setCalendary(JDateChooser calendary) {
		this.calendary = calendary;
	}



	public JTextField getTelephoneTxt() {
		return telephoneTxt;
	}


	
	public JButton getEditBtn() {
		return editBtn;
	}



	public void setEditBtn(JButton editBtn) {
		this.editBtn = editBtn;
	}



	public void setTelephoneTxt(JTextField telephoneTxt) {
		this.telephoneTxt = telephoneTxt;
	}



	public JTextField getAddressTxt() {
		return addressTxt;
	}



	public void setAddressTxt(JTextField addressTxt) {
		this.addressTxt = addressTxt;
	}



	public JTextField getDniTxt() {
		return dniTxt;
	}



	public void setDniTxt(JTextField dniTxt) {
		this.dniTxt = dniTxt;
	}



	public JButton getClearInputs() {
		return clearInputs;
	}



	public void setClearInputs(JButton clearInputs) {
		this.clearInputs = clearInputs;
	}



	public JTextField getSearchUser() {
		return searchUser;
	}



	public void setSearchUser(JTextField searchUser) {
		this.searchUser = searchUser;
	}



	public JButton getSearchBtn() {
		return searchBtn;
	}



	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}



	public JLabel getSearchLabel() {
		return searchLabel;
	}



	public void setSearchLabel(JLabel searchLabel) {
		this.searchLabel = searchLabel;
	}



	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public JButton getAdd() {
		return this.addBtn;
	}

	public void setAdd(JButton addBtn) {
		this.addBtn = addBtn;
	}

	public JButton getEdit() {
		return edit;
	}

	public void setEdit(JButton edit) {
		this.edit = edit;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}
	
	
	
}
