package theDefiler.cards.defiler;

import basemod.AutoAdd;
import basemod.patches.com.megacrit.cardcrawl.screens.compendium.CardLibraryScreen.NoCompendium;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

@AutoAdd.Ignore
public class ShadowDagger extends AbstractDefilerCard {
    public final static String ID = makeID(ShadowDagger.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public ShadowDagger() {
        super(ID, COST, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        this.misc = 1;
        baseDamage = 15;
        magicNumber = baseMagicNumber = 3;
        this.exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m);
    }

    public void upp() {
        upgradeMagicNumber(2);
    }
}
