import java.util.ArrayList;
public class Student{
	private String name;
	private String year;
	private ArrayList<Course> gradebook;
	private ArrayList<Float> grades;

	public Student(String name, String year){
		setName(name);
		setYear(year);
		gradebook = new ArrayList<Course>(0);
		grades = new ArrayList<Float>(0);
	}
	public Student(String name){
		setName(name);
		setYear("freshman");
		gradebook = new ArrayList<Course>();
		grades = new ArrayList<Float>();
	}
	public boolean addCourse(Course course, float grade) throws Exception{
		if(gradebook.contains(course)){
			throw new StudentException(this.name+" has already taken "+course.getCode());
		}
		else if(Registrar.getMinimumGrade(course) > grade){
			throw new UniversityException(course.getCode() + " requires a grade greater than or equal to "+Float.toString(Registrar.getMinimumGrade(course)));
		}
		else{
			gradebook.add(course);
			grades.add(grade);
			return true;
		}
	}
	public float graduation() throws Exception{
		if(gradebook.size() == 0){
			throw new StudentException(this.name+" hasn't taken any courses yet");
		}
		float totalGPA = 0;
		for(int i = 0; i<grades.size();i++){
			totalGPA += grades.get(i);
		}
		float avGPA = totalGPA/grades.size();
		if(avGPA<Registrar.minGPA){
			throw new UniversityException(this.name + "\'s GPA is lower than the minimum required");
		}
		int credits = 0;
		for(int i = 0; i<gradebook.size();i++){
			credits += gradebook.get(i).getCredits();
		}
		if(credits<Registrar.minCredits){
			throw new UniversityException(this.name + " doesn't have enough credits to graduate");
		}
		return avGPA;
	}
	public String getYear() {
	    return year;
	}
	 
	public void setYear(String year) {

		if(year != null && (year=="freshman" || year=="sophomore" || year=="junior" || year=="senior") && year.length()>0){
			this.year = year;
		}
		else{
			throw new StudentException("Student must be one of freshman|sophomore|junior|senior");
		}
	}
	 
	public String getName() {
	    return name;
	}
	 
	public void setName(String name) {
		if(name != null && name.length()>0){
			this.name = name;
		}
		else{
			throw new StudentException("Student name is invalid");
		}

	}
}