package gregicality.science.loaders.recipes.chain;

import gregicality.science.common.GCYSciConfig;
import gregicality.science.common.machine.GCYSciTileEntities;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.CIRCUIT_ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.PLASTIC_BOARD;
import static gregtech.common.items.MetaItems.SMD_DIODE;

public class DigitalInterfaces {
    public static void init() {
        int tier = 3;
        for (String fluid : GCYSciConfig.Misc.solderingFluidList) {
            String[] fluidSplit = fluid.split(":");
            int amount = Integer.parseInt(fluidSplit[1]);
            if (amount > 64000) {
                amount = 64000;
            }
            if (amount < 1) {
                amount = 1;
            }
            FluidStack fluidStack = FluidRegistry.getFluidStack(fluidSplit[0], amount);
            if (fluidStack == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder().duration(160).EUt(300)
                    .inputs(SMD_DIODE.getStackForm(16))
                    .input(dust, Glass, 1)
                    .input(dye, MarkerMaterials.Color.Red, 1)
                    .input(dye, MarkerMaterials.Color.Green, 1)
                    .input(dye, MarkerMaterials.Color.Blue, 1)
                    .input(wireFine, Aluminium, 8)
                    .fluidInputs(fluidStack)
                    .outputs(COLOURED_LEDS.getStackForm(32))
                    .buildAndRegister();

            CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder().duration(120).EUt(300)
                    .inputs(COLOURED_LEDS.getStackForm(4))
                    .inputs(PLASTIC_BOARD.getStackForm())
                    .input(wireFine, Aluminium, 4)
                    .fluidInputs(fluidStack)
                    .outputs(DISPLAY.getStackForm())
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(480)
                    .inputs(DISPLAY.getStackForm())
                    .inputs(MetaTileEntities.HULL[tier].getStackForm())
                    .input(wireFine, AnnealedCopper, 8)
                    .fluidInputs(fluidStack)
                    .outputs(GCYSciTileEntities.MONITOR_SCREEN.getStackForm())
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(500)
                    .inputs(DISPLAY.getStackForm())
                    .inputs(MetaTileEntities.HULL[tier].getStackForm())
                    .input(circuit, MarkerMaterials.Tier.Advanced, 2)
                    .fluidInputs(fluidStack)
                    .outputs(GCYSciTileEntities.CENTRAL_MONITOR.getStackForm())
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder().duration(100).EUt(500)
                    .inputs(DISPLAY.getStackForm())
                    .input(plate, StainlessSteel)
                    .input(circuit, MarkerMaterials.Tier.Advanced)
                    .input(screw, StainlessSteel, 4)
                    .fluidInputs(fluidStack)
                    .outputs(COVER_DIGITAL_INTERFACE.getStackForm())
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(400)
                    .inputs(DISPLAY.getStackForm())
                    .input(circuit, MarkerMaterials.Tier.Basic)
                    .input(wireFine, Copper, 2)
                    .fluidInputs(fluidStack)
                    .outputs(PLUGIN_TEXT.getStackForm())
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(400)
                    .inputs(DISPLAY.getStackForm())
                    .input(circuit, MarkerMaterials.Tier.Basic)
                    .input(wireFine, Iron, 2)
                    .fluidInputs(fluidStack)
                    .outputs(PLUGIN_ONLINE_PIC.getStackForm())
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(400)
                    .inputs(DISPLAY.getStackForm())
                    .input(circuit, MarkerMaterials.Tier.Basic)
                    .input(wireFine, Gold, 2)
                    .fluidInputs(fluidStack)
                    .outputs(PLUGIN_FAKE_GUI.getStackForm())
                    .buildAndRegister();

            ASSEMBLER_RECIPES.recipeBuilder().duration(80).EUt(400)
                    .inputs(DISPLAY.getStackForm())
                    .input(circuit, MarkerMaterials.Tier.Advanced)
                    .input(wireFine, Aluminium, 2)
                    .fluidInputs(fluidStack)
                    .outputs(PLUGIN_ADVANCED_MONITOR.getStackForm())
                    .buildAndRegister();
        }
    }
}
