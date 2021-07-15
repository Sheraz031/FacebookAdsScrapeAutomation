package Pages;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SaveData {

    public void saveImage(String path, String url) {
        try {
            URL imageUrl = new URL(url);
            BufferedImage saveImage = ImageIO.read(imageUrl);
            ImageIO.write(saveImage, "jpg", new File(path));

        } catch (MalformedURLException ex) {
            System.out.println("Error in Saving Image");
        } catch (IOException ex) {
            System.out.println("Error in Saving Image");
        }
    }

    public void saveVideo(String path, String url) {
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(path);
            file.getParentFile().mkdirs();
            bufferedInputStream = new BufferedInputStream(new URL(url).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            int count = 0;
            byte[] b = new byte[100];
            while ((count = bufferedInputStream.read(b)) != -1) {
                fileOutputStream.write(b, 0, count);
            }
        } catch (MalformedURLException ex) {
            System.out.println("Error in Video Saving");
        } catch (IOException ex) {
            System.out.println("Error in Video Saving");
        } finally {
            try {
                bufferedInputStream.close();
            } catch (IOException ex) {
                System.out.println("Error in Video Saving");
            }
        }
    }

    //Method which write all method information in text file take array list as a parameter
    public void saveText(String path, String text) {
        PrintWriter writer = null;
        try {
            //Create file object
            File f = new File(path);
            //Check file already exist or not if not exist create new file
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   //Create writer object of created file
            writer = new PrintWriter(f);
            //Delete all data from file
            writer.print("");
            //Now write newly data into File
            writer.append(text);

            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error in Wrting Text");
        } finally {
            writer.close();
        }
    }

}
