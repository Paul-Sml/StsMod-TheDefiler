package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.powers.DivineStormPower;
import theDefiler.powers.MudCannonPower;

import static theDefiler.DefilerMod.makeID;

public class MudCannon extends AbstractDefilerCard {
    public final static String ID = makeID(MudCannon.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 2;

    public MudCannon() {
        super(ID, COST, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        magicNumber = baseMagicNumber = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        power(new MudCannonPower(p, magicNumber), magicNumber);
    }

    @Override
    public void dug() {
        AbstractPlayer p = AbstractDungeon.player;
        power(new MudCannonPower(p, magicNumber), magicNumber);
    }

    public void upp() {
        upMagic(1);
    }
}
