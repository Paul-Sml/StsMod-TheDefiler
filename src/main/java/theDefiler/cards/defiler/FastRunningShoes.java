package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theDefiler.actions.GainMaxhpAction;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.FastRunningShoesPower;
import theDefiler.powers.LambdaPower;

import static theDefiler.DefilerMod.makeID;
import static theDefiler.util.Wiz.addtb;
import static theDefiler.util.Wiz.applyToSelf;

public class FastRunningShoes extends AbstractDefilerCard {
    public final static String ID = makeID(FastRunningShoes.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public FastRunningShoes() {
        super(ID, COST, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new FastRunningShoesPower(p, magicNumber, upgraded));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}
