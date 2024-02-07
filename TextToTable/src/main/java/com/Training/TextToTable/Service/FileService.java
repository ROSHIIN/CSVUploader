package com.Training.TextToTable.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {
    boolean hasCSVFormat(MultipartFile file);

    void processAndSaveData(MultipartFile file);
}
