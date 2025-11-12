package com.prestamosShort.servis.servisImpl;

import com.prestamosShort.dto.ResponseFile;
import com.prestamosShort.entity.FileEntity;
import com.prestamosShort.repository.FileRepository;
import com.prestamosShort.servis.FileServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileServisImpl implements FileServis {
    @Autowired
    FileRepository fileRepository;
    @Override
    public FileEntity store(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());//para obtener el nombre original del archivo
        FileEntity fileEntity = FileEntity.builder()//construir el objeto para la base de datos
                .name(filename)
                .type(file.getContentType())
                .data(file.getBytes())
                .build();


        return fileRepository.save(fileEntity);
    }

    @Override
    public Optional<FileEntity> getFile(UUID id) throws FileNotFoundException {
        Optional<FileEntity> file = fileRepository.findById(id);//traer de base de datos
        if(file.isPresent()){
            return file;
        }
        return new FileNotFoundException;
    }


    @Override
    public List<ResponseFile> getAllFiles() {
        List<ResponseFile>files = fileRepository.findAll().stream().map(dbFile ->{
            String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()//costruyendo la url para descargar el archivo
                    .path("api/fileManager/files/")
                    .path(dbFile.getId().toString())
                    .toUriString();

            return ResponseFile.builder()
                    .name(dbFile.getName())
                    .url(fileDownloadUrl)
                    .type(dbFile.getType())
                    .size(dbFile.getData().length)
                    .build();
        }).collect(Collectors.toList());

        return files;
    }
}
