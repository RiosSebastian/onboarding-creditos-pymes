package com.prestamosShort.servis;

import com.prestamosShort.dto.DocumentosDtoRes;
import com.prestamosShort.dto.SolicitudCreditoDtoRes;
import com.prestamosShort.dto.dtoReq.DocumentosDtoReq;
import com.prestamosShort.dto.dtoReq.SolicitudCreditoDtoReq;

import java.util.List;

public interface DocumentosServis {


    // metodo para crear los documentos (tenemos que hacer que este metodo sea para subir los archivos en pdf o otros)
    DocumentosDtoRes createDocumentos(DocumentosDtoReq userDTOReq);

    // Firma del método para obtener un documento por su ID
    DocumentosDtoRes getDocumentosById(Long id);

    // método para actualizar un documento
    DocumentosDtoRes updateDocumentos(Long id, DocumentosDtoReq userDTOReq);

    // método para eliminar un documento por su ID
    void deleteDocumento(Long id);

    // método para obtener todos los documentos
    List<DocumentosDtoRes> getAllDocumentos();
}
