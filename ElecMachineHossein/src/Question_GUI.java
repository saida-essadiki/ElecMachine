import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Question_GUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnNewRadioButton_00;
	private JRadioButton rdbtnNewRadioButton_01;
	private JRadioButton rdbtnNewRadioButton_02;
	private JRadioButton rdbtnNewRadioButton_03;
	private JRadioButton rdbtnNewRadioButton_04;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question_GUI frame = new Question_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Question_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("question");
		lblNewLabel.setBounds(61, 42, 272, 41);
		contentPane.add(lblNewLabel);
		
		
		rdbtnNewRadioButton_00 = new JRadioButton("1");
		rdbtnNewRadioButton_00.setBounds(61, 112, 167, 23);
		contentPane.add(rdbtnNewRadioButton_00);
		
		rdbtnNewRadioButton_01 = new JRadioButton("2");
		rdbtnNewRadioButton_01.setBounds(61, 138, 167, 23);
		contentPane.add(rdbtnNewRadioButton_01);
		
		rdbtnNewRadioButton_02 = new JRadioButton("3");
		rdbtnNewRadioButton_02.setBounds(61, 164, 167, 23);
		contentPane.add(rdbtnNewRadioButton_02);
		
		rdbtnNewRadioButton_03 = new JRadioButton("4");
		rdbtnNewRadioButton_03.setBounds(61, 190, 167, 23);
		contentPane.add(rdbtnNewRadioButton_03);
		
		rdbtnNewRadioButton_04 = new JRadioButton("5");
		rdbtnNewRadioButton_04.setBounds(61, 216, 167, 23);
		contentPane.add(rdbtnNewRadioButton_04);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton_00);
		G.add(rdbtnNewRadioButton_01);
		G.add(rdbtnNewRadioButton_02);
		G.add(rdbtnNewRadioButton_03);
		G.add(rdbtnNewRadioButton_04);

		
		btnNewButton = new JButton("Next question");
		btnNewButton.setBounds(292, 216, 107, 23);
		contentPane.add(btnNewButton);
	}
}
