package com.dronteam.adm.i_moby.common.progressbar;

/**
 * Created by adm on 08.07.2017.
 */

public interface TopProgressbarView {
    void startTopProgressbar();
    void stopTopProgressbar();
    void setSwapProgressbarListener(SwapProgressbarListener listener);
}
