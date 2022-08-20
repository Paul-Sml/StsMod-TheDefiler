package theDefiler.patch;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.defiler.Emergency;
import theDefiler.cards.defiler.SpearsShake;

@SpirePatch (clz = AbstractCard.class, method = "canUpgrade")
public class EmergencyPatch {

    public static SpireReturn<Boolean> Prefix(AbstractCard __instance) {
        if (AbstractDungeon.player != null) {
            for (AbstractCard c : AbstractDungeon.player.masterDeck.group) {
                if (c.cardID.equals(Emergency.ID) && !c.upgraded) {
                    return SpireReturn.Return(__instance.cardID.equals(Emergency.ID));
                }
            }
        }
        return SpireReturn.Continue();
    }
}
