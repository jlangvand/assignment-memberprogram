package no.jlangvand.idatt2001.memberprogram;

public class BasicMembership extends Membership {
    @Override
    public int registerPoints(int bonusPointsBalance, int newPoints) {
        return bonusPointsBalance + newPoints;
    }

    @Override
    public String getMembershipName() {
        return "Basic";
    }
}
