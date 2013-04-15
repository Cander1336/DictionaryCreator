package creator;

public class Word {
	private String word;
	private String syllables;
	private int numberOfSyllables;
	private String wordType;
	private String fullWordType = "";
	
	public Word(String word, String syllables, String wordType){
		this.word = word;
		this.syllables = syllables;
		this.wordType = wordType;
		countSyllables();
		setFullWordType();
	}
	
	/**
	 * The String must be: word|syllables|wordtype(s)
	 * @param text - String|String|String
	 */
	public Word(String text){
		word = text.substring(0, text.indexOf('|'));
		text = text.substring(text.indexOf('|')+1);
		syllables = text.substring(0, text.indexOf('|'));
		wordType = text.substring(text.lastIndexOf('|')+1);
		countSyllables();
		setFullWordType();
	}
	
	private void countSyllables(){
		int pos;
		String temp = syllables;
		int counter = 0;
		while((pos = temp.indexOf('·')) != -1){
			counter++;
			temp = temp.substring(pos+1);
		}
		this.numberOfSyllables = counter;
	}
	
	private void setFullWordType(){
		for(int i = 0; i < wordType.length(); i++){
			fullWordType = fullWordType + translate(wordType.charAt(i));
			if(i < wordType.length()-1){
				// more words will be added -> add a dot
				fullWordType = fullWordType + ".";
			}
		}
	}
	
	private String translate(char letter){
		if(letter == 'N'){
			return "noun";
		}
		if(letter == 'p'){
			return "plural noun";
		}
		if(letter == 'h'){
			return "noun phrase";
		}
		if(letter == 'V'){
			return "verb (usu participle)";
		}
		if(letter == 'G'){
			return "gerund";
		}
		if(letter == 't'){
			return "transitive verb";
		}
		if(letter == 'i'){
			return "intransitive verb";
		}
		if(letter == 's'){
			return "singular verb";
		}
		if(letter == 'T'){
			return "past tense";
		}
		if(letter == 'A'){
			return "positive adjective";
		}
		if(letter == 'c'){
			return "comparative adjective";
		}
		if(letter == 'S'){
			return "superlative adjective";
		}
		if(letter == 'v'){
			return "adverb";
		}
		if(letter == 'C'){
			return "conjunction";
		}
		if(letter == 'P'){
			return "preposition";
		}
		if(letter == '!'){
			return "interjection";
		}
		if(letter == 'r'){
			return "pronoun";
		}
		if(letter == 'D'){
			return "definite article";
		}
		if(letter == 'I'){
			return "indefinite article";
		}
		if(letter == 'o'){
			return "nominative";
		}
		return null;
	}
	
	public String getWord(){
		return word;
	}
	
	public int getNumberOfSyllables(){
		return numberOfSyllables;
	}
	
	public String getWordType(){
		return wordType;
	}
	
	public String toString(){
		return word + "|" + syllables + "|" + fullWordType;
	}
	
	public boolean equals(Word word){
		if(this.word == word.getWord() && this.numberOfSyllables == word.getNumberOfSyllables() && this.wordType == word.getWordType()){
			return true;
		}
		return false;
	}
}

