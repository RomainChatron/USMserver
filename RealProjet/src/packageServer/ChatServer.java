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
		if(lesChat.containsKey(nomChat)) {
			lesChat.get(nomChat).register(client);
		} else {
			lesChat.put(nomChat, new ChatS(this, nomChat));
			lesChat.get(nomChat).register(client);
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
