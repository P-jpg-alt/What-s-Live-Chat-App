package chatApp;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

class Client extends JFrame implements ActionListener{

	private JPanel contentPane;
	private static JTextArea textArea;
	private JTextField message;
	static ServerSocket server;
    static Socket client;
    static BufferedReader br;
    static PrintWriter out;
    
    Boolean typing;
	public Client() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(0, 0, 316, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel back = new JLabel("");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					int yesOrNo=JOptionPane.showConfirmDialog(null,"Do you want to Close Connection with Server..?");
					if(yesOrNo==0)
					{
					    dispose();
					    client.close();
						JOptionPane.showMessageDialog(null,"Connection Closed!");
					}
					
				    
				} catch (Exception e1) {
					
				}
			}
		});
		back.setBounds(0, 10, 33, 33);
		ImageIcon i=new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\src\\chatIcons\\back.png");
		Image image=i.getImage();
		Image imgScale=image.getScaledInstance(back.getWidth(),back.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon scaledIcon=new ImageIcon(imgScale); 
		back.setIcon(scaledIcon); 
		panel.add(back);
		
		JLabel profile = new JLabel("");
		profile.setBounds(25, 0, 52, 55);
		ImageIcon i1=new ImageIcon("C:\\\\Users\\\\pritamsing\\\\OneDrive\\\\Desktop\\\\Group Chatting App\\\\src\\\\chatIcons\\\\LogoMakr-4ha8sn (1).png");
		Image image1=i1.getImage();
		Image imgScale1=image1.getScaledInstance(profile.getWidth(),profile.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1=new ImageIcon(imgScale1); 
		profile.setIcon(scaledIcon1); 
		panel.add(profile);
		
		JLabel lblPritam = new JLabel(ClientStart.cName);
		lblPritam.setForeground(Color.WHITE);
		lblPritam.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblPritam.setBounds(77, 10, 121, 25);
		panel.add(lblPritam);
		
		JButton btnNewButton = new JButton("HealthTick");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\health4.jpg"));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(218, 0, 88, 55);
	
		btnNewButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	           {
	               new HealthTick("Self Assessment");
	           }
			
	       });		
		panel.add(btnNewButton);
		
	    
		JLabel lblNewLabel = new JLabel("Active Now");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(77, 36, 131, 19);
		panel.add(lblNewLabel);
		
	    Timer t = new Timer(1, new ActionListener(){
	        public void actionPerformed(ActionEvent ae){
	            if(!typing){
	            	lblNewLabel.setText("Active Now");
	            }
	        }
	    });
	    
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 440, 316, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		message = new JTextField();
		message.setBounds(40, 0, 189, 40);
		panel_1.add(message);
		message.setColumns(10);
	    
	    message.addKeyListener(new KeyAdapter(){
	        public void keyPressed(KeyEvent ke){
	        	lblNewLabel.setText(ClientStart.cName+"is typing...");
	            
	            t.stop();
	            
	            typing = true;
	        }
	        
	        public void keyReleased(KeyEvent ke){
	            typing = false;
	            
	            if(!t.isRunning()){
	                t.start();
	            }
	        }
	    });
	    
	    t.setInitialDelay(1500);
		

		
	
		

		
	
		
		JLabel send = new JLabel("");
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startWriting();
			}
		});
		send.setBounds(261, 0, 45, 40);
		ImageIcon i6=new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\src\\chatIcons\\send.jpeg");
		Image image6=i6.getImage();
		Image imgScale6=image6.getScaledInstance(send.getWidth(),send.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon scaledIcon6=new ImageIcon(imgScale6); 
		send.setIcon(scaledIcon6);
		panel_1.add(send);
		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 55, 308, 386);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("SansSerif", Font.BOLD, 15));
		scrollPane.setViewportView(textArea);
		
		startClient();
		startReading();
		
	}
	
	public static void startClient()
	{
		try
		{
		 client=new Socket(ClientStart.ip,ClientStart.cpNo);
	     br=new BufferedReader(new InputStreamReader(client.getInputStream()));
	 	 out=new PrintWriter(client.getOutputStream());
		
 	     
		}
		catch(Exception e)
		{
			
		}
	}
	
	public  void startReading()
    {
		Runnable r1=()->{
				
    	try
    	{		
    		while(true)
    		{
    			String msg=br.readLine();
    			if(!msg.isEmpty())
    			{
    				if(textArea.getText().isEmpty())
    				{
    					 Calendar cal = Calendar.getInstance();
    				     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    					textArea.setText(msg+"\n"+sdf.format(cal.getTime()));
    					msg="";	
    				}
    				
    				else
    				{
    					 Calendar cal = Calendar.getInstance();
    				     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    					textArea.setText(textArea.getText()+"\n"+msg+"\n"+sdf.format(cal.getTime()));
    					msg="";
    				}
    			}
    		}
    	}
    	catch(Exception e)
    	{
    		
    	}
    		
    	};
    	
    	new Thread(r1).start();
    }
    
    public void startWriting()
    {
    	
    		try
        	{	
    			String msg=message.getText();
    			sendTextToFile(msg);
    			if(!msg.isEmpty())
    			{
    				if(textArea.getText().isEmpty())
    				{
    					Calendar cal = Calendar.getInstance();
    				    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    		//			textArea.setText("\t\t"+msg+"\n\t\t\t"+sdf.format(cal.getTime()));
    					message.setText("");
    					out.println(ClientStart.cName+" : "+msg);
    					out.flush();
    				}
    				
    				else
    				{
    					Calendar cal = Calendar.getInstance();
    				     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    		//			textArea.setText(textArea.getText()+"\n\t\t"+msg+"\n\t\t\t"+sdf.format(cal.getTime()));
    					message.setText("");
    					out.println(ClientStart.cName+" : "+msg);
    					out.flush();
    				}
    				
    			}
        	}
        	catch(Exception e)
        	{
        		
        	}
    
    }
    
    public void sendTextToFile(String messages) throws FileNotFoundException
    {
        try(FileWriter f=new FileWriter("Client.chat.txt",true);
        	PrintWriter p= new PrintWriter(new BufferedWriter(f));){
            p.println(client+" "+ClientStart.cName+"->"+messages);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }    

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
	}
}
