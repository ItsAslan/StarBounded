package com.sbnd.interfaces.spacecrafts;

import com.sbnd.api.BlockCoordinate;

import java.util.List;

public interface ISpacecraftMetadata
{

    List<Thruster> getThrusters();
    List<Fin> getFins();
    List<Nose> getNoses();

    double getMass();
    double getThrust();
    int getTotalFuelDrain();

    class Thruster
    {
        private final BlockCoordinate pos;
        private final ThrusterTier tier;
        private final double thrusterForce;
        private final float drain;

        enum ThrusterTier
        {
            SINGLE_USE,
            MULTIPLE_USE
        }

        public Thruster(BlockCoordinate pos, double thrusterForce, float drain, ThrusterTier tier) {

            this.pos = pos;
            this.thrusterForce = thrusterForce;
            this.drain = drain;

            this.tier = tier;

        }

        public BlockCoordinate getPos()
        {
            return this.pos;
        }

        public double getThrusterForce()
        {
            return this.thrusterForce;
        }

        public float getDrain()
        {
            return this.drain;
        }

        public ThrusterTier getTier()
        {
            return this.tier;
        }
    }

    class Fin
    {
        private final BlockCoordinate pos;
        private final float speedMultiplier;

        public Fin(BlockCoordinate pos, float speedMultiplier) {
            this.pos = pos;
            this.speedMultiplier = speedMultiplier;
        }

        public BlockCoordinate getPos()
        {
            return pos;
        }

        public float getSpeedMultiplier()
        {
            return speedMultiplier;
        }
    }

    class Nose
    {
        private final BlockCoordinate pos;
        private final float speedMultiplier;
        private final int height; // Used to dictate how tall and aerodynamic the Nose / Noses make the spacecraft


        public Nose(BlockCoordinate pos, float speedMultiplier, int height) {
            this.pos = pos;
            this.speedMultiplier = speedMultiplier;
            this.height = height;
        }

        public BlockCoordinate getPos()
        {
            return pos;
        }

        public float getSpeedMultiplier()
        {
            return speedMultiplier;
        }

        public int getHeight()
        {
            return height;
        }
    }

}
