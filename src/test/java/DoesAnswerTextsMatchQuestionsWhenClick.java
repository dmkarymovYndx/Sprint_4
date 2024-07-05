import Page_object.IndexPage;
import Constants.ExpectedTextStrings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DoesAnswerTextsMatchQuestionsWhenClick extends BaseTest {

    private final int index;

    public DoesAnswerTextsMatchQuestionsWhenClick(int index) {
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[] getIndex() {
        return new Object[] {0, 1, 2, 3, 4, 5, 6, 7};
    };

    @Test
    public void checkAnswerTextMatch() {

        IndexPage objIndexPage = new IndexPage(driver);

        objIndexPage.clickQuestionListElement(index);
        String actual = ExpectedTextStrings.TEXT[index];
        Assert.assertEquals("Ошибка: строки не совпадают", objIndexPage.getAnswerElement(index), actual);
    }

}
