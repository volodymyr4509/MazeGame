package com.game.mazeapp.entity;

import java.util.Date;

/**
 * Created by Acer on 11/20/2014.
 */

//many to many with player/monster. Log all fights(info about all kicks)
public class FightLog {

    private Date kickDate;
    //info about success/failed kick and blocks. Example: "Kicked /monstername/ to head successfully. Blocked hit to stomach"
    private String kickInfo;


}
