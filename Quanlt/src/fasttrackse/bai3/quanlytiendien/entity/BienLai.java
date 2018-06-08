package fasttrackse.bai3.quanlytiendien.entity;

public class BienLai  extends KhachHang {

	int mact;
    int chisocu;
    int chisomoi;

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }
    String thoigian;
    public BienLai(int makh, String tenkh, String diachikh,int mact,int chisomoi, int chisocu,String thoigian) {
        super(makh, tenkh, diachikh);
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
        this.mact=mact;
        this.thoigian=thoigian;
    }

    public int getMact() {
        return mact;
    }

    public void setMact(int mact) {
        this.mact = mact;
    }

    public int getChisocu() {
        return chisocu;
    }

    public void setChisocu(int chisocu) {
        this.chisocu = chisocu;
    }

    public int getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(int chisomoi) {
        this.chisomoi = chisomoi;
    }
    public int thanhtoan(){
    return (chisocu - chisomoi)*3000;
    }
    public String mact(){
    return this.mact+"   "+this.chisocu+"   "+this.chisomoi+"   "+this.thoigian;
    }
}
