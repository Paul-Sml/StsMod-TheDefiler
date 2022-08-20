package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.GainGoldDefilerAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class SearingMoney extends AbstractDefilerCard {
    public final static String ID = makeID(SearingMoney.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public SearingMoney() {
        super(ID, COST, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 20;
        secondMagic = baseSecondMagic = 4;
        cardToPreview.add(new Burn());
        cardToPreview.add(new ScorchingHand());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dig(secondMagic, c -> c instanceof AbstractDefilerCard && ((AbstractDefilerCard)c).maxhpCost > 1);
        atb(new GainGoldDefilerAction(magicNumber));
        atb(new MakeTempCardInDrawPileAction(new Burn(), 2, true ,true));
        atb(new MakeTempCardInDrawPileAction(new ScorchingHand(), 1, true ,true));
    }

    @Override
    public void dug() {
        atb(new MakeTempCardInHandAction(cardsToPreview));
    }

    public void upp() {
        upgradeDamage(4);
    }
}
