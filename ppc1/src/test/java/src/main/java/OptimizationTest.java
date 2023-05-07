package src.main.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class OptimizationTest {

    @Test
    public void Opt_BC_Test_middle()
    {
        int Grape_Cap = 5000;
        int Labor_Cap = 12000;
        double Rose_Prc = 12.5;
        double Noir_Prc = 23.5;
        int opt_rev = 24119;
        Optimization opt = new Optimization();
        int exp_rev = (int)opt.Opt_BC(Grape_Cap, Labor_Cap, Rose_Prc, Noir_Prc)[0];
        assertEquals(opt_rev, exp_rev,5);
    }

    @Test
    public void Opt_BC_Test_ZeroCap()
    {
        int Grape_Cap = 0;
        int Labor_Cap = 0;
        double Rose_Prc = 12.5;
        double Noir_Prc = 23.5;
        int opt_rev = 0;
        Optimization opt = new Optimization();
        int exp_rev = (int)opt.Opt_BC(Grape_Cap, Labor_Cap, Rose_Prc, Noir_Prc)[0];
        assertEquals(opt_rev, exp_rev,5);
    }

}