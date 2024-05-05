package com.example.BUYsell.Controllers;

import com.example.BUYsell.Models.Image;
import com.example.BUYsell.Repositories.ImageRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@Data
@RequiredArgsConstructor
public class ImageController {
    private final ImageRepository imageRepository;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id){
        Image image=imageRepository.findById(id).orElseThrow(null);
//        if (image.getContentType().equals("image/jpeg") || image.getContentType().equals("image/png")){
//            try {
//                byte bytes[]=image.getBytes();
//                String name=image.getName();
//                String originalFileName=image.getOriginalFileName();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));

    }
}
