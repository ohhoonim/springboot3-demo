package dev.ohhoonim.demo.controller;

import java.io.File;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.google.common.io.Files;

@RestController
@RequestMapping("/files")
public class FileUploadController {
    @Value("${file.upload.rootpath}")
    private String uploadPath;

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public void upload(@RequestPart("dto") Object dto, @RequestPart("file") MultipartFile file)
            throws Exception {
        String fileName = file.getOriginalFilename();
        String extension = Files.getFileExtension(fileName);
        if (!"jpg".equalsIgnoreCase(extension)) {
            // TODO extension 체크
        }

        File path = new File(uploadPath);
        if (!path.exists()) {
            path.mkdirs();
        }
        File uploadFile = new File(path, UUID.randomUUID().toString().replaceAll("-", "") + "." + extension);
        file.transferTo(uploadFile);
    }

    // TODO 이미지 다운로드(mime type을 이미지형태로)
}
