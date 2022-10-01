package dggaleriaapi.services.Imp;

import dggaleriaapi.services.ImageService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ImageServiceImp implements ImageService {
    @Override
    public void createImage(String fileName, String urlImage, String folderName) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(urlImage).openStream());
             FileOutputStream fileOS = new FileOutputStream("src/main/resources/static/images/"+folderName+"/"+fileName+".jpg")) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        } catch (IOException e) {
            // handles IO exceptions
        }
    }

    @Override
    public String getImage(String fileName, String folderName) throws FileNotFoundException {
        return "src/main/resources/static/images/"+folderName+"/"+fileName+".jpg";
    }

    @Override
    public void deleteImage(String fileName, String folderName) {
        File file = new File("src/main/resources/static/images/"+folderName+"/"+fileName+".jpg");
        file.delete();
    }

    @Override
    public boolean isURLValid(String urlImage) throws IOException {
        URL url = new URL(urlImage);
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        huc.setInstanceFollowRedirects(false);

        int responseCode = huc.getResponseCode();

        return HttpURLConnection.HTTP_OK != responseCode;
    }
}
