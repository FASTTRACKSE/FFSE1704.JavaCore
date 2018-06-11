package fasttrackse.bai3.quanlytiendien.entity;

public class KhachHang {
	private int makh;
    private String tenkh;
    private String diachikh;
    public KhachHang(int makh, String tenkh, String diachikh){
        this.diachikh=diachikh;
        this.makh=makh;
        this.tenkh= tenkh;
    }
    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachikh() {
        return diachikh;
    }

    public void setDiachikh(String diachikh) {
        this.diachikh = diachikh;
    }
    public String toString(){
        return " " +this.makh +"\t"+this.tenkh+"\t"+this.diachikh;
    }

}
