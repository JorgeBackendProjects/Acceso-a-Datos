public class Coche {

    private String modelo, matricula, color;
    private int ano;
    private double kilometros;

    public Coche(){
        modelo=matricula=color="";
        ano=0;
        kilometros=0;
    }

    public Coche(String mo, String ma, String co, int an, double km){
        modelo = mo;
        matricula = ma;
        color = co;
        ano = an;
        kilometros = km;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public String toString(){
        return "Matricula: " + getMatricula() + "\n" +
                "Modelo: " + getModelo() + "\n" +
                "Color: " + getColor() + "\n" +
                "Ano: " + getAno() + "\n" +
                "Kilometros: " + getKilometros();
    }
}
