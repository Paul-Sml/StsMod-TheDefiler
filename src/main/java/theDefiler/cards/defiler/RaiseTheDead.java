package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.BetterDiscardPileToHandAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.GainGoldDefilerAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class RaiseTheDead extends AbstractDefilerCard {
    public final static String ID = makeID(RaiseTheDead.class.getSimpleName());

    private static final int COST = 0;

    public RaiseTheDead() {
        super(ID, COST, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
        exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DamageAction(p, new DamageInfo(p, 2, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.NONE));
        atb(new BetterDiscardPileToHandAction(magicNumber));
    }
    public void upp() {
        upgradeMagicNumber(1);
        uDesc();
    }
}
