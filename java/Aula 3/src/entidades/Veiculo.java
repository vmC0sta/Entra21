package entidades;

public class Veiculo {
    protected String marca;

    public Veiculo(){

    }

    public Veiculo(String marca){
        this.marca = marca;
    }

    public void honk(){
        System.out.println("honk do veículo");
    }

}