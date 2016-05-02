package packageServer;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import vInterface._Chat;
import vInterface._User;

public class Chat extends UnicastRemoteObject implements _Chat {

	private static final long serialVersionUID = 1L;
	private int idC;
	private String name;
	private ArrayList<_User> participants;
	private JTextArea areaMessage;
	private JTextArea areaOldMess;

	/**
	 * create chat without any parameters
	 */
	public Chat() throws RemoteException {
		super();
		setParticipants(new ArrayList<_User>());
	}

	/**
	 * create chat with a nameM
	 */
	protected Chat(String n) throws RemoteException {
		super();
		setName(n);
		setParticipants(new ArrayList<_User>());
	}

	/**
	 * create chat with a name and a list of participants
	 */
	protected Chat(String n, ArrayList<_User> p) throws RemoteException {
		
		setName(n);
		setParticipants(p);

	}

	/**
	 * create chat between 2 users with a name by default
	 */
	protected Chat(User u1, User u2) throws RemoteException {
		super();
		this.setName("Chat between " + u1.getUserName() + " and " + u2.getUserName());
		this.setParticipants(new ArrayList<_User>());
		this.addParticipants(u1);
		this.addParticipants(u2);
	}

	/**
	 * create chat between 2 users with a name given
	 */
	protected Chat(String n, User u1, User u2) throws RemoteException {
		this.setName(n);
		this.setParticipants(new ArrayList<_User>());
		this.addParticipants(u1);
		this.addParticipants(u2);
	}

	/**
	 * Add a participant to the chat
	 * 
	 * @param u
	 *            is a user need to be add to the chat
	 * @throws RemoteException
	 */
	public void addParticipants(_User u) throws RemoteException {
		this.participants.add(u);
	}

	/**
	 * Add a message to the chat
	 * 
	 * @param msg·Ò
	 *            to add to the chat
	 * @throws RemoteException
	 */
	public synchronized void addMessage(String msg) throws RemoteException {
		setNewMessage(msg);
	}

	public String getMessage() throws RemoteException {
		return areaMessage.getText();
	}

	public void setNewMessage(String mess) throws RemoteException {
		areaOldMess.setText(areaOldMess.getText() + "/n" + mess);
	}

	public void displayChat(JFrame contentPane) throws RemoteException {
		
		System.out.println("On est dans chat ");
		JTextArea txtChat = new JTextArea();
		txtChat.setText("  <ProOF> : test mic 1 2 1 2, allo la terre ici grenoble\r\n  <Vivian> : okok\r\n  <Dakaya> : omg");
		txtChat.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtChat.setBounds(242, 68, 671, 407);
		contentPane.add(txtChat);

		this.areaOldMess = txtChat;

		JTextArea txtSend = new JTextArea();
		txtSend.setText(" <User> : \u00E9crire ici...");
		txtSend.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtSend.setBounds(427, 491, 487, 114);
		contentPane.add(txtSend);

		this.areaMessage = txtSend;

		JButton btSend = new JButton("Envoyer");
		btSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtChat.setText(txtChat.getText() + "\r\n" + txtSend.getText());
			}
		});
		btSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btSend.setIcon( new ImageIcon(Chat.class.getResource("/appTemoin1/images/mail-veuillez-envoyer-icone-6810-48.png")));
		btSend.setBackground(Color.BLACK);
		btSend.setForeground(Color.WHITE);
		btSend.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		btSend.setBounds(242, 491, 170, 49);
		contentPane.add(btSend);

		btSend.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					String message = getMessage();
					addMessage(name + ": " + message);
				} catch (RemoteException er) {
					er.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		/*
		 * JButton btnAjouterUnFichier = new JButton("Ajouter un fichier");
		 * btnAjouterUnFichier.setHorizontalAlignment(SwingConstants.LEFT);
		 * btnAjouterUnFichier.setIcon(new ImageIcon(Chat.class.getResource(
		 * "/appTemoin1/images/oYPS__email_mail_attachement_paperclip_trombone-48.png"
		 * ))); btnAjouterUnFichier.setBackground(Color.BLACK);
		 * btnAjouterUnFichier.setForeground(Color.WHITE);
		 * btnAjouterUnFichier.setFont(new Font("Comic Sans MS", Font.PLAIN,
		 * 16)); btnAjouterUnFichier.setBounds(242, 556, 170, 49);
		 * contentPane.add(btnAjouterUnFichier);
		 */

		/*
		 * JButton btnRetour = new JButton("Retour");
		 * btnRetour.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { dispose(); } });
		 * btnRetour.setBackground(Color.BLACK);
		 * btnRetour.setForeground(Color.WHITE); btnRetour.setFont(new Font(
		 * "Comic Sans MS", Font.PLAIN, 16)); btnRetour.setBounds(799, 621, 115,
		 * 29); contentPane.add(btnRetour);
		 */
		JLabel lblNewLabel = new JLabel("Membres");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNewLabel.setIcon(new ImageIcon(Chat.class.getResource("/appTemoin1/images/OMGFDP.png")));
		lblNewLabel.setBounds(27, 79, 126, 49);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Chat.class.getResource("/appTemoin1/images/barre.jpg")));
		lblNewLabel_1.setBounds(-14, 110, 983, 8);
		contentPane.add(lblNewLabel_1);

		JTextArea txtrMembers= new JTextArea();
		String members = "";
		for (int i=0; i<getParticipants().size(); i++){
			members += getParticipants().get(i).getFirstName() + " " + getParticipants().get(i).getLastName() + "\n";
		}
		txtrMembers.setText(members);
		txtrMembers.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtrMembers.setBackground(SystemColor.inactiveCaption);
		txtrMembers.setBounds(15, 144, 187, 254);
		contentPane.add(txtrMembers);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Chat.class.getResource("/appTemoin1/images/4cbMMa6Xi.png")));
		lblNewLabel_2.setBounds(10, 503, 192, 147);
		contentPane.add(lblNewLabel_2);

		JLabel lblTchatDeGroupe = new JLabel("Tchat de groupe");
		lblTchatDeGroupe.setFont(new Font("Snap ITC", Font.BOLD, 24));
		lblTchatDeGroupe.setForeground(Color.WHITE);
		lblTchatDeGroupe.setBounds(68, 16, 271, 29);
		contentPane.add(lblTchatDeGroupe);
	
	}

	/**
	 * Get the String for a chat Help to validate the code
	
	public String toString() {
		String participants = "";
		String s = "";
		try {
			for (int i = 0; i < getParticipants().size(); i++) {
				participants += getParticipants().get(i).toString() + "\n";
			}
			s = "Name: " + getName() + "\nParticipants: " + participants;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return s;
	} */

	// GETTERS AND SETTERS

	public String getName() throws RemoteException {
		return name;
	}

	public void setName(String name) throws RemoteException {
		this.name = name;
	}

	public ArrayList<_User> getParticipants() throws RemoteException {
		return participants;
	}

	public void setParticipants(ArrayList<_User> participants) throws RemoteException {
		this.participants = participants;
	}

	public int getIdC() throws RemoteException {
		return idC;
	}

	public void setIdC(int idC) throws RemoteException {
		this.idC = idC;
	}

}
