package ffse1703012.entity;

import com.mysql.jdbc.PreparedStatement;

public class QuanHuyen {
	private String name, districId;
	private String selectDistrictId;
	private PreparedStatement ps;
	
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

	
	
	
//	public String selectDistrictId(String nameQuanHuyen) {
//		try {
//			
//			String sql = "select * from Quan_huyen where name = '"+nameQuanHuyen+"'";
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ResultSet result=ps.executeQuery();
//			while(result.next())
//			{
//				this.selectDistrictId = result.getString("districtid");
//				
//			}
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}	
//		
//		return selectDistrictId;
//	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
