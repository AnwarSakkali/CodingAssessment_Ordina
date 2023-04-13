package ordina.library.assessment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import ordina.library.assessment.Implementations.LibraryCalculations;
import ordina.library.assessment.Implementations.WordFrequencyImplement;
import ordina.library.assessment.Interfaces.WordFrequency;

public class LibraryCalculationJUnitTests {
    LibraryCalculations libraryCalculations;

    @BeforeEach
    void setup(){
        this.libraryCalculations = mock(LibraryCalculations.class);
    }

    // Looks if highest frequency is two in text
    @Test
    public void givenText_whenCalculateHighestFrequency_returnHighestFrequency() {
        LibraryCalculations libraryCalculations = mock(LibraryCalculations.class);

        String text = "the quick brown fox jumps over the lazy dog";
        int expectedOutput = 2;
        Mockito.when(libraryCalculations.calculateHighestFrequency(text)).thenReturn(expectedOutput);
        int actualOutput = libraryCalculations.calculateHighestFrequency(text);
        Mockito.verify(libraryCalculations).calculateHighestFrequency(text);
        assertEquals(expectedOutput, actualOutput);
    }

    // Looks if chuck appears twice in text
    @Test
    public void givenText_whenCalculateFrequencyForWord_returnWordFrequency(){
        LibraryCalculations libraryCalculations = Mockito.mock(LibraryCalculations.class);
        String text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        int expectedOutput = 2;
        Mockito.when(libraryCalculations.calculateFrequencyForWord(text, "chuck")).thenCallRealMethod();
        int actualOutput = libraryCalculations.calculateFrequencyForWord(text, "chuck");
        Mockito.verify(libraryCalculations).calculateFrequencyForWord(text, "chuck");
        System.out.println(actualOutput);

        assertEquals(expectedOutput, actualOutput);
    }

    // Looks if word "if" doesn't appear thrice in text with expectedOutput being 3 and actualOutput should be 1
    @Test
    public void givenText_whenCalculateFrequencyForWord_returnNotEqualWordFrequency(){
        LibraryCalculations libraryCalculations = Mockito.spy(LibraryCalculations.class);
        //LibraryCalculations libraryCalculations = new LibraryCalculations();
        int unexpectedOutput = 3;
        String word = "chuck";
        String text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        
        Mockito.when(libraryCalculations.calculateFrequencyForWord(text, word)).thenCallRealMethod();
        int actualOutput = libraryCalculations.calculateFrequencyForWord(text, word);
        
        Mockito.verify(libraryCalculations).calculateFrequencyForWord(text, word);

        assertNotEquals("fail", unexpectedOutput, actualOutput);
    }

    // Looks if the WordFrequencyArray lines up with the results
    @Test
    public void givenTextAndN_whenCalculateMostFrequentNWords_returnWordFrequencyArray(){
        LibraryCalculations libraryCalculations = Mockito.mock(LibraryCalculations.class);
        String text = "The sun shines over the lake";
        int n = 3;
        WordFrequency[] wordFrequencies = new WordFrequency[]{
            new WordFrequencyImplement("the", 2),
            new WordFrequencyImplement("lake", 1),
            new WordFrequencyImplement("over", 1)
        };
        Mockito.when(libraryCalculations.calculateMostFrequentNWords(text, n)).thenReturn(wordFrequencies);
        WordFrequency[] actualOutput = libraryCalculations.calculateMostFrequentNWords(text, 3);
        Mockito.verify(libraryCalculations).calculateMostFrequentNWords(text, 3);
        assertArrayEquals(wordFrequencies, actualOutput);
    }
}
