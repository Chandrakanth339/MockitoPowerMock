package defaultpack;

public class SuperClass {

	private String string;

	private SuperClass2 superClass2;
	
	
	public void setString(String superClass) {
		this.string = superClass;
	}

	public String getString() {
		return this.string;
	}

	public SuperClass() {
		string = "SuperClass";
	}

	public String getMethod() {
		return string;
	}

}
