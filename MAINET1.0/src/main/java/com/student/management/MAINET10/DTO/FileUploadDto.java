package com.student.management.MAINET10.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Data
public class FileUploadDto {

    private long empId;
    private Base64 fileBytes;
    private String fileName;
}
