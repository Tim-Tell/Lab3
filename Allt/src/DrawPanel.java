import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Map;
import java.util.Objects;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize


    BufferedImage volvoImage;
    BufferedImage ScaniaImage;
    BufferedImage SaabImage;

    Map<Cars, BufferedImage> carsMap = new HashMap<>();

    // To keep track of a singel cars position

    void addCars() {
        for (Cars car : CarController.cc.cars) {
            if (car instanceof Saab95) {
                carsMap.put(car, SaabImage);
            } else if (car instanceof Volvo240) {
                carsMap.put(car, volvoImage);
            } else if (car instanceof Scania) {
                carsMap.put(car, ScaniaImage);
            }
        }

    }
    Point carPoint = new Point();

    public int getCarPointY(){
        int timPoint = carPoint.y;
        return timPoint;
    }

    // TODO: Make this genereal for all cars
    void moveit(int x, int y) {
        carPointVolvo.x = x;
        carPointVolvo.y = y;
        carPointScania.x = x;
        carPointScania.y = y;
        carPointSaab.x = x;
        carPointSaab.y = y;

    }
    public void AddingCarPoints() {
        for (Cars car : CarController.cc.cars) {
            if (car instanceof Saab95) {
                CarPoints.add(carPointSaab);
            } else if (car instanceof Volvo240) {
                CarPoints.add(carPointVolvo);
            } else if (car instanceof Scania) {
                CarPoints.add(carPointScania);
            }
        }
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

                volvoImage = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
                ScaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
                SaabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
                addCars();
                System.out.println(carsMap);




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
        for (Cars car : carsMap.keySet())       {
        super.paintComponent(g);
        g.drawImage(carsMap.get(car), carPoint.x, carPoint.y, null); // see javadoc for more info on the parameters
    }       }
}
