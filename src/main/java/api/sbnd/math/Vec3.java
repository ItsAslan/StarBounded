package api.sbnd.math;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Vec3 {

    public static final Vec3 ORIGIN = new Vec3(0, 0, 0);

    @Getter private final int x;
    @Getter private final int y;
    @Getter private final int z;

}
