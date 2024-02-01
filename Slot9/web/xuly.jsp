<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="loi.jsp" %>
<%@ page import="spc.Giohang" %>
<%@ page import="db.XulyDB" %>
<%@ page import="db.SanPham" %>
<%@ page import="spc.MonHang" %>
<html>
<% Giohang cart=(Giohang)session.getAttribute("gio"); if(request.getParameter("mua") !=null) { String
    masp=request.getParameter("ms"); int soluong=Integer.parseInt(request.getParameter("sl")); if(cart==null) { cart=new
    Giohang(); } XulyDB db=new XulyDB(); SanPham sp=db.getSanPham(masp); MonHang mh=new MonHang(sp.getmasp(), soluong,
    sp.getDongia()); cart.ThemHang(mh); session.setAttribute("gio", cart); response.sendRedirect("shopping.jsp"); } else
    if(request.getParameter("in") !=null) { response.sendRedirect("hoadon.jsp"); } %>

</html>