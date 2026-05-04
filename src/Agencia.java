import java.util.ArrayList;

public class Agencia
{
    private ArrayList<Paquete> agencia;

    public Agencia()
    {
        agencia=new ArrayList<>();
    }

    public Paquete getValor(int indice)
    {
        return agencia.get(indice);
    }

    public boolean agregar(Paquete paquete)
    {
        if (agencia.isEmpty())
        {
            agencia.add(paquete);
            return true;
        } else
        {
            if (paquete.getNumeroTrack()> agencia.getLast().getNumeroTrack())
            {
                agencia.add(paquete);
                return  true;
            }
            return false;
        }
    }

    public int buscarBinario(int numTrack)
    {
        if(numTrack<agencia.getFirst().getNumeroTrack()||
                numTrack>agencia.getLast().getNumeroTrack()) {
            return -1;
        }
        int inf=0;
        int sup=agencia.size()-1;
        int centro=0;
        while (inf<=sup)
        {
            centro=(inf+sup)/2;
            if (numTrack == agencia.get(centro).getNumeroTrack())
            {
                return  centro;
            }else if (numTrack<agencia.get(centro).getNumeroTrack())
            {
                sup=centro-1;

            }else
            {
                inf=centro+1;
            }

        }
        return -1;
    }

    public String listar ()
    {
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < agencia.size(); i++) {
            sb.append(agencia.get(i).toString());
        }
        return agencia.size()!=0?sb.toString(): "No hay elementos";
        }
}
