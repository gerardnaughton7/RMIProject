package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DictionaryService extends Remote {
	
	public String getDefinition(String filename) throws RemoteException;
	//created a add method in rmi but was unable to implement in time for client
	public void insertWord(String word, String def) throws RemoteException;

}
