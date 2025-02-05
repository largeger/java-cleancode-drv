abstract class DocumentGenerator {

    // this is our template method 👇
    public void generateDocument() {
        collectData();
        formatContent();
        saveDocument();
    }

    protected abstract void collectData();
    protected abstract void formatContent();
    protected abstract void saveDocument();
}

class PDFDocument extends DocumentGenerator {
    @Override
    protected void collectData() {
        System.out.println("Collecting data for PDF document");
    }

    @Override
    protected void formatContent() {
        System.out.println("Formatting content for PDF document");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving PDF document");
    }
}

class WordDocument extends DocumentGenerator {
    @Override
    protected void collectData() {   
        System.out.println("Collecting data for Word document");
    }

    @Override
    protected void formatContent() {
        System.out.println("Formatting content for Word document");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving Word document");
    }
}



public class TemplateMethodDemo {
    public static void main(String[] args) {
        System.out.println("Creating PDF document");
        DocumentGenerator pdfDocument = new PDFDocument();
        pdfDocument.generateDocument();

        System.out.println("Creating Word document");
        DocumentGenerator wordDocument = new WordDocument();
        wordDocument.generateDocument();
    } 
}
