public enum CoordinateAxis {
    X, Y, Z;
    
    public int getValue(airplane plane) {
        switch(this) {
            case X: return plane.x;
            case Y: return plane.y;
            case Z: return plane.z;
            default: throw new IllegalArgumentException("Invalid coordinate axis");
        }
    }
}