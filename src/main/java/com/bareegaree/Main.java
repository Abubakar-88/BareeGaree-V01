package com.bareegaree;

import java.io.File;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] paths = {
                "C:\\Users\\siddi\\TestingPicture\\imageFurniture1.jpg",
                "C:\\Users\\siddi\\TestingPicture\\Bed_roomRent.jpg",
                "C:\\Users\\siddi\\TestingPicture\\Bedroom-Collection.jpg"
        };

        for (String path : paths) {
            File file = new File(path);
            if (file.exists()) {
                System.out.println("File exists: " + path);
            } else {
                System.out.println("File does not exist: " + path);
            }
        }
        }
    }
