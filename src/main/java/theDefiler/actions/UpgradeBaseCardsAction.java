//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package theDefiler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;

import java.util.Iterator;

public class UpgradeBaseCardsAction extends AbstractGameAction {
    public UpgradeBaseCardsAction() {
        this.duration = Settings.ACTION_DUR_MED;
        this.actionType = ActionType.WAIT;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_MED) {
            AbstractPlayer p = AbstractDungeon.player;
            this.upgradeAllCardsInGroup(p.hand);
            this.upgradeAllCardsInGroup(p.drawPile);
            this.upgradeAllCardsInGroup(p.discardPile);
            this.upgradeAllCardsInGroup(p.exhaustPile);
            this.isDone = true;
        }

    }

    private void upgradeAllCardsInGroup(CardGroup cardGroup) {
        Iterator var2 = cardGroup.group.iterator();

        while(var2.hasNext()) {
            AbstractCard c = (AbstractCard)var2.next();
            if (c.rarity == AbstractCard.CardRarity.BASIC && !c.upgraded) {
                if (cardGroup.type == CardGroup.CardGroupType.HAND) {
                    c.superFlash();
                }


                c.upgrade();
                if (c.baseDamage > -1)
                    c.upgradedDamage = true;
                if (c.baseBlock > -1)
                    c.upgradedBlock = true;
                CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(c.cardID);
                c.upgraded=true;
                if (c.timesUpgraded>1)
                    c.name = cardStrings.NAME + "+" + c.timesUpgraded;

                c.initializeDescription();
                /*else
                    c.name = cardStrings.NAME + "+";*/
                c.applyPowers();
            }
        }

    }
}

