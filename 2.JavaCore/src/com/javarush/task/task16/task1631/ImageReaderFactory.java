package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader newReader;

            if (type == null) {
                IllegalArgumentException e = new IllegalArgumentException("Неизвестный тип картинки");
                throw e;
            }
            else if (type.equals(ImageTypes.JPG)) {
                return newReader = new JpgReader();
            } else if (type.equals(ImageTypes.PNG)) {
                return newReader = new PngReader();
            } else if (type.equals(ImageTypes.BMP)) {
                return newReader = new BmpReader();
            }

        return null;
    }
}
