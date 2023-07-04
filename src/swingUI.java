import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class swingUI implements ActionListener{
	
	JFrame frame= new JFrame();
	JPanel panel= new JPanel();
	JTextField textfield= new JTextField();
    JButton [] numberButtons= new JButton[10];
    JButton [] functionButtons= new JButton[8];
    JButton  delButton,mulButton,divButton,addButton,
    		   subButton,clrButton,decButton,equButton;
    
    char operator;
    double num1, num2, result;
    Font myFont= new Font("MV Boli",Font.BOLD,35);
    
   
	swingUI(){
	
		frame.setSize(600,600);
		frame.setTitle("My Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
		textfield.setBounds(150, 0, 300, 50);
		textfield.setEditable(false);
		textfield.setFont(new Font("InkFree",Font.ITALIC,60));
		
		panel.setBounds(150,80,300,300);
		panel.setLayout(new GridLayout(4,4,2,2));
//		panel.setBackground(Color.CYAN);
		
		
		   numberButtons[0]= new JButton();
	       numberButtons[1]= new JButton();
	       numberButtons[2]= new JButton();
	       numberButtons[3]= new JButton();
	       numberButtons[4]= new JButton();
	       numberButtons[5]= new JButton();
	       numberButtons[6]= new JButton();
	       numberButtons[7]= new JButton();
	       numberButtons[8]= new JButton();
	       numberButtons[9]= new JButton();
	       
		for(int i=0; i<10;i++){
			numberButtons[i]= new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(myFont);
		}
		
		addButton= new JButton("+");
		subButton= new JButton("-");
		divButton= new JButton("/");
		mulButton= new JButton("*");
		decButton= new JButton(".");
		equButton= new JButton("=");
		delButton= new JButton("delete");
		clrButton= new JButton("clear");
		
		functionButtons[0]= addButton;
		functionButtons[1]= subButton;
		functionButtons[2]= divButton;
		functionButtons[3]= mulButton;
		functionButtons[4]= decButton;
		functionButtons[5]= equButton;
		functionButtons[6]= delButton;
		functionButtons[7]= clrButton;
		
		for(int i=0; i<8;i++){
			
		functionButtons[i].addActionListener(this);
		functionButtons[i].setFocusable(false);
		functionButtons[i].setFont(myFont);
		}
		
       
       panel.add( numberButtons[1]);
       panel.add( numberButtons[2]);
       panel.add( numberButtons[3]);
       panel.add(addButton);
       
       panel.add( numberButtons[4]);
       panel.add( numberButtons[5]);
       panel.add( numberButtons[6]);
       panel.add(subButton);
       
       panel.add( numberButtons[7]);
       panel.add( numberButtons[8]);
       panel.add( numberButtons[9]);
       panel.add(divButton);
       
       panel.add(mulButton);
       panel.add( numberButtons[0]);
       panel.add(decButton);
       panel.add(equButton);
       
       delButton.setBounds(150,400,150,50);
      clrButton.setBounds(300,400,150,50);
		
      frame.add(delButton);
      frame.add(clrButton);
      
	  frame.add(textfield);
	  frame.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//adds the number buttons functionality
		for(int i=0;i<10;i++) {
			if(e.getSource()==numberButtons[i]) {
			textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		//adds decimal button functionality
		if(e.getSource()==decButton) {
		textfield.setText(textfield.getText().concat("."));	
		}
		
		//adds the function buttons
		if(e.getSource()==addButton) {
		num1= Double.parseDouble(textfield.getText());
		operator='+';
		
		textfield.setText("");
		}
		
		if(e.getSource()==subButton) {
			num1= Double.parseDouble(textfield.getText());
			operator='-';
			
			textfield.setText("");
		
		}
		
		if(e.getSource()==divButton) {
			num1= Double.parseDouble(textfield.getText());
			operator='/';
			
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1= Double.parseDouble(textfield.getText());
			operator='*';
			
			textfield.setText("");
		}
		
//		adds the equals buttons functionality
		if(e.getSource()==equButton) {
			
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'/':
				result=num1/num2;
				break;
			case'*':
				result=num1*num2;
				break;
				
			}
			
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		
//		add clear and delete buttons functionality
		if(e.getSource()==clrButton) {
		textfield.setText("");	
		}
		
		if(e.getSource()==delButton) {
			String string=textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+ string.charAt(i));
			}
		}
	}
}