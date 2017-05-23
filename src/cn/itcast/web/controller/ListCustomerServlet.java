package cn.itcast.web.controller;

import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCustomerServlet", urlPatterns = "/servlet/ListCustomerServlet")
public class ListCustomerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BusinessService service = new BusinessServiceImpl();
            List list = service.getAllCustomer();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/jsp/listcustomer.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "查看客户失败");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
