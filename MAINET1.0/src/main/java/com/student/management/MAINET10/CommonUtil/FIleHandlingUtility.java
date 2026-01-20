package com.student.management.MAINET10.CommonUtil;

import com.student.management.MAINET10.DTO.FileUploadDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class FIleHandlingUtility {
    private static final String IMG_PATH = "C:/Users/Harshad/OneDrive/Documents/filenet";

    public FileUploadDto uploadImage(FileUploadDto file) throws IOException {

        byte[] imageBytes = Base64.getDecoder().decode(file.getFileBytes().toString());
        Path filePath = Paths.get(IMG_PATH, String.valueOf(file.getEmpId()));

        if (!Files.exists(filePath)) {
            Files.createDirectories(filePath);
        }
        Path newFilePth = filePath.resolve(file.getFileName());
        Files.write(newFilePth, imageBytes);
        return null;
    }
}
