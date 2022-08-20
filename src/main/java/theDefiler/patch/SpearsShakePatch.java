package theDefiler.patch;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePostfixPatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.screens.CardRewardScreen;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.cards.defiler.SpearsShake;


@SpirePatch (clz = AbstractCard.class, method = "calculateCardDamage")
public class SpearsShakePatch {

    public static void Postfix(AbstractCard __instance, AbstractMonster mo){

        AbstractPlayer p = AbstractDungeon.player;

        for (int i = 0; i < p.hand.group.size(); i++) {
            if (p.hand.group.get(i).cardID.equals(SpearsShake.ID)){
                __instance.damage /= 2.0F;
                if (__instance.baseDamage != __instance.damage)
                    __instance.isDamageModified = true;
            }
        }
    }

}
@SpirePatch (clz = AbstractCard.class, method = "applyPowers")
class SpearsShakePatchTwo {

    public static void Postfix(AbstractCard __instance){

        AbstractPlayer p = AbstractDungeon.player;

        for (int i = 0; i < p.hand.group.size(); i++) {
            if (p.hand.group.get(i).cardID.equals(SpearsShake.ID)){
                __instance.damage /= 2.0F;
                if (__instance.baseDamage != __instance.damage)
                    __instance.isDamageModified = true;
            }
        }
    }

}
