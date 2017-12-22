package ie.gmit.sw;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
	//Create variables 
	private static final long serialVersionUID = 1L;
	private CreateDictionary cd;
	HashMap<String, List<String>> dictionaryMap;
	
	// When instance is created, create dictionary in constructor
	protected DictionaryServiceImpl() throws RemoteException, IOException {
		super();
		cd = new CreateDictionary();
		cd.inputCSV();
		dictionaryMap = cd.getDict();
	}
	
	//Public method used by client to search words in the dictionary. if word does exist return definition other wise return message 
	@Override
	public String getDefinition(String word) throws RemoteException {
		if(dictionaryMap.containsKey(word.toLowerCase()))
		{
			return dictionaryMap.get(word.toLowerCase()).toString();
		}
		return "Sorry that Word does not exist try again";
	}

	//created a add method in rmi but was unable to implement in time for client
	@Override
	public void insertWord(String word, String def) throws RemoteException {
		// TODO Auto-generated method stub
		insertWord(word,def);
		
	}
	
}
