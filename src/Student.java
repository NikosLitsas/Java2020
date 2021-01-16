public class Student extends Human{


    public Student(int floornum, int classnum, int Lall, String name, String type) {
        super(floornum, classnum, Lall, name, type);
    }

    public void attend(int num) {
        tired = num * Lall ;
    }

    public int getNumOfFloor()  {
        return floornum;
    }

    public int getNumOfClass()  {
        return classnum;
    }

}
