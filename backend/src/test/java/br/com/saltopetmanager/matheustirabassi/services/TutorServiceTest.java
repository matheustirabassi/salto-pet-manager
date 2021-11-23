package br.com.saltopetmanager.matheustirabassi.services;

import br.com.saltopetmanager.matheustirabassi.domain.Tutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


public class TutorServiceTest {
    @Mock
    private TutorService tutorService;

    private Tutor tutor = new Tutor();

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @BeforeEach
    public void SetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        tutor.setName("user");
        tutor.setCpf(12345678909L);
        tutor.setBirthDate(sdf.parse("01/01/2000"));
        tutor.setEmail("user@email.com");
    }

    @Test
    public void findTest_AllValid_Success() {
        when(tutorService.find(12345678909L)).thenReturn(tutor);
        Tutor test = tutorService.find(12345678909L);
        assertEquals(tutor, test);
    }
    @Test
    public void findTest_TutorNotFound_Exception(){
        when(tutorService.find(anyLong())).thenReturn(null);
        when(tutorService.find(12345678909L)).thenReturn(tutor);

        Tutor test = tutorService.find(anyLong());
        assertEquals(null, test);
    }
}
