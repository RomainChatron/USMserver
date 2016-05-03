package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JFrame;

import vInterface._ChatC;

@SuppressWarnings("serial")
public class ChatC extends UnicastRemoteObject implements _ChatC {
	
	JFrame fenetre ;
	String nomChat ;
	int idC ;

	protected ChatC() throws RemoteException {
		super();
	}

	@Override
	public void postMessage(String message) throws RemoteException {
		//fenetre.displayMessage(message);
	}

}
