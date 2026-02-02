package annotations;
import java.lang.reflect.Method;

public class TaskManager {
	
	@TaskInfo(priority = "high", assignedTo = "developer")
	public void task() {
		System.out.println("Custom Annotation");
	}
	
	public static void main(String[] args)throws Exception {
		Method m = TaskManager.class.getMethod("task");
		TaskInfo info = m.getAnnotation(TaskInfo.class);
		System.out.println(info.priority() + " : " + info.assignedTo());
	}
}