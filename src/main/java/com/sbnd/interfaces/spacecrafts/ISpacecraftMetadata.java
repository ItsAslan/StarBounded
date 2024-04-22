package com.sbnd.interfaces.spacecrafts;

import com.sbnd.api.Vector3Pos;

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
        private final Vector3Pos pos;
        private final ThrusterTier tier;
        private final double thrusterForce;
        private final float drain;

        enum ThrusterTier
        {
            SINGLE_USE,
            MULTIPLE_USE
        }

        public Thruster(Vector3Pos pos, double thrusterForce, float drain, ThrusterTier tier) {

            this.pos = pos;
            this.thrusterForce = thrusterForce;
            this.drain = drain;

            this.tier = tier;

        }

        public Vector3Pos getPos()
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
        private final Vector3Pos pos;
        private final float speedMultiplier;

        public Fin(Vector3Pos pos, float speedMultiplier) {
            this.pos = pos;
            this.speedMultiplier = speedMultiplier;
        }

        public Vector3Pos getPos()
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
        private final Vector3Pos pos;
        private final float speedMultiplier;
        private final byte height; // Used to dictate how tall and aerodynamic the Nose / Noses make the spacecraft


        public Nose(Vector3Pos pos, float speedMultiplier, byte height) {
            this.pos = pos;
            this.speedMultiplier = speedMultiplier;
            this.height = height;
        }

        public Vector3Pos getPos()
        {
            return pos;
        }

        public float getSpeedMultiplier()
        {
            return speedMultiplier;
        }

        public byte getHeight()
        {
            return height;
        }
    }

}
