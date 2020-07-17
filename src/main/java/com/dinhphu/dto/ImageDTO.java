package com.dinhphu.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ImageDTO {

    private List<MultipartFile> multiFiles;

    public ImageDTO() {
    }

    public List<MultipartFile> getMultiFiles() {
        return multiFiles;
    }

    public void setMultiFiles(List<MultipartFile> multiFiles) {
        this.multiFiles = multiFiles;
    }
}
