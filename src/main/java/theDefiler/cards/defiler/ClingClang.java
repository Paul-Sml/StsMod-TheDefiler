package theDefiler.cards.defiler;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rewards.RewardItem;
import theDefiler.actions.DefilerDigAction;
import theDefiler.actions.GainMaxhpAction;
import theDefiler.cards.AbstractDefilerCard;

import static theDefiler.DefilerMod.makeID;

public class ClingClang extends AbstractDefilerCard {
    public final static String ID = makeID(ClingClang.class.getSimpleName());
    // intellij stuff power, self, uncommon

    private static final int COST = 0;
    private static final int GOLD_COST = 5;

    public ClingClang() {
        super(ID, COST, GOLD_COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DefilerDigAction(magicNumber, c -> c.upgraded));
    }

    public void drafted() {
        if (!upgraded)
            AbstractDungeon.getCurrRoom().addCardToRewards();
        else {
            RewardItem cardReward = new RewardItem();
            if (cardReward.cards.size() > 0) {
                for (int i = 0; i < cardReward.cards.size(); i++) {
                    if (!cardReward.cards.get(i).upgraded)
                        cardReward.cards.get(i).upgrade();
                }
                AbstractDungeon.getCurrRoom().rewards.add(cardReward);
            }
        }
    }

    public void upp() {
        upgradeMagicNumber(2);
    }
}
