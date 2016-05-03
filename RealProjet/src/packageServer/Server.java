package packageServer;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import dataBase.ArticleDB;
import dataBase.DataArticleDB;
import dataBase.DataDB;
import dataBase.GroupDB;
import dataBase.TaskDB;
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
		String urlTaskDB = "rmi://"+IPSERVER+":"+PORT+"/TaskDB";
		String urlDataDB = "rmi://"+IPSERVER+":"+PORT+"/DataDB";
		String urlArticleDB = "rmi://"+IPSERVER+":"+PORT+"/ArticleDB";
		String urlDataArticleDB = "rmi://"+IPSERVER+":"+PORT+"/DataArticleDB";

		try {
			_ObjectBuilder ob = new ObjectBuilder();
			_UserDB userDB = new UserDB();
			_UserGroupDB userGroupDB = new UserGroupDB();
			_GroupDB GroupDB = new GroupDB();
			_TaskDB TaskDB = new TaskDB();
			_DataDB DataDB = new DataDB();
			_ArticleDB ArticleDB = new ArticleDB();
			_DataArticleDB DataArticleDB = new DataArticleDB();

			LocateRegistry.createRegistry(PORT);
			Naming.rebind(urlObjectBuilder, ob);
			Naming.rebind(urlUserDB, userDB);
			Naming.rebind(urlUserGroupDB, userGroupDB);
			Naming.rebind(urlGroupDB, GroupDB);
			Naming.rebind(urlTaskDB, TaskDB);
			Naming.rebind(urlDataDB, DataDB);
			Naming.rebind(urlArticleDB, ArticleDB);
			Naming.rebind(urlDataArticleDB, DataArticleDB);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Server launched");
	}
	
	
}
