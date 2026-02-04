package functionalInterface;

interface ReportExporter {
    void exportToCSV();
    void exportToPDF();
    
    default void exportToJSON() {
        System.out.println("Exporting report to JSON.");
    }
}

class CSVExporter implements ReportExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Exporting report to CSV");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Exporting report to PDF");
    }
}

class PDFExporter implements ReportExporter {

    @Override
    public void exportToCSV() {
        System.out.println("Exporting report to CSV");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Exporting report to PDF");
    }

    @Override
    public void exportToJSON() {
        System.out.println("PDFExporter custom JSON export logic");
    }
}

public class DataExportFeature {

	public static void main(String[] args) {
		 ReportExporter csv = new CSVExporter();
	     ReportExporter pdf = new PDFExporter();
	     csv.exportToCSV();
	     csv.exportToPDF();
	     csv.exportToJSON();  
	     pdf.exportToCSV();
	     pdf.exportToPDF();
	     pdf.exportToJSON(); 
	}
}