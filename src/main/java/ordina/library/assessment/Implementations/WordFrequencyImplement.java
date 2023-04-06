package ordina.library.assessment.Implementations;

import ordina.library.assessment.Interfaces.WordFrequency;

public class WordFrequencyImplement implements WordFrequency{
    String word;
    int frequency;

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public WordFrequencyImplement(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
    
    public WordFrequencyImplement(){}

    @Override
    public String toString() {
        return "word=" + word + ", frequency=" + frequency;
    }

    
}
