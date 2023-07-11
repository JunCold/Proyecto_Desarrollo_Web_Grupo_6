package com.ProyectoGrupo6.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, String id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "proyecto-grupo6-72ebb.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "proyecto-Grupo6";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "proyecto-grupo6-72ebb-firebase-adminsdk-8h17x-166437a29c";
}