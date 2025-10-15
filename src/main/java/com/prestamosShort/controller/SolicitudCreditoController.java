package com.prestamosShort.controller;

import com.prestamosShort.dto.SolicitudCreditoDtoRes;
import com.prestamosShort.dto.dtoReq.SolicitudCreditoDtoReq;
import com.prestamosShort.servis.SolicitudCreditoServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudCreditoController {

    @Autowired
    private SolicitudCreditoServis solicitudCreditoServis;

    // Crear solicitud de crédito
    @PostMapping
    public ResponseEntity<SolicitudCreditoDtoRes> createSolicitud(@RequestBody SolicitudCreditoDtoReq solicitudDtoReq) {
        SolicitudCreditoDtoRes nuevaSolicitud = solicitudCreditoServis.createSolicitud(solicitudDtoReq);
        return ResponseEntity.ok(nuevaSolicitud);
    }

    // Obtener solicitud por ID
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudCreditoDtoRes> getSolicitudById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        SolicitudCreditoDtoRes solicitud = solicitudCreditoServis.getSolicitudById(id);
        return ResponseEntity.ok(solicitud);
    }

    // Actualizar solicitud
    @PutMapping("/{id}")
    public ResponseEntity<SolicitudCreditoDtoRes> updateSolicitud(
            @PathVariable Long id,
            @RequestBody SolicitudCreditoDtoReq solicitudDtoReq) throws ChangeSetPersister.NotFoundException {
        SolicitudCreditoDtoRes actualizada = solicitudCreditoServis.updateSolicitud(id, solicitudDtoReq);
        return ResponseEntity.ok(actualizada);
    }

    //Eliminar solicitud
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitud(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        solicitudCreditoServis.deleteSolicitud(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener todas las solicitudes
    @GetMapping
    public ResponseEntity<List<SolicitudCreditoDtoRes>> getAllSolicitudes() {
        List<SolicitudCreditoDtoRes> solicitudes = solicitudCreditoServis.getAllSolicitud();
        return ResponseEntity.ok(solicitudes);
    }
}
