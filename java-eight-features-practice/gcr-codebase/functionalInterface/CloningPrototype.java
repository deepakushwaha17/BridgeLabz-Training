package functionalInterface;

class Employee implements Cloneable {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}

public class CloningPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee emp1 = new Employee("Deepa", 101);

        // Clone object
        Employee emp2 = (Employee) emp1.clone();

        System.out.println("Original: " + emp1);
        System.out.println("Clone: " + emp2);
    }
}

