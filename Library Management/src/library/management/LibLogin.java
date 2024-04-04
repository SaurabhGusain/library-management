package library.management;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
public class LibLogin extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField user;
    JPasswordField pass;
    JButton blogin,bexit;
    JPanel p1;
    LibLogin(){
        super("Librarian Login");
        GridLayout layout = new GridLayout(3,2,5,5);
        p1=new JPanel();
        p1.setLayout(layout);
        p1.setBorder(new EmptyBorder(50, 50, 50, 50));
        l1=new JLabel("Enter Username:");
        user=new JTextField(20); 
        l2=new JLabel("Enter Password");
        pass=new JPasswordField(20);
        blogin=new JButton("Login");
        bexit=new JButton("Exit");
        
        blogin.addActionListener( this);
        bexit.addActionListener(this);
        
        p1.add(l1);
        p1.add(user);
        p1.add(l2);
        p1.add(pass);
        p1.add(blogin);
        p1.add(bexit);
        add(p1);
        
        setSize(600,600);    
        setLayout(layout);    
        setVisible(true);      
        
    }
    public static void main(String[] args){
        new LibLogin();
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==blogin){
        String name=user.getText();
	String password=String.valueOf(pass.getPassword());
        if(LibFun.validate(name, password)){
				LibSection.main(new String[]{});
				this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(LibLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				user.setText("");
				pass.setText("");
        }}
        if(e.getSource()==bexit){
            User.main(new String[]{});
            this.dispose();
        }
    }
}
