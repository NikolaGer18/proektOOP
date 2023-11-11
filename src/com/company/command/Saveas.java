package com.company.command;

import java.io.FileWriter;
import java.io.IOException;

public class Saveas {
        if (!currentSessionImages.isEmpty()) {
        try (FileWriter writer = new FileWriter("output_first_image.ppm")) {
            writer.write(currentSessionImages.get(0));
            System.out.println("First image saved as output_first_image.ppm");
        } catch (IOException e) {
            System.out.println("Error saving image");
        }
    } else {
        System.out.println("No images to save.");
    }
}
