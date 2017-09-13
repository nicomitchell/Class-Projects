/******************
Nicolas Mitchell
CECS 220-01
Assignment 03
Problem 02
******************/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JFrame;

public class StyleOptionsPanelApp
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Style Options");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		StyleOptionsPanel panel = new StyleOptionsPanel();
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
public class StyleOptionsPanel extends JPanel
{
	private JLabel	saying;
	private JCheckBox	bold, italic;
	private JTextField size;
	public StyleOptionsPanel()
	{
		saying = new JLabel("Say it with style!");
		saying.setFont(new Font("Helvetica", Font.PLAIN, 36));

		bold = new JCheckBox("Bold");
		bold.setBackground(Color.cyan);
		italic = new JCheckBox("Italic");
		italic.setBackground(Color.cyan);
		size = new JTextField(10);
		size.setBackground(Color.white);

		size.setEditable(true);

		StyleListener listener = new StyleListener();
		bold.addItemListener(listener);
		italic.addItemListener(listener);
		size.addActionListener(listener);

		add(saying);
		add(bold);
		add(italic);
		add(size);

		setBackground(Color.cyan);
		setPreferredSize(new Dimension(300, 100));
	}

	private class StyleListener implements ItemListener, ActionListener
	{
		int style = Font.PLAIN;
		int sizeValue = 32;
		public void itemStateChanged(ItemEvent event)
		{
			style = Font.PLAIN;
			if (bold.isSelected())
				style += Font.BOLD;

			if (italic.isSelected())
				style += Font.ITALIC;

			saying.setFont(new Font("Helvetica", style, sizeValue));
		}
		public void actionPerformed(ActionEvent event)
		{
			String sizeContent = size.getText();
			sizeValue = Integer.parseInt(sizeContent);
			saying.setFont(new Font("Helvetica", style, sizeValue));
		}
	}

}
