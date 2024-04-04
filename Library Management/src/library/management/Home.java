package library.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
public class Home extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField user;
    JPasswordField pass;
    JButton blogin,bexit;
    JPanel homepage;
    
    Home(){
        
        super("Library Management");
        GridLayout layout = new GridLayout(3,2,5,5);
        homepage=new JPanel();
        homepage.setLayout(layout);
        homepage.setBorder(new EmptyBorder(50, 50, 50, 50));
        l1=new JLabel("Enter Username:");
        user=new JTextField(20); 
        l2=new JLabel("Enter Password");
        pass=new JPasswordField(20);
        blogin=new JButton("Login");
        bexit=new JButton("Exit");
        
        blogin.addActionListener( this);
        bexit.addActionListener(this);
        
        homepage.add(l1);
        homepage.add(user);
        homepage.add(l2);
        homepage.add(pass);
        homepage.add(blogin);
        homepage.add(bexit);
        add(homepage);
        
        setSize(600,600);    
        setLayout(layout);    
        setVisible(true);      
    }


    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==blogin){
        String name=user.getText();
	String password=String.valueOf(pass.getPassword());
        if(name.equals("Admin")&&password.equals("Admin123")){
            AdminSection.main(new String[]{});
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(Home.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				user.setText("");
				pass.setText("");
        }}
        if(ae.getSource()==bexit){
            User.main(new String[]{});
            this.dispose();
        }
    }
    
    public static void main(String args[]){
        Home home = new Home();
    }
}
