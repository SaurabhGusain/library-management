
package library.management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
public class User extends JFrame implements ActionListener{
    JPanel p;
    JLabel l1,l2;
    JButton a,l;
    User(){
        p=new JPanel();
        p.setLayout(new GridLayout(2,2,10,10));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));
        
        l1=new JLabel("Admin");
        l2=new JLabel("Librarian");
        a=new JButton("Login");
        l=new JButton("Login");
        
        a.addActionListener(this);
        l.addActionListener(this);
        
        p.add(l1);
        p.add(l2);
        p.add(a);
        p.add(l);
        add(p);
        
        setSize(400,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==a){
            Home.main(new String[]{});
            this.dispose();
        }
        if(ae.getSource()==l){
            LibLogin.main(new String[]{});
            this.dispose();
        }
    }
    public static void main(String[] args){
        new User();
    }
}
