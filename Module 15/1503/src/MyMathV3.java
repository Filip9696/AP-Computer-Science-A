/** 
 * Homework class using abstraction
 * 
 * @author Filip Kin
 * @version 2020-04-21
 */

public class MyMathV3 extends HomeworkV3 {
	public MyMathV3() {
		super();
	}
	
	public void createAssignment(int p) {
		setPagesRead(p);
		setType("Math");
	}
    
	public void doAssignment(int p) {
		setPagesRead(getPagesToRead()-p);
	}
}