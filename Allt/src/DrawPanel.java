import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Map;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize


    BufferedImage volvoImage;
    BufferedImage ScaniaImage;
    BufferedImage SaabImage;

    Map<Cars, BufferedImage> cars = new HashMap<Cars, BufferedImage>();

    // To keep track of a singel cars position

    void addCars(Cars car) {
       if (cars instanceof Saab95) {
           cars.put(car, SaabImage);
       }

       else if (cars instanceof Volvo240) {
           cars.put(car, volvoImage);
       }

       else if (cars instanceof Scania) {
           cars.put(car, ScaniaImage);
       }

    }
    Point volvoPoint = new Point();

    // TODO: Make this genereal for all cars
    void moveit(int x, int y){
        volvoPoint.x = x;
        volvoPoint.y = y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        {
            try {
                // You can remove the "pics" part if running outside of IntelliJ and
                // everything is in the same main folder.
                // volvoImage = ImageIO.read(new File("Volvo240.jpg"));
                // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
                // if you are starting in IntelliJ.
                volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
                ScaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
                SaabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(cars.get(cars), volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
    }
}
