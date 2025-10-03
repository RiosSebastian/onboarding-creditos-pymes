package com.prestamosShort.servis;

import com.prestamosShort.dto.EmpresaDtoRes;
import com.prestamosShort.dto.SolicitudCreditoDtoRes;
import com.prestamosShort.dto.dtoReq.EmpresaDtoReq;
import com.prestamosShort.dto.dtoReq.SolicitudCreditoDtoReq;

import java.util.List;

public interface SolicitudCreditoServis {
    // metodo para crear la solicitud
    SolicitudCreditoDtoRes createSolicitud(SolicitudCreditoDtoReq userDTOReq);

    // Firma del método para obtener una solicitud por su ID
    SolicitudCreditoDtoRes getSolicitudById(Long id);

    // método para actualizar una solicitud
    SolicitudCreditoDtoRes updateSolicitud(Long id, SolicitudCreditoDtoReq userDTOReq);

    // método para eliminar una solicitud por su ID
    void deleteSolicitud(Long id);

    // método para obtener todas la solicitudes
    List<SolicitudCreditoDtoRes> getAllSolicitud();
}
