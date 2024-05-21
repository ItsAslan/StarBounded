package com.sbnd.main;

import com.sbnd.blocks.multiblock.base.ControllerBase;

import java.util.ArrayList;

public class MultiblockManager {

    public static ArrayList<ControllerBase> controllers = new ArrayList<>();

    public static ArrayList<ControllerBase> toDeleteCache = new ArrayList<>();

    public static void tickMultiblocks() {

        if(controllers.size() > 0) {

            for(ControllerBase controller : controllers) {
                controller.tick();
            }

            checkTerminations();

        }

    }

    private static void checkTerminations() {
        for(ControllerBase controller : toDeleteCache) {
            controllers.remove(controller);
        }

        toDeleteCache.clear();
    }

    public static void registerMultiblock(ControllerBase controller) {
        controllers.add(controller);
    }

    public static void terminateMultiblock(ControllerBase controller) {
        toDeleteCache.add(controller);
    }

}
