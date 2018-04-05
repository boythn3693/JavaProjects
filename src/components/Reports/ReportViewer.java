/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.Reports;

import components.utils.HibernateUtil;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;

/**
 *
 * @author vankh
 */
public class ReportViewer extends JDialog {

    private String _folder = System.getProperty("user.dir") + "\\src\\components\\Reports\\";

    public ReportViewer(JFrame parent, String fileName, HashMap param) {
        super(parent, "Thống kê", true);

        // Create a variable for the connection string.  
        String connectionUrl = HibernateUtil.getUrl();
        // Declare the JDBC objects.  
        Connection con = null;

        try {
            // Establish the connection.  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            //JasperDesign design = JasperManager.loadXmlDesign(fileName);
            //JasperReport report = JasperCompileManager.compileReport(fileName);
            JasperPrint print = JasperFillManager.fillReport(_folder + fileName, param, con);

            JRViewer viewer = new JRViewer(print);

            Container c = getContentPane();
            c.add(viewer);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //setBounds(10, 10, 600, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
