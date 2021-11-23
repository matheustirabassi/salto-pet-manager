package br.com.saltopetmanager.matheustirabassi.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TutorTest {

    private Tutor tutor;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @BeforeEach
    public void SetUp() throws Exception {
        tutor = new Tutor();
        tutor.setName("user");
        tutor.setCpf(12345678909L);
        tutor.setBirthDate(sdf.parse("01/01/2000"));
        tutor.setEmail("user@email.com");
    }
    @Test
    public void setBirthDateTest_DateValid_Success() throws ParseException {
    tutor.setBirthDate(sdf.parse("16/04/2000"));
    assertEquals(sdf.parse("16/04/2000"), tutor.getBirthDate());
    }
    @Test
    @DisplayName("Ao informar uma data inválida, dá um parse exception")
    public void setBirthDateTest_InvalidDate_ParseException() throws ParseException {
        Exception exception = assertThrows(ParseException.class, () -> tutor.setBirthDate(sdf.parse("1a")));
        assertEquals("Unparseable date: \"1a\"", exception.getMessage());
    }

}
