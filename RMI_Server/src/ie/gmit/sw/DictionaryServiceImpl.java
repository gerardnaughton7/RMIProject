package ie.gmit.sw;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	private CreateDictionary cd;
	HashMap<String, List<String>> dictionaryMap;

	protected DictionaryServiceImpl() throws RemoteException, IOException {
		super();
		cd = new CreateDictionary();
		cd.inputCSV();
		dictionaryMap = cd.getDict();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDefinition(String word) throws RemoteException {
		// TODO Auto-generated method stub
		if(dictionaryMap.containsKey(word.toLowerCase()))
		{
			return dictionaryMap.get(word.toLowerCase()).toString();
		}else
		{
			return "Sorry that Word does not exist try again";
		}
	}
	
}
