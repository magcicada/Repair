package ch.voidlee.repair;

import ch.voidlee.repair.client.RepairClientEvents;
import net.minecraftforge.eventbus.api.IEventBus;

public class RepairClient {
    public static void init(IEventBus forgeBus, IEventBus modBus) {
        forgeBus.addListener(RepairClientEvents::onLogout);
    }
}
