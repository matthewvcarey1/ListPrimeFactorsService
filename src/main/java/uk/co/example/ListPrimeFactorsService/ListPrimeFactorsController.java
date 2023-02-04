package uk.co.example.ListPrimeFactorsService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListPrimeFactorsController {

    private static final String PARSE_ERROR_MESSAGE = "The input value could not be parsed as a Long Integer";

    @GetMapping("/primefactors/{valueString}")
    public ListFactorsResult primePath(@PathVariable String valueString) {
        try {
            long value=Long.parseLong(valueString);
            ListPrimeFactors lpf = new ListPrimeFactors();
            if (value > ListPrimeFactors.limit){
                return new ListFactorsResult("Value too large, larger than "+Long.toString(ListPrimeFactors.limit),"",Long.toString(value));
            }
            return new ListFactorsResult("", lpf.ListFactorsString(value), Long.toString(value));
        } catch (NumberFormatException e){
            return new ListFactorsResult(PARSE_ERROR_MESSAGE , "", "");
        } catch (Exception e){
            return new ListFactorsResult(e.toString(),"", "");
        }
    }



    @GetMapping("/primeLimits/")
    public PrimeLimits primeLimits(){
        try{
            new ListPrimeFactors();
            final long upperLimit =  ListPrimeFactors.limit;
            final long lowerLimit = 2L;
            return new PrimeLimits(lowerLimit,upperLimit,"");
        }catch (Exception e){
            return new PrimeLimits(1,1, e.getMessage());
        }
    }

    @RequestMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
