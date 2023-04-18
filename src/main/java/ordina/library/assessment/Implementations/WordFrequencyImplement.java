package ordina.library.assessment.Implementations;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof WordFrequencyImplement)) return false;
    WordFrequencyImplement that = (WordFrequencyImplement) o;
    return getFrequency() == that.getFrequency() &&
            Objects.equals(getWord(), that.getWord());
}


    
}
