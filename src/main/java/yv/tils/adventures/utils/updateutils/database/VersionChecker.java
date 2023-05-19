package yv.tils.adventures.utils.updateutils.database;

import yv.tils.adventures.Adventures;
import yv.tils.adventures.utils.ConsoleLog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @since 1.0
 * @version 1.0
 */
public class VersionChecker {
    public String NewestVersion() {
        ConnectionManager.openConnection();

        ResultSet resultSet;

        try {
            resultSet = ConnectionManager.getInformation("SELECT * FROM `yvtils_adventures` WHERE `state` = 'newest'");
            resultSet.next();

        return resultSet.getString(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String VersionChecker_FullRelease(String ServerPluginVersion) {
        ConnectionManager.openConnection();

        if (!Adventures.getInstance().database_connection) {
            return "ERROR";
        }

        ResultSet resultSet;

        try {
            resultSet = ConnectionManager.getInformation("SELECT * FROM `yvtils_adventures` WHERE `state` = 'newest'");

            resultSet.next();
            new ConsoleLog("Full Release: " + resultSet.getString(2));

            if (!Objects.equals(ServerPluginVersion, resultSet.getString(2))) {
                ConnectionManager.closeConnection();
                return "UA";
            }

            ConnectionManager.closeConnection();
            return "UTD";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
