
package library.management;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddLib extends JFrame implements ActionListener{
    JLabel namel,passwordl,emaill,addressl,cityl,phonel;
    JTextField namet,emailt,addresst,cityt,phonet;
    JPasswordField passwordt;
    JButton addb,back;
    JPanel adding;
    AddLib(){
        super("Add Librarian");
        
        adding=new JPanel();
        adding.setLayout(new GridLayout(7,2,5,5));
        adding.setBorder(new EmptyBorder(50, 50, 50, 50));
        namel=new JLabel("Name");
        passwordl=new JLabel("Password");
        emaill=new JLabel("Email");
        addressl=new JLabel("Address");
        cityl=new JLabel("City");
        phonel=new JLabel("Phone");
        
        namet=new JTextField(null);
        passwordt=new JPasswordField(null);
        emailt=new JTextField(null);
        addresst=new JTextField(null);
        cityt=new JTextField(null);
        phonet=new JTextField(null);
        
        addb=new JButton("Add");
        back=new JButton("Back");
        addb.addActionListener(this);
        back.addActionListener(this);
        //addb.setBounds(100, 40, 40, 40);
        
        adding.add(namel);
        adding.add(namet);
        adding.add(passwordl);
        adding.add(passwordt);
        adding.add(emaill);
        adding.add(emailt);
        adding.add(addressl);
        adding.add(addresst);
        adding.add(cityl);
        adding.add(cityt);
        adding.add(phonel);
        adding.add(phonet);
        adding.add(addb);
        adding.add(back);
        
        add(adding);
        setSize(800,400);
	setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        String name=namet.getText();
        String pass=String.valueOf(passwordt.getPassword());
        String email=emailt.getText();
        String address=addresst.getText();
        String city=cityt.getText();
        String phone=phonet.getText();
        
        if(ae.getSource()==addb){
            int i=0;
            if(!(name.equals("")||pass.equals("")||phone.equals("")||email.equals("")||address.equals("")||city.equals(""))){
                    i=LibFun.save(name, pass, email, address, city, phone);
                    if(i>0){
                        JOptionPane.showMessageDialog(AddLib.this,"Librarian added successfully!");
                	namet.setText(null);
                        passwordt.setText(null);
                        emailt.setText(null);
                        addresst.setText(null);
                        cityt.setText(null);
                        phonet.setText(null);
				
                    }else{
			JOptionPane.showMessageDialog(AddLib.this,"Sorry, unable to save!");
                    }
            }else{
                JOptionPane.showMessageDialog(AddLib.this,"Fill all the details.");
            }            
                        
        }
        if(ae.getSource()==back){
            //AdminSection.main(new String[]{});
            this.dispose();
        }
            
    }
    public static void main(String []args){
        new AddLib();
    } 
    
}
