/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package candidatesmanager;

/**
 *
 * @author hoaht
 */
public class Main {
    public static void main(String[] args) {
        CandidateList candidateList = new CandidateList();
        String[] menu = {"Experience", "Fresher", "Internship", "Searching", "Exit"};
        while (true) {
            System.out.println("============ CANDIDATE MANAGEMENT SYSTEM ============");
            Menu.printMenu(menu);
            System.out.println("=====================================================");
            int choice = Menu.getChoiceFromMenu(menu);
            
            switch (choice) {
                case 1: candidateList.addCandidate(0); break;
                case 2: candidateList.addCandidate(1); break;
                case 3: candidateList.addCandidate(2); break;
                case 4: candidateList.searchCandidate(); break;
                case 5: System.exit(0); break;
            }
        }
    }
}
