/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etz.csv;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//import com.baeldung.libraries.opencsv.helpers.Helpers;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Olugbenga.Falodun
 */
public class CsvReaderExamples {

    public static void main(String[] args) throws Exception {
        CsvReaderExamples csvReader = new CsvReaderExamples();
        System.out.println(csvReader.oneByOneExample());
    }

    public List<String[]> oneByOne(Reader reader) throws Exception {
        List<String[]> list = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader);
        String[] line;
        HashSet<String> set=new HashSet();
        while ((line = csvReader.readNext()) != null) {
            String name = line[0];
            set.add(name);
            list.add(line);
        }
        Iterator<String> i=set.iterator();  
           while(i.hasNext())  
           {  
           System.out.println(i.next());  
           }  
        reader.close();
        csvReader.close();
        return list;
    }

    public String oneByOneExample() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(
                ClassLoader.getSystemResource("csv/pp.csv").toURI()));
        return this.oneByOne(reader).toString();
    }
}
