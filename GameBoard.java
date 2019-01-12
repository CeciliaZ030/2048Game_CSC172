import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GameBoard extends JFrame implements KeyListener, ActionListener{
	
	JPanel GUI = new JPanel();
	JPanel Board = new JPanel();

	JTextField tf1 = new JTextField(5);
	JTextField tf2  = new JTextField(5);
	JTextField tf3  = new JTextField(5);
	JTextField tf4  = new JTextField(5);
	JTextField tf5  = new JTextField(5);
	JTextField tf6 = new JTextField(5);
	JTextField tf7 = new JTextField(5);
	JTextField tf8 = new JTextField(5);
	JTextField tf9 = new JTextField(5);
	JTextField tf10 = new JTextField(5);
	JTextField tf11 = new JTextField(5);
	JTextField tf12 = new JTextField(5);
	JTextField tf13 = new JTextField(5);
	JTextField tf14 = new JTextField(5);
	JTextField tf15 = new JTextField(5);
	JTextField tf16 = new JTextField(5);

	JButton start = new JButton("Start");
	JButton quit = new JButton("Quit");
	JButton restart = new JButton("Clear");
		

	public GameBoard() {
		
		setLayout(new BorderLayout());
		initialize();
		setUpTF();
		add(GUI, BorderLayout.NORTH);
		add(Board, BorderLayout.SOUTH);
		setSize(450,170);
		setTitle("2048");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}

	public void initialize () {
		
		GUI.setLayout(new FlowLayout());
		GUI.add(quit);
		GUI.add(restart);
		GUI.add(start);
		quit.addActionListener(this);
		restart.addActionListener(this);	
		start.addKeyListener(this);
		
		Board.setLayout(new GridLayout(4,4));
		Board.add(tf1);
		Board.add(tf2);
		Board.add(tf3);
		Board.add(tf4);
		Board.add(tf5);
		Board.add(tf6);
		Board.add(tf7);
		Board.add(tf8);
		Board.add(tf9);
		Board.add(tf10);
		Board.add(tf11);
		Board.add(tf12);
		Board.add(tf13);
		Board.add(tf14);
		Board.add(tf15);
		Board.add(tf16);
		

	}
	
	public void setUpTF() {
		
		tf1.setText(Matrix.entry1.dataToString());
		tf2.setText(Matrix.entry2.dataToString());
		tf3.setText(Matrix.entry3.dataToString());
		tf4.setText(Matrix.entry4.dataToString());
		tf5.setText(Matrix.entry5.dataToString());
		tf6.setText(Matrix.entry6.dataToString());
		tf7.setText(Matrix.entry7.dataToString());
		tf8.setText(Matrix.entry8.dataToString());
		tf9.setText(Matrix.entry9.dataToString());
		tf10.setText(Matrix.entry10.dataToString());
		tf11.setText(Matrix.entry11.dataToString());
		tf12.setText(Matrix.entry12.dataToString());
		tf13.setText(Matrix.entry13.dataToString());
		tf14.setText(Matrix.entry14.dataToString());
		tf15.setText(Matrix.entry15.dataToString());
		tf16.setText(Matrix.entry16.dataToString());	
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(restart)) {
			System.out.println("restart");
			Matrix.clear();
		}
		if(e.getSource().equals(quit)) {
			System.exit(0);  
		}
		setUpTF();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		 int keyCode = e.getKeyCode();
		    switch( keyCode ) { 
		        case KeyEvent.VK_LEFT:
		        		System.out.println("left");
					Matrix.toTheLeft(Matrix.row0);
					Matrix.toTheLeft(Matrix.row1);
					Matrix.toTheLeft(Matrix.row2);
					Matrix.toTheLeft(Matrix.row3);
					Matrix.popRandom();
		            break;
		        case KeyEvent.VK_RIGHT:
		        		System.out.println("right");
					Matrix.toTheRight(Matrix.row0);
					Matrix.toTheRight(Matrix.row1);
					Matrix.toTheRight(Matrix.row2);
					Matrix.toTheRight(Matrix.row3);
					Matrix.popRandom();		            
					break;
		        case KeyEvent.VK_UP:
		        		System.out.println("up");
					Matrix.toTheLeft(Matrix.column0);
					Matrix.toTheLeft(Matrix.column1);
					Matrix.toTheLeft(Matrix.column2);
					Matrix.toTheLeft(Matrix.column3);
					Matrix.popRandom();
		        		break;
		        case KeyEvent.VK_DOWN :
		        		System.out.println("down");
					Matrix.toTheRight(Matrix.column0);
					Matrix.toTheRight(Matrix.column1);
					Matrix.toTheRight(Matrix.column2);
					Matrix.toTheRight(Matrix.column3);
					Matrix.popRandom();
		        		break;
		     }
		Matrix.printRow(Matrix.row0, Matrix.row1, Matrix.row2, Matrix.row3);
		setUpTF();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new GameBoard();
		
	}
}





