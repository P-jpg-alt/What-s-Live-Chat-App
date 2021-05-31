package chatApp;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ServerStart extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField port;
    static int pNo;
    static Socket socket;
    public static Vector client = new Vector();
   
    static String grpName;
    
    
    
	public ServerStart(Socket socket)
	{
		try
		{
            ServerStart.socket = socket;
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ServerStart() {
		
		
		setType(Type.POPUP);
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
		logo.setBounds(10, 0, 61, 55);
		ImageIcon r=new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\src\\chatIcons\\LogoMakr-4ha8sn (1).png");
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
		
		JLabel lblChatAs = new JLabel("Enter Port No. to Start the group");
		lblChatAs.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblChatAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblChatAs.setBounds(0, 39, 297, 23);
		panel_1.add(lblChatAs);
		
		JLabel lblPortNo = new JLabel("Port No. :-");
		lblPortNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortNo.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblPortNo.setBounds(22, 91, 95, 23);
		panel_1.add(lblPortNo);
		
		port = new JTextField();
		port.setColumns(10);
		port.setBounds(127, 94, 160, 23);
		panel_1.add(port);
		
		JLabel v2 = new JLabel("*");
		v2.setHorizontalAlignment(SwingConstants.CENTER);
		v2.setForeground(Color.RED);
		v2.setBounds(115, 123, 160, 17);
		panel_1.add(v2);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p=port.getText();
				
			    if(p.isEmpty())
				{
					v2.setText("This field is required");
				}
				
				else
				{
					int po=Integer.parseInt(p);
					pNo=po;
					dispose();
		           
					ServerSocket s;
					try 
					{
						s = new ServerSocket(po);
						JOptionPane.showMessageDialog(null,"SERVER STARTED....");
						while(true){
				            Socket socket = s.accept();
				            ServerStart server = new ServerStart(socket);
				            Thread thread = new Thread(server);
				            thread.start();
				        }
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}
			        
				
				}
			}
		});
		btnNewButton.setBackground(new Color(46, 139, 87));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnNewButton.setBounds(21, 151, 254, 32);
		panel_1.add(btnNewButton);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				try
				{
					
					ServerStart frame = new ServerStart();
					frame.setVisible(true);	
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}


	@Override
	public void run(){
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            client.add(writer);
            
            while(true){
                String data = reader.readLine().trim();
              
                
                for(int i = 0; i < client.size(); i++){
                    try{
                        PrintWriter bw = (PrintWriter)client.get(i);
                        bw.write(data);
                        bw.write("\r\n");
                        bw.flush();
                    }catch(Exception e){}
                }
                
            }
        }catch(Exception e){}
        
        
    }
}
