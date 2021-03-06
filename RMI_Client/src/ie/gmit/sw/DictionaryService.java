package ie.gmit.sw;
//import remote and remoteException
import java.rmi.Remote;
import java.rmi.RemoteException;

//interface extends remote
public interface DictionaryService extends Remote {
	//all methods must throw remote exceptions
	public String getDefinition(String word) throws RemoteException;
	//created a add method in rmi but was unable to implement in time for client
	public void insertWord(String word, String def) throws RemoteException;

}
