package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.TheDefiler;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class ForeignKnowledge extends AbstractDefilerCard {
    public final static String ID = makeID(ForeignKnowledge.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public ForeignKnowledge() {
        super(ID, COST, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 5;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
        for (AbstractCard c : p.hand.group) {
            if (c.color != TheDefiler.Enums.DEFILER_COLOR) {
                draw();
                atb(new GainEnergyAction(1));
                break;
            }
        }
    }

    public void upp() {
        upgradeDamage(3);
    }
}
