package com.prestamosShort.servis.servisImpl;

import com.prestamosShort.dto.EmpresaDtoRes;
import com.prestamosShort.dto.dtoReq.EmpresaDtoReq;
import com.prestamosShort.entity.Empresa;
import com.prestamosShort.mapper.EmpresaMapper;
import com.prestamosShort.repository.EmpresaRepository;
import com.prestamosShort.servis.EmpresaServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class EmpresaServiceImpl implements EmpresaServis {

        @Autowired
        private EmpresaRepository empresaRepository;

        @Autowired
        private EmpresaMapper empresaMapper;

        @Override
        public EmpresaDtoRes createEmpresas(EmpresaDtoReq empresaDtoReq) {
            Empresa empresa = empresaMapper.toEmpresa(empresaDtoReq);
            Empresa saved = empresaRepository.save(empresa);
            return empresaMapper.toDto(saved);
        }

        @Override
        public EmpresaDtoRes getEmpresasById(Long id) {
            Empresa empresa = empresaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Empresa no encontrada con id: " + id));
            return empresaMapper.toDto(empresa);
        }

        @Override
        public EmpresaDtoRes updateEmpresa(Long id, EmpresaDtoReq empresaDtoReq) {
            Empresa empresaExistente = empresaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Empresa no encontrada con id: " + id));

            // Actualizamos los datos
            empresaExistente.setNombre(empresaDtoReq.nombre());
            empresaExistente.setCuit(empresaDtoReq.cuit());
            empresaExistente.setDireccion(empresaDtoReq.direccion());
            empresaExistente.setTelefono(empresaDtoReq.telefono());
            empresaExistente.setEmail(empresaDtoReq.email());



            Empresa actualizada = empresaRepository.save(empresaExistente);
            return empresaMapper.toDto(actualizada);
        }

        @Override
        public void deleteEmpresas(Long id) {
            Empresa empresa = empresaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Empresa no encontrada con id: " + id));
            empresaRepository.delete(empresa);
        }

        @Override
        public List<EmpresaDtoRes> getAllEmpresas() {
            return empresaRepository.findAll()
                    .stream()
                    .map(empresaMapper::toDto)
                    .collect(Collectors.toList());
        }
    }


