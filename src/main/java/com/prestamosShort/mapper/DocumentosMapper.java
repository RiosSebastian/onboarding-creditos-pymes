package com.prestamosShort.mapper;

import com.prestamosShort.dto.DocumentosDtoRes;
import com.prestamosShort.dto.EmpresaDtoRes;
import com.prestamosShort.dto.dtoReq.DocumentosDtoReq;
import com.prestamosShort.entity.Documentos;
import com.prestamosShort.entity.Empresa;

public class DocumentosMapper {
    public DocumentosDtoRes toDto(Documentos documentos){
        return DocumentosDtoRes.builder()
                .estado(documentos.getEstado())
                .fechaSubida(documentos.getFechaSubida())
                .tipo(documentos.getTipo())
                .urlStorage(documentos.getUrlStorage())
                .build();
    }

    public Documentos toDocumentos(DocumentosDtoReq dtoReq){
        return Documentos.builder()
                .estado(dtoReq.estado())
                .fechaSubida(dtoReq.fechaSubida())
                .tipo(dtoReq.tipo())
                .urlStorage(dtoReq.urlStorage())
                .build();
    }
}
