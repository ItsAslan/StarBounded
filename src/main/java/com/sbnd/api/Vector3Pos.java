package com.sbnd.api;

import com.sun.istack.internal.NotNull;

import java.util.Objects;
import java.util.Random;

public class Vector3Pos
{
    public long x;
    public long y;
    public long z;

    public Vector3Pos(long x, long y, long z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3Pos add(@NotNull Vector3Pos otherVec)
    {
        return new Vector3Pos(this.x + otherVec.x, this.y + otherVec.y, this.z + otherVec.z);
    }

    public Vector3Pos subtract(@NotNull Vector3Pos otherVec)
    {
        return new Vector3Pos(this.x - otherVec.x, this.y - otherVec.y, this.z = otherVec.z);
    }

    public Vector3Pos multiply(long scalar)
    {
        return new Vector3Pos(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public long dot(@NotNull Vector3Pos otherVec)
    {
        return this.x * otherVec.x + this.y * otherVec.y + this.z * otherVec.z;
    }

    public double magnitude()
    {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }

    public Vector3Pos normalize()
    {
        double magnitude = magnitude();
        if(magnitude == 0)
        {
            return new Vector3Pos(0, 0, 0);
        }
        return new Vector3Pos((long)(this.x / magnitude), (long)(this.y / magnitude), (long)(this.z / magnitude));
    }

    public Vector3Pos cross(@NotNull Vector3Pos otherVec)
    {
        return new Vector3Pos(
                this.y * otherVec.z - this.z * otherVec.y,
                this.z * otherVec.x - this.x * otherVec.z,
                this.x * otherVec.y - this.y * otherVec.x
        );
    }

    public double distanceTo(@NotNull Vector3Pos otherVec)
    {
        return Math.sqrt(
                (this.x - otherVec.x) * (this.x - otherVec.x) +
                        (this.y - otherVec.y) * (this.y - otherVec.y) +
                        (this.z - otherVec.z) * (this.z - otherVec.z)
        );
    }

    public boolean equals(@NotNull Vector3Pos otherVec)
    {
        return this.x == otherVec.x && this.y == otherVec.y && this.z == otherVec.z;
    }

    public boolean isZeroVector()
    {
        return this.x == 0 && this.y == 0 && this.z == 0;
    }

    public String toString()
    {
        return String.format("(%d, %d, %d)", this.x, this.y, this.z);
    }

    public long[] toArray()
    {
        return new long[] {this.x, this.y, this.z};
    }

    public int hashCode()
    {
        return Objects.hash(this.x, this.y, this.z);
    }

    // Some nerdy physics stuff ill probably never use but hey, if I want to I can

    public double angleWith(@NotNull Vector3Pos otherVec)
    {
        double dotProduct = this.dot(otherVec);
        double magnitudeProduct = this.magnitude() * otherVec.magnitude();
        return Math.acos(dotProduct / magnitudeProduct);
    }

    public Vector3Pos projectOnto(@NotNull Vector3Pos otherVec)
    {
        double dotProduct = this.dot(otherVec);
        double otherMagnitudeSquared = otherVec.x * otherVec.x + otherVec.y * otherVec.y + otherVec.z * otherVec.z;
        double scalar = dotProduct / otherMagnitudeSquared;
        return otherVec.multiply((long)scalar);
    }

    public Vector3Pos negate()
    {
        return new Vector3Pos(-this.x, -this.y, -this.z);
    }

    public Vector3Pos clampMagnitude(double max)
    {
        double currentMagnitude = this.magnitude();
        if(currentMagnitude > max)
        {
            return this.normalize().multiply((long)max);
        }
        return new Vector3Pos(this.x, this.y, this.z);
    }

    public Vector3Pos rotateAround(@NotNull Vector3Pos axis, double angle)
    {
        double sinHalfAngle = Math.sin(angle / 2);
        double cosHalfAngle = Math.cos(angle / 2);
        double rx = axis.x * sinHalfAngle;
        double ry = axis.y * sinHalfAngle;
        double rz = axis.z * sinHalfAngle;
        Vector3Pos q = new Vector3Pos((long)rx, (long)ry, (long)rz);
        Vector3Pos qConjugate = new Vector3Pos((long)-rx, (long)-ry, (long)-rz);

        Vector3Pos qv = q.cross(this).add(this.multiply((long) cosHalfAngle));
        Vector3Pos qvqc = qv.cross(qConjugate);
        return this.add(qvqc.multiply(2));
    }

    public Vector3Pos reflect(@NotNull Vector3Pos normal)
    {
        double dot = this.dot(normal);
        return normal.multiply((long) (2 * dot)).subtract(this);
    }

    public Vector3Pos lerp(@NotNull Vector3Pos otherVec, double factor)
    {
        return new Vector3Pos(
                (long) (this.x * (1 - factor) + otherVec.x * factor),
                (long) (this.y * (1 - factor) + otherVec.y * factor),
                (long) (this.z * (1 - factor) + otherVec.z * factor)
        );
    }

    public Vector3Pos floor()
    {
        return new Vector3Pos((long)Math.floor(this.x), (long)Math.floor(this.y), (long)Math.floor(this.z));
    }

    public Vector3Pos ceil()
    {
        return new Vector3Pos((long)Math.ceil(this.x), (long)Math.ceil(this.y), (long)Math.ceil(this.z));
    }

    public Vector3Pos abs()
    {
        return new Vector3Pos(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    public Vector3Pos random(long min, long max)
    {
        Random random = new Random();
        return new Vector3Pos(min + random.nextLong() * (max - min), min + random.nextLong() * (max - min), min + random.nextLong() * (max - min));
    }

}
