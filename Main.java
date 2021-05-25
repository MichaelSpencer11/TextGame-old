import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//the main method. Java needs this to run the stuff
//I try to have this do as little as possible and have the classes do all the work

public class Main{
	
    public static void main(String[] args){    
    	//World world = new World();
        //world.createWorld();
        JFrame frame = new JFrame();
        frame.setTitle("Kessem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(420,420);
        frame.setVisible(true);
        
        ImageIcon image = new ImageIcon("kuflogobasic.png");
        frame.setIconImage(image.getImage());
        
        frame.getContentPane().setBackground(Color.black);
    }
}