package chatApp;
import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;
 class Imageslider extends JFrame  implements ActionListener
{
ImageIcon s[];
JLabel l;
JButton b1,b2,b3,b4,b5,b6,b7;
int i,l1;
JPanel p;
public Imageslider()
{
	setResizable(false);
	setLocation(400,100);
    getContentPane().setLayout(new BorderLayout( ));
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
    JPanel p=new JPanel(new FlowLayout());
    p.setPreferredSize(new Dimension(100, 100));
    p.setSize(new Dimension(10, 10));
    b1=new JButton("Previous");
    b1.setHorizontalTextPosition(SwingConstants.LEFT);
    b1.setFont(new Font("Impact", Font.PLAIN, 14));
    b1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    b1.setPreferredSize(new Dimension(95, 50));
    b1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
    b1.setBounds(200,600,450,200);
    b2=new JButton("Next");
    b2.setHorizontalTextPosition(SwingConstants.RIGHT);
    b2.setFont(new Font("Impact", Font.PLAIN, 14));
    b2.setAlignmentX(Component.RIGHT_ALIGNMENT);
    b2.setPreferredSize(new Dimension(95, 50));
    p.add(b1);
    p.add(b2);

    getContentPane().add(p,BorderLayout.SOUTH);
    b1.addActionListener(this);
    b2.addActionListener(this);


    s = new ImageIcon[7]; 
    s[0] = new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\step01.jpg");
    s[1] = new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\step02.jpg");
    s[2] = new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\step03.jpg");
    s[3] = new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\step11.jpg");
    s[4] = new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\step22.jpg");
    s[5] = new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\step44.png");
    s[6] = new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\step3.png");
    l = new JLabel("",JLabel.CENTER); 
    getContentPane().add(l,BorderLayout.CENTER);
    l.setIcon(s[0]);
    
}
public  void actionPerformed(ActionEvent e)
{
    if(e.getSource()==b1)
    {
        if(i==0)
        {
            JOptionPane.showMessageDialog(null,"Welcome, Read all instructions and follow properly");
	    	
        }
        else
            {
            i=i-1;
            l.setIcon(s[i]);
        }
    }
    if(e.getSource()==b2)
    {
        if(i==s.length-1)
        {
            JOptionPane.showMessageDialog(null,"Thank You!, Stay Safe and Stay Healthy");
            dispose();
	    	
        }
        else
            {
            i=i+1;
            l.setIcon(s[i]);
            }
        }
     }
public static void main(String args[])
{
    Imageslider obj = new Imageslider();
}
 }