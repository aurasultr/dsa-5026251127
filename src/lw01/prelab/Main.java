package lw01.prelab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main (String[] args){
        try (Scanner scanner = new Scanner(Main.class.getResourceAsStream("jobs.txt"))) {
            List<PrintJob> JobList = new ArrayList<>();
            
            while(scanner.hasNext()){
                String type = scanner.next();
                String id = scanner.next();
                int pages = scanner.nextInt();
                
                PrintJob job;
                
                if(type.equals("MONO")){
                    job = new MonoPrint(id,pages);
                }else{
                    job = new ColourPrint(id,pages);
                }
                JobList.add(job);
            }
            for(PrintJob job : JobList){
                System.out.println(job.summary());
            }
        }



    }
}