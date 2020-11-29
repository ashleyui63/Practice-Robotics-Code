package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class SteelTalonController extends WPI_VictorSPX
{

    private  boolean reverse;
    private double bias;


    public SteelTalonController(int deviceNumber, boolean reverse, double bias)
    {
        super(deviceNumber);
        this.reverse = reverse;
        this.bias = bias;
        setInverted(reverse);
    }
    @Override
    public void set(double speed)
    {
        super.set(speed * bias);
    }

    public void setReverse(boolean reverse)
    {
        this.reverse = reverse;
    }

    public void setBias(double bias)
    {
        this.bias = bias;
    }

    public boolean getReverse()
    {
        return reverse;
    }

    public double getBias()
    {
        return bias;
    }



}