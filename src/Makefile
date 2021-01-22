JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Main.java \
	Class.java \
	Corridor.java \
	Floor.java \
	Human.java \
	Place.java \
	School.java \
	Stairs.java \
	Student.java \
	StudentJunior.java \
	StudentSenior.java \
	Teacher.java \
	Yard.java \


default: classes

classes: $(CLASSES:.java=.class)

clean:
	rm *.class