package soupbubbles.minecraftboom.world;

import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import soupbubbles.minecraftboom.handler.ConfigurationHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class WorldGenEventHandler
{

    @SubscribeEvent
    public void onDecorateBiome(DecorateBiomeEvent.Decorate event)
    {
        if (ConfigurationHandler.Settings.generatePumpkins)
        {
            if (event.getType() == EventType.PUMPKIN)
            {
                event.setResult(Result.DENY);
            }
        }
    }
}