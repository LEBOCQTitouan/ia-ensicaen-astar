package edu.ensicaen;

import edu.ensicaen.app.App;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.setup();
        while (true) {
            app.next();
            try {
                Thread.sleep(1000 / App.frameRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}