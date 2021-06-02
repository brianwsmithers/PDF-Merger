/**
 *
 * This program can merge pdfs together. As of 6/2/21 it is set up to merge only two files. More can be added
 * by adding additional file paths...
 */

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.io.File;
import java.io.IOException;

public class Main {

    // Send merged file here...
    static String destination =
            "C:\\Users\\smithersb\\Downloads\\";
    // Merged files new name...
    static String NEW_FILE_NAME =
            "ISO 14001.2015 MGMT Review Meeting Minutes and Attendance - May 2021";
    // Path of file one...
    static String FILE_ONE_PATH =
            "C:\\Users\\smithersb\\Downloads\\Mgmt Review 5-13-21 - Attendance.pdf";
    // Path of file two...
    static String FILE_TWO_PATH =
            "C:\\Users\\smithersb\\Downloads\\KMA & KIE ISO 140012015 Management Review Meeting Minutes - May 2021.pdf";

    public static void main(String[] args) {
        // Create pdfMergerUtility obj
        // Obj then sets destination for merged file, name of file and extension.
        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
        pdfMergerUtility.setDestinationFileName(destination + NEW_FILE_NAME + ".pdf");

        // Create two File Obj and set the paths to the constant variables
        File FILE_ONE = new File(FILE_ONE_PATH);
        File FILE_TWO = new File(FILE_TWO_PATH);
        try {
            // Add both files to pdfMergerUtility obj
            // Merge both files
            pdfMergerUtility.addSource(FILE_TWO);
            pdfMergerUtility.addSource(FILE_ONE);
            pdfMergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (IOException e) {
            e.printStackTrace();
        }
       System.out.println("Files successfully merged...");
    }
}
