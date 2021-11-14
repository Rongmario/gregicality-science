package gregicality.science.loaders.recipes.chain;

import gregicality.science.common.item.GCYSciMetaItems;

import static gregicality.science.api.GCYSciMaterials.*;
import static gregicality.science.loaders.recipes.GCYSciRecipeMaps.BIO_REACTOR_RECIPES;
import static gregicality.science.loaders.recipes.GCYSciRecipeMaps.CHEMICAL_DEHYDRATOR_RECIPES;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class HNIWChain {

    public static void init() {
        //K2CO3 + 2 SO2 + H2O -> 2 KHSO3 + CO2
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(SulfurDioxide.getFluid(2000))
                .input(dust, PotassiumCarbonate, 6)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, PotassiumBisulfite, 12)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        //KNO3 + Pb -> PbO + KNO2
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Saltpeter, 5)
                .input(dust, Lead)
                .output(dust, PotassiumNitrite, 4)
                .output(dust, Massicot, 2)
                .blastFurnaceTemp(3000)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        //KNO2 + CH3COOH + NaCl > HNO2 + CH3COONa + KCl
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumNitrite, 4)
                .fluidInputs(AceticAcid.getFluid(1000))
                .input(dust, Salt, 2)
                .fluidOutputs(NitrousAcid.getFluid(1000))
                .output(dust, RockSalt, 2)
                .fluidOutputs(SodiumAcetate.getFluid(1000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        ///2 KHSO3 + HNO2 -> K2NHS2O7 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(NitrousAcid.getFluid(1000))
                .input(dust, PotassiumBisulfite, 12)
                .output(dust, PotassiumHydroxylaminedisulfonate, 13)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(1920)
                .duration(100)
                .buildAndRegister();

        //2 K2NHS2O7 + 4 H2O -> 2 K2SO4 + H2SO4 + N2H8SO6
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PotassiumHydroxylaminedisulfonate, 26)
                .fluidInputs(Water.getFluid(4000))
                .output(dust, HydroxylammoniumSulfate, 17)
                .output(dust, PotassiumSulfate, 12)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();

        //N2H8SO6 + BaCl2 -> 2 H4NOCl + BaSO4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, HydroxylammoniumSulfate, 17)
                .input(dust, BariumChloride, 3)
                .fluidOutputs(HydroxylamineHydrochloride.getFluid(2000))
                .fluidOutputs(BariumSulfateSolution.getFluid(1000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        //C4H6O4 + CaCl2 (not consumed) + (CH3CO)2O -> C4H4O3 + 2 CH3COOH
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SuccinicAcid, 14)
                .fluidInputs(AceticAnhydride.getFluid(1000))
                .notConsumable(dust, CalciumChloride)
                .output(dust, SuccinicAnhydride, 11)
                .fluidOutputs(AceticAcid.getFluid(2000))
                .EUt(7680)
                .duration(100)
                .buildAndRegister();

        //2 CH2O + C2H2 + 4 H -> C4H8O + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Acetylene.getFluid(1000))
                .fluidInputs(Formaldehyde.getFluid(2000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .fluidOutputs(Tetrahydrofuran.getFluid(1000))
                .EUt(7680)
                .duration(75)
                .buildAndRegister();

        //C4H4O3 + H4NOCl + Na -> C4H5NO3 + H2O + NaCl + H
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .input(dust, SuccinicAnhydride, 66)
                .fluidInputs(HydroxylamineHydrochloride.getFluid(6000))
                .fluidInputs(Toluene.getFluid(6000))
                .input(dust, Sodium, 6)
                .fluidInputs(Methanol.getFluid(40000))
                .output(dust, Salt, 12)
                .output(dust, NHydroxysuccinimide, 13)
                .fluidOutputs(Water.getFluid(6000))
                .fluidOutputs(Hydrogen.getFluid(6000))
                .EUt(1920)
                .duration(400)
                .buildAndRegister();

        //NH3 + 3 C2H5OH -> (C2H5)3N + 3 H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidInputs(Ethanol.getFluid(3000))
                .fluidOutputs(Triethylamine.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        //(CH2CO)2NOH + (CH3CO)2O -> C6H7NO4 + CH3COOH
        CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(Triethylamine.getFluid(1000))
                .fluidInputs(AceticAnhydride.getFluid(1000))
                .input(dust, NHydroxysuccinimide, 13)
                .notConsumable(Tetrahydrofuran.getFluid(1000))
                .output(dust, SuccinimidylAcetate, 18)
                .fluidOutputs(AceticAcid.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();

        //SeO2 + H2O -> H2SeO3
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SeleniumOxide, 3)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(SelenousAcid.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        //CH3CHO + O -> (CHO)2 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Acetaldehyde.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .notConsumable(SelenousAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(Glyoxal.getFluid(1000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        //2 CH3COOH + (NH4)2CO3 -> H2O + CO2 + 2 CH3COONH4
        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, AmmoniumCarbonate, 14)
                .fluidInputs(AceticAcid.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, AmmoniumAcetate, 24)
                .EUt(1920)
                .duration(100)
                .buildAndRegister();

        //CH3COONH4 -> CH3CONH2 + H2O (H2O lost in dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder()
                .input(dust, AmmoniumAcetate, 12)
                .output(dust, Acetamide, 9)
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        //CH3CONH2 -> CH3CN + H2O (H2O lost in dehydrator)
        CHEMICAL_DEHYDRATOR_RECIPES.recipeBuilder()
                .input(dust, Acetamide, 9)
                .output(dust, Acetonitrile, 6)
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        //C7H8 + Cl -> C7H7Cl + H
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Toluene.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(1000))
                .notConsumable(GCYSciMetaItems.UVA_HALIDE_LAMP.getStackForm())
                .fluidOutputs(BenzylChloride.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        //6 CH2O + 4 NH3 -> C6H12N4 + 6 H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Formaldehyde.getFluid(4000))
                .fluidOutputs(Ammonia.getFluid(6000))
                .output(dust, Hexamethylenetetramine, 22)
                .fluidOutputs(Water.getFluid(6000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        //C7H7Cl + C6H12N4 + 2 HCl + 6 H2O -> C7H9N + 6 CH2O + 3 NH4Cl
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(BenzylChloride.getFluid(1000))
                .input(dust, Hexamethylenetetramine, 22)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(Water.getFluid(6000))
                .fluidOutputs(Benzylamine.getFluid(1000))
                .fluidOutputs(AmmoniumChloride.getFluid(3000))
                .fluidOutputs(Formaldehyde.getFluid(6000))
                .EUt(7680)
                .duration(200)
                .buildAndRegister();

        //6 C7H9N + 3 (CHO)2 + CH3CN (not consumed) -> C48N6H48 + 6 H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Glyoxal.getFluid(3000))
                .fluidInputs(Benzylamine.getFluid(6000))
                .notConsumable(Hydrogen.getFluid(1000))
                .notConsumable(dust, Acetonitrile)
                .output(dust, Hexabenzylhexaazaisowurtzitane)
                .EUt(7680)
                .duration(100)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PalladiumChloride)
                .input(dust, Carbon)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidInputs(Formaldehyde.getFluid(1000))
                .output(dust, PdCCatalyst)
                .EUt(1920)
                .duration(100)
                .buildAndRegister();

        //C48N6H48 + 4 C6H7NO4 + 4H -> 4 C7H8 + C28N6H32O4 + C4H5NO2
        CHEMICAL_PLANT_RECIPES.recipeBuilder()
                .fluidInputs(Hydrogen.getFluid(4000))
                .notConsumable(dust, PdCCatalyst)
                .notConsumable(Ethylbenzene.getFluid(1000))
                .notConsumable(HydrobromicAcid.getFluid(1000))
                .notConsumable(Dimethylformamide.getFluid(1000))
                .input(dust, SuccinimidylAcetate, 72)
                .input(dust, Hexabenzylhexaazaisowurtzitane)
                .output(dust, DibenzylTetraacetylhexaazaisowurtzitane)
                .output(dust, Succinimide, 48)
                .fluidOutputs(Toluene.getFluid(4000))
                .EUt(30720)
                .duration(100)
                .buildAndRegister();

        //BF3 + HF + HNO3 -> NO2BF4 + H2O
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(BoronFluoride.getFluid(1000))
                .fluidInputs(HydrofluoricAcid.getFluid(1000))
                .fluidInputs(NitricAcid.getFluid(1000))
                .output(dust, NitroniumTetrafluoroborate, 8)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(1920)
                .duration(100)
                .buildAndRegister();

        //BF3 + HF + NO2 -> NOBF4 + HNO3
        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(BoronFluoride.getFluid(2000))
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .fluidInputs(DinitrogenTetroxide.getFluid(2000))
                .output(dust, NitrosoniumTetrafluoroborate, 7)
                .fluidOutputs(NitricAcid.getFluid(1000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();


        //C28N6H32O4 + 6 NOBF4 + 2 H2O -> C14N8H18O6 + 2 C7H6O + 4 NO + 6 HBF4
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, DibenzylTetraacetylhexaazaisowurtzitane)
                .input(dust, NitrosoniumTetrafluoroborate, 42)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, Tetraacetyldinitrosohexaazaisowurtzitane)
                .fluidOutputs(TetrafluoroboricAcid.getFluid(6000))
                .fluidOutputs(NitricOxide.getFluid(4000))
                .fluidOutputs(Benzaldehyde.getFluid(2000))
                .EUt(1920)
                .duration(100)
                .buildAndRegister();

        //C14N8H18O6 + 6 NO2BF4 + 4 H2O -> C6H6N12O12 + 2 NOBF4 + 4 CH3COOH + 4 HBF4
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, DibenzylTetraacetylhexaazaisowurtzitane)
                .input(dust, NitroniumTetrafluoroborate, 48)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, CrudeHexanitroHexaaxaisowurtzitane)
                .output(dust, NitrosoniumTetrafluoroborate, 14)
                .fluidOutputs(TetrafluoroboricAcid.getFluid(6000))
                .fluidOutputs(AceticAcid.getFluid(4000))
                .EUt(491520)
                .duration(100)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CrudeHexanitroHexaaxaisowurtzitane)
                .fluidInputs(Ethylenediamine.getFluid(1000))
                .input(dust, SilicaGel)
                .output(dust, HexanitroHexaaxaisowurtzitane)
                .EUt(1920)
                .duration(100)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(TetrafluoroboricAcid.getFluid(1000))
                .fluidInputs(Water.getFluid(3000))
                .fluidOutputs(HydrofluoricAcid.getFluid(4000))
                .fluidOutputs(BoricAcid.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        BIO_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BrevibacteriumFlavium)
                .input(dust, Succinimide, 12)
                .output(dust, SuccinicAnhydride, 11)
                .fluidOutputs(Ammonia.getFluid(1000))
                .EUt(3840)
                .duration(100)
                .buildAndRegister();

    }
}