package inheritance;

public class EducationalCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaidOnlineCourse poCourse = new PaidOnlineCourse("JAVA Programming" ,4 , "BridgeLabz" , false , 155000.0,2.0);
		poCourse.getPaidOnlineCourseDetails();

	}

}

//Base class
class Course{
	String courseName;
	int duration;
	
	Course(String courseName, int duration){
		this.courseName = courseName;
		this.duration = duration;
	}
	
	void displayCourseDetails() {
		System.out.println("Course Name : "+courseName);
		System.out.println("Course Duration : "+duration + " months");
	}
}

//Subclass of Course class
class OnlineCourse extends Course{
	String platform;
	boolean isRecorded;
	
	OnlineCourse(String courseName, int duration,String platform ,boolean isRecorded){
		super(courseName,duration);
		this.platform = platform;
		this.isRecorded = isRecorded;
	}
	
	void getOnlineCourseDetails() {
		System.out.println("Online Course Platform : "+platform);
		String checkIsRecorded = isRecorded ? "YES" : "NO";
		System.out.println("Is Recorded ? : "+checkIsRecorded);
	}
}

//Subclass of OnlineCourse class
class PaidOnlineCourse extends OnlineCourse{
	double fees;
	double discount;
	
	PaidOnlineCourse(String courseName, int duration,String platform ,boolean isRecorded,double fees ,double discount){
		super(courseName,duration,platform,isRecorded);
		this.fees = fees;
		this.discount = discount;
	}
	
	double calculateDiscount() {
		double discountedFees = fees - (fees * discount / 100);
		return discountedFees;
	}
	
	void getPaidOnlineCourseDetails() {
		displayCourseDetails();
		getOnlineCourseDetails();
		System.out.println("Online Course Fees : $"+fees);
		System.out.println("Discount : "+discount + "%");
		System.out.println("Discounted Course Fees : $"+calculateDiscount());
	}
}