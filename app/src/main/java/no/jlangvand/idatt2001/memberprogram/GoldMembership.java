package no.jlangvand.idatt2001.memberprogram;

public class GoldMembership extends Membership {
    private static final float POINTS_SCALING_FACTOR_LEVEL_1 = 1.3f;
    private static final float POINTS_SCALING_FACTOR_LEVEL_2 = 1.5f;

    @Override
    public int registerPoints(int bonusPointsBalance, int newPoints) {
        if (bonusPointsBalance < 90000)
            return bonusPointsBalance + (int) (POINTS_SCALING_FACTOR_LEVEL_1 * newPoints + 0.5f);
        return bonusPointsBalance + (int) (POINTS_SCALING_FACTOR_LEVEL_2 * newPoints + 0.5f);
    }

    @Override
    public String getMembershipName() {
        return "Gold";
    }

}
