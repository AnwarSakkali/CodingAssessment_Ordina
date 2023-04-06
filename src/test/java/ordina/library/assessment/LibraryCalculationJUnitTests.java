package ordina.library.assessment;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;
import org.mockito.Mockito;
import ordina.library.assessment.Implementations.LibraryCalculations;
import ordina.library.assessment.Implementations.WordFrequencyImplement;
import ordina.library.assessment.Interfaces.WordFrequency;

public class LibraryCalculationJUnitTests {

    @Test
    public void testCalculateHighestFrequency() {
    LibraryCalculations libraryCalculations = Mockito.mock(LibraryCalculations.class);

    String text = "the quick brown fox jumps over the lazy dog";
    int expectedOutput = 2;
    Mockito.when(libraryCalculations.calculateHighestFrequency(text)).thenReturn(expectedOutput);
    int actualOutput = libraryCalculations.calculateHighestFrequency(text);
    Mockito.verify(libraryCalculations).calculateHighestFrequency(text);
    assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testcalculateFrequencyForWord(){
        LibraryCalculations libraryCalculations = Mockito.mock(LibraryCalculations.class);
        String text = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        int expectedOutput = 2;
        Mockito.when(libraryCalculations.calculateFrequencyForWord(text, "chuck")).thenReturn(expectedOutput);
        int actualOutput = libraryCalculations.calculateFrequencyForWord(text, "chuck");
        Mockito.verify(libraryCalculations).calculateFrequencyForWord(text, "chuck");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testcalculateMostFrequentNWords(){
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
