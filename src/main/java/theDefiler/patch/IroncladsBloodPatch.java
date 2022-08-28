package theDefiler.patch;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.screens.CardRewardScreen;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.relics.IroncladsBlood;

@SpirePatch(clz = AbstractCreature.class, method = "increaseMaxHp")
public class IroncladsBloodPatch {

    public static void Postfix(AbstractCreature __instance, int amount, boolean showEffect){

        if (AbstractDungeon.player.hasRelic(IroncladsBlood.ID)) {
            __instance.heal(amount, true);
            __instance.healthBarUpdatedEvent();
        }

    }
}
