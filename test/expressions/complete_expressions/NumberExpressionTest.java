package evaluator.expressions.complete_expressions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class NumberExpressionTest {

    @Test
    public void equals_withSameNumber_returnsTrue() {
        NumberExpression numberExpression = new NumberExpression(7);
        NumberExpression otherNumberExpression = new NumberExpression(7);

        assertThat(numberExpression).isEqualTo(otherNumberExpression);
    }

    @Test
    public void equals_withDifferentNumber_returnsFalse() {
        NumberExpression numberExpression = new NumberExpression(7);
        NumberExpression otherNumberExpression = new NumberExpression(13);

        assertThat(numberExpression).isNotEqualTo(otherNumberExpression);
    }

}
