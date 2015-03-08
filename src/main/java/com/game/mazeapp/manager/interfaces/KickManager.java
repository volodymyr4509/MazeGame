package com.game.mazeapp.manager.interfaces;

import com.game.mazeapp.entityJSON.KickParamsJSON;
import com.game.mazeapp.entityJSON.KickResponseJSON;

/**
 * Created by Home on 08.03.2015.
 */
public interface KickManager {
    public KickResponseJSON processKick(KickParamsJSON kickParams);
}
