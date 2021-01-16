import java.util.Random;

public class Class extends Place{

    private int class_number, cclass;
    private Teacher teacher;

    public Class(int cclass,int i) {
        super.place = "Class";
        this.class_number = i;
        this.cclass = cclass;
        System.out.println("A Class has been created");
    }

@Override
    public void print()
    {
        System.out.println("People in Class " + class_number + " are: ");
        for(Student student:students)
        {
            System.out.println(student.getName());
        }
        System.out.println("The Teacher is: ");
        teacher.print();
    }

    public boolean enter(Student student)
    {
        if(getStudents().size()==cclass)
        {
            students.add(student) ;
            System.out.println(student.getName()+ " enters classroom");
            student.setOccupied();
            return true;
        }
        return false ;
    }

@Override
    public void exit(Student student)
    {
        students.removeIf(student::equals);
        System.out.println(student.getName() + " starts exiting!");
        System.out.println(student.getName() + " exits classroom");
        student.setNotOccupied();
    }

    public void operate(int N) {
        for (Student student : getStudents())
            student.attend(N);

        teacher.teach(N);
    }

    public int getClassNumber()  {
        return class_number;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
