/** Daniel Genberg */

package Bonusuppgift10;

import javax.imageio.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.*;
/**
 * Denna klass gör så att man kan bläddra mellan två bilder genom att trycka på
 * en knapp
 */

public class ImageViewer extends JFrame {
	private JLabel imageLabel;
	private JButton button;
	private Icon imageTeater;
	private Icon imageVetenskap;
	private JPanel pane;

	private boolean whichImage = false; // falskt = teater och ändras när bilderna ändras

	/**
	 * Detta är konstruktorn där knappen "button" med texten "change" läggs till
	 * samt bilderna introduceras. JLabel:en och JButton:en stoppas in i en JPanel
	 * som görs till "contentPane"
	 * 
	 * @throws Exception
	 */
	public ImageViewer() throws Exception {
		try {
			JButton button = new JButton("Change");
			JPanel pane = new JPanel();

			URL teater = new URL("http://www.sm.luth.se/csee/courses/d0010e/l/prob/10tj5Ei9o/LTU-Teatern.jpg");
			URL vetenskap = new URL(
					"http://www.sm.luth.se/csee/courses/d0010e/l/prob/10tj5Ei9o/LTU-Vetenskapens-hus.jpg");

			Icon imageTeater = new ImageIcon(ImageIO.read(teater));
			Icon imageVetenskap = new ImageIcon(ImageIO.read(vetenskap));
			JLabel imageLabel = new JLabel(imageTeater); // Börjar med teaterbilden

			pane.add(button);
			pane.add(imageLabel);

			setContentPane(pane);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pack();
			setVisible(true);

			/** En anonym klass som ändrar bilden genom interface actionlistener */

			button.addActionListener(new ActionListener() {
				{
				}

				/**
				 * Denna kontrollerar ifall whichImage är true eller false och beroende på det
				 * så kommer bilderna ändras när man trycker på "Change" behövs för använda
				 * interface actionlistener
				 */
				public void actionPerformed(ActionEvent arg0) {

					if (whichImage == false) {
						imageLabel.setIcon(imageVetenskap); // Gör så att bilden på vetenskapshuset kommer upp
						whichImage = true;
					} else {
						imageLabel.setIcon(imageTeater);// Gör så att bilden på teatern kommer upp
						whichImage = false;
					}

				}

			});

		} catch (Exception e) { // Fångar det generella undantaget
			throw new Exception();
		}
	}

	/**
	 * Detta är main-metoden som gör att programmet körs och att man kan se bilden
	 */

	public static void main(String args[]) throws Exception {
		ImageViewer window = new ImageViewer();
	}
}
