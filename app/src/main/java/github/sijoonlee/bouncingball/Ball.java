package github.sijoonlee.bouncingball;

public class Ball {
    public double x;
    public double y;
    public double radius;
    public double minX;
    public double maxX;
    public double minY;
    public double maxY;
    private double speedX;
    private double speedY;
    private double accelerationX;
    private double accelerationY;
    private double reducingSpeedFactor;
    private double reducingAccFactor;


    public Ball(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speedX = 1;
        this.speedY = 1;
        this.accelerationX = 1;
        this.accelerationY = 1;
        this.updateBoundary();
        this.reducingSpeedFactor = 0.8;
        this.reducingAccFactor = 0.8;

    }

    public void reverseSpeedX(){
        this.speedX *= -1;
    }

    public void reverseSpeedY(){
        this.speedY *= -1;
    }

    public void reverseAccX(){
        this.accelerationX *= -1;
    }

    public void reverseAccY(){
        this.accelerationY *= -1;
    }

    public void decreaseSpeedX(){
        this.speedX *= reducingSpeedFactor;
    }
    public void decreaseSpeedY(){
        this.speedY *= reducingSpeedFactor;
    }
    public void decreaseAccX(){
        this.accelerationX *= reducingAccFactor;
    }
    public void decreaseAccY(){
        this.accelerationY *= reducingAccFactor;
    }

    public void updateBoundary() {
        minX = x - radius;
        maxX = x + radius;
        minY = y - radius;
        maxY = y + radius;
    }

    public void update() {
        speedX += accelerationX;
        speedY += accelerationY;
        x += speedX;
        y += speedY;
        this.updateBoundary();
    }
}
