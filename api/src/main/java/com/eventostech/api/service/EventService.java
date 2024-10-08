package com.eventostech.api.service;

import com.amazonaws.services.s3.AmazonS3;
import com.eventostech.api.domain.event.Event;
import com.eventostech.api.domain.event.EventRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class EventService {

    @Value("${{{{aws.bucket.name")
    private String bucketName;

    private AmazonS3 s3Client;
    public Event createEvent(EventRequestDTO data){
        String imgUrl = null;

        if(data.image() != null){
           imgUrl = this.uploadImg(data.image());
        }
        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.date()));
        newEvent.setEventUrl(imgUrl);

        return newEvent;
    }

    private String uploadImg(MultipartFile multipartFile){
        String filename= UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        try{
            File file = this.convertMultipartFile(multipartFile);
            s3Client.putObject(bucketName, filename, file);
            file.delete();
            return s3Client.getUrl(bucketName,filename).toString();

        } catch (Exception e){
        System.out.println("Erro ao subir arquivo");
        return null;
        }

    }
    private File convertMultipartFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();

        return convFile;
    }
}
