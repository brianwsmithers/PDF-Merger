import javax.swing.*;

public class PdfForm {

    CreatePDF createPDF = new CreatePDF();

    JFrame frame;
    private JPanel topPanel;
    private JPanel midPanel;
    private JTextField destinationFolderTextBox;
    private JLabel destinationFolderLabel;
    private JPanel destinationFolderPanel;
    private JPanel topFilePanel;
    private JTextField fileOneTextField;
    private JTextField fileTwoTextField;
    private JTextField fileThreeTextField;
    private JTextField fileFourTextField;
    private JTextField fileFiveTextField;
    private JTextField fileSixTextField;
    private JTextField fileSevenTextField;
    private JTextField fileEightTextField;
    private JTextField fileNineTextField;
    private JTextField fileTenTextField;
    private JPanel innerFilePanel;
    private JLabel fileOneLabel;
    private JLabel fileTwoLabel;
    private JLabel fileThreeLabel;
    private JLabel fileFourLabel;
    private JLabel fileFiveLabel;
    private JLabel fileSixLabel;
    private JLabel fileSevenLabel;
    private JLabel FileEightLabel;
    private JLabel fileNineLabel;
    private JLabel fileTenLabel;
    private JButton convertButton;
    private JLabel titleLabel;
    private JPanel buttonPane;
    private JTextField newFileNameTextField;
    private JLabel newFileNameLabel;

    // Sets PDF output location to current user's Download folder
    private String downloadDestination = System.getProperty("user.home") + "\\Downloads\\";

    private String newFileName = null;
    private String fileOne = null;
    private String fileTwo = null;
    private String fileThree = null;
    private String fileFour = null;
    private String fileFive = null;
    private String fileSix = null;
    private String fileSeven = null;
    private String fileEight = null;
    private String fileNine = null;
    private String fileTen = null;

    private String imagePath =
            "C:\\Users\\smithersb\\IdeaProjects\\PDF Merger\\icon\\pdf.png";

    // These lambdas get text from the JTextField boxes.
    public PdfForm() {
        destinationFolderTextBox.addCaretListener(e -> {
            downloadDestination = destinationFolderTextBox.getText();
        });
        newFileNameTextField.addCaretListener(e -> {
            newFileName = newFileNameTextField.getText();
        });
        fileOneTextField.addCaretListener(e -> {
            setFileOne(fileOneTextField.getText());
        });
        fileTwoTextField.addCaretListener(e -> {
            setFileTwo(fileTwoTextField.getText());
        });
        fileThreeTextField.addCaretListener(e -> {
            setFileThree(fileThreeTextField.getText());
        });
        fileFourTextField.addCaretListener(e -> {
            setFileFour(fileFourTextField.getText());
        });
        fileFiveTextField.addCaretListener(e -> {
            setFileFive(fileFiveTextField.getText());
        });
        fileSixTextField.addCaretListener(e -> {
            setFileSix(fileSixTextField.getText());
        });
        fileSevenTextField.addCaretListener(e -> {
            setFileSeven(fileSevenTextField.getText());
        });
        fileEightTextField.addCaretListener(e -> {
            setFileEight(fileEightTextField.getText());
        });
        fileNineTextField.addCaretListener(e -> {
            setFileNine(fileNineTextField.getText());
        });
        fileTenTextField.addCaretListener(e -> {
            setFileTen(fileTenTextField.getText());
        });
        // This lambda will start the merged PDF process.
        // The FileOne and FileTwo JTextFields cannot be null. All other files will be checked if null.
        convertButton.addActionListener(e -> {
            if (getDownloadDestination() != null && getNewFileName()
                    != null && getFileOne() != null && getFileTwo() != null) {
                createPDF.createPDF(
                        getDownloadDestination(),
                        getNewFileName(),
                        getFileOne(),
                        getFileTwo(),
                        getFileThree(),
                        getFileFour(),
                        getFileFive(),
                        getFileSix(),
                        getFileSeven(),
                        getFileEight(),
                        getFileNine(),
                        getFileTen());
            }
        });
    }

