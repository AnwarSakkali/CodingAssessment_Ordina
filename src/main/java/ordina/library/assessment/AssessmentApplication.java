package ordina.library.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//import ordina.library.assessment.Implementations.LibraryCalculations;
//import ordina.library.assessment.Interfaces.WordFrequency;

@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})
public class AssessmentApplication {
	//static LibraryCalculations libcalcs = new LibraryCalculations();

	public static void main(String[] args) {
		// String text = "ertv byta obtydsi iayra i dsjyf akkt hgk byta df fg df df df akhgd ogf ygl byta";
		// System.out.println(libcalcs.calculateHighestFrequency(text));
		// System.out.println(libcalcs.calculateFrequencyForWord(text, "fg"));
		// System.out.println(libcalcs.calculateFrequencyForWord(text, "byta"));
		// WordFrequency[] wordFrequencies = libcalcs.calculateMostFrequentNWords(text, 5);
		// for(WordFrequency wordFrequency : wordFrequencies){
		// 	System.out.println(wordFrequency);
		// }
		
		SpringApplication.run(AssessmentApplication.class, args);
	}

}
