package theDefiler.patch;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import theDefiler.cards.AbstractDefilerCard;

public class AbstractCardPatches {
//    private static Texture GoldOrb = ImageMaster.loadImage("thedefilermodResources/images/512/panelGoldBagFull.png");
//    private static Texture MHPOrb = ImageMaster.loadImage("thedefilermodResources/images/512/panelHeartFull.png");
//    private static Texture GMHPOrb = ImageMaster.loadImage("thedefilermodResources/images/512/panelGoldBagHeartFull.png");
    @SpirePatch(clz = AbstractCard.class, method = "renderEnergy")
    public static class SecondEnergyRenderPatch {
        @SpirePostfixPatch
        public static void patch(AbstractCard __instance, SpriteBatch sb) {
            if(__instance instanceof AbstractDefilerCard) {
                FontHelper.cardEnergyFont_L.getData().setScale(__instance.drawScale);

                float yOffset = 55.0F * Settings.scale * __instance.drawScale;
                int counter = 0;
                Vector2 offset = new Vector2(0, -yOffset * counter);
                offset.rotate(__instance.angle);

                if (((AbstractDefilerCard)__instance).goldCost > -1 && ((AbstractDefilerCard)__instance).maxhpCost > -1) {
//                    renderElementHelper(sb, GMHPOrb,
//                            (__instance.current_x ) + offset.x,
//                            (__instance.current_y) + offset.y,
//                            __instance.drawScale * Settings.scale,
//                            __instance.drawScale * Settings.scale,
//                            __instance.angle);
                    FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(((AbstractDefilerCard) __instance).goldCostForTurn), __instance.current_x, __instance.current_y, -135.0F * __instance.drawScale * Settings.scale, 120.0F * __instance.drawScale * Settings.scale, __instance.angle, false, Color.WHITE);
                    FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(((AbstractDefilerCard) __instance).maxhpCostForTurn), __instance.current_x, __instance.current_y, -135.0F * __instance.drawScale * Settings.scale, 55.0F * __instance.drawScale * Settings.scale, __instance.angle, false, Color.WHITE);
                } else if (((AbstractDefilerCard)__instance).goldCost > -1) {
//                    renderElementHelper(sb, GoldOrb,
//                            (__instance.current_x ) + offset.x,
//                            (__instance.current_y) + offset.y,
//                            __instance.drawScale * Settings.scale,
//                            __instance.drawScale * Settings.scale,
//                            __instance.angle);
                    FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(((AbstractDefilerCard) __instance).goldCostForTurn), __instance.current_x, __instance.current_y, -135.0F * __instance.drawScale * Settings.scale, 120.0F * __instance.drawScale * Settings.scale, __instance.angle, false, Color.WHITE);
                } else if (((AbstractDefilerCard)__instance).maxhpCost > -1) {
//                    renderElementHelper(sb, MHPOrb,
//                            (__instance.current_x ) + offset.x,
//                            (__instance.current_y) + offset.y,
//                            __instance.drawScale * Settings.scale,
//                            __instance.drawScale * Settings.scale,
//                            __instance.angle);
                    FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(((AbstractDefilerCard) __instance).maxhpCostForTurn), __instance.current_x, __instance.current_y, -135.0F * __instance.drawScale * Settings.scale, 120.0F * __instance.drawScale * Settings.scale, __instance.angle, false, Color.WHITE);
                }
            counter++;
            }
        }
        private static void renderHelper(SpriteBatch sb, Color color, TextureAtlas.AtlasRegion img, float drawX, float drawY, AbstractCard C) {
            sb.setColor(color);
            sb.draw(img, drawX + img.offsetX - (float)img.originalWidth / 2.0F, drawY + img.offsetY - (float)img.originalHeight / 2.0F, (float)img.originalWidth / 2.0F - img.offsetX, (float)img.originalHeight / 2.0F - img.offsetY, (float)img.packedWidth, (float)img.packedHeight, C.drawScale * Settings.scale, C.drawScale * Settings.scale, C.angle);
        }
        private static void renderElementHelper(SpriteBatch sb, Texture img, float drawX, float drawY, float thingX, float thingY, float angle) {
            sb.setColor(Color.WHITE.cpy());
            sb.draw(img, drawX, drawY,
                    256.0F, 256.0F, 512.0F, 512.0F,
                    thingX, thingY,
                    angle, 0, 0, 125, 125, false, false);

        }

    }
}
