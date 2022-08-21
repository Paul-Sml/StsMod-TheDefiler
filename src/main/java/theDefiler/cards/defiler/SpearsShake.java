package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class SpearsShake extends AbstractDefilerCard {
    public final static String ID = makeID(SpearsShake.class.getSimpleName());
    // intellij stuff power, self, uncommon
    private static AbstractCard c = new DomisdrawsSpear();

    private static final int COST = -2;

    public SpearsShake() {
        super(ID, COST, CardType.CURSE, CardRarity.CURSE, CardTarget.NONE);
        //cardToPreview.add(c);
    }

    @Override
    public void onRemoveFromMasterDeck() {
        AbstractPlayer p = AbstractDungeon.player;
        for(AbstractCard c : p.masterDeck.group) {
            p.masterDeck.removeCard(DomisdrawsSpear.ID);
            break;
        }
    }

    public void use(AbstractPlayer p, AbstractMonster m) {}

    public void upp() {}
}
