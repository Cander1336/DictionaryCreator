package creator.update;

public class PartOfSpeechWord {
	private String word;
	private String wordType;
	
	public PartOfSpeechWord(String word, String wordType){
		this.word = word;
		this.wordType = wordType;
	}
	
	public String getWord(){
		return word;
	}
	
	public String getWordType(){
		return wordType;
	}
	
	public String toString(){
		return word + "=" + wordType;
	}
}
