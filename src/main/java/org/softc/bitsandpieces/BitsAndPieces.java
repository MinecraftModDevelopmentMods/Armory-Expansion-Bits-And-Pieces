package org.softc.bitsandpieces;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.softc.armoryexpansion.ArmoryExpansion;
import org.softc.armoryexpansion.common.integration.aelib.integration.JsonIntegration;

@Mod(
        modid = BitsAndPieces.MODID,
        name = BitsAndPieces.NAME,
        version = BitsAndPieces.VERSION,
        dependencies = BitsAndPieces.DEPENDENCIES
)
@Mod.EventBusSubscriber
public class BitsAndPieces extends JsonIntegration {
    private static final String INTEGRATION_ID = "bitsandpieces";
    private static final String INTEGRATION_NAME = "Bits And Pieces";

    static final String MODID = ArmoryExpansion.MODID + "-" + INTEGRATION_ID;
    static final String NAME = ArmoryExpansion.NAME + " - " + INTEGRATION_NAME;
    static final String VERSION = "0.0.1";
    static final String DEPENDENCIES =
            "required-after:" + ArmoryExpansion.MODID + "; ";

    public BitsAndPieces() {
        super(INTEGRATION_ID, ArmoryExpansion.MODID, INTEGRATION_ID);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.modId = INTEGRATION_ID;
        super.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<? super Block> event){
        super.registerBlocks(event);
    }

    @Override
    public boolean isLoadable() {
        return ArmoryExpansion.isIntegrationEnabled(this.modId);
    }
}
