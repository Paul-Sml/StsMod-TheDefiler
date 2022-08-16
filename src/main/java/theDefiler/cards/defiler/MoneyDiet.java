package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.actions.GainMaxhpAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class MoneyDiet extends AbstractDefilerCard {
    public final static String ID = makeID(MoneyDiet.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int GOLD_COST = 10;
    private static final int UPGRADED_GOLD_COST = 5;

    public MoneyDiet() {
        super(ID, COST, GOLD_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 9;
        magicNumber = baseMagicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DamageAction(p, new DamageInfo(p, magicNumber, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.NONE));
        block();
    }

    public void upp() {
        upgradeBlock(2);
        upgradeMagicNumber(-1);
        upBgc(UPGRADED_GOLD_COST);
    }
}
