package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        LOGGER.info("Inside main");

        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testFindCountriesByPartialName();
        testDeleteCountry();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found", e);
        }
        LOGGER.info("End");
    }

    private static void testAddCountry() {
        LOGGER.info("Start");
        Country newCountry = new Country("ZZ", "Testland");
        countryService.addCountry(newCountry);
        try {
            Country country = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Added country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found after add", e);
        }
        LOGGER.info("End");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start");
        try {
            countryService.updateCountry("ZZ", "Testland Updated");
            Country country = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found for update", e);
        }
        LOGGER.info("End");
    }

    private static void testFindCountriesByPartialName() {
        LOGGER.info("Start");
        List<Country> countries = countryService.findCountriesByPartialName("stan");
        LOGGER.debug("Matching countries={}", countries);
        LOGGER.info("End");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("ZZ");
        LOGGER.info("End");
    }

}
