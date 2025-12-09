
package pz5;
public class Main {
    public static void main(String[] args) {
        // Перевірка звичайного автомата
        System.out.println("--- Basic FSM ---");
        FiniteStateMachine fsm = new FiniteStateMachine();
        System.out.println("abcTESTabc -> " + fsm.processString("abcTESTabc")); // F
        System.out.println("abcTES     -> " + fsm.processString("abcTES"));     // 3
        System.out.println("TTEST      -> " + fsm.processString("TTEST"));      // Помилка логіки схеми (не F)

        System.out.println("\n--- Smart FSM (Task *) ---");
        SmartFiniteStateMachine smartFsm = new SmartFiniteStateMachine();
        System.out.println("TTEST      -> " + smartFsm.processString("TTEST")); // F (Виправлено)
        System.out.println("TETEST     -> " + smartFsm.processString("TETEST")); // F (Виправлено)
    }
}
