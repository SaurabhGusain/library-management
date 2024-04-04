
package library.management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
class ViewIssue extends JFrame implements ActionListener{
    JPanel p;
    JTable t;
    JButton b;
    ViewIssue(){
        p=new JPanel();
        p.setBorder(new EmptyBorder(5,5,5,5));
        p.setLayout(new BorderLayout());
        
        String data[][]=null;
        String column[]=null;
        try{
            Connection con=DBC.getConnection();
            PreparedStatement ps=con.prepareStatement("Select * from issuebooks", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=ps.executeQuery();
            
            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                column[i-1]=rsmd.getColumnName(i);
            }
            
            rs.last();
            int row=rs.getRow();
            rs.beforeFirst();
            
            data=new String[row][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        t=new JTable(data,column);
        JScrollPane sp=new JScrollPane(t);
        
        b=new JButton("back");
        b.addActionListener(this);
        p.add(sp,BorderLayout.NORTH);
        p.add(b, BorderLayout.SOUTH);
        add(p);
            
        setSize(1000,600);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b){
            this.dispose();
            LibSection.main(new String[]{});
       }
    }
    public static void main(String[] arrgs){
        new ViewIssue();
    }
}
