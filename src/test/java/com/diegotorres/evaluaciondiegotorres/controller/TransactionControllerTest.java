package com.diegotorres.evaluaciondiegotorres.controller;
import com.diegotorres.evaluaciondiegotorres.aplication.input.port.TransactionInputPort;
import com.diegotorres.evaluaciondiegotorres.domain.Trasaction;
import com.diegotorres.evaluaciondiegotorres.infraestructure.input.adapter.rest.dto.TransactionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionInputPort transactionInputPort;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateTransaction() throws Exception {
        // Datos de prueba
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setValue(100.0); // Establece cualquier valor para el monto

        Long idAccount = 1L; // Establece cualquier ID de cuenta

        // Mock del resultado de la operación en el puerto de entrada
        Trasaction transaction = new Trasaction();
        Mockito.when(transactionInputPort.createTransaction(any(Trasaction.class), eq(idAccount))).thenReturn(transaction);

        // Realizar la solicitud POST al endpoint /transaction
        mockMvc.perform(post("/transaction")
                        .param("idAccount", String.valueOf(idAccount))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transactionDto)))
                .andExpect(status().isOk());
    }
}
