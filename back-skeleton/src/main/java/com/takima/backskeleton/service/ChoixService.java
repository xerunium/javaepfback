package com.takima.backskeleton.service;

import com.takima.backskeleton.DAO.ChoixDao;
import com.takima.backskeleton.dataload.ImageUtils;
import com.takima.backskeleton.models.Choix;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class ChoixService {

    private final ChoixDao choixDao;

    public String uploadImage(MultipartFile imageFile) throws IOException {
        var imageToSave = Choix.builder()
                .description(imageFile.getOriginalFilename())
                .image(ImageUtils.compressImage(imageFile.getBytes()))
                .build();
        choixDao.save(imageToSave);
        return "file uploaded successfully : " + imageFile.getOriginalFilename();
    }

    public byte[] downloadImage(String imageName) {
        Optional<Choix> dbImage = choixDao.findByDescription(imageName);

        return dbImage.map(image -> {
            try {
                return ImageUtils.decompressImage(image.getImage());
            } catch (DataFormatException | IOException exception) {
                throw new ContextedRuntimeException("Error downloading an image", exception)
                        .addContextValue("Image ID",  image.getId())
                        .addContextValue("Image name", imageName);
            }
        }).orElse(null);
    }
}
