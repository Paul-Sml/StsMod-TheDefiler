package theDefiler.patch;

import basemod.ReflectionHacks;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.screens.SingleCardViewPopup;
import theDefiler.cards.AbstractDefilerCard;

public class SingleCardViewPopupPatches {
    //private static TextureAtlas.AtlasRegion SecondLargeEnergyOrbOnCard = theextravagant.UIAtlas.findRegion("LargeOtherEnergyCard");

    @SpirePatch(clz = SingleCardViewPopup.class, method = "renderCost")

    public static class RenderSecondCostPatch {
//        private static Texture GoldOrb = ImageMaster.loadImage("thedefilermodResources/images/512/panelGoldBagFull.png");
//        private static Texture MHPOrb = ImageMaster.loadImage("thedefilermodResources/images/512/panelHeartFull.png");
//        private static Texture GMHPOrb = ImageMaster.loadImage("thedefilermodResources/images/512/panelGoldBagHeartFull.png");
        private static void renderHelper(SpriteBatch sb, float x, float y, TextureAtlas.AtlasRegion img) {
            if (img != null) {
                sb.draw(img, x + img.offsetX - (float)img.originalWidth / 2.0F, y + img.offsetY - (float)img.originalHeight / 2.0F, (float)img.originalWidth / 2.0F - img.offsetX, (float)img.originalHeight / 2.0F - img.offsetY, (float)img.packedWidth, (float)img.packedHeight, Settings.scale, Settings.scale, 0.0F);
            }
        }
        @SpirePostfixPatch
        public static void patch(SingleCardViewPopup __instance, SpriteBatch sb) {
            AbstractCard C = (AbstractCard) ReflectionHacks.getPrivate(__instance, SingleCardViewPopup.class, "card");
            if (C instanceof AbstractDefilerCard) {
                //renderHelper(sb, (float) Settings.WIDTH / 2.0F + 270.0F * Settings.scale, (float) Settings.HEIGHT / 2.0F + 380.0F * Settings.scale, SecondLargeEnergyOrbOnCard);
//                renderHelper(sb, (float) Settings.WIDTH / 2.0F - 115 * Settings.scale, (float) Settings.HEIGHT / 2.0F - 94.0F * Settings.scale, GoldOrb);
                FontHelper.renderFont(sb, FontHelper.SCP_cardEnergyFont, Integer.toString(((AbstractDefilerCard)C).goldCostForTurn), (float) Settings.WIDTH / 2.0F - 300 * Settings.scale, (float) Settings.HEIGHT / 2.0F + 88F * Settings.scale, Color.WHITE);
            }
        }
    }
}