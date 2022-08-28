package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.UpgradeBaseCardsAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class LearnYourBasics extends AbstractDefilerCard {
    public final static String ID = makeID(LearnYourBasics.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;

    public LearnYourBasics() {
        super(ID, COST, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new UpgradeBaseCardsAction());
    }

    public void upp() {
        isInnate = true;
        uDesc();
    }
}
