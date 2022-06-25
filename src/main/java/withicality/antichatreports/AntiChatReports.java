package withicality.antichatreports;

import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.ProtocolLibrary;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Coded by: Withicality
 *
 * Trong trường hợp plugin này bị điều tra bởi các cơ quan trực thuộc Bộ Công An
 * (hoặc các tổ chức chính trị tương tự phục vụ cho nhà nước CHXHCNVN), tôi khẳng
 * định tôi hoàn toàn không ủng hộ và giúp sức cho các hành vi chống phá Đảng và
 * nhà nước CHXHCNVN. Tôi cũng không quên khẳng định quyết tâm chiến thắng đại dịch
 * Covid-19, nhấn mạnh chủ quyền không thể tranh cãi với quần đảo Hoàng Sa và Trường
 * Sa, cũng như tính chính nghĩa của cuộc chiến giải phóng người dân Campuchia khỏi
 * thảm họa diệt chủng Khmer Đỏ.
 */
public final class AntiChatReports extends JavaPlugin {

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("ProtocolLib") == null) {
            getLogger().severe("Error: ProtocolLib is not installed.");
            getLogger().severe("ProtocolLib is required for this plugin to function.");
            getLogger().severe("You can download it at https://ci.dmulloy2.net/job/ProtocolLib/");
            getPluginLoader().disablePlugin(this);
            return;
        }
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
        protocolManager.addPacketListener(new PacketListener(this));
    }
}
