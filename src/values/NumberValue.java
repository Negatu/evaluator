package evaluator.values;

import evaluator.values.Value;

public class NumberValue extends Value {

    private double number;

    public NumberValue(double number) {
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Double.toString(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NumberValue) {
            NumberValue other = (NumberValue) obj;
            return number == other.number;
        }
        return false;
    }

}
