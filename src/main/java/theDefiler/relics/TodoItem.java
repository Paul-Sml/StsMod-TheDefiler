package theDefiler.relics;

import theDefiler.TheDefiler;

import static theDefiler.DefilerMod.makeID;

public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, TheDefiler.Enums.DEFILER_COLOR);
    }
}
