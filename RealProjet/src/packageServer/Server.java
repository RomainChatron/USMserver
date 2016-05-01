package packageServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataBase.UserDB;
import vInterface._ObjectBuilder;
import vInterface._UserDB;

public class Server {	
	
	public static void main(String[] args) {
		String IPSERVER = "localhost";
		int PORT = 54321;
		
		String urlObjectBuilder = "rmi://"+IPSERVER+":"+PORT+"/ObjectBuilder";
		String urlUserDB = "rmi://"+IPSERVER+":"+PORT+"/UserDB";

		try {
			_ObjectBuilder ob = new ObjectBuilder();
			_UserDB userDB = new UserDB();

			LocateRegistry.createRegistry(PORT);
			Naming.rebind(urlObjectBuilder, ob);
			Naming.rebind(urlUserDB, userDB);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Server launched");
	}
	
	
}
