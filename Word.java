public class Word {

    /**
     * Take a string as a word
     */
    private String word;

    /**
     * How many times the word appears
     */
    private int frequency;

    /**
     * Create a new word
     * @param s string to be a word
     */
    public Word(String s) {

        word = s;

        frequency = 1;
    }

    /**
     * Compares two words
     * @param f word to be compared
     * @return 0 if equal, 1 if greater, -1 if less
     */
    public int compareTo(Word f){

        String w1 = this.word;
        String w2 = f.word;

        return w1.compareTo(w2);
    }

    /**
     * Converts the object to a printable string
     * @return  a printable string with the word and frequency
     */
    @Override
    public String toString(){

        return word + " => " + frequency;
    }

    /**
     * Increments the frequency
     */
    public void incFrequency(){

        frequency++;
    }
}
