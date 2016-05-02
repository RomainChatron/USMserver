package vInterface;

import java.awt.Container;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import packageServer.User;

public interface _Chat extends Remote {
	
	
		
		/**
		 * Add a participant to the chat
		 * @param u is a user need to be add to the chat
		 * @throws RemoteException
		 */
		public void addParticipants(_User u) throws RemoteException ;
		
		/**
		 * Add a message to the chat
		 * @param msg to add to the chat
		 * @throws RemoteException
		 */
		public void addMessage(String msg) throws RemoteException ;

		public void displayChat(JFrame contentPane) throws RemoteException;
		/**
		 * Get the String for a chat 
		 * Help to validate the code
		 
		public String toString() ;*/
		
		// GETTERS AND SETTERS

			public String getName() throws RemoteException ;
			public void setName(String name) throws RemoteException ;
			public ArrayList<_User> getParticipants() throws RemoteException ;
			public void setParticipants(ArrayList<_User> participants) throws RemoteException ;
			public int getIdC() throws RemoteException ;
			public void setIdC(int idC) throws RemoteException;

	
}
