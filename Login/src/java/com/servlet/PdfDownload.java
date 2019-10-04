/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import service.User;

/**
 *
 * @author isuru_s
 */
public class PdfDownload extends HttpServlet {
    private String DOWNLOAD_FILE_NAME = "postReport.pdf"; //file name of the downloadable file
    private String FILE_TYPE = "application/pdf"; //file type of the file(pdf)
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
           generatePdfReport(request,response); //generate and download 
        }catch(Exception e){
            System.out.println("Exception in PdfDownload => "+e);
        }
    }
    
    public void generatePdfReport(HttpServletRequest request,HttpServletResponse response){
    
    List<User> userData = new LinkedList<>();
    String reportPath;
    OutputStream outputStream = null;
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JRDataSource reportSource;
    Map reportParameters;
    welcome ur = new welcome();
    
    try {

      reportPath = request.getServletContext().getRealPath("/report") + "\\report1.jrxml";

      reportParameters = new HashMap();
      reportParameters.put("userName", "This is List of Users");

      jasperDesign = JRXmlLoader.load(reportPath);
      jasperReport = JasperCompileManager.compileReport(jasperDesign);
      userData = ur.getPdfdata();
      reportSource = new JRBeanCollectionDataSource(userData); //set the database values to the reportSource
      //byteStream
      byte[] byteStream;
       System.out.println(ur.getPdfdata());
      byteStream = JasperRunManager.runReportToPdf(jasperReport,reportParameters, reportSource);
         

      //response
      response.setHeader("Content-Disposition", "attachement; filename=" + DOWNLOAD_FILE_NAME);
      response.setContentType(FILE_TYPE);
      response.setContentLength(byteStream.length);
      //outputstream
      outputStream = response.getOutputStream();
     
      //byteStream = data, 0 = starting offset, byteStream.length = length
      outputStream.write(byteStream, 0, byteStream.length);

    } catch (JRException ex) {
      Logger.getLogger(PdfDownload.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception e) {
      e.printStackTrace();
    }finally{   
        try {
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(PdfDownload.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
  }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
