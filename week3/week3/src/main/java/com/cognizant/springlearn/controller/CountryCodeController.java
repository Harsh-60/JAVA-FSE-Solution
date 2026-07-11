// Week 3 / 2. spring-rest-handson / "REST - Get country based on country code"
package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

// URL: /countries/{code}
// Sample Request: http://localhost:8090/countries/in
// Sample Response: {"code": "IN", "name": "India"}
// Country code matching is case insensitive.
@RestController
public class CountryCodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryCodeController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("Start");
        LOGGER.debug("code={}", code);

        Country country = countryService.getCountry(code);

        LOGGER.info("End");
        return country;
    }

}
