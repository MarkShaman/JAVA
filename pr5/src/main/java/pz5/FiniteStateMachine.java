package pz5;

public class FiniteStateMachine {
    // Стан зберігаємо як рядок ("S", "1", "2", "3", "F")
    protected String state = "S";

    public String processString(String text) {
        // Скидаємо стан перед кожним новим рядком
        this.state = "S";

        // Проходимо по кожному символу рядка
        for (char ch : text.toCharArray()) {

            // Якщо ми вже в фінальному стані, залишаємось там (петля *)
            if (this.state.equals("F")) {
                continue;
            }

            // Логіка переходів згідно з діаграмою
            switch (this.state) {
                case "S":
                    if (ch == 'T') this.state = "1";
                    else this.state = "S"; // !T
                    break;

                case "1":
                    if (ch == 'E') this.state = "2";
                    else this.state = "S"; // !E (Тут криється баг для "TTEST")
                    break;

                case "2":
                    if (ch == 'S') this.state = "3";
                    else this.state = "S"; // !S
                    break;

                case "3":
                    if (ch == 'T') this.state = "F";
                    else this.state = "S"; // !T
                    break;
            }
        }
        return this.state;
    }
}
