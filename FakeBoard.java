import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FakeBoard extends JFrame implements KeyListener{
	
	JPanel Board = new JPanel();
	JButton button = new JButton("hello");
	JLabel Label = new JLabel("FUck you");


	public FakeBoard() {
		
		setLayout(new BorderLayout());
		initialize();
		add(Board, BorderLayout.SOUTH);
		setSize(450,170);
		setTitle("fake");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void initialize () {
		
		Board.addKeyListener(this);
		Board.setLayout(new FlowLayout());
		button.addKeyListener(this);
		Board.add(button);
		
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
		        case KeyEvent.VK_UP:
		        		System.out.println("a");
		        		break;
		        case KeyEvent.VK_DOWN:
		        		System.out.println("d");
		        		break;
		        case KeyEvent.VK_LEFT:
		        		System.out.println("w");
		        		break;
		        case KeyEvent.VK_RIGHT :
	        		System.out.println("s");
		        		break;
		     }
		    
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new FakeBoard();
		
	}

}
