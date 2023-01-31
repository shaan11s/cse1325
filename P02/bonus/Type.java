public enum Type {
    BIRD(100), DOG(15), CAT(20), FISH(5);

    private double lifespan;

    Type(double lifespan){
        this.lifespan = lifespan;
    }
    public double lifespan(){
        return lifespan;
    }
}
