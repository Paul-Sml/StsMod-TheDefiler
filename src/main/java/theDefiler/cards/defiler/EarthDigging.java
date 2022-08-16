package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.DefilerDigAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class EarthDigging extends AbstractDefilerCard {
    public final static String ID = makeID(EarthDigging.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public EarthDigging() {
        super(ID, COST, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        magicNumber = baseMagicNumber = 3;
        cardToPreview.add(new TombDigging());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.rarity == CardRarity.BASIC));
    }

    @Override
    public void onRemoveFromMasterDeck() {
        atb(new AddCardToDeckAction(cardsToPreview));
    }

    public void upp() {
        upgradeMagicNumber(1);
        upgradeCardToPreview();
        uDesc();
    }
}
