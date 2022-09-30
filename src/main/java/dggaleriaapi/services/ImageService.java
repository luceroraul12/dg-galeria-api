package dggaleriaapi.services;

public interface ImageService {

    void createImage(String fileName, String urlImage, String folderName);
    void deleteImage(String fileName, String folderName);
}
