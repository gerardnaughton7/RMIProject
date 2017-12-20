package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CreateDictionary {
	private String csvFile = "Resources/dictionary.csv";
	private StringBuilder definition = new StringBuilder();
	private HashMap<String, List<String>> dictionary = new HashMap<String, List<String>>();
	private String word = null;
	private String line = null;
	
	public void inputCSV() throws IOException{
		
		BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile)));
		
		while((line = bReader.readLine()) != null){
			//if line start with " take in the first word as key for hashmap
			if(line.startsWith("\"")){
				//if we're not on the first line, do this. calls the addDefinition function which adds the word and definition to the dictionary hashmap
				if(word != null){
					addDefinition(word.toLowerCase(), definition.toString());
					definition = new StringBuilder();	//reset string builder
				}
				//otherwise find the end of the word
				int endOfWord = line.indexOf('"', 1);
				
				//makes a word from one quote to the next double quote
				word = line.substring(1,  endOfWord);
				//add the rest of the line to wordDefiniton 2 chars after end of the word
				definition.append((line.substring(endOfWord + 2)));
				definition.append("\n");//add a new line

			}
			else{//other wise keep adding line/text to definition
				definition.append((line));
				definition.append("\n");
			}
		}//while
		bReader.close();

	}
	
	//add the word and the definition to the dictionary hash map
	public void addDefinition(String word, String def){
		//check if dictionary already has word and if so add definition to existing definition
		if(dictionary.containsKey(word)){
			List<String> definition = dictionary.get(word);
			definition.add(def);
			dictionary.put(word, definition);
		}
		//else add word and definition to dictionary
		else{
			List<String> definition = new ArrayList<String>();
			definition.add(def);
			dictionary.put(word, definition);
		}
	}
	
	//get definition for specific word
	public List<String> get(String definition) {
		return dictionary.get(definition);
	}
	
	//Insert new word and definition to dictionary
	public String insertWord(String word, String def)
	{
		List<String> definition = new ArrayList<String>();
		definition.add(def);
		dictionary.put(word, definition);
		return "Word and Definition have been Added to Dictionary";
	}
	
	// get whole dictionary
	public HashMap<String,List<String>> getDict()
	{	
		return this.dictionary;	
	}
}
