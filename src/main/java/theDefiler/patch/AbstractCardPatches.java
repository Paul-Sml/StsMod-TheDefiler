package theDefiler.patch;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import theDefiler.cards.AbstractDefilerCard;

public class AbstractCardPatches {
    //private static TextureAtlas.AtlasRegion SecondEnergyOrbOnCard = theextravagant.UIAtlas.findRegion("OtherEnergyCard");
    @SpirePatch(clz = AbstractCard.class, method = "renderEnergy")
    public static class SecondEnergyRenderPatch {
        @SpirePostfixPatch
        public static void patch(AbstractCard __instance, SpriteBatch sb) {
            if(__instance instanceof AbstractDefilerCard)
            {
                FontHelper.cardEnergyFont_L.getData().setScale(__instance.drawScale);
                //renderHelper(sb, Color.WHITE, SecondEnergyOrbOnCard, __instance.current_x, __instance.current_y, __instance);
                if (((AbstractDefilerCard)__instance).goldCostForTurn > 0)
                    FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(((AbstractDefilerCard)__instance).goldCostForTurn), __instance.current_x, __instance.current_y, -135.0F * __instance.drawScale * Settings.scale, 110.0F * __instance.drawScale * Settings.scale, __instance.angle, false, Color.WHITE);
                if (((AbstractDefilerCard)__instance).maxhpCostForTurn > 0)
                    FontHelper.renderRotatedText(sb, FontHelper.cardEnergyFont_L, Integer.toString(((AbstractDefilerCard)__instance).maxhpCostForTurn), __instance.current_x, __instance.current_y, -135.0F * __instance.drawScale * Settings.scale, 65.0F * __instance.drawScale * Settings.scale, __instance.angle, false, Color.WHITE);
            }
        }
        private static void renderHelper(SpriteBatch sb, Color color, TextureAtlas.AtlasRegion img, float drawX, float drawY, AbstractCard C) {
            sb.setColor(color);
            sb.draw(img, drawX + img.offsetX - (float)img.originalWidth / 2.0F, drawY + img.offsetY - (float)img.originalHeight / 2.0F, (float)img.originalWidth / 2.0F - img.offsetX, (float)img.originalHeight / 2.0F - img.offsetY, (float)img.packedWidth, (float)img.packedHeight, C.drawScale * Settings.scale, C.drawScale * Settings.scale, C.angle);
        }
    }
}
