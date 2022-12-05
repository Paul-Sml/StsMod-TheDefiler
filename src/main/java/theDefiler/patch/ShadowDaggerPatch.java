package theDefiler.patch;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.GetAllInBattleInstances;
import com.megacrit.cardcrawl.rooms.EventRoom;
import com.megacrit.cardcrawl.screens.CardRewardScreen;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.cards.defiler.ShadowDagger;

import java.util.Iterator;

@SpirePatch(clz = EventRoom.class, method = "onPlayerEntry")
public class ShadowDaggerPatch {

    public static void Postfix(EventRoom thing){

        AbstractPlayer p = AbstractDungeon.player;

        Iterator var1 = AbstractDungeon.player.masterDeck.group.iterator();

        AbstractCard c;
        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c.cardID.equals(ShadowDagger.ID)) {
                c.misc += c.magicNumber;
                c.applyPowers();
                c.baseDamage += c.misc;
                c.isDamageModified = false;
            }
        }

        /*for(var1 = GetAllInBattleInstances.get(c.cardID.equals(ShadowDagger.ID)).iterator(); var1.hasNext(); c.baseDamage = c.misc) {
            c = (AbstractCard)var1.next();
            c.misc += c.magicNumber;
            c.applyPowers();
        }*/


    }

}
