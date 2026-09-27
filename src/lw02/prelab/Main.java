package lw02.prelab;

import java.util.* ;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

       LinkedList <String[]> transactions = new LinkedList<>();
       LinkedList <String[]> customers = new LinkedList<>();

       Queue <String[]> process = new LinkedList<>();
       Stack <String[]> failed = new Stack<>();

       while (sc.hasNext()) {
            String[] transaction = new String[3];
            transaction[0] = sc.next(); //name
            transaction[1] = sc.next(); //type
            transaction[2] = sc.next(); //amount
            transactions.add(transaction); //add array ke linkedlist
        }

        process.addAll(transactions); //add linkedlist ke queue
        
        while(!process.isEmpty()){ //selama queue masih ada akan masih nge loop tp kl udh kosong maka loop berhenti
            String[] transaction = process.poll(); //buat ambil data dari queue
            String name = transaction[0]; //name itu single string, jadi ambil dari array transaction index 0
            String type = transaction[1]; 
            int amount = Integer.parseInt(transaction[2]); // Convert amount to integer

            String[] customer = null; //kita anggap gaada dulu customernya 
            
            for (String[] data : customers){
                if (data[0].equals (name)){
                    customer = data;
                    break;
                }
            }

            if(customer == null){ //jika gaada customer maka buat baru
                customer = new String[2];
                customer[0] = name;
                customer[1] = "0"; // untuk balance awal
                customers.add(customer);
            }
            int balance = Integer.parseInt(customer[1]); //ambil balance dari customer
            if (type.equals ("DEPOSIT")){
                balance += amount;
                customer[1] = String.valueOf(balance); //ubah apapun balance ke string
            }else{
                if (balance < amount){
                    failed.push(transaction); //jika balance kurang maka push ke stack
                }else{
                    balance -= amount;
                    customer[1] = String.valueOf(balance); //balance integer diubah ke string
                }
            }
        }
        System.out.println("=== Final Balances ===");
        for (String[] customer : customers){
        System.out.println(customer[0] + ": " + customer[1]);
    }
        System.out.println("=== Failed Transactions ===");
        while (!failed.isEmpty()) {
            String[] transaction = failed.pop();
            System.out.println(transaction[0] + ": " + transaction[1] + " " + transaction[2]);
    }
    }
}