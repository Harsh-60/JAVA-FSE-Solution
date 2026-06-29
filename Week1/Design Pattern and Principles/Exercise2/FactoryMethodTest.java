// FactoryMethodTest.java
public class FactoryMethodTest {
    public static void main(String[] args) {

        DocumentFactory wordFactory  = new WordDocumentFactory();
        DocumentFactory pdfFactory   = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        System.out.println("-- Word --");
        Document word = wordFactory.createDocument();
        word.open(); word.save();

        System.out.println("-- PDF --");
        Document pdf = pdfFactory.createDocument();
        pdf.open(); pdf.save();

        System.out.println("-- Excel --");
        Document excel = excelFactory.createDocument();
        excel.open(); excel.save();
    }
}
