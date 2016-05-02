package packageServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataBase.GroupDB;
import dataBase.UserDB;
import dataBase.UserGroupDB;
import vInterface._ObjectBuilder;
import vInterfaceDB.*;

public class Server {	
	
	public static void main(String[] args) {
		String IPSERVER = "localhost";
		int PORT = 54321;
		
		String urlObjectBuilder = "rmi://"+IPSERVER+":"+PORT+"/ObjectBuilder";
		String urlUserDB = "rmi://"+IPSERVER+":"+PORT+"/UserDB";
		String urlUserGroupDB = "rmi://"+IPSERVER+":"+PORT+"/UserGroupDB";
		String urlGroupDB = "rmi://"+IPSERVER+":"+PORT+"/GroupDB";

		try {
			_ObjectBuilder ob = new ObjectBuilder();
			_UserDB userDB = new UserDB();
			_UserGroupDB userGroupDB = new UserGroupDB();
			_GroupDB GroupDB = new GroupDB();

			LocateRegistry.createRegistry(PORT);
			Naming.rebind(urlObjectBuilder, ob);
			Naming.rebind(urlUserDB, userDB);
			Naming.rebind(urlUserGroupDB, userGroupDB);
			Naming.rebind(urlGroupDB, GroupDB);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Server launched");
	}
	
	
}
