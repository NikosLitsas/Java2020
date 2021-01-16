public class Human {

    protected String name;
    protected int floornum, classnum, Lall, tired;
    private boolean occupied;


    public Human(int floornum,int classnum,int Lall,String name,String type) {
        this.name = name;
        this.floornum = floornum;
        this.classnum = classnum;
        this.Lall = Lall;
        System.out.println("A new "+ type + " has been created");
        printInfo();
    }

    public Human() {

    }

    void print()
    {
        System.out.println(name+ "'s points of tiredness are " + tired);
    }

    public void printInfo()
    {
        System.out.println(name);
        System.out.println("Floor "+ floornum + " Class "+ classnum);
        System.out.println("Points of tiredness: " + tired);
        if(occupied)
            System.out.println("He is currently in the Classroom");
        else
            System.out.println("He is not in the Classroom");
    }


    public String getName() {
        return name;
    }

    public void setOccupied() {
        occupied = true;
    }
}
