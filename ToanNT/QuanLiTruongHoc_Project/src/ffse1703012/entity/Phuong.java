package ffse1703012.entity;

public class Phuong {
	private String name;

	public Phuong() {
		//
	}

	public Phuong(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
