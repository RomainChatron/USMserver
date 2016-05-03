package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import vInterface._ChatC;
import vInterface._ChatS;
import vInterface._ChatServer;

@SuppressWarnings("serial")
public class ChatServer extends UnicastRemoteObject implements _ChatServer {
	HashMap<String, _ChatS> lesChat ;

	protected ChatServer() throws RemoteException {
		super();
		lesChat = new HashMap<>();
	}

	@Override
	public void register(String nomChat, _ChatC client) throws RemoteException {
		System.out.println("on rentre dans le register");
		if(lesChat.containsKey(nomChat)) {
			System.out.println("on est dans le contains");
			lesChat.get(nomChat).register(client);
			System.out.println("on a register");
		} else {
			System.out.println("il contient pas, on crée");
			lesChat.put(nomChat, new ChatS(this, nomChat));
			System.out.println("on a créé");
			lesChat.get(nomChat).register(client);
			System.out.println("on a register");
		}
	}

	@Override
	public void unregister(String nomChat, _ChatC client) throws RemoteException {
		if(lesChat.containsKey(nomChat)) {
			lesChat.get(nomChat).unregister(client);
		} else {
			// TODO : créer Exception à throw ici
		}
	}

	@Override
	public void postMessage(String nomChat, String message) throws RemoteException {
		if(lesChat.containsKey(nomChat)) {
			System.out.println("On a reçu sur ChatServer : " + message);
			lesChat.get(nomChat).postMessage(message);
		} else {
			// TODO : créer Exception à throw ici
		}
	}

	@Override
	public void deleteChat(String nomChat) throws RemoteException {
		lesChat.remove(nomChat);
	}
	
}
