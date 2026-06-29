// WordDocument.java
public class WordDocument implements Document {
    public void open()  { System.out.println("Opening Word Document..."); }
    public void save()  { System.out.println("Saving Word Document..."); }
}

// PdfDocument.java
class PdfDocument implements Document {
    public void open()  { System.out.println("Opening PDF Document..."); }
    public void save()  { System.out.println("Saving PDF Document..."); }
}

// ExcelDocument.java
class ExcelDocument implements Document {
    public void open()  { System.out.println("Opening Excel Document..."); }
    public void save()  { System.out.println("Saving Excel Document..."); }
}
