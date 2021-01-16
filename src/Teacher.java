public class Teacher extends Human{


    public Teacher(int floornum,int classnum,int l,String name) {
        super(floornum, classnum, l, name,"Teacher");
    }

    public void teach(int num) {
        tired = num * Lall;
    }
}
