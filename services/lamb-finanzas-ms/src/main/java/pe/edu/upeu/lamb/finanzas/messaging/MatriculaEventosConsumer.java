package pe.edu.upeu.lamb.finanzas.messaging;

import pe.edu.upeu.lamb.finanzas.event.MatriculaConfirmadaEvento;
import pe.edu.upeu.lamb.finanzas.service.PagoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MatriculaEventosConsumer {

    private static final String MATRICULA_REGISTRADA = "matricula.registrada";

    private final PagoService pagoService;

    @KafkaListener(topics = "${app.kafka.topic.matricula}",
            properties = "spring.json.value.default.type=pe.edu.upeu.lamb.finanzas.event.MatriculaConfirmadaEvento")
    public void alRecibirMatricula(MatriculaConfirmadaEvento evento) {
        if (!MATRICULA_REGISTRADA.equals(evento.getTipoEvento())) {
            log.warn("component=consumer eventType={} status=ignored", evento.getTipoEvento());
            return;
        }
        log.info("component=consumer eventType={} matriculaId={} idPersona={} status=consumed",
                evento.getTipoEvento(), evento.getMatriculaId(), evento.getIdPersona());
        pagoService.generarCargoDeMatricula(evento);
    }
}
