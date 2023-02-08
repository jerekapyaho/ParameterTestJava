import java.util.Formatter;

public class Pan implements Parameter {
    public Pan() {
        this.setValue(this.getDefaultValue());
    }

    public Pan(int value) {
        this.setValue(value);
    }

    // Implements the setValue(int) method of the Parameter interface.
    // Relies on the default implementation of isValid for checking.
    public void setValue(int value) {
        if (this.isValid(value)) {
            this.value = value;
        }
        else {
            StringBuilder sb = new StringBuilder();
            Formatter fmt = new Formatter(sb);
            fmt.format(
                "%s must be between %d and %d (was %d)",
                this.getName(), 
                this.getMinimumValue(), 
                this.getMaximumValue(),
                value
            );
            fmt.close();
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public int getMinimumValue() {
        return -7;
    }

    public int getMaximumValue() {
        return 7;
    }

    public int getDefaultValue() {
        return 0;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return "Pan";
    }

    @Override
    public String toString() {
        int min = this.getMinimumValue();
        int max = this.getMaximumValue();
        int length = max - min + 1;
        int place = this.getValue() - min;

        StringBuffer line = new StringBuffer("-".repeat(length));
        line.setCharAt(Math.abs(min), '0');
        line.setCharAt(place, 'X');
        
        return this.getName() + ": L|" + line.toString() + "|R ";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter)object;
        return other.getValue() == this.getValue();
    }

    @Override
    public int hashCode() {
        return this.getValue();
    }

    private int value;
}
