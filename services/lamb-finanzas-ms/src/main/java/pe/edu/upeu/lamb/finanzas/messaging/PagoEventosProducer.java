package pe.edu.upeu.lamb.finanzas.messaging;

import pe.edu.upeu.lamb.finanzas.event.PagoAceptadoEvento;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@Component
@RequiredArgsConstructor
public class PagoEventosProducer {

    private final KafkaTemplate<String, PagoAceptadoEvento> kafkaTemplate;

    @Value("${app.kafka.topic.pago-aceptado}")
    private String topicPagoAceptado;

    public void publicarTrasCommit(PagoAceptadoEvento evento) {
        if (TransactionSynchronizationManager.isSynchronizationActive()) {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    enviar(evento);
                }
            });
        } else {
            enviar(evento);
        }
    }

    private void enviar(PagoAceptadoEvento evento) {
        kafkaTemplate.send(topicPagoAceptado, String.valueOf(evento.getIdPersona()), evento)
                .whenComplete((resultado, ex) -> {
                    if (ex != null) {
                        log.error("component=producer topic={} eventType={} idPersona={} status=error error=\"{}\"",
                                topicPagoAceptado, evento.getTipoEvento(), evento.getIdPersona(), ex.getMessage());
                        return;
                    }
                    log.info("component=producer topic={} partition={} offset={} eventType={} idPersona={} status=published",
                            resultado.getRecordMetadata().topic(),
                            resultado.getRecordMetadata().partition(),
                            resultado.getRecordMetadata().offset(),
                            evento.getTipoEvento(), evento.getIdPersona());
                });
    }
}
