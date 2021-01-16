import java.util.ArrayList;

public class School extends Place{

    Floor[] floors = new Floor[3];
    private Yard yard;
    private Stairs stairs;

    public School(int cclass) {
        super();

        System.out.println("A new School has been created");

        yard = new Yard();
        stairs = new Stairs();

        for (int i = 0; i < 3; i++) {
            floors[i] = new Floor(cclass, i+1);
        }
    }
@Override
    public boolean enter(Student student)
    {
        yard.enter(student);
        return true;
    }

    public Floor getFloor(int i) {
        return floors[i];
    }

    public Yard getYard() {
        return yard;
    }

    public Stairs getStairs() {
        return stairs;
    }

    public void operate(int N) {
        for (int i = 0; i < 3; i++)
            floors[i].operate(N);
    }


@Override
    public void print() {
        System.out.println("School life consists of: ");
        yard.print();
        stairs.print();
        for (int i = 0; i < 3; i++) {
            floors[i].print();
        }
    }
}