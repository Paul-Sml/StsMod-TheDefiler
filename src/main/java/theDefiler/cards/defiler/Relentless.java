package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NoDrawPower;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.NoBlockDefilerPower;

import static theDefiler.DefilerMod.makeID;

public class Relentless extends AbstractDefilerCard {
    public final static String ID = makeID(Relentless.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int GOLD_COST = 15;

    public Relentless() {
        super(ID, COST, GOLD_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        secondMagic = baseSecondMagic = 4;
        magicNumber = baseMagicNumber = 3;
        baseBlock = 7;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (AbstractDungeon.player.currentBlock <= secondMagic) {
            draw(magicNumber);
            block();

            power(new NoDrawPower(p));
            power(new NoBlockDefilerPower(p));
        }
    }

    public void upp() {
        upMagic(1);
    }
}
