package annotations;

import java.lang.reflect.Method;

public class UseTodoAnnotation {
	
	@Todo(task = "Push Code on github", assignedTo = "developer", priority = "HIGH")
	public void task1() {
		System.out.println("Task 1 .");
	}
	
	@Todo(task = "Solve Leetcode", assignedTo = "developer")
	public void task2() {
		System.out.println("Task 2 .");
	}
	
	@Todo(task = "Go through material", assignedTo = "user", priority = "LOW")
	public void task3() {
		System.out.println("Task 3 .");
	}
	
	public static void main(String[] args)throws Exception {
		Method[] methods = UseTodoAnnotation.class.getDeclaredMethods();
		
		for(Method m : methods) {
			if(m.isAnnotationPresent(Todo.class)) {
				Todo todo = m.getAnnotation(Todo.class);
				System.out.println("Method name: " + m.getName()+ " , " + "Task: " + todo.task() + " ,"
						+ "Assigned to: " + todo.assignedTo() + "Priority: " + todo.priority());
			}
		}
	}

}
