package spc;

import java.util.ArrayList;

public class Giohang {

    private ArrayList<MonHang> cart;

    public Giohang() {
        cart = new ArrayList<MonHang>();
    }

    public void ThemHang(MonHang mh) {
        // Nếu món hàng đã có trong giỏ
        // thì cập nhập lại số lượng
        if (cart.contains(mh)) {
            MonHang hang = cart.get(cart.indexOf(mh));
            hang.setSoluong(hang.getSoluong() + mh.getSoluong());
        } else {// còn không thì thêm mới
            cart.add(mh);
        }
    }

    public double Tongtien() {
        double tien = 0;
        for (MonHang mh : cart) {
            tien += mh.getDongia() * mh.getSoluong();
        }
        return tien;
    }

    public ArrayList<MonHang> getGH() {
        return cart;
    }
}
