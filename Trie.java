class Trie {
    private int length = 0;
    private int totalLength = 0;
    private ElementTrie first = new ElementTrie();

    public String insertWord(String word){
        ElementTrie child = first;
        for (int i=0; i < word.length(); i ++){
            if (child.getAlphabet()[ElementTrie.letterToIndex(word.charAt(i))] == null){
                child.getAlphabet()[ElementTrie.letterToIndex(word.charAt(i))] = new ElementTrie(word.charAt(i));
            }
            child = child.getAlphabet()[ElementTrie.letterToIndex(word.charAt(i))];
        }

        if (! child.isWord){
            this.length += 1;
            child.isWord = true;
        }

        this.totalLength += 1;
        return word;
    }

    public boolean has(String word){
        ElementTrie child = first;

        for (int i=0; i < word.length(); i ++){
            ElementTrie node = child.getAlphabet()[ElementTrie.letterToIndex(word.charAt(i))];

            if (node == null) {
                return false;
            }

            child = node;

        }

        if (child.isWord) {
            return true;
        }

        return false;

    }

    public int getLength(){
        return this.length;
    }

    public int getTotalLength(){
        return this.totalLength;
    }
}