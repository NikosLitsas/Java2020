public class Floor extends Place{

    private Corridor corridor;
    private Class[] classesSenior = new Class[3];
    private Class[] classesJunior = new Class[3];
    private int j ;

    public Floor(int cclass,int j){
        super("Floor");
        corridor = new Corridor();
        this.j = j+1;
        for(int i=0;i<3;i++)
        {
            classesSenior[i] = new Class(cclass,i+1) ;
            classesJunior[i] = new Class(cclass,i+4) ;
        }
    }

    @Override
    public void print()
    {
        System.out.println("Floor number: " + j + " contains");
        corridor.print();
        for(int i=0;i<3;i++)
        {
            classesSenior[i].print() ;
            classesJunior[i].print() ;
        }
    }

    public void operate(int N)
    {
        for(int i=0;i<3;i++)
        {
            classesSenior[i].operate(N);
            classesJunior[i].operate(N);
        }
    }

@Override
    public boolean enter(Student student)
    {
        System.out.println(student.getName() + " enters Floor");
        corridor.enter(student);
        return true;
    }

    public Class getClasses(int classnum)
    {
        for(int i=0;i<3;i++)
        {
            if(classnum == classesSenior[i].getClassNumber())
                return classesSenior[i];
            else if(classnum == classesJunior[i].getClassNumber())
                return classesJunior[i];
        }
        return null ;
    }

    public Corridor getCorridor() {
        return corridor;
    }
}
