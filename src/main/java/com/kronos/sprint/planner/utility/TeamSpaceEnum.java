package com.kronos.sprint.planner.utility;

import java.util.Arrays;

public enum TeamSpaceEnum {

    PAYROLL("PR Tax", "PAY", 61),
    ACCRUALS("Accruals", "AC", 22),
    PLATFORM_MERCURY("Curiosity", "PLAT", 21),
    APD("APD", "APD", 33),
    CALYPSO("Calypso", "CAL", 31),
    DEVOPS("DevOps", "DEVOPS", 26),
    HCM_DIMENSIONS("HCM Dimensions", "DH", 30),
    PERFORMANCE_ENGINEERING("Performance Engineering", "DEV", 30),
    KSB_PAYROLL_TEAM("KSB Payroll Team", "KPS", 27),
    BLANK(null, null, 0);

    private String label;
    private String space;
    private int teamId;

    TeamSpaceEnum(String label, String space, int teamId) {
        this.label = label;
        this.space = space;
        this.teamId = teamId;
    }

    public static TeamSpaceEnum getValueByTeamLabel(String label) {

        return Arrays.stream(TeamSpaceEnum.values())
                .filter(type -> type.getLabel().equalsIgnoreCase(label))
                .findFirst()
                .orElse(BLANK);
    }

    public static TeamSpaceEnum getValueByTeamId(int teamId) {

        return Arrays.stream(TeamSpaceEnum.values())
                .filter(type -> type.getTeamId() == teamId)
                .findFirst()
                .orElse(BLANK);
    }

    public String getLabel() {
        return label;
    }

    public String getSpace() {
        return space;
    }

    public int getTeamId() {
        return teamId;
    }
}
