<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="loi.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="spc.Giohang" %>
<%@ page import="spc.MonHang" %>
<%@ page import="db.SanPham" %>
<%@ page import="db.XulyDB" %>
<%@ page import="java.util.ArrayList" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <table border="1" width="70%">
        <tr>
            <th>MSSP</th>
            <th>Ten san Phẩm</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
        </tr>
        <% Giohang cart=(Giohang)session.getAttribute("gio"); if(cart !=null) { XulyDB db=new XulyDB();
            ArrayList<MonHang> ds = cart.getGH();
            for(MonHang mh : ds) {
            SanPham sp = db.getSanPham(mh.getMsMH());
            %>
            <tr>
                <td>
                    <%= mh.getMsMH() %>
                </td>
                <td>
                    <%= sp.getTenSP() %>
                </td>
                <td>
                    <%= mh.getSoluong() %>
                </td>
                <td>
                    <%= mh.getDongia() %>
                </td>
            </tr>
            <% } %>
    </table>
    <h2 align="right">Tổng tiền:<%= cart.Tongtien() %>
    </h2>
    <% } %>
</body>

</html>