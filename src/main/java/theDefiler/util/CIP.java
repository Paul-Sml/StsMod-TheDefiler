package theDefiler.util;

import basemod.abstracts.CustomSavable;

import static theDefiler.DefilerMod.canIgnorePath;
import static theDefiler.DefilerMod.canIgnorePathLoadIgnore;

public class CIP implements CustomSavable<Boolean> {
    public final static String SaveKey = "CIPKey";

    @Override
    public Boolean onSave() {
        return canIgnorePath;
    }

    @Override
    public void onLoad(Boolean aBoolean) {
        if (aBoolean!=null) {
            canIgnorePath = aBoolean;
            canIgnorePathLoadIgnore = aBoolean;
        }
    }
}
