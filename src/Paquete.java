public class Paquete
{
    private int numeroTrack;
    private float peso;
    private String destino;
    private String origen;
    private String receptor;
    private String estado;

    public Paquete(int numeroTrack, float peso, String destino, String origen, String receptor) {
        this.numeroTrack = numeroTrack;
        this.peso = peso;
        this.destino = destino;
        this.origen = origen;
        this.receptor = receptor;
        estado= "Receptado";
    }
    public void setEstado(String estado)
    {
        this.estado= estado;
    }

    public int getNumeroTrack()
    {
        return numeroTrack;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "numeroTrack=" + numeroTrack +
                ", peso=" + peso +
                ", destino='" + destino +
                ", origen='" + origen +
                ", receptor='" + receptor +
                ", estado='" + estado + "\n";

    }
}
