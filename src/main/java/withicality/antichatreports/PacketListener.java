package withicality.antichatreports;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.plugin.Plugin;

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
public class PacketListener extends PacketAdapter {
    public PacketListener(Plugin plugin) {
        super(plugin, PacketType.Play.Client.CHAT);
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        //Documentation: https://wiki.vg/Protocol#Chat_Message_.28serverbound.29
        PacketContainer packet = event.getPacket();
        PacketType type = packet.getType();

        if (!type.equals(PacketType.Play.Client.CHAT)) return;
        packet.getBooleans().write(0, false);
    }
}
