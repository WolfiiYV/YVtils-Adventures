package yv.tils.adventures.difficulty;

import org.bukkit.Material;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.language.LanguageMessage;

/**
 * @since 1.0
 * @version 1.0
 */
public enum Difficultys {

    D1("§6Challenge", Material.DIAMOND_SWORD, LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_CHALLENGE), LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_DETAILED_CHALLENGE)),
    D2("§6Almost Peaceful", Material.WOODEN_SWORD, LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_ALMOST_PEACEFUL), LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_DETAILED_ALMOST_PEACEFUL)),
    D3("§6Careless Cheetah", Material.POTION, LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_CARELESS_CHEETAH), LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_DETAILED_CARELESS_CHEETAH)),
    D4("§6Careful Snail", Material.POTION, LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_CAREFUL_SNAIL), LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_DETAILED_CAREFUL_SNAIL)),
    D5("§6Careful Holder", Material.CHEST, LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_CAREFUL_HOLDER), LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_DETAILED_CAREFUL_HOLDER)),
    D6("§6Ruthless Rumble", Material.SPAWNER, LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_RUTHLESS_RUMBLE), LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_DETAILED_RUTHLESS_RUMBLE)),
    D7("§6Swift Hunger", Material.COOKED_BEEF, LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_SWIFT_HUNGER), LanguageFile.getMessage(LanguageMessage.DIFFICULTY_DESC_DETAILED_SWIFT_HUNGER));

    public final String desc;
    public final Material item;
    public final String name;
    public final String dability;

    Difficultys(String name, Material item, String desc, String dability) {
        this.name = name;
        this.desc = desc;
        this.item = item;
        this.dability = dability;
    }
}
