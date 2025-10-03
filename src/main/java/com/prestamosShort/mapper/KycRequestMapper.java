package com.prestamosShort.mapper;

import com.prestamosShort.dto.KycRequestDtoRes;
import com.prestamosShort.dto.dtoReq.KycRequestDtoReq;
import com.prestamosShort.entity.KycRequest;

public class KycRequestMapper {
    public KycRequestDtoRes toDto(KycRequest kycRequest){
        return KycRequestDtoRes.builder()
                .respuestaRaw(kycRequest.getRespuestaRaw())
                .resultado(kycRequest.getResultado())
                .fechaVerificacion(kycRequest.getFechaVerificacion())
                .proveedor(kycRequest.getProveedor())
                .build();
    }

    public KycRequest toKyc(KycRequestDtoReq request){
        return KycRequest.builder()
                .proveedor(request.proveedor())
                .fechaVerificacion(request.fechaVerificacion())
                .resultado(request.resultado())
                .respuestaRaw(request.respuestaRaw())
                .build();
    }
}
