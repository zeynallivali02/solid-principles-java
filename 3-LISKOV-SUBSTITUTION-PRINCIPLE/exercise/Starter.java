// LSP Practice Exercise — starter code. Square silently breaks Rectangle's
// contract. Redesign so substituting Square for Rectangle can never surprise
// a caller. See README.md in this folder for the full task and requirements.

class Rectangle {
    protected int width;
    protected int height;

   public Rectangle(int w, int h) {
    this.width = w;
    this.height = h;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;

    public Square(int s) {
    this.side = s;
    }


    @Override
    public int getArea(){
        return side * side;
    }
}

public class Starter {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5,10);
        Square square = new Square(15);


       



        // A caller of Rectangle expects independent width/height -> area 50.
        // A Square can't honor that -> area is actually 100.
        System.out.println("Expected 50, got: " + rect.getArea());
    }
}
