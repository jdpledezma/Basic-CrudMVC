package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ModelUser;
import view.ViewCrudMenu;
import view.ViewLogin;

public class ControllerLogin implements ActionListener {

	ViewLogin viewLogin = new ViewLogin();
	ModelUser modelUser; 
	ControllerCrudMenu controllerCrudMenu;
	
	public ControllerLogin(ViewLogin viewLogin) {
		this.viewLogin = viewLogin;
		modelUser = new ModelUser();
		this.viewLogin.getSubmitBtn().addActionListener((ActionListener) this);
	}
	
	
	public void showScreen() {
		viewLogin.setSize(300,400);
		viewLogin.setDefaultCloseOperation(3);
		viewLogin.setLocationRelativeTo(null);
		viewLogin.setResizable(false);
		viewLogin.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == viewLogin.getSubmitBtn()){
			String username = viewLogin.getUsernameTxt().getText();
			String password = viewLogin.getPasswordTxt().getText();
			boolean userAuthorized = this.modelUser.userVerify(username,password);
			if(userAuthorized) {
				JOptionPane.showMessageDialog(null, "Login Success");
				this.viewLogin.dispose();
				controllerCrudMenu = new ControllerCrudMenu(new ViewCrudMenu());
				try {
					controllerCrudMenu.showCrudMenu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(null,"Error Login");
			}
		}
		
	}
	
}
