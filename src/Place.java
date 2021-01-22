import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Place
{

    //protected static CopyOnWriteArrayList<Student> students = new CopyOnWriteArrayList<>();
    protected ArrayList<Student> students = new ArrayList<>();

    String place;


    public Place(String place) {
        this.place = place;

        System.out.println("A "+place+" has been created");
    }

    public void print()
    {
        System.out.println("People in " + place + " are: ");

        for(Student student:students)
        {
            System.out.println(student.getName());
        }

    }

    public boolean enter(Student student)
    {
        students.add(student) ;
        System.out.println(student.getName() + " enters " + place);
        return true;
    }

    public void exit(Student student)
    {
        students.removeIf(student::equals);
        System.out.println(student.getName() + " exits " + place);
    }

    public void empty() {
        while (!students.isEmpty()) {
            int m = new Random().nextInt(getStudents().size());
            Student student = getStudents().get(m);
            exit(student);
        }
    }


    public ArrayList<Student> getStudents() {
        return students;
    }
}