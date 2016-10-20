public class ElementTrie {
    private ElementTrie[] alphabet;
    private char letter;
    public boolean isWord = false;

    public ElementTrie(){
        this.alphabet = new ElementTrie[26];
    }

    public ElementTrie(char letter){
        // Pointer should be stored into the array
        this.alphabet = new ElementTrie[26];
        this.alphabet[letterToIndex(letter)] = null;
        this.letter = letter;
    }

    public ElementTrie(char letter, ElementTrie next){
        this(letter);
        this.alphabet[letterToIndex(letter)] = next;
    }

    public ElementTrie[] getAlphabet(){
        return this.alphabet;
    }

    static int letterToIndex(char letter){
        return ((int) letter - 97);
    }
}
