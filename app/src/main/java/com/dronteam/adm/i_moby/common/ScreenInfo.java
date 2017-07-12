package com.dronteam.adm.i_moby.common;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by danreegly on 12.07.17.
 */

public class ScreenInfo {
    static public float density(Context ctx){
        return ctx.getResources().getDisplayMetrics().density;
    }
    static public Point sizes(Context ctx) {
        WindowManager wm = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return new Point((int)(size.x/density(ctx)),(int)(size.y/density(ctx)));
    }
}
