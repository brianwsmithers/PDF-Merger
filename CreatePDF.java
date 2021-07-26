/*
This class creates the merged PDF file.
 */

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatePDF {

    // All file will go to this ArrayList to be added to the mergeDocuments method.
    List<File> fileList = new ArrayList<>();

    PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();

    public void createPDF(String destinationFolder,
                          String newFileName,
                          String FILE_ONE_PATH,
                          String FILE_TWO_PATH,
                          String FILE_THREE_PATH,
                          String FILE_FOUR_PATH,
                          String FILE_FIVE_PATH,
                          String FILE_SIX_PATH,
                          String FILE_SEVEN_PATH,
                          String FILE_EIGHT_PATH,
                          String FILE_NINE_PATH,
                          String FILE_TEN_PATH) {

        // Create pdfMergerUtility obj
        // Obj then sets destination for merged file, name of file and extension.
        pdfMergerUtility.setDestinationFileName(destinationFolder + newFileName + ".pdf");

        // Create ten File Obj and set the paths to the constant variables
        try {
            addFileList(FILE_ONE_PATH);
            addFileList(FILE_TWO_PATH);
            addFileList(FILE_THREE_PATH);
            addFileList(FILE_FOUR_PATH);
            addFileList(FILE_FIVE_PATH);
            addFileList(FILE_SIX_PATH);
            addFileList(FILE_SEVEN_PATH);
            addFileList(FILE_EIGHT_PATH);
            addFileList(FILE_NINE_PATH);
            addFileList(FILE_TEN_PATH);
            mergeFiles();
            pdfMergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // If path is null, do not add to list.
    public void addFileList(String path) {
        if (path != null) {
            fileList.add(new File(path));
        }
    }
    // This method will merge the files in the fieList ArrayList.
    public void mergeFiles() throws FileNotFoundException {
        for (File file : fileList) {
            pdfMergerUtility.addSource(file);
        }
    }
}
