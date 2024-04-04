package library.management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class IssueBook extends JFrame implements ActionListener {
    JPanel p;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    IssueBook(){
        p=new JPanel();
        p.setLayout(new GridLayout(6,2,5,5));
        p.setBorder(new EmptyBorder(50, 50, 50, 50));
        l1=new JLabel("Book Callno");
        l2=new JLabel("Student Id");
        l3=new JLabel("Student Name");
        l4=new JLabel("Student Contact");
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        
        b1=new JButton("Issue");
        b2=new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(l4);
        p.add(t4);
        p.add(b1);
        p.add(b2);
        add(p);
        
        setSize(600,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
        String bookcallno=t1.getText();
        String studentname=t3.getText();
        String studentcontact=t4.getText();
        
        if(bookcallno.equals("")||t2.getText().equals("")||studentname.equals("")||studentcontact.equals("")){
            JOptionPane.showMessageDialog(IssueBook.this,"Error! Fill all the details.");
        }
        else{
        
        int studentid=Integer.parseInt(t2.getText());
        if(BookFun.checkBook(bookcallno)){

        int i=BookFun.issue(bookcallno, studentid, studentname, studentcontact);
        if(i>0){
                JOptionPane.showMessageDialog(IssueBook.this,"Book issued successfully!");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");

        }else{
                JOptionPane.showMessageDialog(IssueBook.this,"Sorry, unable to issue!");
        }//end of save if-else

        }else{
                JOptionPane.showMessageDialog(IssueBook.this,"Sorry, Callno doesn't exist!");
        }//end of checkbook if-else
        }}
        if(e.getSource()==b2){
            this.dispose();
            LibSection.main(new String[]{});
        }
    }
    
    public static void main(String[] args){
        new IssueBook();
    }
    
}
