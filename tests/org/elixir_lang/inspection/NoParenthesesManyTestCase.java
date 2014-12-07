package org.elixir_lang.inspection;

import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;

/**
 * Created by luke.imhoff on 12/6/14.
 */
public class NoParenthesesManyTestCase extends LightCodeInsightFixtureTestCase {
    public void testFunctionSpaceEmptyParentheses() {
        myFixture.configureByFiles("FunctionSpaceEmptyParentheses.ex");
        myFixture.enableInspections(NoParenthesesStrict.class);
        myFixture.checkHighlighting();
    }

    @Override
    protected String getTestDataPath() {
        return System.getenv("INTELLIJ_ELIXIR_PATH") + "/testData/org/elixir_lang/inspection/no_parentheses_strict_test_case";
    }
}
