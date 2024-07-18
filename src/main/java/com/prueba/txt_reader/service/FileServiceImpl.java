package com.prueba.txt_reader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Value("${ruta.archivo}")
    private String outputFilePath;

    @Value("${regiones}")
    private String regionesProperty;

    @Value("${ciclos}")
    private String ciclosProperty;

    @Override
    public void generateFile() {
        List<String> regiones = Arrays.asList(regionesProperty.split(","));
        List<String> ciclos = Arrays.asList(ciclosProperty.split(","));
        writeToFile(regiones, ciclos);
    }
 

    private void writeToFile(List<String> regiones, List<String> ciclos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            StringBuilder sb1 = new StringBuilder();
            for (int i = 0; i < ciclos.size(); i++) {
                if (i > 0) sb1.append(", ");
                sb1.append(regiones.get(i)).append("-").append(ciclos.get(i));
            }
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < ciclos.size(); i++) {
                if (i == 0) sb2.append("\n");
                if (i >= 0) sb2.append("\n");
                sb2.append(regiones.get(i)).append("-").append(ciclos.get(i));
            }
            
            StringBuilder sb3 = new StringBuilder();
            Collections.reverse(regiones);
            Collections.reverse(ciclos);
            for (int i = 0; i < ciclos.size(); i++) {
                if (i == 0) sb3.append("\n");
                if (i >= 0) sb3.append("\n");
                sb3.append(regiones.get(i)).append("-").append(ciclos.get(i));
            }
        
            writer.write(sb1.toString());
            writer.write(sb2.toString());
            writer.write(sb3.toString());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}