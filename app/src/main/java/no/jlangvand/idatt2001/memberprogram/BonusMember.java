package no.jlangvand.idatt2001.memberprogram;

import java.time.LocalDate;

import no.iskra.hashedpassword.HashedPassword;

/**
 * BonusMember
 */
public class BonusMember {
    private final int memberNumber;
    private final LocalDate enrolledDate;
    private int bonusPointsBalance = 0;
    private String name;
    private String emailAddress;
    private HashedPassword password;
    private Membership membership;

    private static final int SILVER_LIMIT = 25000;
    private static final int GOLD_LIMIT = 75000;

    public BonusMember(int memberNumber, LocalDate enrolled, int bonusPoints, String name, String email) {
        this.memberNumber = memberNumber;
        this.enrolledDate = enrolled;
        this.name = name;
        this.emailAddress = email;
        this.membership = new BasicMembership();
        registerBonusPoints(bonusPoints);
    }

    public int getBonusPointsBalance() {
        return bonusPointsBalance;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setPassword(String password) {
        this.password = new HashedPassword(password);
    }        

    public boolean checkPassword(String password) {
        return this.password.validate(password);
    }

    public void registerBonusPoints(int points) {
        this.bonusPointsBalance = this.membership.registerPoints(this.bonusPointsBalance, points);
        checkAndSetMembership();
    }

    public String getMembershipLevel() {
        return this.membership.getMembershipName();
    }

    public int getMemberNumber() {
        return this.memberNumber;
    }

    private void checkAndSetMembership() {
        if (this.enrolledDate.isAfter(this.enrolledDate.minusYears(1))) {
            if (this.bonusPointsBalance >= SILVER_LIMIT)
                this.membership = this.bonusPointsBalance >= GOLD_LIMIT ? new GoldMembership() : new SilverMembership();
        }
    }
}
