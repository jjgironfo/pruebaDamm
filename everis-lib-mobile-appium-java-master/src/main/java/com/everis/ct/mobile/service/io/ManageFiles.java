package com.everis.ct.mobile.service.io;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static com.everis.ct.mobile.service.util.UtilMobile.logger;

public class ManageFiles {

    public static String readAsString(String fileResourcesPath) {
        try {
            Resource resource = new ClassPathResource(fileResourcesPath);
            InputStream inputStream = resource.getInputStream();
            return new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new RuntimeException(e); // TODO: Mejorar Excepciones
        }
    }

    public static String getJsonContentAsString(String jsonPath) {
        File file = new File(jsonPath);
        String content = StringUtils.EMPTY;
        try {
            content = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
        } catch (IOException e) {
            logger(ManageFiles.class).warning("Ocurrio un error al leer el archivo.");
        }

        if (content.isEmpty()) logger(ManageFiles.class).log(Level.WARNING, "El archivo JSON esta vacio.");

        return content;
    }

}