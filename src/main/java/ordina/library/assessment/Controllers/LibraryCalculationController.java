package ordina.library.assessment.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ordina.library.assessment.Implementations.LibraryCalculations;
import ordina.library.assessment.Interfaces.WordFrequency;

@RestController
public class LibraryCalculationController {
    
    LibraryCalculations libraryCalculations = new LibraryCalculations();

    @RequestMapping("/highestFrequency/{text}")
    public int calculateHighestFrequency(@PathVariable String text){
        return libraryCalculations.calculateHighestFrequency(text);
    }

    @RequestMapping("/frequencyForWord/{text}/{word}")
    public int calculateFrequencyForWord(@PathVariable String text, @PathVariable String word){
        return libraryCalculations.calculateFrequencyForWord(text, word);
    }

    @RequestMapping("/mostFrequentWords/{text}/{n}")
    public WordFrequency[] calculateMostFrequentNWords(@PathVariable String text, @PathVariable int n){
        return libraryCalculations.calculateMostFrequentNWords(text, n);
    }
    
}
