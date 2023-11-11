import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import javax.imageio.ImageIO;

public class GrayscaleConverter {
    public static void main(String[] args) throws Exception {
        // Load the image
        BufferedImage image = ImageIO.read(new File("C:\\Users\\Admin\\OneDrive\\Картини\\vector.jpg"));

        if (image.getColorModel().getColorSpace().getType() == ColorSpace.TYPE_GRAY) {
            System.out.println("The image is already in grayscale");
            return;
        }
        // Create a bitmap
        BufferedImage bitmap = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        // Copy the pixels
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        op.filter(image, bitmap);

        ImageIO.write(bitmap, "jpg", new File("C:\\Users\\Admin\\OneDrive\\Картини\\grayscale.jpg"));
        // Convert the bitmap to a string representation
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < bitmap.getHeight(); y++) {
            for (int x = 0; x < bitmap.getWidth(); x++) {
                int pixel = bitmap.getRGB(x, y);
                int value = (pixel >> 8) & 0xff; // extract the grayscale value
                sb.append(getCharacterForValue(value)); // convert the value to a character and append it to the string
            }
            sb.append("\n"); // add a newline character after each row
        }

        // Print the string to the console
        System.out.println(sb.toString());
    }

    private static char getCharacterForValue(int value) {
        // This method maps a grayscale value (0-255) to a character
        char[] chars = {' ', '.', ':', '-', '=', '+', '*', '#', '%', '@'};
        int index = Math.round((chars.length - 1) * ((float) value / 255));
        return chars[index];
    }
}
