package theDefiler.util;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import theDefiler.cards.AbstractDefilerCard;

import java.util.EnumMap;
import java.util.Map;

public class SingleViewWeightRender {

    private static final Texture BIG_GOLD_ICON = ImageMaster.loadImage("thedefilermodResources/images/1024/panelGoldBag.png");
    private static final Texture BIG_HP_ICON = ImageMaster.loadImage("thedefilermodResources/images/1024/panelHeart.png");
    private static float yOffset = 120.0F * Settings.scale;
    private static float centerX = (float)Settings.WIDTH / 2.0F;
    private static float centerY = (float)Settings.HEIGHT / 2.0F;


    private static void renderElementHelper(SpriteBatch sb, Texture img, float drawX, float drawY) {

        sb.draw(img, drawX, drawY,
                0, 0, 164.0F, 164.0F,
                Settings.scale,  Settings.scale,
                0, 0, 0, 164, 164, false, false);

    }

    public static void renderElementCost(AbstractDefilerCard card, SpriteBatch sb){

        float fScaleX = FontHelper.SCP_cardEnergyFont.getData().scaleX;

        FontHelper.SCP_cardEnergyFont.getData().setScale(0.75F);

        if(!card.isLocked && card.isSeen) {

            // <----------

            if (card.goldCost >= 0) {

                renderElementHelper(sb, BIG_GOLD_ICON, centerX - 348.0F * Settings.scale,
                        centerY + 163.0F * Settings.scale);

                Color c = Settings.CREAM_COLOR;

                float dualDigitCostOffset = 682.0F;
                if (card.goldCost >= 10)
                    dualDigitCostOffset -= 25.0F;

                FontHelper.renderFont(sb, FontHelper.SCP_cardEnergyFont, card.goldCost+"", dualDigitCostOffset * Settings.scale,
                        (float)Settings.HEIGHT / 2.0F + 268.0F * Settings.scale, c);

                if (card.maxhpCost >= 0) {

                    renderElementHelper(sb, BIG_HP_ICON, centerX - 348.0F * Settings.scale,
                            centerY + 43.0F * Settings.scale);

                    FontHelper.renderFont(sb, FontHelper.SCP_cardEnergyFont, card.maxhpCost+"", 682.0F * Settings.scale,
                            (float)Settings.HEIGHT / 2.0F + 148.0F * Settings.scale, c);

                }
            } else
            if (card.maxhpCost >= 0) {

                renderElementHelper(sb, BIG_HP_ICON, centerX - 348.0F * Settings.scale,
                        centerY + 163.0F * Settings.scale);

                Color c = Settings.CREAM_COLOR;
                FontHelper.renderFont(sb, FontHelper.SCP_cardEnergyFont, card.maxhpCost+"", 682.0F * Settings.scale,
                        (float)Settings.HEIGHT / 2.0F + 268.0F * Settings.scale, c);

            }

        }
        FontHelper.SCP_cardEnergyFont.getData().setScale(fScaleX);
    }


}
