package db;

public class MonHang {
    private String msMH;
    private int soluong;
    private double dongia;

    public double getDongia() {
        return dongia;
    }

    public void setDongia() {

    }

    public MonHang(String msMH, int soluong, double dongia) {
        super();
        this.msMH = msMH;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public String getMsMH() {
        return msMH;
    }

    public void setMsMH(String msMH) {
        this.msMH = msMH;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((msMH == null) ? 0 : msMH.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MonHang other = (MonHang) obj;
        if (msMH == null) {
            if (other.msMH != null)
                return false;
        } else if (!msMH.equalsIgnoreCase(other.msMH))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return msMH;
    }
}
