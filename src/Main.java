import static java.lang.System.exit;
import java.util.*;

public class Main {


    public static void main(String[] args){

        if(args.length<5)
        {
            System.out.println( "Not enough arguments" ) ;
            exit(-1) ;
        }

        int cclass = Integer.parseInt(args[0]);
        int lj = Integer.parseInt(args[1]);
        int ls = Integer.parseInt(args[2]);
        int lt = Integer.parseInt(args[3]);
        int n = Integer.parseInt(args[4]);

        School school = new School(cclass);

        Random rand = new Random();

        int numOfStudents = cclass*2;
        int numOfTeachers = 18 ;


        ArrayList<Student> students = new ArrayList<>();

        for(int i=0;i<numOfStudents/2;i++)
        {
            int int1 = rand.nextInt(3);
            int int2 = rand.nextInt(3);
            Student student = new StudentSenior(int1+1,int2+4,ls,generateName());
            students.add(student);
        }

        for(int i=0;i<numOfStudents/2;i++)
        {
            int int1 = rand.nextInt(3);
            int int2 = rand.nextInt(3);
            Student student = new StudentJunior(int1+1,int2+1,lj,generateName());
            students.add(student);
        }

        ArrayList<Teacher> teachers = new ArrayList<>();

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<6;j++)
            {
                Teacher teacher = new Teacher(i+1,j+1,lt,generateName()) ;
                school.getFloor(i).getClasses(j+1).setTeacher(teacher);
                teachers.add(teacher);
            }
        }

        while(!students.isEmpty())  //check for students that cant enter
        {
            int m = new Random().nextInt(students.size());
            Student stud = students.get(m);
            school.enter(stud);
            students.remove(m);
        }

        while(!school.getYard().getStudents().isEmpty())
        {
            int m = new Random().nextInt(school.getYard().getStudents().size());
            Student stud = school.getYard().getStudents().get(m);
            school.getYard().exit(stud);
            school.getStairs().enter(stud);
        }

        for(int j = 0; j < 3; j++) {
            //while(school.getStairs().getStudents().isEmpty())
            for (Student student : school.getStairs().getStudents()) {
                if (student.getNumOfFloor() == j + 1) {
                    school.getStairs().exit(student);
                    school.getFloor(j).enter(student);
                }
            }

            for (int k = 0; k < 6; k++) {
                for (Student student : school.getFloor(j).getStudents()) {
                    if (student.getNumOfClass() == k + 1) {
                        if (school.getFloor(j).getClasses(k + 1).enter(student))
                            school.getFloor(j).getCorridor().exit(student);
                        else
                            break;
                    }
                }
            }
        }

        for(int i = 0 ;i<numOfTeachers;i++)
        {
            teachers.forEach(Human::setOccupied);
        }

        school.operate(n) ;
        school.print() ;
    }


    static String generateName()
        {
            String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder s = new StringBuilder(10);
            int y;
            for ( y = 0; y < 10; y++) {
                int index = (int)(AlphaString.length() * Math.random());
                s.append(AlphaString.charAt(index));
            }
            return s.toString();
        }
}
