package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.Vajra;
import theDefiler.actions.GainMaxhpAction;
import theDefiler.cards.AbstractDefilerCard;
import theDefiler.relics.Antibodies;

import static theDefiler.DefilerMod.makeID;

public class Antibody extends AbstractDefilerCard {
    public final static String ID = makeID(Antibody.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 1;

    public Antibody() {
        super(ID, COST, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new GainMaxhpAction(magicNumber));
    }

    public void drafted() {
        relicObtain();
    }

    public void onRemoveFromMasterDeck() {
        relicObtain();
    }

    private void relicObtain() {
        AbstractPlayer p = AbstractDungeon.player;
        if (!p.hasRelic(Antibodies.ID)) {
            AbstractDungeon.getCurrRoom().spawnRelicAndObtain(500, 500, RelicLibrary.getRelic(Antibodies.ID).makeCopy());
        } else {
            p.getRelic(Antibodies.ID).counter++;
        }
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}
