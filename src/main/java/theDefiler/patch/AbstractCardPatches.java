package theDefiler.patch;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import theDefiler.cards.AbstractDefilerCard;

public class AbstractCardPatches {
    //private static TextureAtlas.AtlasRegion SecondEnergyOrbOnCard = theextravagant.UIAtlas.findRegion("OtherEnergyCard");
    private static Texture GoldOrb = ImageMaster.loadImage("thedefilermodResources/images/512/panelGoldBag.png");
    private static Texture MHPOrb = ImageMaster.loadImage("thedefilermodResources/images/512/panelHeart.png");
    @SpirePatch(clz = AbstractCard.class, method = "renderEnergy")
    public static class SecondEnergyRenderPatch {
        @SpirePostfixPatch
        public static void patch(AbstractCard __instance, SpriteBatch sb) {
            if(__instance instanceof AbstractDefilerCard)
            {
                FontHelper.cardEnergyFont_L.getData().setScale(__instance.drawScale);

                if (((AbstractDefilerCard)__instance).goldCost > 0) {
                    FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(((AbstractDefilerCard) __instance).goldCostForTurn), __instance.current_x, __instance.current_y, -135.0F * __instance.drawScale * Settings.scale, 120.0F * __instance.drawScale * Settings.scale, __instance.angle, false, Color.WHITE);
                    renderElementHelper(sb, GoldOrb, 0.0F * __instance.drawScale * Settings.scale,
                            0.0F * __instance.drawScale * Settings.scale);
                }
                if (((AbstractDefilerCard)__instance).maxhpCost > 0)
                    FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(((AbstractDefilerCard)__instance).maxhpCostForTurn), __instance.current_x, __instance.current_y, -135.0F * __instance.drawScale * Settings.scale, 55.0F * __instance.drawScale * Settings.scale, __instance.angle, false, Color.WHITE);
            }
        }
        private static void renderHelper(SpriteBatch sb, Color color, TextureAtlas.AtlasRegion img, float drawX, float drawY, AbstractCard C) {
            sb.setColor(color);
            sb.draw(img, drawX + img.offsetX - (float)img.originalWidth / 2.0F, drawY + img.offsetY - (float)img.originalHeight / 2.0F, (float)img.originalWidth / 2.0F - img.offsetX, (float)img.originalHeight / 2.0F - img.offsetY, (float)img.packedWidth, (float)img.packedHeight, C.drawScale * Settings.scale, C.drawScale * Settings.scale, C.angle);
        }
        private static void renderElementHelper(SpriteBatch sb, Texture img, float drawX, float drawY) {
            sb.draw(img, drawX, drawY,
                    0, 0, 125.0F, 125.0F,
                    Settings.scale,  Settings.scale,
                    0, 0, 0, 125, 125, false, false);

        }

    }
}
