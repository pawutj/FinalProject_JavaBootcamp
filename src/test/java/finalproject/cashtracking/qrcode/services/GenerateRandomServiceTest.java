package finalproject.cashtracking.qrcode.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateRandomServiceTest {

    @Test
    void generateRandomBase64Token() {
        GenerateRandomService generateRandomService  = new GenerateRandomService();
        String result = generateRandomService.generateRandomBase64Token(6);

        assertEquals(result.length(),8);
    }
}