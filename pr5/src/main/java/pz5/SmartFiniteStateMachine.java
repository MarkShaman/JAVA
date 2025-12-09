package pz5;

public class SmartFiniteStateMachine extends FiniteStateMachine {

    @Override
    public String processString(String text) {
        this.state = "S"; // Скидання стану

        for (char ch : text.toCharArray()) {
            // Якщо вже знайшли фініш - далі не перевіряємо
            if (this.state.equals("F")) {
                break;
            }

            switch (this.state) {
                case "S":
                    if (ch == 'T') this.state = "1";
                    else this.state = "S";
                    break;

                case "1": // Маємо "T"
                    if (ch == 'E') this.state = "2";
                    else if (ch == 'T') this.state = "1"; // "TT..." -> лишаємось в "1"
                    else this.state = "S";
                    break;

                case "2": // Маємо "TE"
                    if (ch == 'S') this.state = "3";
                    else if (ch == 'T') this.state = "1"; // "TET..." -> це нова "T"
                    else this.state = "S";
                    break;

                case "3": // Маємо "TES"
                    if (ch == 'T') this.state = "F";      // "TEST" -> Успіх
                    else this.state = "S";                // Будь-що інше ламає послідовність
                    break;
            }
        }
        return this.state;
    }
}