package no.jlangvand.idatt2001.memberprogram;

public class SilverMembership extends Membership {
    private static float POINTS_SCALING_FACTOR = 1.2f;

    @Override
    public int registerPoints(int bonusPointsBalance, int newPoints) {
        return bonusPointsBalance + (int) (POINTS_SCALING_FACTOR * newPoints + 0.5f);
    }

    @Override
    public String getMembershipName() {
        return "Silver";
    }

}
