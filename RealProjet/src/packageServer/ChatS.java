package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import vInterface._ChatC;
import vInterface._ChatS;

@SuppressWarnings("serial")
public class ChatS extends UnicastRemoteObject implements _ChatS{
	
	ArrayList<_ChatC> listeAbo ;
	ChatServer papa ;
	String nomChat ;

	protected ChatS() throws RemoteException {
		super();
	}
	
	public ChatS(ChatServer mama, String nomChat) throws RemoteException {
		super();
		papa = mama ;
		this.nomChat = nomChat ;
		listeAbo = new ArrayList<>();
		System.out.println("bien créé");
	}

	@Override
	public void register(_ChatC client) throws RemoteException {
		listeAbo.add(client);
	}

	@Override
	public void unregister(_ChatC client) throws RemoteException {
		listeAbo.remove(client);
		if(listeAbo.size() == 0) {
			papa.deleteChat(nomChat);
		}
	}

	@Override
	public void postMessage(String message) throws RemoteException {
		for(int i = 0 ; i < listeAbo.size() ; i++ ) {
			listeAbo.get(i).postMessage(message);
		}
	}

}
