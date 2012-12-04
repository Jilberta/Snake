import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPlayer extends JFrame implements Player, KeyListener {
	private Direction curDir;
	private Direction newDir;
	private String name;
	private JTextField tf;
	private boolean readyToGiveName = false;

	public MyPlayer() {
		super();
		newDir = Direction.moveToRight;
		JLabel ask = new JLabel("  Enter your name");
		tf = new JTextField();
		JButton ok = new JButton("ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = tf.getText();
				readyToGiveName = true;
			}
		});
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(ask);
		p.add(tf);
		p.add(ok);
		add(p);
		addKeyListener(this);
		setVisible(true);
		showControlPanel(true);
		requestFocus();

	}

	private void showControlPanel(boolean b) {
		if(b)
			setBounds(200, 200, 400, 100);
		else
			setBounds(-500, -500, 400, 100);
	}
	

	@Override
	public Direction getDirection() {
		requestFocus();
		synchronized (newDir) {
			curDir = newDir;
		}
		return curDir;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch ((int) e.getKeyCode()) {
		case 38: // up
			if (curDir != Direction.moveToDown)
				newDir = Direction.moveToUp;
			break;
		case 40: // down
			if (curDir != Direction.moveToUp)
				newDir = Direction.moveToDown;
			break;
		case 37: // left
			if (curDir != Direction.moveToRight)
				newDir = Direction.moveToLeft;
			break;
		case 39: // right
			if (curDir != Direction.moveToLeft)
				newDir = Direction.moveToRight;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}

	@Override
	public String getName() {
		showControlPanel(true);
		while(! readyToGiveName){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		showControlPanel(false);
		return name;
	}

//	public static void main(String[] args) throws InterruptedException {
//		Player p = new MyPlayer();
//		while (true) {
//			Thread.sleep(1000);
//			
//			switch (p.getDirection()) {
//			case moveToUp:
//				System.out.print('^');
//				break;
//			case moveToDown:
//				System.out.print('v');
//				break;
//			case moveToLeft:
//				System.out.print('<');
//				break;
//			case moveToRight:
//				System.out.print('>');
//				break;
//
//			default:
//				break;
//			}
//		}
//	}
}
