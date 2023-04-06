package ordina.library.assessment.Implementations;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


import ordina.library.assessment.Interfaces.WordFrequency;
import ordina.library.assessment.Interfaces.WordFrequencyAnalyzer;

public class LibraryCalculations implements WordFrequencyAnalyzer{

    // CalculateHighestFrequency should return the highest frequency in the text (several words might actually have this frequency)
    public int calculateHighestFrequency(String text) {
        int highestValue = 0;

        //Split the text so you can get every word and create hashmap to store the frequencies of words
        String[] splStrings = text.split(" ");
        Map<String, Integer> wordsWithFrequency = new HashMap<>();
        
        //Goes through the text words, then checks if word exists in dict: if not -> create | if so -> increase increment
        for (String i : splStrings) {

            if (wordsWithFrequency.get(i) == null) {
                wordsWithFrequency.put(i, 1);
            }

            else{
                wordsWithFrequency.put(i, wordsWithFrequency.get(i) + 1);
                if(wordsWithFrequency.get(i) > highestValue){
                    highestValue = wordsWithFrequency.get(i);
                }
            }
        }
        return highestValue;
    }

    //CalculateFrequencyForWord should return the frequency of the specified word
    public int calculateFrequencyForWord(String text, String word) {
        int frequency = 0;

        //Split the text so you can get every word
        String[] splStrings = text.split(" ");

        //For every word, if it's the same as the given word, increase frequency increment by 1
        for(String i : splStrings){
            if(i.equals(word)){
                frequency += 1;
            }
        }
        return frequency;
    }

    //CalculateMostFrequentNWords should return a list of the most frequent „n" words in the input text, all the words returned in lower case.  If several words have the same frequency, this method should return them in ascendant alphabetical order (for input text "The sun shines over the lake" and n = 3, it should return the list {("the", 2), ("lake", 1), ("over", 1) }
    public WordFrequency[] calculateMostFrequentNWords(String text, int n) {
        //Split the text so you can get every word and create a hashmap to store the frequencies of words
        String[] splStrings = text.split(" ");
        Map<String, Integer> wordsWithFrequency = new HashMap<>();
        
        //Goes through the text words, then checks if word exists in dict: if not -> create | if so -> increase increment 
        for (String i : splStrings) {
            if (wordsWithFrequency.get(i) == null) {
                wordsWithFrequency.put(i, 1);
            }
            else{
                wordsWithFrequency.put(i, wordsWithFrequency.get(i) + 1);
            }
        }

        WordFrequency[] wordFrequencies = fillAndSortList(wordsWithFrequency, n);
        return wordFrequencies;
    }

    //called by calculateMostFrequentNWords() to make use of the WordFrequency object
    private WordFrequency[] fillAndSortList(Map<String, Integer> dict, int n){
        int length = dict.size();
        int count = 0;
        WordFrequency[] wordFrequencies = new WordFrequency[length];

        //goes through the established dictionary and writes everything to the wordFrequency list
        for(Map.Entry<String, Integer> set : dict.entrySet()){
            WordFrequencyImplement wordFrequencyImplement = new WordFrequencyImplement(set.getKey(), set.getValue());
            wordFrequencies[count] = wordFrequencyImplement;
            count++;
        }

        //sorts the wordFrequency list by the frequency of every word
        Arrays.sort(wordFrequencies, new Comparator<WordFrequency>() {
            public int compare(WordFrequency wf1, WordFrequency wf2){
                return wf2.getFrequency() - wf1.getFrequency();
            }
        });

        //uses int n to only display a select amount of words from the original text
        wordFrequencies = Arrays.copyOfRange(wordFrequencies, 0, n);
        return wordFrequencies;
    }
}
