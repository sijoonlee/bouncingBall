package github.sijoonlee.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class BouncingBallView extends View {
    Ball ball;
    private Paint paint;
    private double boundaryWidth;
    private double boundaryHeight;

    public BouncingBallView(Context context, double boundaryWidth, double boundaryHeight) {
        super(context);
        ball = new Ball(10,10,10);
        this.boundaryWidth = boundaryWidth;
        this.boundaryHeight = boundaryHeight;
        paint = new Paint();

    }
    public void update(){
        this.bounceOnWall();
        ball.update();
    }

    public void bounceOnWall(){
        if ( ball.minX <= 0 ){
            ball.x = ball.radius;
            ball.reverseSpeedX();
            ball.decreaseSpeedX();
            ball.reverseAccX();
            ball.decreaseAccX();
        } else if (ball.maxX >= this.boundaryWidth){
            ball.x = this.boundaryWidth - ball.radius;
            ball.reverseSpeedX();
            ball.decreaseSpeedX();
            ball.reverseAccX();
            ball.decreaseAccX();
        }

        if ( ball.minY <= 0 ) {
            ball.y = ball.radius;
            ball.reverseSpeedY();
            ball.reverseAccY();
            ball.decreaseSpeedY();
            ball.decreaseAccY();

        } else if (ball.maxY >= this.boundaryHeight){
            ball.y = this.boundaryHeight - ball.radius;
            ball.reverseSpeedY();
            ball.reverseAccY();
            ball.decreaseSpeedY();
            ball.decreaseAccY();
        }


    }

    @Override
    protected void onDraw(Canvas canvas){
        // boundaryBox.set()
        paint.setColor(Color.GREEN);
        this.update();
        canvas.drawCircle((float)ball.x, (float)ball.y, (float)ball.radius, paint);
        try{
            Thread.sleep(30);

        } catch (InterruptedException e) {}

        invalidate(); // force to redraw

    }
}
