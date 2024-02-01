<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="loi.jsp" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.XulyDB" %>
<%@ page import="spc.Giohang" %>
<%@ page import="spc.MonHang" %>
<%@ page import="db.SanPham" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mua hàng qua mạng</title>
</head>

<body>
    <form action="xuly.jsp" method="post">
        Chọn sản phẩm:
        <select name="ms">
            <% XulyDB db=new XulyDB(); ResultSet rs=db.getAllProducts(); while(rs.next()) { %>
                <option label='<%=rs.getString("tensp") %>' value='<%=rs.getString("mssp") %>'>
                    <% } %>
        </select>
        Số lượng:<input type="text" name="sl" />
        <input type="submit" value="Mua Hàng" name="mua" />
        <input type="submit" value="In Hóa đơn" name="in" />
        <hr />
        <h1>CHI TIẾT GIỎ HÀNG</h1>
        <table border="1" width="70%">
            <tr>
                <th>MSSP</th>
                <th>Ten san Phẩm</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>
            </tr>
            <% Giohang cart=(Giohang)session.getAttribute("gio"); if(cart !=null) { ArrayList<MonHang> ds =
                cart.getGH();
                for(MonHang mh:ds) {
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
    </form>
</body>

</html>