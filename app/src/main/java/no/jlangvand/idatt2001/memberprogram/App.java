/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package no.jlangvand.idatt2001.memberprogram;

public class App {
    public void runTests() {
        MemberArchive memberArchive = new MemberArchive();

        memberArchive.listAllMembers();

        System.out.println("\nAdd some bonuspoints to all of the members..\n");

        System.out.println("Member 1 gets 10.000");
        memberArchive.registerPoints(1, 10000);

        System.out.println("Member 2 gets 10.000");
        memberArchive.registerPoints(2, 10000);

        System.out.println("Member 3 gets 10.000");
        memberArchive.registerPoints(3, 10000);

        System.out.println("Member 4 gets 10.000");
        memberArchive.registerPoints(4, 10000);

        System.out.println("Member 5 gets 10.000");
        memberArchive.registerPoints(5, 10000);

        System.out.println("Now lets see the register:\n");
        memberArchive.listAllMembers();

    }

    public static void main(String[] args) {
        new App().runTests();
    }
}
