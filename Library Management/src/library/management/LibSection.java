
package library.management;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class LibSection extends JFrame implements ActionListener{
    JMenuBar amenu;
    JMenu lib,log;
    JMenuItem addl,view,issue,view_issue,return_book,logout;
    LibSection(){
        super("Librarian Section");
        amenu=new JMenuBar();
        lib =new JMenu("Books");
        addl=new JMenuItem("Add Book");
        view=new JMenuItem("View Books");
        issue=new JMenuItem("Issue Book");
        view_issue=new JMenuItem("View Issue Books");
        return_book=new JMenuItem("Return Book");
        
        log=new JMenu("Logout");
        logout=new JMenuItem("Logout");
        
       
        addl.addActionListener(this);
        view.addActionListener(this);
        issue.addActionListener(this);
        view_issue.addActionListener(this);
        return_book.addActionListener(this);
        
        logout.addActionListener(this);
        
        amenu.add(lib);
        lib.add(addl);
        lib.add(view);
        lib.add(issue);
        lib.add(view_issue);
        lib.add(return_book);
        
        amenu.add(log);
        log.add(logout);
        this.setJMenuBar(amenu);
        
        this.setSize(1000,500);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==addl){
            AddBook.main(new String[]{});
            this.dispose();
        }
        if(ae.getSource()==view){
            ViewBook.main(new String[]{});
            this.dispose();
        }
        if(ae.getSource()==issue){
            IssueBook.main(new String[]{});
            this.dispose();
        }
        if(ae.getSource()==view_issue){
            ViewIssue.main(new String[]{});
            this.dispose();
        }
        if(ae.getSource()==return_book){
            ReturnBook.main(new String[]{});
            this.dispose();
        }
        if(ae.getSource()==logout){
            this.dispose();
            User.main(new String[]{});
    }
    }
    public static void main(String[] args){
        LibSection libSection = new LibSection();
    }
}
