import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JSpinner spiTrack;
    private JTextField txtPeso;
    private JComboBox cboOrigen;
    private JComboBox cboDestino;
    private JTextField txtReceptor;
    private JButton btnRegistrar;
    private JSpinner spiNumero;
    private JButton btnNumero;
    private JButton btnListar;
    private JTextArea txtListar;
    private Agencia norte=new Agencia();
    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int track=Integer.parseInt(spiTrack.getValue().toString());
                float peso=Float.parseFloat(txtPeso.getText());
                String origen=cboOrigen.getSelectedItem().toString();
                String destino=cboDestino.getSelectedItem().toString();
                String receptor=txtReceptor.getText();
                Paquete p=new Paquete(track,
                        peso,
                        origen,
                        destino,
                        receptor);
                if(norte.agregar(p)==false){
                    JOptionPane.showMessageDialog(
                            null,
                            "Revise el numTrack debe ser unico y ordenado");
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Paquete registrado");
                }
            }
        });
        btnNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numero=Integer.parseInt(spiNumero.getValue().toString());
                int indice=norte.buscarBinario(numero);
                if(indice!=-1){
                    txtListar.setText(norte.getValor(indice).toString());
                }else{
                    JOptionPane.showMessageDialog(null,
                            "No existe");
                }
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListar.setText(norte.listar());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
