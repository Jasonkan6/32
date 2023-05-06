package src.main.java;

import static org.junit.jupiter.api.Assertions.*;
class functionCControllerTest {

    @org.junit.jupiter.api.Test
    void run_button_C() {

        int Cap_Labor_Int = 100;
        int Cap_Grape_Int = 200;
        int Bko_Rose_Int = 2;
        int Bko_Noir_Int = 3;
        int Labor_Rose = 10;
        int Labor_Noir = 15;
        int Grape_Rose = 5;
        int Grape_Noir = 8;
        float Prc_Rose_Float = 25.0f;
        float Prc_Noir_Float = 30.0f;

        int remainingLaborCapacity = Cap_Labor_Int - Bko_Rose_Int * Labor_Rose - Bko_Noir_Int * Labor_Noir;
        int remainingGrapeCapacity = Cap_Grape_Int - Bko_Rose_Int * Grape_Rose - Bko_Noir_Int * Grape_Noir;
        boolean Bko_fulfill = remainingLaborCapacity > 0 && remainingGrapeCapacity > 0;
        int Opt_Rose = 0;
        int Opt_Noir = 0;
        int Opt_Revenue = 0;

        if (Bko_fulfill) {
            for (int i = 0; i <= min(remainingGrapeCapacity / Grape_Rose, remainingLaborCapacity / Labor_Rose); i++) {
                for (int j = 0; j <= min(remainingGrapeCapacity / Grape_Noir, remainingLaborCapacity / Labor_Noir); j++) {
                    if (i * Grape_Rose + j * Grape_Noir <= remainingGrapeCapacity &&
                            i * Labor_Rose + j * Labor_Noir <= remainingLaborCapacity) {
                        float revenue = i * Prc_Rose_Float + j * Prc_Noir_Float;
                        if (revenue > Opt_Revenue) {
                            Opt_Revenue = (int) revenue;
                            Opt_Rose = i;
                            Opt_Noir = j;
                        }
                    }
                }
            }
        }

        assertEquals(20, remainingLaborCapacity);
        assertEquals(80, remainingGrapeCapacity);
        assertTrue(Bko_fulfill);
        assertEquals(480, Opt_Revenue);
        assertEquals(8, Opt_Rose);
        assertEquals(5, Opt_Noir);
    }
}