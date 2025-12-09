package pz5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// 1. Вказуємо, що цей клас буде запускатись параметризованим ранером
@RunWith(Parameterized.class)
public class FsmTest {

    private final String input;
    private final String expectedState;

    // 2. Конструктор, у який будуть передаватись дані
    public FsmTest(String input, String expectedState) {
        this.input = input;
        this.expectedState = expectedState;
    }

    // 3. Метод, що повертає список даних для тестів
    // { "Вхідний рядок", "Очікуваний стан" }
    @Parameterized.Parameters(name = "{index}: Input=\"{0}\" -> Expected={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // --- Базові кейси (Завдання 1-2) ---
                {"abcTESTabc", "F"},
                {"TEST",       "F"},
                {"abcTES",     "3"},
                {"abcTE",      "2"},
                {"abcT",       "1"},
                {"no match",   "S"},
                {"",           "S"},

                // --- Складні кейси "із зірочкою" (Завдання 3) ---
                {"TTEST",      "F"}, // Smart-автомат має це пройти
                {"TETEST",     "F"},
                {"TES_TEST",   "F"},
                {"TTTTEST",    "F"}
        });
    }

    // 4. Сам тест. Він простий, бо дані приходять ззовні.
    // Ми тестуємо саме SmartFiniteStateMachine, бо він має проходити ВСІ тести (і прості, і складні).
    @Test
    public void testSmartFsmLogic() {
        SmartFiniteStateMachine smartFsm = new SmartFiniteStateMachine();

        String actualState = smartFsm.processString(this.input);

        assertEquals("Помилка обробки рядка: " + this.input,
                this.expectedState,
                actualState);
    }
}