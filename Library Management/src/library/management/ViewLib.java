package library.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;

public class ViewLib extends JFrame implements ActionListener {
    JPanel p1;
    JTable table;
    JButton b1;
    ViewLib(){
        p1=new JPanel();
        p1.setBorder(new EmptyBorder(5, 5, 5, 5));
	p1.setLayout(new BorderLayout());
        String data[][]=null;
	String column[]=null;
        try{
			Connection con=DBC.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
        
            table = new JTable(data,column);
            JScrollPane sp=new JScrollPane(table);
            
            b1=new JButton("back");
            b1.setSize(20,10);
            b1.addActionListener(this);
            p1.add(sp,BorderLayout.NORTH);
            p1.add(b1, BorderLayout.SOUTH);
            add(p1);
            
            setSize(1000,600);
            setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            this.dispose();
            AdminSection.main(new String[]{});
        }
    }
    public static void main(String[] args){
        new ViewLib();
    }
}
