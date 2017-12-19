package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DictionaryService extends Remote {
	
	public String getDefinition(String filename) throws RemoteException;

}
