package library.management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class AddBook extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JPanel p1;
    AddBook(){
        p1=new JPanel();
        p1.setLayout(new GridLayout(6,2,5,5));
        p1.setBorder(new EmptyBorder(50, 50, 50, 50));
        l1=new JLabel("Callno");
        l2=new JLabel("Name");
        l3=new JLabel("Author");
        l4=new JLabel("Publisher");
        l5=new JLabel("Quantity");
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        
        b1=new JButton("Add Book");
        b2=new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(l5);
        p1.add(t5);
        
        p1.add(b1);
        p1.add(b2);
        
        add(p1);
        setSize(800,400);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String callno=t1.getText();
	String name=t2.getText();
	String author=t3.getText();
	String publisher=t4.getText();
	String squantity=t5.getText();
	
        
        if(e.getSource()==b1){
            int i;
            if(!(callno.equals("")||name.equals("")||author.equals("")||publisher.equals("")||squantity.equals(""))){
                int quantity=Integer.parseInt(squantity);
                i=BookFun.save(callno, name, author, publisher, quantity);
                if(i>0){
                     JOptionPane.showMessageDialog(AddBook.this, "Book add Successfully.");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                }
                else{
                    JOptionPane.showMessageDialog(AddBook.this, "Error! Book not added.");
                }
            }
            else{
                JOptionPane.showMessageDialog(AddBook.this,"Error! Fill all the details.");
            }
        }
        if(e.getSource()==b2){
             this.dispose();
             LibSection.main(new String[]{});
        }
    }
    
    public static void main(String[] args){
        new AddBook();
    }
}
