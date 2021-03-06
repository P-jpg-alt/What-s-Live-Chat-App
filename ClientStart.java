package chatApp;


import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientStart extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField port;
    static String cName;
    static int cpNo;
    static String ip;
    private JTextField i;
    
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientStart frame = new ClientStart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public ClientStart() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(0, 0, 297, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(10, 0, 52, 55);
		ImageIcon r=new ImageIcon("C:\\\\Users\\\\pritamsing\\\\OneDrive\\\\Desktop\\\\Group Chatting App\\\\src\\\\chatIcons\\\\LogoMakr-4ha8sn (1).png");
		Image rimage=r.getImage();
		Image rimgScale=rimage.getScaledInstance(logo.getWidth(),logo.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon rscaledIcon=new ImageIcon(rimgScale); 
		logo.setIcon(rscaledIcon);
		panel.add(logo);
		
		JLabel lblWhatsapp = new JLabel("WhatsLive");
		lblWhatsapp.setFont(new Font("Arial", Font.BOLD, 30));
		lblWhatsapp.setForeground(new Color(0, 0, 0));
		lblWhatsapp.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatsapp.setBounds(43, 11, 215, 33);
		panel.add(lblWhatsapp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(60, 179, 113));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setBounds(0, 56, 297, 298);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblChatAs = new JLabel("Chat as :-");
		lblChatAs.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblChatAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblChatAs.setBounds(21, 42, 84, 23);
		panel_1.add(lblChatAs);
		
		name = new JTextField();
		name.setBounds(125, 45, 160, 23);
		panel_1.add(name);
		name.setColumns(10);
		
		JLabel v1 = new JLabel("*");
		v1.setForeground(new Color(255, 0, 0));
		v1.setHorizontalAlignment(SwingConstants.CENTER);
		v1.setBounds(115, 71, 160, 17);
		panel_1.add(v1);
		
		JLabel lblPortNo = new JLabel("Port No. :-");
		lblPortNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortNo.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblPortNo.setBounds(10, 91, 95, 23);
		panel_1.add(lblPortNo);
		
		port = new JTextField();
		port.setColumns(10);
		port.setBounds(125, 94, 160, 23);
		panel_1.add(port);
		
		JLabel v2 = new JLabel("*");
		v2.setHorizontalAlignment(SwingConstants.CENTER);
		v2.setForeground(Color.RED);
		v2.setBounds(115, 123, 160, 17);
		panel_1.add(v2);
		
		JLabel lblIpAddress = new JLabel("IP Address :-");
		lblIpAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpAddress.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblIpAddress.setBounds(10, 140, 110, 23);
		panel_1.add(lblIpAddress);
		
		i = new JTextField();
		i.setColumns(10);
		i.setBounds(125, 143, 160, 23);
		panel_1.add(i);
		
		JLabel v3 = new JLabel("*");
		v3.setHorizontalAlignment(SwingConstants.CENTER);
		v3.setForeground(Color.RED);
		v3.setBounds(115, 172, 160, 17);
		panel_1.add(v3);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=name.getText();
				String p=port.getText();
				String ipaddress=i.getText();
				
				
				if(n.isEmpty())
				{
					v1.setText("This field is required");
				}
				
				else if(p.isEmpty())
				{
					v2.setText("This field is required");
				}
				
				else if(ipaddress.isEmpty())
				{
					v3.setText("This field is required");
				}
				
				else
				{
					int po=Integer.parseInt(p);
					cName=n;
					cpNo=po;
					ip=ipaddress;
			
					Client c = new Client();
					dispose();
					c.setVisible(true);
					
				}
			}
		});
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBounds(21, 218, 254, 32);
		panel_1.add(btnNewButton);
		
	
		
		
	}
}

