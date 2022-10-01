package dggaleriaapi.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public interface ImageService {

    void createImage(String fileName, String urlImage, String folderName);

    String getImage(String fileName, String folderName) throws FileNotFoundException;
    void deleteImage(String fileName, String folderName);

    boolean isURLValid(String url) throws IOException;
}
