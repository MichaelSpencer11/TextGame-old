import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame() {
        this.setTitle("Kessem");
        this.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(420,420);
        this.setVisible(true);
        
        ImageIcon image = new ImageIcon("kuflogobasic.png");
        this.setIconImage(image.getImage());
        
        this.getContentPane().setBackground(Color.black);
	}
}
