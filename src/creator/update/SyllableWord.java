package creator.update;

public class SyllableWord {
	private String word;
	private String syllables;
	
	public SyllableWord(String word, String syllables){
		this.word = word;
		this.syllables = syllables;
	}
	
	public String getWord(){
		return word;
	}
	
	public String getSyllables(){
		return syllables;
	}
	
	public String toString(){
		return word + "=" + syllables;
	}
}
