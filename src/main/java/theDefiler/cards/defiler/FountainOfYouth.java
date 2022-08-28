package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class FountainOfYouth extends AbstractDefilerCard {
    public final static String ID = makeID(FountainOfYouth.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public FountainOfYouth() {
        super(ID, COST, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        revival = baseRevival = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        revival();
    }

    @Override
    public void onRemoveFromMasterDeck() {
        CardGroup removeableCurses = AbstractDungeon.player.masterDeck.getPurgeableCards();
        removeableCurses = removeableCurses.getCardsOfType(CardType.CURSE);

        for (int i = 0; i < removeableCurses.size(); i++) {
            AbstractDungeon.player.masterDeck.removeCard(removeableCurses.getTopCard());
        }
    }


    public void upp() {
        secondRevival = baseSecondRevival = 2;
        uDesc();
    }
}
