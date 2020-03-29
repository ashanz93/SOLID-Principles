package Documents;

public interface ExportableDocument {
    byte[] toPdf();
    String toJson();
    String toTxt();
}
