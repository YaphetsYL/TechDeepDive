package com.dbs.ce.gapi.utf8;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

/**
 * @author Lei
 * @version 1.0
 * @date 2022/3/25 - 03 - 25 - 23:22
 */
public class ImageToBase64String {

    public static void main(String[] args) {
        //String inputImagePath = "image/image1.jpg";
        //String outputImagePath = "image1Out.jpg";
        String inputImagePath = "image/image2.gif";
        String outputImagePath = "image2Out.jpg";
        ClassLoader classLoader = ImageToBase64String.class.getClassLoader();

        String encodedString = "";
        File inputImage = new File(classLoader
                .getResource(inputImagePath)
                .getFile());

        try {
            byte[] imageContent = FileUtils.readFileToByteArray(inputImage);
            encodedString = Base64.getEncoder().encodeToString(imageContent);
            System.out.println(encodedString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File outputImage = new File(inputImage.getParentFile().getAbsoluteFile()
                + File.separator + outputImagePath);

        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
            FileUtils.writeByteArrayToFile(outputImage, decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
