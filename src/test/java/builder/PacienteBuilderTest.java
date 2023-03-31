package builder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PacienteBuilderTest {

    @Test
    void deveRetornarExcecaoParaPacienteSemID() {
        try {
            PacienteBuilder pacienteBuilder = new PacienteBuilder();
            Paciente paciente = pacienteBuilder
                    .setNome("Paciente 1")
                    .setEmail("paciente1@email.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("ID do paciente inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoParaPacienteSemNome() {
        try {
            PacienteBuilder pacienteBuilder = new PacienteBuilder();
            Paciente paciente = pacienteBuilder
                    .setIdPaciente(1)
                    .setEmail("paciente1@email.com")
                    .build();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarPacienteValido() {
        PacienteBuilder pacienteBuilder = new PacienteBuilder();
        Paciente paciente = pacienteBuilder
                .setIdPaciente(1)
                .setNome("Paciente 1")
                .setEmail("aluno1@email.com")
                .build();

        assertNotNull(paciente);
    }
}