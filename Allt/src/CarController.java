import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */



public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    protected ArrayList<Cars> cars = new ArrayList<>();
    static CarController cc = new CarController();


    //methods:

    public static void main(String[] args) {
        // Instance of this class

        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());
        cc.cars.add(new Saab95());


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);



        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : cars) {
                car.move();
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : cars
                ) {
            car.gas(gas);
        }
    }

    void brake (int amount) {
        double brake= ((double) amount) / 100;
        for (Cars car : cars) {
            car.brake(brake);
        }
        }

    void startCars() {
        for (Cars car : cars) {
            car.startEngine();
        }
    }

    void stopCars() {
        for (Cars car : cars) {
           car.stopEngine();
        }
    }

    void turboOn() {
        for (Cars car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Cars car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void trailerUp(double amount) {
        for (Cars car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).trailerUp(amount);
            }
        }
    }

    void trailerDown(double amount) {
        for (Cars car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).trailerDown(amount);
            }
        }
    }



}



