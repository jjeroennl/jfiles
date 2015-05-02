import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.awt.GridLayout;

public class Main extends JFrame{
	public String folderSize ;
	public String[] files;
	public JButton fileButton;
	public Main() {
		final program program = new program();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		final JButton btnButon = new JButton("Go");
		
		textField = new JTextField();
		textField.setText("/");
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		final JButton button = new JButton("^");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oneUp;
				String[] oneup;
				oneUp = textField.getText();
				oneup = oneUp.split("/");
				if(oneUp.endsWith("/")){
					textField.setText(oneUp.replace(oneup[oneup.length -1] + "/", ""));
					btnButon.doClick();
				}
				else{
					textField.setText(oneUp.replace(oneup[oneup.length -1], ""));
					btnButon.doClick();
				}
			}
		});
		panel_1.add(button);
		panel_1.add(textField);
		
		textField.setColumns(20);
		
		
		final JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(3, 5, 0, 0));
		
		
		btnButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					getList l = new getList();
					
					ArrayList<String> list = l.get(textField.getText());
					
			       
			        	files = list.toArray(new String[list.size()]);
			        
			        	folderSize = files[0].replace("total", "");
			        
			        	panel_2.removeAll();
			        
			        	for(int i = 0; i != files.length; i++){
			        		final int number = i;
			        	
			        	
			        		JPanel file = new JPanel();
			        		file.setLayout(new GridLayout(2, 1, 0, 0));
			    		

			        		Image image = null;
			        		try {
			        			geticon i1 = new geticon();
			        			String icon = i1.grab(textField.getText());
			        			File sourceimage = new File(icon);
			        			image = ImageIO.read(sourceimage);
			        		} catch (IOException e1) {
			        			e1.printStackTrace();
			        		}
			        		
			        		JLabel label = new JLabel(new ImageIcon(image));

			        		file.add(label, "push, align center");
			        		JLabel fileButton = new JLabel(files[i]);
			        	
			        		file.setLayout(new GridLayout(2, 1, 0, 0));
			      
			        		file.add(fileButton, BorderLayout.CENTER);
			        	
			        		fileButton.addMouseListener(new MouseAdapter() {
			        			public void mouseClicked(MouseEvent e) {
			    					if(files[number].contains("~")){
			    					
			    					}
			    					else if(files[number].contains(".")){
			    				
			    						program.launch(textField.getText(), files[number]);
			    					
			    					}
			    				
			    					else{
			    						if(textField.getText().endsWith("/")){
			    							textField.setText(textField.getText() + files[number]);
			    							btnButon.doClick();
			    							
			    						}
			    						else{
			    							textField.setText(textField.getText() + "/" + files[number]);
			    							btnButon.doClick();
			    						}
			    					}
			    				}
			        		});
			        		panel_2.add(file, BorderLayout.CENTER);
			        		validate();
			        		repaint();
			        	
			        	}
			        
			        /*} catch (Exception e1){
			        	System.out.println(e1.toString());
			        	panel_2.removeAll();
			        	validate();
			        	repaint();
			        	JLabel errormessage = new JLabel("This folder is empty or you do not have sufficient rights to open this folder.");
			        	panel_2.add(errormessage);
			        	validate();
			        	repaint();
			        }*/
				}
		});
		panel_1.add(btnButon);
		btnButon.doClick();

		

	}

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public static void main(String[] args) {

		JFrame frame = new Main();
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Files");
		frame.setVisible(true);	
		
	}
}
