package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class SearingCoins extends AbstractDefilerCard {
    public final static String ID = makeID(SearingCoins.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public SearingCoins() {
        super(ID, COST, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 4;
        secondMagic = baseSecondMagic = 20;
        cardToPreview.add(new ScorchingHand());
        cardToPreview.add(new Burn());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dig(magicNumber, c -> c instanceof AbstractDefilerCard && ((AbstractDefilerCard)c).maxhpCost > 0);
        atb(new GainGoldAction(secondMagic));
        AbstractCard c = new ScorchingHand();
        if (upgraded)
            c.upgrade();
        this.addToBot(new MakeTempCardInDrawPileAction(c, 1, true, true));
        this.addToBot(new MakeTempCardInDrawPileAction(new Burn(), 2, true, true));
    }

    public void upp() {
        uDesc();
        cardToPreview.get(0).upgrade();
    }
}
