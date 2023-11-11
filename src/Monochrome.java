import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Monochrome {

    public static void main(String[] args) {
        try {
            convertToMonochrome("\"C:\\Users\\Admin\\Downloads\\image123.png\"", "monochrome_result.png", 128);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertToMonochrome(String inputPath, String outputPath, int threshold) throws IOException {
        // Read the image/
        BufferedImage image = ImageIO.read(new File(inputPath));

        // Get image dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // Create a BufferedImage for the monochrome result
        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

        // Apply the monochrome effect based on the threshold
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int gray = (int) (0.2989 * ((rgb >> 16) & 0xFF) + 0.5870 * ((rgb >> 8) & 0xFF) + 0.1140 * (rgb & 0xFF));
                int newRGB = (gray < threshold) ? 0x000000 : 0xFFFFFF;
                resultImage.setRGB(x, y, newRGB);
            }
        }

        // Save the result image
        ImageIO.write(resultImage, "png", new File(outputPath));
    }
}
