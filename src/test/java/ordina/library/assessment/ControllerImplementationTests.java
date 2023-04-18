package ordina.library.assessment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import ordina.library.assessment.Implementations.WordFrequencyImplement;
import ordina.library.assessment.Interfaces.WordFrequency;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerImplementationTests {

    @Autowired
	private MockMvc mockMvc;

    @Test
    public void givenText_whenCalculateHighestFrequencyController_returnHighestFrequency() throws Exception {
        // given
        int expectedValue = 2;
        String text = "the sun rises in the morning";

        // when 
        MvcResult result = mockMvc.perform(get("/highestFrequency/{text}", text))
                .andExpect(status().isOk())
                .andReturn();

        // then
        int actualValue = Integer.parseInt(result.getResponse().getContentAsString());
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void givenText_whenCalculateFrequencyForWordController_returnEqualWordFrequency() throws Exception {
        // given
        int expectedValue = 6;
        String text = "can you can a can as a canner can can a can";
        String word = "can";

        // when 
        MvcResult result = mockMvc.perform(get("/frequencyForWord/{text}/{word}", text, word))
                .andExpect(status().isOk())
                .andReturn();
                
        int actualValue = Integer.parseInt(result.getResponse().getContentAsString());

        //  then
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void givenTextAndN_whencalculateMostFrequentNWordsController_returnWordFrequencyArray() throws Exception{
        // given
        WordFrequency[] wordFrequencies = new WordFrequency[]{
            new WordFrequencyImplement("the", 2),
            new WordFrequencyImplement("shines", 1),
            new WordFrequencyImplement("over", 1)
        };
        String text = "the sun shines over the lake";
        int n = 3;

        // when
        MvcResult result = mockMvc.perform(get("/mostFrequentWords/{text}/{n}", text, n))
                .andExpect(status().isOk())
                .andReturn();
               
        // then
        MockHttpServletResponse response = result.getResponse();
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addAbstractTypeMapping(WordFrequency.class, WordFrequencyImplement.class);
        objectMapper.registerModule(module);
        WordFrequency[] actualValue = objectMapper.readValue(response.getContentAsString(), WordFrequency[].class);
        assertArrayEquals(wordFrequencies, actualValue);
    }


}
