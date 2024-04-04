package library.management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
public class ReturnBook extends JFrame implements ActionListener{
    JPanel p;
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;
    ReturnBook(){
        p=new JPanel();
        p.setLayout(new GridLayout(3,2,5,5));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));
        l1=new JLabel("Book Callno");
        l2=new JLabel("Student Id");
        t1=new JTextField();
        t2=new JTextField();
        b1=new JButton("Return");
        b2=new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(b1);
        p.add(b2);
        add(p);
        setSize(400,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            if(t1.getText().equals("")||t2.getText().equals("")){
                JOptionPane.showMessageDialog(ReturnBook.this,"Error! Fill all the details.");
            }
            else{

                String bookcallno=t1.getText();
                int studentid=Integer.parseInt(t2.getText());
                int i=BookFun.delete(bookcallno, studentid);
                if(i>0){
                        JOptionPane.showMessageDialog(ReturnBook.this,"Book returned successfully!");
                        t1.setText("");
                        t2.setText("");

                }else{
                        JOptionPane.showMessageDialog(ReturnBook.this,"Sorry, unable to return book!");
                }
            }
        }
        if(e.getSource()==b2){
            this.dispose();
            LibSection.main(new String[]{});
        }
    }
    
    public static void main(String[] args){
        new ReturnBook();
    }
    
}
