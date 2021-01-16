import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Place
{

    //protected static CopyOnWriteArrayList<Student> students = new CopyOnWriteArrayList<>();
    protected ArrayList<Student> students = new ArrayList<>();

    String place;
    int cap;


    public Place(String place, int cap) {
        this.place = place;
        this.cap = cap;
    }

    public Place(String place) {
        this.place = place;
    }

    public Place() {
    }

    public void print()
    {
        System.out.println("People in " + place + " are: ");

        for(Student student:students)
        {
            System.out.println(student.getName());
        }

    }

    boolean enter(Student student)
    {
        students.add(student) ;
        System.out.println(student.getName() + " enters " + place);
        return true;
    }

    void exit(Student student)
    {
        students.removeIf(student::equals);
        System.out.println(student.getName() + " exits " + place);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}