package deniz.document.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created by deniz on 1/11/17.
 */
public class CSVDocument {

    private ArrayList<String> headers;
    public static String DEFAULT_DELIM = ",";
    private File csvFile;
    private File tmpFile;

    public CSVDocument(){

    }
    public CSVDocument(File csvFile){
        this.csvFile = csvFile;
        tmpFile = new File(csvFile.getAbsolutePath().replace(csvFile.getName(), "."+csvFile.getName()));

        try{
            headers = new ArrayList<>(Arrays.asList(Files.lines(csvFile.toPath()).findFirst().get().split(DEFAULT_DELIM)));
        }catch(IOException ioe){

        }

    }


    public CSVDocument(String filePath){
        this.csvFile = new File(filePath);
        tmpFile = new File(csvFile.getAbsolutePath().replace(csvFile.getName(), "."+csvFile.getName()));
        try{
            headers = new ArrayList<>(Arrays.asList(Files.lines(csvFile.toPath()).findFirst().get().split(DEFAULT_DELIM)));
        }catch(IOException ioe){

        }

    }

    public void setHeaders(ArrayList<String> headers){
        this.headers = headers;
    }

    public List<String> getHeaders(){
        return headers;
    }

    public String getHeadersAsString(){
        StringJoiner sj = new StringJoiner(",");
        headers.forEach(sj::add);
        return sj.toString();
    }

    public String getHeaderAt(int headerIndex){
        if(headerIndex >= headers.size()){
            return null;
        }
        return headers.get(headerIndex);
    }

    public boolean headerContains(String header){
        return headers.contains(header);
    }

    public boolean replaceHeaderEntry(String oldVal, String newVal){
        if(headers.contains(oldVal)){
            return false;
        }
        headers.set(headers.indexOf(oldVal), newVal);
        return headers.contains(newVal);
    }

    public void setCsvFile(File csvFile){
        this.csvFile = csvFile;
    }

    public File getCsvFile(){
        return csvFile;
    }

    public List<String> getPreview() throws IOException{
        return Files.lines(csvFile.toPath()).limit(10).collect(Collectors.toList());
    }


    public void addHeader(String header, String newField) throws IOException{
        headers.add(header);
        appendNewField(newField);
    }

    private void appendNewField(String newField) throws IOException{
        BufferedWriter bufferedFileWriter = Files.newBufferedWriter(tmpFile.toPath(), StandardOpenOption.CREATE);
        bufferedFileWriter.write(getHeadersAsString()+"\n");
        Files.lines(csvFile.toPath()).skip(1).forEach(oldLine -> {
            try {
                bufferedFileWriter.write(oldLine + DEFAULT_DELIM + newField+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedFileWriter.flush();
    }

    public void saveTmpFile() throws IOException{
        Files.copy(tmpFile.toPath(), csvFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        Files.delete(tmpFile.toPath());
    }

}
