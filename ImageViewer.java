/** Daniel Genberg */

package Bonusuppgift10;

import javax.imageio.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.*;
/**
 * Denna klass g�r s� att man kan bl�ddra mellan tv� bilder genom att trycka p�
 * en knapp
 */

public class ImageViewer extends JFrame {
	private JLabel imageLabel;
	private JButton button;
	private Icon imageTeater;
	private Icon imageVetenskap;
	private JPanel pane;

	private boolean whichImage = false; // falskt = teater och �ndras n�r bilderna �ndras

	/**
	 * Detta �r konstruktorn d�r knappen "button" med texten "change" l�ggs till
	 * samt bilderna introduceras. JLabel:en och JButton:en stoppas in i en JPanel
	 * som g�rs till "contentPane"
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
			JLabel imageLabel = new JLabel(imageTeater); // B�rjar med teaterbilden

			pane.add(button);
			pane.add(imageLabel);

			setContentPane(pane);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			pack();
			setVisible(true);

			/** En anonym klass som �ndrar bilden genom interface actionlistener */

			button.addActionListener(new ActionListener() {
				{
				}

				/**
				 * Denna kontrollerar ifall whichImage �r true eller false och beroende p� det
				 * s� kommer bilderna �ndras n�r man trycker p� "Change" beh�vs f�r anv�nda
				 * interface actionlistener
				 */
				public void actionPerformed(ActionEvent arg0) {

					if (whichImage == false) {
						imageLabel.setIcon(imageVetenskap); // G�r s� att bilden p� vetenskapshuset kommer upp
						whichImage = true;
					} else {
						imageLabel.setIcon(imageTeater);// G�r s� att bilden p� teatern kommer upp
						whichImage = false;
					}

				}

			});

		} catch (Exception e) { // F�ngar det generella undantaget
			throw new Exception();
		}
	}

	/**
	 * Detta �r main-metoden som g�r att programmet k�rs och att man kan se bilden
	 */

	public static void main(String args[]) throws Exception {
		ImageViewer window = new ImageViewer();
	}
}
