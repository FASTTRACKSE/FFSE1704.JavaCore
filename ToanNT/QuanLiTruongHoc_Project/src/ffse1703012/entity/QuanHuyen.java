package ffse1703012.entity;


public class QuanHuyen {
	private String name, districId;
	
	public QuanHuyen() {
		//
	}
	
	public QuanHuyen(String name, String districtId) {
		this.name = name;
		this.districId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistricId() {
		return districId;
	}

	public void setDistricId(String districId) {
		this.districId = districId;
	}

	
	
	

	
	@Override
	public String toString() {
		return this.name;
	}
	
}
