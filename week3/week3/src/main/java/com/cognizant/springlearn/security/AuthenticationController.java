// Week 3 / 5. JWT-handson / "Create authentication service that returns JWT"
package com.cognizant.springlearn.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// URL: /authenticate
// Sample Request: curl -s -u user:pwd http://localhost:8090/authenticate
// Sample Response: {"token":"eyJhbGciOiJIUzI1NiJ9. ... "}
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    // In a real application this key should come from a secrets manager / environment
    // variable rather than being hard coded. Must be >= 256 bits for HS256.
    private static final String SECRET_KEY = "this-is-a-demo-secret-key-please-change-me-32b";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("authHeader={}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.info("Start");

        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes, StandardCharsets.UTF_8);
        String user = decodedCredentials.substring(0, decodedCredentials.indexOf(":"));

        LOGGER.debug("user={}", user);
        LOGGER.info("End");
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.info("Start");

        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        // Token expires 20 minutes (1,200,000 ms) from now
        builder.setExpiration(new Date(System.currentTimeMillis() + 1200000));
        builder.signWith(key, SignatureAlgorithm.HS256);

        String token = builder.compact();

        LOGGER.debug("token={}", token);
        LOGGER.info("End");
        return token;
    }

}
