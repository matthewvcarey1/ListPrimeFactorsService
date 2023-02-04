package uk.co.example.ListPrimeFactorsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ListPrimeFactorsServiceApplicationTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void contextLoads() {
    }
    @Test
    public void pathDecimalShouldReturnValue() throws Exception {
        this.mockMvc.perform(get("/primefactors/2402"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value("2 × 1201"))
                .andExpect(jsonPath("$.source").value("2402"));;
    }


}