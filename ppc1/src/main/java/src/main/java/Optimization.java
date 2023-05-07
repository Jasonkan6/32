package src.main.java;

import java.util.Vector;

import static java.lang.Math.min;

public class Optimization {
    int Labor_Rose = 5; //mins
    int Labor_Noir = 12; //mins
    int Grape_Rose = 6; //kgs
    int Grape_Noir = 4;//kgs
    int Prod_Cap = 5000; //litre
    int Labor_Rate  = 935 / (int)(37.5 * 60);
    public Object[] Opt_A(int Cap_Grape_Int_A, int Cap_Labor_Int_A, float Prc_Rose_Float_A, float Prc_Noir_Float_A, int Fixed_Costs_A){
        int Opt_Profit = 0;
        int x_out = 0;
        int y_out = 0;
        float Opt_Margin = 0;

        for (int i = 0; i <= min(Cap_Grape_Int_A / Grape_Rose, Cap_Labor_Int_A / Labor_Rose); i++) {
            for (int j = 0; j <= min(Cap_Grape_Int_A / Grape_Noir, Cap_Labor_Int_A / Labor_Noir); j++) {
                if (i * Grape_Rose + j * Grape_Noir <= Cap_Grape_Int_A &&
                        i * Labor_Rose + j * Labor_Noir <= Cap_Labor_Int_A) {
                    int VCL = (Labor_Rose * i + Labor_Noir * j) * Labor_Rate ;
                    float SR = i * Prc_Rose_Float_A + j * Prc_Noir_Float_A;
                    float GP = SR - VCL - Fixed_Costs_A;
                    if (GP > Opt_Profit) {
                        Opt_Profit = (int) GP;
                        x_out = i;
                        y_out = j;
                        Opt_Margin = (float)Opt_Profit / SR *100;
                    }
                }
            }
        }
        return new Object[]{Opt_Profit, x_out, y_out, Opt_Margin};
    };
    public Object[] Opt_BC(int Grape_Cap, int Labor_Cap, double Rose_Prc, double Noir_Prc){
        int opt_rose = 0;
        int opt_noir = 0;
        int opt_rev = 0;
        for (int i = 0; i<=Grape_Cap/Grape_Rose; i++) // iterate through possible litres of grape rose
        {
            for (int j = 0; j<=Grape_Cap/Grape_Noir; j++) // iterate through possible litres of grape noir
            {
                if (Grape_Rose*i+Grape_Noir*j<=Grape_Cap && i*Labor_Rose+j*Labor_Noir<=Labor_Cap)
                {
                    double revenue = i*Rose_Prc + j*Noir_Prc;
                    if (revenue>opt_rev)
                    {
                        opt_rose = i;
                        opt_noir = j;
                        opt_rev = (int)revenue;
                    }
                }
            }
        }

        return new Object[]{opt_rev, opt_rose, opt_noir};
    }
}
