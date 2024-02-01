package db;

public class SanPham {
    private String masp;
    private String tenSP;
    private double dongia;

    public SanPham() {
        super();
    }

    public SanPham(String masp, String tenSP, double dongia) {
        super();
        this.masp = masp;
        this.tenSP = tenSP;
        this.dongia = dongia;
    }

    public String getmasp() {
        return masp;
    }

    public void setmasp(String masp) {
        this.masp = masp;
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
        result = prime * result + ((masp == null) ? 0 : masp.hashCode());
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
        if (masp == null) {
            if (other.masp != null)
                return false;
        } else if (!masp.equals(other.masp))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return tenSP;
    }
}
