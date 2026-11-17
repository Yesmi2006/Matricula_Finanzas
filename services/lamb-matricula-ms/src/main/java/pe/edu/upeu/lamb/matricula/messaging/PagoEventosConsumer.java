package pe.edu.upeu.lamb.matricula.messaging;

import pe.edu.upeu.lamb.matricula.event.PagoAceptadoEvento;
import pe.edu.upeu.lamb.matricula.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PagoEventosConsumer {

    private static final String PAGO_ACEPTADO = "pago.aceptado";

    private final MatriculaService matriculaService;

    @KafkaListener(topics = "${app.kafka.topic.pago-aceptado}",
            properties = "spring.json.value.default.type=pe.edu.upeu.lamb.matricula.event.PagoAceptadoEvento")
    public void alRecibirPago(PagoAceptadoEvento evento) {
        if (!PAGO_ACEPTADO.equals(evento.getTipoEvento())) {
            log.warn("component=consumer eventType={} status=ignored", evento.getTipoEvento());
            return;
        }
        log.info("component=consumer eventType={} matriculaId={} idPersona={} status=consumed",
                evento.getTipoEvento(), evento.getMatriculaId(), evento.getIdPersona());
        matriculaService.confirmar(evento.getMatriculaId());
    }
}
