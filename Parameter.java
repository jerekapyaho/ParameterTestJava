interface Parameter {
    int getMinimumValue();
    int getMaximumValue();
    int getDefaultValue();
    int getValue();

    default boolean isValid(int value) {
        return 
            (value >= this.getMinimumValue()) && 
            (value <= this.getMaximumValue()); 
    }

    void setValue(int value);

    String getName();
}
