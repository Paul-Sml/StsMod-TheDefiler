package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class BarbedWhip extends AbstractDefilerCard {
    public final static String ID = makeID(BarbedWhip.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public BarbedWhip() {
        super(ID, COST, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        baseDamage = 12;
        magicNumber=baseMagicNumber=2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DamageAction(p, new DamageInfo(p, magicNumber, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.NONE));
        dmg(m);
    }

    public void upp() {
        upgradeDamage(3);
        upgradeMagicNumber(-1);
    }
}
