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
import theDefiler.util.SingleViewWeightRender;

@SpirePatch(
        clz = SingleCardViewPopup.class,
        method = "renderCost",
        paramtypes = {"com.badlogic.gdx.graphics.g2d.SpriteBatch"}
)

public class SingleCardViewPopupPatches {
    public static void Postfix(SingleCardViewPopup __instance, SpriteBatch sb) {
        AbstractCard c = (AbstractCard) ReflectionHacks.getPrivate(__instance, SingleCardViewPopup.class, "card");
        if(c instanceof AbstractDefilerCard) {
            SingleViewWeightRender.renderElementCost((AbstractDefilerCard) c, sb);
        }
    }
}