package SmartLibraryManagementSystem;

public class Student implements User{
	
	private String name;
	public Student(String name) {
		this.name = name;
	}
	
	@Override
	public void showRole() {
		System.out.println(name + " is a Student.");
	}

	@Override
	public int getBorrowLimit() {
        return 7;   // limited days
    }
	
	@Override
	public void update(String message) {
		System.out.println(name + " notified: " + message);
	}
}
