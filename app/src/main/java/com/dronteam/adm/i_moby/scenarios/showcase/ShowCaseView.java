package com.dronteam.adm.i_moby.scenarios.showcase;

import com.dronteam.adm.i_moby.common.CallBack;
import com.dronteam.adm.i_moby.common.CommonView;
import com.dronteam.adm.i_moby.scenarios.special_offer.SpecialOffersAdapter;

/**
 * Created by smb on 13/12/2016.
 */

public interface ShowcaseView extends CommonView {

    void setOnButtonClick(CallBack callBack);
    void setList(SpecialOffersAdapter adapter);

}