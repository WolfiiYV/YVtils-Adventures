package yv.tils.adventures.utils.updateutils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import yv.tils.adventures.Adventures;
import yv.tils.adventures.utils.MessagePlaceholder;
import yv.tils.adventures.utils.language.LanguageFile;
import yv.tils.adventures.utils.updateutils.database.VersionChecker;

/**
 * @since 1.0
 * @version 1.0
 */
public class JoinAnnouncer implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPermission("yvtils.adventures.update.getannounced")) {
            if (new VersionChecker().VersionChecker_FullRelease(Adventures.PluginVersion).equals("UA")) {
                e.getPlayer().sendMessage(LanguageFile.DirectFormatter( MessagePlaceholder.PREFIXUPDATE + " §fUpdate Available - Running Version: " + Adventures.PluginVersion + "; Available Version: " + new VersionChecker().NewestVersion(), MessagePlaceholder.PREFIXUPDATE + " §fUpdate Verfügbar - Nutzende Version: " + Adventures.PluginVersion + "; Neueste Version: " + new VersionChecker().NewestVersion()));
            }
        }
    }
}
