package theDefiler.patch;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.screens.CardRewardScreen;
import theDefiler.cards.AbstractDefilerCard;

@SpirePatch(clz = CardRewardScreen.class, method = "acquireCard")
public class DraftedPatch {

    public static void Postfix(AbstractCard card){

        if (card instanceof AbstractDefilerCard) {
            ((AbstractDefilerCard) card).drafted();
        }

    }

}
