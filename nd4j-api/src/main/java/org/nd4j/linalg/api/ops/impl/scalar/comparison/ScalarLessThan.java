package org.nd4j.linalg.api.ops.impl.scalar.comparison;

import org.nd4j.linalg.api.complex.IComplexNumber;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseScalarOp;
import org.nd4j.linalg.api.ops.Op;
import org.nd4j.linalg.factory.Nd4j;

/**
 * Return a binary (0 or 1) when less than a number
 * @author Adam Gibson
 */
public class ScalarLessThan extends BaseScalarOp {
    public ScalarLessThan(INDArray x, INDArray y, INDArray z, int n, Number num) {
        super(x, y, z, n, num);
    }

    public ScalarLessThan(INDArray x, Number num) {
        super(x, num);
    }

    public ScalarLessThan(INDArray x, INDArray y, INDArray z, int n, IComplexNumber num) {
        super(x, y, z, n, num);
    }

    public ScalarLessThan(INDArray x, IComplexNumber num) {
        super(x, num);
    }

    @Override
    public String name() {
        return "lessthan_scalar";
    }

    @Override
    public IComplexNumber op(IComplexNumber origin, double other) {
        return origin.absoluteValue().doubleValue() < num.doubleValue() ? Nd4j.createComplexNumber(1, 0) : Nd4j.createComplexNumber(0,0);
    }

    @Override
    public IComplexNumber op(IComplexNumber origin, float other) {
        return origin.absoluteValue().doubleValue() < num.doubleValue() ? Nd4j.createComplexNumber(1,0) : Nd4j.createComplexNumber(0,0);
    }

    @Override
    public IComplexNumber op(IComplexNumber origin, IComplexNumber other) {
        return origin.absoluteValue().doubleValue() < num.doubleValue() ? Nd4j.createComplexNumber(1,0) : Nd4j.createComplexNumber(0,0);
    }

    @Override
    public float op(float origin, float other) {
        return origin < num.floatValue() ? 1 : 0;

    }

    @Override
    public double op(double origin, double other) {
        return origin < num.floatValue() ? 1 : 0;

    }

    @Override
    public double op(double origin) {
        return origin < num.floatValue() ? 1 : 0;

    }

    @Override
    public float op(float origin) {
        return origin < num.floatValue() ? 1 : 0;

    }

    @Override
    public IComplexNumber op(IComplexNumber origin) {
        return origin.absoluteValue().doubleValue() < num.doubleValue() ? Nd4j.createComplexNumber(1,0) : Nd4j.createComplexNumber(0,0);
    }

    @Override
    public Op opForDimension(int index, int dimension) {
        if(num != null)
            return new ScalarLessThan(x.vectorAlongDimension(index,dimension),num);
        else
            return new ScalarLessThan(x.vectorAlongDimension(index, dimension),complexNumber);
    }
}
