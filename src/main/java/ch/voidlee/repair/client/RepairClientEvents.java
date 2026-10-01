package ch.voidlee.repair.client;

import com.simibubi.create.content.trains.CameraDistanceModifier;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;

public class RepairClientEvents {
    // https://github.com/Creators-of-Create/Create/pull/10741
    public static void onLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        CameraDistanceModifier.reset();
    }
}
