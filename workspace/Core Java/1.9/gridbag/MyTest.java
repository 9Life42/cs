package gridbag;

import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTest extends JFrame {

	public MyTest() {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		add(new JButton("Sneaky"), new GBC(0, 0, 2, 1).setFill(GBC.BOTH).setWeight(100, 100));
		add(new JButton("S"), new GBC(2, 0, 1, 2).setFill(GBC.BOTH).setWeight(100, 100));
		add(new JButton("S"), new GBC(0, 1, 1, 2).setFill(GBC.BOTH).setWeight(100, 100));
		add(new JButton("Sneaky"), new GBC(1, 2, 2, 1).setFill(GBC.BOTH).setWeight(100, 100));
		add(new JPanel(), new GBC(1, 1, 1, 1).setFill(GBC.BOTH).setWeight(100, 100));
		
//		for (int x = 0; x < 3; x++) {
//			for (int y = 1; y < 3; y++) {
//				add(new JButton(x + ", " + y), new GBC(x, y));
//			}
//		}
		
//		JButton a = new JButton();
//		JButton b = new JButton();
//		
//		add(a, new GBC(0, 0));
//		add(b, new GBC(1, 2));
		
		pack();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MyTest();
				frame.setTitle("MyTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}