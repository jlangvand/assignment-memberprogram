package no.jlangvand.idatt2001.memberprogram;

abstract class Membership {
    public abstract int registerPoints(int bonusPointsBalance, int newPoints);

    public abstract String getMembershipName();
}
