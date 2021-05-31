package chatApp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

class HealthTick extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[10];
	JButton btnNext, btnAnalyze;
	ButtonGroup bg;
	int count = 0,cc=0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];
	private JLabel lblhealthLabel;

	
	HealthTick(String s) {
		super(s);
		setResizable(false);
		getContentPane().setBackground(SystemColor.menu);
		label = new JLabel();
		getContentPane().add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 9; i++) {
			radioButton[i] = new JRadioButton();
			getContentPane().add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnAnalyze = new JButton("Analyzing...");
		
		btnNext.addActionListener(this);
		btnAnalyze.addActionListener(this);
		getContentPane().add(btnNext);
		getContentPane().add(btnAnalyze);
		set();
		label.setBounds(30, 40, 450, 20);
		//radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 2000, 20);
		btnNext.setBounds(90, 258, 122, 39);
		btnAnalyze.setBounds(253, 258, 106, 39);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		lblhealthLabel = new JLabel("");
		lblhealthLabel.setIcon(new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\health2.jpg"));
		lblhealthLabel.setBounds(462, 300, 224, 183);
		getContentPane().add(lblhealthLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Imageslider();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\pritamsing\\OneDrive\\Desktop\\Group Chatting App\\bin\\chatIcons\\h5.jpg"));
		btnNewButton.setBounds(0, 307, 212, 176);
		getContentPane().add(btnNewButton);
		setLocation(250, 100);
		setVisible(true);
		setSize(700, 520);
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnAnalyze.setText("Result ->");
				btnAnalyze.setBackground(Color.RED);
			}
		}
		if (e.getActionCommand().equals("Analyze")) {
			JButton bk = new JButton("Analyze" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			getContentPane().add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnAnalyze.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Analyze" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result ->")) {
			if (check())
				count = count + 1;
                cc= (count/1)*10;
			current++;
                if(cc==0){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE in danger NOW, Dont Panic Quickly call on below Phone no \n9167281178\n ,Stay at that place only Dont interact with anyone until our further measures !");
                    
					
                }
                else if(cc==10){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE in danger NOW, Dont Panic Quickly call on below Phone no \n9167281178\n ,Stay at that place only Dont interact with anyone until our further measures !");
                    
					
                }
                else if(cc==20){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE in danger NOW, Dont Panic Quickly call on below Phone no \n9167281178\n ,Stay at that place only Dont interact with anyone until our further measures !");
                    
					
                }
                else if(cc==30){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE in danger NOW, Dont Panic Quickly call on below Phone no \n9167281178\n ,Stay at that place only Dont interact with anyone until our further measures !");
                    
					
                }
                else if(cc==40){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE Not at all SAFE NOW,  Dont Panic Quickly call on below Phone no \n9167281178\n ,Stay at that place only Dont interact with anyone until our further measures !");
                    
                }
                else if(cc==50){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE Not at all SAFE NOW,  Dont Panic Quickly call on below Phone no \n9167281178\n ,Stay at that place only Dont interact with anyone until our further measures !");
                    
                }
                else if(cc==60){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE Not at all SAFE NOW,  Dont Panic Quickly call on below Phone no \n9167281178\n ,Stay at that place only Dont interact with anyone until our further measures !");
                    
                }
                else if(cc==70){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE not SAFE might be infected take a leave as soon as possible and be in quarantine for a week, Call us on below phone no if anything else you you may suffering\n9167281178");
                    
                }
                else if(cc==80){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE ok quite suspicious by analysing so please requestig to stay at home only maintain distance with family members also and Dont think to go anywhere IF NEEDED\nTake Necessary precaution and wear Masks\nGive this Self Assesment atleast Once a day!");
                    
                }
                else if(cc==90){
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE SAFE NOW, but do check your health status twice a day and STEP OUT ONLY IF NEEDED\nTake Necessary precaution and wear Masks\nGive this Self Assesment atleast Once a day!");
                    
                }
                else{
                    JOptionPane.showMessageDialog(this, "Your Safety measures is about= " + cc+" Percents\nYOU ARE totally SAFE NOW, BUT STEP OUT ONLY IF NEEDED\nTake Necessary precaution and wear Masks\nGive this Self Assesment atleast Once a day!");
                      
                }  
                try {
					FileWriter f=new FileWriter("HealthClient.chat.txt",true);
					BufferedWriter bw=new BufferedWriter(f);
					bw.write(ClientStart.cName+"'s"+" "+"Current Health Status is ->"+cc+"%\n");
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                dispose();
                
       

            

		}
	}

	
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  How You Are Feeling Today?");
			radioButton[0].setText("Great");
			radioButton[1].setText("Not able to identify");
			radioButton[2].setText("Not so Good maybe infected");
			radioButton[3].setText("Not Infected but having some other health issues ");
			
		}
		if (current == 1) {
			label.setText("Que2:  Are you experiencing any of the following Symptoms ?");
			radioButton[0].setText("Cough/Fever");
			radioButton[1].setText("Difficulty in Breathing");
			radioButton[2].setText("Loss of sense of smell and taste");
			radioButton[3].setText("None of these");
		}
		if (current == 2) {
			label.setText("Que3: Have you ever had any of these?");
			radioButton[0].setText("Diabetes");
			radioButton[1].setText("Heart Disease");
			radioButton[2].setText("Hypertension");
			radioButton[3].setText("None of these");
		}
		if (current == 3) {
			label.setText("Que4: Have you ever travel anywhere internationally in the last 20-30 days?");
			radioButton[0].setText("yes");
			radioButton[1].setText("no");
			radioButton[2].setText("Not sure");
			radioButton[3].setText("Not Internationally but travel in home Country");
		}
		if (current == 4) {
			label.setText("Que5:  Which of the following apply to you?");
			radioButton[0].setText(" I have interacted with someone who has tested positive for COVID-19");
			radioButton[1].setText("I am healthcare worker and examined patient without any safety measures");
			radioButton[2].setText("Not sure but came into contact with much crowd");
			radioButton[3].setText("None of these");
		}
        
		if (current == 5) {
			label.setText("Que6: What is your oxygen level");
			radioButton[0].setText("Below 95");
			radioButton[1].setText("Don't know");
			radioButton[2].setText("Above <= 95");
			radioButton[3].setText("Maybe,Having breath issues");
		}
		if (current == 6) {
			label.setText("Que7: What is your body temperature");
			radioButton[0].setText("Don't know but feeling fever");
			radioButton[1].setText("Below 36 degree");
			radioButton[2].setText("Between 36.1-37.2 degree");
			radioButton[3].setText("Above 38 degree");
		}
		if (current == 7) {
			label.setText("Que8:  Describe about your daily job");
			radioButton[0].setText("Mandatory work");
			radioButton[1].setText("Work from home");
			radioButton[2].setText("Alternate days work");
			radioButton[3].setText("Not guided yet");
		}
		if (current == 8) {
			label.setText("Que9: Have you tested negative before but still feeling infected ");
			radioButton[0].setText("Yes");
			radioButton[1].setText("Maybe");
			radioButton[2].setText("No");
			radioButton[3].setText("No, I haven't done the test before");
		}
		if (current == 9) {
			label.setText("Que10: Have you taken a Vaccine");
			radioButton[0].setText("Yes, and now feeling well");
			radioButton[1].setText("No");
			radioButton[2].setText("Not yet,But Registered");
			radioButton[3].setText("Yes, but still feeling infected");  
		}
        
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 450, 20);
	}

	
	boolean check() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[3].isSelected());
		if (current == 2)
			return (radioButton[3].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[3].isSelected());
		if (current == 5)
			return (radioButton[2].isSelected());
		if (current == 6)
			return (radioButton[2].isSelected());
		if (current == 7)
			return (radioButton[1].isSelected());
		if (current == 8)
			return (radioButton[2].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new HealthTick("Self Assesment Test");
	}
}