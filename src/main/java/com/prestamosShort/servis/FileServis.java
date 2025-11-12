package com.prestamosShort.servis;

import com.prestamosShort.dto.ResponseFile;
import com.prestamosShort.entity.FileEntity;
import org.eclipse.angus.mail.iap.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FileServis {


    FileEntity store(MultipartFile file) throws IOException; //para almacenar o cargar archivos a la base de datos

    Optional<FileEntity>getFile(UUID id) throws FileNotFoundException;//para descarger archivos de la base de datos

    List<ResponseFile> getAllFiles();//para consultar la lista de archivos en la base de datos

}
