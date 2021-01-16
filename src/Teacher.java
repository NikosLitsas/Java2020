public class Teacher extends Human{


    public Teacher(int floornum,int classnum,int l,String name) {
        super(floornum, classnum, l, name,"Teacher");
    }

    public void teacher_out(Teacher teacher)
    {
        teacher.setNotOccupied();
        System.out.println("Teacher is out!");
        teacher.printInfo();
    }

    public void teach(int num) {
        tired = num * Lall;
    }
}
