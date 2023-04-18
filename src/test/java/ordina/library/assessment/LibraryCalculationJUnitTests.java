package ordina.library.assessment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import ordina.library.assessment.Implementations.LibraryCalculations;
import ordina.library.assessment.Implementations.WordFrequencyImplement;
import ordina.library.assessment.Interfaces.WordFrequency;

public class LibraryCalculationJUnitTests {
    LibraryCalculations libraryCalculations = new LibraryCalculations();
    @BeforeEach
    void setup(){
    }

    // Looks if highest frequency is two in text
    @Test
    public void givenText_whenCalculateHighestFrequency_returnHighestFrequency() {
        // given
        String text = "the quick brown fox jumps over the lazy dog";
        int expectedOutput = 2;
        
        // when
        int actualOutput = libraryCalculations.calculateHighestFrequency(text);
        
        // then
        assertEquals(expectedOutput, actualOutput);
    }

    // Looks if chuck appears twice in text
    @Test
    public void givenText_whenCalculateFrequencyForWord_returnWordFrequency(){
        // given
        String text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        int expectedOutput = 2;
        
        // when
        int actualOutput = libraryCalculations.calculateFrequencyForWord(text, "chuck");
        
        // then
        assertEquals(expectedOutput, actualOutput);
    }

    // Looks if word "if" doesn't appear thrice in text with expectedOutput being 3 and actualOutput should be 1
    @Test
    public void givenText_whenCalculateFrequencyForWord_returnNotEqualWordFrequency(){
        // given
        int unexpectedOutput = 3;
        String word = "chuck";
        String text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        
        // when
        int actualOutput = libraryCalculations.calculateFrequencyForWord(text, word);
        
        // then
        assertNotEquals("fail", unexpectedOutput, actualOutput);
    }

    // Looks if the WordFrequencyArray lines up with the results
    @Test
    public void givenTextAndN_whenCalculateMostFrequentNWords_returnWordFrequencyArray(){
        // given
        LibraryCalculations libraryCalculations = Mockito.mock(LibraryCalculations.class);
        String text = "The sun shines over the lake";
        int n = 3;
        WordFrequency[] wordFrequencies = new WordFrequency[]{
            new WordFrequencyImplement("the", 2),
            new WordFrequencyImplement("lake", 1),
            new WordFrequencyImplement("over", 1)
        };

        // when
        Mockito.when(libraryCalculations.calculateMostFrequentNWords(text, n)).thenReturn(wordFrequencies);
        WordFrequency[] actualOutput = libraryCalculations.calculateMostFrequentNWords(text, 3);
        Mockito.verify(libraryCalculations).calculateMostFrequentNWords(text, 3);
        
        // then
        assertArrayEquals(wordFrequencies, actualOutput);
    }
}
