import java.util.ArrayList;
public class Registrar{
	static float minGPA = 3.0f;
	static int minCredits = 10;
	private static ArrayList<Course> courses = new ArrayList<Course>(0);
	private static ArrayList<Float> minGrades = new ArrayList<Float>(0);

	public static void setMinimumGrade(Course course, float grade){
		courses.add(course);
		minGrades.add(grade);
	}
	
	public static float getMinimumGrade(Course course) throws Exception{
		if(courses.indexOf(course) != -1){
			return minGrades.get(courses.indexOf(course));
		}
		else{
			throw new UniversityException(course.getCode() + " was not found in the registry");
		}
	}
	public static void class2020(Student[] s) throws Exception{
		for(int i = 0; i<s.length;i++){
			try{
				System.out.println("Congrats to "+s[i].getName()+" for graduating with GPA "+Float.toString(s[i].graduation()));
			}
			catch(Exception e){
				if(e instanceof UniversityException){
					System.err.println("Sorry,"+e.getMessage());
				}
				else{
					System.out.println(e.getMessage());
				}
			}
		}
	}
}