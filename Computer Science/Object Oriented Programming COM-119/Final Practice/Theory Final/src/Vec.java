public class Vec {
    public static void main(String[] args) {
        Vector v1 = new Vector(1f, 2f);
        Vector v2 = new Vector(2f, 3f);
        Vector v3 = v1.add(v2);
        System.out.println(v3.getX() + " " + v3.getY());
    }
}

class Vector {
    private float x, y;

    Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }

    Vector add(Vector vector) {
        return new Vector(x + vector.x, y + vector.y);
    }
}