    public void launchGUI() {
        frame = new JFrame("PDF Merger");

        // "Icon made by Pixel perfect from www.flaticon.com"
        ImageIcon img = new ImageIcon(imagePath);
        frame.setIconImage(img.getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(topPanel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        destinationFolderTextBox.setText(downloadDestination); // default
        addPopUpMenu();
    }

    // Adds the right click undo, cut, paste, etc... to JTextField menus.
    public void addPopUpMenu() {
        JTextFieldRegularPopupMenu obj = new JTextFieldRegularPopupMenu();
        obj.addTo(destinationFolderTextBox);
        obj.addTo(newFileNameTextField);
        obj.addTo(fileOneTextField);
        obj.addTo(fileTwoTextField);
        obj.addTo(fileThreeTextField);
        obj.addTo(fileFourTextField);
        obj.addTo(fileFiveTextField);
        obj.addTo(fileSixTextField);
        obj.addTo(fileSevenTextField);
        obj.addTo(fileEightTextField);
        obj.addTo(fileNineTextField);
        obj.addTo(fileTenTextField);
    }

    public String getDownloadDestination() {
        return downloadDestination;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public String getFileOne() {
        return fileOne;
    }

    public String getFileTwo() {
        return fileTwo;
    }

    public String getFileThree() {
        return fileThree;
    }

    public String getFileFour() {
        return fileFour;
    }

    public String getFileFive() {
        return fileFive;
    }

    public String getFileSix() {
        return fileSix;
    }

    public String getFileSeven() {
        return fileSeven;
    }

    public String getFileEight() {
        return fileEight;
    }

    public String getFileNine() {
        return fileNine;
    }

    public String getFileTen() {
        return fileTen;
    }

    // This method checks the last four indices of a file to check if it is a pdf file.
    public boolean checkIfPDF(String file) {
        boolean isFile = false;
        if (!file.equals("")) {
            char[] charArray = file.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = charArray.length - 1; i >= 0; i--) {
                stringBuilder.append(charArray[i]);
                stringBuilder.reverse();
                if (stringBuilder.toString().equals(".pdf")) {
                    isFile = true;
                    break;
                }
                stringBuilder.reverse();
            }
        }
        return isFile;
    }

    // Sets file to file obj if it is a pdf file
    public void setFileOne(String fileOne) {
        if (checkIfPDF(fileOne)) {
            this.fileOne = fileOne;
        }
    }

    // Sets file to file obj if it is a pdf file
    public void setFileTwo(String fileTwo) {
        if (checkIfPDF(fileTwo)) {
            this.fileTwo = fileTwo;
        }
    }

    // Sets file to file obj if it is a pdf file
    public void setFileThree(String fileThree) {
        if (checkIfPDF(fileThree)) {
            this.fileThree = fileThree;
        }
    }

    // Sets file to file obj if it is a pdf file
    public void setFileFour(String fileFour) {
        if (checkIfPDF(fileFour)) {
            this.fileFour = fileFour;
        }
    }

    // Sets file to file obj if it is a pdf file
    public void setFileFive(String fileFive) {
        if (checkIfPDF(fileFive)) {
            this.fileFive = fileFive;
        }
    }

    // Sets file to file obj if it is a pdf file
    public void setFileSix(String fileSix) {
        if (checkIfPDF(fileSix)) {
            this.fileSix = fileSix;
        }
    }

    // Sets file to file obj if it is a pdf file
    public void setFileSeven(String fileSeven) {
        if (checkIfPDF(fileSeven)) {
            this.fileSeven = fileSeven;
        }
    }

    // Sets file to file obj if it is a pdf file
    public void setFileEight(String fileEight) {
        if (checkIfPDF(fileEight)) {
            this.fileEight = fileEight;
        }
    }

    // Sets file to file obj if it is a pdf file
    public void setFileNine(String fileNine) {
        if (checkIfPDF(fileNine)) {
            this.fileNine = fileNine;
        }
    }

    // Sets file to file obj if it is a pdf file
    public void setFileTen(String fileTen) {
        if (checkIfPDF(fileTen)) {
            this.fileTen = fileTen;
        }
    }
}
