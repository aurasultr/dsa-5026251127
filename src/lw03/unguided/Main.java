package lw03.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //problem  1
        Scanner sc = new Scanner(Main.class.getResourceAsStream("registrations.txt"));

        Set<String> participants = new LinkedHashSet<>();
        while(sc.hasNext()){
            String studentId = sc.next();

            if(!participants.contains(studentId)){
                participants.add(studentId);
            }
        }

        //problem 2
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        Set<String> checkins = new HashSet<>();
        int rejected = 0;

        System.out.println("===== Event Check-In Results =====");

        while(sc2.hasNext()){
            String studentId = sc2.next();

             if (!participants.contains(studentId)) {
                System.out.println(studentId + ": Rejected (not registered)");
                rejected++;
            } else if (checkins.contains(studentId)) {
                System.out.println(studentId + ": Rejected (already checked in)");
                rejected++;
            } else {
                checkins.add(studentId);
                System.out.println(studentId + ": Checked in");
            }
        }

        int absent = participants.size() - checkins.size();

        // Final
        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + participants.size());
        System.out.println("Successful check-ins: " + checkins.size());
        System.out.println("Absent students: " + absent);
        System.out.println("Rejected attempts: " + rejected);
    }
}