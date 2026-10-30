package pe.edu.upeu.lamb.matricula.service;

import pe.edu.upeu.lamb.matricula.dto.ListaEsperaSeccionRequest;
import pe.edu.upeu.lamb.matricula.dto.ListaEsperaSeccionResponse;
import pe.edu.upeu.lamb.matricula.entity.ListaEsperaSeccion;
import pe.edu.upeu.lamb.matricula.exception.ResourceNotFoundException;
import pe.edu.upeu.lamb.matricula.mapper.ListaEsperaSeccionMapper;
import pe.edu.upeu.lamb.matricula.repository.ListaEsperaSeccionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListaEsperaSeccionService {

    private final ListaEsperaSeccionRepository listaEsperaSeccionRepository;
    private final ListaEsperaSeccionMapper listaEsperaSeccionMapper;

    public List<ListaEsperaSeccionResponse> listar() {
        return listaEsperaSeccionRepository.findAll().stream()
                .map(listaEsperaSeccionMapper::toResponse)
                .toList();
    }

    public ListaEsperaSeccionResponse obtener(Long id) {
        return listaEsperaSeccionMapper.toResponse(buscarOFallar(id));
    }

    public ListaEsperaSeccionResponse crear(ListaEsperaSeccionRequest request) {
        ListaEsperaSeccion entity = listaEsperaSeccionMapper.toEntity(request);
        return listaEsperaSeccionMapper.toResponse(listaEsperaSeccionRepository.save(entity));
    }

    private ListaEsperaSeccion buscarOFallar(Long id) {
        return listaEsperaSeccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lista de espera de seccion no encontrada: " + id));
    }
}
