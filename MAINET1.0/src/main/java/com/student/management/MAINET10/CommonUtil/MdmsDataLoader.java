package com.student.management.MAINET10.CommonUtil;

import java.io.InputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.management.MAINET10.CommonServies.MdmsCache;

import jakarta.annotation.PostConstruct;

@Component
public class MdmsDataLoader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void inti() {
        try {
            loadMdms("TaxMaster", "mdms/tax-master.json");
        } catch (Exception ex) {
            throw new RuntimeException("Failed to load MDMS data", ex);
        }
    }

    private void loadMdms(String moduleName, String filePath) throws Exception {
        ClassPathResource resource = new ClassPathResource(filePath);
        try (InputStream is = resource.getInputStream()) {
            Object jsonData = objectMapper.readValue(is, Object.class);
            MdmsCache.put(moduleName, jsonData);
        }

    }
}
