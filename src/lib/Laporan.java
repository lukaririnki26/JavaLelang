package lib;

import java.io.File;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author fahmi
 */
public class Laporan {
    Connection connection = new DBHelper().init();
    public Laporan(String data){
        try {
            File  filereport = new File("src/report/"+data);
            JasperReport jreport =(JasperReport) JRLoader.loadObject(filereport.getPath());
            JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jreport, null,connection);
            JasperViewer.viewReport(jprint);
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
}
