package yv.tils.adventures.unlock.LevelPath;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 1.0
 * @version 1.0
 */
public enum Level {

    /*
L01: 50XP
L02: 75XP
L03: 100XP
L04: 125XP
L05: 150XP
L06: 175XP
L07: 200XP
L08: 225XP
L09: 250XP
L10: 300XP
L11: 350XP
L12: 400XP
L13: 450XP
L14: 500XP
L15: 550XP
L16: 600XP
L17: 650XP
L18: 700XP
L19: 750XP
L20: 800XP
L21: 900XP
L22: 1000XP
L23: 1100XP
L24: 1200XP
L25: 1300XP
L26: 1400XP
L27: 1500XP
L28: 1600XP
L29: 1700XP
L30: 1800XP
     */

    L1(1, 50, "The Beginning", ""),
    L2(2, 75, "null", ""),
    L3(3, 100, "null", ""),
    L4(4, 125, "null", ""),
    L5(5, 150, "More Hearts I", ""),
    L6(6, 175, "null", ""),
    L7(7, 200, "null", ""),
    L8(8, 225, "null", ""),
    L9(9, 250, "null", ""),
    L10(10, 300, "I'll spare your life I", ""),
    L11(11, 350, "null", ""),
    L12(12, 400, "null", ""),
    L13(13, 450, "null", ""),
    L14(14, 500, "null", ""),
    L15(15, 550, "On Fire I", ""),
    L16(16, 600, "null", ""),
    L17(17, 650, "null", ""),
    L18(18, 700, "null", ""),
    L19(19, 750, "null", ""),
    L20(20, 800, "More Hearts II", ""),
    L21(21, 900, "null", ""),
    L22(22, 1000, "null", ""),
    L23(23, 1100, "null", ""),
    L24(24, 1200, "null", ""),
    L25(25, 1300, "More Hearts III", ""),
    L26(26, 1400, "null", ""),
    L27(27, 1500, "null", ""),
    L28(28, 1600, "null", ""),
    L29(29, 1700, "null", ""),
    L30(30, 1800, "Light Flight I", ""),
    L31(31, 2000, "null", ""),
    L32(32, 2200, "null", ""),
    L33(33, 2400, "null", ""),
    L34(34, 2600, "null", ""),
    L35(35, 2800, "I'll spare your life II", ""),
    L36(36, 3000, "null", ""),
    L37(37, 3200, "null", ""),
    L38(38, 3400, "null", ""),
    L39(39, 3600, "null", ""),
    L40(40, 3800, "Vampire I", ""),
    L41(41, 4000, "null", ""),
    L42(42, 4500, "null", ""),
    L43(43, 5000, "null", ""),
    L44(44, 5500, "null", ""),
    L45(45, 6000, "The End I", ""),


    //Extra Level, make it unreachable
    L46(46, 999999999, "", "");


    public final int level;
    public final int xp;
    public final String reward;
    public final String desc;

    Level(int level, int xp, String reward, String desc) {
        this.level = level;
        this.xp = xp;
        this.reward = reward;
        this.desc = desc;
    }
}
