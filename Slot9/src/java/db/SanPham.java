package db;

public class SanPham {
    private String msSP;
    private String tenSP;
    private double dongia;

    public SanPham() {
        super();
    }

    public SanPham(String msSP, String tenSP, double dongia) {
        super();
        this.msSP = msSP;
        this.tenSP = tenSP;
        this.dongia = dongia;
    }

    public String getMsSP() {
        return msSP;
    }

    public void setMsSP(String msSP) {
        this.msSP = msSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((msSP == null) ? 0 : msSP.hashCode());
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
        SanPham other = (SanPham) obj;
        if (msSP == null) {
            if (other.msSP != null)
                return false;
        } else if (!msSP.equals(other.msSP))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return tenSP;
    }
}
