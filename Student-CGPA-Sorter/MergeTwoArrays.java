public class MergeTwoArrays{

	public static Student[] mergeArrays(Student[] array1, Student[] array2){
		Student[] mArray = new Student[array1.length+array2.length];
		int i = 0; 
		int j = 0;
		int k = 0;

		while(i < array1.length && j < array2.length){
			if(array1[i].getCgpa()>=array2[j].getCgpa())
				mArray[k++] = array1[i++];
			else
				mArray[k++] = array2[j++];
		}
		while(i < array1.length){
			mArray[k++] = array1[i++];
		}
		while(j < array2.length){
			mArray[k++] = array2[j++];
		}
		return mArray;

	}

	
	public static void main(String args[]){
		
		Student s1 = new Student("John3", "Doe3", 23, "jdoe3@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030",
			"Computer Science", (float)(18), (float)(102), (float)(3.88), 2017, 2021);
		Student s2 = new Student("John4", "Doe4", 23, "jdoe4@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030",
			"Computer Science", (float)(18), (float)(102), (float)(3.86), 2017, 2021);		
		Student s3 = new Student("John5", "Doe5", 23, "jdoe5@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030",
			"Computer Science", (float)(18), (float)(102), (float)(3.97), 2017, 2021);

		
		Undergraduate u1 = new Undergraduate("John6", "Doe6", 23, "jdoe6@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030",
			"Computer Science", (float)(18), (float)(102), (float)(3.85), 2017, 2021, 4);
		Undergraduate u2 = new Undergraduate("John7", "Doe7", 23, "jdoe7@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030",
			"Computer Science", (float)(18), (float)(102), (float)(3.87), 2017, 2021, 4);
		Undergraduate u3 = new Undergraduate("John8", "Doe8", 23, "jdoe8@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030",
			"Computer Science", (float)(18), (float)(102), (float)(3.76), 2017, 2021, 4);

		
		Graduate g1 = new Graduate("John9", "Doe9", 23, "jdoe9@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030",
			"Computer Science", (float)(18), (float)(102), (float)(3.83), 2017, 2021, "Machine Learning", "Mr. X");
		Graduate g2 = new Graduate("John10", "Doe10", 23, "jdoe10@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030",
			"Computer Science", (float)(18), (float)(102), (float)(3.74), 2017, 2021, "Machine Learning", "Mr. X");
		Graduate g3 = new Graduate("John11", "Doe11", 23, "jdoe11@gmu.edu", "703-416-2478", "George Mason University, Fairfax, VA-22030",
			"Computer Science", (float)(18), (float)(102), (float)(3.72), 2017, 2021, "Machine Learning", "Mr. X");

		
		Student[] array1 = {s1, s2, u1, g1};
		Student[] array2 = {s3, u2, u3, g2, g3};
		
		System.out.println("\n------------------ Printing Array1 (sorted in descending order of CGPA) ---------------------");
		for (Student p: array1){
			System.out.println(p);
		}

		System.out.println("\n------------------ Printing Array2 (sorted in descending order of CGPA) ---------------------");
		for (Student p: array2){
			System.out.println(p);
		}

		Student[] mArray = mergeArrays(array1, array2); // you need to implement the called method.
		System.out.println("\n------------------ Printing Merged Array (sorted in descending order of CGPA) ---------------------");
		for (Student p: mArray){
			System.out.println(p);
		}

	}

}