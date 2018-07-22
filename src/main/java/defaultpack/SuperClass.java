package defaultpack;

public class SuperClass {

	private String string;

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
