package library.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminSection extends JFrame implements ActionListener{
    JMenuBar amenu;
    JMenu lib,log;
    JMenuItem addl,deletel,viewl,logout;
    AdminSection(){
        super("Admin Section");
        amenu=new JMenuBar();
        lib =new JMenu("Librarian Detail");
        addl=new JMenuItem("Add Librarian");
        deletel=new JMenuItem("Delete Librarian");
        viewl=new JMenuItem("View Librarian");
        
        log=new JMenu("Logout");
        logout=new JMenuItem("Logout");
        
       
        addl.addActionListener(this);
        deletel.addActionListener(this);
        viewl.addActionListener(this);
        logout.addActionListener(this);
        
        amenu.add(lib);
        lib.add(addl);
        lib.add(deletel);
        lib.add(viewl);
        amenu.add(log);
        log.add(logout);
        this.setJMenuBar(amenu);
        
        this.setSize(1000,500);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
     
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addl){
            AddLib.main(new String[]{});
            this.dispose();
        }
        if(ae.getSource()==deletel){
            DelLib.main(new String[]{});
            this.dispose();
        }
        if(ae.getSource()==viewl){
            ViewLib.main(new String[]{});
            this.dispose();
        }
        if(ae.getSource()==logout){
            this.dispose();
            User.main(new String[]{});
            
        }
        
    }
    public static void main(String []args){
        new AdminSection();
    }
}
