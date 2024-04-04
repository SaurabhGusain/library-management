package library.management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DelLib extends JFrame implements ActionListener{
    JLabel l1;
    JTextField id;
    JButton b1,b2;
    JPanel p;
    DelLib(){
        super("Delete Librarian");
        p=new JPanel();
        l1=new JLabel();
        id=new JTextField(20);
        b1=new JButton("Delete");
        b2=new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        p.add(l1);
        p.add(id);
        p.add(b1);
        p.add(b2);
        add(p);
        
        setLayout(new FlowLayout());
        setSize(800,400);
        setVisible(true);
      
    }

    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String sid=id.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(DelLib.this,"Id can't be blank");
				}else{
					int Lid=Integer.parseInt(sid);
					int i=LibFun.delete(Lid);
					if(i>0){
						JOptionPane.showMessageDialog(DelLib.this,"Record deleted successfully!");
                                                id.setText("");
					}else{
						JOptionPane.showMessageDialog(DelLib.this,"Unable to delete given id!");
                                                id.setText("");
					}
				}
			}
        if(ae.getSource()==b2){
            AdminSection.main(new String[]{});
            this.dispose();
        }
    }
    public static void main(String[] args){
        new DelLib();
    }
}
