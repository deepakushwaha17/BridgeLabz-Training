package scenario;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class EduResults {

    // Merge Sort function
    public static Student[] mergeSort(Student[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;

        Student[] left = new Student[mid];
        Student[] right = new Student[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    // Merge two sorted arrays
    public static Student[] merge(Student[] left, Student[] right) {
        Student[] result = new Student[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].marks <= right[j].marks) { // stable sorting
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("Deepa", 85),new Student("Mahi", 90),
            new Student("Neha", 80),new Student("Sahil", 90),
            new Student("Aman", 89),new Student("Abhay", 75)
        };

        Student[] sorted = mergeSort(students);

        System.out.println("Final Rank List:");
        for (Student s : sorted) {
            System.out.println(s.name + " - " + s.marks);
        }
    }
}