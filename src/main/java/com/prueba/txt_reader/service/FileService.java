
package com.prueba.txt_reader.service;

public interface FileService {
    void generateFile();
}


// Esta interface está pensada para desacoplar e implimentar varias formas de generateFile, es un patron de diseño para flexibilizar el codigo con sobreestura de metodos.