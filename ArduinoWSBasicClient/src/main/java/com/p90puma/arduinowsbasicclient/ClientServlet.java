package com.p90puma.arduinowsbasicclient;

import com.p90puma.arduinows.ArduinoWS;
import com.p90puma.arduinows.ArduinoWSService;
import java.io.*;
import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author p90puma
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8084/ArduinoWS/ArduinoWSService?wsdl")
    public ArduinoWSService service;
    @Resource
    protected WebServiceContext context;


    void main(){

    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<h2>Servlet ClientServlet at " + request.getContextPath() + "</h2>");

            ArduinoWS port = service.getArduinoWSPort();

            String i = request.getParameter("arduino_msg");

            String result = null;

            result = port.sendSerialInput(i);

            out.println("<br/>");
            out.println("Result:");
            out.println(result);
            ((Closeable) port).close();

        } catch (Exception e) {
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
