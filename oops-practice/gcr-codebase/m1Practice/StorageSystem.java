package m1Practice;
import java.util.*;

class FileVersion {
	String version;
	int size;
	
	public FileVersion(String version, int size) {
		this.version = version;
		this.size = size;
	}

	public String getVersion() {
		return version;
	}

	public int getSize() {
		return size;
	}
}

public class StorageSystem {
	
	static Map<String, List<FileVersion>> records = new HashMap<>();
	
	public static void upload(String fileName, String version, int size) {
		records.putIfAbsent(fileName, new ArrayList<>());
		
		for(FileVersion f : records.get(fileName)) {
			if(f.version.equals(version)) {
				return;
			}
		}
		records.get(fileName).add(new FileVersion(version , size));
	}
	
	public static void fetch(String fileName) {
		if(!records.containsKey(fileName) || records.get(fileName).isEmpty()) {
			System.out.println("File Not Found");  
			return;
		}
		
		List<FileVersion> versions = new ArrayList<>(records.get(fileName));
		versions.sort((a,b) ->{
			if(a.size != b.size) return a.size - b.size;
			return a.version.compareTo(b.version);
		});
		
		for(FileVersion f : versions) {
			System.out.println(fileName + " " + f.version + " " + f.size);
		}	
	}
	
	public static void latest(String fileName) {
		if(!records.containsKey(fileName) || records.get(fileName).isEmpty()) {
			System.out.println("File Not Found"); 
			return;
		}
		List<FileVersion> versions = records.get(fileName);
		FileVersion f = versions.get(versions.size() - 1);
		System.out.println(fileName + " " + f.version + " " + f.size);
	}
	
	public static void totalStorage(String fileName) {
		if(!records.containsKey(fileName) || records.get(fileName).isEmpty()) {
			System.out.println("File Not Found"); 
			return;
		}
		int total = 0;
		List<FileVersion> versions = records.get(fileName);
		for(FileVersion f : versions) {
			total += f.size;
		}
		System.out.println(fileName + " " + total);
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			String input = sc.nextLine();
			String[] data = input.split(" ");
			String type = data[0].trim();
			String fileName = data[1].trim();
	
			switch(type) {
			case "UPLOAD" : 			
				String version = data[2].trim();
				int size = Integer.parseInt(data[3].trim());
				upload(fileName,version,size);
				break;
			case "FETCH" :
				fetch(fileName);
				break;
			case "LATEST" :
				latest(fileName);
				break;
			case "TOTAL_STORAGE" : 
				totalStorage(fileName);
				break;
			}
		}
		
		sc.close();
	}
}