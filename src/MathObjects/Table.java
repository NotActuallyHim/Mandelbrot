package MathObjects;
public class Table {
    private double[] x;
    private double[] y;

    
    public Table(double[] xArr, double[] yArr){
        this.x = xArr;
        this.y = yArr;
    }

    public double[] getX(){
        return this.x;
    }

    public double[] getY(){
        return this.y;
    }

    public Table ConvertX(Rational ratio){
        double[] temp = new double[this.x.length];
        for (int i = 0; i < this.x.length; i++) {
            temp[i] = this.x[i] * ratio.toDouble();
        }
        return new Table(temp, this.y);
    }
  
    public Table ConvertY(Rational ratio){
        double[] temp = new double[this.y.length];
        for (int i = 0; i < this.y.length; i++) {
            temp[i] = this.y[i] * ratio.toDouble();
        }
        return new Table(this.x, temp);
    }


}
