package no.jlangvand.idatt2001.memberprogram;


import java.time.LocalDate;
import java.util.HashMap;

/**
 * The member archive holds all the bonus members. The archive provides
 * functionality for adding members to the register, looking up bonuspoints
 * of given members, registering new bonuspoints and listing all the members.
 *
 * @author arne
 */
public class MemberArchive {

    // Use a HashMap, since the members have a unique member number.
    private HashMap<Integer, BonusMember> members;

    /**
     * Creates a new instance of MemberArchive.
     */
    public MemberArchive() {
        this.members = new HashMap<>();
        this.fillRegisterWithTestdata();
    }

    /**
     * Adds a new member to the register. The new member must have a memebr number
     * different from exsisting members. If not, the new member will not be added.
     *
     * @return {@code true} if the new member was added successfully,
     *         {@code false} if the new member could not be added, due to a
     *          membernumber that allready exsists.
     */
    public boolean addMember(BonusMember bonusMember) {
        if (members.containsKey(bonusMember.getMemberNumber()))
            return false;
        return members.put(bonusMember.getMemberNumber(), bonusMember) != null;
    }

    /**
     * Registers new bonuspoints to the member with the member number given
     * by the parameter {@code memberNumber}. If no member in the register
     * matches the provided member number, {@code false} is returned.
     *
     * @param memberNumber the member number to add the bonus points to
     * @param bonusPoints the bonus points to be added
     * @return {@code true} if bonuspoints were added successfully,
     *         {@code flase} if not.
     */
    public boolean registerPoints(int memberNumber, int bonusPoints) {
        if (!members.containsKey(memberNumber))
            return false;
        members.get(memberNumber).registerBonusPoints(bonusPoints);
        return true;
    }

    /**
     * Get bonus point balance of a member by member number and password.
     * Returns -1 if member is not found or -2 if password does not validate.
     *
     * @param memberNumber the member to get balance from
     * @param password password
     * @return bonus point balance
     *         {@code -1} if member is not found
     *         {@code -2} if password does not validate    
     */    
    public int findPoints(int memberNumber, String password) {
        if (members.containsKey(memberNumber)) {
            if (members.get(memberNumber).checkPassword(password))
                return members.get(memberNumber).getBonusPointsBalance();
            else
                return -2;
        }
        return -1;
    }
    
    /**
     * Lists all members to the console.
     */
    public void listAllMembers() {
        this.members.forEach((id, member) -> {
                System.out.print("\nID: " + id);
                System.out.print("\nName: " + member.getName());
                System.out.print("\nEmail: " + member.getEmailAddress());
                System.out.print("\nEnrolled: " + member.getEnrolledDate().toString());
                System.out.print("\nMember type: " + member.getMembershipLevel());
                System.out.print("\nPoints: " + member.getBonusPointsBalance() + "\n");
        });
    }


    /**
     * Fills the register with some arbitrary members, for testing purposes.
     */
    private void fillRegisterWithTestdata() {
        BonusMember member = new BonusMember(1, LocalDate.now(), 10000, "Olsen, Ole", "ole@olsen.biz");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(2, LocalDate.now(), 15000, "Jensen, Jens", "jens@jensen.biz");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(3, LocalDate.now(), 5000, "Lie, Linda", "linda@lie.no");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(4, LocalDate.now(), 30000, "Paulsen, Paul", "paul@paulsen.org");
        this.members.put(member.getMemberNumber(), member);
        member = new BonusMember(5, LocalDate.now(), 75000, "FLo, Finn", "finn.flo@gmail.com");
        this.members.put(member.getMemberNumber(), member);
    }
}
