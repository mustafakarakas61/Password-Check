package MainPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainClass extends JFrame {

	private JPanel contentPane;
	private JPasswordField txt_pass1;
	private JPasswordField txt_pass2;
	private JButton btn_Control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass frame = new MainClass();
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
	public MainClass() {
		setTitle("Password Check");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 224, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbl_Password1 = new JLabel("Password:");
		lbl_Password1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Password1.setBounds(10, 31, 150, 20);
		contentPane.add(lbl_Password1);

		txt_pass1 = new JPasswordField();
		txt_pass1.setBounds(163, 33, 201, 20);
		txt_pass1.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || ke.getKeyChar() == '.' || ke.getKeyChar() == '?' || ke.getKeyChar() == '!'
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (txt_pass1.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						txt_pass1.setEditable(true);
					} else {
						txt_pass1.setEditable(false);
					}

				} else {
					txt_pass1.setEditable(false);

				}
			}
		});
		contentPane.add(txt_pass1);

		JLabel lbl_Password2 = new JLabel("Re-enter password:");
		lbl_Password2.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lbl_Password2.setBounds(10, 54, 150, 20);
		contentPane.add(lbl_Password2);

		txt_pass2 = new JPasswordField();
		txt_pass2.setBounds(163, 56, 201, 20);
		txt_pass2.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() == ' ' || ke.getKeyChar() == '.' || ke.getKeyChar() == '?' || ke.getKeyChar() == '!'
						|| (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z')
						|| (ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z')
						|| (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')
						|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE || ke.getKeyCode() == KeyEvent.VK_ENTER
						|| ke.getKeyCode() == KeyEvent.VK_SHIFT || ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK
						|| ke.getKeyCode() == KeyEvent.VK_ESCAPE) {

					if (txt_pass2.getText().length() <= 30 || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
							|| ke.getKeyCode() == KeyEvent.VK_ENTER || ke.getKeyCode() == KeyEvent.VK_SHIFT
							|| ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK || ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
						txt_pass2.setEditable(true);
					} else {
						txt_pass2.setEditable(false);
					}

				} else {
					txt_pass2.setEditable(false);

				}
			}
		});
		contentPane.add(txt_pass2);

		JLabel lbl_Eye = new JLabel();
		lbl_Eye.setBounds(374, 31, 20, 22);
		ImageIcon imageIcon = new ImageIcon(MainClass.class.getResource("/Images/eyeOff.png"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(22, 20, java.awt.Image.SCALE_SMOOTH);
		lbl_Eye.setIcon(new ImageIcon(newimg));
		lbl_Eye.addMouseListener(new MouseAdapter() {
			boolean eye = false;

			@Override
			public void mouseClicked(MouseEvent e) {

				if (!eye) {
					ImageIcon imageIcon = new ImageIcon(MainClass.class.getResource("/Images/eyeOn.png"));
					Image image = imageIcon.getImage();
					Image newimg = image.getScaledInstance(22, 20, java.awt.Image.SCALE_SMOOTH);
					lbl_Eye.setIcon(new ImageIcon(newimg));

					txt_pass1.setEchoChar((char) 0);
					txt_pass2.setEchoChar((char) 0);

					eye = true;
				} else {
					ImageIcon imageIcon = new ImageIcon(MainClass.class.getResource("/Images/eyeOff.png"));
					Image image = imageIcon.getImage();
					Image newimg = image.getScaledInstance(22, 20, java.awt.Image.SCALE_SMOOTH);
					txt_pass1.setEchoChar('*');
					txt_pass2.setEchoChar('*');
					lbl_Eye.setIcon(new ImageIcon(newimg));
					eye = false;
				}
				super.mouseClicked(e);
			}
		});
		contentPane.add(lbl_Eye);

		btn_Control = new JButton("Test");
		btn_Control.setBackground(new Color(233, 150, 122));
		btn_Control.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Control.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(txt_pass1.getText().equals(txt_pass2.getText()))) {
					JOptionPane.showMessageDialog(null, "Your password does not match the password you entered again.", "Mesaj",
							JOptionPane.ERROR_MESSAGE);
					txt_pass2.setText("");
				} else if (txt_pass1.getText().length() < 6 || txt_pass2.getText().length() < 6) {
					JOptionPane.showMessageDialog(null, "Your password must be at least 6 digits.", "Mesaj",
							JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Your Password Can Be Accepted.", "Mesaj",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btn_Control.setBounds(156, 118, 89, 32);
		contentPane.add(btn_Control);
		txt_pass2.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (!(txt_pass1.getText().equals(txt_pass2.getText()))) {
					txt_pass1.setBackground(Color.red);
					txt_pass2.setBackground(Color.red);
				}

				if (txt_pass1.getText().equals(txt_pass2.getText())) {
					txt_pass1.setBackground(Color.green);
					txt_pass2.setBackground(Color.green);
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txt_pass1.getText().length() == 0 || txt_pass2.getText().length() == 0) {
					txt_pass1.setBackground(Color.white);
					txt_pass2.setBackground(Color.white);
				}

				else if (!(txt_pass1.getText().equals(txt_pass2.getText()))) {
					txt_pass1.setBackground(Color.red);
					txt_pass2.setBackground(Color.red);
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});
		txt_pass1.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {

				if (txt_pass2.getText().length() > 0
						&& !(txt_pass1.getText().equals(txt_pass2.getText()))) {
					txt_pass1.setBackground(Color.red);
					txt_pass2.setBackground(Color.red);
				}

				if (txt_pass1.getText().equals(txt_pass2.getText())) {
					txt_pass1.setBackground(Color.green);
					txt_pass2.setBackground(Color.green);
				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txt_pass1.getText().length() == 0 || txt_pass2.getText().length() == 0) {
					txt_pass1.setBackground(Color.white);
					txt_pass2.setBackground(Color.white);
				} else if (!(txt_pass1.getText().equals(txt_pass2.getText()))) {
					txt_pass1.setBackground(Color.red);
					txt_pass2.setBackground(Color.red);
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}

		});

	}

}
